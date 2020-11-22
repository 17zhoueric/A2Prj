package org.ecs160.a2;

import com.codename1.ui.Container;
import com.codename1.ui.layouts.BoxLayout;

public class workSpace extends Container {
    public workSpace() {
        super();
        this.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
      //  this.getAllStyles().setBgColor(0x000000);//0xD4E6F1); //top screen
        this.getAllStyles().setBgTransparency(255);
    }
}
