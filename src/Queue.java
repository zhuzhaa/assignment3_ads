public class Queue<T> {
    LinkedList<T> b = new LinkedList<T>();
    public boolean isEmpty() {
        return (b.size == 0);
    }

    public T peek(){
        return b.get(0);
    }

    public int size(){
        return b.size;
    }

    public T dequeue() {
        T removingElement = peek();
        b.remove();
        return removingElement;
    }

    public T enqueue(T data) {
        b.add(data);
        return data;
    }
}