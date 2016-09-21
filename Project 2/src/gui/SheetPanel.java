package gui;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.WEST;
import model.SlotList;

public class SheetPanel extends BorderPanel {
    public SheetPanel(int rows, int columns, SlotList slots) {
        add(WEST, new RowLabels(rows));
        add(CENTER, new SlotLabels(rows, columns, slots));
    }
}