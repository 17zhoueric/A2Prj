package org.ecs160.a2;

import java.util.ArrayList;
import java.util.List;

public class NANDGate extends Gate{
    public NANDGate (ArrayList<Boolean> inputs) {
        super(inputs, !(inputs.get(0) && inputs.get(1)));
    }

    public NANDGate() {}

    public void setInputs(List<Boolean> inputs) {
        this.inputs = inputs;
        output = !(inputs.get(0) && inputs.get(1));
    }
}