package bidding.server;

/**
 *
 * Created by MakeMEK on 02/04/15.
 */
//TODO Implement Item's functionality
public class Item {

    String ownerName;
    String itemName;
    String description;

    double currentBid;
    String bidderName;
    int timeRemaining;

    public Item(String ownerName, String itemName, String description) {

    }

    /**
     * Compare item by name
     * @param obj a compare item
     * @return item has the same name
     */
    public boolean equals(Object obj) {
        if( !(obj instanceof Item))
            return false;

        Item item = (Item)obj;
        return itemName.equalsIgnoreCase(item.itemName);
    }

    public boolean bid(String bidderName, double bidPrice) {
        throw new UnsupportedOperationException();
    }

    public void setTimeRemaining(int seconds) {
        throw new UnsupportedOperationException();
    }
}
