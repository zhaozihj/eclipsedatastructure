package ���ȶ���;

public class MaxPriorityQueueTest {

	public static void main(String[] args) {
	      //�������ȶ���
		MaxPriorityQueue<String> queue=new MaxPriorityQueue<>(10);
		//�������д洢Ԫ��
		queue.insert("a");
		queue.insert("b");
		queue.insert("c");
		queue.insert("d");
		queue.insert("e");
		queue.insert("f");
		queue.insert("g");
		//ͨ��ѭ���Ӷ����л�ȡ����Ԫ��
          while(!queue.isEmpty()) {
        	  String max=queue.delMax();
        	  System.out.println(max);
          }
	}

}
