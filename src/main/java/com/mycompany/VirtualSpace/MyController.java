package com.mycompany.VirtualSpace;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/virtual-space")
public class MyController {

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("imageForm", new ImageForm());
        return "index";
    }

    @PostMapping("/process")
    public String processForm(ImageForm imageForm, Model model) {
        // Logic to determine the selected image path based on category and subcategory
        String selectedImagePath = determineImagePath(imageForm.getCategory(), imageForm.getSubcategory());

        // Add selected image path to the model
        model.addAttribute("selectedImagePath", selectedImagePath);

        // Populate the model with subcategories based on the selected category
        List<String> subcategories = getSubcategories(imageForm.getCategory());
        model.addAttribute("subcategories", subcategories);

        return "index";
    }

    private String determineImagePath(String category, String subcategory) {

        // Define a mapping between categories, subcategories, and image paths
        Map<String, Map<String, String>> imagePathMapping = new HashMap<>();

        // Animal category
        Map<String, String> animalImages = new HashMap<>();
        animalImages.put("Clown Fish", "/images/animal/clownfish.jpg");
        animalImages.put("Dori", "/images/animal/dori.jpg");
        // Add other animal subcategories and their image paths
        imagePathMapping.put("animal", animalImages);

        // Plant category
        Map<String, String> plantImages = new HashMap<>();
        plantImages.put("Seaweed", "/images/plant/seaweed.jpg");
        plantImages.put("Coral", "/images/plant/coral.jpg");
        // Add other plant subcategories and their image paths
        imagePathMapping.put("plant", plantImages);

        // Wreckage category
        Map<String, String> wreckageImages = new HashMap<>();
        wreckageImages.put("Treasure", "/images/wreckage/treasure.jpg");
        wreckageImages.put("Shipwreck", "/images/wreckage/shipwreck.jpg");
        // Add other wreckage subcategories and their image paths
        imagePathMapping.put("wreckage", wreckageImages);

        // Retrieve the image path based on the provided category and subcategory
        return imagePathMapping.getOrDefault(category, Collections.emptyMap())
                .getOrDefault(subcategory, "/images/default.jpg");
    }

    private List<String> getSubcategories(String category) {
    
        // Define a mapping between categories and their subcategories
        Map<String, List<String>> subcategoriesMapping = new HashMap<>();
        
        // Animal category
        subcategoriesMapping.put("animal", Arrays.asList("Clown Fish", "Dori", "Shark", "Squid", "Octopus", "Tuna"));
    
        // Plant category
        subcategoriesMapping.put("plant", Arrays.asList("Seaweed", "Coral", "Kelp"));
    
        // Wreckage category
        subcategoriesMapping.put("wreckage", Arrays.asList("Treasure", "Shipwreck", "Submarine", "Cargo Box"));
    
        // Debugging output
        List<String> subcategories = subcategoriesMapping.getOrDefault(category, Collections.emptyList());
        System.out.println("Subcategories for category " + category + ": " + subcategories);
    
        return subcategories;
    }
    

}
