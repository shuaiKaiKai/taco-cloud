package tacos.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.handler.GenericHandler;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import tacos.model.Order;

/**
 * 通过消息处理器将订单提交至Taco Cloud API
 */
@Component
public class OrderSubmitMessageHandler implements GenericHandler<Order> {

    private RestTemplate rest;

    @Autowired
    private ApiProperties apiProps;

    @Override
    public Object handle(Order order, MessageHeaders messageHeaders) {
        rest.postForObject(apiProps.getUrl(), order, String.class);
        return null;
    }
}
