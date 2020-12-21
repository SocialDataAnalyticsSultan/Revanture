package eg6;

public class ImplementionMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MyInterface1 i1 = new Implementor();
		i1.method1();
		i1.method2();
		i1.method3();
		i1.method4();
		i1.common();
		
		
		MyInterface2 i2 = new Implementor();
		i2.call1();
		i2.call2();
		
		Implementor i3 = new Implementor();
		i3.method1();
		i3.method2();
		i3.method3();
		i3.method4();
		i3.call1();
		i3.call2();
		i3.inner1();
		i3.inner2();
	}

}
