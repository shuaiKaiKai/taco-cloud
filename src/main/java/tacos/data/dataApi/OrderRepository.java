package tacos.data.dataApi;

import tacos.model.Order;

public interface OrderRepository {

    Order save(Order order);
}
