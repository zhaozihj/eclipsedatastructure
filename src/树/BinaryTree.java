package ��;


public class BinaryTree<Key extends Comparable<Key>,Value> {
//��¼�����
private Node root;
//��¼����Ԫ�ظ���
private int N;
private class Node{
	//�洢��
	public Key key;
	//�洢ֵ
	public Value value;
	//��¼���ӽڵ�
	public Node left;
	//��¼���ӽڵ�
	public Node right;
	public Node(Key key,Value value,Node left,Node right) {
		this.key=key;
		this.value=value;
		this.right=right;
	}
}
//��ȡ����Ԫ�صĸ���
public int size() {
	return N;
}

//���������Ԫ��key-value
public void put(Key key,Value value) {
	root=put(root,key,value);
}
//��ָ�����������key-value�����������Ԫ�غ������
public Node put(Node x,Key key,Value value) {
	//x����Ϊ��
	if(x==null) {
               N++;
		return new Node(key,value,null,null);
	}
	//���x������Ϊ��
		//�Ƚ�x���ļ���key�Ĵ�С
		int cmp=key.compareTo(x.key);
		if(cmp>0) {
			//���key����x���ļ����������x���������
			x.right=put(x.right,key,value);
		}
		else if(cmp<0) {
			//���keyС��x�ڵ�ļ����������x����������
			x.left=put(x.left,key,value);
		}
		else
		{
			//���key����x���ļ������滻value
			x.value=value;
		}
		return x;
}
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

//ɾ������key��Ӧ��valueֵ
public void delete(Key key) {
	delete(root,key);
}
//ɾ��ָ����x�е�key����Ӧ��value��������ɾ���������
public Node delete(Node x,Key key) {
	//x��Ϊnull
	
	if(x==null) {
		return null;
	}
	//x����Ϊnull
	//�Ƚ�key��x�����Ĵ�С
			int cmp=key.compareTo(x.key);
	if(cmp>0) {
		//���key����x���ļ����������x���������
		x.right=delete(x.right,key);
	}
	else if(cmp<0) {
		//���keyС��x�ڵ�ļ����������x����������
		x.left=delete(x.left,key);
	}
	else
	{
		//��Ԫ�ظ�����һ
		N--;
		//���ҵ�x�������������С�Ľ��
		if(x.right==null) {
			return x.left;//��Ϊ�ǵݹ������������ֵ֮����������Զ����Ǹ���ɾ�����ĸ��ڵ�
		}
		if(x.left==null) {
		return x.right;//��Ϊ�ǵݹ������������ֵ֮����������Զ����Ǹ���ɾ�����ĸ��ڵ�
		}
		Node minNode=x.right;
		while(minNode.left!=null) {
		minNode=minNode.left;
		
		}
		//ɾ���������е���С���
		Node n=x.right;
		while(n.left!=null) {
			//���n������һ������һ���ǿգ��ͽ�n������һ����Ϊnull
		if(n.left.left==null) {
			n.left=null;
		}
		else {
			//�任n��㼴��
			n=n.left;
		}
		}
	//����С���Ϊ��ɾ������ҽ��ĸ����
			minNode.right=x.right;
		
			minNode.left=x.left;
		
		//��ɾ���ĸ����ΪminNode�ĸ��ڵ�
		x=minNode;

	}
	return x;//��Ϊ�ǵݹ������������ֵΪxҲ����minNode֮����������Զ����Ǹ���ɾ�����ĸ��ڵ㣬����󷵻صľ���ɾ���������
}

//�ҳ����������ҳ���С�ļ�
public Key min() {
	return min(root).key;
}
//����ָ����x���ҳ���С�����ڵĽ��
public Node min(Node x) {
	if(x.left!=null) {
		return min(x.left);
	}
	else
	{
		return x;
	}
}
//�ҳ������������ļ�
public Key max() {
	return max(root).key;
}
//����ָ�����е�����
public Node max(Node x) {
	if(x.right!=null) {
		return min(x.right);
	}
	else
	{
		return x;
	}
}

//ǰ�����
//��ȡ�������е����м�
public Queue<Key> preErgodic(){
	Queue<Key> keys=new Queue<Key>();
	preErgodic(root,keys);
	return keys;
}
//��ȡָ�������еļ��ŵ�keys
private void preErgodic(Node x,Queue<Key> keys) {
	if(x==null) {
		return;
	}
	//��x����key���뵽keys��
	keys.enqueue(x.key);
	//�ݹ����x����������
	if(x.left!=null) {
		preErgodic(x.left,keys);
	}
	//�ݹ����x����������
	if(x.right!=null) {
		preErgodic(x.right,keys);
	}
} 


public Queue<Key> midErgodic(){
	Queue<Key> keys=new Queue<Key>();
	midErgodic(root,keys);
	return keys;
}

//�������
private void midErgodic(Node x,Queue<Key> keys) {
	if(x==null) {
		return;
	}
	//�ݹ����x����������
		if(x.left!=null) {
			midErgodic(x.left,keys);
		}
		//��x����key���뵽keys��
		keys.enqueue(x.key);
		//�ݹ����x����������
		if(x.right!=null) {
			midErgodic(x.right,keys);
		}
}
//�������
public Queue<Key> lastErgodic(){
	Queue<Key> keys=new Queue<Key>();
	lastErgodic(root,keys);
	return keys;
}

private void lastErgodic(Node x,Queue<Key> keys) {
	if(x==null) {
		return;
	}
	//�ݹ����x����������
		if(x.left!=null) {
			lastErgodic(x.left,keys);
		}
		//�ݹ����x����������
		if(x.right!=null) {
			lastErgodic(x.right,keys);
		}
		//��x����key���뵽keys��
		keys.enqueue(x.key);
	
}
//�������
public Queue<Key> layerErgodic(){
	//�����������У��ֱ�洢���еļ������еĽ��
	Queue<Key> keys=new Queue<>();
	Queue<Node> nodes=new Queue<>();
	
	//Ĭ�����������з�����ڵ�
	nodes.enqueue(root);
	while(!nodes.isEmpty()) {
		//�Ӷ����е���һ�����
		Node n=nodes.dequeue();
		keys.enqueue(n.key);
		//�жϵ�ǰ�����û�����ӽڵ㣬�������nodes��
		if(n.left!=null) {
			nodes.enqueue(n.left);
		}
		//�жϵ�ǰ�����û�����ӽڵ㣬�������nodes��
	    if(n.right!=null) {
	    	nodes.enqueue(n.right);
	    }
	}
	return keys;
}

//������������������
public int maxDepth() {
	return maxDepth(root);
}

//��ȡָ����x��������
public int maxDepth(Node x) {
	if(x==null) {
		return 0;
	}
	int max=0;//����x��������
	int maxl=0;//����x����������������
	int maxR=0;//����x����������������
	
	//����x�����������������
	if(x.left!=null) {
		maxl=maxDepth(x.left);
	}
	//����x���������������
	if(x.right!=null) {
		maxR=maxDepth(x.right);
	}
	//�Ƚ������������Ⱥ������������ȣ�ȡ�ϴ�ֵ+1����
	max=maxl>maxR?maxl+1:maxR+1;
	return max;
	
}


}
