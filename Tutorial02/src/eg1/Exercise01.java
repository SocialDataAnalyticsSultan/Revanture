package eg1;

public class Exercise01 {

	public static void main(String[] args) {
		int m = 100;
		oddNumber(m);

	}
	
	public static void oddNumber(int m) {
		for (int i=1; i<=m; i++) {
			if (i%2 == 1) {
				System.out.print(i + "  ");
			}
		}
	}
}
