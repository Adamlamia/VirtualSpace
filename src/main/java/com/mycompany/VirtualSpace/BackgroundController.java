// BackgroundController.java
package com.mycompany.VirtualSpace;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BackgroundController {

    @PostMapping("/change-background")
    public String changeBackground(@RequestParam String option) {
        BackgroundDecorator decorator;

        switch (option) {
            case "over-the-sea":
                decorator = new OverTheSeaDecorator();
                break;
            case "in-the-sea":
                decorator = new InTheSeaDecorator();
                break;
            case "bottom-of-the-sea":
                decorator = new BottomOfTheSeaDecorator();
                break;
            default:
                decorator = new DefaultDecorator();
        }

        return decorator.getImagePath();
    }
}
