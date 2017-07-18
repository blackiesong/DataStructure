package ds;

import java.util.Iterator;



public interface Collection<Anytype> extends Iterable<Anytype> {
	int size();
	boolean isEmpty();
	void clear();
	boolean contains(Anytype x);
	boolean add(Anytype x);
	boolean remove(Anytype x);
	Iterator<Anytype> iterator();
	public static <Anytype> void print(Collection<Anytype> coll) {
		for (Anytype item : coll) {
			System.out.println(item);
		}
	}
}
