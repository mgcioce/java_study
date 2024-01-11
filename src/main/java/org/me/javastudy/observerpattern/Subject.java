package org.me.javastudy.observerpattern;

import java.util.Observer;

public interface Subject {

    public default void subscribe(Observer observer) {
        
    }
    public default void unsubscribe(Observer observer) {

    }
}
