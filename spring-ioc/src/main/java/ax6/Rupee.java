package ax6;

import org.springframework.stereotype.Component;

@Component("inr")
public class Rupee implements Currency {

	@Override
	public double dollarValue() {
		return 84.50;
	}

}
