package cw3;

public interface IQueue<T> {
    boolean isEmpty();
    boolean isFull();
    T dequeue() throws EmptyQueueException, EmptyStackException;
    void enqueue(T elem) throws FullQueueException, FullStackException, EmptyStackException;
    int size();
    T first() throws EmptyQueueException, EmptyStackException;
}
