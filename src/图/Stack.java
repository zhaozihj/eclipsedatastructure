package ͼ;

import java.util.Iterator;

class Stack<T> implements Iterable<T>{
	//��¼�׽ڵ�
	private Node head;
	//ջ��Ԫ�ظ���
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
		//��ʼ���׽ڵ�
		this.head=new Node(null,null);
		//��ʼ��ջԪ�ظ���
		this.N=0;
	}
	//�жϵ�ǰջ�е�Ԫ�ظ����Ƿ�Ϊ��
	public boolean isEmpty() {
		return N==0;
	}
	//��ȡջ��Ԫ�صĸ���
	public int size() {
		return N;
	}
	//��tԪ��ѹ��ջ
	public void push(T t) {
		//����һ���½�㣬���½����뵽�׽ڵ����һ�����֮��
	Node newNode=new Node(t,head.next);
	head.next=newNode;
	N++;
	}
	//��ջ
	public T pop() {
		//�ҵ��׽ڵ�ָ���һ�����
		Node old=head.next;
		//���ջ��û��Ԫ��
		if(old==null) {
			return null;
		}
		//���׽ڵ�ֱ����Ҫɾ��������һ���ڵ�
		head.next=head.next.next;
		//Ԫ�ظ�����һ
		N--;
		//�����Ǹ��������Ľ��
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
