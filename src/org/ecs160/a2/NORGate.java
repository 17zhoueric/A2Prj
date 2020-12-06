package org.ecs160.a2;

import java.util.ArrayList;
import java.util.List;

public class NORGate extends Gate{
    public NORGate (ArrayList<Boolean> inputs) {
        super(inputs, !(inputs.get(0) || inputs.get(1)));
    }

    public NORGate() {}

    public void setInputs(List<Boolean> inputs) {
        this.inputs = inputs;
        output = !(inputs.get(0) || inputs.get(1));
    }
}