package ds;

public class MyArrayList<Anytype> implements Iterable<Anytype> {
	private static final int DEFAULT_CAPACITY=10;
//	�Ѵ�С��������Ϊ�����ݳ�Ա���д洢
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
//		�洢��ԭʼ�����һ������
		Anytype[] old=theItems;
//		Ϊ����������ڴ�
		theItems=(Anytype[])new Object[newCapacity];
//		�������ݿ�������������
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
//	��ӵ����ĩ�˲�ͨ��������ӵ�ָ��λ�õĽ�һ��İ汾�����Լ�ʵ��
	public boolean add(Anytype x){
		add(size(),x);
		return true;
	}
//	���������Ĵ���ʮ�ְ���
//	������������䣬��ô����Ҫ���ԭ����С���������Ա��ⲻ�ò��ٴθı�������
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

