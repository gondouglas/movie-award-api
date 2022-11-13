package gondouglas.movieaward.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TB_MOVIE")
public class Movie {

	@Id
	@Column(name = "ID_MOVIE")
	private Long id;
	
	@Column(name = "YEAR")
	private Integer year;
	
	@Column(name = "TITLE")
	private String title;
	
	@Column(name = "STUDIO")
	private String studio;
	
	@Column(name = "PRODUCERS")
	private String producers;
	
	@Column(name = "WINNER")
	private Boolean winner;
}
