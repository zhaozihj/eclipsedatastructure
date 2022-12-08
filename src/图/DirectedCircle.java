package ͼ;

public class DirectedCircle {

	//���������㣬ֵ��ʾ��ǰ�����Ƿ��Ѿ������� 
	private boolean[] marked;
	//��¼ͼ���Ƿ��л� 
	private boolean hasCycle;
	//���������㣬ʹ��ջ��˼�룬��¼��ǰ������û���Ѿ��������� ����������·����
	private boolean[] onStack;
	
	//����һ����⻷���󣬼��ͼG���Ƿ��л�
	public DirectedCircle(Digraph G) {
		//��ʼ��marked����
		this.marked=new boolean[G.V()];
		//��ʼ��hasCycle
		this.hasCycle=false;
		//��ʼ��onStack
		this.onStack=new boolean[G.V()];
	 
		//�ҵ�ͼ��ÿһ�����㣬��ÿһ��������Ϊ��ڣ�����һ��dfs��������
		for(int v=0;v<G.V();v++) {
			//�ж������ǰ���㻹û���������������dfs��������
			if(!marked[v]) {
				dfs(G,v);
			}
		}
		
		
		
	}
	//��������������������ͼG���Ƿ��л� 
	private void dfs(Digraph G,int v) {
		//�Ѷ���v��ʶΪ������
		marked[v]=true;
		
		//�ѵ�ǰ�����ջ
		onStack[v]=true;
		//�����������
		for(Integer w:G.adj(v)) {
			//�����ǰ���wû�б�������������ݹ����dfs����
			if(!marked[w]) {
				dfs(G,w);
			}
			
			//�жϵ�ǰ����w�Ƿ��Ѿ���ջ�У�����Ѿ���ջ�У�֤����ǰ����֮ǰ��������������״̬����ô������Ҫ����һ�Σ���֤����⵽����
			if(onStack[w]) {
				hasCycle=true;
				return ;
			}
			
		}
		//�õ�ǰ�ڵ��ջ
		onStack[v]=false;
	}
	//�ж�ͼ���Ƿ��л�
	public boolean hasCycle() {
		return hasCycle;
	}
}