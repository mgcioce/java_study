package org.me.javastudy.anonymousclasses;

public class LambdaExpressions {

    private String stringField;
    private final String FINAL = "FINAL can't be reassigned";

    public LambdaExpressions(String stringField) {
        this.stringField = stringField;
    }

    public void example(){
        RegularInterface regularInterface = (message) -> System.out.println("here's my one line version: " + message);
        regularInterface.interfaceMethod("see?");
        regularInterface = message -> {
            System.out.println("This has more than one line so it needs curly braces");
            System.out.println("I can also access the enclosing class members: " + getStringField());
            setStringField("changing it up bro");
            System.out.println(getStringField());
            System.out.println("but only final field directly: " + FINAL);
        };
        regularInterface.interfaceMethod(null);
    }
    public String getStringField() {
        return stringField;
    }

    public void setStringField(String stringField) {
        this.stringField = stringField;
    }


    public static void main(String[] args) {
        LambdaExpressions lambdaExpressions = new LambdaExpressions("lambda bro");
        lambdaExpressions.example();
    }


}
