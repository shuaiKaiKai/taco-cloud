package tacos.controler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import tacos.config.ParamsConfig;
import tacos.data.dataApi.OrderRepository;
import tacos.data.dataApi.TacoRepository;
import tacos.model.Order;
import tacos.model.Taco;

@Slf4j
@RequestMapping("/orders")
@Controller
@SessionAttributes("order")
@ConfigurationProperties(prefix = "taco.orders")
public class OrderController {

    private OrderRepository orderRepo;

    private ParamsConfig paramsConfig;

    private TacoRepository tacoRepo;

    @Autowired
    public OrderController(OrderRepository orderRepo, ParamsConfig paramsConfig, TacoRepository tacoRepo) {
        this.orderRepo = orderRepo;
        this.paramsConfig = paramsConfig;
        this.tacoRepo = tacoRepo;
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

    /**
     * @param taco
     * @return
     */
    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Taco postTaco(@RequestBody Taco taco) {
        return tacoRepo.save(taco);
    }


    /**
     * 返回状态码200
     * @return
     */
    @RequestMapping(value = "/test", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Integer> test() {
        int i = paramsConfig.getPageSize();
        return new ResponseEntity<Integer>(i, HttpStatus.OK);
    }


}
