package 图;

public class Edge implements Comparable<Edge>{
private final int v;//顶点一
private final int w;//顶点二
private final double weight;//权重值
//通过顶点v和w，以及权重weight值构成一个边对象
public Edge(int v,int w,double weight) {
	this.v=v;
	this.w=w;
	this.weight=weight;
}

//获取边的权重值
public double weight() {
	return weight;
}

//获取边上的一个点
public int either() {
	return v;
}
//获取边上除了顶点vertex外的另外一个顶点
public int other(int vertex) {
	if(vertex==v) {
		return w;
	}
	else
	{
		return v;
	}
}
//比较当前边和参数that边的权重，如果当前边权重大，返回 1，如果一样大，返回0，如果当前权重小，返回-1 
public int compareTo(Edge that) {
	int cmp=0;
	if(this.weight()>that.weight()) {
		cmp=1;
	}
	else if(this.weight()<that.weight()) {
		cmp=-1;
	}
	else
	{
		cmp=0;
	}
	return cmp;
	
}
}
