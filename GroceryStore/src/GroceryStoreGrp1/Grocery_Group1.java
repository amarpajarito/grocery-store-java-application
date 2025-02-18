package GroceryStoreGrp1;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.AbstractListModel;
import javax.swing.JTextArea;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import java.awt.Component;
import javax.swing.JRadioButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import java.awt.FlowLayout;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class Grocery_Group1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel mainFrame;
	private JTextField txtfUnitPrice;
	private JTextField txtfQuantity;
	private JTextField txtfSubTotal;
	private JPasswordField passfieldPin1;
	private JPasswordField passfieldPin2;
	private JList<String> lstList;
	private DefaultListModel<String> listModel;
	DecimalFormat df = new DecimalFormat("0.00");
	private List<Item> cartItems = new ArrayList<>();
	private JTextArea txtaOutput;
	private JButton btnAddtoCart;
	private JButton btnClearRow1;
	private JButton btnCheckOut;
	private JButton btnClearRow2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Grocery_Group1 frame = new Grocery_Group1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private static class Item {
	    private float unitPrice;
	    private int quantity;
	    private float subtotal;

	    public Item(float unitPrice, int quantity) {
	        this.unitPrice = unitPrice;
	        this.quantity = quantity;
	        this.subtotal = unitPrice * quantity;
	    }

	    public float getUnitPrice() {
	        return unitPrice;
	    }

	    public int getQuantity() {
	        return quantity;
	    }

	    public float getSubtotal() {
	        return subtotal;
	    }
	}
	
	private void disableFieldsAndButtons() {
	    txtfUnitPrice.setEnabled(false);
	    txtfSubTotal.setEnabled(false);
	    txtfQuantity.setEnabled(false);
	    lstList.setEnabled(false);
	    btnAddtoCart.setEnabled(false);
	    btnClearRow1.setEnabled(false);
	}

	private void enableFieldsAndButtons() {
	    txtfUnitPrice.setEnabled(true);
	    txtfSubTotal.setEnabled(true);
	    txtfQuantity.setEnabled(true);
	    lstList.setEnabled(true);
	    btnAddtoCart.setEnabled(true);
	    btnClearRow1.setEnabled(true);
	}
	
	private void updateButtonState() {
	    boolean hasItems = !txtaOutput.getText().trim().isEmpty();
	    btnCheckOut.setEnabled(hasItems);
	    btnClearRow2.setEnabled(hasItems);
	}

	/**
	 * Create the frame.
	 */
	public Grocery_Group1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 930, 600);
		mainFrame = new JPanel();
		mainFrame.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(mainFrame);
		GridBagLayout gbl_mainFrame = new GridBagLayout();
		gbl_mainFrame.columnWidths = new int[]{0, 0};
		gbl_mainFrame.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_mainFrame.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_mainFrame.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		mainFrame.setLayout(gbl_mainFrame);
		
		listModel = new DefaultListModel<>();
		
		JPanel pnlRow1 = new JPanel();
		pnlRow1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GridBagConstraints gbc_pnlRow1 = new GridBagConstraints();
		gbc_pnlRow1.insets = new Insets(5, 10, 5, 10);
		gbc_pnlRow1.fill = GridBagConstraints.BOTH;
		gbc_pnlRow1.gridx = 0;
		gbc_pnlRow1.gridy = 0;
		mainFrame.add(pnlRow1, gbc_pnlRow1);
		GridBagLayout gbl_pnlRow1 = new GridBagLayout();
		gbl_pnlRow1.columnWidths = new int[]{0, 0};
		gbl_pnlRow1.rowHeights = new int[]{0, 0, 0, 0};
		gbl_pnlRow1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_pnlRow1.rowWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		pnlRow1.setLayout(gbl_pnlRow1);
		
		JLabel lblStoreTitle = new JLabel("Welcome to Group 1's Grocery Store");
		lblStoreTitle.setFont(new Font("Verdana", Font.BOLD, 18));
		GridBagConstraints gbc_lblStoreTitle = new GridBagConstraints();
		gbc_lblStoreTitle.insets = new Insets(5, 5, 5, 5);
		gbc_lblStoreTitle.gridx = 0;
		gbc_lblStoreTitle.gridy = 0;
		pnlRow1.add(lblStoreTitle, gbc_lblStoreTitle);
		
		JPanel pnlSub1 = new JPanel();
		GridBagConstraints gbc_pnlSub1 = new GridBagConstraints();
		gbc_pnlSub1.insets = new Insets(5, 10, 5, 10);
		gbc_pnlSub1.fill = GridBagConstraints.BOTH;
		gbc_pnlSub1.gridx = 0;
		gbc_pnlSub1.gridy = 1;
		pnlRow1.add(pnlSub1, gbc_pnlSub1);
		pnlSub1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel pnlCategory = new JPanel();
		pnlSub1.add(pnlCategory);
		GridBagLayout gbl_pnlCategory = new GridBagLayout();
		gbl_pnlCategory.columnWidths = new int[] {0, 0, 30, 30, 30};
		gbl_pnlCategory.rowHeights = new int[]{0, 0, 0};
		gbl_pnlCategory.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_pnlCategory.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		pnlCategory.setLayout(gbl_pnlCategory);
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setFont(new Font("Verdana", Font.BOLD, 14));
		GridBagConstraints gbc_lblCategory = new GridBagConstraints();
		gbc_lblCategory.gridwidth = 5;
		gbc_lblCategory.insets = new Insets(5, 10, 5, 10);
		gbc_lblCategory.gridx = 0;
		gbc_lblCategory.gridy = 0;
		pnlCategory.add(lblCategory, gbc_lblCategory);
		
		JComboBox cmbCategory = new JComboBox();
		cmbCategory.setFont(new Font("Verdana", Font.PLAIN, 14));
		cmbCategory.setModel(new DefaultComboBoxModel<>(new String[]{
	            "Select a category", 
	            "Fresh & Package Foods", 
	            "Beverages", 
	            "Canned Goods", 
	            "Condiments & Spices", 
	            "Household Products", 
	            "Personal Care Products", 
	            "Pet Care Products"
	        }));
		GridBagConstraints gbc_cmbCategory = new GridBagConstraints();
		gbc_cmbCategory.insets = new Insets(0, 10, 10, 10);
		gbc_cmbCategory.gridwidth = 5;
		gbc_cmbCategory.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbCategory.gridx = 0;
		gbc_cmbCategory.gridy = 1;
		pnlCategory.add(cmbCategory, gbc_cmbCategory);
		
		JPanel pnlItems = new JPanel();
		pnlSub1.add(pnlItems);
		GridBagLayout gbl_pnlItems = new GridBagLayout();
		gbl_pnlItems.columnWidths = new int[] {0, 0, 30, 30, 30};
		gbl_pnlItems.rowHeights = new int[]{0, 0, 0};
		gbl_pnlItems.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_pnlItems.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		pnlItems.setLayout(gbl_pnlItems);
		
		JLabel lblItems = new JLabel("Items");
		lblItems.setFont(new Font("Verdana", Font.BOLD, 14));
		GridBagConstraints gbc_lblItems = new GridBagConstraints();
		gbc_lblItems.gridwidth = 5;
		gbc_lblItems.insets = new Insets(5, 10, 5, 10);
		gbc_lblItems.gridx = 0;
		gbc_lblItems.gridy = 0;
		pnlItems.add(lblItems, gbc_lblItems);
		
		lstList = new JList<>(listModel);
		lstList.setBorder(new LineBorder(new Color(0, 0, 0)));
		lstList.setFont(new Font("Verdana", Font.PLAIN, 14));
		GridBagConstraints gbc_lstList = new GridBagConstraints();
		gbc_lstList.gridwidth = 5;
		gbc_lstList.insets = new Insets(0, 10, 10, 10);
		gbc_lstList.fill = GridBagConstraints.BOTH;
		gbc_lstList.gridx = 0;
		gbc_lstList.gridy = 1;
		pnlItems.add(lstList, gbc_lstList);
		
		Map<String, Map<String, Float>> categoryItemsMap = new HashMap<>();
		categoryItemsMap.put("Fresh & Package Foods", Map.of("Meat", 350.00f, "Fish", 200.00f, "Dairy", 50.00f, "Baked Goods", 60.00f));
		categoryItemsMap.put("Beverages", Map.of("Coffee", 150.00f, "Tea", 100.00f, "Juice", 50.00f, "Soda", 25.00f, "Beer", 40.00f, "Wine", 300.00f));
		categoryItemsMap.put("Canned Goods", Map.of("Soup", 45.00f, "Tuna", 35.00f, "Beans", 40.00f, "Vegetables", 30.00f, "Pasta Sauce", 70.00f));
		categoryItemsMap.put("Condiments & Spices", Map.of("Salt", 10.00f, "Pepper", 20.00f, "Oregano", 50.00f, "Cinnamon", 30.00f, "Sugar", 40.00f, "Olive Oil", 250.00f, "Ketchup", 50.00f, "Mayonnaise", 60.00f));
		categoryItemsMap.put("Household Products", Map.of("Paper Towels", 100.00f, "Tissues", 50.00f, "Trash Bags", 80.00f, "Dish Soap", 30.00f, "Laundry Detergent", 150.00f, "Aluminum Foil", 40.00f));
		categoryItemsMap.put("Personal Care Products", Map.of("Shampoo", 80.00f, "Conditioner", 80.00f, "Deodorant", 100.00f, "Toothpaste", 60.00f, "Dental Floss", 50.00f));
		categoryItemsMap.put("Pet Care Products", Map.of("Pet Food", 200.00f, "Kitty Litter", 150.00f, "Chew Toys", 100.00f, "Pet Shampoo", 120.00f));

		cmbCategory.addActionListener(e -> {
		    String selectedCategory = (String) cmbCategory.getSelectedItem();
		    listModel.clear();

		    if ("Select a category".equals(selectedCategory)) {
		        disableFieldsAndButtons();
		        txtfUnitPrice.setText("");
		        txtfSubTotal.setText("");
		        txtfQuantity.setText("");
		    } else {
		        enableFieldsAndButtons();
		        txtfUnitPrice.setText("");
		        txtfSubTotal.setText("");
		        lstList.clearSelection();
		        txtfQuantity.setEnabled(false);
		        if (categoryItemsMap.containsKey(selectedCategory)) {
		            for (String item : categoryItemsMap.get(selectedCategory).keySet()) {
		                listModel.addElement(item);
		            }
		        }
		    }
		});

		lstList.addListSelectionListener(e -> {
		    if (!e.getValueIsAdjusting()) {
		        String selectedCategory = (String) cmbCategory.getSelectedItem();
		        String selectedItem = lstList.getSelectedValue();

		        if (selectedCategory != null && selectedItem != null && categoryItemsMap.containsKey(selectedCategory)) {
		            Float price = categoryItemsMap.get(selectedCategory).get(selectedItem);
		            if (price != null) {
		                txtfUnitPrice.setText("Php " + df.format(price));
		                txtfQuantity.setEnabled(true);
		                txtfQuantity.setEditable(true);
		            }
		        } else {
		            txtfQuantity.setEnabled(false);
		            txtfQuantity.setEnabled(false);
		        }
		    }
		});


		
		JPanel pnlCart = new JPanel();
		pnlSub1.add(pnlCart);
		pnlCart.setLayout(new GridLayout(3, 2, 10, 10));
		
		JLabel lblUnitPrice = new JLabel("Unit Price");
		lblUnitPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblUnitPrice.setFont(new Font("Verdana", Font.BOLD, 14));
		pnlCart.add(lblUnitPrice);
		
		txtfUnitPrice = new JTextField();
		txtfUnitPrice.setEnabled(false);
		txtfUnitPrice.setEditable(false);
		txtfUnitPrice.setFont(new Font("Verdana", Font.PLAIN, 14));
		pnlCart.add(txtfUnitPrice);
		txtfUnitPrice.setColumns(10);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantity.setFont(new Font("Verdana", Font.BOLD, 14));
		pnlCart.add(lblQuantity);
		
		txtfQuantity = new JTextField();
		txtfQuantity.setEditable(false);
		txtfQuantity.setEnabled(false);
		txtfQuantity.setFont(new Font("Verdana", Font.PLAIN, 14));
		pnlCart.add(txtfQuantity);
		txtfQuantity.setColumns(10);
		
		JLabel lblSubTotal = new JLabel("Subtotal");
		lblSubTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubTotal.setFont(new Font("Verdana", Font.BOLD, 14));
		pnlCart.add(lblSubTotal);
		
		txtfSubTotal = new JTextField();
		txtfSubTotal.setEditable(false);
		txtfSubTotal.setEnabled(false);
		txtfSubTotal.setFont(new Font("Verdana", Font.PLAIN, 14));
		pnlCart.add(txtfSubTotal);
		txtfSubTotal.setColumns(10);
		
		JPanel pnlButtonRow1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pnlButtonRow1.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		GridBagConstraints gbc_pnlButtonRow1 = new GridBagConstraints();
		gbc_pnlButtonRow1.insets = new Insets(0, 10, 5, 10);
		gbc_pnlButtonRow1.fill = GridBagConstraints.BOTH;
		gbc_pnlButtonRow1.gridx = 0;
		gbc_pnlButtonRow1.gridy = 2;
		pnlRow1.add(pnlButtonRow1, gbc_pnlButtonRow1);
		
		btnAddtoCart = new JButton("Add to Cart");
		btnAddtoCart.setEnabled(false);
		btnAddtoCart.setFont(new Font("Verdana", Font.PLAIN, 14));
		pnlButtonRow1.add(btnAddtoCart);
		
		btnClearRow1 = new JButton("Clear");
		btnClearRow1.setEnabled(false);
		btnClearRow1.setFont(new Font("Verdana", Font.PLAIN, 14));
		pnlButtonRow1.add(btnClearRow1);
		
		btnAddtoCart.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        try {
		            float unitPrice = Float.parseFloat(txtfUnitPrice.getText().replace("Php ", "").trim());
		            int quantity = Integer.parseInt(txtfQuantity.getText());
		            float subtotal = unitPrice * quantity;
		            String selectedItem = lstList.getSelectedValue();

		            if (selectedItem != null) {
		                cartItems.add(new Item(unitPrice, quantity));
		                String output = String.format("%s - Php %.2f x %d = Php %.2f", selectedItem, unitPrice, quantity, subtotal);
		                txtaOutput.append(output + "\n");
		                txtfSubTotal.setText(String.format("%.2f", subtotal));

		                JOptionPane.showMessageDialog(mainFrame,
		                    String.format("'%s' has been added to your cart.", selectedItem),
		                    "Item Added",
		                    JOptionPane.INFORMATION_MESSAGE);
		                
		                updateButtonState();

		                cmbCategory.setSelectedIndex(0);
		                txtfQuantity.setText("");
		                txtfUnitPrice.setText("");
		                txtfSubTotal.setText("");
		                txtfUnitPrice.setEditable(false);
		                txtfSubTotal.setEditable(false);
		                
		                
		            } else {
		                JOptionPane.showMessageDialog(mainFrame,
		                    "Please select an item from the list.",
		                    "Selection Error",
		                    JOptionPane.ERROR_MESSAGE);
		            }
		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(mainFrame,
		                "Please enter valid numbers for price and quantity.",
		                "Input Error",
		                JOptionPane.ERROR_MESSAGE);
		        }
		    }
		});

		btnClearRow1.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        cmbCategory.setSelectedItem("Select a category");
		        lstList.clearSelection();
		        txtfUnitPrice.setText("");
		        txtfQuantity.setText("");
		        txtfSubTotal.setText("");
		    }
		});
		
		JPanel pnlRow2 = new JPanel();
		pnlRow2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GridBagConstraints gbc_pnlRow2 = new GridBagConstraints();
		gbc_pnlRow2.insets = new Insets(5, 10, 5, 10);
		gbc_pnlRow2.fill = GridBagConstraints.BOTH;
		gbc_pnlRow2.gridx = 0;
		gbc_pnlRow2.gridy = 1;
		mainFrame.add(pnlRow2, gbc_pnlRow2);
		GridBagLayout gbl_pnlRow2 = new GridBagLayout();
		gbl_pnlRow2.columnWidths = new int[]{0, 0};
		gbl_pnlRow2.rowHeights = new int[]{0, 0, 0, 0};
		gbl_pnlRow2.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_pnlRow2.rowWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		pnlRow2.setLayout(gbl_pnlRow2);
		
		JLabel lblCart = new JLabel("Cart");
		lblCart.setFont(new Font("Verdana", Font.BOLD, 18));
		GridBagConstraints gbc_lblCart = new GridBagConstraints();
		gbc_lblCart.insets = new Insets(5, 10, 5, 10);
		gbc_lblCart.gridx = 0;
		gbc_lblCart.gridy = 0;
		pnlRow2.add(lblCart, gbc_lblCart);
		
		txtaOutput = new JTextArea();
		txtaOutput.setEditable(false);
		txtaOutput.setText("");
		txtaOutput.setFont(new Font("Verdana", Font.PLAIN, 14));
		GridBagConstraints gbc_txtaOutput = new GridBagConstraints();
		gbc_txtaOutput.insets = new Insets(0, 15, 5, 15);
		gbc_txtaOutput.fill = GridBagConstraints.BOTH;
		gbc_txtaOutput.gridx = 0;
		gbc_txtaOutput.gridy = 1;
		pnlRow2.add(txtaOutput, gbc_txtaOutput);
		
		JPanel pnlRow2Btn = new JPanel();
		GridBagConstraints gbc_pnlRow2Btn = new GridBagConstraints();
		gbc_pnlRow2Btn.fill = GridBagConstraints.BOTH;
		gbc_pnlRow2Btn.gridx = 0;
		gbc_pnlRow2Btn.gridy = 2;
		pnlRow2.add(pnlRow2Btn, gbc_pnlRow2Btn);
		
		btnCheckOut = new JButton("Checkout");
		btnCheckOut.setEnabled(false);
		btnCheckOut.setFont(new Font("Verdana", Font.PLAIN, 14));
		pnlRow2Btn.add(btnCheckOut);
		
		btnClearRow2 = new JButton("Clear");
		btnClearRow2.setEnabled(false);
		btnClearRow2.setFont(new Font("Verdana", Font.PLAIN, 14));
		pnlRow2Btn.add(btnClearRow2);
		
		btnCheckOut.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        if (cartItems.isEmpty()) {
		            JOptionPane.showMessageDialog(mainFrame,
		                "Your cart is empty. Please add items before checking out.",
		                "Checkout Error",
		                JOptionPane.ERROR_MESSAGE);
		            return;
		        }

		        float totalAmount = 0;
		        for (Item item : cartItems) {
		            totalAmount += item.getSubtotal();
		        }

		        JOptionPane.showMessageDialog(mainFrame,
		            String.format("Your total amount is: Php %.2f\nPlease proceed to the checkout section to apply discounts and select a payment method.", totalAmount),
		            "Proceed to Checkout",
		            JOptionPane.INFORMATION_MESSAGE);
		    }
		});
		
		btnClearRow2.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        cartItems.clear();
		        txtaOutput.setText("");
		        
		        updateButtonState();
		    }
		});
		
		JPanel pnlRow3 = new JPanel();
		pnlRow3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GridBagConstraints gbc_pnlRow3 = new GridBagConstraints();
		gbc_pnlRow3.insets = new Insets(5, 10, 5, 10);
		gbc_pnlRow3.fill = GridBagConstraints.BOTH;
		gbc_pnlRow3.gridx = 0;
		gbc_pnlRow3.gridy = 2;
		mainFrame.add(pnlRow3, gbc_pnlRow3);
		GridBagLayout gbl_pnlRow3 = new GridBagLayout();
		gbl_pnlRow3.columnWidths = new int[]{0, 0};
		gbl_pnlRow3.rowHeights = new int[]{0, 0};
		gbl_pnlRow3.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_pnlRow3.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		pnlRow3.setLayout(gbl_pnlRow3);
		
		JPanel pnlSubRow3 = new JPanel();
		GridBagConstraints gbc_pnlSubRow3 = new GridBagConstraints();
		gbc_pnlSubRow3.insets = new Insets(5, 10, 5, 10);
		gbc_pnlSubRow3.fill = GridBagConstraints.BOTH;
		gbc_pnlSubRow3.gridx = 0;
		gbc_pnlSubRow3.gridy = 0;
		pnlRow3.add(pnlSubRow3, gbc_pnlSubRow3);
		pnlSubRow3.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel pnlDiscount = new JPanel();
		pnlSubRow3.add(pnlDiscount);
		pnlDiscount.setLayout(new GridLayout(2, 1, 10, 10));
		
		JCheckBox chckbxWmembership = new JCheckBox("with Membership Discount");
		chckbxWmembership.setFont(new Font("Verdana", Font.PLAIN, 14));
		chckbxWmembership.setHorizontalAlignment(SwingConstants.LEFT);
		pnlDiscount.add(chckbxWmembership);
		
		JCheckBox chckbxSeniorOrPwd = new JCheckBox("Senior or PWD");
		chckbxSeniorOrPwd.setFont(new Font("Verdana", Font.PLAIN, 14));
		chckbxSeniorOrPwd.setHorizontalAlignment(SwingConstants.LEFT);
		chckbxSeniorOrPwd.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		chckbxSeniorOrPwd.setAlignmentX(Component.CENTER_ALIGNMENT);
		pnlDiscount.add(chckbxSeniorOrPwd);
		
		JPanel pnlModeOfPayment = new JPanel();
		pnlSubRow3.add(pnlModeOfPayment);
		pnlModeOfPayment.setLayout(new GridLayout(3, 1, 10, 10));
		
		JRadioButton rdbtnCash = new JRadioButton("Cash");
		rdbtnCash.setFont(new Font("Verdana", Font.PLAIN, 14));
		rdbtnCash.setHorizontalAlignment(SwingConstants.LEFT);
		pnlModeOfPayment.add(rdbtnCash);
		
		JRadioButton rdbtnCreditCard = new JRadioButton("Credit Card");
		rdbtnCreditCard.setFont(new Font("Verdana", Font.PLAIN, 14));
		rdbtnCreditCard.setHorizontalAlignment(SwingConstants.LEFT);
		pnlModeOfPayment.add(rdbtnCreditCard);
		
		JRadioButton rdbtnDebitCard = new JRadioButton("Debit Card");
		rdbtnDebitCard.setFont(new Font("Verdana", Font.PLAIN, 14));
		rdbtnDebitCard.setHorizontalAlignment(SwingConstants.LEFT);
		pnlModeOfPayment.add(rdbtnDebitCard);
		
		JPanel pnlPin = new JPanel();
		pnlSubRow3.add(pnlPin);
		pnlPin.setLayout(new GridLayout(2, 2, 10, 10));
		
		JLabel lblPin1 = new JLabel("Pin");
		lblPin1.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblPin1.setHorizontalAlignment(SwingConstants.CENTER);
		pnlPin.add(lblPin1);
		
		passfieldPin1 = new JPasswordField();
		passfieldPin1.setFont(new Font("Verdana", Font.PLAIN, 14));
		pnlPin.add(passfieldPin1);
		
		JLabel lblPin2 = new JLabel("Pin");
		lblPin2.setHorizontalAlignment(SwingConstants.CENTER);
		lblPin2.setFont(new Font("Verdana", Font.PLAIN, 14));
		pnlPin.add(lblPin2);
		
		passfieldPin2 = new JPasswordField();
		passfieldPin2.setFont(new Font("Verdana", Font.PLAIN, 14));
		pnlPin.add(passfieldPin2);
		
		JPanel pnlRow4 = new JPanel();
		GridBagConstraints gbc_pnlRow4 = new GridBagConstraints();
		gbc_pnlRow4.insets = new Insets(0, 0, 5, 0);
		gbc_pnlRow4.fill = GridBagConstraints.BOTH;
		gbc_pnlRow4.gridx = 0;
		gbc_pnlRow4.gridy = 3;
		mainFrame.add(pnlRow4, gbc_pnlRow4);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setFont(new Font("Verdana", Font.PLAIN, 14));
		pnlRow4.add(btnConfirm);
		
		JButton btnClearRow4 = new JButton("Clear");
		btnClearRow4.setFont(new Font("Verdana", Font.PLAIN, 14));
		pnlRow4.add(btnClearRow4);
	}

}