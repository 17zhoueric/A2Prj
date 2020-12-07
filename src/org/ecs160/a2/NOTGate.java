package org.ecs160.a2;

import com.codename1.ui.Image;
import com.codename1.ui.util.Resources;

import java.io.IOException;

public class NOTGate implements StateChanger{

    private Resources r;
    private formApp app;
    private Integer gridCell;
    private Boolean output;
    private String name;
    private Image image;

    public NOTGate (formApp app, Integer gridCell, String name) {
        try { r = Resources.open("/theme.res"); }
        catch (IOException e) { e.printStackTrace(); }
        this.app = app;
        this.gridCell = gridCell;
        this.name = name;
        image = r.getImage("not.png");
        calculateOutput();
    }

    @Override
    public Boolean getOutput() {
        return output;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Image getImage() {
        calculateOutput();
        return image;
    }

    @Override
    public void updateState(Boolean state) { /* pass */ }

    // calculates state depending on the square to its left
    private void calculateOutput() {
        Boolean input = false;
        if (app.getWorkSpace().getGridCell(gridCell - 1).getStateChanger() != null &&
                app.getWorkSpace().getGridCell(gridCell - 1).getStateChanger().getName().equals("Horizontal")) {
            input = app.getWorkSpace().getGridCell(gridCell - 1).getStateChanger().getOutput();
        }
        output = !input;
    }
}