package tacos.Kafka.impl;

import tacos.model.Order;

public interface OrderMessagingService {

    void sendOrder(Order order);
}
