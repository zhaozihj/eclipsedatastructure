package ͼ;

public class DepthFirstSearch {
	//���������㣬ֵ��ʾ��ǰ�����Ƿ��Ѿ�������
	private boolean[] marked; 
	//��¼�ж��ٸ�������s������ͨ
	private int count;
	//�������������������ʹ��������������ҳ�Gͼ��s���� ��������ͨ����
	public DepthFirstSearch(Graph G,int s) {
		//��ʼ��marked����
		this.marked=new boolean[G.V()];
		//��ʼ���Ͷ���s��ͨ�Ķ��������
		this.count=0;
		
	dfs(G,s);
	}
	//ʹ��������������ҳ�Gͼ��v�����������ͨ���� 
	private void dfs(Graph G,int v ) {
		//��v�����ʶΪ������
		marked[v]=true;
		//û��������������ǰv������ڽӱ�
		for(Integer w:G.adj(v)) {
			//�ж���ЩԪ����û�б������������û������������ݹ����dfs���������������
			if(!marked[w]) {
				dfs(G,w);
			}
		}
		count++;
	}
	//�ж϶���w��s�����Ƿ���ͨ
	public boolean marked(int w) {
		return marked[w];
	}
	//��ȡ�붥��s��ͨ�����ж��������
	public int count() {
		return count;
	}
	
}
