package org.example.designPatterns.behavioral.iterator.standard;

public class IntArray implements Aggregate {
    private int[] values;

    public IntArray(int[] values) {
        this.values = values;
    }

    public int getValueAt(int index) {
        return values[index];
    }

    public int getLength() {
        return values.length;
    }

    @Override
    public Iterator iterator() {
        return new IntArrayIterator(this);
    }
}
