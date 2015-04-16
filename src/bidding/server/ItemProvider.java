package bidding.server;

import java.util.ArrayList;

/**
 * A middle man between bidding.client and database
 * Created by MakeMEK on 02/04/15.
 */
public class ItemProvider implements IAuctionServer {

    private DBMock db;
    private static ItemProvider instance;

    private ItemProvider(DBMock db) {
        this.db = db;
    }

    public static ItemProvider instance() {
        return new ItemProvider(new DBMock());
    }

    @Override
    public void placeItemForBid(String ownerName, String itemName, String itemDesc, double startBid, int auctionTime) {
        Item item = ItemFactory.create(ownerName, itemName, itemDesc, startBid, auctionTime);
        db.addItem(item);
    }

    @Override
    public void bidOnItem(String bidderName, String itemName, double bid) {
        Item item = db.getItem(itemName);
        item.bid(bidderName, bid);
    }

    @Override
    public Item[] getItems() {
        return db.getItems();
    }

    @Override
    public Item getItem(String itemName) {
        return db.getItem(itemName);
    }

    @Override
    public void registerListener(IAuctionListener al, String itemName) {
        db.getItem(itemName).addBidStatusListener(al);
    }
}
