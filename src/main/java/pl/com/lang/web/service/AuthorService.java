package pl.com.lang.web.service;

import pl.com.lang.support.exception.DuplicateException;
import pl.com.lang.support.exception.NotFoundException;
import pl.com.lang.web.entity.Author;
import pl.com.lang.web.service.impl.AuthorServiceImpl;

/**
 * Author service Implementation refer to {@link AuthorServiceImpl}
 */
public interface AuthorService {

	public Author getAuthor(Long authorId) throws NotFoundException;

	public Author createAuthor(String authorName) throws DuplicateException;

	public void deleteAuthor(Long authorId) throws NotFoundException;

	public Author assignBook(Long authorId, Long bookId) throws NotFoundException;
}
