package com.catwithbowtie;

import java.util.Scanner;

public class Main {
    static public void main(String[] args) {
        System.out.println("Введите выражение : ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(input + " = " + Dejkstra.calculate(Parser.parse(input)).string);
    }
}
