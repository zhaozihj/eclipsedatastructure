package 图;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PrimMSTTest {
public static void main(String []args) throws NumberFormatException, IOException {
	//先创建一个加权无向图
	BufferedReader br=new BufferedReader(new FileReader("D:\\放乱七八糟\\c.txt"));
	int pointnumbers=Integer.parseInt(br.readLine());
	EdgeWeightedGraph G=new EdgeWeightedGraph(pointnumbers);
	int edgenumbers=Integer.parseInt(br.readLine());
	for(int i=0;i<edgenumbers;i++) {
		String []line=br.readLine().split(" ");
	    int v=Integer.parseInt(line[0]);
	    int w=Integer.parseInt(line[1]);
	    double weight=Double.parseDouble(line[2]);
	    
	    //构建加权无向边
	    Edge edge=new Edge(v,w,weight);
	    G.addEdge(edge);
	}
	//创建一个PrimMST对象，计算加权无向图中的最小生成树
	PrimMST primMST=new PrimMST(G);
	
	//获取最小生成树中的所有边
	Queue<Edge> edges=primMST.edges();
	
	//遍历打印所有的边
	for(Edge e:edges) {
		int v=e.either();
		int w=e.other(v);
		double weight=e.weight();
		System.out.println(v+"-"+w+"::"+weight);
	}
	
}
}
