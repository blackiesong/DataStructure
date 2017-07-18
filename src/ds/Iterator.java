package ds;

public interface Iterator<Anytype> {
	boolean hasNext();
	Anytype next();
	void remove();
	public static <Anytype> void print(Collection<Anytype> coll) {
		java.util.Iterator<Anytype> itr=coll.iterator();
		while (itr.hasNext()) {
			Anytype anytype = (Anytype) itr.next();
			System.out.println(anytype);
		}
	}
}
