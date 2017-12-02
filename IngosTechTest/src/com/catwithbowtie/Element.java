package com.catwithbowtie;

public class Element {
    static public enum Type {operator, var, bracket};
    public String value;
    public Type type;

    public Element(String value) {
        this.value = value;
        if ((value.equals("(")) || (value.equals(")"))){
            type = Type.bracket;
        } else if ((value.equals("+")) || (value.equals("-")) || (value.equals("*")) || (value.equals("/"))) {
            type = Type.operator;
        } else {
            type = Type.var;
        }
    }

    public Element(char value) {
        this(String.valueOf(value));
    }

    static public boolean ejCond(Element el1, Element el2) {
        if (el1.type != Type.operator)
            return false;
        if ((el2.value.equals("+")) || (el2.value.equals("-"))) {
            return true;
        } else if ((el1.value.equals("*")) || (el1.value.equals("/"))) {
            return true;
        }
        return false;
    }

}
