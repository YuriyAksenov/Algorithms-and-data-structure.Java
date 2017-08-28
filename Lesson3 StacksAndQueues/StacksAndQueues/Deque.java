import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private class Node{
        Item item;
        Node prev;
        Node next;
    }

    private Node first=null;
    private Node last=null;
    private int count=0;

    // конструктор пустого дека
    public Deque(){

    }
    // дек пуст?
    public boolean isEmpty(){
        return first==null;
    }
    // возвращает количество элементов в деке
    public int size(){
        return count;
    }
    // добавляет элемент в начало
    public void addFirst(Item item){
        if(item==null) throw new IllegalArgumentException("Argyment is null");
        Node newNode  = new Node();
        newNode.item=item;
        newNode.next=last;
        newNode.prev=null;

        if(!isEmpty()) first.prev=newNode;else  first=last=newNode;
        count++;
    }
    // добавляет элемент в конец
    public void addLast(Item item){
        if(item==null) throw new IllegalArgumentException("Argyment is null");
        Node newNode  = new Node();
        newNode.item=item;
        newNode.next=null;
        newNode.prev=first;

        if(!isEmpty()) last.next=newNode;else  first=last=newNode;
        count++;
    }
    // удаляет и возвращает элемент с начала
    public Item removeFirst(){
        if(isEmpty()) throw new NoSuchElementException("The deque is empty.");
        Item returnItem = first.item;
        if (first==last) first=last=null; else first = first.next;
        count--;
        return returnItem;
    }
    // удаляет и возвращает элемент с конца
    public Item removeLast(){
        if(isEmpty()) throw new NoSuchElementException("The deque is empty.");
        Item returnItem = last.item;
        if (first==last) first=last=null; else last = last.prev;
        count--;
        return returnItem;
    }
    // возвращает итератор по элементам с начала
    // к концу дека
    public Iterator<Item> iterator(){
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item>{
        private Node current=first;

        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("It is not possible.");
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    // клиент
    public static void main(String[] args){

    }
}