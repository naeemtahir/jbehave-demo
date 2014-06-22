package example.jbehave;

/**
 * 
 * @author Naeem Tahir
 *
 */
public class Item {
    
    private int id;
    private String description;
    private int quantity;

    public Item(int id, String description, int quantity) {
        this.id = id;
        this.description = description;
        this.quantity = quantity;
    }
    
    public int getId() {
        return id;
    }
    
    public String getDescription() {
        return description;
    
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((description == null) ? 0 : description.hashCode());
        result = prime * result + id;
        result = prime * result + quantity;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Item other = (Item) obj;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (id != other.id)
            return false;
        if (quantity != other.quantity)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Item [id=" + id + ", description=" + description
                + ", quantity=" + quantity + "]";
    }
}
