package runnable_interface_implementation;

public class RunMain {

	public static void main(String[] args) {
		
		MyRun r1 = new MyRun();
		Thread t1 = new Thread(r1, "run-1");
		
		MyRun r2 = new MyRun();
		Thread t2 = new Thread(r2, "run-2");
		
		MyRun r3 = new MyRun();
		Thread t3 = new Thread(r3, "run-3");
		
		MyRun r4 = new MyRun();
		Thread t4 = new Thread(r4, "run-4");
		
		MyRun r5 = new MyRun();
		Thread t5 = new Thread(r5, "run-5");
		
		/*
		 * t1.setDaemon(true); t2.setDaemon(true); t3.setDaemon(true);
		 * t4.setDaemon(true); t5.setDaemon(true);
		 */
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		
		
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
			t5.join();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		for (int i=0; i<5; i++) {
			System.out.println("Printing from thread - " + Thread.currentThread().getName()+
					" value of i= " + (i+1));
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Main ends here");
	}

}
