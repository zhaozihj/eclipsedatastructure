package 树;

public class UFTREE {
		//记录结点元素和该元素所在分组的标识
	private int[] eleAndGroup;
	//记录并查集中数据的分组个数
	private int count;
	//初始化并查集
	public UFTREE(int N) {
		//初始化分组的数量，默认情况下有N个分组
			this.count=N;
			//初始化end数组
			this.eleAndGroup=new int [N];
			//初始化eleAndGroup中的元素极其所在的组的标识符,让eleAndGroup数组的索引作为并查集的每个节点的元素，并且让每个索引处的值(该元素所在组的标识符)就是该索引
	        for(int i=0;i<eleAndGroup.length;i++) {
	        	eleAndGroup[i]=i;
	        }
	}

	//获取当前并查集中的数据有多少个分组
	public int count() {
		return this.count;
		
	}
	//查询p所在分组的标识符
	public int find(int p) {
		while(true) {
			if(p==eleAndGroup[p]) {
				return p;
			}
			
			p=eleAndGroup[p];
		}
	}

	//判断并查集中元素p和元素q是否在同一个分组中
	public boolean connected(int p,int q) {
		return find(p)==find(q);
	}
	//合并p元素和q元素所在的分组
	public void union(int p,int q) {

		//找到p所在分组的对应的根节点
		int pRoot=find(p);
		//找到q所在分组的根节点
		int qRoot=find(q);
//如果p和q已经在一个分组就不用合并了
		if(pRoot==qRoot) {
			return ;
		}
		//让p所在树的根节点的父节点为q所在树的根节点即可
		eleAndGroup[pRoot]=qRoot;
		//组数减一
		this.count--;
	}
	
}
