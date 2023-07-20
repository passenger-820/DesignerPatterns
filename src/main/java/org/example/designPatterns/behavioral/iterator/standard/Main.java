package org.example.designPatterns.behavioral.iterator.standard;

public class Main {
    public static void main(String[] args) {
        int[] values = {1, 2, 3, 4, 5};
        IntArray intArray = new IntArray(values);

        Iterator iterator = intArray.iterator();
        while (iterator.hasNext()) {
            int value = (int) iterator.next();
            System.out.println(value);
        }
    }
}
