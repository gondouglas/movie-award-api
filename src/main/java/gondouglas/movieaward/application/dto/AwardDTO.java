package gondouglas.movieaward.application.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AwardDTO {
	
	private String producer;

	private Integer previousWin;

	private Integer followingWin;

	public Integer getInterval() {
		if (previousWin == null || followingWin == null) {
			return 0;
		}

		return followingWin - previousWin;
	}

}
