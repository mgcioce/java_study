package org.me.javastudy.inheritence;

public class ChildClass extends ParentClass{

    private String childOnlyField;

    public ChildClass(ParentClass parent) {
        super();
        this.setInherited(parent.getInherited());
        this.setNotInherited(parent.getNotInherited());
    }

    public String getChildOnlyField() {
        return childOnlyField;
    }

    public void setChildOnlyField(String childOnlyField) {
        this.childOnlyField = childOnlyField;
    }

    public String illegalAccess() {
        //compile time error
        //return super.notInherited;
        return null;
    }
}
