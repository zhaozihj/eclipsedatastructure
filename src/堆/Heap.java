package ��;

public class Heap<T extends Comparable<T>> {
	//��Ŷ��е�Ԫ��
	private T[] item;
	//����Ԫ�صĸ���
	private int N;
	//���췽��������Ԫ�ظ���Ϊcapacity�Ķ�
	public Heap(int capacity) {
	item=(T[])new Comparable[capacity+1];//����ֱ�Ӷ���һ���������飬Ҫ������ǿת��ʽ,ͬʱT��̳�Comparable����Ӧ������������0�����ã�����Ҫcapacity+1
	this.N=0;
	}
	//�ж϶�������i����Ԫ���Ƿ�С������j����ֵ
	private boolean less(int i,int j) {
		return item[i].compareTo(item[j])<0;
	}
	//��������i������j������ֵ
	private void exch(int i,int j) {
		T a;
		a=item[i];
		item[i]=item[j];
		item[j]=a;
	}
	//�����в���һ��Ԫ��
	public void insert(T t) {
		item[++N]=t;
		swim(N);//��Ϊ�¼ӽ�ȥ֮�����������һ�����ϸ�
	}
	//ʹ���ϸ��㷨��ʹ����k����Ԫ�����ڶ��д���һ����ȷ��λ��
	private void swim(int k) {
		//ͨ��ѭ�����ϱȽϵ�ǰ�����丸����ֵ��������ָ����ȵ�ǰ����ֵС�ͽ���
		while(k>1) {
			//�Ƚϵ�ǰ�����丸�ڵ�
			if(less(k/2,k)) {
				exch(k/2,k);
			}
			k=k/2;
		}
	}
	//ɾ����������Ԫ�أ��������������Ԫ��
	public T delMax() {
		T max =item[1];//��¼��ɾ�������ֵ
		//�ø��ڵ������������Ľ��y����λ��
		exch(1,N);
		//�����ڵ����������ָ��null
		item[N]=null;
		//Ԫ�ظ���-1
		N--;
		//ͨ���³��㷨���ö���������
		sink(1);
		return max;
		
	}
	
	//ʹ���³��㷨��ʹ����k����Ԫ�����ڶ��д���һ����ȷ��λ��
	private void sink(int k) {
		//ͨ��ѭ�����϶Աȵ�ǰk���������ӽڵ�2k�����ӽڵ�2k+1����Ԫ�ش�С�������ǰ���С������Ҫ����λ��
		while(2*k<=N) {
			//��ȡ��ǰ�ӽڵ��еĽϴ�ֵ
			int max=0;//��¼�ϴ��ӽ�����ڵ�����
			if(2*k+1<=N) {
				if(less(2*k,2*k+1)) {
					max=2*k+1;
				}
				else
				{
					max=2*k;
				}
			}
			else
			{
				max=2*k;
			}
			//�Ƚϵ�ǰ���ͽϴ��ӽڵ��ֵ,��Ϊk�Ǵ������Ū�����ģ����Բ���������һ���ӽڵ�����һ���ӽڵ�С�����
			if(less(max,k)) {
				break;
			}
			//����k�������ļ���max��������λ��
			exch(k,max);
			//�任k��ֵ
			k=max;
		}
	}


}
