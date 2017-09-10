package ds;

public class Binarynod<Anytype> {
	public Binarynod(Anytype theElement) {
		// TODO Auto-generated constructor stub
		this(theElement,null,null);
	}
	public Binarynod(Anytype theElement,Binarynod<Anytype> lt,Binarynod<Anytype> rt) {
		element=theElement;
		left=lt;
		right=rt;

}
	Anytype element;
	Binarynod<Anytype> left;
	Binarynod<Anytype> right;
}
