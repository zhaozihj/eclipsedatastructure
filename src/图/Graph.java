package 图;

public class Graph {
	//顶点数目
private final int V;
//边的数目
private int E;
//邻接表
private Queue<Integer>[] adj;
public Graph(int v) {
	//初始化顶点数量
	this.V=v;
	//初始化边的数量
	this.E=0;
	//初始化邻接表
	this.adj=new Queue[v];
	
	for(int i=0;i<adj.length;i++) {
		adj[i]=new Queue<Integer>();
	}
}
///获取顶点的数目
public int V() {
	return V;
}
//获取边的数目
public int E() {
	return E;
}
//如图中添加一条边v-w
public void addEdge(int v,int w) {
	//在无向图中，边是没有方向的，该边既可以说是从v到w也可以说是从w到v得边，让w出现在v邻接表中，让v出现在w邻接表中
	adj[v].enqueue(w);
	adj[w].enqueue(v);
	//边的数量加一
	E++;
}

//获取和顶点v相邻的所有顶点
public Queue<Integer> adj(int v){
	return adj[v];
}


}
