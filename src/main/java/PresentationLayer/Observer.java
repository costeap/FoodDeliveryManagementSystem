package PresentationLayer;

import BusinessLayer.Order;

public interface Observer {
    void update(Order order);
}
