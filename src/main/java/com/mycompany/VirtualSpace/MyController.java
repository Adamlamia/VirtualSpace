// MyController.java
package com.mycompany.VirtualSpace;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/virtual-space")
public class MyController {

    private static final int GRID_SIZE = 9; // Adjust this based on your grid size

    @GetMapping("/choose-category")
    public String showCategoryPage(Model model) {
        Map<String, List<String>> categories = CategoryManager.getCategories();
        model.addAttribute("categories", categories);
        model.addAttribute("gridSize", GRID_SIZE);
        return "choose-category";
    }

    @PostMapping("/display-item")
    public String displayItem(String category, String item, int row, int column, Model model) {
        // Calculate the grid position
        int position = row * GRID_SIZE + column;

        // Construct the path based on the category and item
        String imagePath = constructImagePath(category, item);

        // Pass the grid position and image path to the view
        model.addAttribute("position", position);
        model.addAttribute("imagePath", imagePath);
        return "display-item";
    }

    private String constructImagePath(String category, String item) {
        String categoryPath = category.toLowerCase();
        String itemPath = item.toLowerCase() + ".png";

        // Use Paths to construct the path safely
        Path imagePath = Paths.get("/images", categoryPath, itemPath);

        // Convert the Path to a String
        return imagePath.toString();
    }
}
