package 树;


public class BinaryTree<Key extends Comparable<Key>,Value> {
//记录根结点
private Node root;
//记录树中元素个数
private int N;
private class Node{
	//存储键
	public Key key;
	//存储值
	public Value value;
	//记录左子节点
	public Node left;
	//记录右子节点
	public Node right;
	public Node(Key key,Value value,Node left,Node right) {
		this.key=key;
		this.value=value;
		this.right=right;
	}
}
//获取树中元素的个数
public int size() {
	return N;
}

//向树中添加元素key-value
public void put(Key key,Value value) {
	root=put(root,key,value);
}
//向指定的树中添加key-value，并返回添加元素后的新树
public Node put(Node x,Key key,Value value) {
	//x子树为空
	if(x==null) {
               N++;
		return new Node(key,value,null,null);
	}
	//如果x子树不为空
		//比较x结点的键和key的大小
		int cmp=key.compareTo(x.key);
		if(cmp>0) {
			//如果key大于x结点的键，则继续找x结点右子树
			x.right=put(x.right,key,value);
		}
		else if(cmp<0) {
			//如果key小于x节点的键，则继续找x结点的左子树
			x.left=put(x.left,key,value);
		}
		else
		{
			//如果key等于x结点的键，则替换value
			x.value=value;
		}
		return x;
}
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

//删除树中key对应的value值
public void delete(Key key) {
	delete(root,key);
}
//删除指定树x中的key所对应的value，并返回删除后的新树
public Node delete(Node x,Key key) {
	//x树为null
	
	if(x==null) {
		return null;
	}
	//x树不为null
	//比较key和x结点键的大小
			int cmp=key.compareTo(x.key);
	if(cmp>0) {
		//如果key大于x结点的键，则继续找x结点右子树
		x.right=delete(x.right,key);
	}
	else if(cmp<0) {
		//如果key小于x节点的键，则继续找x结点的左子树
		x.left=delete(x.left,key);
	}
	else
	{
		//让元素个数减一
		N--;
		//得找到x结点右子树中最小的结点
		if(x.right==null) {
			return x.left;//因为是递归所以这个返回值之后在上面会自动给那个被删除结点的父节点
		}
		if(x.left==null) {
		return x.right;//因为是递归所以这个返回值之后在上面会自动给那个被删除结点的父节点
		}
		Node minNode=x.right;
		while(minNode.left!=null) {
		minNode=minNode.left;
		
		}
		//删除右子树中的最小结点
		Node n=x.right;
		while(n.left!=null) {
			//如果n结点的下一个的下一个是空，就将n结点的下一个设为null
		if(n.left.left==null) {
			n.left=null;
		}
		else {
			//变换n结点即可
			n=n.left;
		}
		}
	//让最小结点为被删结点左右结点的父结点
			minNode.right=x.right;
		
			minNode.left=x.left;
		
		//被删结点的父结点为minNode的父节点
		x=minNode;

	}
	return x;//因为是递归所以这个返回值为x也就是minNode之后在上面会自动给那个被删除结点的父节点，到最后返回的就是删除后的新树
}

//找出整个树中找出最小的键
public Key min() {
	return min(root).key;
}
//查找指定树x中找出最小键所在的结点
public Node min(Node x) {
	if(x.left!=null) {
		return min(x.left);
	}
	else
	{
		return x;
	}
}
//找出整个树中最大的键
public Key max() {
	return max(root).key;
}
//查找指定树中的最大键
public Node max(Node x) {
	if(x.right!=null) {
		return min(x.right);
	}
	else
	{
		return x;
	}
}

//前序遍历
//获取整个树中的所有键
public Queue<Key> preErgodic(){
	Queue<Key> keys=new Queue<Key>();
	preErgodic(root,keys);
	return keys;
}
//获取指定树所有的键放到keys
private void preErgodic(Node x,Queue<Key> keys) {
	if(x==null) {
		return;
	}
	//把x结点的key放入到keys中
	keys.enqueue(x.key);
	//递归遍历x结点的左子树
	if(x.left!=null) {
		preErgodic(x.left,keys);
	}
	//递归遍历x结点的右子树
	if(x.right!=null) {
		preErgodic(x.right,keys);
	}
} 


public Queue<Key> midErgodic(){
	Queue<Key> keys=new Queue<Key>();
	midErgodic(root,keys);
	return keys;
}

//中序遍历
private void midErgodic(Node x,Queue<Key> keys) {
	if(x==null) {
		return;
	}
	//递归遍历x结点的左子树
		if(x.left!=null) {
			midErgodic(x.left,keys);
		}
		//把x结点的key放入到keys中
		keys.enqueue(x.key);
		//递归遍历x结点的右子树
		if(x.right!=null) {
			midErgodic(x.right,keys);
		}
}
//后序遍历
public Queue<Key> lastErgodic(){
	Queue<Key> keys=new Queue<Key>();
	lastErgodic(root,keys);
	return keys;
}

private void lastErgodic(Node x,Queue<Key> keys) {
	if(x==null) {
		return;
	}
	//递归遍历x结点的左子树
		if(x.left!=null) {
			lastErgodic(x.left,keys);
		}
		//递归遍历x结点的右子树
		if(x.right!=null) {
			lastErgodic(x.right,keys);
		}
		//把x结点的key放入到keys中
		keys.enqueue(x.key);
	
}
//层序遍历
public Queue<Key> layerErgodic(){
	//定义两个队列，分别存储树中的键和树中的结点
	Queue<Key> keys=new Queue<>();
	Queue<Node> nodes=new Queue<>();
	
	//默认往结点队列中放入根节点
	nodes.enqueue(root);
	while(!nodes.isEmpty()) {
		//从队列中弹出一个结点
		Node n=nodes.dequeue();
		keys.enqueue(n.key);
		//判断当前结点有没有左子节点，有则放入nodes中
		if(n.left!=null) {
			nodes.enqueue(n.left);
		}
		//判断当前结点有没有右子节点，有则放入nodes中
	    if(n.right!=null) {
	    	nodes.enqueue(n.right);
	    }
	}
	return keys;
}

//计算整个树的最大深度
public int maxDepth() {
	return maxDepth(root);
}

//获取指定树x的最大深度
public int maxDepth(Node x) {
	if(x==null) {
		return 0;
	}
	int max=0;//这是x的最大深度
	int maxl=0;//这是x的左子树的最大深度
	int maxR=0;//这是x的右子树的最大深度
	
	//计算x结点左子树的最大深度
	if(x.left!=null) {
		maxl=maxDepth(x.left);
	}
	//计算x结点右子树最大深度
	if(x.right!=null) {
		maxR=maxDepth(x.right);
	}
	//比较左子树最大深度和右子树最大深度，取较大值+1即可
	max=maxl>maxR?maxl+1:maxR+1;
	return max;
	
}


}
