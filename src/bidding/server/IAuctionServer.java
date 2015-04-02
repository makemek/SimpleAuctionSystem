package bidding.server;

/**
 * An interface with the bidding.server
 * Created by MakeMEK on 02/04/15.
 */
public interface IAuctionServer {
    /**
     * Puts a new item up for auction.
     * If an item by that name already is up for auction in the bidding.server, an Exception is thrown
     * @param ownerName name of the owner
     * @param itemName name of the item
     * @param itemDesc description of the item
     * @param startBid minimum bid
     * @param auctionTime when will the item be available for auction
     */
    public void placeItemForBid(String ownerName, String itemName,
                                String itemDesc, double startBid, int auctionTime);

    /**
     * The bidder with name bidderName makes a new bid on the item specified by
     * the itemName argument. The bid amount is specified by the bid argument.
     * For the bid to be accepted it must be higher than the current bid on the
     * specified item, else an Exception is thrown.
     * @param bidderName name of the bidder
     * @param itemName name of the item
     * @param bid the amount of bid (must be higher than current bid)
     */
    public void bidOnItem(String bidderName, String itemName, double bid);

    /**
     * get items available for auction
     * @return an array of items available for auction
     */
    public Item[] getItems();

    /**
     * Returns the item for auction specified by itemName.
     * @param itemName name of the item
     * @return auction item
     */
    public Item getItem(String itemName);

    /**
     * Registers a listener with the auction bidding.server for changes in the item specified
     * by the itemName argument. Whenever the current bid on the specified item
     * changes (or its auction period expires), the IAuctionListener is notified via its
     * update() method.
     * @param al an auction listener
     * @param itemName name of the item
     */
    public void registerListener(IAuctionListener al, String itemName);
}
