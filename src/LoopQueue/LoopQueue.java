package LoopQueue;

/**
 * Created by Zephery on 2016/7/31.
 */
public class LoopQueue<T> {
    private int DefaultSize = 10;
    private int capacity;     //所输入的容量;
    private int front;
    private int rear;
    private Object[] elementData;

    public LoopQueue() {
        capacity = DefaultSize;
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

    public int length() {
        if (isempty())
            throw new IndexOutOfBoundsException("full");
        return rear > front ? rear - front : capacity - (front - rear);
    }

    public void add(T element) {
        if (rear==front&&elementData[front]!=null) {
            throw new IndexOutOfBoundsException("full");
        }
        elementData[rear++] = element;
        rear = rear == capacity ? 0 : rear;
    }
    @SuppressWarnings("unchecked")
    public T remove() {
        if (isempty()) {
            throw new IndexOutOfBoundsException("nicai");
        }
        T oldValue = (T) elementData[front];
        elementData[front] = null;
        front = front == capacity ? 0 : front;
        return oldValue;
    }

}
