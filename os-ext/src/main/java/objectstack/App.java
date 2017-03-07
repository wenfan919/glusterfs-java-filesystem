package objectstack;

import objectstack.api.Repository;
import objectstack.repository.impl.GlusterfsRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Created by tangfeixiong (tangfx128@gmail.com) on 3/6/17.
 */
@SpringBootApplication
public class App {
    @Bean
    public Repository glusterfsRepository() {
        return new GlusterfsRepository();
    }
	
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
