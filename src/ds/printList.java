package ds;

import java.util.Iterator;

//递归的不当使用
public class printList {
	//使用递归
	public static <Anytype> void printList(Iterator<Anytype> itr) {
		if (!itr.hasNext()) {
			return;
		}
		System.out.println(itr.next());
		printList(itr);
	}
	//不用递归打印一个表的方法
	public static <Anytype> void printList1(Iterator<Anytype> itr){
		while (true) {
			if (!itr.hasNext()) {
				return;
			}
			System.out.println(itr.next());
		}
		
	}
}
