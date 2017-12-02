package com.catwithbowtie;

public class CalcString {
    public String string;

    public CalcString() {
        string = "";
    }

    public CalcString(String string) {
        this.string = string;
    }

    public CalcString add(CalcString other) {
        CalcString newCS = new CalcString();
        newCS.string = string + other.string;
        return newCS;
    }

    public CalcString sub(CalcString other) {
        CalcString newCS = new CalcString();
        newCS.string = string;
        if (newCS.string.substring(newCS.string.length() - other.string.length()).equals(other.string)) {
            newCS.string = newCS.string.substring(0, newCS.string.length() - other.string.length());
        }
        return newCS;
    }

    public CalcString mul(CalcString other) {
        CalcString newCS = new CalcString();
        for(int i = 0; (i < length()); i++) {
            newCS.string += string.charAt(i);
            if(i < other.length())
                newCS.string += other.string.charAt(i);
        }
        if (length() < other.length())
            for(int i = length(); (i < other.length()); i++)
                newCS.string += other.string.charAt(i);
        return newCS;
    }

    public CalcString div(CalcString other) {
        CalcString newCS = new CalcString();
        for (int i = 0, j = 0; i < length(); i++) {
            if (i % 2 != 0) {
                if (j < other.length()) {
                    if (string.charAt(i) != other.string.charAt(j))
                        newCS.string += string.charAt(i);
                    j++;
                } else {
                    newCS.string += string.charAt(i);
                }
            } else {
                newCS.string += string.charAt(i);
            }
        }
        return newCS;
    }


    public int length() {
        return string.length();
    }
}
