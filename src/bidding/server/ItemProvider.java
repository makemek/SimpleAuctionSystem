package bidding.server;

/**
 * A middle man between bidding.client and database
 * Created by MakeMEK on 02/04/15.
 */
//TODO Implement ItemProvider functionality
public class ItemProvider implements IAuctionServer {

    public ItemProvider(DBMock db) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void placeItemForBid(String ownerName, String itemName, String itemDesc, double startBid, int auctionTime) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void bidOnItem(String bidderName, String itemName, double bid) {
        throw new UnsupportedOperationException();
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
        throw new UnsupportedOperationException();
    }
}