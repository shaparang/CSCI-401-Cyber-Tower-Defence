

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;



class IOPanel extends JPanel implements ActionListener, MouseListener{
	public static JTextArea output = new JTextArea("", 10, 50);
	public static JTextField input = new JTextField("");
	public static JButton enter = new JButton("Enter");
	
	// game variables 
	String state = "start";
	String question = null;
	String ans = null;
	
	public IOPanel() {
		output.setBackground(Color.BLACK);
		input.setBackground(Color.BLACK);
		output.setForeground(Color.GREEN);
		input.setForeground(Color.GREEN);
		output.setEditable(false);
		enter.addActionListener(this);
		enter.setMnemonic(KeyEvent.VK_ENTER);
		
		
		Box b = Box.createVerticalBox();
		Box c = Box.createHorizontalBox();
		
		c.add(input);
		c.add(enter);
		
		b.add(output, "South");
		b.add(c, "South");
		
		add(b, "South");
	}
 

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		String inputs = input.getText();
		if (source == enter) {
			if (state.equals("start") && inputs.equals("start")) {
				output.setText("Please choose an option \n1. Start Game \n 2. Options \n 3. Exit");
				state = "menu";
				input.setText(" ");
				return;
			}
			if (state.equals("menu")) {
				int choice;
				
		        try {
		           choice = Integer.parseInt(inputs.trim());
		        }
		        catch (NumberFormatException z) {
		            choice = 0;
		        }
				
				switch(choice) { // menu
				case 1: // start game
					output.setText("Please choose an option \n1. Single Player \n 2. Multiplayer \n 3. Go Back");
					input.setText(" ");
					state = "startgame";
					return;
				case 2: // options
					output.setText("this is the options :)");
					input.setText(" ");
					state = "options";
					return;
				case 3: // exit
					System.exit(0);
				default:
					output.append("\n Not a valid option. Please choose again");
				}
			}
			if (state.equals("startgame")) {
				int choice;
				
		        try {
		           choice = Integer.parseInt(inputs.trim());
		        }
		        catch (NumberFormatException z) {
		            choice = 0;
		        }
		        
		        switch(choice) { // start game
		        case 1: // single player
		        	output.setText("Please choose an option \n1. Difficulty Select \n 2. Go Back");
					input.setText(" ");
					state = "singleplayer";
					return;
		        case 2: // multiplayer
		        	output.setText("Currently under development \n Please choose an option \\n1. Difficulty Select \\n 2. Go Back");
		        	input.setText(" ");
					//state = "multiplayer";
					return;
		        case 3: // go back
		        	output.setText("Please choose an option \n1. Start Game \n 2. Options \n 3. Exit");
					state = "menu";
					input.setText(" ");
					return;
				default:
					output.append("\n Not a valid option. Please choose again");
		        }	
			}
			if (state.equals("singleplayer")) {
				int choice;
				
		        try {
		           choice = Integer.parseInt(inputs.trim());
		        }
		        catch (NumberFormatException z) {
		            choice = 0;
		        }
		        
		        switch(choice) { //single player
		        case 1: // difficulty
		        	output.setText("Please choose an option \n1. Easy \n2. Medium \n3. Hard");
					input.setText(" ");
					state = "difficulty";
					return;
		        case 2: // go back
		        	output.setText("Please choose an option \n1. Single Player \n 2. Multiplayer \n 3. Go Back");
					state = "startgame";
					input.setText(" ");
					return;
		        default:
					output.append("\n Not a valid option. Please choose again");
		        }
		        
			}
			if (state.equals("difficulty")) {
				int choice;
				
		        try {
		           choice = Integer.parseInt(inputs.trim());
		        }
		        catch (NumberFormatException z) {
		            choice = 0;
		        }
		        
		       switch(choice) {
		       case 1:
		    	   node("AV", 1, 20, 20);
		    	   node("FW", 2, 100, 20);
		    	   node("IDS", 3, 80, 80);
		    	   node("V", 4, 150, 150);
		       }
			}
		
			input.setText(" ");
		
		}
	}
	public void node(String name, int type, int x, int y) {
		ImageIcon image;
		JLabel label = new JLabel();
		switch(type) {
		case 1:
			image = new ImageIcon("graphics/Antivirus.gif");
			break;
		case 2:
			image = new ImageIcon("graphics/Firewall.gif");
			break;
		case 3:
			image = new ImageIcon("graphics/IDS.gif");
			break;
		case 4:
			image = new ImageIcon("graphics/Virus.gif");
			break;
		default:
			image = new ImageIcon("graphics/Antivirus.gif");
		}
		ImageIcon imageScaled= new ImageIcon(image.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
		label.setIcon(imageScaled);
		
		Border border = BorderFactory.createBevelBorder(1, new Color(0, 0, 255), new Color(0, 0, 155));
		label.setBorder(border);
		
		Frame.display.add(label);
		label.setBounds(x, y, 60, 60);
		label.addMouseListener(this);
		
	}

	public void mouseClicked(MouseEvent e) {}

	public void mousePressed(MouseEvent e) {
		JLabel label = (JLabel)e.getSource();
		Border border = BorderFactory.createBevelBorder(1, new Color(0, 255, 255), new Color(0, 155, 155));
		label.setBorder(border);
	}

	public void mouseReleased(MouseEvent e) {}

	public void mouseEntered(MouseEvent e) {}

	public void mouseExited(MouseEvent e) {}
}


class DisplayPanel extends JPanel {
	
	public DisplayPanel() {
		Border border = BorderFactory.createLoweredBevelBorder();
		setBorder(border);
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
	
}


class Frame extends JFrame {
	public static DisplayPanel display = new DisplayPanel();
	public static IOPanel IO = new IOPanel();
	
	public void setText(String s) {
		IOPanel.output.append("\n" + s);
	}
	
	public Frame() {
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screen = tk.getScreenSize();
		setTitle("Cyber Security Tower Defense");
		setSize(screen.width/2, screen.height/2);
		
		addWindowListener (new Close());
		
		Container contentPane = getContentPane();
		contentPane.add(display, "Center");
		contentPane.add(IO, "South");
		
	}
}


class Close extends WindowAdapter{
	public void windowClosing(WindowEvent e) {
	 System.exit(0);
	}
}


public class UI {

	public static void main(String[] args) {
		Frame frame = new Frame();
		frame.setVisible(true);
		frame.setText("\n\n░█▀▀░█░█░█▀▄░█▀▀░█▀▄░░░█▀▄░█▀▀░█▀▀░█▀▀░█▀█░█▀▀░█▀▀\r\n"
				+         "░█░░░░█░░█▀▄░█▀▀░█▀▄░░░█░█░█▀▀░█▀▀░█▀▀░█░█░▀▀█░█▀▀\r\n"
				+         "░▀▀▀░░▀░░▀▀░░▀▀▀░▀░▀░░░▀▀░░▀▀▀░▀░░░▀▀▀░▀░▀░▀▀▀░▀▀▀");
		frame.setText("\n\n\n Type start to begin...");
	}
	
}
