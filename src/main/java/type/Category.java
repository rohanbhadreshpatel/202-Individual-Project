package type;

public interface Category {
	
	public String getName();
	public int getPrice();
	public void setPrice(int price);
	public int getSeatCount();
	public void setSeatCount(int seatCount);
	public int computePrice();
	
}
