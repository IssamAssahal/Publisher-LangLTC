package pl.com.lang.web.repository;

import pl.com.lang.support.jpa.CustomJpaRepository;
import pl.com.lang.web.entity.Author;
import pl.com.lang.web.entity.Book;
import pl.com.lang.web.entity.BookAuthor;

/**
 * <b>BookAuthor Repository</b><br>
 * @author Issam As-sahal ISA
 */
public interface BookAuthorRepository extends CustomJpaRepository<BookAuthor, Long> {

	public BookAuthor findByBookAndAuthor(Book book, Author author);

	public void deleteByAuthor(Author author);

	public void deleteByBook(Book book);
}
