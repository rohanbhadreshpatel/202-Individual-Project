package validation;

public class Discover extends Card {
	Discover(Card authenticator) {
		super(authenticator);
	}

	boolean auth(String cardNumber) {
		if (isAuthenticDiscoverCard(cardNumber)) {
			return true;
		} else {
			return super.auth(cardNumber);
		}
	}

	boolean isAuthenticDiscoverCard(String cardNumber) {
		if (cardNumber.length() == 16 && cardNumber.startsWith("6011")) {
			return true;
		}
		return false;
	}
}
