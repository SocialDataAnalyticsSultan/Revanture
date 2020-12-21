package eg6;

public class Implementor implements MyInterface1, MyInterface2, MyInterface2.InnerInterface  {

	@Override
	public void method1() {
		System.out.println("MyInterface1 method1() & x= " + x);
		
	}

	@Override
	public void method2() {
		System.out.println("MyInterface1 method2() & x= " + x);
		
	}

	@Override
	public void method3() {
		System.out.println("MyInterface1 method3() & x= " + x);
		
	}

	@Override
	public void method4() {
		System.out.println("MyInterface1 method4() & x= " + x);
		
	}

	@Override
	public void call1() {
		System.out.println("MyInterface2 call1()");
		
	}

	@Override
	public void call2() {
		// TODO Auto-generated method stub
		System.out.println("MyInterface2 call2()");
		
	}

	@Override
	public void common() {
		System.out.println("MyInterface1 and MyInterface2 common()");
		
	}
	
	@Override
	public void inner1() {
		// TODO Auto-generated method stub
		System.out.println("MyInterface2 call2()");
		
	}
	
	@Override
	public void inner2() {
		// TODO Auto-generated method stub
		System.out.println("MyInterface2 call2()");
		
	}

}
