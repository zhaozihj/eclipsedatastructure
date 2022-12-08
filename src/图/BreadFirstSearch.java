package ͼ;

public class BreadFirstSearch {
	//���������㣬ֵ��ʾ��ǰ�����Ƿ��Ѿ������� 
	private boolean[] marked;
	//��¼�ж��ٸ�������s������ͨ 
	private int count;
	//�����洢�������ڽӱ�ĵ�
	private Queue<Integer> waitSearch;
	//������������������ʹ�ù�����������ҳ�Gͼ��s������������ڶ���
	public BreadFirstSearch(Graph G,int s) {
		this.marked=new boolean[G.V()];
		this.count=0;
		this.waitSearch=new Queue<Integer>();
		bfs(G,s);
	}
	private void bfs(Graph G,int v) {
		//����ǰv��ʶΪ������
		marked[v]=true;
		//��Ҫ��v������д�����
		waitSearch.enqueue(v);
		//ͨ��ѭ����������в�Ϊ�գ���Ӷ����е���һ���������Ķ����������
	   while(!waitSearch.isEmpty()) {
		   //����һ���������Ķ���
		   Integer wait=waitSearch.dequeue();
		   
		   //����wait������ڽӱ�
		  for(Integer w: G.adj(wait))
		  {
			  //�жϵ�ǰ����Ƿ�����
			  if(!marked[w]) {
				  bfs(G,w);
			  }
		  }
		   
	   }
	   //����ͨ�Ķ���+1
	  count++;
	}
	//�ж�w�����Ƿ���s������ͨ
	public boolean marked(int w) {
		return marked[w];
	}
	//��ȡ�붥��s��ͨ�����ж��������
	public int count() {
		return count;
	}
	
}
