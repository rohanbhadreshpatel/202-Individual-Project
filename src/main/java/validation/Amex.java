package validation;

public class Amex extends Card {
	Amex(Card auth) {
		super(auth);
	}

	boolean auth(String cardNumber) {
		if (isAuthenticAmexCard(cardNumber)) {
			return true;
		} else {
			return super.auth(cardNumber);
		}
	}

	boolean isAuthenticAmexCard(String cardNumber) {
		if (cardNumber.length() == 15 && cardNumber.charAt(0) == '3'
				&& (cardNumber.charAt(1) == '4' || cardNumber.charAt(1) == '7')) {
			return true;
		}
		return false;
	}
}
