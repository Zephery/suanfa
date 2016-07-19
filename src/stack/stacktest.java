package stack;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/**
 * Created by Zephery on 2016/7/19.
 */
public class stacktest<E extends Object> {
    private List<E> pool = new ArrayList<E>();

    public stacktest() {
    }

    public void clear() {
        pool.clear();
    }

    public boolean isEmpty() {
        return pool.isEmpty();
    }

    public E getTopObject() {
        if (isEmpty()) {
            return null;
        }
        return pool.get(0);
    }

    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return pool.remove(pool.size()-1);
    }
    public void push(E e){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        pool.add(e);
    }
    public int getStackSize(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return pool.size();
    }
}
