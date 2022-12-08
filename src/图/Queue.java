package ͼ;
import java.util.Iterator;


class Queue<T> implements Iterable<T>{
	//��¼�׽ڵ�
	private Node head;
	//��¼���һ�����
	private Node last;
	//��¼������Ԫ�صĸ���
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
	//�жϵ�ǰ�����Ƿ�Ϊ��
	public boolean isEmpty() {
		return N==0;
	}
	//���ض�����Ԫ�صĸ���
	public int size() {
		return N;
	}
	//������в���Ԫ��t
	public void enqueue(T t) {
		//��ǰβ�ڵ�Ϊnull
		if(last==null) {
			last=new Node(t,null);
			head.next=last;
		}
		else
		{
			//��ǰβ�ڵ㲻Ϊnull
		//�����½��
			Node oldlast=last;
		Node newNode =new Node(t,null);
		//���½������Ϊβ�ڵ�
		last=newNode;
		//��ԭ����β�ڵ�ָ���½��
		oldlast.next=last;
		}
		//Ԫ�ظ�����һ
		N++;
		
	}
	//�Ӷ������ó�һ��Ԫ��
	public T dequeue() {
		if(isEmpty()) {
		return null;
		}
		//����ԭ����һ��
		Node oldfirst=head.next;
		//ͷ�ڵ�ֱ��ָ��ԭ���ڶ���
		head.next=oldfirst.next;
		N--;
		
		//��������е�Ԫ��ɾ�����ˣ���Ҫ����last=null
		if(isEmpty()) {
			last=null;
		}
		
		//����ԭ����һ��
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
	