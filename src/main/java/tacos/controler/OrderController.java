package tacos.controler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import tacos.data.dataApi.OrderRepository;
import tacos.model.Order;

@Slf4j
@RequestMapping("/orders")
@Controller
@SessionAttributes("order")
public class OrderController {

    private OrderRepository orderRepo;


    @Autowired
    public OrderController(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }


    /**
     * 订单视图数据
     *
     * @return
     */
    @GetMapping("/current")
    public String orderForm() {
        return "orderForm";
    }

    /**
     * 处理订单提交
     *
     * @param order
     * @return
     */
    @PostMapping
    public String processOrder(Order order, Errors errors, SessionStatus sessionStatus) {
        if (errors.hasErrors()) {
            return "orderForm";
        }

        orderRepo.save(order);
        log.info("Order submitted: " + order);
        sessionStatus.setComplete();
        return "redirect:/";
    }
}
