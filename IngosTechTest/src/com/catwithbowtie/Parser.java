package com.catwithbowtie;

import java.util.ArrayList;

public class Parser {
    static public ArrayList<Element> parse(String to_parse) {
        ArrayList<Element> els = new ArrayList<Element>();
        String curVar = "";
        to_parse += " ";
        for (int i = 0; i < to_parse.length(); i++) {
            if (isOperator(to_parse.charAt(i))) {
                if (curVar != "") {
                    els.add(new Element(curVar));
                    curVar = "";
                }
                els.add(new Element(to_parse.charAt(i)));
            } else if (to_parse.charAt(i) == ' ') {
                if (curVar != "") {
                    els.add(new Element(curVar));
                    curVar = "";
                }
            } else {
                curVar += to_parse.charAt(i);
            }
        }
        return els;
    }



    static private boolean isOperator(char sym) {
        switch(sym) {
            case '(':
            case ')':
            case '*':
            case '/':
            case '-':
            case '+':
                return true;
        }
        return false;
    }
}
