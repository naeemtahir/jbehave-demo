package example.jbehave;

/**
 * 
 * @author Naeem Tahir
 *
 */
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    
    String customerId;
    private Map<Integer, Item> cartInternal;
    

    public ShoppingCart(String customerId) {
        this.customerId = customerId;
        this.cartInternal = new HashMap<Integer, Item>();
    }

    public void addItem(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Can't add null item");
        } else {
            this.cartInternal.put(Integer.valueOf(item.getId()), item);
        }
    }

    public Item removeItem(Integer itemId) {
        return this.cartInternal.remove(itemId);
    }
    
    public Item getItem(Integer itemId) {
        return this.cartInternal.get(itemId);
    }    
    
    public void updateQuantity(String itemId, int qty) {
        Item item = cartInternal.get(itemId);
        item.setQuantity(qty);
    }
    
    public int getSize() {
        return cartInternal.size();
    }
    
    Collection<Item> listItems() {
        return cartInternal.values();
    }
}
