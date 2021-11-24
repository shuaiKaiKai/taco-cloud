package tacos.Kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import tacos.Kafka.impl.OrderMessagingService;
import tacos.model.Order;

public class KafkaOrderMessagingService implements OrderMessagingService {

    @Autowired
    private KafkaTemplate<String, Order> kafkaTemplate;

    @Override
    public void sendOrder(Order order) {
        kafkaTemplate.send("tacacloud.order.topic", order);
        // 设置默认的发送主题
        kafkaTemplate.sendDefault(order);
    }
}
