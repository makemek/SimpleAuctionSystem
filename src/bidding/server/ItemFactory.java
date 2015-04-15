package bidding.server;

/**
 * Created by Apipol on 15/04/15.
 */
public class ItemFactory {
    public static Item create(String ownerName, String itemName, String desc, double price, int availableTime) {
        Item itm = new Item(ownerName, itemName, desc, price);
        itm.setTimeRemaining(availableTime);
        return itm;
    }
}
