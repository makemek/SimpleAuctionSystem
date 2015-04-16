package bidding.client;

import bidding.server.*;

/**
 * Shows auction of interest
 * Created by MakeMEK on 02/04/15.
 */
public class Bidder implements IAuctionListener {

    private String bidderName;

    public Bidder(String bidderName) {
        this.bidderName = bidderName;
    }

    public String getName() {return bidderName;}

    @Override
    public void update(Item item) {
        System.out.println("New bid");
        System.out.println("Bidder: " + item.getBidderName());
        System.out.println("Price: " + item.getBiddingPrice());
        System.out.println("-------------------------------------");
    }


}