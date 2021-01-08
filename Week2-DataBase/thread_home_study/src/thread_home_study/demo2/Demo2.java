package thread_home_study.demo2;

public class Demo2{

	public static void main(String[] args) {
		Hi obj1 = new Hi();
		Hello obj2 = new Hello();
		
		Thread t1 = new Thread(obj1);
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Thread t2 = new Thread(obj2);
		
		t1.start();
		t2.start();

	}

}

class Hi implements Runnable{
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

class Hello implements Runnable{//Runnable do not have start method
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
