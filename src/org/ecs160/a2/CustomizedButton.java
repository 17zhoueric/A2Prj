package org.ecs160.a2;

import com.codename1.ui.Image;
import com.codename1.ui.util.Resources;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.Style;

import java.awt.*;
import java.io.IOException;

public class CustomizedButton extends Button {
    private String cellName;
    private Boolean filled = false;
    private Resources r;
    private Component comp;

    public CustomizedButton(String txt) {
        super(txt);
        try { r = Resources.open("/theme.res"); }
        catch (IOException e) { e.printStackTrace(); }
        this.getAllStyles().setFgColor(0xffffff);

        this.getAllStyles().setBgColor(0xffffff);
        this.getAllStyles().setBgTransparency(255);
        this.getAllStyles().setMargin(3, 3, 3,3);
        //this.setSize(new Dimension(8,10));

        cellName = txt;
    }

    public String getCell() { return cellName; }

    public Boolean isFilled() { return filled; }

    public void addComponent(String s) {
        Image image;

        switch(s) {
            case "AND Gate":
                image = r.getImage("and.png");
                comp = new ANDGate();
                break;
            case "NAND Gate":
                image = r.getImage("nand.png");
                comp = new NANDGate();
                break;
            case "NOR Gate":
                image = r.getImage("nor.png");
                comp = new NORGate();
                break;
            case "NOT Gate":
                image = r.getImage("not.png");
                comp = new NOTGate();
                break;
            case "OR Gate":
                image = r.getImage("or.png");
                comp = new ORGate();
                break;
            case "XNOR Gate":
                image = r.getImage("xnor.png");
                comp = new XNORGate();
                break;
            case "XOR Gate":
                image = r.getImage("xor.png");
                comp = new XORGate();
                break;
            case "Toggle":
                image = r.getImage("toggle_off.PNG");
                comp = new Toggle();
                break;
            case "LED":
                image = r.getImage("red_led.jpg");
                comp = new LED();
                break;
            case "Vertical":
                image = r.getImage("vertical.png");
                break;
            case "Horizontal":
                image = r.getImage("horizontal.png");
                break;
            case "nine o'clock":
                image = r.getImage("nine_o_clock.png");
                break;
            case "nine thirty":
                image = r.getImage("nine_thirty.png");
                break;
            case "six fifteen":
                image = r.getImage("six_fifteen.png");
                break;
            case "three o'clock":
                image = r.getImage("three_o_clock.png");
                break;
            default:
                image = r.getImage("white_square.PNG");
        }

        if (!filled) this.getAllStyles().setBgImage(image);
        filled = true;
    }

    public void removeComponent() {
        if (filled) { this.getAllStyles().setBgImage(null); }
        filled = false;
        this.comp = null;
    }
}