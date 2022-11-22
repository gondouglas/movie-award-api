package gondouglas.movieaward.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import gondouglas.movieaward.api.AwardController;
import gondouglas.movieaward.application.AwardApplication;
import gondouglas.movieaward.application.dto.AwardDTO;
import gondouglas.movieaward.application.dto.AwardIntervalDTO;

@SpringBootTest
public class AwardIntegrationTest {

	@Autowired
	AwardApplication awardApplication;

	@Test
	public void testGetInterval() throws Exception {
		AwardController controller = new AwardController(awardApplication);
		AwardIntervalDTO searchInvervalAward = controller.searchInvervalAward().getBody();

		assertEquals(Boolean.FALSE, searchInvervalAward.getMax().isEmpty(), "");
		assertEquals(Boolean.FALSE, searchInvervalAward.getMin().isEmpty(), "");
	}

	@Test
	public void testGetMaxInterval() throws Exception {
		AwardController controller = new AwardController(awardApplication);
		AwardIntervalDTO searchInvervalAward = controller.searchInvervalAward().getBody();

		Integer interval = searchInvervalAward.getMax().get(0).getInterval();

		assertEquals(13, interval, "");
	}

	@Test
	public void testGetMinInterval() throws Exception {
		AwardController controller = new AwardController(awardApplication);
		AwardIntervalDTO searchInvervalAward = controller.searchInvervalAward().getBody();

		Integer interval = searchInvervalAward.getMin().get(0).getInterval();

		assertEquals(1, interval, "");
	}

	
	@Test
	@DisplayName("deve apresentar dois resultados max com intervalo igual a 13")
	public void testGetMaxIntervalSameProducer() throws Exception {
		AwardController controller = new AwardController(awardApplication);
		AwardIntervalDTO searchInvervalAward = controller.searchInvervalAward().getBody();
		int expected = 13;

		assertTrue(searchInvervalAward.getMax().size() >= 2, "");

		for (AwardDTO dto : searchInvervalAward.getMax()) {
			Integer interval = dto.getInterval();
			assertEquals(expected, interval, "");
		}
	}
}
