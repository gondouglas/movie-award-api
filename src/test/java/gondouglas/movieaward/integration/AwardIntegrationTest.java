package gondouglas.movieaward.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import gondouglas.movieaward.api.AwardController;
import gondouglas.movieaward.application.AwardApplication;
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
}
