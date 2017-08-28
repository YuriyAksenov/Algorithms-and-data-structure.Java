import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] array;
    private int N=0;

    // конструктор пустой рандомизированной
    // очереди
    public RandomizedQueue() {
        array =  (Item[]) new Object[1];
    }
    // очередь пуста?
    public boolean isEmpty(){
        return N==0;
    }
    // возвращает количество элементов в очереди
    public int size(){
        return N;
    }
    // добавляет элемент
    public void enqueue(Item item){
        if(item==null) throw new IllegalArgumentException("Argyment is null");
        if(N==array.length) resize(2*array.length);
        array[N++]=item;
    }
    // удаляет и возвращает случайный элемент
    public Item dequeue(){
        if(isEmpty()) throw new NoSuchElementException("The deque is empty.");
        int iRandom = new Random(N).nextInt();
        Item returnItem = array[iRandom];
        array[iRandom]=null;
        N--;
        if((N*100/array.length)<=25) resize(array.length/2);
        return returnItem;

    }
    // возвращает (но не удаляет) случайный
    // элемент
    public Item sample(){
        int iRandom = new Random(N).nextInt();
        return array[iRandom];
    }
    // возвращает независимый итератор элементов
    // в случайном порядке
    public Iterator<Item> iterator(){
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item>{

        private int n;
        private int i;
        private int k;

        private int step;
        private int jump;

        private Item[] iArray;

        public ListIterator(){
            iArray = (Item[])new Object[N];
            n=iArray.length;
            i=n;
            step = new Random().nextInt(n*2);
            jump =new Random().nextInt(10);
            for (int j=0;j<n;j++)
            iArray[j]=array[j];
        }

        @Override
        public boolean hasNext() {
            return i>0;
        }

        @Override
        public Item next() {
            k=(i+step*jump)%n;
            i--;

            return array[k];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("It is not possible.");
        }
    }

    private void resize(int capacity){
        Item[] copy = (Item[]) new Object[capacity];
        for(int i=0;i<N;i++){
            copy[i]=array[i];
        }
        array=copy;
    }
    // клиент
    public static void main(String[] args){

    }
}