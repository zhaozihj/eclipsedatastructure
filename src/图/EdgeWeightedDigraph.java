package ͼ;

public class EdgeWeightedDigraph {
	
	//��¼��������
	private final int V; 

	//��¼������
    private int E; 

    //�ڽӱ�
	private Queue<DirectedEdge>[] adj;

	//����һ������V������Ŀռ�Ȩ����ͼ
	public EdgeWeightedDigraph(int V){
		//��ʼ����������
		this.V=V;
		//��ʼ���ߵ�����
		this.E=0;
		//��ʼ���ڽӱ�
		this.adj=new Queue[V];
		
		for(int i=0;i<adj.length;i++) {
			adj[i]=new Queue<DirectedEdge>();
		}
		
	}
	
	//��ȡͼ�ж�������� 
	public int V() {
	return V;	
	}

	//��ȡͼ�бߵ����� 
public int E() {
	return E;
}

//���Ȩ����ͼ�����һ����e 
public void addEdge(DirectedEdge e) {
	//��e���з���ģ�ֻ��Ҫ��e�����������ڽӱ��м���
	int v=e.from();
	adj[v].enqueue(e);
	E++;
}

//��ȡ�ɶ���vָ�������еı� 
public Queue<DirectedEdge> adj(int v) {
	return adj[v];
}

//��ȡ��Ȩ����ͼ�����б�
public Queue edges() {
//����ͼ�е�ÿһ������Ȼ��õ��ö�����ڽӱ������õ�ÿһ������ӵ�������
Queue<DirectedEdge> edges=new Queue<DirectedEdge>();
for(int v=0;v<V;v++) {
	for(DirectedEdge edge:adj[v]) {
		edges.enqueue(edge);
	}
}
return edges;
}

}