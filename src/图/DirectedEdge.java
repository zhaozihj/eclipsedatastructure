package ͼ;

public class DirectedEdge {
private final int v;//���
private final int w;//�յ�
private final double weight;//��ǰ�ߵ�Ȩ��

//ͨ������v��w���Լ�Ȩ��weightֵ����һ���߶���
public DirectedEdge(int v,int w,double weight) {
	this.v=v;
	this.w=w;
	this.weight=weight;
}
//��ȡ�ߵ�Ȩ��ֵ
public double weight() {
	return weight;
}

//��ȡ����ߵ����
public int from() {
	return v;
} 

//��ȡ����ߵ��յ�
public int to() {
	return w;
}
}
