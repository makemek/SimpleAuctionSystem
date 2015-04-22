package bidding.scenario;

import bidding.client.Bidder;
import bidding.server.DBMock;
import bidding.server.IAuctionServer;
import bidding.server.Item;
import bidding.server.ItemProvider;

/**
 * A testing scenario with
 * 1. 3 auction items, A, B, and C
 * 2. Eve is the owner of item A:5$, B:10$, and C:15$
 * 3. 2 bidders, Alice, Bob
 *
 * Scenario
 * 1. Alice bid A $10
 * 2. Bob bid A $20
 * 3. Bob bid B $5
 *
 * Expected Results
 * Item A: Bob win the bid
 * Item B: Bob fail to bid (bid lower than original price)
 * Item C: Nobody bid this item
 */
public class NormalBidding {
    private static String ownerName = "Eve";
    private static Item itemA = new Item(ownerName, "A", "", 5);
    private static Item itemB = new Item(ownerName, "B", "", 10);
    private static Item itemC = new Item(ownerName, "C", "", 15);
    private static Item[] items = {itemA, itemB, itemC};

    public static void main(String... args) {
        Bidder bobPage = new Bidder("Bob");
        Bidder alicePage = new Bidder("Alice");

        // pre-assumptions
        String ownerName = "Eve";
        IAuctionServer provider = ItemProvider.instance();
        for(Item itm: items)
            provider.placeItemForBid(itm.getOwner(), itm.getItemName(),
                    itm.getDescription(), itm.getBiddingPrice(), 100);

        // alice subscribe for bidding price change
        provider.getItem(itemA.getItemName()).addBidStatusListener(alicePage);

        // list all items before changes
        items = provider.getItems();
        System.out.println("Before scenario begins");
        for(Item itm: items)
                displayItemInfo(itm);
        System.out.println("***************************************");

        // scenario
        provider.bidOnItem(alicePage.getName(), itemA.getItemName(), 10);
        provider.bidOnItem(bobPage.getName(), itemA.getItemName(), 20);
        provider.bidOnItem(bobPage.getName(), itemB.getItemName(), 5);

        // list all items after changes
        System.out.println("After scenario");
        for(Item itm: items)
            displayItemInfo(itm);
    }

    private static void displayItemInfo(Item itm) {
        System.out.println("\n--------------");
        System.out.println("Item name: " + itm.getItemName());
        System.out.println("Owner: " + itm.getOwner());
        System.out.println("Price: " + itm.getBiddingPrice());
        System.out.println("Bidder name: " + itm.getBidderName());
        System.out.println("--------------");
    }
}
