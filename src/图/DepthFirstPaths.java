package 图;


public class DepthFirstPaths {
//索引代表顶点，值表示当前顶点是否已经被搜索 
	private boolean[] marked;
	//起点
	private int s;
	//索引代表顶点，值代表从起点s到当前顶点路径上的最后一个顶点
	private int[] edgeTo;
	
	//
	public DepthFirstPaths(Graph G,int s) {
	//初始化marked数组
		this.marked=new boolean[G.V()];
		//初始化s起点
		this.s=s;
		//初始化edgeTo数组
	    this.edgeTo=new int[G.V()];
	    dfs(G,s);
	}
	
	//使用深度优先搜索找出G图中v顶点的所有相通顶点 
	private void dfs(Graph G,int v) {
		//把v标识为已搜索
		marked[v]=true;
		
		//通过顶点v的邻接表，拿到每一个相邻的顶点，继续进行搜索
		for(Integer w:G.adj(v)) {
			
			//如果w没有被搜索则继续递归搜索
			if(!marked[w]) {
				edgeTo[w]=v;//到达顶点w路径上的最后一个顶点是v,通过v找到w的
				dfs(G,w);
			}
		}
	}
	
	//判断v顶点与s顶点是否存在路径 
	private boolean hasPathTo(int v) {
		return marked[v];
	}
	
	//找出从起点s到顶点v的路径(就是该路径经过的顶点)
      public Stack<Integer> pathTo(int v){
    	  if(!hasPathTo(v)) {
    		  return null;
    	  }
    	  //创键栈对象，保存路径中的所有顶点
    	  Stack<Integer> path=new Stack<>();
    	  
    	  //通过循环，从顶点v开始，一直往前找找到起点为止
    	  for(int x=v;x!=s;x=edgeTo[x]) {
    		  path.push(x);
    	  }
    	  //把起点s放到栈中
    	  path.push(s);
    	  return path;
      }

} 
