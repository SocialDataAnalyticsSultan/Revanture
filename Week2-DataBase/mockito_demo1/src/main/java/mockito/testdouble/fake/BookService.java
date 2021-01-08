package mockito.testdouble.fake;

public class BookService {
	
	private BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}

	public void addBook(Book book) {
		bookRepository.save(book);
	}
	
	public int findNumberBook() {
		return bookRepository.findAll().size();
	}
	

}
