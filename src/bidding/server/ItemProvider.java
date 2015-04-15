package bidding.server;

import java.util.ArrayList;

/**
 * A middle man between bidding.client and database
 * Created by MakeMEK on 02/04/15.
 */
//TODO Implement ItemProvider functionality
public class ItemProvider implements IAuctionServer {

    private DBMock db;

    public ItemProvider(DBMock db) {
        this.db = db;
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
        throw new UnsupportedOperationException();
    }

    @Override
    public Item getItem(String itemName) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void registerListener(IAuctionListener al, String itemName) {
        db.getItem(itemName).addBidStatusListener(al);
    }
}
