package 树;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Traffic_Project_Test {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new FileReader("D:\\放乱七八糟\\a.txt"));
		//城市数量
		int number=Integer.parseInt(br.readLine());
		UF_TREE_WEIGHTED uf=new UF_TREE_WEIGHTED(number);
		//路的数量
		int roadNumber=Integer.parseInt(br.readLine());
		//循环读取已经修建好的道路，并调用union方法
		for(int i=0;i<roadNumber;i++) {
			String line = br.readLine();
			int p = Integer.parseInt(line.split(" ")[0]);
			int q = Integer.parseInt(line.split(" ")[1]);
			uf.union(p,q);

		}
		//获取剩余的分组数量
		int groupNumber = uf.count();
		//计算出还需要修建的道路
		System.out.println("还需要修建"+(groupNumber-1)+"道路，城市才能相通");


	}

}
