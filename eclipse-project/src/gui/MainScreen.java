package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import org.graalvm.compiler.nodes.InliningLog.UpdateScope;

import logic.Game;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.ScrollPane;
import java.awt.TextArea;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class MainScreen {
	
	private final int WIDTH = 800, HEIGHT = 600;
	private Game manager;
	
	//Left JPanel
	private JPanel leftPanel;
	private JTabbedPane tabbedPane;
	private JPanel actionsPanel;
	private JPanel upgradesPanel;
	
	//Right JPanel
	private JPanel rightPanel;
	private JPanel infoPanel;
	private JPanel screenPanel;
	private JPanel gameInfoPanel;
	
	//gameInfo
	private JTextField totalMoneyTextField;
	private JTextField totalCarbonTextField;
	private JTextField totalApTextField;
	private JTextField dailyCarbonTextField;
	private JTextField dailyExpensesTextField;
	private JTextField dailyApTextField;
	
	JTextPane infoTextPane;
	int itemYCoord = 10;
	
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
		creatRightPanel();
		

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
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 250, 600);
		leftPanel.add(tabbedPane);
		
		createUpgradePanel();

		
	}
	
	public void createUpgradePanel() {
		actionsPanel = new JPanel();
		actionsPanel.setLayout(null);
		tabbedPane.addTab("Actions", null, actionsPanel, null);
		
		int height = 10;
		for (int i = 0; i < 4; i++) {
			addButton(actionsPanel, height);
			height += 60;
		}
		
	}
	
	public void addButton(JPanel panel, int y) {
		JButton button = new JButton("Test");
		button.setBounds(25, y, 200, 50);
		panel.add(button);
		
	}
	
	public void createActionsPanel(JPanel panel) {
		
	}
	
	private void creatRightPanel() {
		
		rightPanel.setLayout(null);
		createGameInfoPanel();
		createInfoPanel();	
		createScreenPanel();
		
	}
	
	public void createGameInfoPanel() {
		gameInfoPanel = new JPanel();
		gameInfoPanel.setBounds(25, 0, 500, 30);
		gameInfoPanel.setBackground(Color.GREEN);
		rightPanel.add(gameInfoPanel);
		
		totalMoneyTextField = createInfoTextFields();
		
		totalApTextField = createInfoTextFields();
		
		totalCarbonTextField = createInfoTextFields();
	}
	
	public JTextField createInfoTextFields() {
		JTextField textFeild = new JTextField();
		textFeild.setText("TESTING");
		gameInfoPanel.add(textFeild);
		
		return textFeild;
	}
	
	public void updateGameInfoTextFields() {
		
	}
	
	public void createInfoPanel() {
		infoPanel = new JPanel();
		infoPanel.setBounds(25, 50, 500, 150);
		infoPanel.setBackground(Color.CYAN);
		rightPanel.add(infoPanel);
		infoPanel.setLayout(null);
		
		infoTextPane = new JTextPane();
		infoTextPane.setBounds(12, 12, 476, 88);
		infoTextPane.setEditable(false);
		infoPanel.add(infoTextPane);
	}
	
	public void createScreenPanel() {
		screenPanel = new JPanel();
		screenPanel.setBackground(Color.RED);
		screenPanel.setBounds(25, 220, 500, 330);
		rightPanel.add(screenPanel);
		screenPanel.setLayout(null);
		
		for (int i = 0; i < 5; i++) {
			addItemToInventory();
		}
		
	}
	
	public void addItemToInventory() {
		//y = 30 * num items in inventory
		JTextField textArea = new JTextField();
		textArea.setText("This is a test"); // change to item description
		textArea.setAlignmentY(SwingConstants.CENTER);
		textArea.setEditable(false);
		textArea.setBounds(10, itemYCoord, 480, 20);
		screenPanel.add(textArea);
		
		itemYCoord += 40;
	}
}
