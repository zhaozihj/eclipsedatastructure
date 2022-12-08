package ͼ;

public class Edge implements Comparable<Edge>{
private final int v;//����һ
private final int w;//�����
private final double weight;//Ȩ��ֵ
//ͨ������v��w���Լ�Ȩ��weightֵ����һ���߶���
public Edge(int v,int w,double weight) {
	this.v=v;
	this.w=w;
	this.weight=weight;
}

//��ȡ�ߵ�Ȩ��ֵ
public double weight() {
	return weight;
}

//��ȡ���ϵ�һ����
public int either() {
	return v;
}
//��ȡ���ϳ��˶���vertex�������һ������
public int other(int vertex) {
	if(vertex==v) {
		return w;
	}
	else
	{
		return v;
	}
}
//�Ƚϵ�ǰ�ߺͲ���that�ߵ�Ȩ�أ������ǰ��Ȩ�ش󣬷��� 1�����һ���󣬷���0�������ǰȨ��С������-1 
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
