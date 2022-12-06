package org.me.javastudy.anonymousclasses;

public abstract class AbstractClass {

    private String stringField;

    public AbstractClass(String stringField) {
        this.stringField = stringField;
    }

    public void nonAbstractMethod() {
        System.out.println("og method definition");
        System.out.println(getStringField());
    }

    public String getStringField() {
        return stringField;
    }

    public void setStringField(String stringField) {
        this.stringField = stringField;
    }
}
