package 树;

import java.util.Scanner;

public class UFTest {

	public static void main(String[] args) {
		UF uf=new UF(5);
		System.out.println("默认情况分组个数"+uf.count());
		Scanner in=new Scanner(System.in);
		while(true) {
			System.out.println("请输入第一个要合并的元素");
			int p=in.nextInt();
			System.out.println("请输入第二个要合并的元素");
			int q=in.nextInt();
			
			if(uf.connected(p,q)) {
				System.out.println(p+"元素和"+q+"已经在同一个组中了");
				continue;
			}
			uf.union(p, q);
			System.out.println("当前并查集中还有："+uf.count()+"个分组");
		}

	}

}
