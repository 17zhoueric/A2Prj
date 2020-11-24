package org.ecs160.a2;

import java.util.*;
import static com.codename1.ui.CN.*;
import static com.codename1.ui.CN.*;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Dialog;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.*;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.util.Resources;
import com.codename1.ui.plaf.UIManager;

import java.io.IOException;

//nav bar
public class toolBar extends Container {
    private Resources theme;
    final Button andGate = new Button(theme.getImage("and.png"));
    final Button nandGate = new Button(theme.getImage("nand.png"));
    final Button norGate = new Button(theme.getImage("nor.png"));

    final Button xnorGate = new Button(theme.getImage("xnor.png"));
    final Button orGate = new Button(theme.getImage("or.png"));
    final Button notGate = new Button(theme.getImage("not.png"));
    final Button xorGate = new Button(theme.getImage("xor.png"));

   // private Hashtable<String, buttonDecorator> buttons = new Hashtable<String, buttonDecorator>();

    public toolBar() {
        super();
        this.setLayout(new GridLayout(1, 10));
        this.getAllStyles().setBgColor(0x000000);//0xF4ECF7); // background is pinkish
        this.getAllStyles().setBgTransparency(255);
        this.add(andGate); this.add(nandGate); this.add(norGate);
        this.add(xnorGate); this.add(orGate); this.add(notGate);
        this.add(xorGate);


    }

   /* public buttonDecorator getButton(String buttonName) {
        return buttons.get(buttonName);
    }*/
}