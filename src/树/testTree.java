package 树;

public class testTree {

	public static void main(String[] args) {
		//创建二叉查找对象
		BinaryTree<String,String> tree=new BinaryTree<>();
		tree.put("E", "5");
		tree.put("B", "2");
		tree.put("G", "7");
		tree.put("A", "1");
		tree.put("D", "4");
		tree.put("F", "6");
		tree.put("H", "8");
		tree.put("C", "3");

System.out.println(tree.maxDepth());

}}
