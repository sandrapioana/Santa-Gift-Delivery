package delivery;

import santa.ChildOutput;
import santa.SantaClaus;

import java.util.ArrayList;

public interface DeliveryStrategy {
    /**
     * Method that makes the delivery based on the input strategy
     */
    ArrayList<ChildOutput> makeDelivery(SantaClaus santa);
}
