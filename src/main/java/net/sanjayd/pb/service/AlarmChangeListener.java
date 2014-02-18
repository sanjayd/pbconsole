package net.sanjayd.pb.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.async.DeferredResult;

public class AlarmChangeListener extends DeferredResult<ResponseEntity<String>> {

    private boolean alertWhen;

    public AlarmChangeListener(boolean alertWhen) {
        super();
        this.alertWhen = alertWhen;
        this.onTimeout(new Runnable() {
            @Override
            public void run() {
                setResult(new ResponseEntity<String>("timeout", HttpStatus.NO_CONTENT));
            }
        });
    }

    public void alert() {
        setResult(new ResponseEntity<String>("" + alertWhen, HttpStatus.OK));
    }
}
