package m.code;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;

@SpringBootApplication
@Repository
public class SimpleCrudAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleCrudAppApplication.class, args);
	}

}
