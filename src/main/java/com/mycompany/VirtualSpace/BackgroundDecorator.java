package com.mycompany.VirtualSpace;

public interface BackgroundDecorator {
    String getImagePath();
}

class OverTheSeaDecorator implements BackgroundDecorator {
    @Override
    public String getImagePath() {
        return "/images/over_the_sea.jpg";
    }
}

class InTheSeaDecorator implements BackgroundDecorator {
    @Override
    public String getImagePath() {
        return "/images/in_the_sea.jpg";
    }
}

class BottomOfTheSeaDecorator implements BackgroundDecorator {
    @Override
    public String getImagePath() {
        return "/images/bottom_of_the_sea.jpg";
    }
}

class DefaultDecorator implements BackgroundDecorator {
    @Override
    public String getImagePath() {
        return "/images/default.jpg";
    }
}
