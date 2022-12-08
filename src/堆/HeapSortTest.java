package 堆;

import java.util.Arrays;

public class HeapSortTest {

	public static void main(String[] args) {
		//待排序的数组
		String[] arr = {"S","O","R","T","E","X","A","M","P","L","E"};
		HeapSort.sort(arr);
		//打印排序后数组中元素
		System.out.println(Arrays.toString(arr));
	}

}
