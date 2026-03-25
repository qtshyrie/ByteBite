/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ByteBitePackage;

import javax.swing.*;
import java.awt.*;

public class newclass {

    public static void main(String[] args) {
        JFrame frame = new JFrame("BYTEBITE");
        frame.setSize(1000, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // ===== TOP TITLE =====
        JLabel title = new JLabel("BYTEBITE", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 28));
        title.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        frame.add(title, BorderLayout.NORTH);

        // ===== LEFT PANEL (CATEGORIES) =====
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(5, 1, 10, 10));
        leftPanel.setBorder(BorderFactory.createTitledBorder("Categories"));

        String[] categories = {"All Item", "Foods", "Drinks", "Sides"};
        for (String cat : categories) {
            JButton btn = new JButton(cat);
            leftPanel.add(btn);
        }

        JButton logout = new JButton("Log Out");
        leftPanel.add(logout);

        frame.add(leftPanel, BorderLayout.WEST);

        // ===== CENTER PANEL (ITEMS) =====
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(3, 3, 10, 10));
        centerPanel.setBorder(BorderFactory.createTitledBorder("Items"));

        for (int i = 1; i <= 9; i++) {
            JPanel itemPanel = new JPanel(new BorderLayout());

            JLabel pic = new JLabel("Picture", JLabel.CENTER);
            pic.setBorder(BorderFactory.createLineBorder(Color.GRAY));

            JButton addBtn = new JButton("Add");

            itemPanel.add(pic, BorderLayout.CENTER);
            itemPanel.add(addBtn, BorderLayout.SOUTH);

            centerPanel.add(itemPanel);
        }

        frame.add(centerPanel, BorderLayout.CENTER);

        // ===== RIGHT PANEL (CART) =====
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BorderLayout());
        rightPanel.setBorder(BorderFactory.createTitledBorder("Cart"));

        DefaultListModel<String> cartModel = new DefaultListModel<>();
        JList<String> cartList = new JList<>(cartModel);

        JScrollPane scroll = new JScrollPane(cartList);
        rightPanel.add(scroll, BorderLayout.CENTER);

        JPanel cartButtons = new JPanel();
        JButton removeBtn = new JButton("Delete");
        JButton checkoutBtn = new JButton("Checkout");
        JButton cancelBtn = new JButton("Cancel");

        cartButtons.add(removeBtn);
        cartButtons.add(cancelBtn);
        cartButtons.add(checkoutBtn);

        rightPanel.add(cartButtons, BorderLayout.SOUTH);

        frame.add(rightPanel, BorderLayout.EAST);

        // ===== FUNCTIONALITY =====
        Component[] items = centerPanel.getComponents();
        for (Component comp : items) {
            JPanel panel = (JPanel) comp;
            JButton addBtn = (JButton) panel.getComponent(1);

            addBtn.addActionListener(e -> {
                cartModel.addElement("Item added");
            });
        }

        removeBtn.addActionListener(e -> {
            int selected = cartList.getSelectedIndex();
            if (selected != -1) {
                cartModel.remove(selected);
            }
        });

        cancelBtn.addActionListener(e -> cartModel.clear());

        checkoutBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Checkout complete!");
            cartModel.clear();
        });

        frame.setVisible(true);
    }
}
