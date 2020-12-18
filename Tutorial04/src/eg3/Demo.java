package eg3;

public class Demo {

	public static void main(String[] args) {
		int x = 10;
		int y = 2;
		int res = 0;
		String s = null;
		
		try {
			res=x/y;
			System.out.println(s.length());
		}catch (ArithmeticException e){
			System.out.println("You cannot divide by zero.");
		}catch(NullPointerException e) {
			System.out.println("Something is null");
		}catch(Exception e) {
			System.out.println("Unhandled Exception");
		}finally {
			System.out.println("Result is " + res);
		}
		System.out.println("This is other LOC of this app");

	}

}
