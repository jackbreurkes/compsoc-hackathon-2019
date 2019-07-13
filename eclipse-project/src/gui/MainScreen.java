package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import logic.Game;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class MainScreen {
	
	private final int WIDTH = 800, HEIGHT = 600;
	private Game manager;
	private JPanel leftPanel;
	private JPanel rightPanel;

	JButton btnUpgrade;
	JButton btnActions;
	
	JPanel actionsPanel;
	JPanel upgradesPanel;
	
	private JFrame frame;


	public MainScreen(Game manager) {
		this.manager = manager;
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		frame = new JFrame("Game");
		frame.setBounds(0, 0, WIDTH, HEIGHT);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		createGrid();
		createLeftPanel();
		

	}
	
	private void createGrid() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {250, 550, 0};
		gridBagLayout.rowHeights = new int[]{572, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		leftPanel = new JPanel();
		leftPanel.setBackground(Color.BLACK);
		leftPanel.setLayout(null);
		GridBagConstraints gbc_leftPanel_1 = new GridBagConstraints();
		gbc_leftPanel_1.fill = GridBagConstraints.BOTH;
		gbc_leftPanel_1.insets = new Insets(0, 0, 0, 5);
		gbc_leftPanel_1.gridx = 0;
		gbc_leftPanel_1.gridy = 0;
		frame.getContentPane().add(leftPanel, gbc_leftPanel_1);
		
		
		
		rightPanel = new JPanel();
		GridBagConstraints gbc_rightPanel_1 = new GridBagConstraints();
		gbc_rightPanel_1.fill = GridBagConstraints.BOTH;
		gbc_rightPanel_1.gridx = 1;
		gbc_rightPanel_1.gridy = 0;
		frame.getContentPane().add(rightPanel, gbc_rightPanel_1);
	}
	
	private void createLeftPanel() {
		
		btnUpgrade = new JButton("Upgrades");
		btnUpgrade.setLocation(10, 10);
		btnUpgrade.setSize(110, 40);
		leftPanel.add(btnUpgrade);
		
		btnActions = new JButton("Actions");
		btnActions.setLocation(130, 10);
		btnActions.setSize(110, 40);
		leftPanel.add(btnActions);
		
	}
	
	public void creaeteUpgradePanel(JPanel panel) {
		
		
		
	}
	
	public void createActionsPanel(JPanel panel) {
		
	}
	
	private void creatRightPanel() {
	}

}
