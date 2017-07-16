package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/*
Построй дерево(1)
*/

public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    public static void main(String[] args) {
        List<String> list = new CustomTree();
        for (int i = 1; i < 16; i++) {
            list.add(String.valueOf(i));
        }
        //System.out.println("Expected 3, actual is " + ((CustomTree) list).getParent("8"));
        list.remove("5");
        //System.out.println("Expected null, actual is " + ((CustomTree) list).getParent("11"));
    }

    Entry<String> root = new Entry<>("0");

    static class Entry<T> implements Serializable {
        String elementName;
        int lineNumber = 0;
        boolean availableToAddLeftChildren,
                availableToAddRightChildren;
        Entry<T> parent,
                leftChild,
                rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            this.availableToAddLeftChildren = true;
            this.availableToAddRightChildren = true;
        }

        void checkChildren() {
            if (leftChild != null)
                availableToAddLeftChildren = false;
            if (rightChild != null)
                availableToAddRightChildren = false;
        }

        public boolean isAvailableToAddChildren() {
            return availableToAddRightChildren || availableToAddLeftChildren;
        }
    }

    public boolean add(String element) {
        Entry<String> newElement = new Entry<>(element);
        Queue<Entry<String>> queue = new ConcurrentLinkedQueue<>();
        queue.add(root);
        while (true) {
            Entry<String> currentRoot = queue.remove();
            // если находим локальный "корень" у которого нет 1 или 2=х "детей", то записываем
            if (currentRoot.isAvailableToAddChildren()) {
                elementAdd(currentRoot, newElement);
                break;
            } // если дети есть, то ставим их в очередь
            else {
                if (currentRoot.leftChild != null)
                    queue.add(currentRoot.leftChild);
                if (currentRoot.rightChild != null)
                    queue.add(currentRoot.rightChild);
            }
        }
        return true;
    }

    //проверяет наличие детей и запихивает туда, где их нет
    public void elementAdd(Entry<String> currentRoot, Entry<String> currentElement) {
        if (currentRoot.availableToAddLeftChildren) {
            currentElement.parent = currentRoot;
            currentElement.lineNumber = currentRoot.lineNumber + 1;
            currentRoot.leftChild = currentElement;
        } else if (currentRoot.availableToAddRightChildren) {
            currentElement.parent = currentRoot;
            currentElement.lineNumber = currentRoot.lineNumber + 1;
            currentRoot.rightChild = currentElement;
        }
        currentRoot.checkChildren();
    }

    @Override
    public boolean remove(Object object) {
        String removeElementStr = (String) object;
        //ищем нужный элемент в графе и если он не null, удаляем
        Entry<String> removeElement = findElement(root, removeElementStr);
        if (removeElement != null) {
            if (removeElement.parent.leftChild != null && removeElement.parent.leftChild.elementName.equals(removeElement.elementName))
                removeElement.parent.leftChild = null;
            else removeElement.parent.rightChild = null;
            removeElement.parent = null;
        }
        return true;
    }

    //метод ищет указанный элемент в графе и взвращает его или null, если его нет
    public Entry<String> findElement(Entry<String> root, String findElement) {
        Entry<String> elementOut = null;
        Queue<Entry<String>> queue = new ConcurrentLinkedQueue<>();
        queue.add(root);
        while (queue.size() != 0) {
            Entry<String> currentElement = queue.remove();
            if (currentElement.elementName.equals(findElement)) {
                elementOut = currentElement;
                break;
            } else {
                if (currentElement.leftChild != null)
                    queue.add(currentElement.leftChild);
                if (currentElement.rightChild != null)
                    queue.add(currentElement.rightChild);
            }
        }
        return elementOut;
    }

    @Override
    public int size() {
        int size = 0;
        Queue<Entry<String>> queue = new ConcurrentLinkedQueue<>();
        queue.add(root);
        // пробегаемся по элементам
        while (queue.size() != 0) {
            Entry<String> currentElement = queue.remove();
            if (currentElement.leftChild != null) {
                queue.add(currentElement.leftChild);
                size++;
            }
            if (currentElement.rightChild != null) {
                queue.add(currentElement.rightChild);
                size++;
            }
        }
        return size;
    }

    public String getParent(String element) {
        Entry<String> findElement = findElement(root, element);
        if (findElement != null)
            return findElement.parent.elementName;
        else return null;
    }

        @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }
}
//
//public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
//    Entry<String> root;
//
//    public static void main(String[] args) {
//        List<String> list = new CustomTree();
//        for (int i = 1; i < 16; i++) {
//            list.add(String.valueOf(i));
//        }
//        //System.out.println("Expected 3, actual is " + ((CustomTree) list).getParent("8"));
//        list.remove("5");
//        //System.out.println("Expected null, actual is " + ((CustomTree) list).getParent("11"));
//    }
//
//
//    static class Entry<T> implements Serializable {
//        String elementName;
//        int lineNumber;
//        boolean availableToAddLeftChildren, availableToAddRightChildren;
//        Entry<T> parent, leftChild, rightChild;
//
//        public Entry(String elementName) {
//            this.elementName = elementName;
//            availableToAddRightChildren = true;
//            availableToAddLeftChildren = true;
//        }
//
//        void checkChildren() {
//            if (leftChild != null) availableToAddLeftChildren = false;
//            if (rightChild != null) availableToAddRightChildren = false;
//        }
//
//        boolean isAvailableToAddChildren() {
//            return availableToAddLeftChildren || availableToAddRightChildren;
//        }
//    }
//
//
//    protected void elementAdd(Entry<String> currentRoot, Entry<String> currentElement){
//        if (currentRoot.availableToAddLeftChildren) {
//            currentElement.parent = currentRoot;
//            currentElement.lineNumber = currentRoot.lineNumber + 1;
//            currentRoot.leftChild = currentElement;
//        }
//        else if (currentRoot.availableToAddRightChildren){
//            currentElement.parent = currentRoot;
//            currentElement.lineNumber = currentRoot.lineNumber + 1;
//            currentRoot.rightChild = currentElement;
//        }
//        currentRoot.checkChildren();
//    }
//
//
//    @Override
//    public String get(int index) {
//        throw new UnsupportedOperationException();
//    }
//
//    @Override
//    public boolean add(String element){
//        Entry<String> newElement = new Entry<>(element);
//        Queue<Entry<String>> queue = new ConcurrentLinkedQueue<>();
//        queue.add(root);
//        while (true) {
//            Entry<String> currentRoot = queue.remove();
//            // если находим локальный "корень" у которого нет 1 или 2=х "детей", то записываем
//            if (currentRoot.isAvailableToAddChildren()) {
//                elementAdd(currentRoot, newElement);
//                break;
//            } // если дети есть, то ставим их в очередь
//            else {
//                if (currentRoot.leftChild != null)
//                    queue.add(currentRoot.leftChild);
//                if (currentRoot.rightChild != null)
//                    queue.add(currentRoot.rightChild);
//            }
//        }
//        return true;
//    }
//
//
//    @Override
//    public int size() {
//        int count = 0;
//        if (root != null) {
//            Queue<Entry<String>> queue = new ConcurrentLinkedQueue<>();
//            count++;
//            queue.add(root);
//            while (!queue.isEmpty()) {
//                Entry<String> currentEntry = queue.remove();
//                if (!currentEntry.availableToAddRightChildren && currentEntry.rightChild != null) {
//                    count++;
//                    queue.add(currentEntry.rightChild);
//                }
//                if (!currentEntry.availableToAddLeftChildren && currentEntry.leftChild != null) {
//                    count++;
//                    queue.add(currentEntry.leftChild);
//                }
//            }
//        }
//        return count;
//    }
//
//    public String getParent(String s) {
//        Queue<Entry<String>> queue = new ConcurrentLinkedQueue<>();
//        String parentName = null;
//        queue.add(root);
//        while (!queue.isEmpty()) {
//            Entry<String> currentEntry = queue.remove();
//            if (currentEntry.elementName.equals(s)) {
//                parentName = currentEntry.parent.elementName;
//                break;
//            } else {
//                if (!currentEntry.availableToAddRightChildren && currentEntry.rightChild != null) {
//                    queue.add(currentEntry.rightChild);
//                }
//                if (!currentEntry.availableToAddLeftChildren && currentEntry.leftChild != null) {
//                    queue.add(currentEntry.leftChild);
//                }
//            }
//        }
//        return parentName;
//    }
//
//    @Override
//    public boolean remove(Object o) {
//        String s = (String) o;
//        this.remove(s);
//        return false;
//    }
//    public void remove(String s) {
//        if (root == null) {
//            return;
//        }
//        Queue<Entry<String>> queue = new ConcurrentLinkedQueue<>();
//        queue.add(root);
//        boolean isRemoved = false;
//        while (!isRemoved && !queue.isEmpty()) {
//            Entry<String> currentEntry = queue.remove();
//            if (!currentEntry.leftChild.elementName.equals(s)) {
//                queue.add(currentEntry.leftChild);
//            } else {
//                if (!isRemoved) {
//                    currentEntry.leftChild = null;
//                    isRemoved = true;
//                }
//            }
//            if (!currentEntry.rightChild.elementName.equals(s)) {
//                queue.add(currentEntry.rightChild);
//            } else {
//                if (!isRemoved) {
//                    currentEntry.rightChild = null;
//                    isRemoved = true;
//                }
//            }
//        }
//    }
//
////    @Override
////    public void forEach(Consumer<? super String> action) {
////    }
////
////    @Override
////    public Spliterator<String> spliterator() {
////        return null;
////    }
//
////    @Override
////    public Stream<String> stream() {
////        return null;
////    }
////
////    @Override
////    public Stream<String> parallelStream() {
////        return null;
////    }
//
//
////    @Override
////    public boolean removeIf(Predicate<? super String> filter) {
////        return false;
////    }
////
////    @Override
////    public void replaceAll(UnaryOperator<String> operator) {
////
////    }
////
////    @Override
////    public void sort(Comparator<? super String> c) {
////    }
//
//    @Override
//    public String set(int index, String element) {
//        throw new UnsupportedOperationException();
//    }
//
//    @Override
//    public void add(int index, String element) {
//        throw new UnsupportedOperationException();
//    }
//
//    @Override
//    public String remove(int index) {
//        throw new UnsupportedOperationException();
//    }
//
//    @Override
//    public List<String> subList(int fromIndex, int toIndex) {
//        throw new UnsupportedOperationException();
//    }
//
//    @Override
//    protected void removeRange(int fromIndex, int toIndex) {
//        throw new UnsupportedOperationException();
//    }
//
//    @Override
//    public boolean addAll(int index, Collection<? extends String> c) {
//        throw new UnsupportedOperationException();
//    }
//}
