package com.sean.学习.数组.test;

public abstract class AbstractList<E> implements List<E> {

    protected int size;

    @Override
    public void add(E element) {
        add(size, element);
    }

    @Override
    public void remove(E element) {
        remove(indexOf(element));
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return 0 == size;
    }

    @Override
    public boolean contains(E element) {
        return ELEMENT_NOT_FOUND != indexOf(element);
    }

    //判断数组下标是否越界
    protected void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("size=" + size + ",index=" + index);
        }
    }

    //判断数组下标是否越界
    protected void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("size=" + size + ",index=" + index);
        }
    }

}

