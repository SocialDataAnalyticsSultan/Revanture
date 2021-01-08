package thread_home_study.demo3;

public class Demo3 {

	public static void main(String[] args) {
		
		Thread t1 = new Thread(()->
		{
			for(int i=0; i<5; i++) {
				System.out.println("Hi");
				try {
					Thread.sleep(500);  //static method
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		Thread t2 = new Thread(()->
		{
			for(int i=0; i<5; i++) {
				System.out.println("Hello");
				try {
					Thread.sleep(500);  //static method
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		t1.start();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t2.start();
		
		System.out.println(t1.isAlive());
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(t1.isAlive());
		System.out.println("Bye");

	}

}
