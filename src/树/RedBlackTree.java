package ��;

public class RedBlackTree <Key extends Comparable<Key>,Value> {
//���ڵ�
	private Node root;
	//��¼����Ԫ�صĸ���
	private int N;
	//��ɫ����
	private static final boolean RED=true;
	//��ɫ����
	private static final boolean BLACK=false;
	
	//�����
	private class Node{
		//�洢��
		public Key key;
		//�洢ֵ
		public Value value;
		//��¼���ӽڵ�
		public Node left;
		//��¼���ӽ��
		public Node right;
		//���丸�ڵ�ָ���������ӵ���ɫ
		public boolean color;
		public Node(Key key,Value value,Node left,Node right,boolean color) {
			this.key=key;
			this.value=value;
			this.left=left;
			this.right=right;
			this.color=color;
		}
	}
	
	//��ȡ����Ԫ�صĸ���
	public int size() {
	return N;
	}
	
	//�жϵ�ǰ���ĸ��ڵ�ָ�������Ƿ�Ϊ��ɫ
	private boolean isRed(Node x) {
		if(x==null) {
			return false;
		}
		return x.color==RED;
	}
	//����
	private Node rotateleft(Node h) {
		//��ȡh�������ӽڵ㣬��ʾΪx
		Node x=h.right;
		//��x�������ӽڵ��Ϊh�ڵ�����ӽ��
	      h.right=x.left;
		//��h��Ϊx�����ӽڵ�
		x.left=h;
		//��x�ڵ��color���Ե���h����color����
		x.color=h.color;
		//��h����color���Ա�Ϊ��ɫ
		h.color=RED;
		return x;
	}
	//����
	private Node rotateright(Node h) {
		//��ȡh�������ӽ�㣬��ʾΪx
		Node x=h.left;
		//��x�ڵ�����ӽڵ�Ϊh�����ӽڵ�
		h.left=x.right;
		//��h�ڵ��Ϊx�ڵ�����ӽ��
		x.right=h;
		//��x����color���Ե���h�ڵ��color����
		x.color=h.color;
		//��h�ڵ��color����Ϊ��ɫ
		h.color=RED;
		return x;
	}
	
	//��ɫ��ת�������ӽ���Ǻ�ɫ����ǰ�ڵ��Ǻ�ɫ
	private void flipColor(Node n) {
		n.left.color=BLACK;
		n.right.color=BLACK;
		n.color=RED;
	}
	public void put(Key key,Value value) {

		root=put(root,key,value);
		//���ڵ����ɫ���Ǻ�ɫ��
		root.color=BLACK;
	}
	/*
	 * ��ָ��������ɲ�����������������Ԫ�غ��µ���
	 */
	private Node put(Node h,Key key,Value val) {
		//�ж�h�Ƿ�Ϊ��
		if(h==null) {
			//������һ
			N++;
			return new Node(key,val,null,null,RED);
		}
		//��Ϊ�վ͵�ȥ�Ƚ�h�ڵ�ļ���key�Ĵ�С
		int cmp=key.compareTo(h.key);
		if(cmp<0) {
			//С���㣬��������
			h.left=put(h.left,key,val);
		}
		else if(cmp>0)
		{
			//�������������
			h.right=put(h.right,key,val);
		}
		else
		{
			//������,�����滻
			h.value=val;
		}
       //��������������ǰ���h�����ӽڵ�Ϊ��ɫ�����ӽ��Ϊ��ɫ����Ҫ����
		if(isRed(h.right)&&!isRed(h.left)) {
			h=rotateleft(h);
		}
		//��������������ǰ���h�����ӽڵ㣬�����ӽڵ�����ӽڵ㶼Ϊ��ɫ��Ҫ����
		if(isRed(h.left)&&isRed(h.left.left)) {
			h=rotateright(h);
		}
		//��ɫ��ת��ǰ���������ӽ�㶼Ϊ��ɫ
		
		if(isRed(h.left)&&isRed(h.right)) {
			flipColor(h);
		}
		return h;
		
	}
	//������ҷ����Ͷ��������һ��һ��
	//��ѯ����ָ��key��Ӧ��value
	public Value get(Key key) {
		return get(root,key);
	}
	//��ָ������x�У�����key��Ӧ��ֵ
	public Value get(Node x,Key key) {
		//x��Ϊnull
		if(x==null) {
			return null;
		}
		//x����Ϊnull
		//�Ƚ�key��x�����Ĵ�С
		int cmp=key.compareTo(x.key);
		if(cmp>0) {
			//���key����x���ļ����������x���������
			return get(x.right,key);
		}
		else if(cmp<0) {
			//���keyС��x�ڵ�ļ����������x����������
			return get(x.left,key);
		}
		else
		{
			//���key����x���ļ������ҵ���key�Ľ�㣬ֻ��Ҫ����x����ֵ����
			return x.value;
		}
	}
	
}
