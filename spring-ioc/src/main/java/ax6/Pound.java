package ax6;

import org.springframework.stereotype.Component;

@Component("ukp")
public class Pound implements Currency {

	@Override
	public double dollarValue() {
		return 0.85;
	}

}
