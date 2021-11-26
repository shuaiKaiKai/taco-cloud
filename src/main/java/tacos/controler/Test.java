package tacos.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import tacos.annotation.FruitName;

@Controller
public class Test {

    @FruitName(value = "苹果")
    private String name;

    @GetMapping("/testFruit")
    public void testFruit() {
        System.out.println(this.name);
    }
}
