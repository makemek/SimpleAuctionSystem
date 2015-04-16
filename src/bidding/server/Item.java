package bidding.server;

import com.sun.org.apache.bcel.internal.generic.IADD;

import java.util.ArrayList;

/**
 * Item's info for bidding
 * Item's name use to uniquely distinguish object
 * Created by MakeMEK on 02/04/15.
 */
public class Item {

    private String ownerName;
    private String itemName;
    private String description;

    private double currentBid;
    private String bidderName;
    private int timeRemaining;

    private ArrayList<IAuctionListener> listener = new ArrayList<IAuctionListener>();

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

        notifyObserver();
        return true;
    }

    public void addBidStatusListener(IAuctionListener listener) {
        this.listener.add(listener);
    }

    public IAuctionListener[] getListeners() {
        return listener.toArray(new IAuctionListener[listener.size()]);
    }

    private void notifyObserver() {
        for(IAuctionListener obs: listener)
            obs.update(this);
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

    public String getDescription() {
        return description;
    }

    public void setTimeRemaining(int seconds) {
        timeRemaining = seconds;
    }
}
