package com.sean.学习.数组.test;

/**
 * ArrayList_optimize
 *
 * @author chenxu
 * @summary ArrayList_optimize
 * @since 2020-08-14 23:38
 */
public class ArrayList_optimize<E> extends AbstractList<E> {

    //元素数组
    private E[] elements;

    //首元素下标
    private int first = -1;

    //尾元素下标
    private int last = -1;

    private static final int DEFAULT_CAPACITY = 10;//2;

    public ArrayList_optimize() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayList_optimize(int initCapacity) {
        elements = (E[]) (initCapacity > DEFAULT_CAPACITY ?
                new Object[initCapacity] : new Object[DEFAULT_CAPACITY]);
    }

    //add(int index, Object e) 在某一位置添加元素
    public void add(int index, E element) {
        rangeCheckForAdd(index);

        ensureCapacity(size + 1);

        int maxIndex = elements.length - 1;

        if (size == 0) {
            first++;
            last++;
            elements[first] = element;
        } else if (index == 0) {
            first = first == 0 ? maxIndex : --first;
            elements[first] = element;
        } else if (index == size) {
            last = last == maxIndex ? 0 : ++last;
            elements[last] = element;
        } else {
            int diffIndex = index + first;
            int endIndex = diffIndex;

            if (index >= size >> 1) {
                if (last == maxIndex) elements[0] = elements[maxIndex];

                int fromIndex = last == maxIndex ? maxIndex : last + 1;
                if (diffIndex > maxIndex) endIndex = diffIndex - elements.length;
                else if (first > last) endIndex = 0;

                for (int i = fromIndex; i > endIndex; i--) {
                    elements[i] = elements[i - 1];
                }

                if (first > last && diffIndex <= maxIndex) {
                    elements[0] = elements[maxIndex];
                    endIndex = diffIndex == maxIndex ? maxIndex : diffIndex + 1;
                    for (int i = maxIndex; i > endIndex; i--) {
                        elements[i] = elements[i - 1];
                    }
                }

                last = last == maxIndex ? 0 : ++last;
            } else {
                endIndex = --diffIndex;
                if (first == 0) elements[maxIndex] = elements[0];

                int fromIndex = first == 0 ? 0 : first - 1;

                if (diffIndex > maxIndex)  endIndex = maxIndex;

                for (int i = fromIndex; i < endIndex; i++) {
                    elements[i] = elements[i + 1];
                }

                if (diffIndex > maxIndex) {
                    elements[maxIndex] = elements[0];
                    endIndex = diffIndex - elements.length;
                    for (int i = 0; i < endIndex; i++) {
                        elements[i] = elements[i + 1];
                    }
                }
                first = first == 0 ? maxIndex : --first;
            }
            elements[endIndex] = element;
        }
        size++;
    }

    @Override
    public void remove(E element) {
        int realIndex = indexOf(element);
        if (ELEMENT_NOT_FOUND == realIndex) return;
        remove(realIndex >= first ? realIndex - first : elements.length - first + realIndex);
    }

    //remove(int index) 移除某一位置元素，返回移除的元素
    public E remove(int index) {
        rangeCheck(index);

        int realIndex = size == 1 ? first : getRealIndex(index);
        E oldElement = elements[realIndex];

        if (size == 1) {
            elements[first] = null;
            first = -1;
            last = -1;
        } else {
            int maxIndex = elements.length - 1;
            if (index >= size >> 1) {

                int endIndex = realIndex > last ? maxIndex : last;
                for (int i = realIndex; i < endIndex; i++) {
                    elements[i] = elements[i + 1];
                }

                if (realIndex > last) {
                    elements[maxIndex] = elements[0];
                    for (int i = 0; i < last; i++) {
                        elements[i] = elements[i + 1];
                    }
                }
                elements[last] = null;

                last = last == 0 ? maxIndex : --last;
            } else {

                int endIndex = realIndex < first ? 0 : first;
                for (int i = realIndex; i > endIndex; i--) {
                    elements[i] = elements[i - 1];
                }

                if (realIndex < first) {
                    elements[0] = elements[maxIndex];
                    for (int i = maxIndex; i > first; i--) {
                        elements[i] = elements[i - 1];
                    }
                }
                elements[first] = null;

                first = first == maxIndex ? 0 : ++first;
            }
        }

        size--;
        trim();
        return oldElement;
    }

    //clear() 清空数组
    public void clear() {
        int fromIndex = first;
        if (first > last) {
            for (int i = fromIndex; i < elements.length; i++) {
                elements[i] = null;
            }
            fromIndex = 0;
        }
        for (int i = fromIndex; i <= last; i++) {
            elements[i] = null;
        }

        if (null != elements && elements.length > DEFAULT_CAPACITY) elements = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
        first = -1;
        last = -1;
    }

    //set(int index, Object e) 设置某一位置元素为e，返回原元素
    public E set(int index, E element) {
        rangeCheck(index);

        index = getRealIndex(index);
        E oldElement = elements[index];
        elements[index] = element;
        return oldElement;
    }

    //indexOf(Object e) 获取某一元素位置
    public int indexOf(E element) {
        int fromIndex = first;
        if (null == element) {
            if (first > last) {
                for (int i = first; i < elements.length; i++) {
                    if (null == elements[i]) {
                        return i;
                    }
                }
                fromIndex = 0;
            }

            for (int i = fromIndex; i <= last; i++) {
                if (null == elements[i]) {
                    return i;
                }
            }

        } else {
            if (first > last) {
                for (int i = first; i < elements.length; i++) {
                    if (element.equals(elements[i])) {
                        return i;
                    }
                }
                fromIndex = 0;
            }

            for (int i = fromIndex; i <= last; i++) {
                if (element.equals(elements[i])) {
                    return i;
                }
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    //get(int index) 获取某一位置元素
    public E get(int index) {
        rangeCheck(index);

        return elements[getRealIndex(index)];
    }

    //数组扩容
    private void ensureCapacity(int newCapacity) {

        int oldCapacity = elements.length;
        if (oldCapacity >= newCapacity) return;

        //新容量为旧容量的1.5倍
        newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];

        int index = first > last ? oldCapacity - first : size;
        for (int i = 0; i < index; i++) {
            newElements[i] = elements[first + i];
        }

        if (first > last) {
            for (int i = index; i < size; i++) {
                newElements[i] = elements[i - index];
            }
        }

        elements = newElements;
        first = 0;
        last = size - 1;
        System.out.println(oldCapacity + "扩容为" + newCapacity);
    }

    //数组缩容
    private void trim() {
        int oldCapacity = elements.length;
        int newCapacity = oldCapacity >> 1;
        if (size >= newCapacity || newCapacity < DEFAULT_CAPACITY) return;

        E[] newElements = (E[]) new Object[newCapacity];
        int index = first > last ? oldCapacity - first : size;
        for (int i = 0; i < index; i++) {
            newElements[i] = elements[first + i];
        }

        if (first > last) {
            for (int i = index; i < size; i++) {
                newElements[i] = elements[i - index];
            }
        }

        elements = newElements;
        first = 0;
        last = size - 1;
        System.out.println(oldCapacity + "缩容为" + newCapacity);
    }

    //获取实际下标
    private int getRealIndex(int index) {
        index = first + index;
        if (index >= elements.length) index = index - elements.length;
        return index;
    }

    @Override
    public String toString() {

        if (size == 0) return "size=0,first=-1,last=-1,arrayList_optimize=[]";

        StringBuilder stringBuilder = new StringBuilder();

        int fromIndex = first;
        if (first > last) {
            for (int i = first; i < elements.length; i++) {
                if (i != first) {
                    stringBuilder.append(",");
                }
                stringBuilder.append(elements[i]);
            }
            fromIndex = 0;
        }

        for (int i = fromIndex; i <= last; i++) {
            if (i != first) {
                stringBuilder.append(",");
            }
            stringBuilder.append(elements[i]);
        }

        return "size=" + size() + ",first=" + first + ",last=" + last + ",arrayList_optimize=[" + stringBuilder + "]";
    }
}
