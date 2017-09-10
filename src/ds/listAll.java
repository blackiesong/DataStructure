package ds;

public class listAll {
	private void listAll(int depth) {
		printName(depth);//答应出这个树深度的文件名字
		if(isDirectory){
			for each file in this directory(for each child)
			c.listAll(depth+1)
		}
	}
	//利用递归完成子文件下每一个文件的子文件，递归到底
	public void listAll(){
		listAll(0);
	}
	
}
