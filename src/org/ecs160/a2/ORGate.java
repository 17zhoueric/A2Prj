package org.ecs160.a2;
import com.codename1.ui.util.Resources;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ORGate extends Component {
    public ORGate() {}

    public ORGate (Integer gridCell, String name) {
        try { r = Resources.open("/theme.res"); }
        catch (IOException e) { e.printStackTrace(); }
        this.gridCell = gridCell;
        this.name = name;
        image = r.getImage("or.png");
        delay = 0;
    }

    // calculates state depending on the square to its left and the square directly above it
    @Override
    public void calculateOutput(formApp app) {
        List<Integer> inputs = getInputs(app);
        List<Integer> delays = new ArrayList<>();

        if (inputs.size() == 2){
            output = inputs.get(0) | inputs.get(1);
        }
        else output = -1;
    }

    @Override
    public int getVersion() {
        return 0;
    }

    @Override
    public String getObjectId() {
        return "OR";
    }
}