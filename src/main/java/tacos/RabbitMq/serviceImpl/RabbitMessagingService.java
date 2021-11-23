package tacos.RabbitMq.serviceImpl;


import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import tacos.model.Order;
import tacos.RabbitMq.OrderMessagingService;

/**
 * RabbitMQ发送异步消息
 */
public class RabbitMessagingService implements OrderMessagingService {

    @Autowired
    private RabbitTemplate rabbit;

    @Override
    public void sendOrder(Order order) {
        MessageConverter converter = rabbit.getMessageConverter();
        MessageProperties props = new MessageProperties();
        Message message = converter.toMessage(order, props);
        rabbit.send("tacocloud.order", message);
    }
}
