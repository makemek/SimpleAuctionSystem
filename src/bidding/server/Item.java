package bidding.server;

/**
 * Item's info for bidding
 * Item's name use to uniquely distinguish object
 * Created by MakeMEK on 02/04/15.
 */
public class Item {

    String ownerName;
    String itemName;
    String description;

    double currentBid;
    String bidderName;
    int timeRemaining;

    public Item(String ownerName, String itemName, String description, double price) {
        this.ownerName = ownerName;
        this.itemName = itemName;
        this.description = description;
        this.currentBid = price;
    }

    /**
     * Compare item by name
     * @param obj a compare item
     * @return item has the same name
     */
    public boolean equals(Object obj) {
        String name;
        if(obj instanceof String)
            name = (String)obj;
        else if(obj instanceof Item)
            name = ((Item) obj).itemName;
        else
            return false;

        return itemName.equalsIgnoreCase(name);
    }

    /**
     * Bid item by price. If bidding price is lower than the previous bidding, it is ignored
     * @param bidderName name of the bidder
     * @param bidPrice bidding price
     * @return boolean accept bidding price or not
     */
    public boolean bid(String bidderName, double bidPrice) {
        if(bidPrice < currentBid)
            return false;
        this.bidderName = bidderName;
        currentBid = bidPrice;
        return true;
    }

    public String getOwner() {
        return ownerName;
    }

    public String getItemName() {
        return itemName;
    }

    public String getBidderName() {
        return bidderName;
    }

    public double getBiddingPrice() {
        return currentBid;
    }

    public void setTimeRemaining(int seconds) {
        timeRemaining = seconds;
    }
}
