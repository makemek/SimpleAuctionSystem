package bidding.server;

/**
 * A listener for changes in the item Whenever the current bid on the specified item
 changes (or its auction period expires), the IAuctionListener is notified via its
 update() method.
 * Created by MakeMEK on 02/04/15.
 */
public interface IAuctionListener {

    /**
     * Notify observer on bidding price changes
     * @param item An item with updated bidding price
     */
    public void update(Item item);
}
