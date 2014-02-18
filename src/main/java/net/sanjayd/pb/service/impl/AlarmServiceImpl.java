package net.sanjayd.pb.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import net.sanjayd.pb.service.AlarmChangeListener;
import net.sanjayd.pb.service.AlarmService;

import org.apache.log4j.Logger;

public class AlarmServiceImpl implements AlarmService {

    private static final Logger logger = Logger.getLogger(AlarmServiceImpl.class);

    private ReadWriteLock lock;

    private boolean armed;

    private List<AlarmChangeListener> listeners;

    public AlarmServiceImpl() {
        this.lock = new ReentrantReadWriteLock();
        this.armed = false;
        this.listeners = Collections.synchronizedList(new ArrayList<AlarmChangeListener>());
    }

    @Override
    public boolean switchTo(Boolean armed) {
        lock.writeLock().lock();
        try {
            if (this.armed == armed) {
                return this.armed;
            } else {
                this.armed = armed;
                logger.info((this.armed ? "Arming" : "Disarming") + " alarm");
                for(AlarmChangeListener listener: listeners) {
                    listener.alert();
                }
                return this.armed;
            }
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public boolean isArmed() {
        lock.readLock().lock();
        try {
            return this.armed;
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public AlarmChangeListener isArmed(Boolean alertWhen) {
        lock.readLock().lock();
        try {
            if (alertWhen != null && alertWhen != armed) {
                AlarmChangeListener listener = new AlarmChangeListener(alertWhen);
                this.listeners.add(listener);
                return listener;
            } else {
                AlarmChangeListener listener = new AlarmChangeListener(armed);
                listener.alert();
                return listener;
            }
        } finally {
            lock.readLock().unlock();
        }
    }
}
