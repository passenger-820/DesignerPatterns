package org.example.designPatterns.structural.composite;

public class Client {
    public static void main(String[] args) {
        FileSystem file1 = new File("1.txt");
        FileSystem file2 = new File("2.txt");
        Folder folder1 = new Folder("folder_one");
        Folder folder2 = new Folder("folder_two");
        folder1.add(file1);
        folder1.add(file2);
        folder1.add(folder2);
        folder2.add(file2);
        folder1.display();
    }
}
