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
        String name;
        if(obj instanceof String)
            name = (String)obj;
        else if(obj instanceof Item)
            name = ((Item) obj).itemName;
        else
            return false;

        return itemName.equalsIgnoreCase(name);
    }

    public boolean bid(String bidderName, double bidPrice) {
        throw new UnsupportedOperationException();
    }

    public void setTimeRemaining(int seconds) {
        throw new UnsupportedOperationException();
    }
}
