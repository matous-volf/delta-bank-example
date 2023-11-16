package org.delta.bank.observer;

public interface Observer {
    public void update();
    public void setSubject(Subject subject);
}
