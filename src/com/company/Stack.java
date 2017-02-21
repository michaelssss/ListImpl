package com.company;

/**
 * Created by michaelssss on 2017/2/19.
 */
public class Stack {
    private Object[] objects;
    private int index;
    private int size;

    public Stack() {
        this(16);
    }

    public Stack(int size) {
        this.objects = new Object[size];
        this.index = -1;
        this.size = 0;
    }

    public Object pop() {
        size--;
        return objects[index--];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(Object o) {
        size++;
        ensureCapcity();
        objects[++index] = o;
    }

    private void ensureCapcity() {
        if (index == this.objects.length - 1) {
            Object[] objects = new Object[this.objects.length * 2];
            System.arraycopy(this.objects, 0, objects, 0, size - 1);
            this.objects = objects;
        }
    }

    public Object peek(Object o) {
        for (int index = 0; index < size; index++) {
            if (this.objects[index].equals(o)) {
                return this.objects[index];
            }
        }
        return null;
    }
}
