package org.example.designPatterns.behavioral.iterator.standard;

/**
 * 有没有下一个，以及具体的下一个Object
 */
public interface Iterator {
    boolean hasNext();
    Object next();
}
