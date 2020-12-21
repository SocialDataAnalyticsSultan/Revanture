package eg1;

public class Demo1 {

	public static void main(String[] args) {
		int ar[] = {12, 33, 11, 2, 344, 11, 12};
		for (int i=0; i<ar.length; i++) {
			System.out.println("ar[" + i + "] -> " + ar[i]);
		}
		
		// System.out.println(ar[9]); give an exception
		System.out.println("ar[0] " + ar[0]); 
		System.out.println("Size of array = " + ar.length);
		
		
		int ar1[] = new int[10];
		System.out.println("Printing contents of ar1");
		for(int x:ar1) {
			System.out.print(x + "  ");  // Default is 0
		}
		
		ar1[0]=22;
		ar1[1]=21;
		ar1[2]=32;
		ar1[3]=43;
		ar1[4]=45;
		
		System.out.println();
		int n=5;
		System.out.println("Printing content of array");
		for (int i=0; i<n; i++) {
			System.out.print(ar1[i] + "   ");
		}
		
		System.out.println();
		int pos = 3;
		int elem = 999;
		for(int i = n; i>=pos; i--) {
			ar1[i] = ar1[i-1];
		}
		ar1[pos-1]=elem;
		n++;
		
		for (int i=0; i<n; i++) {
			System.out.print(ar1[i] + "   ");
		}
		
		System.out.println();
		int delpos = 1;
		for(int i = delpos-1; i<n; i++) {
			ar1[i] = ar1[i+1];
		}
		n--;
		for (int i=0; i<n; i++) {
			System.out.print(ar1[i] + "   ");
		}
		

	}

}
