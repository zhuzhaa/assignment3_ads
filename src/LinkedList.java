class LinkedList<T> {
    private node<T> head;
    private node<T> tail;
    public int size;

    LinkedList(){
        head = null;
        size = 0;
    }

    public T get(int index) {
        node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public void add(T data){
        if(head == null){
            head = new node(data);
        } else {
            node temp = head;
            head = new node(data);
            head.next = temp;
        }
        size++;
    }

    public T remove() {
        if (head == null)
            throw new IndexOutOfBoundsException("Linked list is empty!");
        T a = head.data;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
        }
        size--;
        return a;
    }
}
