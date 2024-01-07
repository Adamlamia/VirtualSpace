package com.mycompany.VirtualSpace;

public class DefaultDecorator implements BackgroundDecorator {

    @Override
    public String getImagePath() {
        // Uncomment the following line and provide the correct image path
        return "/images/default.jpg";
    }
    
}
