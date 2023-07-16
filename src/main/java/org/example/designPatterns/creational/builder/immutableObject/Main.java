package org.example.designPatterns.creational.builder.immutableObject;

public class Main {
    public static void main(String[] args) {
        ImmutablePerson.Builder builder = new ImmutablePerson.Builder();
        ImmutablePerson immutablePerson = builder.setAge(1).setName("a").setAddress("china").build();
        System.out.println("immutablePerson = " + immutablePerson.toString());
    }
}
