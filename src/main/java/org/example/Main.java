package org.example;

public class Main {
    public static void main(String[] args) {
        StringProcessor processor = new StringProcessor();
        String password = "adilet";
        System.out.println(processor.isStrongPassword(password));
        String sentence = "Hello, I am 19 years old.";
        System.out.println(processor.calculateDigits(sentence));
        String sentence2 = "Hello, World and Java";
        System.out.println(processor.calculateWords(sentence2));
        String expression = "1 + 5 * (5 - 2)";
        System.out.println(processor.calculateExpression(expression));
    }
}