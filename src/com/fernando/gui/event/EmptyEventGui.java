package com.fernando.gui.event;

import com.fernando.gui.utils.XY;
import com.fernando.gui.enums.EventGuiEnum;

public class EmptyEventGui extends EventGui {
    public EmptyEventGui() {
        super(new XY(-1, -1), EventGuiEnum.EMPTY);
    }
}
