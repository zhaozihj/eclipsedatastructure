package ͼ;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PrimMSTTest {
public static void main(String []args) throws NumberFormatException, IOException {
	//�ȴ���һ����Ȩ����ͼ
	BufferedReader br=new BufferedReader(new FileReader("D:\\�����߰���\\c.txt"));
	int pointnumbers=Integer.parseInt(br.readLine());
	EdgeWeightedGraph G=new EdgeWeightedGraph(pointnumbers);
	int edgenumbers=Integer.parseInt(br.readLine());
	for(int i=0;i<edgenumbers;i++) {
		String []line=br.readLine().split(" ");
	    int v=Integer.parseInt(line[0]);
	    int w=Integer.parseInt(line[1]);
	    double weight=Double.parseDouble(line[2]);
	    
	    //������Ȩ�����
	    Edge edge=new Edge(v,w,weight);
	    G.addEdge(edge);
	}
	//����һ��PrimMST���󣬼����Ȩ����ͼ�е���С������
	PrimMST primMST=new PrimMST(G);
	
	//��ȡ��С�������е����б�
	Queue<Edge> edges=primMST.edges();
	
	//������ӡ���еı�
	for(Edge e:edges) {
		int v=e.either();
		int w=e.other(v);
		double weight=e.weight();
		System.out.println(v+"-"+w+"::"+weight);
	}
	
}
}
