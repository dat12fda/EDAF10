package gui;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingConstants;

import model.Slot;
import model.SlotList;

public class SlotLabels extends GridPanel {
	private List<SlotLabel> labelList;

	
	
	public SlotLabels(int rows, int cols, SlotList slots) {
		super(rows + 1, cols);
		labelList = new ArrayList<SlotLabel>(rows * cols);
		for (char ch = 'A'; ch < 'A' + cols; ch++) {
			add(new ColoredLabel(Character.toString(ch), Color.LIGHT_GRAY,
					SwingConstants.CENTER));
		}
		for (int row = 1; row <= rows; row++) {
			for (char ch = 'A'; ch < 'A' + cols; ch++) {
				SlotLabel label = new SlotLabel();
				slots.get(row - 1).addObserver(label);
				add(label);
				labelList.add(label);
			}
		}
		SlotLabel firstLabel = labelList.get(5);
		firstLabel.setBackground(Color.YELLOW);
	}

	public int getIndex(SlotLabel sl) {
		return labelList.indexOf(sl);
	}

	public List<SlotLabel> getList() {
		return labelList;

	}

}