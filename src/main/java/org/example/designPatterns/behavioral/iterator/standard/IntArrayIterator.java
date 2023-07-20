package org.example.designPatterns.behavioral.iterator.standard;

public class IntArrayIterator implements Iterator {
    private IntArray intArray;
    private int index;

    public IntArrayIterator(IntArray intArray) {
        this.intArray = intArray;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < intArray.getLength();
    }

    @Override
    public Object next() {
        int value = intArray.getValueAt(index);
        index++;
        return value;
    }
}
