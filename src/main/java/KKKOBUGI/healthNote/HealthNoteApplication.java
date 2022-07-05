package KKKOBUGI.healthNote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing//시간을 구할 떄 필요한 어노테이션에서 auditing기능을 사용하려면 필요
@SpringBootApplication
public class HealthNoteApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthNoteApplication.class, args);
	}

}
