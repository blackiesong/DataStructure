package ds;

import java.util.Iterator;

//�ݹ�Ĳ���ʹ��
public class printList {
	//ʹ�õݹ�
	public static <Anytype> void printList(Iterator<Anytype> itr) {
		if (!itr.hasNext()) {
			return;
		}
		System.out.println(itr.next());
		printList(itr);
	}
	//���õݹ��ӡһ����ķ���
	public static <Anytype> void printList1(Iterator<Anytype> itr){
		while (true) {
			if (!itr.hasNext()) {
				return;
			}
			System.out.println(itr.next());
		}
		
	}
}
