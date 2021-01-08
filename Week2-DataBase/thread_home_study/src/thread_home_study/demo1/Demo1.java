package thread_home_study.demo1;

public class Demo1 {

	public static void main(String[] args) {
		
		Hi obj1 = new Hi();
		Hello obj2 = new Hello();
		
		obj1.start();  //start call run method
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		obj2.start();
		
		//obj1.show();
		//obj2.show();
	}

}

class Hi extends Thread{
	public void run() {
		for(int i=0; i<5; i++) {
			System.out.println("Hi");
			try {
				Thread.sleep(500);  //static method
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Hello extends Thread{
	public void run() {
		for(int i=0; i<5; i++) {
			System.out.println("Hello");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}