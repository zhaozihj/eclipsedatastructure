package 优先队列;

import java.util.ArrayList;
import java.util.Arrays;

class Main{
	public static void main(String []args) {
		ArrayList<String> list=new ArrayList<>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		String []a=new String[list.size()];
		list.toArray(a);
		System.out.println(Arrays.toString(a));
		ArrayList<String> list2=new ArrayList<>();
		list2=(ArrayList<String>) Arrays.asList(a);
		System.out.println(list2);
		
	}
}