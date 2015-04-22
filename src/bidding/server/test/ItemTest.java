package bidding.server.test;

import bidding.server.DBMock;
import bidding.server.Item;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class ItemTest {

    Item item;
    String bidderName = "alice";
    String ownerName = "owner";
    int bidPrice = 5;
    @Before
    public void setup() {
        item = new Item(ownerName, "itm1", "desc", bidPrice);
    }

    @Test
    public void ownerBidHisItem() {
        assertFalse(item.bid(ownerName, bidPrice));
    }

    @Test
    public void bid_negative() {
        assertFalse(bidItem(-1));
    }

    @Test
    public void bid_zero() {
        assertFalse(bidItem(0));
    }

    @Test
    public void bid_less_price() {
        assertFalse(bidItem(bidPrice - 1));
    }

    @Test
    public void bid_same_price() {
        assertFalse(bidItem(bidPrice));
    }

    @Test
    public void bid_higher_price() {
        assertTrue(bidItem(bidPrice + 1));
    }

    private boolean bidItem(double price) {
        return item.bid(bidderName, price);
    }
}