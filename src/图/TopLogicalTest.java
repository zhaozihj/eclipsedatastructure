package 图;

public class TopLogicalTest {

	public static void main(String[] args) {
		//准备有向图
		Digraph digraph=new Digraph(6);
		digraph.addEdge(0, 2);
		digraph.addEdge(0, 3);
		digraph.addEdge(2, 4);
		digraph.addEdge(3, 4);
		digraph.addEdge(4, 5);
		digraph.addEdge(1,3);
		//通过TopoLogical对象对有向图中的顶点进行排序
		TopoLogical topological=new TopoLogical(digraph);
		//获取顶点的线性序列，进行打印就可以了
         Stack<Integer> order=topological.order();
         for(Integer s:order) {
        	 System.out.println(s);
         }
	}

}
