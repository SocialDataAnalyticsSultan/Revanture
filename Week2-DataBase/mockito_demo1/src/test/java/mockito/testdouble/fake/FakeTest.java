package mockito.testdouble.fake;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class FakeTest {

	@Test
	void testFake() {
		BookRepository bookRepository = new FakeBookRepository();
		BookService bookService = new BookService(bookRepository);
		
		bookService.addBook(new Book("1234", "Mockito In Action", 250, LocalDate.now()));
		bookService.addBook(new Book("1235", "JUnit 5 In Action", 200, LocalDate.now()));
		
		assertEquals(2, bookService.findNumberBook());
	}

}
