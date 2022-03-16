package hello.boardspring;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.time.LocalDateTime;
import java.util.stream.IntStream;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class BoardSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoardSpringApplication.class, args);
	}

}
