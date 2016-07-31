/**
 * Created by Zephery on 2016/7/31.
 */
public class LoopQueue<T> {
    private int DEFAULT_SIZE = 10;
    private int capacity;
    private Object[] elementData;
    private int front = 0;
    private int rear = 0;

    public LoopQueue() {
        capacity = DEFAULT_SIZE;
        elementData = new Object[capacity];
    }

    public LoopQueue(T element) {
        this();
        elementData[0] = element;
        rear++;
    }

    public LoopQueue(T element, int initSize) {
        this.capacity = initSize;
        elementData = new Object[capacity];
        elementData[0] = element;
        rear++;
    }

    public boolean isempty() {
        return rear == front && elementData[rear] == null;
    }

    public int getLength() {
        if (isempty()) {
            throw new IndexOutOfBoundsException("Full");
        }
        return rear > front ? rear - front : capacity - (front - rear);
    }

    public void add(T element) {
        if (rear == front && elementData[front] != null) {
            throw new IndexOutOfBoundsException("Full");
        }
        elementData[rear++] = element;
        rear = rear == capacity ? 0 : rear;
    }
    @SuppressWarnings("unchecked")
    public T element(){
        if(isempty()){
            throw new IndexOutOfBoundsException("empty");
        }
        return (T)elementData[front];
    }
    @SuppressWarnings("unchecked")
    public T remove(){
        if(isempty()){
            throw new IndexOutOfBoundsException("empty");
        }
        T oldValue=(T)elementData[front];
        elementData[front++]=null;
        front=front==capacity?0:front;
        return oldValue;
    }
}
