package ds;

public class listAll {
	private void listAll(int depth) {
		printName(depth);//��Ӧ���������ȵ��ļ�����
		if(isDirectory){
			for each file in this directory(for each child)
			c.listAll(depth+1)
		}
	}
	//���õݹ�������ļ���ÿһ���ļ������ļ����ݹ鵽��
	public void listAll(){
		listAll(0);
	}
	
}
