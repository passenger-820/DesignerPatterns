package org.example.designPatterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Composite（组合节点），文件夹
 * 可以有文件夹和文件
 */
public class Folder implements FileSystem{
    //文件夹的名称
    private String name;
    //文件或子文件夹
    private List<FileSystem> children;
    public Folder(String name){
        this.name = name;
        this.children = new ArrayList<>();
    }

    public void add(FileSystem fileSystem){
        children.add(fileSystem);
    }

    public void remove(FileSystem fileSystem){
        children.remove(fileSystem);
    }
    @Override
    public void display() {
        //展示自己的名字
        System.out.println("Folder: " + name);
        for (FileSystem child : children) {
            //及子文件夹和文件的名字，递归内层也展示出来
            //文件夹会展示子文件夹和文件名，文件会展示文件名
            System.out.println(name + "文件夹下");
            child.display();
        }
    }
}
