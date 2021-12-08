package tacos.controler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tacos.annotation.FruitName;

@RestController
public class Test {

    @FruitName(value = "苹果")
    private String name;

    @GetMapping("/testFruit")
    public String testFruit() {
        return name;
    }
}
