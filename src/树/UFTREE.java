package ��;

public class UFTREE {
		//��¼���Ԫ�غ͸�Ԫ�����ڷ���ı�ʶ
	private int[] eleAndGroup;
	//��¼���鼯�����ݵķ������
	private int count;
	//��ʼ�����鼯
	public UFTREE(int N) {
		//��ʼ�������������Ĭ���������N������
			this.count=N;
			//��ʼ��end����
			this.eleAndGroup=new int [N];
			//��ʼ��eleAndGroup�е�Ԫ�ؼ������ڵ���ı�ʶ��,��eleAndGroup�����������Ϊ���鼯��ÿ���ڵ��Ԫ�أ�������ÿ����������ֵ(��Ԫ��������ı�ʶ��)���Ǹ�����
	        for(int i=0;i<eleAndGroup.length;i++) {
	        	eleAndGroup[i]=i;
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
		//��p�������ĸ��ڵ�ĸ��ڵ�Ϊq�������ĸ��ڵ㼴��
		eleAndGroup[pRoot]=qRoot;
		//������һ
		this.count--;
	}
	
}
