package ͼ;


public class DepthFirstPaths {
//���������㣬ֵ��ʾ��ǰ�����Ƿ��Ѿ������� 
	private boolean[] marked;
	//���
	private int s;
	//���������㣬ֵ��������s����ǰ����·���ϵ����һ������
	private int[] edgeTo;
	
	//
	public DepthFirstPaths(Graph G,int s) {
	//��ʼ��marked����
		this.marked=new boolean[G.V()];
		//��ʼ��s���
		this.s=s;
		//��ʼ��edgeTo����
	    this.edgeTo=new int[G.V()];
	    dfs(G,s);
	}
	
	//ʹ��������������ҳ�Gͼ��v�����������ͨ���� 
	private void dfs(Graph G,int v) {
		//��v��ʶΪ������
		marked[v]=true;
		
		//ͨ������v���ڽӱ��õ�ÿһ�����ڵĶ��㣬������������
		for(Integer w:G.adj(v)) {
			
			//���wû�б�����������ݹ�����
			if(!marked[w]) {
				edgeTo[w]=v;//���ﶥ��w·���ϵ����һ��������v,ͨ��v�ҵ�w��
				dfs(G,w);
			}
		}
	}
	
	//�ж�v������s�����Ƿ����·�� 
	private boolean hasPathTo(int v) {
		return marked[v];
	}
	
	//�ҳ������s������v��·��(���Ǹ�·�������Ķ���)
      public Stack<Integer> pathTo(int v){
    	  if(!hasPathTo(v)) {
    		  return null;
    	  }
    	  //����ջ���󣬱���·���е����ж���
    	  Stack<Integer> path=new Stack<>();
    	  
    	  //ͨ��ѭ�����Ӷ���v��ʼ��һֱ��ǰ���ҵ����Ϊֹ
    	  for(int x=v;x!=s;x=edgeTo[x]) {
    		  path.push(x);
    	  }
    	  //�����s�ŵ�ջ��
    	  path.push(s);
    	  return path;
      }

} 
