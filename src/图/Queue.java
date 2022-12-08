package 图;
import java.util.Iterator;


class Queue<T> implements Iterable<T>{
	//记录首节点
	private Node head;
	//记录最后一个结点
	private Node last;
	//记录队列中元素的个数
	private int N;
	
	private class Node{
		public T item;
		public Node next;
		public Node(T item,Node next) {
			this.item=item;
			this.next=next;
		}
	}
	public Queue() {
		this.head=new Node(null,null);
		this.last=null;
		this.N=0;
	}
	//判断当前队列是否为空
	public boolean isEmpty() {
		return N==0;
	}
	//返回队列中元素的个数
	public int size() {
		return N;
	}
	//像队列中插入元素t
	public void enqueue(T t) {
		//当前尾节点为null
		if(last==null) {
			last=new Node(t,null);
			head.next=last;
		}
		else
		{
			//当前尾节点不为null
		//创建新结点
			Node oldlast=last;
		Node newNode =new Node(t,null);
		//将新结点设置为尾节点
		last=newNode;
		//将原本的尾节点指向新结点
		oldlast.next=last;
		}
		//元素个数加一
		N++;
		
	}
	//从队列中拿出一个元素
	public T dequeue() {
		if(isEmpty()) {
		return null;
		}
		//保留原本第一个
		Node oldfirst=head.next;
		//头节点直接指向原本第二个
		head.next=oldfirst.next;
		N--;
		
		//如果队列中的元素删除完了，需要重置last=null
		if(isEmpty()) {
			last=null;
		}
		
		//返回原本第一个
		return oldfirst.item;
		}
	@Override
	public Iterator<T> iterator() {
		return new SIterator();
	}
	private class SIterator implements Iterator{
             private Node n;
             public SIterator() {
            	 this.n=head;
             }
		@Override
		public boolean hasNext() {
			return n.next!=null;
		}

		@Override
		public Object next() {
			n=n.next;
			return n.item;
		}
		
	}
	}
	