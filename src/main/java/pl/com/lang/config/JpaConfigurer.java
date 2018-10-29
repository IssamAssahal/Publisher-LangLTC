package pl.com.lang.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import pl.com.lang.support.jpa.CustomRepositoryFactoryBean;
import pl.com.lang.support.jpa.SpringSecurityAuditorAware;
import pl.com.lang.web.entity.User;


/**
 * @author Issam As-sahal ISA
 */

@Configuration
@EnableJpaRepositories(basePackages = "pl.com.lang.web.repository", repositoryFactoryBeanClass = CustomRepositoryFactoryBean.class)
// @EnableJpaRepositories(basePackages =
// "com.assahal.web.repository",
// repositoryBaseClass = CustomJpaRepositoryImpl.class)
@EnableJpaAuditing
public class JpaConfigurer {

    @Bean
    public AuditorAware<User> auditorAware() {
        return new SpringSecurityAuditorAware();
    }
}
