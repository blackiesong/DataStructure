package ds;

import java.util.Collection;
import java.util.ListIterator;


public interface List<Anytype>extends Collection<Anytype>,java.util.List<Anytype>{
	Anytype get(int idx);
	Anytype set(int idx,Anytype newVal);
	void add(int idx,Anytype x);
	ListIterator<Anytype> listIterator(int pos);
	public static void makelist1(List<Integer> lst,int N) {
		lst.clear();
		for (int i = 0; i < N; i++) {
			lst.add(i);
		}
	}
}


