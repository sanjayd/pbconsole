package net.sanjayd.pb.service;

public interface AlarmService {

    public boolean switchTo(Boolean armed);
    public boolean isArmed();
    public AlarmChangeListener isArmed(Boolean alertWhen);

}
