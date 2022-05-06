package validation;

public class MasterCard extends Card {
	MasterCard(Card authenticator) {
		super(authenticator);
	}

	boolean auth(String cardNumber) {
		if (isAuthenticMasterCard(cardNumber)) {
			return true;
		} else {
			return super.auth(cardNumber);
		}
	}

	boolean isAuthenticMasterCard(String cardNumber) {
		char num1 = cardNumber.charAt(0), num2 = cardNumber.charAt(1);
		if (cardNumber.length() == 16 && num1 == '5' && num2 - '0' >= 1 && num2 - '0' <= 5) {
			return true;
		}
		return false;
	}
}
