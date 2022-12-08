package ��;

public class HeapSort {
//�ж�heap��������i����Ԫ���Ƿ�С������j����Ԫ��
	private static boolean less(Comparable[] heap,int i,int j) {
		return heap[i].compareTo(heap[j])<0;
	}
	//����heap����i������j��������ֵ
	private static void exch(Comparable[] heap,int i,int j) {
		Comparable temp=heap[i];
		heap[i]=heap[j];
		heap[j]=temp;
	}
	//����ԭ����source�����ɳ���heap
	private static void createHeap(Comparable[] source,Comparable[] heap) {
		//��source�е�Ԫ�ؿ�����heap�У�heap�е�Ԫ�ؾ��γ�һ������Ķ�
		System.arraycopy(source,0, heap, 1, source.length);
		//�Զ��е�Ԫ�����³��������ӳ��ȵ�һ�봦��ʼ������1��ɨ�裩
		for(int i=source.length/2;i>0;i--) {
			sink(heap,i,heap.length-1);
		}
	}
	//��source�����е����ݴ�С��������
	public static void sort(Comparable[] source) {
		//�ö�������Ԫ�غ�δ��������һ������
		//������
         Comparable []heap=new Comparable[source.length+1];//0����������
		createHeap(source,heap);
		//����һ����������¼δ�����Ԫ�����������
		int N=heap.length-1;
		//ͨ��ѭ������1������δ�����Ԫ���������������Ԫ�ؽ���
		while(N!=1) {
			exch(heap,1,N);
			//�ų����������Ԫ�����ڵ�����������Ҫ����ѵ��³�����
			N--;
			//������1����Ԫ�ؽ����³�����
			sink(heap,1,N);
		}
         //��heap�е����ݸ��Ƶ�ԭ������
		System.arraycopy(heap,1,source,0,source.length);
		

	}
	//��heap���У���target����Ԫ�����³�����Χ��0-range
	private static void sink(Comparable[] heap,int target,int range) {
		while(2*target<=range) {
			//������û�����ӽ����whileѭ��������������������û��     û���ӽڵ�����
			//1.�ҳ���ǰ���Ľϴ���ӽ��
			    int max;
			    if(2*target+1<=range) {
			    	if(less(heap,2*target,2*target+1)) {
			    		max=2*target+1;
			    	}
			    	else
			    	{
			    		max=2*target;
			    	}
			    }else
			    {
			    	max=2*target;
			    }
			//2.�Ƚϵ�ǰ����ֵ�ͽϴ��ӽ���ֵ
			if(less(heap,max,target)) {
				break;
			}
			exch(heap,target,max);
			target=max;
			}
	}
	
}
