package org.ecs160.a2;
import com.codename1.ui.Image;
import com.codename1.ui.util.Resources;

import java.io.IOException;
import java.util.ArrayList;

public class ORGate implements StateChanger{

    private Resources r;
    private formApp app;
    private Integer gridCell;
    private Boolean output;
    private String name;
    private Image image;

    public ORGate (formApp app, Integer gridCell, String name) {
        try { r = Resources.open("/theme.res"); }
        catch (IOException e) { e.printStackTrace(); }
        this.app = app;
        this.gridCell = gridCell;
        this.name = name;
        image = r.getImage("or.png");
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

    // calculates state depending on the square to its left and the square directly below it
    private void calculateOutput() {
        ArrayList<Boolean> inputs = new ArrayList<Boolean>();
        if (app.getWorkSpace().getGridCell(gridCell - 1).getStateChanger() != null)
            inputs.add(app.getWorkSpace().getGridCell(gridCell - 1).getStateChanger().getOutput());
        if (app.getWorkSpace().getGridCell(gridCell + 8).getStateChanger() != null
                && !app.getWorkSpace().getGridCell(gridCell + 8).getStateChanger().getName().equals("Horizontal"))
            inputs.add(app.getWorkSpace().getGridCell(gridCell + 8).getStateChanger().getOutput());
        if (inputs.size() == 2) output = inputs.get(0) || inputs.get(1);
        else output = false;
    }
}