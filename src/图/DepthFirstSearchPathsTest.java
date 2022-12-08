package Õº;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DepthFirstSearchPathsTest {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new FileReader("D:\\∑≈¬“∆ﬂ∞À‘„\\b.txt"));
		int pointnumber=Integer.parseInt(br.readLine());
		Graph g=new Graph(pointnumber);
		
		int edgenumber=Integer.parseInt(br.readLine());
		for(int i=0;i<edgenumber;i++) {
			String line=br.readLine();
			int p=Integer.parseInt(line.split(" ")[0]);
			int q=Integer.parseInt(line.split(" ")[1]);
			g.addEdge(p, q);
		}
             DepthFirstPaths paths=new DepthFirstPaths(g,0);
             Stack<Integer> path=paths.pathTo(4);
             StringBuilder sb=new StringBuilder();
             for(Integer v:path) {
            	sb.append(v+"-");
             }
             sb.deleteCharAt(sb.length()-1);
             System.out.println(sb);
	}
       
}
