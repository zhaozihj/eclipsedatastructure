package ͼ;

public class TopLogicalTest {

	public static void main(String[] args) {
		//׼������ͼ
		Digraph digraph=new Digraph(6);
		digraph.addEdge(0, 2);
		digraph.addEdge(0, 3);
		digraph.addEdge(2, 4);
		digraph.addEdge(3, 4);
		digraph.addEdge(4, 5);
		digraph.addEdge(1,3);
		//ͨ��TopoLogical���������ͼ�еĶ����������
		TopoLogical topological=new TopoLogical(digraph);
		//��ȡ������������У����д�ӡ�Ϳ�����
         Stack<Integer> order=topological.order();
         for(Integer s:order) {
        	 System.out.println(s);
         }
	}

}
