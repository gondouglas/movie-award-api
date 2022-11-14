package gondouglas.movieaward;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import gondouglas.movieaward.service.StartupService;

@SpringBootApplication
public class MovieAwardApiApplication {

	private final StartupService startupService;

	@Autowired
	public MovieAwardApiApplication(StartupService startupService) {
		this.startupService = startupService;
	}

	public static void main(String[] args) {
		SpringApplication.run(MovieAwardApiApplication.class, args);
	}


	@EventListener(ApplicationReadyEvent.class)
	public void onStartup() {
		startupService.execute();
	}
}
