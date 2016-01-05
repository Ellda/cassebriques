package commandMenu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

/**
 * CommandButton implements the invoker interface. It's the concrete invoker of
 * our Command Pattern.
 * 
 * @author Antoine Fonfria - 14 129 748
 * @author Baptiste Jaeckert 14 129 775
 * @author Jonathan Diaz-Muy 13 041 479
 * @author Adrien Burel 14 126 607
 * @author Landry Modeste Goutondji 14 000 626
 * @author J�r�my Collard 14 129 766
 * @author Mentor Bajraktari 14 129 757
 * @author Olivier Scheffler 12 179 288
 * @author Elliot G�mus-Pr�vost 13 111 198
 * @author Samuel Arseneault 13 161 801
 * @author Djenebou Monique Dembele 10 103 210
 * @author Florent Gargot 14 129 784
 */

@SuppressWarnings("serial")
public class CommandButton extends JButton implements Invoker, ActionListener {

	private Command command;

	public CommandButton(String label) {
		super(label);
		this.setBackground(new Color(153, 204, 255));
		this.setFont(new Font("Calibri Light", Font.BOLD, this.getFont()
				.getSize()));
		this.setBorder(new LineBorder(new Color(153, 204, 255), 12));
		this.addActionListener(this);
	}

	@Override
	public void storeCommand(Command c) {

		command = c;
	}

	@Override
	public void actionPerformed(ActionEvent evt) {

		command.execute();

	}

}
