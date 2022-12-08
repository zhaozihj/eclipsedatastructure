package 图;

public class EdgeWeightedGraph {
	//记录顶点数量 
	private final int V;
	//记录边数量 
	private int E;
	//邻接表
	private Queue<Edge>[] adj;
	
	//创建一个含有V个顶点的空加权无向图
	public EdgeWeightedGraph(int V) {
		//初始化顶点的数量
		this.V=V;
		//初始化边的数量
		this.E=0;
		//初始化邻接表
		this.adj=new Queue[V];
		for(int i=0;i<adj.length;i++) {
			adj[i]=new Queue<Edge>();
		}
	}
	
	//获取图中顶点的数量
	public int V() {
		return V;
	}
	
	//获取图中边的数量
	public int E() {
		return E;
	}
	//往无向图中添加一条边e
	public void addEdge(Edge e) {
		//获取这条边的两个顶点
		int v=e.either();
		int w=e.other(v);
		adj[v].enqueue(e);
		adj[w].enqueue(e);
		
		//边的数量加一
		E++;
	}
	//获取顶点v所关联的所有边
	public Queue<Edge> adj(int v){
		return adj[v];
	}
	//获取加权无向图的所有边
	public Queue<Edge> edges() {
		//创建一个队列对象存储所有边
		Queue<Edge> alledges=new Queue<>();
		
		//遍历图中的每一个顶点，找到该顶点的邻接表，邻接表中存储了该顶点关联的每一条边
		//因为这是无向图，所以同一条边同时出现在了它关联的两个点的邻接表中，如果按照上述方法会一条边出现两次，需要让一条边只记录一次
		//解决方法就是如果当前结点小于另一个结点的时候才会添加，这样就砍去了一半的情况
		for(int i=0;i<V;i++) {
			for(Edge w:adj[i]) {
				if(w.other(i)<i) {
					alledges.enqueue(w);
				}
			}
		}
		return alledges;
		
	}
}
