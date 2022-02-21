package hello.boardspring;

import hello.boardspring.domain.MyBoard;
import hello.boardspring.repository.MyBoardRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.stream.IntStream;

@SpringBootApplication
public class BoardSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoardSpringApplication.class, args);
	}
	
//	@Bean
//	public CommandLineRunner runner(MyBoardRepository myBoardRepository) throws Exception {
//		return (args) -> {
//			IntStream.rangeClosed(1, 100).forEach(index ->
//														  myBoardRepository.save(new MyBoard(Long.valueOf(index),"게시글" + index,"내용" + index, LocalDateTime.now(),LocalDateTime.now())));
//
//		};
//	}
}
