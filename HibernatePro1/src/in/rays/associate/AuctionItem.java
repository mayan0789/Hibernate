package in.rays.associate;

import java.util.Set;

public class AuctionItem {

	private int id;
	private String Description;
	private Set<Bid> bid;

	public AuctionItem() {	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Set<Bid> getBid() {
		return bid;
	}

	public void setBid(Set<Bid> bid) {
		this.bid = bid;
	}
	
}
