package ͼ;

import ���ȶ���.IndexMinPriorityQueue;

public class PrimMST {
	//���������㣬ֵ��ʾ��ǰ�������С������֮�����̱� 
	private Edge[] edgeTo; 
	//���������㣬ֵ��ʾ��ǰ�������С������֮�����̱ߵ�Ȩ��
	private double[] distTo;
	//���������㣬�����ǰ�����Ѿ������У���ֵΪtrue������Ϊ false 
	private boolean[] marked;
	//������ж���������ж���֮�����Ч���б�
	private IndexMinPriorityQueue pq;
	
	//����һ����Ȩ����ͼ��������С�������������
	public PrimMST(EdgeWeightedGraph G) {
		this.edgeTo=new Edge[G.V()];
		this.distTo=new double[G.V()];
		for(int i=0;i<distTo.length;i++) {
			distTo[i]=Double.POSITIVE_INFINITY;
		}
		this.marked=new boolean[G.V()];
		
		pq=new IndexMinPriorityQueue<Double>(G.V());
		
		//Ĭ���ö���0���뵽���У���������ֻ��һ������0������㶥��Ĭ��û������������������������distTo��Ӧλ�õ�ֵ�洢0.0
		distTo[0]=0.0;
		pq.insert(0, 0.0);
		
		//����������С���ȶ��У��õ���С�ĺ��б߶�Ӧ�Ķ��㣬�Ѹö�����뵽��С��������
		while(!pq.isEmpty()) {
			visit(G,pq.delMin());
		}
	}
	
	//������v��ӵ���С�������У����Ҹ����� �� 
	private void visit(EdgeWeightedGraph G, int v)
	{
		//�Ѷ���v��ӵ���С��������
		marked[v]=true;
		//��������
		for(Edge e:G.adj(v)) {
			//��ȡe�ߵ�����һ������
			int w=e.other(v);
			//�ж�����һ�������ǲ����Ѿ������У���������в��������������У���������
			if(marked[w]) {
				continue;
			}
			
			//�жϱ�e��Ȩ���Ƿ�С�ڴ�w���㵽�����Ѿ�������С�ߵ�Ȩ��
			if(e.weight()<distTo[w]) {
				//��������
				edgeTo[w]=e;
				distTo[w]=e.weight();
				if(pq.contains(w)) {
					pq.changeItem(w,e.weight());
				}
				else
				{
					pq.insert(w, e.weight());
				}
			}
		}
	}
	//��ȡ��С�����������б�
	public Queue edges() {
		Queue<Edge> alledges=new Queue<>();
		for(int i=0;i<edgeTo.length;i++) {
			if(edgeTo[i]!=null) {
				alledges.enqueue(edgeTo[i]);
			}
		}
		return alledges;
	}
	
}
