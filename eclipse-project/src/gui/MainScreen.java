package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import logic.Game;

public class MainScreen {
	
	int width = 800, height = 600;
	Game manager;

	private JFrame frame;

	public MainScreen(Game manager) {
		this.manager = manager;
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		frame = new JFrame("Game");
		frame.setBounds(0, 0, width, height);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
