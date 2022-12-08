package ͼ;

public class EdgeWeightedGraph {
	//��¼�������� 
	private final int V;
	//��¼������ 
	private int E;
	//�ڽӱ�
	private Queue<Edge>[] adj;
	
	//����һ������V������Ŀռ�Ȩ����ͼ
	public EdgeWeightedGraph(int V) {
		//��ʼ�����������
		this.V=V;
		//��ʼ���ߵ�����
		this.E=0;
		//��ʼ���ڽӱ�
		this.adj=new Queue[V];
		for(int i=0;i<adj.length;i++) {
			adj[i]=new Queue<Edge>();
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
	//������ͼ�����һ����e
	public void addEdge(Edge e) {
		//��ȡ�����ߵ���������
		int v=e.either();
		int w=e.other(v);
		adj[v].enqueue(e);
		adj[w].enqueue(e);
		
		//�ߵ�������һ
		E++;
	}
	//��ȡ����v�����������б�
	public Queue<Edge> adj(int v){
		return adj[v];
	}
	//��ȡ��Ȩ����ͼ�����б�
	public Queue<Edge> edges() {
		//����һ�����ж���洢���б�
		Queue<Edge> alledges=new Queue<>();
		
		//����ͼ�е�ÿһ�����㣬�ҵ��ö�����ڽӱ��ڽӱ��д洢�˸ö��������ÿһ����
		//��Ϊ��������ͼ������ͬһ����ͬʱ������������������������ڽӱ��У������������������һ���߳������Σ���Ҫ��һ����ֻ��¼һ��
		//����������������ǰ���С����һ������ʱ��Ż���ӣ������Ϳ�ȥ��һ������
		for(int i=0;i<V;i++) {
			for(Edge w:adj[i]) {
				if(w.other(i)<i) {
					alledges.enqueue(w);
				}
			}
		}
		return alledges;
		
	}
}
