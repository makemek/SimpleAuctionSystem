package bidding.server;

import java.util.ArrayList;
import java.util.List;

/**
 * A mock database store auction item
 * Created by MakeMEK on 02/04/15.
 */
//TODO Implement DBMock functionality
public class DBMock {

    private List<Item> items = new ArrayList<Item>();

    /**
     * Get auction item by name
     * @param itemName name of the item
     * @return An item of the specified name
     */
    public Item getItem(String itemName) {
        throw new UnsupportedOperationException();
    }

    /**
     * Get all available items
     * @return an array of Item
     */
    public Item[] getItems() {
        throw new UnsupportedOperationException();
    }

    /**
     * Add a new item to a database. If an item with the same name already exits, throws an exception
     * @param item An item to be added
     * @throws java.lang.IllegalArgumentException
     */
    public void addItem(Item item) {
        throw new UnsupportedOperationException();
    }
}
