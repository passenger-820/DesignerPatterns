package org.example.designPatterns.behavioral.iterator.innerClass;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{2,1,3,1,6,5,9};
        IntArray intArray = new IntArray(nums);

        // 使用迭代器进行迭代
        Iterator iterator = intArray.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
