package validation;

public class Visa extends Card {
	Visa(Card authenticator) {
		super(authenticator);
	}

	boolean auth(String cardNumber) {
		if (isAuthenticVisaCard(cardNumber)) {
			return true;
		} else {
			return super.auth(cardNumber);
		}
	}

	boolean isAuthenticVisaCard(String cardNumber) {
		char num1 = cardNumber.charAt(0);
		int cardLength = cardNumber.length();
		if ((cardLength == 13 || cardLength == 16) && num1 == '4') {
			return true;
		}
		return false;
	}
}
