package org.example.designPatterns.structural.composite;

/**
 * Leaf（叶子节点），文件
 */
public class File implements FileSystem{
    //文件名
    private String name;
    public File(String name) {
        this.name = name;
    }

    @Override
    public void display() {
        System.out.println("File: " + name);
    }
}
