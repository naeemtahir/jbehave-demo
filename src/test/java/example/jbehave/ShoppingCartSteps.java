package example.jbehave;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;

/**
 * 
 * @author Naeem Tahir
 *
 */
public class ShoppingCartSteps extends Steps {
    ShoppingCart shoppingCart;
    
    @BeforeScenario
    public void setUp() {
        shoppingCart = new ShoppingCart("testUser");
    }

    @Given("a non-empty shopping cart")
    public void populateCart() {
        // populate cart
        shoppingCart.addItem(new Item(100, "Scent of a Woman", 1));
        shoppingCart.addItem(new Item(200, "Godfather", 1));
        shoppingCart.addItem(new Item(300, "City of God", 1));
    }
    
    @When("user removes an item from the cart")
    public void removeItem() {
        shoppingCart.removeItem(200);
    }

    @Then("cart has one less items")
    public void verifyItemCount() {
        assertEquals(2, shoppingCart.getSize());
    }
    
    @Then("removed item is no longer in the cart")
    public void verifyItemRemoved() {
        assertNull(shoppingCart.getItem(200));
    }
}
