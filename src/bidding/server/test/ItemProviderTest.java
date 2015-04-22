package bidding.server.test;

import bidding.server.DBMock;
import bidding.server.IAuctionListener;
import bidding.server.Item;
import bidding.server.ItemProvider;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ItemProviderTest {

    String itemName = "itm";
    String ownerName = "owner";

    ItemProvider provider1Item;
    ItemProvider providerNoItem;

    Item itemDummy;
    final double ITEM_PRICE = 10;
    final int AUCTION_TIME = 100;

    @Before
    public void setup() {
        itemDummy = new Item(ownerName, itemName, "", ITEM_PRICE);

        provider1Item = ItemProvider.instance();
        provider1Item.placeItemForBid(ownerName, itemName, "", ITEM_PRICE, AUCTION_TIME);
        providerNoItem = ItemProvider.instance();
    }

    @Test
    public void placeNewItemForBid() throws Exception {
        double bidPrice = 20;
        providerNoItem.placeItemForBid(ownerName, itemName, "", bidPrice, 100);

        // verify that item is in database
        Item itm = providerNoItem.getItem(itemName);
        assertNotNull(itm);

        // same item ?
        assertEquals(itemDummy, itm);
    }

    @Test(expected = ArrayStoreException.class)
    public void placeAlreadyExistingItem() {
        provider1Item.placeItemForBid(ownerName, itemName, "", ITEM_PRICE, AUCTION_TIME);
    }

    @Test
    public void testBidOnItem() throws Exception {
        // register observer
        MockObs obs = new MockObs();
        provider1Item.registerListener(obs, itemDummy.getItemName());

        // bid item with higher price
        itemDummy = provider1Item.getItem(itemName);
        itemDummy.bid("Bob", ITEM_PRICE + 1);

        // verify that observer received notification
        assertTrue(obs.notified);
        assertEquals(obs.received, itemDummy);
    }

    @Test
    public void testRegisterListener() throws Exception {
        MockObs obs = new MockObs();
        itemDummy.addBidStatusListener(obs);

        assertEquals(itemDummy.getListeners()[0], obs);
    }

    @Test
    public void singleton() {
        assertEquals(ItemProvider.instance(), ItemProvider.instance());
    }
}

class MockObs implements IAuctionListener {
    boolean notified = false;
    Item received;

    @Override
    public void update(Item item) {
        notified = true;
        received = item;
    }
}