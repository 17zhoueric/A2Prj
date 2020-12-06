package org.ecs160.a2;

import java.util.ArrayList;
import java.util.List;

public class NOTGate extends Gate{
    public NOTGate (ArrayList<Boolean> inputs) {
        super(inputs, !inputs.get(0));
    }

    public NOTGate() {}

    public void setInputs(List<Boolean> inputs) {
        this.inputs = inputs;
        output = !inputs.get(0);
    }
}