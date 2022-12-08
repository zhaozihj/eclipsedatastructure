package 图;

public class DepthFirstOrder {
	//索引代表顶点，值表示当前顶点是否已经被搜索 
	private boolean[] marked;
	//使用栈，存储顶点序列
	private Stack reversePost;
	
	//创建一个检测环对象，检测图G中是否有环
	public DepthFirstOrder(Digraph G) {
		//初始化marked数组
		this.marked=new boolean[G.V()];
		//初始化reversePost栈
		this.reversePost=new Stack<Integer>();
		
		//让图中的每一个顶点作为一次入口完成深度搜索
		for(int v=0;v<G.V();v++) {
			if(!marked[v]) {
				dfs(G,v);
			}
		}
	}
	//基于深度优先搜索，生成顶点线性序列
	private void dfs(Digraph G,int v) {
		marked[v]=true;
		for(Integer w:G.adj(v)) {
			if(!marked[w]) {
				dfs(G,w);
			}
		}
		//让顶点v进栈
		reversePost.push(v);
	}
	//获取顶点线性序列
	public Stack reversePost() {
		return reversePost;
	}
}
