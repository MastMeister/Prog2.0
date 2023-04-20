package aufgabe04;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedArrayFreqTable<T> extends AbstractFrequencyTable<T> {

    private Node<T> start;
    private Node<T> end;

    private Node<T> head;
    private int size;
    public LinkedArrayFreqTable(){
        clear();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
    start = new Node<T>(null,end,null);
    end = new Node<T>(null,null,start);
    size = 0;
    }

    @Override
    public void add(T w, int f) {
        // Wenn die Liste noch kein Element enthält
        if(this.isEmpty()){
            Node<T> a = new Node<T>(new Element<T>(w,f),end,start);
            end.prev = a;
            start.next = a;
            size++;
            return;
        }
        head = start.next;
        // wenn Element schon vorhanden
        while(head != end) {
            if (head.data.getElement().equals(w)) {
                head.data.addFrequency(f);

                moveToLeft(head);
                return;
            }
            head = head.next;
        }
        // Wenn element noch nicht vorhanden am ende einfügen
        Node<T> t = end.prev;
        Node<T> r = new Node<T>(new Element<T>(w,f),t.next,t);
        r.next.prev = r;
        t.next = r;
        moveToLeft(r);
        size++;
    }

    @Override
    public Element<T> get(int pos) {
        if (pos < 0 || pos >= size)
            throw new IndexOutOfBoundsException();
        head = start.next;
        for (int i = 0; i < pos; i++)
            head = head.next;
        return head.data;
    }

    @Override
    public int get(T w) {
        head = start.next;
    while (head != end){
        if(head.data.getElement().equals(w))
            return head.data.getFrequency();
        head = head.next;
    }
    return 0;
    }
    public void moveToLeft(Node<T> pos){
        head = pos;
        Node<T> t = pos;
        int freq = pos.data.getFrequency();
        //Richtige Position finden
        while(head.prev != start && freq > head.prev.data.getFrequency()) {
            head = head.prev;
            //if(head.prev == start)
              //  break;
        }
        //System.out.println(head.data);
        // Node neu richtig einfügen
        Node<T> y = new Node<T>(pos.data,head,head.prev);
        y.prev.next = y;
        head.prev =y;
        //Alte position löschen
        pos.prev.next = pos.next;
        pos.next.prev = pos.prev;
    }

    @Override
    public Iterator<Element<T>> iterator() {
        return new LinkedListIterator();
    }
    private class LinkedListIterator implements Iterator<Element<T>> {
        private Node<T> zeiger = start.next;

        @Override
        public boolean hasNext() {
            return zeiger.next != null;
        }

        @Override
        public Element<T> next() {
            if(!hasNext())
                throw new NoSuchElementException();
            Node<T> current = zeiger;
            zeiger = zeiger.next;
            return current.data;
        }

        @Override
        public void remove(){throw new UnsupportedOperationException();}
    }
}

    class Node<T> {
    Node<T> next;
    Node<T> prev; // previous
    Element<T> data;// data;
    Node(Element<T> x, Node<T> n, Node<T> p) {
    data = x;
    next = n;
    prev = p;
    }
    }