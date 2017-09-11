package ds;

public class BinarySearchTree<AnyType> extends Comparable<? super AnyType>{
	private static class BinaryNode<AnyType>{
		 BinaryNode(AnyType theElement) {
			// TODO Auto-generated constructor stub
			this(theElement,null,null);
		}
		BinaryNode(AnyType theElement,BinaryNode<AnyType> lt,BinaryNode<AnyType> rt){
			element=theElement;left=lt;right=rt;
		}
		AnyType element;
		BinaryNode<AnyType> left;
		BinarySearchTree<AnyType> right;
	}
	
	private BinaryNode<AnyType> root;
	public BinarySearchTree(){
		root=null;//构造方法 置空根节点（初始化）
	}
	public void makeEmpty(){
		root=null;
	}
	public boolean isEmpty(){
		return root==null;
	}
	
}
