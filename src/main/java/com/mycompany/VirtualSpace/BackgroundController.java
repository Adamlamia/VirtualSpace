package com.mycompany.VirtualSpace;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BackgroundController {

    @PostMapping("/change-background")
    public String changeBackground(@RequestParam String option) {
        // Define the paths for the three background options
        String imagePath = "/images/";
        switch (option) {
            case "over-the-sea":
                imagePath += "over_the_sea.jpg";
                break;
            case "in-the-sea":
                imagePath += "in_the_sea.jpg";
                break;
            case "bottom-of-the-sea":
                imagePath += "bottom_of_the_sea.jpg";
                break;
            default:
                imagePath += "default.jpg";
        }

        // Return the updated background image path
        return imagePath;
    }
}
