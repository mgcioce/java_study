package org.me.javastudy.inheritence;

public class ParentClass {

    private String notInherited;
    protected String inherited;

    public String getNotInherited() {
        return notInherited;
    }

    public void setNotInherited(String notInherited) {
        this.notInherited = notInherited;
    }

    public String getInherited() {
        return inherited;
    }

    public void setInherited(String inherited) {
        this.inherited = inherited;
    }
}
