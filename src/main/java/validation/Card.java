package validation;

public abstract class Card {
	Card subsequentAction;

	Card(Card nextProcessor) {
		this.subsequentAction = nextProcessor;
	}

	boolean auth(String cardNumber) {
		if (cardNumber.length() > 19)
			return false;

		if (subsequentAction != null)
			return subsequentAction.auth(cardNumber);

		return false;
	}
}
