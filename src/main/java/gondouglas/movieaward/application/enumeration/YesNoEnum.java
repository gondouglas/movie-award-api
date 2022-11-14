package gondouglas.movieaward.application.enumeration;

import java.util.Arrays;
import java.util.List;

public enum YesNoEnum {
	
	YES {
		@Override
		public List<String> options() {
			return Arrays.asList("yes", "y");
		}
	},
	NO {
		@Override
		public List<String> options() {
			return Arrays.asList("no", "n");
		}
	};

	public abstract List<String> options();
}
