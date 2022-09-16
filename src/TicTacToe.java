import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TicTacToe implements ActionListener{

	JFrame frame = new JFrame("Tic-Tac-Toe");
	JLabel title = new JLabel();
	JPanel title_panel = new JPanel();
	JButton[] buttons = new JButton[9];
	JPanel button_panel = new JPanel();
	JButton restart_button = new JButton();
	JPanel restart_panel = new JPanel();
	
	JLabel xVictory = new JLabel();
	JLabel oVictory = new JLabel();
	int x_score=0,o_score=0;
	int time = 3000;
	boolean xTurn, finish = false, empty = true;
	
	TicTacToe(){
		
		ImageIcon img = new ImageIcon("C:\\Users\\lenovo\\Desktop\\Eclipse Workspace\\Tic-Tac-Toe\\src\\tictactoe_icon.jpg");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,600);
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		frame.setIconImage(img.getImage());
		
		title.setText("Tic-Tac-Toe");
		title.setBackground(new Color(0x9FA5D5));
		title.setForeground(new Color(0x6454F0));
		title.setFont(new Font("MV Boli", Font.ITALIC, 60));
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setOpaque(true);
		
		title_panel.setLayout(new BorderLayout());
		title_panel.setPreferredSize(new Dimension(100,100));
		title_panel.add(title);
		frame.add(title_panel,BorderLayout.NORTH);
		
		button_panel.setLayout(new GridLayout(3,3));
		for(int i=0;i<9;i++) {
			buttons[i] = new JButton();
			button_panel.add(buttons[i]);
			
			buttons[i].addActionListener(this);
			buttons[i].setFont(new Font("MV Boli", Font.ITALIC, 50));
			buttons[i].setFocusable(false);
			
			
		}
		frame.add(button_panel);
		
		restart_button.setText("Restart");
		restart_button.setFont(new Font("MV Boli", Font.BOLD,50));
		restart_button.setBackground(new Color(0xE0D2EB));
		restart_button.setForeground(new Color(0x6454f0));
		restart_button.setFont(new Font("MV Boli", Font.ITALIC,50));
		restart_button.setFocusable(false);
		restart_button.addActionListener(this);
				
		restart_panel.setBackground(new Color(0x9FA5D5));
		restart_panel.setPreferredSize(new Dimension(100,100));
		xVictory.setText("X: "+x_score+"     ");
		oVictory.setText("     O: "+o_score);
		xVictory.setFont(new Font("MV Boli", Font.BOLD, 25));
		oVictory.setFont(new Font("MV Boli", Font.BOLD, 25));
		restart_panel.add(xVictory);
		restart_panel.add(restart_button);
		restart_panel.add(oVictory);
		
		
		frame.add(restart_panel, BorderLayout.SOUTH);
		
		first_turn();
	}
	
	void first_turn() {
		Random random = new Random();
		
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if(random.nextInt(2) == 0) {
			xTurn = true;
			title.setText("X Turn");
		}
		else {
			xTurn = false;
			title.setText("O Turn");
		}
	}
	void check() {
		if(buttons[0].getText() == "X" &&
				buttons[1].getText() == "X" &&
				buttons[2].getText() == "X") {
			finish = true;
			empty=false;
			victory(0,1,2, 'X');
		}
		if(buttons[3].getText() == "X" &&
				buttons[4].getText() == "X" &&
				buttons[5].getText() == "X") {
			finish = true;
			empty=false;
			victory(3,4,5, 'X');
		}
		if(buttons[6].getText() == "X" &&
				buttons[7].getText() == "X" &&
				buttons[8].getText() == "X") {
			finish = true;
			empty=false;
			victory(6,7,8, 'X');
		}
		if(buttons[0].getText() == "X" &&
				buttons[3].getText() == "X" &&
				buttons[6].getText() == "X") {
			finish = true;
			empty=false;
			victory(0,3,6, 'X');
		}
		if(buttons[0].getText() == "X" &&
				buttons[4].getText() == "X" &&
				buttons[8].getText() == "X") {
			finish = true;
			empty=false;
			victory(0,4,8, 'X');
		}
		if(buttons[1].getText() == "X" &&
				buttons[4].getText() == "X" &&
				buttons[7].getText() == "X") {
			finish = true;
			empty=false;
			victory(1,4,7, 'X');
		}
		if(buttons[2].getText() == "X" &&
				buttons[5].getText() == "X" &&
				buttons[8].getText() == "X") {
			finish = true;
			empty=false;
			victory(2,5,8, 'X');
		}
		if(buttons[2].getText() == "X" &&
				buttons[4].getText() == "X" &&
				buttons[6].getText() == "X") {
			finish = true;
			empty=false;
			victory(2,4,6, 'X');
		}
		
		
		if(buttons[0].getText() == "O" &&
				buttons[1].getText() == "O" &&
				buttons[2].getText() == "O") {
			finish = true;
			empty=false;
			victory(0,1,2, 'O');
		}
		if(buttons[3].getText() == "O" &&
				buttons[4].getText() == "O" &&
				buttons[5].getText() == "O") {
			finish = true;
			empty=false;
			victory(3,4,5, 'O');
		}
		if(buttons[6].getText() == "O" &&
				buttons[7].getText() == "O" &&
				buttons[8].getText() == "O") {
			finish = true;
			empty=false;
			victory(6,7,8, 'O');
		}
		if(buttons[0].getText() == "O" &&
				buttons[3].getText() == "O" &&
				buttons[6].getText() == "O") {
			finish = true;
			empty=false;
			victory(0,3,6, 'O');
		}
		if(buttons[0].getText() == "O" &&
				buttons[4].getText() == "O" &&
				buttons[8].getText() == "O") {
			finish = true;
			empty=false;
			victory(0,4,8, 'O');
		}
		if(buttons[1].getText() == "O" &&
				buttons[4].getText() == "O" &&
				buttons[7].getText() == "O") {
			finish = true;
			empty=false;
			victory(1,4,7, 'O');
		}
		if(buttons[2].getText() == "O" &&
				buttons[5].getText() == "O" &&
				buttons[8].getText() == "O") {
			finish = true;
			empty=false;
			victory(2,5,8, 'O');
		}
		if(buttons[2].getText() == "O" &&
				buttons[4].getText() == "O" &&
				buttons[6].getText() == "O") {
			finish = true;
			empty=false;
			victory(2,4,6, 'O');
		}
		
		if(empty){
			int empty_block=0;
			for(int i=0;i<9;i++) {
				if(buttons[i].getText() == "X" || 
						buttons[i].getText() == "O") {
					empty_block++;
				}
			}
			if(empty_block == 9) {

				for(int i=0;i<9;i++) {
					buttons[i].setEnabled(false);
				}
				title.setText("Draw !!!");
			}
			
		}
	}
	void victory(int x, int y, int z, char win) {
		buttons[x].setBackground(new Color(0xE8F5C8));
		buttons[y].setBackground(new Color(0xE8F5C8));
		buttons[z].setBackground(new Color(0xE8F5C8));
		
		for(int i=0;i<9;i++) {
			buttons[i].setEnabled(false);
		}
		title.setText(win +" Wins !!!");
		if(win == 'O') {
			o_score++;
		}
		if(win == 'X') {
			x_score++;
		}
		xVictory.setText("X: "+x_score+"     ");
		oVictory.setText("     O: "+o_score);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0;i<9;i++) {
			if(e.getSource() == buttons[i] && buttons[i].getText() == "") {
				if(xTurn) {
					buttons[i].setForeground(new Color(0xD57EEA));
					buttons[i].setText("X");
					
					title.setText("O Turn");
					check();
					xTurn = false;
				}
				else {
					buttons[i].setForeground(new Color(0xFCCB90));
					buttons[i].setText("O");
					
					title.setText("X Turn");
					check();
					xTurn = true;
				}
			}
		}
		if(e.getSource() == restart_button) {
			first_turn();
			empty = true;
			time = 0;
			for(int i=0;i<9;i++) {
				buttons[i].setText("");
				buttons[i].setEnabled(true);
				buttons[i].setBackground(null);
			}
			
		}
		
	}
	
}
