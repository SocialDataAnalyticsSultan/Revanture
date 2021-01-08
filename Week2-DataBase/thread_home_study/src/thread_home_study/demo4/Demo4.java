package thread_home_study.demo4;

public class Demo4 {

	public static void main(String[] args) {
		Thread t1 = new Thread(()->
		{
			for(int i=0; i<5; i++) {
				System.out.println("Hi...."+ Thread.currentThread().getPriority());
				try {
					Thread.sleep(500);  //static method
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "Hi Thread");
		
		Thread t2 = new Thread(()->
		{
			for(int i=0; i<5; i++) {
				System.out.println("Hello..." + Thread.currentThread().getPriority());
				try {
					Thread.sleep(500);  //static method
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "Hello Thread");
		
		t1.start();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t2.start();
		
		//t1.setName("Hi");
		//t2.setName("Hello");
		
		System.out.println(t1.getName());  // default start with 0
		System.out.println(t2.getName());
		
		//t1.setPriority(1); 
		//t2.setPriority(10);
		
		t1.setPriority(Thread.MIN_PRIORITY); 
		t2.setPriority(Thread.MAX_PRIORITY);
		
		System.out.println(t1.getPriority());  // default 5 range(1-10)
		System.out.println(t2.getPriority()); // 
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Bye");

	}

}
