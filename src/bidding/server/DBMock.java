package bidding.server;

import java.util.ArrayList;
import java.util.List;

/**
 * A mock database store auction item
 * Created by MakeMEK on 02/04/15.
 */
public class DBMock {

    private List<Item> items = new ArrayList<Item>();

    /**
     * Get auction item by name
     * @param itemName name of the item
     * @return An item of the specified name
     * @throws java.lang.IllegalArgumentException If given itemName is not found
     */
    public Item getItem(String itemName) {
        for(Item item: items)
            if(item.itemName.equalsIgnoreCase(itemName))
                return item;
        throw new IllegalArgumentException("Item: " + itemName + " not found");
    }

    /**
     * Get all available items
     * @return an array of Item
     */
    public Item[] getItems() {
        return items.toArray(new Item[items.size()]);
    }

    /**
     * Add a new item to a database. If an item with the same name already exits, throws an exception
     * @param item An item to be added
     * @throws java.lang.IllegalArgumentException
     */
    public void addItem(Item item) {
        if(items.contains(item))
            throw new ArrayStoreException("item already exists!");
        items.add(item);
    }
}
