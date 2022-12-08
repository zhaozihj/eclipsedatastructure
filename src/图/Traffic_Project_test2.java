package 图;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Traffic_Project_test2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new FileReader("D:\\放乱七八糟\\a.txt"));
		int citynumber=Integer.parseInt(br.readLine());
		Graph group=new Graph(citynumber);
		int roadnumber=Integer.parseInt(br.readLine());
		for(int i=0;i<roadnumber;i++) {
			String line=br.readLine();
			int p=Integer.parseInt(line.split(" ")[0]);
			int q=Integer.parseInt(line.split(" ")[1]);
			group.addEdge(p,q);
		}
		DepthFirstSearch search=new DepthFirstSearch(group,9);
		//判断第九个城市和第八个第十个是否相通
        System.out.println(search.marked(10));
        System.out.println(search.marked(8));
	}

}
