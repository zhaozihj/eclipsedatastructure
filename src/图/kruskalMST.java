package ͼ;

import ���ȶ���.MinPriorityQueue;
import ��.UF_TREE_WEIGHTED;

public class kruskalMST {
	//������С�����������б� 
	private Queue mst;
	//���������㣬ʹ��uf.connect(v,w)�����ж϶���v�Ͷ���w�Ƿ��� ͬһ�����У�ʹ��uf.union(v,w)���԰Ѷ���v���ڵ����Ͷ���w���ڵ����ϲ�
	private UF_TREE_WEIGHTED uf ;
	//�洢ͼ�����еıߣ�ʹ����С���ȶ��У��Ա߰���Ȩ�ؽ�������
	private MinPriorityQueue<Edge> pq;
	
	//����һ����Ȩ����ͼ��������С�������������
	public kruskalMST(EdgeWeightedGraph G) {
		//��ʼ��mst
		mst=new Queue<Edge>();
		//��ʼ��uf
		uf=new UF_TREE_WEIGHTED(G.V());
		//��ʼ��pq
		pq=new MinPriorityQueue<>(G.E()+1);
		//��ͼ�����еıߴ洢��pq��
		for(Edge e:G.edges()) {
			pq.insert(e);
		}
		//����pq���У��õ���СȨ�صı߽��д���
		while(!pq.isEmpty()&&mst.size()<G.V()-1) {
			//�ҵ�Ȩ����С�ı�
			Edge e=pq.delMin();
			//�ҵ��ñߵ���������
			int v=e.either();
			int w=e.other(v);
			//�ж������������Ƿ��Ѿ���ͬһ�����У������ͬһ�����У����Ըñ�����������һ�����У������������������ڵ��������ϲ���һ����
			if(uf.connected(v,w)) {
				continue;
			}
			
			uf.union(v, w);
			//�ñ�e���뵽mst������
			mst.enqueue(e);
		}
	}
	//��ȡ��С�����������б�
	public Queue edges() {
		return mst;
	}
}
