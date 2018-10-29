package pl.com.lang.web.repository;

import pl.com.lang.support.jpa.CustomJpaRepository;
import pl.com.lang.web.entity.Author;

import java.util.Set;

/**
 * <b>Author Repository</b><br>
 * @author Issam As-sahal ISA
 */
public interface AuthorRepository extends CustomJpaRepository<Author, Long> {

	public Author findByAuthorName(String authorName);

	public Set<Author> findByAuthorBooks_Book_Id(Long bookId);
}
