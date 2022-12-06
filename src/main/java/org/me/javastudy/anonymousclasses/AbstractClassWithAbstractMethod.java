package org.me.javastudy.anonymousclasses;

public abstract class AbstractClassWithAbstractMethod {

    private String stringField;

    public AbstractClassWithAbstractMethod(String stringField) {
        this.stringField = stringField;
    }

    public abstract void abstractMethod();

    public String getStringField() {
        return stringField;
    }

    public void setStringField(String stringField) {
        this.stringField = stringField;
    }
}
