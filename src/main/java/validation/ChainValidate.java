package validation;

public class ChainValidate {
	Card cardAuth;

	public ChainValidate() {
		cardAuth = new Visa(new MasterCard(new Discover(new Amex(null))));
	}

	public boolean auth(String cardNumber) {
		return cardAuth.auth(cardNumber);
	}
}
