package eg8;

public class Demo11 {

	public static void main(String[] args) {
		String s = "Hello hi good evening how are you doing today?";
		
		StringBuilder sb = new StringBuilder();
		String ar[]= s.split(" ");
		for (int index=0; index<ar.length; index++) {
			sb.append(Character.toUpperCase(ar[index].charAt(0))).append(ar[index].substring(1)).append(" ");
		}
		
		System.out.println(sb);
		StringBuilder sb2 = new StringBuilder();
		for(int index = 0; index<ar.length; index++) {
			sb2.append(ar[index].substring(0, ar[index].length()-1)).append(Character.toUpperCase(ar[index].charAt(ar[index].length()-1))).append(" ");
		}
		System.out.println(sb2);

	}

}
