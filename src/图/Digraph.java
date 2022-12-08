package ͼ;

public class Digraph {
//������Ŀ
	private final int V;
	//�ߵ���Ŀ
	private int E;
	//�ڽӱ�
	private Queue<Integer>[] adj;
	
	public Digraph(int V) {
		//��ʼ����������
		this.V=V;
		//��ʼ���ߵ�����
		this.E=0;
		//��ʼ���ڽӱ�
		this.adj=new Queue[V];
		
		for(int i=0;i<adj.length;i++) {
			adj[i]=new Queue<Integer>();
		}
		
	}
	
	//��ȡ�������Ŀ
	public int V() {
		return V;
	}
	//��ȡ�ߵ���Ŀ
	public int E() {
		return E;
	}
	
	//������ͼ�����һ����  v->w
	public void addEdge(int v,int w) {
		//�ö���w�����ڶ���v���ڽӱ��У���Ϊ�����з���ģ����գ�����v���ڽӱ��д洢�����ڶ���ĺ�����v����������
		adj[v].enqueue(w);
		E++;
	}
	//��ȡ��vָ���ı������ӵĶ���
	public Queue<Integer> adj(int v){
	return adj[v];
	}
	//��ȡ��ͼ�ķ���ͼ
	private Digraph reverse() {
		//��������ͼ����
		Digraph r=new Digraph(V);
		for(int v=0;v<V;v++) {
			//��ȡ�ɸö���ָ�������б�
			for(Integer w:adj[v]) {//ԭͼ�б�ʾ������v->w�ñ�
				r.addEdge(w, v);//�������㷴����ӣ��Ϳ����ñ߶�����
				
			}
		}
		return r;
	}
}
