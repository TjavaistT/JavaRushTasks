package com.javarush.task.task37.task3701;

import java.util.ArrayList;
import java.util.Iterator;

/* 
Круговой итератор
*/
public class Solution<T> extends ArrayList<T> {
    public static void main(String[] args) {
        Solution<Integer> list = new Solution<>();
        list.add(1);
        list.add(2);
        list.add(3);

        int count = 0;
        for (Integer i : list) {
            //1 2 3 1 2 3 1 2 3 1
            System.out.print(i + " ");
            count++;
            if (count == 10) {
                break;
            }
        }
    }

    //В каждом классе коллекции есть итератор по умолчанию - достаточно его перепределить
    // и можно явно не вызывать - он сам скрыто задействуется через цикл foreach - for(:){}
    @Override
    public Iterator<T> iterator() {
        return new RoundIterator();
    }

    public class RoundIterator implements Iterator<T> {
        Iterator<T> iterator = Solution.super.iterator();
        int cursor = 0;

        @Override
        public boolean hasNext() {
            return size() > 0;
        }

        @Override
        public T next() {
            cursor++;
            if(cursor > size()){
                iterator = Solution.super.iterator();
                cursor = 1;
            }
            return iterator.next();
        }

        @Override
        public void remove() {
            iterator.remove();
        }
    }
}
