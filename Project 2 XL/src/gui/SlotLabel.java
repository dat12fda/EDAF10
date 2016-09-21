package gui;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;

public class SlotLabel extends ColoredLabel implements Observer {
	public SlotLabel() {
		super("                    ", Color.WHITE, RIGHT);
		addMouseListener(new ClickListener());

	}

	private class ClickListener extends MouseAdapter {
		public void mouseClicked(MouseEvent event) {
			setBackground(Color.YELLOW);

			// notify editorn och currentLabeln
			// observe editor och currentLabeln

		}
	}

	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
	}
}