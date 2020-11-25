package org.ecs160.a2;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.Style;

import java.util.Hashtable;

public class menu extends Container {
    final Button clear = new Button("Clear Workspace");
    final Button delete = new Button("Delete");

    // Numeric is for number input
    TextField propagation_delay = new TextField("", "Propagation Delay", 5, TextArea.NUMERIC);

    //private Hashtable<String, CustomizedButton> buttons = new Hashtable<String, CustomizedButton>();
    public menu() {
        super();
        this.setLayout(new GridLayout(2, 1));
        this.getAllStyles().setBgColor(0x6890b3);
        this.getAllStyles().setBgTransparency(255);
        this.getAllStyles().setPadding(0, 200, 0, 0);
        Container top_row = new Container(new GridLayout(1, 2));
        top_row.add(clear);
        top_row.add(delete);
        this.add(top_row);
        this.add(propagation_delay);
    }
}
