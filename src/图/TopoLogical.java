package ͼ;

public class TopoLogical {
	//�������������
	private Stack order;
	public TopoLogical(Digraph G) {
		//�ȼ��ͼ����û�л�
		DirectedCircle circle=new DirectedCircle(G);
		//�ж�Gͼ����û�л������û�л�������ж������򣬴���һ�������������
		if(!circle.hasCycle()) {
		DepthFirstOrder depthFirstOrder=new DepthFirstOrder(G);
		order=depthFirstOrder.reversePost();
		}
	}
	//�ж�ͼG�Ƿ��л� 
	public boolean isCycle() {
		return order==null;
	}
	//��ȡ������������ж��� 
	public Stack order() {
		return order;
	}
}
