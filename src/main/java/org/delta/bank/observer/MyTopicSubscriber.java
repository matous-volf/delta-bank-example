package org.delta.bank.observer;

public class MyTopicSubscriber implements Observer {
    private String name;
    private Subject topic;

    public MyTopicSubscriber(String name) {
        this.name = name;
    }

    public void update() {
        String message = (String) topic.getUpdate(this);

        if (message == null) {
            System.out.println(name + ": No new message");
        } else {
            System.out.println(name + ": Consuming message: " + message);
        }
    }

    public void setSubject(Subject subject) {
        topic = subject;
    }
}
