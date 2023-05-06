package game.items;

/**
 * An interface for items that are sellable
 * @author Tong Jet Kit
 * @Version 1.0
 */
public interface Sellable {

    /**
     * To return the selling price of the item
     * @return An integer which is the selling price of the item
     */
    int getSellPrice();
}
