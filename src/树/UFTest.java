package ��;

import java.util.Scanner;

public class UFTest {

	public static void main(String[] args) {
		UF uf=new UF(5);
		System.out.println("Ĭ������������"+uf.count());
		Scanner in=new Scanner(System.in);
		while(true) {
			System.out.println("�������һ��Ҫ�ϲ���Ԫ��");
			int p=in.nextInt();
			System.out.println("������ڶ���Ҫ�ϲ���Ԫ��");
			int q=in.nextInt();
			
			if(uf.connected(p,q)) {
				System.out.println(p+"Ԫ�غ�"+q+"�Ѿ���ͬһ��������");
				continue;
			}
			uf.union(p, q);
			System.out.println("��ǰ���鼯�л��У�"+uf.count()+"������");
		}

	}

}
