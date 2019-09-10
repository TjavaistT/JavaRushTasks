package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/* 
Построй дерево
*/
public class CustomTree extends AbstractList<String> implements Serializable, Cloneable {

    Entry<String> root;

    Entry[] elements = new Entry[1];

    //по условию дерево создается сразу с корнем
    public CustomTree() {
        root = new Entry<>("root");
        root.parent = null;
        elements[0] = root;
    }

    // методы открытого интерфейса add, remove, getParent
    // ини включают все прочие методы, т.е. отображают логику задачм,
    // только они используются в тестах
    /**
     *  добавить элемент всегда в конец
     */
    @Override
    public boolean add(String newElemName) {
        int newIndex = elements.length;
        int newCountElements = newIndex + 1;
        int parentIndex = (newIndex-1)/2;

        elements = resizeElements(newCountElements, newElemName);

        return createParenChildRelatives(parentIndex, newIndex);
    }

    /*
    * стереть элемент, а также
    * востановить родителям возможность иметь детей,
    * проверить и удалить пустые ячейки для элементов из конца списка
     */
    @Override
    public boolean remove(Object elementName){
        checkStringTypeElement(elementName);

        //найти и удалить всю ветку элементов, в т.ч. дочерние элементы
        //а родителям восстановить возможность иметь детей
        boolean result = findAndDeleteBranch((String)elementName);

        //если удалены последние элементы - то откатываемся(удаляем запись в массиве) до  существующих элементов
        deleteLastEmptyElements(getIndexLastRealElement());

        return result;
    }

    //возвращает имя родителя элемента дерева, имя которого было полученного в качестве параметра.
    //если есть элименты с одинаковыми именами - то вернется самый первый
    //но такое вот условие задачи
    public String getParent(String elementName) { return elements[findElementIndex(elementName)].parent.elementName; }


    //методы закрытого интерфейса - подробности реализации, которые можно изменять при желании
    private int findElementIndex(String elementName) {
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] != null && elements[i].elementName.equals(elementName)) {
                return i;
            }
        }

        System.out.println(elementName);

        throw new RuntimeException("Индекс элемента по имени не найден");
    }

    private Entry[] resizeElements(int newCountElements, String newElemName) {
        int newIndex = newCountElements - 1;

        Entry[] newArElements = new Entry[newCountElements];

        System.arraycopy(elements, 0, newArElements, 0, newIndex);

        newArElements[newIndex] = new Entry(newElemName);

        return newArElements;
    }

    //обновить взаимосвязи родитель - ребенок
    private boolean findAndDeleteBranch(String elementName) {
        try {
            int elementIndex = findElementIndex(elementName);

            /*
             * восстановить родителю возможность иметь детей
             * эта возможность потенциальна, т.к. дети добавляются в конец
             * но важна для тех случаев когда удаляется целый уровень
             * и все элементы предыдущего уровня должны иметь возможность иметь детей
             */
            restoreParentRelatives(elements[elementIndex].parent);

            deleteElementWithChildren(elementIndex);

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    private boolean createParenChildRelatives(int parentIndex, int index) {

        Entry child = elements[index];
        Entry parent = elements[parentIndex];

        //если родитель был удален - то ребенок вставится следующему не удаленному родителю левым ребенком
        if(parent == null) {
            while (parent == null) {
                parent = elements[++parentIndex];
            }
            setLeftChild(child, parent);
        //если родитель не был удален - то потребуется решить - это левый ребено или правый
        } else {
            // связь родитель - какой-то ребенок
            //левый ребенок
            if(isLeftChild(index, parentIndex)) setLeftChild(child, parent);
            //правый ребенок
            if(isRightChild(index, parentIndex)) setRightChild(child, parent);
        }

        // связь ребенок - родитель
        child.parent = parent;

        return true;
    }

    private void checkStringTypeElement(Object curElement) {
        if(!(curElement instanceof String)) throw new UnsupportedOperationException();
    }

    @Override
    public int size() {return elements.length -1;}

    private void restoreParentRelatives(Entry parent) {
        if(parent.leftChild != null || !parent.availableToAddLeftChildren) deleteLeftChild(parent);
        if(parent.rightChild != null || !parent.availableToAddRightChildren) deleteRightChild(parent);
    }

    private void toFreeParentConnection(int childIndex) {
        int parentIndex = (childIndex-1)/2;
        if(elements[parentIndex] != null) {
            if (parentIndex * 2 + 1 == childIndex) elements[parentIndex].availableToAddLeftChildren = true;
            if (parentIndex * 2 + 2 == childIndex) elements[parentIndex].availableToAddRightChildren = true;
        }
    }

    private void setRightChild(Entry child, Entry parent) {
        parent.rightChild = child;
        parent.availableToAddRightChildren = false;
    }

    private void setLeftChild(Entry child, Entry parent) {
        parent.leftChild = child;
        parent.availableToAddLeftChildren = false;
    }

    private void deleteRightChild(Entry parent) {
        parent.rightChild = null;
        parent.availableToAddRightChildren = true;
    }

    private void deleteLeftChild(Entry parent) {
        parent.leftChild = null;
        parent.availableToAddLeftChildren = true;
    }

    private boolean isRightChild(int index, int parentIndex) {
        return (parentIndex * 2 + 2) == index;
    }

    private boolean isLeftChild(int index, int parentIndex) {
        return (parentIndex * 2 + 1) == index;
    }

    private void deleteElementWithChildren(int i) throws Exception {
        if(!elements[i].availableToAddLeftChildren || elements[i].leftChild != null) deleteElementWithChildren(getIndex(elements[i].leftChild));
        if(!elements[i].availableToAddRightChildren || elements[i].rightChild != null) deleteElementWithChildren(getIndex(elements[i].rightChild));
        elements[i] = null;
    }

    private int getIndex(Entry element) throws Exception {
        int index = -1;

        for (int i = 0; i < elements.length; i++) {
            if(elements[i] != null && element.elementName.equals(elements[i].elementName)) {
                index = i;
                break;
            }
        }

        if(index > -1) return index;

        throw new Exception("some problem");
    }

    private void deleteLastEmptyElements(int indexLastNotEmptyElement) {
        if(indexLastNotEmptyElement > 0){
            Entry[] modifiedElements = new Entry[indexLastNotEmptyElement +1];
            System.arraycopy(elements, 0, modifiedElements, 0, indexLastNotEmptyElement + 1);

            elements = modifiedElements;

            for (int i = indexLastNotEmptyElement; i < elements.length; i++) {
                toFreeParentConnection(i);
            }
        }
    }

    //посчитать с конца, какой элемент не пустой и получить его индекс
    private int getIndexLastRealElement() {
        int indexLastNotEmptyElement = elements.length;

        while (true){
            if(elements[--indexLastNotEmptyElement] != null) return indexLastNotEmptyElement;
        }
    }

    //класс для объектов-узлов
    static class Entry<T> implements Serializable{

        String elementName;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;
        public Entry(String elementName) {
            this.elementName = elementName;
            this.availableToAddLeftChildren = true;
            this.availableToAddRightChildren = true;
        }

        //наличие этого метода требует условие, но в решении его не использовал
        boolean isAvailableToAddChildren(){
            return availableToAddLeftChildren || availableToAddRightChildren;
        }

    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    //Все что ниже - неиспользуемое наследие
    @Override
    public void add(int index, String element) {throw new UnsupportedOperationException();}

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }
}
