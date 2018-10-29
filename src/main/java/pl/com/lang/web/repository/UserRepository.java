package pl.com.lang.web.repository;

import pl.com.lang.support.jpa.CustomJpaRepository;
import pl.com.lang.web.entity.User;

/**
 * <b>User Repository</b><br>

 * 
 * @author Issam As-sahal ISA
 */
public interface UserRepository extends CustomJpaRepository<User, Long> {

	public User findByUsername(String username);
}
