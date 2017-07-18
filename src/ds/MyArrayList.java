package ds;

public class MyArrayList<Anytype> implements Iterable<Anytype> {
	private static final int DEFAULT_CAPACITY=10;
//	把大小及数组作为其数据成员进行存储
	private int theSize;
	private Anytype[] theItems;
	private void doClear(){
		theSize=0;
		ensureCapacity(DEFAULT_CAPACITY);
	}
	
	public void ensureCapacity(int newCapacity){
		if (newCapacity<theSize) {
			return;
		}
//		存储对原始数组的一个引用
		Anytype[] old=theItems;
//		为新数组分配内存
		theItems=(Anytype[])new Object[newCapacity];
//		将就内容拷贝到新数组中
		for (int i = 0; i < size(); i++) {
			theItems[i]=old[i];
		}
	}
	public int size(){
		return theSize;
	}
	public MyArrayList(){
		doClear();
	}
	public void clear(){
		doClear();
	}
	public boolean isEmpty(){
		return size()==0;
	}
	public void trimToSize(){
		ensureCapacity(size());
	}
	public Anytype get(int idx){
		if (idx<0||idx >=size()) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return theItems[idx];
	}
	public Anytype set(int idx,Anytype newVal){
		if (idx<0||idx>=size()) {
			throw new ArrayIndexOutOfBoundsException();
		}
		Anytype old=theItems[idx];
		theItems[idx]=newVal;
		return old;
	}
//	添加到表的末端并通过调用添加到指定位置的较一般的版本而得以简单实现
	public boolean add(Anytype x){
		add(size(),x);
		return true;
	}
//	扩充容量的代价十分昂贵。
//	如果容量被扩充，那么它就要变成原来大小的两倍，以避免不得不再次改变容量。
	public void add(int idx,Anytype x){
		if (theItems.length==size()) {
			ensureCapacity(size()*2+1);
		}
		for (int i = theSize; i >idx; i--) {
			theItems[i]=theItems[i-1];
		}
		theItems[idx]=x;
		theSize++;
	}
	public Anytype remove(int idx){
		Anytype removeItem=theItems[idx];
		for (int i = idx; i < size()-1; i++) {
			theItems[i]=theItems[i+1];
			theSize--;
		}
		return removeItem;
	}
	public java.util.Iterator<Anytype> iterator(){
		return new ArrayListIterator();
	}
	private class ArrayListIterator implements java.util.Iterator<Anytype>{
		private int current=0;
		public boolean hasNext(){
			return current<size();
		}
		public Anytype next(){
			if(!hasNext()){
				throw new java.util.NoSuchElementException();
			}
			return theItems[current++];
		}
		public void remove(){
			MyArrayList.this.remove(--current);
		}
	}
}

