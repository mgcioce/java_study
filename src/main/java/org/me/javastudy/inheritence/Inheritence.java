package org.me.javastudy.inheritence;

public class Inheritence {

    public static void main(String[] args) {
        Inheritence i = new Inheritence();
        i.examples();
    }

    public void examples(){
        System.out.println("In java, inheritence describes the object oriented feature that enables subclasses to be created from parent classes");
        System.out.println("Using the extends keyword, we can define a subclass that can inherit fields and methods from its parent class");
        System.out.println("For example: ");
        ParentClass parent = new ParentClass();
        parent.setInherited("I inherit this text");
        parent.setNotInherited("I don't have direct access to this field as a child");
        ChildClass child = new ChildClass(parent);
        System.out.println("Trying to access the parent classes field that wasn't inherited results in a compile time error");
        //System.out.println(child.notInherited);
        System.out.println("However, the child inherited the public methods of it's parent class in order to still have access");
        System.out.println(child.getNotInherited());
        System.out.println("NOTE: if both classes are defined in the same scope then it is possible for the child class to still access the private field of the parent class directly");
        System.out.println("And here's a field and methods new to the child class NOT in the parent class");
        child.setChildOnlyField("This string is only in the Child class");
        System.out.println(child.getChildOnlyField());
    }

}
