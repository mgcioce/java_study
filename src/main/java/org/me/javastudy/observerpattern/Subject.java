package org.me.javastudy.observerpattern;

public interface Subject {

    //any implementing class should define :
    // 1) a collection of Observers that are subscribed to the subject instance
    // 2) a private method for calling the update() method of the observers when the internal state of the subject changes

    public void subscribe(Observer observer);
    public void unsubscribe(Observer observer);
}
