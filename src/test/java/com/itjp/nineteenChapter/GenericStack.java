package com.itjp.nineteenChapter;

import java.util.ArrayList;

/**
 * 泛型类
 *
 * @author wangzi
 * @date 18/2/3 上午1:14.
 */
public class GenericStack<E> {
    private ArrayList<E> arrayList;

    public GenericStack() {
        this.arrayList = new ArrayList<E>();
    }

    public E pop() {
        int size = arrayList.size();
        E obj = arrayList.get(size - 1);
        arrayList.remove(size - 1);
        return obj;
    }

    public void push(E obj) {
        arrayList.add(obj);
    }

    public int size() {
        return arrayList.size();
    }

    public E peek() {
        int size = arrayList.size();
        return arrayList.get(size - 1);
    }

    @Override
    public String toString() {
        return "GenericStack{" +
                "arrayList=" + arrayList +
                '}';
    }

}
