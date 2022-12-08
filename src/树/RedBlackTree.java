package 树;

public class RedBlackTree <Key extends Comparable<Key>,Value> {
//根节点
	private Node root;
	//记录树中元素的个数
	private int N;
	//红色链接
	private static final boolean RED=true;
	//黑色链接
	private static final boolean BLACK=false;
	
	//结点类
	private class Node{
		//存储键
		public Key key;
		//存储值
		public Value value;
		//记录左子节点
		public Node left;
		//记录右子结点
		public Node right;
		//由其父节点指向它的链接的颜色
		public boolean color;
		public Node(Key key,Value value,Node left,Node right,boolean color) {
			this.key=key;
			this.value=value;
			this.left=left;
			this.right=right;
			this.color=color;
		}
	}
	
	//获取树中元素的个数
	public int size() {
	return N;
	}
	
	//判断当前结点的父节点指向链接是否为红色
	private boolean isRed(Node x) {
		if(x==null) {
			return false;
		}
		return x.color==RED;
	}
	//左旋
	private Node rotateleft(Node h) {
		//获取h结点的右子节点，表示为x
		Node x=h.right;
		//让x结点的左子节点称为h节点的右子结点
	      h.right=x.left;
		//让h称为x的左子节点
		x.left=h;
		//让x节点的color属性等于h结点的color属性
		x.color=h.color;
		//让h结点的color属性变为红色
		h.color=RED;
		return x;
	}
	//右旋
	private Node rotateright(Node h) {
		//获取h结点的左子结点，表示为x
		Node x=h.left;
		//让x节点的右子节点为h的左子节点
		h.left=x.right;
		//让h节点成为x节点的右子结点
		x.right=h;
		//让x结点的color属性等于h节点的color属性
		x.color=h.color;
		//让h节点的color属性为红色
		h.color=RED;
		return x;
	}
	
	//颜色反转，左右子结点是黑色，当前节点是红色
	private void flipColor(Node n) {
		n.left.color=BLACK;
		n.right.color=BLACK;
		n.color=RED;
	}
	public void put(Key key,Value value) {

		root=put(root,key,value);
		//根节点的颜色总是黑色的
		root.color=BLACK;
	}
	/*
	 * 在指定树中完成插入操作，并返回添加元素后新的树
	 */
	private Node put(Node h,Key key,Value val) {
		//判断h是否为空
		if(h==null) {
			//数量加一
			N++;
			return new Node(key,val,null,null,RED);
		}
		//不为空就得去比较h节点的键和key的大小
		int cmp=key.compareTo(h.key);
		if(cmp<0) {
			//小于零，继续往左
			h.left=put(h.left,key,val);
		}
		else if(cmp>0)
		{
			//大于零继续往右
			h.right=put(h.right,key,val);
		}
		else
		{
			//等于零,进行替换
			h.value=val;
		}
       //进行左旋，当当前结点h的左子节点为黑色，右子结点为红色，需要左旋
		if(isRed(h.right)&&!isRed(h.left)) {
			h=rotateleft(h);
		}
		//进行右旋，当当前结点h的左子节点，和左子节点的左子节点都为红色需要右旋
		if(isRed(h.left)&&isRed(h.left.left)) {
			h=rotateright(h);
		}
		//颜色反转当前结点的左右子结点都为红色
		
		if(isRed(h.left)&&isRed(h.right)) {
			flipColor(h);
		}
		return h;
		
	}
	//这个查找方法和二叉查找树一摸一样
	//查询树中指定key对应的value
	public Value get(Key key) {
		return get(root,key);
	}
	//从指定的树x中，查找key对应的值
	public Value get(Node x,Key key) {
		//x树为null
		if(x==null) {
			return null;
		}
		//x树不为null
		//比较key和x结点键的大小
		int cmp=key.compareTo(x.key);
		if(cmp>0) {
			//如果key大于x结点的键，则继续找x结点右子树
			return get(x.right,key);
		}
		else if(cmp<0) {
			//如果key小于x节点的键，则继续找x结点的左子树
			return get(x.left,key);
		}
		else
		{
			//如果key等于x结点的键，就找到了key的结点，只需要返回x结点的值即可
			return x.value;
		}
	}
	
}
