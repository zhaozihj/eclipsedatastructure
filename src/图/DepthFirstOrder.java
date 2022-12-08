package ͼ;

public class DepthFirstOrder {
	//���������㣬ֵ��ʾ��ǰ�����Ƿ��Ѿ������� 
	private boolean[] marked;
	//ʹ��ջ���洢��������
	private Stack reversePost;
	
	//����һ����⻷���󣬼��ͼG���Ƿ��л�
	public DepthFirstOrder(Digraph G) {
		//��ʼ��marked����
		this.marked=new boolean[G.V()];
		//��ʼ��reversePostջ
		this.reversePost=new Stack<Integer>();
		
		//��ͼ�е�ÿһ��������Ϊһ���������������
		for(int v=0;v<G.V();v++) {
			if(!marked[v]) {
				dfs(G,v);
			}
		}
	}
	//��������������������ɶ�����������
	private void dfs(Digraph G,int v) {
		marked[v]=true;
		for(Integer w:G.adj(v)) {
			if(!marked[w]) {
				dfs(G,w);
			}
		}
		//�ö���v��ջ
		reversePost.push(v);
	}
	//��ȡ������������
	public Stack reversePost() {
		return reversePost;
	}
}
