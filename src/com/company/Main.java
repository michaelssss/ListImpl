package com.company;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> list = new MyArrayList<>(2);
        list.add("A");
        list.add("B");
        list.add("C");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
