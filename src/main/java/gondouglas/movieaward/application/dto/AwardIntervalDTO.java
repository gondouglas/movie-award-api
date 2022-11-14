package gondouglas.movieaward.application.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AwardIntervalDTO {
	
	private List<AwardDTO> min = new ArrayList<>();

	private List<AwardDTO> max = new ArrayList<>();

}
