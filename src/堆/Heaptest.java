package ��;

public class Heaptest {

	public static void main(String[] args) {
        //�����Ѷ���
		Heap<String> heap=new<String> Heap(10);
		//�����д����ַ�������
		heap.insert("a");
		heap.insert("b");
		heap.insert("c");
		heap.insert("d");
		heap.insert("e");
		heap.insert("f");
		heap.insert("g");
		heap.insert("h");
		heap.insert("i");
		
		//ͨ��ѭ���Ӷ���ɾ������
		String result=null;
		while((result=heap.delMax())!=null) {
	      System.out.println(result);
	}

}
}
