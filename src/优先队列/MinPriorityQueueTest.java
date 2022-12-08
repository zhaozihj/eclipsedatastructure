package 优先队列;

public class MinPriorityQueueTest {

	public static void main(String[] args) {
              MinPriorityQueue<String> mpqt=new MinPriorityQueue<>(10);
              mpqt.insert("f");
              mpqt.insert("e");
              mpqt.insert("d");
              mpqt.insert("c");
              mpqt.insert("b");
              mpqt.insert("a");
           while(!mpqt.isEmpty()) {
        	   String min=mpqt.delMin();
        	   System.out.println(min+" ");
           } 
	}

}
