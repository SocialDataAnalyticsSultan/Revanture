package thread_class_extension;

public class MyThread extends Thread {
	
	public void run() {
		System.out.println(Thread.currentThread());
		
		System.out.println("Printing from thread " + Thread.currentThread().getName() 
				+ " Id is " + Thread.currentThread().getId());
		
		for (int i=0; i<4; i++) {
			System.out.println("Printing from thread - " + Thread.currentThread().getName() +
					" value of i " + (i+1));
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
