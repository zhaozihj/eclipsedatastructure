package ���ȶ���;

public class MinPriorityQueue<T extends Comparable<T>>{
	//�洢���е�Ԫ��
	private T[] items;
	//��¼����Ԫ�صĸ���
	private int N;
	
	public MinPriorityQueue (int capacity) {
		this.items=(T[]) new Comparable[capacity+1];
		
	}
	//��ȡ������Ԫ�ظ���
	public int size() {
		return N;
	}
	//�ж϶����Ƿ�Ϊ��
	public boolean isEmpty() {
		return N==0;
	}
	//�ж϶�������i����Ԫ���Ƿ�С������j����Ԫ��
	private boolean less(int i,int j) {
		return items[i].compareTo(items[j])<0;
	}
	//������������i��ֵ������j��ֵ
	private void exch(int i,int j) {
		T a=items[i];
		items[i]=items[j];
		items[j]=a;
	}
	//���������һ��Ԫ��
	public void insert(T t) {
		items[++N]=t;
		swim(N);
	}
	//ɾ��������С��Ԫ�أ������������СԪ��
	public T delMin() {
		T min=items[1];
		exch(1,N);
		items[N]=null;
		N--;
		sink(1);
		return min;
	}
	//ʹ���ϸ��㷨��ʹ����Ϊk��Ԫ���ڶ��д���һ����ȷ��λ��
	public void swim(int k) {
		//ͨ��ѭ���Ƚϵ�ǰ�����丸�ڵ�Ĵ�С
		while(k>1) {
			if(less(k,k/2)) {
				exch(k,k/2);
			}
			k=k/2;
		}
	}
	//ʹ���³��㷨��ʹ����Ϊk��Ԫ���ڶ��д���һ����ȷ��λ��
	public void sink(int k) {
		//ͨ��ѭ���Ƚϵ�ǰ�����ӽ���еĽ�Сֵ
		while(2*k<=N) {
			//�ҵ��ӽ���еĽ�Сֵ
			int min;
			if(2*k+1<=N) {
				if(less(2*k,2*k+1)) {
					min=2*k;
				}
				else {
					min=2*k+1;
				}
			}
			else
			{
				min=2*k;
			}
			
			//�жϵ�ǰ���ͽ�Сֵ�Ĵ�С
			if(less(k,min)) {
				break;
			}
			exch(k,min);
			k=min;
		}
		
		
	}

}
