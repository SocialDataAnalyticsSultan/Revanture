package eg3;
import java.io.FileNotFoundException;

public class Presenter {
	public static void main(String[] args) {
		Business b = new Business();
		String filename = "hello.txt";
		
		try {
			b.openFile(filename);
		}catch(FileNotFoundException e) {
			System.out.println(e);
		}
	}

}
