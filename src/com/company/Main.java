package com.company;

public class Main {

    public static void main(String[] args) {
        Stack stack = new Stack(2);
        stack.push("Haha");
        stack.push("heiheihei");
        stack.push("lalalalal");
        System.out.println(stack.peek("Haha"));
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
