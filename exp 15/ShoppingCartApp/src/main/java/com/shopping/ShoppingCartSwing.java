package com.shopping;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ShoppingCartSwing {

    private ShopManager shopManager;
    private JFrame frame;
    private JTabbedPane tabbedPane;
    private JTable productTable;
    private JTable cartTable;
    private JLabel totalLabel;
    private JLabel discountLabel;
    private JLabel subtotalLabel;
    private JTextField discountField;
    private JTextArea receiptArea;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                new ShoppingCartSwing().initialize();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public void initialize() {
        shopManager = new ShopManager();
        shopManager.initializeProducts();

       
        frame = new JFrame("Shopping Cart System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);

       
        tabbedPane = new JTabbedPane();
        
       
        tabbedPane.addTab("Shop", createShopPanel());
        tabbedPane.addTab("Cart", createCartPanel());
        tabbedPane.addTab("Checkout", createCheckoutPanel());

        frame.add(tabbedPane);
        frame.setVisible(true);
    }

    private JPanel createShopPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

       
        JLabel titleLabel = new JLabel("Available Products");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(titleLabel, BorderLayout.NORTH);

        
        String[] columnNames = {"ID", "Name", "Price", "Category", "Action"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 4; // Only action column is editable
            }
        };

        for (Product product : shopManager.getProductCatalog()) {
            model.addRow(new Object[]{
                product.getId(),
                product.getName(),
                String.format("$%.2f", product.getPrice()),
                product.getCategory(),
                "Add to Cart"
            });
        }

        productTable = new JTable(model);
        productTable.getColumn("Action").setCellRenderer(new ButtonRenderer());
        productTable.getColumn("Action").setCellEditor(new ButtonEditor(new JTextField(), "Add to Cart", true));

        JScrollPane scrollPane = new JScrollPane(productTable);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    private JPanel createCartPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

     
        JLabel titleLabel = new JLabel("Your Shopping Cart");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(titleLabel, BorderLayout.NORTH);

        String[] columnNames = {"Product", "Unit Price", "Quantity", "Total", "Action"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        cartTable = new JTable(model);
        cartTable.getColumn("Action").setCellRenderer(new ButtonRenderer());
        cartTable.getColumn("Action").setCellEditor(new ButtonEditor(new JTextField(), "Remove", false));

        JScrollPane scrollPane = new JScrollPane(cartTable);
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

        JPanel discountPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        discountPanel.add(new JLabel("Discount Code:"));
        discountField = new JTextField(10);
        discountPanel.add(discountField);
        JButton applyButton = new JButton("Apply");
        applyButton.addActionListener(e -> applyDiscount());
        discountPanel.add(applyButton);

        JPanel totalsPanel = new JPanel(new GridLayout(3, 1, 5, 5));
        subtotalLabel = new JLabel("Subtotal: $0.00");
        discountLabel = new JLabel("Discount: $0.00");
        totalLabel = new JLabel("Total: $0.00");
        totalLabel.setFont(new Font("Arial", Font.BOLD, 14));
        totalsPanel.add(subtotalLabel);
        totalsPanel.add(discountLabel);
        totalsPanel.add(totalLabel);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton clearButton = new JButton("Clear Cart");
        clearButton.addActionListener(e -> {
            shopManager.resetCart();
            updateCartView();
        });
        buttonPanel.add(clearButton);

        bottomPanel.add(discountPanel);
        bottomPanel.add(totalsPanel);
        bottomPanel.add(buttonPanel);

        panel.add(bottomPanel, BorderLayout.SOUTH);
        updateCartView();

        return panel;
    }

    private JPanel createCheckoutPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

      
        JLabel titleLabel = new JLabel("Checkout");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(titleLabel, BorderLayout.NORTH);

       
        receiptArea = new JTextArea();
        receiptArea.setEditable(false);
        receiptArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(receiptArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton checkoutButton = new JButton("Complete Checkout");
        checkoutButton.addActionListener(e -> checkout());
        buttonPanel.add(checkoutButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }

    private void applyDiscount() {
        String discountCode = discountField.getText().trim();
        if (discountCode.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please enter a discount code.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean success = shopManager.applyDiscount(discountCode);
        if (success) {
            JOptionPane.showMessageDialog(frame, "Discount applied successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            updateCartView();
        } else {
            JOptionPane.showMessageDialog(frame, "Invalid discount code or discount already applied.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void checkout() {
        if (shopManager.getCartSize() == 0) {
            JOptionPane.showMessageDialog(frame, "Your cart is empty. Nothing to checkout.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        StringBuilder receipt = new StringBuilder();
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);

        receipt.append("===================================\n");
        receipt.append("             RECEIPT              \n");
        receipt.append("===================================\n");
        receipt.append("Date: ").append(formattedDateTime).append("\n");
        receipt.append("-----------------------------------\n");

        for (CartItem item : shopManager.getCart().getItems()) {
            receipt.append(String.format("%-20s x%d    $%.2f\n", 
                             item.getProduct().getName(),
                             item.getQuantity(),
                             item.getTotalPrice()));
        }

        receipt.append("-----------------------------------\n");
        receipt.append(String.format("Subtotal:            $%.2f\n", shopManager.getCart().getSubtotal()));

        if (shopManager.getCart().isDiscountApplied()) {
            receipt.append(String.format("Discount (%s):     -$%.2f\n", 
                             shopManager.getCart().getAppliedDiscountCode(),
                             shopManager.getCart().getDiscountAmount()));
        }

        receipt.append(String.format("TOTAL:               $%.2f\n", shopManager.getCart().getTotal()));
        receipt.append("===================================\n");
        receipt.append("         Thank you for shopping!  \n");
        receipt.append("===================================\n");

        receiptArea.setText(receipt.toString());

        shopManager.resetCart();
        updateCartView();

        JOptionPane.showMessageDialog(frame, "Thank you for your purchase!\nYour order has been processed successfully.", 
                                    "Checkout Complete", JOptionPane.INFORMATION_MESSAGE);
    }

    private void updateCartView() {
        DefaultTableModel model = (DefaultTableModel) cartTable.getModel();
        model.setRowCount(0); 

        for (CartItem item : shopManager.getCart().getItems()) {
            model.addRow(new Object[]{
                item.getProduct().getName(),
                String.format("$%.2f", item.getProduct().getPrice()),
                item.getQuantity(),
                String.format("$%.2f", item.getTotalPrice()),
                "Remove"
            });
        }

        double subtotal = shopManager.getCart().getSubtotal();
        double discount = shopManager.getCart().getDiscountAmount();
        double total = shopManager.getCart().getTotal();

        subtotalLabel.setText(String.format("Subtotal: $%.2f", subtotal));
        discountLabel.setText(String.format("Discount: $%.2f", discount));
        totalLabel.setText(String.format("Total: $%.2f", total));
    }

    class ButtonRenderer extends JButton implements javax.swing.table.TableCellRenderer {
        public ButtonRenderer() {
            setOpaque(true);
        }

        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value == null) ? "" : value.toString());
            return this;
        }
    }

    class ButtonEditor extends DefaultCellEditor {
        private String label;
        private JButton button;
        private boolean isPushed;
        private boolean isProductTable;

        public ButtonEditor(JTextField textField, String label, boolean isProductTable) {
            super(textField);
            this.label = label;
            this.isProductTable = isProductTable;
            button = new JButton(label);
            button.setOpaque(true);
            button.addActionListener(e -> fireEditingStopped());
        }

        public Component getTableCellEditorComponent(JTable table, Object value,
                boolean isSelected, int row, int column) {
            isPushed = true;
            return button;
        }

        public Object getCellEditorValue() {
            if (isPushed) {
                
                if (isProductTable) {
                  
                    int productId = (int) productTable.getModel().getValueAt(productTable.getSelectedRow(), 0);
                    String input = JOptionPane.showInputDialog(frame, "Enter quantity:", "Add to Cart", JOptionPane.QUESTION_MESSAGE);
                    try {
                        int quantity = Integer.parseInt(input);
                        if (quantity > 0) {
                            shopManager.addToCart(productId, quantity);
                            updateCartView();
                            JOptionPane.showMessageDialog(frame, "Item added to cart!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(frame, "Quantity must be greater than zero.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(frame, "Please enter a valid number for quantity.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    
                    String productName = (String) cartTable.getModel().getValueAt(cartTable.getSelectedRow(), 0);
                    shopManager.removeFromCart(getProductIdByName(productName));
                    updateCartView();
                }
            }
            isPushed = false;
            return label;
        }

        public boolean stopCellEditing() {
            isPushed = false;
            return super.stopCellEditing();
        }
    }

    private int getProductIdByName(String name) {
        for (Product p : shopManager.getProductCatalog()) {
            if (p.getName().equals(name)) {
                return p.getId();
            }
        }
        return -1;
    }

    public static class Product {
        private int id;
        private String name;
        private double price;
        private String category;

        public Product(int id, String name, double price, String category) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.category = category;
        }

        public int getId() { return id; }
        public String getName() { return name; }
        public double getPrice() { return price; }
        public String getCategory() { return category; }

        @Override
        public String toString() {
            return String.format("ID: %d | %-20s | $%.2f | Category: %s",
                    id, name, price, category);
        }
    }

    public static class CartItem {
        private Product product;
        private int quantity;

        public CartItem(Product product, int quantity) {
            this.product = product;
            this.quantity = quantity;
        }

        public Product getProduct() { return product; }
        public int getQuantity() { return quantity; }
        public void setQuantity(int quantity) { this.quantity = quantity; }
        public double getTotalPrice() { return product.getPrice() * quantity; }

        @Override
        public String toString() {
            return String.format("%-20s | $%.2f x %d = $%.2f",
                    product.getName(), product.getPrice(),
                    quantity, getTotalPrice());
        }
    }

    public static class ShoppingCart {
        private List<CartItem> items;
        private double discountRate;
        private boolean discountApplied;
        private String appliedDiscountCode;

        public ShoppingCart() {
            this.items = new ArrayList<>();
            this.discountRate = 0.0;
            this.discountApplied = false;
            this.appliedDiscountCode = null;
        }

        public void addItem(Product product, int quantity) {
            for (CartItem item : items) {
                if (item.getProduct().getId() == product.getId()) {
                    item.setQuantity(item.getQuantity() + quantity);
                    return;
                }
            }
            items.add(new CartItem(product, quantity));
        }

        public boolean removeItem(int productId) {
            Iterator<CartItem> iterator = items.iterator();
            while (iterator.hasNext()) {
                CartItem item = iterator.next();
                if (item.getProduct().getId() == productId) {
                    iterator.remove();
                    return true;
                }
            }
            return false;
        }

        public List<CartItem> getItems() { return items; }
        public double getSubtotal() {
            return items.stream().mapToDouble(CartItem::getTotalPrice).sum();
        }
        public double getDiscountAmount() { return getSubtotal() * discountRate; }
        public double getTotal() { return getSubtotal() - getDiscountAmount(); }
        public boolean applyDiscount(String code, double rate) {
            if (!discountApplied) {
                this.discountRate = rate;
                this.discountApplied = true;
                this.appliedDiscountCode = code;
                return true;
            }
            return false;
        }
        public int getItemCount() { return items.size(); }
        public void clear() {
            items.clear();
            discountRate = 0.0;
            discountApplied = false;
            appliedDiscountCode = null;
        }
        public boolean isDiscountApplied() { return discountApplied; }
        public String getAppliedDiscountCode() { return appliedDiscountCode; }
        public double getDiscountRate() { return discountRate; }
    }

    public static class ShopManager {
        private List<Product> productCatalog;
        private ShoppingCart cart;
        private Map<String, Double> discountCodes;

        public ShopManager() {
            this.productCatalog = new ArrayList<>();
            this.cart = new ShoppingCart();
            this.discountCodes = new HashMap<>();
            discountCodes.put("SAVE10", 0.10);
            discountCodes.put("SAVE20", 0.20);
            discountCodes.put("HALF", 0.50);
        }

        public void initializeProducts() {
            productCatalog.add(new Product(1, "Laptop", 999.99, "Electronics"));
            productCatalog.add(new Product(2, "Smartphone", 499.99, "Electronics"));
            productCatalog.add(new Product(3, "Headphones", 129.99, "Electronics"));
            productCatalog.add(new Product(4, "T-shirt", 19.99, "Clothing"));
            productCatalog.add(new Product(5, "Jeans", 39.99, "Clothing"));
            productCatalog.add(new Product(6, "Sneakers", 79.99, "Footwear"));
            productCatalog.add(new Product(7, "Book", 14.99, "Books"));
            productCatalog.add(new Product(8, "Coffee Mug", 9.99, "Kitchen"));
            productCatalog.add(new Product(9, "Backpack", 49.99, "Accessories"));
            productCatalog.add(new Product(10, "Water Bottle", 12.99, "Kitchen"));
        }

        public List<Product> getProductCatalog() { return productCatalog; }
        public ShoppingCart getCart() { return cart; }
        public Product findProductById(int productId) {
            return productCatalog.stream()
                    .filter(p -> p.getId() == productId)
                    .findFirst()
                    .orElse(null);
        }
        public boolean addToCart(int productId, int quantity) {
            Product product = findProductById(productId);
            if (product != null) {
                cart.addItem(product, quantity);
                return true;
            }
            return false;
        }
        public boolean removeFromCart(int productId) {
            return cart.removeItem(productId);
        }
        public boolean applyDiscount(String code) {
            if (discountCodes.containsKey(code)) {
                return cart.applyDiscount(code, discountCodes.get(code));
            }
            return false;
        }
        public int getCartSize() { return cart.getItemCount(); }
        public void resetCart() { cart.clear(); }
    }
}