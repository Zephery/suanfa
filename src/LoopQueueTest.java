/**
 * Created by Zephery on 2016/7/31.
 */
public class LoopQueueTest {
    public static void main(String args[]){
        LoopQueue<String> queue=new LoopQueue<String>("aaaa",6);
        queue.add("bbb");
        queue.add("ccc");
        queue.remove();
        queue.add("dddd");
        queue.add("eeee");
        queue.add("fffff");
        queue.add("gggg");
        queue.add("hhhh");
        queue.add("iiiiii");
        System.out.println("OK");
    }
}
