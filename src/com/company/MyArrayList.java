package com.company;

import java.util.*;

/**
 * Created by michaelssss on 2017/2/15.
 */
public class MyArrayList<T> implements List<T> {
    private Object[] objects;

    private int size;

    public MyArrayList(int size) {
        this.objects = new Object[size];
        this.size = 0;
    }

    public MyArrayList() {
        this(16);
    }

    @Override

    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (Object t : objects) {
            if (t.equals(o)) return true;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(objects, objects.length);
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return (T1[]) this.toArray();
    }

    private void increaseCapacipy() {
        Object[] objects = new Object[this.objects.length * 2];
        System.arraycopy(this.objects, 0, objects, 0, this.objects.length);
        this.objects = objects;
    }

    private boolean isFull() {
        return size() == objects.length - 1;
    }

    @Override
    public boolean add(T t) {
        if (isFull()) {
            increaseCapacipy();
        }
        objects[size] = t;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (indexOf(o) == -1) {
            return false;
        }
        remove(indexOf(o));
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        this.objects = new Object[16];
    }

    @Override
    public T get(int index) {
        return (T) this.objects[index];
    }

    @Override
    public T set(int index, T element) {
        this.objects[index] = element;
        return element;
    }

    @Override
    public void add(int index, T element) {
        Object[] objects = new Object[size + 1];
        System.arraycopy(this.objects, 0, objects, 0, index - 1);
        objects[index] = element;
        System.arraycopy(this.objects, 0, objects, 0, size - index - 1);
        this.objects = objects;
    }

    @Override
    public T remove(int index) {
        Object[] objects = new Object[size - 1];
        System.arraycopy(this.objects, 0, objects, 0, index - 1);
        System.arraycopy(this.objects, index + 1, objects, index - 1, size - index - 1);
        T t = get(index);
        this.objects = objects;
        return t;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (this.objects[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (this.objects[i].equals(o)) {
                index = i;
            }
        }
        return index;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}
