package tacos.controler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tacos.model.Order;

import javax.validation.Valid;

@Slf4j
@RequestMapping("/orders")
@Controller
public class OrderController {

    /**
     * 订单视图数据
     *
     * @param model
     * @return
     */
    @GetMapping("/current")
    public String orderForm(Model model) {
        // todo:先new一个，后续会从数据库中获取
        model.addAttribute("order", new Order());
        return "orderForm";
    }

    /**
     * 处理订单提交
     *
     * @param order
     * @return
     */
    @PostMapping
    public String processOrder(@Valid Order order, Errors errors) {
        if (errors.hasErrors()) {
            return "orderForm";
        }
        log.info("Order submitted: " + order);
        return "redirect:/";
    }
}
