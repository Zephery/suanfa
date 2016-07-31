package LoopQueue;

/**
 * Created by Zephery on 2016/7/31.
 */
public class LoopQueueTest {
    public static void main(String args[]){
        LoopQueue<String> loopQueue=new LoopQueue<String>("eeee",4);
        loopQueue.add("aaaa");
        loopQueue.add("bbbb");
        loopQueue.add("cccc");
        loopQueue.remove();
        loopQueue.add("dddddd");
        System.out.println("fjoejfoeij");
    }
}
