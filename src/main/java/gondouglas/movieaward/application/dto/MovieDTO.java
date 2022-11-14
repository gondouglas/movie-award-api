package gondouglas.movieaward.application.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MovieDTO implements DomainDTO {

	private Long id;
	
	private Integer year;
	
	private String title;
	
	private String studio;
	
	private String producers;
	
	private Boolean winner;
}
