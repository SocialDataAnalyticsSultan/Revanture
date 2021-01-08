package mockito.testdouble.fake;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class FakeBookRepository implements BookRepository{
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
