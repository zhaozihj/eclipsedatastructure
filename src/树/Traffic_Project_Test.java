package ��;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Traffic_Project_Test {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new FileReader("D:\\�����߰���\\a.txt"));
		//��������
		int number=Integer.parseInt(br.readLine());
		UF_TREE_WEIGHTED uf=new UF_TREE_WEIGHTED(number);
		//·������
		int roadNumber=Integer.parseInt(br.readLine());
		//ѭ����ȡ�Ѿ��޽��õĵ�·��������union����
		for(int i=0;i<roadNumber;i++) {
			String line = br.readLine();
			int p = Integer.parseInt(line.split(" ")[0]);
			int q = Integer.parseInt(line.split(" ")[1]);
			uf.union(p,q);

		}
		//��ȡʣ��ķ�������
		int groupNumber = uf.count();
		//���������Ҫ�޽��ĵ�·
		System.out.println("����Ҫ�޽�"+(groupNumber-1)+"��·�����в�����ͨ");


	}

}
