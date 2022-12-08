package ���ȶ���;

public class MaxPriorityQueue<T extends Comparable<T>> {
 
	//�洢���е�Ԫ��
	private T[] items;
	//��¼����Ԫ�صĸ���
	private int N;
	
	public MaxPriorityQueue(int Capacity) {
		this.items=(T[])new Comparable[Capacity+1];
		this.N=0;
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
	//��������i������j��������ֵ
	private void exch(int i,int j) {
		T a=items[i];
		items[i]=items[j];
		items[j]=a;
	}
	//�����в���һ��Ԫ��
	public void insert(T t) {
		items[++N]=t;
		swim(N);
	}
	//ɾ����������Ԫ�أ��������������ֵ
    public T delMax() {
 T max=items[1];
 exch(1,N);
 items[N]=null;
 N--;
 sink(1);
 return max;
    }
    //ʹ���ϸ��㷨��ʹ����k����Ԫ�ض��ڶ��д���һ����ȷ��λ��
    private void swim(int k) {
    	while(k>1) {
    		if(less(k/2,k)) {
    			exch(k/2,k);
    		}
    		
    		k=k/2;
    	}
    }
    //ʹ���³��㷨��ʹ����k����Ԫ���ڶ��д���һ����ȷ��λ��
    private void sink(int k) {
    	while(2*k<=N) {
    		int max;
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
    		if(!less(k,max)) {
    			break;
    		}
    		exch(k,max);
    		k=max;
    	}
    }
	
}
