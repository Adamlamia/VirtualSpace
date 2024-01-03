// CategoryManager.java
package com.mycompany.VirtualSpace;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoryManager {

    private static final Map<String, List<String>> categories = new HashMap<>();

    static {
        categories.put("Animal", Arrays.asList("Clown Fish", "Dori"));
        categories.put("Plant", Arrays.asList("Seaweed", "Coral"));
        categories.put("Wreckage", Arrays.asList("Treasure", "Shipwreck"));
    }

    public static Map<String, List<String>> getCategories() {
        return categories;
    }
}
