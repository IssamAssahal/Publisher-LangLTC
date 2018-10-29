package pl.com.lang.unit.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pl.com.lang.api.AuthorController;
import pl.com.lang.web.entity.Author;
import pl.com.lang.web.entity.Book;
import pl.com.lang.web.entity.User;
import pl.com.lang.web.service.AuthorService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * <b>Author Controller Unit Test</b><br>
 * 
 * @author Issam As-sahal ISA
 */
@RunWith(SpringRunner.class)
public class AuthorControllerTest {

	private MockMvc mockMvc;
	private @Mock
    AuthorService authorService;
	private @InjectMocks
	AuthorController authorController = new AuthorController();

	private Long authorId = 1L;
	private String authorName = "Adam";
	private User user = new User();

	private ObjectMapper mapper = new ObjectMapper();

	@Before
	public void setUp() {
		user.setUsername(authorName);
		this.mockMvc = MockMvcBuilders.standaloneSetup(this.authorController).build();
	}

	@Test
	public void testCreateAuthor() throws Exception {
		Author savedAuthor = new Author();
		savedAuthor.setId(authorId);
		savedAuthor.setAuthorName(authorName);
		savedAuthor.setCreateBy(user);

		Author newAuthor = new Author();
		newAuthor.setAuthorName(authorName);

		Mockito.when(authorService.createAuthor(authorName)).thenReturn(savedAuthor);

		this.mockMvc.perform(post("/api/authors").contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsBytes(newAuthor))).andExpect(status().isCreated());

	}

	@Test
	public void testGetAuthor() throws Exception {
		Author savedAuthor = new Author();
		savedAuthor.setId(authorId);
		savedAuthor.setAuthorName(authorName);
		savedAuthor.setCreateBy(user);

		Mockito.when(authorService.getAuthor(authorId)).thenReturn(savedAuthor);

		this.mockMvc.perform(get("/api/authors/" + authorId)).andExpect(status().isOk());

	}

	@Test
	public void testDeleteAuthor() throws Exception {
		Mockito.doNothing().when(authorService).deleteAuthor(authorId);
		this.mockMvc.perform(delete("/api/authors/" + authorId)).andExpect(status().isNoContent());
	}

	@Test
	public void testAssignBook() throws Exception {

		Book book = new Book();
		book.setId(1L);

		Author savedAuthor = new Author();
		savedAuthor.setId(authorId);
		savedAuthor.setAuthorName(authorName);
		savedAuthor.setCreateBy(user);

		Mockito.when(authorService.assignBook(authorId, 1L)).thenReturn(savedAuthor);

		this.mockMvc.perform(put("/api/authors/" + authorId + "/books").contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsBytes(book))).andExpect(status().isOk());

	}
}
