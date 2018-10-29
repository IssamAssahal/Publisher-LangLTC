package pl.com.lang.support.jpa;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * <b>Custom JPA repository</b> <BR>
 */
@NoRepositoryBean
public interface CustomJpaRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {

	public T sharedCustomMethod(ID id);
}
