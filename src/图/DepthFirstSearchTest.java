package 图;

public class DepthFirstSearchTest {

	public static void main(String[] args) {
		//准备Graph对象
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
        //准备深度优先搜索对象
		DepthFirstSearch dfs=new DepthFirstSearch(graph,0);
		//测试与某个顶点相通的顶点数量
		System.out.println(dfs.count());//与0顶点相通的顶点数量
		//测试某个0点与5点是否相通
		boolean marked1=dfs.marked(5);
		System.out.println(marked1);
	}

}
