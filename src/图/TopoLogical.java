package 图;

public class TopoLogical {
	//顶点的拓扑排序
	private Stack order;
	public TopoLogical(Digraph G) {
		//先检测图中有没有环
		DirectedCircle circle=new DirectedCircle(G);
		//判断G图中有没有环，如果没有环，则进行顶点排序，创建一个顶点排序对象
		if(!circle.hasCycle()) {
		DepthFirstOrder depthFirstOrder=new DepthFirstOrder(G);
		order=depthFirstOrder.reversePost();
		}
	}
	//判断图G是否有环 
	public boolean isCycle() {
		return order==null;
	}
	//获取拓扑排序的所有顶点 
	public Stack order() {
		return order;
	}
}
