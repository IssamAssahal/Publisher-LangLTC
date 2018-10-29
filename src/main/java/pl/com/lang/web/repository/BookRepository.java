package pl.com.lang.web.repository;

import pl.com.lang.support.jpa.CustomJpaRepository;
import pl.com.lang.web.entity.Book;

import java.util.Set;

/**
 * <b>Book Repository</b><br>
 * @author Issam As-sahal ISA
 */
public interface BookRepository extends CustomJpaRepository<Book, Long> {

	public Book findByBookName(String bookName);

	public Set<Book> findByBookAuthors_Author_Id(Long authorId);
}
