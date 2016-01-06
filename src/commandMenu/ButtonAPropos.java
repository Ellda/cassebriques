package commandMenu;

import javax.swing.JOptionPane;

/**
 * Concrete command that handles a menu event.
 * 
 * @author Antoine Fonfria - 14 129 748
 * @author Baptiste Jaeckert 14 129 775
 * @author Jonathan Diaz-Muy 13 041 479
 * @author Adrien Burel 14 126 607
 * @author Landry Modeste Goutondji  14 000 626
 * @author J�r�my Collard 14 129 766
 * @author Mentor Bajraktari 14 129 757
 * @author Olivier Scheffler 12 179 288
 * @author Elliot G�mus-Pr�vost 13 111 198
 * @author Samuel Arseneault 13 161 801
 * @author Djenebou Monique Dembele 10 103 210
 * @author Florent Gargot 14 129 784
 */

public class ButtonAPropos extends Command { 
   private static String text = 
		    "<html><h1><span style='font-size: medium;'>&Eacute;quipe de d&eacute;veloppement</span></h1>" +
		    "<ul>" + 
			"<li><span style='color: #333399;'><strong>Adrien Burel</strong></span></li>" + 
			"<li><span style='color: #333399;'><strong>Antoine Fonfria</strong></span></li>" + 
			"<li><span style='color: #333399;'><strong>Anthony Demuylder</strong></span></li>" + 
			"<li><span style='color: #333399;'><strong>Baptiste Jaeckert</strong></span></li>" +
			"<li><span style='color: #333399;'><strong>Benoit Fauque</strong></span></li>" + 
			"<li><span style='color: #333399;'><strong>Dj&eacute;n&eacute;bou Monique Dembele</strong></span></li>" + 
			"<li><span style='color: #333399;'><strong>Elliott G&eacute;mus-Pr&eacute;vost</strong></span></li>" + 
			"<li><span style='color: #333399;'><strong>Florent Gargot</strong></span></li>" +
			"<li><span style='color: #333399;'><strong>J&eacute;r&eacute;my Collard</strong></span></li>" + 
			"<li><span style='color: #333399;'><strong>Jonathan Diaz-Muy</strong></span></li>" + 
			"<li><span style='color: #333399;'><strong>Julien Mithra</strong></span></li>" + 
			"<li><span style='color: #333399;'><strong>Landry Modeste Goutondji</strong></span></li>" + 
			"<li><span style='color: #333399;'><strong>Mentor Bajraktari</strong></span></li>" + 
			"<li><span style='color: #333399;'><strong>Nicolas heldmaier</strong></span></li>" + 
			"<li><span style='color: #333399;'><strong>Olivier Scheffler</strong></span></li>" + 
			"<li><span style='color: #333399;'><strong>Samuel Arseneault</strong></span></li>" + 
			"</ul>";					
   
	@Override
	protected void executeImpl() {
		JOptionPane.showMessageDialog(null, text, "� propos", JOptionPane.INFORMATION_MESSAGE);
	}

}
