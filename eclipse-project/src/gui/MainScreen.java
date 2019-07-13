package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import logic.Booster;
import logic.Game;
import logic.Upgrade;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.ScrollPane;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;

public class MainScreen extends TimerTask {
	
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
	private JLabel lblDailyMoney;
	private JLabel lblDailyCo;
	private JLabel lblDailyAp;
	private JLabel lblTotalmoney;
	private JLabel lblTotalCo;
	private JLabel lblTotalAp;
	private JPanel boostersPanel;
	
	
	private DecimalFormat df = new DecimalFormat("#.####");


	public MainScreen(Game manager) {
		this.manager = manager;
		initialize();
		frame.setVisible(true);
		
		Timer timer = new Timer();
		timer.schedule(manager, 0, 1000);
		timer.schedule(this, 0, 100);
	}
	
	public void run() {
		lblDailyMoney.setText("Daily money: " + Integer.toString(manager.DAILY_EARNINGS - manager.getDailyExpenses()));
		lblDailyCo.setText("Daily CO2: " + df.format(manager.getDailyCO2()));
		lblDailyAp.setText("Daily AP: " + Integer.toString(manager.getDailyActionPoints()));
		lblTotalmoney.setText("Total money: " + Integer.toString(manager.getMoney()));
		lblTotalCo.setText("Total CO2: " + df.format(manager.getCarbonFootPrint()));
		lblTotalAp.setText("Total AP: " + Integer.toString(manager.getActionPoints()));
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
		createBoosterPanel();
		
	}
	
	public void createUpgradePanel() {
		actionsPanel = new JPanel();
		actionsPanel.setLayout(null);
		tabbedPane.addTab("Actions", null, actionsPanel, null);

		
		int height = 10;
		for (int i = 0; i < manager.getUpgrades().size(); i++) {
			addButton(actionsPanel, height, manager.getUpgrades().get(i));
			height += 60;
		}
		
	}
	
	
	public void addButton(JPanel panel, int y, Upgrade upgrade) {
		JButton button = new JButton(upgrade.getName());
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				upgrade.ApplyEffects(manager);
				infoTextPane.setText(upgrade.getFact());
				run();
			}
		});
		button.setBounds(25, y, 200, 50);
		panel.add(button);
		
	}
	
	
	public void createBoosterPanel() {
		boostersPanel = new JPanel();
		boostersPanel.setLayout(null);
		tabbedPane.addTab("Boosters", null, boostersPanel, null);
		
		int height = 10;
		for (int i = 0; i < manager.getBoosters().size(); i++) {
			addBoosterButton(boostersPanel, height, manager.getBoosters().get(i));
			height += 60;
		}
	}
	
	public void addBoosterButton(JPanel panel, int y, Booster booster) {
		System.out.println(booster.getName());
		JButton button = new JButton(booster.getName() + " ($" + booster.getCost() + ", AP:" + booster.getAPCost() + ")");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				booster.applyEffects(manager);
				infoTextPane.setText(booster.getFact());
				run();
			}
		});
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
		gameInfoPanel.setBounds(25, 0, 500, 41);
		gameInfoPanel.setBackground(Color.GREEN);
		rightPanel.add(gameInfoPanel);
		
		lblDailyMoney = new JLabel("Daily Money:");
		gameInfoPanel.add(lblDailyMoney);
		
		lblDailyCo = new JLabel("Daily CO2: ");
		gameInfoPanel.add(lblDailyCo);
		
		lblDailyAp = new JLabel("Daily AP:");
		gameInfoPanel.add(lblDailyAp);
		
		lblTotalmoney = new JLabel("Total Money:");
		gameInfoPanel.add(lblTotalmoney);
		
		lblTotalCo = new JLabel("Total CO2: ");
		gameInfoPanel.add(lblTotalCo);
		
		lblTotalAp = new JLabel("Total AP: ");
		gameInfoPanel.add(lblTotalAp);
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
