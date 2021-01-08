package synchronization;

public class Main {

	public static void main(String[] args) {
		new Pages("page-1 by user-1", "page-2 by user-1");
		new Pages("page-1 by user-2", "page-2 by user-2");
		new Pages("page-1 by user-3", "page-2 by user-3");
		new Pages("page-1 by user-4", "page-2 by user-4");
		new Pages("page-1 by user-5", "page-2 by user-5");

	}

}
