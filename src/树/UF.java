package ��;

public class UF {
	//��¼���Ԫ�غ͸�Ԫ�����ڷ���ı�ʶ
private int[] eleAndGroup;
//��¼���鼯�����ݵķ������
private int count;
//��ʼ�����鼯
public UF(int N) {
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
	return eleAndGroup[p];
}

//�жϲ��鼯��Ԫ��p��Ԫ��q�Ƿ���ͬһ��������
public boolean connected(int p,int q) {
	return find(p)==find(q);
}
//�ϲ�pԪ�غ�qԪ�����ڵķ���
public void union(int p,int q) {
	//�ж�Ԫ��p��q�Ƿ��Ѿ���ͬһ�����У�����Ѿ���ͬһ�����У�����������Ϳ�����
	if(connected(p,q)) {
		return ;
	}
	
	//�ҵ�p���ڷ���ı�ʶ��
	int pgroup=find(p);
	//�ҵ�q���ڷ���ı�ʶ��
	int qgroup=find(q);
    //�ϲ��飬��p�����������Ԫ�ص����ʶ����Ϊq���ڷ���ı�ʶ��
	for(int i=0;i<eleAndGroup.length;i++) {
	if(eleAndGroup[i]==pgroup) {
		eleAndGroup[i]=qgroup;
	}
	}
	//������һ
	this.count--;
}
}
