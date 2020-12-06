package org.ecs160.a2;

import java.util.ArrayList;
import java.util.List;

public class XNORGate extends Gate{
    public XNORGate (ArrayList<Boolean> inputs) {
        super(inputs, inputs.get(0) == inputs.get(1));
    }

    public XNORGate() {}

    public void setInputs(List<Boolean> inputs) {
        this.inputs = inputs;
        output = inputs.get(0) == inputs.get(1);
    }
}