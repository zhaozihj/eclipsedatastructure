package ��;

public class UF_TREE_WEIGHTED {

		//��¼���Ԫ�غ͸�Ԫ�����ڷ���ı�ʶ
	private int[] eleAndGroup;
	//��¼���鼯�����ݵķ������
	private int count;
	//�����洢ÿһ�����ڵ��Ӧ���б���Ľ�����
	private int[] sz;
	//��ʼ�����鼯
	public UF_TREE_WEIGHTED(int N) {
		//��ʼ�������������Ĭ���������N������
			this.count=N;
			//��ʼ��end����
			this.eleAndGroup=new int [N];
			//��ʼ��eleAndGroup�е�Ԫ�ؼ������ڵ���ı�ʶ��,��eleAndGroup�����������Ϊ���鼯��ÿ���ڵ��Ԫ�أ�������ÿ����������ֵ(��Ԫ��������ı�ʶ��)���Ǹ�����
	        for(int i=0;i<eleAndGroup.length;i++) {
	        	eleAndGroup[i]=i;
	        }
	        this.sz=new int[N];
	        //Ĭ������£�sz��ÿ����������ֵ����1
	        for(int i=0;i<sz.length;i++) {
	        	sz[i]=1;
	        }
	}

	//��ȡ��ǰ���鼯�е������ж��ٸ�����
	public int count() {
		return this.count;
		
	}
	//��ѯp���ڷ���ı�ʶ��
	public int find(int p) {
		while(true) {
			if(p==eleAndGroup[p]) {
				return p;
			}
			
			p=eleAndGroup[p];
		}
	}

	//�жϲ��鼯��Ԫ��p��Ԫ��q�Ƿ���ͬһ��������
	public boolean connected(int p,int q) {
		return find(p)==find(q);
	}
	//�ϲ�pԪ�غ�qԪ�����ڵķ���
	public void union(int p,int q) {

		//�ҵ�p���ڷ���Ķ�Ӧ�ĸ��ڵ�
		int pRoot=find(p);
		//�ҵ�q���ڷ���ĸ��ڵ�
		int qRoot=find(q);
//���p��q�Ѿ���һ������Ͳ��úϲ���
		if(pRoot==qRoot) {
			return ;
		}
		//�ж���pRoot��Ӧ��������qRoot��Ӧ������
		if(sz[pRoot]<sz[qRoot]) {
			eleAndGroup[pRoot]=qRoot;
			sz[qRoot]+=sz[pRoot];
		}
		else
		{
			eleAndGroup[qRoot]=pRoot;
			sz[pRoot]=sz[qRoot];
		}
		//������һ
		this.count--;
	}
	
}


