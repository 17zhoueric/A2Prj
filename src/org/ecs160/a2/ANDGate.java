package org.ecs160.a2;
import java.util.ArrayList;
import java.util.List;

public class ANDGate extends Gate{
    public ANDGate (ArrayList<Boolean> inputs) {
        super(inputs, inputs.get(0) && inputs.get(1));
    }

    public ANDGate() {}

    public void setInputs(List<Boolean> inputs) {
        this.inputs = inputs;
        output = inputs.get(0) && inputs.get(1);
    }

}