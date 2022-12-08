package 堆;

public class Heap<T extends Comparable<T>> {
	//存放堆中的元素
	private T[] item;
	//堆中元素的个数
	private int N;
	//构造方法，生成元素个数为capacity的堆
	public Heap(int capacity) {
	item=(T[])new Comparable[capacity+1];//不能直接定义一个泛型数组，要用这钟强转形式,同时T类继承Comparable所以应该这样，而且0被弃用，所以要capacity+1
	this.N=0;
	}
	//判断堆中索引i处的元素是否小于索引j处的值
	private boolean less(int i,int j) {
		return item[i].compareTo(item[j])<0;
	}
	//交换堆中i索引和j索引的值
	private void exch(int i,int j) {
		T a;
		a=item[i];
		item[i]=item[j];
		item[j]=a;
	}
	//往堆中插入一个元素
	public void insert(T t) {
		item[++N]=t;
		swim(N);//因为新加进去之后在最后所以一定是上浮
	}
	//使用上浮算法，使索引k处的元素能在堆中处于一个正确的位置
	private void swim(int k) {
		//通过循环不断比较当前结点和其父结点的值，如果发现父结点比当前结点的值小就交换
		while(k>1) {
			//比较当前结点和其父节点
			if(less(k/2,k)) {
				exch(k/2,k);
			}
			k=k/2;
		}
	}
	//删除堆中最大的元素，并返回这个最大的元素
	public T delMax() {
		T max =item[1];//记录被删除的最大值
		//让根节点和最大索引处的结点y交换位置
		exch(1,N);
		//让现在的最大索引处指向null
		item[N]=null;
		//元素个数-1
		N--;
		//通过下沉算法，让堆重新有序
		sink(1);
		return max;
		
	}
	
	//使用下沉算法，使索引k处的元素能在堆中处于一个正确的位置
	private void sink(int k) {
		//通过循环不断对比当前k结点和其左子节点2k和右子节点2k+1处的元素大小，如果当前结点小，则需要交换位置
		while(2*k<=N) {
			//获取当前子节点中的较大值
			int max=0;//记录较大子结点所在的索引
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
			//比较当前结点和较大子节点的值,因为k是从最底下弄上来的，所以不存在它比一个子节点大比另一个子节点小的情况
			if(less(max,k)) {
				break;
			}
			//交换k索引处的键和max索引处的位置
			exch(k,max);
			//变换k的值
			k=max;
		}
	}


}
