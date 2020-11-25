package org.ecs160.a2;


import static com.codename1.ui.CN.*;

import com.codename1.ui.*;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.io.Log;
import com.codename1.ui.layouts.BoxLayout;

import java.io.IOException;

/**
 * This file was generated by <a href="https://www.codenameone.com/">Codename One</a> for the purpose 
 * of building native mobile applications using Java.
 */
public class AppMain {

    private Form current;
    private Resources theme;
    private Resources gates;

    public void init(Object context) {
        // use two network threads instead of one
        updateNetworkThreadCount(2);

        theme = UIManager.initFirstTheme("/theme");

        // Enable Toolbar on all Forms by default
        Toolbar.setGlobalToolbar(true);

        // Pro only feature
        Log.bindCrashProtection(true);

        addNetworkErrorListener(err -> {
            // prevent the event from propagating
            err.consume();
            if(err.getError() != null) {
                Log.e(err.getError());
            }
            Log.sendLogAsync();
            Dialog.show("Connection Error", "There was a networking error in the connection to " + err.getConnectionRequest().getUrl(), "OK", null);
        });
        try {
            gates = Resources.open("/theme.res");
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    
    public void start() {
        if(current != null){
            current.show();
            return;
        }

        Form hi = new Form("Logic Simulator", BoxLayout.y());

        // retrieving gate images from the theme.res
        /*final Button andGate = new Button(gates.getImage("and.png"));
        final Button nandGate = new Button(gates.getImage("nand.png"));
        final Button norGate = new Button(gates.getImage("nor.png"));

        final Button xnorGate = new Button(gates.getImage("xnor.png"));
        final Button orGate = new Button(gates.getImage("or.png"));
        final Button notGate = new Button(gates.getImage("not.png"));
        final Button xorGate = new Button(gates.getImage("xor.png"));*/

        // buttons only:
        final Button andGate = new Button("AND Gate");
        final Button nandGate = new Button("NAND Gate");
        final Button norGate = new Button("NOR Gate");

        final Button xnorGate = new Button("XNOR Gate");
        final Button orGate = new Button("OR Gate");
        final Button notGate = new Button("NOT Gate");
        final Button xorGate = new Button("XOR Gate");

        final Button led = new Button("LED");
        final Button toggle = new Button("Toggle");

        final Button trash = new Button("Trash");
        final Button clear = new Button("Clear");

        // allow gates to be draggable
//        andGate.setDraggable(true);
//        nandGate.setDraggable(true);
//        norGate.setDraggable(true);
//        xnorGate.setDraggable(true);
//
//        orGate.setDraggable(true);
//        notGate.setDraggable(true);
//        xorGate.setDraggable(true);

        // remove default button styling
//        andGate.setUIID("Label"); nandGate.setUIID("Label"); norGate.setUIID("Label");
//        xnorGate.setUIID("Label"); orGate.setUIID("Label"); notGate.setUIID("Label");
//        xorGate.setUIID("Label");

        // creation of tool bar with gates
        Container toolBar = new Container();
        toolBar.setLayout(new GridLayout(1, 11));
        toolBar.add(trash); toolBar.add(clear); toolBar.add(led); toolBar.add(toggle); toolBar.add(andGate); toolBar.add(nandGate); toolBar.add(norGate);
        toolBar.add(xnorGate); toolBar.add(orGate); toolBar.add(notGate);
        toolBar.add(xorGate);
        toolBar.setScrollableX(true);

        //hi.add(new Label("Hi World"));

       // toolBar tooBar = new toolBar();
        workSpace workSpc = new workSpace();
        workSpc.setScrollableX(false);

        menu main_menu = new menu();


        // form for the workspace, gates, and title
        appLogic logic = new appLogic(main_menu, workSpc, toolBar);
        formApp app = new formApp(main_menu, workSpc, toolBar);
        workSpc.setDropTarget(true);

        app.show();

        //hi.show();
    }

    public void stop() {
        current = getCurrentForm();
        if(current instanceof Dialog) {
            ((Dialog)current).dispose();
            current = getCurrentForm();
        }
    }
    
    public void destroy() {
    }

}
