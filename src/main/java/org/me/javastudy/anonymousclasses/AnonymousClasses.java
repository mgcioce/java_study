package org.me.javastudy.anonymousclasses;

public class AnonymousClasses {
    public static void main(String[] args) {
        System.out.println("exploring anonymous classes");

        //1) A regular class using an overridden method to create an anonymous class instance
        System.out.println("1) regular class with overridden method definition");
        NormalClass normalClassInstance = new NormalClass("og definition");
        System.out.println(normalClassInstance.normalMethod());
        NormalClass anonClassOne = new NormalClass("anonymous!"){
            @Override
            public String normalMethod(){
                System.out.println("anonymous class definition");
                return getStringField();
            }
        };
        System.out.println(anonClassOne.normalMethod());

        //2)An abstract class (without an abstract method) can create an "anonymous" class instance
        System.out.println("2) Abstract class without abstract method");
        AbstractClass anonClassTwo = new AbstractClass("anonymous! (cheating here :P)") {}; // no actual definition needed! empty curly braces hack!
        anonClassTwo.nonAbstractMethod();

        //3)An abstract class with an abstract method uses method implementation to create an anonymous class instance
        System.out.println("3) Abstract class with abstract method");
        AbstractClassWithAbstractMethod classWithAbstractMethod = new AbstractClassWithAbstractMethod("anonymous!") {
            @Override
            public void abstractMethod() {
                System.out.println("just implemented this abstract method bro");
                System.out.println(getStringField());
            }
        };
        classWithAbstractMethod.abstractMethod();

        //4) creating an anonymous class instance via an interface definition
        System.out.println("4) Anonymous Classes using interface definitions");
        RegularInterface interfaceInstance = new RegularInterface() {
            @Override
            public void interfaceMethod(String message) {
                System.out.println("This definition only exists here unless specifically duplicated in the code!");
                System.out.println(message);
            }
        };
        interfaceInstance.interfaceMethod("anonymous!");
        //lambda expression version of above!
        RegularInterface lambdaExpressionImplementation = (message) -> {
            System.out.println("Lambda expression definition of the same interface!");
            System.out.println(message);
        };
        lambdaExpressionImplementation.interfaceMethod("anonymous!");
    }
}