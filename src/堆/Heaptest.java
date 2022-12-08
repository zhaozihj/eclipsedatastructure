package 堆;

public class Heaptest {

	public static void main(String[] args) {
        //创建堆对象
		Heap<String> heap=new<String> Heap(10);
		//往堆中存入字符串数据
		heap.insert("a");
		heap.insert("b");
		heap.insert("c");
		heap.insert("d");
		heap.insert("e");
		heap.insert("f");
		heap.insert("g");
		heap.insert("h");
		heap.insert("i");
		
		//通过循环从堆中删除数据
		String result=null;
		while((result=heap.delMax())!=null) {
	      System.out.println(result);
	}

}
}
