package ͼ;

public class DepthFirstSearchTest {

	public static void main(String[] args) {
		//׼��Graph����
		Graph graph=new Graph(13);
		graph.addEdge(0,5);
		graph.addEdge(0,6);
		graph.addEdge(0,1);
		graph.addEdge(0,2);
		graph.addEdge(5,3);
		graph.addEdge(5,4);
		graph.addEdge(3,4);
		graph.addEdge(4,6);
		graph.addEdge(7,8);
		graph.addEdge(9,11);
		graph.addEdge(9,10);
		graph.addEdge(9,12);
		graph.addEdge(11,12);
        //׼�����������������
		DepthFirstSearch dfs=new DepthFirstSearch(graph,0);
		//������ĳ��������ͨ�Ķ�������
		System.out.println(dfs.count());//��0������ͨ�Ķ�������
		//����ĳ��0����5���Ƿ���ͨ
		boolean marked1=dfs.marked(5);
		System.out.println(marked1);
	}

}
