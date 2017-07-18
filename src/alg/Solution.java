package alg;

public class Solution {
	public static void main(String[] args) {
		Solution s=new Solution();
		StringBuffer b=new StringBuffer();
		b.append(" happy ");
		System.out.println(s.replaceSpace(b));
	}
	public String replaceSpace(StringBuffer str){
		int spacenum=0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i)==' ') {
				spacenum++;
			}
		}
		int oldindex=str.length()-1;
		int newlenth=str.length()+spacenum*2;
		int newindex=newlenth-1;
		str.setLength(newlenth);
		for (; oldindex>=0&&oldindex<newindex; oldindex--) {
			if (str.charAt(oldindex)==' ') {
				str.setCharAt(newindex--, '0');
				str.setCharAt(newindex--, '2');
				str.setCharAt(newindex--, '%');
			}else {
				str.setCharAt(newindex--, str.charAt(oldindex));
			}
		}
		
		return str.toString();
	}
}
