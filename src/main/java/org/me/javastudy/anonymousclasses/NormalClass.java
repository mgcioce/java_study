package org.me.javastudy.anonymousclasses;

public class NormalClass {

    private String stringField;

    public NormalClass(String stringField) {
        this.stringField = stringField;
    }

    public String normalMethod() {
        System.out.println("og class definition");
        return stringField;
    }

    public String getStringField() {
        return stringField;
    }

    public void setStringField(String stringField) {
        this.stringField = stringField;
    }

}
