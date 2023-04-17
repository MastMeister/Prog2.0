package aufgabe04;

public class LinkedArrayFreqTable<T> extends AbstractFrequencyTable<T> {

    private Node start;
    private Node end;

    private Node head;
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
    start = new Node(null,end,null);
    end = new Node(null,null,start);
    size = 0;
    }

    @Override
    public void add(T w, int f) {
        // Wenn die Liste noch kein Element enthält
        if(this.isEmpty()){
            Node a = new Node(new Word(w,f),end,start);
            end.prev = a;
            start.next = a;
            size++;
            return;
        }
        head = start.next;
        // wenn Element schon vorhanden
        while(head != end) {
            if (head.data.getWord().equals(w)) {
                head.data.addFrequency(f);

                moveToLeft(head);
                return;
            }
            head = head.next;
        }
        // Wenn element noch nicht vorhanden am ende einfügen
        Node t = end.prev;
        Node r = new Node(new Word(w,f),t.next,t);
        r.next.prev = r;
        t.next = r;
        moveToLeft(r);
        size++;
    }

    @Override
    public Word get(int pos) {
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
        if(head.data.getWord().equals(w))
            return head.data.getFrequency();
        head = head.next;
    }
    return 0;
    }
    public void moveToLeft(Node pos){
        head = pos;
        Node t = pos;
        int freq = pos.data.getFrequency();
        //Richtige Position finden
        while(head.prev != start && freq > head.prev.data.getFrequency()) {
            head = head.prev;
            //if(head.prev == start)
              //  break;
        }
        //System.out.println(head.data);
        // Node neu richtig einfügen
        Node y = new Node(pos.data,head,head.prev);
        y.prev.next = y;
        head.prev =y;
        //Alte position löschen
        pos.prev.next = pos.next;
        pos.next.prev = pos.prev;


         /*   if(head.prev == start) {
                // am anfang neu einfügen
                Node b = new Node(pos.data, start.next, start);
                b.next.prev = b;
                start.next = b;
                // ursprüngliche Stelle löschen
                pos.prev.next = pos.next;
                pos.next.prev = pos.prev;
            }*/




            /*
             // vor richtiger stelle einfügen
             Node b = head;
             Node a = new Node(t.data,b, b.prev);
             a.prev.next = a;
             b.prev = a;
             // ursprüngliche stelle löschen löschen :
             t.prev.next = t.next;
             t.next.prev = t.prev;
             return;
            */



    }

}
    class Node {
    Node next;
    Node prev; // previous
    Word data;// data;
    Node(Word x, Node n, Node p) {
    data = x;
    next = n;
    prev = p;
    }
    }