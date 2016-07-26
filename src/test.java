import java.util.Scanner;
import java.lang.Character;

/**
 * Created by Zephery on 2016/7/19.
 */
class StackX {
    private int  maxSize;        // size of stack array
    private char[] stackArray;
    private int  top;            // top of stack

    //--------------------------------------------------------------
    public StackX(int s)         // constructor
    {
        maxSize = s;             // set array size
        stackArray = new char[maxSize];  // create array
        top = -1;                // no items yet
    }

    //--------------------------------------------------------------
    public void push(char j)    // put item on top of stack
    {
        stackArray[++top] = j;     // increment top, insert item
    }

    //--------------------------------------------------------------
    public char pop()           // take item from top of stack
    {
        return stackArray[top--];  // access item, decrement top
    }

    //--------------------------------------------------------------
    public char  peek()          // peek at top of stack
    {
        return stackArray[top];
    }

    //--------------------------------------------------------------
    public boolean isEmpty()    // true if stack is empty
    {
        return (top == -1);
    }

    //--------------------------------------------------------------
    public boolean isFull()     // true if stack is full
    {
        return (top == maxSize - 1);
    }
}

public class test {
    public static void main(String[] args) {
        StackX theStack = new StackX(10);  // make new stack
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char array[] = str.toCharArray();
        for (int i = 0; i < array.length; i++) {
            theStack.push(array[i]);
        }

        while (!theStack.isEmpty())     // until it's empty,
        {                             // delete item from stack
            char value = theStack.pop();
            System.out.print(value);      // display it
            System.out.print("");
        }  // end while
        System.out.println("");
    }  // end main()
}
