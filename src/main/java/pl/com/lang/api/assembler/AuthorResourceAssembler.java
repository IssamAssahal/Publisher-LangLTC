package pl.com.lang.api.assembler;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.util.CollectionUtils;

import pl.com.lang.api.AuthorController;
import pl.com.lang.api.BookController;
import pl.com.lang.api.resource.AuthorResource;
import pl.com.lang.web.entity.Author;
import pl.com.lang.web.entity.BookAuthor;

/**
 * <b>Author Resource Assembler</b><br>
 *
 */
public class AuthorResourceAssembler extends ResourceAssemblerSupport<Author, AuthorResource> {

	public AuthorResourceAssembler() {
		super(AuthorController.class, AuthorResource.class);
	}

	@Override
	public AuthorResource toResource(Author author) {
		AuthorResource resource = createResourceWithId(author.getId(), author);

		// books
		if (!CollectionUtils.isEmpty(author.getAuthorBooks())) {
			for (BookAuthor bookAuthor : author.getAuthorBooks()) {
				resource.add(ControllerLinkBuilder.linkTo(
						ControllerLinkBuilder.methodOn(BookController.class).getBook(bookAuthor.getBook().getId()))
						.withRel("books"));
			}
		}

		// assign book
		Link assignBookLink = ControllerLinkBuilder
				.linkTo(ControllerLinkBuilder.methodOn(AuthorController.class).assignBook(author.getId(), null))
				.withRel("assignBook");
		resource.add(assignBookLink);

		return resource;
	}

	@Override
	protected AuthorResource instantiateResource(Author author) {

		AuthorResource resource = new AuthorResource();
		resource.setAuthorName(author.getAuthorName());
		resource.setCreateBy(author.getCreateBy().getUsername());
		resource.setCreateDate(author.getCreateDate());
		if (null != author.getLastModifiedBy()) {
			resource.setLastModifiedBy(author.getLastModifiedBy().getUsername());
			resource.setLastModifiedDate(author.getLastModifiedDate());
		}

		return resource;
	}

}
