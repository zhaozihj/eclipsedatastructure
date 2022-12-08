package 图;

import java.util.Iterator;

class Stack<T> implements Iterable<T>{
	//记录首节点
	private Node head;
	//栈中元素个数
	private int N;
	private class Node{
	public T item;
	public Node next;
	public Node(T item,Node next) {
		this.item=item;
		this.next=next;
	}
	}
	public Stack() {
		//初始化首节点
		this.head=new Node(null,null);
		//初始化栈元素个数
		this.N=0;
	}
	//判断当前栈中的元素个数是否为零
	public boolean isEmpty() {
		return N==0;
	}
	//获取栈中元素的个数
	public int size() {
		return N;
	}
	//将t元素压入栈
	public void push(T t) {
		//创建一个新结点，将新结点插入到首节点和下一个结点之间
	Node newNode=new Node(t,head.next);
	head.next=newNode;
	N++;
	}
	//弹栈
	public T pop() {
		//找到首节点指向第一个结点
		Node old=head.next;
		//如果栈中没有元素
		if(old==null) {
			return null;
		}
		//让首节点直接连要删除结点后面一个节点
		head.next=head.next.next;
		//元素个数减一
		N--;
		//返回那个被弹出的结点
		return old.item;
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
