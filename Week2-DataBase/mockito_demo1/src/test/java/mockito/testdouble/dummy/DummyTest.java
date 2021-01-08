package mockito.testdouble.dummy;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import mockito.testdouble.fake.Book;

class DummyTest {

	@Test
	void testDummy() {
		//In memory database, HashMap, List
		Map<String, Book> bookStore = new HashMap<>();
		
		
		@Override
		public void save(Book book) {
			bookStore.put(book.getBookId(), book);
		}

		@Override
		public Collection<Book> findAll() {
			return bookStore.values();
		}
	}

}
