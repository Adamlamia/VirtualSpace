// BackgroundController.java
package com.mycompany.VirtualSpace;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BackgroundController {

    private SoundController soundController = new SoundController();

    @PostMapping("/change-background")
    public String changeBackground(@RequestParam String option) {
        BackgroundDecorator decorator;

        switch (option) {
            case "over-the-sea":
                decorator = new OverTheSeaDecorator();
                soundController.addObserver(new ShipBellObserver());
                break;
            case "in-the-sea":
                decorator = new InTheSeaDecorator();
                soundController.addObserver(new SeaWaveObserver());
                break;
            case "bottom-of-the-sea":
                decorator = new BottomOfTheSeaDecorator();
                soundController.addObserver(new SeaBirdObserver());
                break;
            default:
                decorator = new DefaultDecorator();
        }

        // Uncomment the following lines and return decorator.getImagePath();
        soundController.notifyObservers();
        return decorator.getImagePath();
    }
}
