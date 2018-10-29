package pl.com.lang.web.service;

import pl.com.lang.support.exception.DuplicateException;
import pl.com.lang.support.exception.NotFoundException;
import pl.com.lang.web.entity.Book;
import pl.com.lang.web.service.impl.BookServiceImpl;

/**
 * Book service Implementation refer to {@link BookServiceImpl}
 */
public interface BookService {


	public Book getBook(Long bookId) throws NotFoundException;

	public Book createBook(String bookName) throws DuplicateException;

	public void deleteBook(Long bookId) throws NotFoundException;

	public Book assignAuthor(Long bookId, Long authorId) throws NotFoundException;
}
