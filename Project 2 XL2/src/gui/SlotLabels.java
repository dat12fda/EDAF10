package gui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.SwingConstants;

import model.Slot;
import model.SlotList;

public class SlotLabels extends GridPanel {
    private List<SlotLabel> labelList;

    public SlotLabels(int rows, int cols, Current current, SlotList slotList) {
        super(rows + 1, cols);
        labelList = new ArrayList<SlotLabel>(rows * cols);
        for (char ch = 'A'; ch < 'A' + cols; ch++) {
            add(new ColoredLabel(Character.toString(ch), Color.LIGHT_GRAY,
                    SwingConstants.CENTER));
        }
        for (int row = 1; row <= rows; row++) {
            for (char ch = 'A'; ch < 'A' + cols; ch++) {            	
            	SlotLabel label = new SlotLabel(current, String.valueOf(ch) + row);
                add(label);
                labelList.add(label);              
            }         
        }
        current.setCurrent(labelList.get(0));
    }
    
    public void updateLabels(SlotList slotList) {
    	for(SlotLabel label : labelList) {
    		Map hashMap = slotList.getHashMap(); 		
    		label.setText(slotList.input(hashMap.get(label.getName()).toString(), label.getName()));
    	}
    }    
}
