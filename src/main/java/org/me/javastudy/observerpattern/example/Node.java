package org.me.javastudy.observerpattern.example;

import org.me.javastudy.observerpattern.Observer;

import java.util.List;

public abstract class Node {

    private List<Observer> observerList;
}
