package com.catwithbowtie;

import java.util.ArrayList;
import java.util.Stack;

public class Dejkstra {
    static private ArrayList<Element> convertToRPE(ArrayList<Element> els) {
        Stack<Element> st = new Stack<Element>();
        ArrayList<Element> res = new ArrayList<Element>();
        for (int i = 0; i < els.size(); i++) {
            Element el = els.get(i);
            if (el.type == Element.Type.var) {
                res.add(el);
            } else if (el.value.equals("(")) {
                st.add(el);
            } else if (el.value.equals(")")) {
                while((st.size() > 0) && (!st.peek().value.equals("("))) {
                    res.add(st.pop());
                }
                if (st.size() > 0)
                    st.pop();

            } else if (el.type == Element.Type.operator){
                while ((st.size() > 0) && (Element.ejCond(st.peek(), el)))
                    res.add(st.pop());
                st.add(el);
            }
        }
        while (st.size() > 0)
            res.add(st.pop());
        return res;
    }

    static public CalcString calculate(ArrayList<Element> els) {
        els = convertToRPE(els);
        Stack<Element> st = new Stack<Element>();
        for (Element el : els) {
            if (el.type == Element.Type.var) {
                st.add(el);
            } else if (el.type == Element.Type.operator) {
                CalcString second = new CalcString(st.pop().value);
                CalcString first = new CalcString(st.pop().value);
                switch(el.value){
                    case "+":
                        first = first.add(second);
                        break;
                    case "-":
                        first = first.sub(second);
                        break;
                    case "/":
                        first = first.div(second);
                        break;
                    case "*":
                        first = first.mul(second);
                        break;
                }
                st.add(new Element(first.string));
            }
        }
        return new CalcString(st.pop().value);
    }
}
