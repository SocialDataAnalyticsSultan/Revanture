package eg2;

public class Outer {
	
	public void outerMethod() {
		InnerPrivate i = new InnerPrivate();
		i.helloInnerPrivate();
		
	}
	
	private class InnerPrivate{
		public void helloInnerPrivate() {
			System.out.println("Hey hello from helloInnerPrivate()");
		}
	}
	
	public class InnerPublic{
		public void helloInnerPublic() {
			System.out.println("Hey hello from helloInnerPublic()");
		}
	}
	
	public static class InnerPublicStatic{
		public void helloInnerPublicNonStatic() {
			System.out.println("Hey hello from InnerPublicStatic()");
		
		}
		
		public static void helloInnerPublicStatic() {
			System.out.println("Hey hello from helloInnerPublicStatic()");
		}
	}

}
