
package org.ecs160.a2;

import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BorderLayout;

public class formApp extends Form {

    public formApp(Form other, workSpace workSpaceRef, Container toolBarRef) {
        super("Test");
        this.setLayout(new BorderLayout());

        this.add(BorderLayout.NORTH, other);
        this.add(BorderLayout.CENTER, workSpaceRef);
        this.add(BorderLayout.SOUTH, toolBarRef);
    }
}