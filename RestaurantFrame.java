import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class RestaurantFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField burgerField;
	private JTextField fishChipsField;
	private JTextField donnerKebabsField;
	private JTextField waterField;
	private JTextField colaField;
	private JTextField tangoField;
	private JTextField foodCostField;
	private JTextField drinkCostField;
	private JTextField totalCostField;
	private ImageIcon img1;

	
	private final double burgerPrice = 250.00;
	private final double fishChipsPrice = 80.00;
	private final double donnerKebabsPrice = 100.00;
	
	private final double waterPrice = 25.00;
	private final double colaPrice = 35.00;
	private final double tangoPrice = 25.00;
	
	
	private JTextArea billTextArea;
	private JButton totalButton;
	private JButton printReceiptButton;
	
	private DecimalFormat df = new DecimalFormat("0.00");
	
	
	
	public RestaurantFrame() {
		super("Restaurant");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 130, 1600, 800);

		ImageIcon backgroundIcon = new ImageIcon("menu.png");
		JLabel backgroundLabel = new JLabel(backgroundIcon);
		backgroundLabel.setBounds(250, 0, 1000, 750);
		backgroundLabel.setOpaque(true);
		backgroundLabel.setLayout(null);

		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		contentPane.add(backgroundLabel);
		
		JLabel foodLabel = new JLabel("Food");
		foodLabel.setFont(new Font("Rockwell Nova", Font.ITALIC, 16));
		foodLabel.setHorizontalAlignment(SwingConstants.CENTER);
		foodLabel.setBounds(26, 53, 191, 28);
		contentPane.add(foodLabel);
		
		JLabel burgerLabel = new JLabel("Burger Meal \u09F3250.00");
		burgerLabel.setBounds(21, 92, 138, 28);
		contentPane.add(burgerLabel);
		
		burgerField = new JTextField();
		burgerLabel.setLabelFor(burgerField);
		burgerField.setBounds(169, 92, 42, 28);
		contentPane.add(burgerField);
		burgerField.setColumns(10);
		burgerField.setText("0");
		
		JLabel fishChipsLabel = new JLabel("Fish and Chips \u09F380.00");
		fishChipsLabel.setBounds(21, 131, 138, 28);
		contentPane.add(fishChipsLabel);
		
		JLabel donnerKebabsLabel = new JLabel("Donner Kebabs \u09F3100.00");
		donnerKebabsLabel.setBounds(21, 170, 138, 28);
		contentPane.add(donnerKebabsLabel);
		
		fishChipsField = new JTextField();
		fishChipsField.setColumns(10);
		fishChipsField.setBounds(169, 131, 42, 28);
		contentPane.add(fishChipsField);
		fishChipsField.setText("0");
		
		donnerKebabsField = new JTextField();
		donnerKebabsField.setColumns(10);
		donnerKebabsField.setBounds(169, 170, 42, 28);
		contentPane.add(donnerKebabsField);
		donnerKebabsField.setText("0");
		
		JLabel drinksLabel = new JLabel("Drinks");
		drinksLabel.setHorizontalAlignment(SwingConstants.CENTER);
		drinksLabel.setFont(new Font("Rockwell Nova", Font.ITALIC, 16));
		drinksLabel.setBounds(21, 209, 191, 28);
		contentPane.add(drinksLabel);
		
		JLabel waterLabel = new JLabel("Water bottle \u09F325.00");
		waterLabel.setBounds(21, 248, 138, 28);
		contentPane.add(waterLabel);
		
		waterField = new JTextField();
		waterField.setColumns(10);
		waterField.setBounds(169, 248, 42, 28);
		contentPane.add(waterField);
		waterField.setText("0");
		
		JLabel colaLabel = new JLabel("Coca Cola \u09F325.00");
		colaLabel.setBounds(21, 287, 138, 28);
		contentPane.add(colaLabel);
		
		JLabel tangoLabel = new JLabel("Tango \u09F325.00");
		tangoLabel.setBounds(21, 326, 138, 28);
		contentPane.add(tangoLabel);
		
		colaField = new JTextField();
		colaField.setColumns(10);
		colaField.setBounds(169, 287, 42, 28);
		contentPane.add(colaField);
		colaField.setText("0");
		
		tangoField = new JTextField();
		tangoField.setColumns(10);
		tangoField.setBounds(169, 326, 42, 28);
		contentPane.add(tangoField);
		tangoField.setText("0");
		
		JLabel foodCostLabel = new JLabel("Food Cost:");
		foodCostLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		foodCostLabel.setBounds(21, 399, 100, 28);
		contentPane.add(foodCostLabel);
		
		foodCostField = new JTextField();
		foodCostField.setColumns(10);
		foodCostField.setBounds(131, 399, 80, 28);
		contentPane.add(foodCostField);
		
		JLabel drinkCostLabel = new JLabel("Drink Cost:");
		drinkCostLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		drinkCostLabel.setBounds(21, 438, 100, 28);
		contentPane.add(drinkCostLabel);
		
		JLabel totalCostLabel = new JLabel("Total Cost:");
		totalCostLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		totalCostLabel.setBounds(21, 477, 100, 28);
		contentPane.add(totalCostLabel);
		
		drinkCostField = new JTextField();
		drinkCostField.setColumns(10);
		drinkCostField.setBounds(131, 438, 80, 28);
		contentPane.add(drinkCostField);
		
		totalCostField = new JTextField();
		totalCostField.setColumns(10);
		totalCostField.setBounds(131, 477, 80, 28);
		contentPane.add(totalCostField);
		
		billTextArea = new JTextArea();
		billTextArea.setBounds(1300, 131, 239, 535);
		contentPane.add(billTextArea);
		
		totalButton = new JButton("Total");
		totalButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		totalButton.setBounds(131, 510, 89, 28);
		contentPane.add(totalButton);
		totalButton.addActionListener(this);
		
		printReceiptButton = new JButton("Print Receipt");
		printReceiptButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		printReceiptButton.setBounds(1300, 700, 116, 28);
		contentPane.add(printReceiptButton);
		printReceiptButton.addActionListener(this);
		
		JLabel restaurantLabel = new JLabel("KHADOK's");
		restaurantLabel.setFont(new Font("Gill Sans Nova Light", Font.BOLD | Font.ITALIC, 37));
		restaurantLabel.setHorizontalAlignment(SwingConstants.CENTER);
		restaurantLabel.setForeground(java.awt.Color.BLUE);
		restaurantLabel.setBounds(1200, 35, 425, 70);
		restaurantLabel.setOpaque(true);
		contentPane.add(restaurantLabel);
	}
	
	public int getCount(JTextField field) {
		int count = Integer.parseInt(field.getText());
		return count;
	}
	
	public double getFoodTotal() {
		double total = getCount(burgerField) * burgerPrice
				+ getCount(fishChipsField) * fishChipsPrice
		        + getCount(donnerKebabsField) * donnerKebabsPrice;
		return total;
	}
	
	public double getDrinkTotal() {
		double total = getCount(waterField) * waterPrice
				+ getCount(colaField) * colaPrice
				+ getCount(tangoField) * tangoPrice;
		return total;
	}
	
	public double getTotal() {
		double total = getFoodTotal() + getDrinkTotal();
		return total;
	}
	
	public void printReceipt() {
		billTextArea.setText("========================\n"
	+ "Food total        : " + df.format(getFoodTotal()) +" taka"+ "\n"
	+ "Drink total        : " + df.format(getDrinkTotal()) +" taka"+ "\n"
	+ "Total Amount  : " + df.format(getTotal()) + " taka"+ "\n"
	+ "========================\n"
);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==totalButton) {
			foodCostField.setText(df.format(getFoodTotal()) + "");
			drinkCostField.setText(df.format(getDrinkTotal()) + "");
			totalCostField.setText(df.format(getTotal()) + "");
		}
		if (e.getSource()==printReceiptButton) {
			printReceipt();
		}
		
	}


}