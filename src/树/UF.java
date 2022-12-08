package 树;

public class UF {
	//记录结点元素和该元素所在分组的标识
private int[] eleAndGroup;
//记录并查集中数据的分组个数
private int count;
//初始化并查集
public UF(int N) {
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
	return eleAndGroup[p];
}

//判断并查集中元素p和元素q是否在同一个分组中
public boolean connected(int p,int q) {
	return find(p)==find(q);
}
//合并p元素和q元素所在的分组
public void union(int p,int q) {
	//判断元素p和q是否已经在同一分组中，如果已经在同一分组中，则结束方法就可以了
	if(connected(p,q)) {
		return ;
	}
	
	//找到p所在分组的标识符
	int pgroup=find(p);
	//找到q所在分组的标识符
	int qgroup=find(q);
    //合并组，让p所在组的所有元素的组标识符变为q所在分组的标识符
	for(int i=0;i<eleAndGroup.length;i++) {
	if(eleAndGroup[i]==pgroup) {
		eleAndGroup[i]=qgroup;
	}
	}
	//组数减一
	this.count--;
}
}
