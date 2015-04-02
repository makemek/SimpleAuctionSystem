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

    /**
     * A testing scenario with
     * 1. 3 auction items, A, B, and C
     * 2. 2 bidders, Alice, Bob
     *
     * Scenario
     * 1. Alice bid A $10
     * 2. Bob bid A $20
     * 3. Bob bid B $5
     * @param args command-line arguments
     */
    public static void main(String... args) {
        Bidder bobPage = new Bidder("Bob");
        Bidder AlicePage = new Bidder("Alice");
        DBMock db = new DBMock();

        //TODO Implement scenarios and assumptions
        // pre-assumptions


        // scenario


        IAuctionServer provider = new ItemProvider(new DBMock());

    }

    @Override
    public void update(Item item) {
        //TODO Implement what to do when item is updated
        throw new UnsupportedOperationException();
    }
}