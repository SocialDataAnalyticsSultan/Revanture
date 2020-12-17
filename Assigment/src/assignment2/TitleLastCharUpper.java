package assignment2;

public class TitleLastCharUpper {

	public static void main(String[] args) {
		String s="hello hi good evening how are you doing today";
		StringBuilder sb=new StringBuilder();
		String arr[]=s.split(" ");
		
		for (int index=0; index<arr.length; index++) {
			sb.append(arr[index].substring(0, arr[index].length()-1)).append(Character.toUpperCase(arr[index].charAt(arr[index].length()-1))).append(" ");
		}
		System.out.println(sb.toString());
	}
}
