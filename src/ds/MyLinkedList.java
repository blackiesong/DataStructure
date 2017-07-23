package ds;

import java.util.Iterator;

public class MyLinkedList<Anytype> implements Iterable<Anytype> {
	private int theSize;
	private int modCount;
	private Node<Anytype> beginMarker;
	private Node<Anytype> endMarker;
	
	@Override
	public Iterator<Anytype> iterator() {
		// TODO Auto-generated method stub
		return new LinkedListIterator();
	}
	private class LinkedListIterator implements java.util.Iterator<Anytype>{
		private Node<Anytype> current=beginMarker.next;
		private int expectedModcount=modCount;
		private boolean okToRemove=false;
		public boolean hasNext(){
			return current!=endMarker;
		}
		public Anytype next(){
			if (modCount!=expectedModcount) {
				throw new java.util.ConcurrentModificationException();
			}
			if (!hasNext()) {
				throw new java.util.NoSuchElementException();
			}
			Anytype nextItem=current.data;
			current=current.next;
			okToRemove=true;
			return nextItem;
		}
		public void remove(){
			if (modCount!=expectedModcount) {
				throw new java.util.ConcurrentModificationException();
			}
			if (!okToRemove) {
				throw new IllegalStateException();
			}
			MyLinkedList.this.remove(current.prev);
			expectedModcount++;
			okToRemove=false;
		}
	}
	public int size() {
		return theSize;
	}
	public boolean isEmpty(){
		return size()==0;
	}
	
	private void addBefore(Node<Anytype> p,Anytype x){
		Node<Anytype> newNode=new Node<>(x, p.prev, p);
		newNode.prev.next=newNode;
		p.prev=newNode;
		theSize++;
		modCount++;
	}
	private Node<Anytype> getNode(int idx) {
		return getNode(idx, 0, size()-1);
		
	}
	private Node<Anytype> getNode(int idx,int lower,int upper){
		Node<Anytype> p;
		if (idx<lower||idx>upper) {
			throw new IndexOutOfBoundsException();
		}
		if (idx<size()/2) {
			p=beginMarker.next;
			for (int i = 0; i < idx; i++) {
				p=p.next;
			}
		}else {
			p=endMarker;
			for (int i = size(); i >idx; i--) {
				p=p.prev;
			}
		}
		return p;
	}
	public boolean add(Anytype x) {
		add(size(), x);
		return true;
	}
	public void add(int idx,Anytype x) {
		addBefore(getNode(idx, 0, size()), x);
	}
	public Anytype get(int idx) {
		return getNode(idx).data;
	}
	private Anytype set(int idx,Anytype newVal) {
		Node<Anytype> p=getNode(idx);
		Anytype oldVal=p.data;
		p.data=newVal;
		return oldVal;
	}
	public Anytype remove(int idx) {
		return remove(getNode(idx));
	}
	private Anytype remove(Node<Anytype> p) {
		p.next.prev=p.prev;
		p.prev.next=p.next;
		theSize--;
		modCount++;
		return p.data;
	}
	public static class Node<Anytype>{
		public Node(Anytype d,Node<Anytype> p,Node<Anytype> n){
			data=d;prev=p;next=n;
		}
		public Anytype data;
		public Node<Anytype> prev;
		public Node<Anytype> next;
	}
	public void clear(){
		doClear();
	}
	private void doClear(){
		beginMarker=new Node<Anytype>(null, null, null);
		endMarker=new Node<Anytype>(null, beginMarker, null);
	}
	
}
