package gondouglas.movieaward.application.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AwardDTO {
	
	private String producer;

	private Integer interval;

	private Integer previousWin;

	private Integer followingWin;

}
