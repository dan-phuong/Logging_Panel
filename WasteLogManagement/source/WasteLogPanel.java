import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
/**
 * This class creates the WasteLogPanel, which catalogues waste and calculates lost value from waste
 * 
 */
public class WasteLogPanel extends javax.swing.JFrame implements ActionListener, ComponentListener {

	// Instantiation block
	private javax.swing.JButton addToppingOunce;
	private javax.swing.JButton addIngredient;
	private javax.swing.JButton addCondiment;
	private javax.swing.JButton calculateCostButton;
	private javax.swing.JButton addToppingUnit;
	private javax.swing.JButton addMeat;
	private javax.swing.JButton addProduct;
	private javax.swing.JComboBox<String> toppingsOunceComboBox;
	private javax.swing.JComboBox<String> toppingsUnitComboBox;
	private javax.swing.JComboBox<String> meatsComboBox;
	private javax.swing.JComboBox<String> ingredientsComboBox;
	private javax.swing.JComboBox<String> condimentsComboBox;
	private javax.swing.JComboBox<String> productsComboBox;
	private javax.swing.JLabel wasteLogLabel;
	private javax.swing.JLabel ingredientsOunceLabel;
	private javax.swing.JLabel condimentsTitle;
	private javax.swing.JLabel condimentsOuncesLabel;
	private javax.swing.JLabel productsTitle;
	private javax.swing.JLabel productsUnitLabel;
	private javax.swing.JLabel toppingsOunceLabel;
	private javax.swing.JLabel toppingsOunceTitle;
	private javax.swing.JLabel toppingsUnitTitle;
	private javax.swing.JLabel meatsTitle;
	private javax.swing.JLabel toppingsUnitLabel;
	private javax.swing.JLabel meatsUnitLabel;
	private javax.swing.JLabel totalWasteLabel;
	private javax.swing.JTextArea costWasteArea;
	private javax.swing.JLabel totalCostLabel;
	private javax.swing.JScrollPane ScrollPane;
	private javax.swing.JLabel ingredientsTitle;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JTextField toppingsOunceField;
	private javax.swing.JTextField toppingsUnitField;
	private javax.swing.JTextField meatsField;
	private javax.swing.JTextField ingredientsField;
	private javax.swing.JTextField condimentsField;
	private javax.swing.JTextField productsField;
	// Instantiation block

	// Instantiation block
	private String ingredientName;
	private String builtString = "";
	private double value;
	private double amount;
	private String choice;
	private double sum = 0;
	private ArrayList<Food> foodList = new ArrayList<Food>();
	// Instantiation block

	// Hashmap declaration and initiation
	HashMap<String, Double> hashFood = new HashMap<String, Double>();

	// ComboBox block
	String[] toppingsByUnit = { "Chicken", "Green Bellpepper", "Meatball", "Mushrooms", "Red Onions", "Sausage",
	"Tomatoes" };

	String[] toppingsByOunce = { "Anchovies", "Artichoke Hearts", "Balsamic Vinaigrette", "Banana Pepper",
			"Black Olives", "Clam", "Croutons", "Green Bellpepper", "Green Olives", "Jalapeno", "Mozzarella",
			"Mushrooms", "Parmesan", "Pepperoni", "Pineapple", "Provolone", "Red Onions", "Roasted Red Peppers",
	"Tomatoes" };

	String[] meats = { "Bacon", "Chicken", "Salami", "Sausages", "Meatball" };

	String[] ingredients = { "Flour", "Salt", "Panko", "Oil", "Honey" };

	String[] condiments = { "BBQ", "Caesar", "Ranch", "Spicy Buffalo" };

	String[] finalproducts = { "14 inch Pizza", "18 inch Pizza", "Thick - 16 Inch Pizza", "Thin - 16 Inch Pizza",
			"24 inch Pizza", "Calzone", "Stromboli", "Long rolls", "Short rolls" };
	// ComboBox block

	public WasteLogPanel() {
		toppingsOunceComboBox = new javax.swing.JComboBox<>(toppingsByOunce);
		toppingsUnitComboBox = new javax.swing.JComboBox<>(toppingsByUnit);
		meatsComboBox = new javax.swing.JComboBox<>(meats);
		ingredientsComboBox = new javax.swing.JComboBox<>(ingredients);
		condimentsComboBox = new javax.swing.JComboBox<>(condiments);
		productsComboBox = new javax.swing.JComboBox<>(finalproducts);

		jPanel1 = new javax.swing.JPanel();
		jPanel2 = new javax.swing.JPanel();
		jPanel3 = new javax.swing.JPanel();
		jPanel4 = new javax.swing.JPanel();
		addToppingOunce = new javax.swing.JButton();
		addIngredient = new javax.swing.JButton();
		addCondiment = new javax.swing.JButton();
		addToppingUnit = new javax.swing.JButton();
		addMeat = new javax.swing.JButton();
		addProduct = new javax.swing.JButton();

		// Calculation cost set up
		calculateCostButton = new javax.swing.JButton();
		calculateCostButton.setBackground(new java.awt.Color(0, 42, 97));
		calculateCostButton.setFont(new java.awt.Font("Tahoma", 1, 11));
		calculateCostButton.setForeground(new java.awt.Color(0, 40, 63));
		calculateCostButton.setText("Calculate Cost");
		calculateCostButton.addActionListener(this);
		// Calculation cost set up

		// Button text set up
		addToppingOunce.setText("Add");
		addIngredient.setText("Add");
		addCondiment.setText("Add");
		addToppingUnit.setText("Add");
		addMeat.setText("Add");
		addProduct.setText("Add");
		// Button text set up

		// Button listeners
		addToppingOunce.addActionListener(this);
		addIngredient.addActionListener(this);
		addCondiment.addActionListener(this);
		addToppingUnit.addActionListener(this);
		addMeat.addActionListener(this);
		addProduct.addActionListener(this);
		// Button listeners

		// Labels set up
		wasteLogLabel = new javax.swing.JLabel();
		toppingsOunceLabel = new javax.swing.JLabel();
		toppingsOunceTitle = new javax.swing.JLabel();

		toppingsUnitTitle = new javax.swing.JLabel();
		toppingsUnitLabel = new javax.swing.JLabel();

		meatsTitle = new javax.swing.JLabel();
		meatsUnitLabel = new javax.swing.JLabel();

		ingredientsTitle = new javax.swing.JLabel();
		ingredientsOunceLabel = new javax.swing.JLabel();

		condimentsTitle = new javax.swing.JLabel();
		condimentsOuncesLabel = new javax.swing.JLabel();

		productsTitle = new javax.swing.JLabel();
		productsUnitLabel = new javax.swing.JLabel();

		totalWasteLabel = new javax.swing.JLabel();
		costWasteArea = new javax.swing.JTextArea();
		totalCostLabel = new javax.swing.JLabel();
		ScrollPane = new javax.swing.JScrollPane();
		// Labels set up

		// Text field set up
		toppingsOunceField = new javax.swing.JTextField(10);
		toppingsUnitField = new javax.swing.JTextField(10);
		meatsField = new javax.swing.JTextField(10);
		ingredientsField = new javax.swing.JTextField(10);
		condimentsField = new javax.swing.JTextField(10);
		productsField = new javax.swing.JTextField(10);
		// Text field set up

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jPanel1.setBackground(new java.awt.Color(0, 42, 97));

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 66, Short.MAX_VALUE));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 600, Short.MAX_VALUE));

		jPanel2.setBackground(new java.awt.Color(0, 72, 164));
		jPanel2.setPreferredSize(new java.awt.Dimension(146, 70));

		wasteLogLabel.setFont(new java.awt.Font("Tahoma", 1, 24));
		wasteLogLabel.setForeground(new java.awt.Color(255, 255, 255));
		wasteLogLabel.setText("Waste Log");

		toppingsOunceTitle.setFont(new java.awt.Font("Tahoma", 1, 24));
		toppingsOunceTitle.setForeground(new java.awt.Color(0, 42, 97));
		toppingsOunceTitle.setText("Toppings by Ounce");

		toppingsOunceLabel.setFont(new java.awt.Font("Tahoma", 1, 14));
		toppingsOunceLabel.setText("Quantity in Ounces:");

		toppingsUnitTitle.setFont(new java.awt.Font("Tahoma", 1, 24));
		toppingsUnitTitle.setForeground(new java.awt.Color(0, 42, 97));
		toppingsUnitTitle.setText("Toppings by Unit");

		toppingsUnitLabel.setFont(new java.awt.Font("Tahoma", 1, 14));
		toppingsUnitLabel.setText("Quantity by unit:");

		meatsTitle.setFont(new java.awt.Font("Tahoma", 1, 24));
		meatsTitle.setForeground(new java.awt.Color(0, 42, 97));
		meatsTitle.setText("Meats");

		meatsUnitLabel.setFont(new java.awt.Font("Tahoma", 1, 14));
		meatsUnitLabel.setText("Quantity by unit:");

		ingredientsTitle.setFont(new java.awt.Font("Tahoma", 1, 24));
		ingredientsTitle.setForeground(new java.awt.Color(0, 42, 97));
		ingredientsTitle.setText("Ingredients");

		ingredientsOunceLabel.setFont(new java.awt.Font("Tahoma", 1, 14));
		ingredientsOunceLabel.setText("Quantity in Ounces:");

		condimentsTitle.setFont(new java.awt.Font("Tahoma", 1, 24));
		condimentsTitle.setForeground(new java.awt.Color(0, 42, 97));
		condimentsTitle.setText("Condiments");

		condimentsOuncesLabel.setFont(new java.awt.Font("Tahoma", 1, 14));
		condimentsOuncesLabel.setText("Quantity in Ounces:");

		productsTitle.setFont(new java.awt.Font("Tahoma", 1, 24));
		productsTitle.setForeground(new java.awt.Color(0, 42, 97));
		productsTitle.setText("Products");

		productsUnitLabel.setFont(new java.awt.Font("Tahoma", 1, 14));
		productsUnitLabel.setText("Quantity in units:");

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(wasteLogLabel)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup().addGap(20, 20, 20).addComponent(wasteLogLabel)
						.addContainerGap(21, Short.MAX_VALUE)));

		jPanel3.setBackground(new java.awt.Color(255, 255, 255));

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup().addGap(23, 23, 23).addGroup(jPanel3Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(toppingsOunceTitle)
								.addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
										.addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout
												.createSequentialGroup()
												.addComponent(toppingsOunceComboBox,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(addToppingOunce))
										.addGroup(javax.swing.GroupLayout.Alignment.LEADING,
												jPanel3Layout.createSequentialGroup().addComponent(toppingsOunceLabel)
												.addGap(18, 18, 18).addComponent(toppingsOunceField,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))))
						.addComponent(ingredientsTitle)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
								.addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout
										.createSequentialGroup()
										.addComponent(ingredientsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(addIngredient))
								.addGroup(javax.swing.GroupLayout.Alignment.LEADING,
										jPanel3Layout.createSequentialGroup().addComponent(ingredientsOunceLabel)
										.addGap(18, 18, 18).addComponent(ingredientsField,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE))))
						.addGap(53, 53, 53)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel3Layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addGroup(jPanel3Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addGroup(jPanel3Layout.createSequentialGroup()
														.addComponent(toppingsUnitLabel).addGap(18, 18, 18)
														.addComponent(toppingsUnitField))
												.addComponent(toppingsUnitTitle))
										.addGroup(jPanel3Layout.createSequentialGroup()
												.addComponent(condimentsOuncesLabel).addGap(18, 18, 18)
												.addComponent(condimentsField, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(jPanel3Layout.createSequentialGroup()
												.addComponent(condimentsComboBox,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(addCondiment))
										.addComponent(condimentsTitle))
								.addGroup(jPanel3Layout.createSequentialGroup()
										.addComponent(toppingsUnitComboBox, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(78, 78, 78).addComponent(addToppingUnit)))
						.addGap(54, 54, 54)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel3Layout.createSequentialGroup()
										.addGroup(jPanel3Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(productsTitle).addComponent(productsUnitLabel))
										.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
												.addGroup(jPanel3Layout.createSequentialGroup()
														.addComponent(productsComboBox,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(addProduct))
												.addGroup(javax.swing.GroupLayout.Alignment.LEADING,
														jPanel3Layout.createSequentialGroup()
														.addComponent(meatsUnitLabel).addGap(18, 18, 18)
														.addComponent(meatsField))
												.addGroup(javax.swing.GroupLayout.Alignment.LEADING,
														jPanel3Layout.createSequentialGroup().addComponent(meatsTitle)
														.addGap(0, 0, Short.MAX_VALUE))
												.addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout
														.createSequentialGroup()
														.addComponent(meatsComboBox,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(addMeat))
												.addGroup(jPanel3Layout.createSequentialGroup()
														.addGap(0, 0, Short.MAX_VALUE)
														.addGroup(jPanel3Layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.TRAILING)
																.addComponent(productsField,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addComponent(calculateCostButton,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 135,
																		javax.swing.GroupLayout.PREFERRED_SIZE))))
										.addGap(47, 47, 47)))));
		jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup().addGap(39, 39, 39)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(toppingsOunceTitle).addComponent(toppingsUnitTitle)
								.addComponent(meatsTitle))
						.addGap(18, 18, 18)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(toppingsOunceLabel)
								.addComponent(toppingsOunceField, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(toppingsUnitLabel)
								.addComponent(toppingsUnitField, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(meatsUnitLabel)
								.addComponent(meatsField, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(toppingsOunceComboBox, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(toppingsUnitComboBox, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(meatsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(addToppingOunce).addComponent(addToppingUnit).addComponent(addMeat))
						.addGap(37, 37, 37)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(jPanel3Layout.createSequentialGroup().addComponent(ingredientsTitle)
												.addGap(18, 18, 18)
												.addGroup(jPanel3Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(ingredientsOunceLabel)
														.addComponent(ingredientsField,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGap(18, 18, 18)
												.addGroup(jPanel3Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(ingredientsComboBox,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(addIngredient)))
										.addGroup(jPanel3Layout.createSequentialGroup().addComponent(condimentsTitle)
												.addGap(18, 18, 18)
												.addGroup(jPanel3Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(condimentsOuncesLabel).addComponent(
																condimentsField, javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGap(18, 18, 18)
												.addGroup(jPanel3Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(condimentsComboBox,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(addCondiment))))
										.addContainerGap(238, Short.MAX_VALUE))
								.addGroup(jPanel3Layout.createSequentialGroup().addComponent(productsTitle)
										.addGap(18, 18, 18)
										.addGroup(jPanel3Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(productsUnitLabel).addComponent(productsField,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(jPanel3Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(productsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(addProduct))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(calculateCostButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(22, 22, 22)))));

		jPanel4.setBackground(new java.awt.Color(35, 39, 42));

		totalWasteLabel.setFont(new java.awt.Font("Tahoma", 1, 18));
		totalWasteLabel.setForeground(new java.awt.Color(255, 255, 255));
		totalWasteLabel.setText("Total Waste");

		totalCostLabel.setBackground(new java.awt.Color(0, 42, 97));
		totalCostLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		totalCostLabel.setForeground(new java.awt.Color(255, 255, 255));

		//
		costWasteArea.setEditable(false);
		costWasteArea.setBackground(new java.awt.Color(35, 39, 42));
		costWasteArea.setColumns(20);
		costWasteArea.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		costWasteArea.setForeground(new java.awt.Color(255, 255, 255));
		costWasteArea.setRows(5);
		ScrollPane.setViewportView(costWasteArea);

		//

		javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
		jPanel4.setLayout(jPanel4Layout);
		jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel4Layout.createSequentialGroup().addGroup(jPanel4Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel4Layout.createSequentialGroup()
								.addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(jPanel4Layout.createSequentialGroup().addGap(51, 51, 51)
												.addComponent(totalWasteLabel))
										.addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addComponent(
												totalCostLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 84,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addGap(0, 44, Short.MAX_VALUE))
						.addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addComponent(ScrollPane,
								javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
						.addContainerGap()));
		jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addComponent(totalWasteLabel)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(ScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 429,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(totalCostLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup()
				.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.PREFERRED_SIZE)
				.addGap(0, 0, 0)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1025, Short.MAX_VALUE)
						.addGroup(layout.createSequentialGroup()
								.addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(0, 0, 0).addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addGroup(layout.createSequentialGroup()
						.addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(layout.createSequentialGroup().addGap(0, 0, 0).addComponent(jPanel4,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)))));

		pack();
	}

	// Reads List.txt file and stores in HashMap
	public void fileReader() {
		try {
			Scanner in = new Scanner(new FileInputStream("List.txt"));
			while (in.hasNextLine()) {
				String read = in.nextLine();
				String[] splitRead = read.split(", ");
				ingredientName = splitRead[0];
				value = Double.valueOf(splitRead[1]);
				hashFood.put(ingredientName, value);
			}
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(this,
					"File could not be found! Please add List.txt to your files (Not the source folder).");
		}
	}

	// This method stores information into a text file
	public boolean dailyInformationStorage(String dataEntry) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
			String partialFileName=String.valueOf(sdf).concat("Joey'sWasteLogTG.txt");
			File dateFileName = new File("16.11.2021Joey'sWasteLogTG.txt");
			if (dateFileName.exists()) {
				PrintWriter out = new PrintWriter(new FileOutputStream(dateFileName));
				out.print(dataEntry);	
				out.close();
				return true;
			}
			else {
				PrintWriter out = new PrintWriter(new FileOutputStream(dateFileName, true));
				out.append(dataEntry);
				out.close();
				return true;
			}
		}
		catch (FileNotFoundException t) {
			return false;
		}
	}


	public void actionPerformed(ActionEvent e) {

		// Gives list of ingredients and products used with their price
		if (e.getSource() == calculateCostButton) {
			for (Food element : foodList) {
				builtString += "\n" + element;
			}
			costWasteArea.setText(builtString);
			dailyInformationStorage(costWasteArea.getText()); // Stores data into a text File
			builtString = ""; // Resets string to append new built-strings
		} else {

			// Checks to see which button was pressed, adds corresponding data to
			// calculations
			if (e.getSource() == addToppingOunce) {
				choice = toppingsOunceComboBox.getSelectedItem().toString();
				amount = Double.valueOf(toppingsOunceField.getText());
			}

			else if (e.getSource() == addIngredient) {
				choice = ingredientsComboBox.getSelectedItem().toString();
				amount = Double.valueOf(ingredientsField.getText());
			}

			else if (e.getSource() == addCondiment) {
				choice = condimentsComboBox.getSelectedItem().toString();
				amount = Double.valueOf(condimentsField.getText());
			}

			else if (e.getSource() == addToppingUnit) {
				choice = toppingsUnitComboBox.getSelectedItem().toString();
				amount = Double.valueOf(toppingsUnitField.getText());
			}

			else if (e.getSource() == addMeat) {
				choice = meatsComboBox.getSelectedItem().toString();
				amount = Double.valueOf(meatsField.getText());
			}

			else if (e.getSource() == addProduct) {
				choice = productsComboBox.getSelectedItem().toString();
				amount = Double.valueOf(productsField.getText());

			}
			// Instantiates new food after data is passed in
			Food newFood = new Food(choice, hashFood.get(choice), amount);

			// Added to foodList Array
			foodList.add(newFood);

			// Following methods add to the total cost below
			sum += hashFood.get(choice) * amount;
			String convertedSum = String.format("%.2f", sum);
			totalCostLabel.setText("Total: " + convertedSum);
		}

	}

	public void componentResized(ComponentEvent e) {
	}

	public void componentMoved(ComponentEvent e) {
	}

	public void componentShown(ComponentEvent e) {
	}

	public void componentHidden(ComponentEvent e) {
	}
}
