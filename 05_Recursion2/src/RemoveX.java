
public class RemoveX {

	public static String removeX(String str) {
//		if(str.isEmpty()) {
		if(str.length() == 0) {
			return str;
		}
		String ans = "";
		if(str.charAt(0) != 'x') {
			ans += str.charAt(0);
		}
		String smallAns = removeX(str.substring(1));
		return ans + smallAns; // id 0th index is x then ans will be empty otherwise it will hold the 0th element
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "xbxa";
		System.out.println(removeX(str));
	}

}
