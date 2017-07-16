package ds;
public class ShuzuList {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr=new int[5];
		arr[0]=1;
		arr[1]=3;
		arr[2]=9;
		arr[4]=10;
		for (int i = 0; i < arr.length; i++) {
			System.out.println("转换前：第"+i+"项是："+arr[i]);
		}
		int[] newArr=new int[arr.length*2];
		for (int i = 0; i < arr.length; i++) {
			newArr[i]=arr[i];
		}
		arr=newArr;
		for (int i = 0; i < arr.length; i++) {
			System.out.println("转换后：第"+i+"项是："+arr[i]);
		}
	}
}
