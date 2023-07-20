package org.example.designPatterns.behavioral.iterator.innerClass;

/**
 * 有没有下一个，以及具体的下一个int
 */
public interface Iterator {
    boolean hasNext();
    int next();
}
