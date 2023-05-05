package game.items;

/**
 * An interface for items that are sellable
 * @author Tong Jet Kit
 */
public interface Sellable {

    /**
     * To return the selling price of the item
     * @return An integer which is the selling price of the item
     */
    int getSellPrice();
}
