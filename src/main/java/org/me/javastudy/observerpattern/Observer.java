package org.me.javastudy.observerpattern;

public interface Observer {

    //include a collection of Subjects for any implementing class

    /*
    This update method should find the matching subject that is calling the update method
    in order to execute a specific set of logic, i.e. each subject an observer follow shoiuld have
    a corresponding update method written specifically for when that suject's inernal state changes
     */
    public void update(Subject subject);

}
