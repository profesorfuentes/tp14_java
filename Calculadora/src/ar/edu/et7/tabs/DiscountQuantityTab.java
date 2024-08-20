package ar.edu.et7.tabs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DiscountQuantityTab extends TabPanel {
    private JTextField unitPriceField;
    private JTextField quantityField;
    private JTextArea resultArea;

    public DiscountQuantityTab() {
        unitPriceField = new JTextField(10);
        quantityField = new JTextField(10);
        resultArea = new JTextArea(5, 20);
        createPanel();
    }

    @Override
    public JPanel createPanel() {
        panel = new JPanel(new GridBagLayout());
        addInputFields(panel, unitPriceField, quantityField, this::calcular, resultArea);
        return panel;
    }

    private void calcular(ActionEvent e) {
        double unitPrice = 0;
        int quantity = 0;
        double totalPriceWithDiscount = 0;
        double discount = 0;

        try {
            unitPrice = Double.parseDouble(unitPriceField.getText());
            quantity = Integer.parseInt(quantityField.getText());
        } catch (NumberFormatException ex) {
            resultArea.setText("Error en la entrada: " + ex.getMessage());
            return;
        }

        // Determinar el descuento basado en la cantidad
        if (quantity >= 50) {
            discount = 0.3; // 30% de descuento para 50 o más unidades
        } else if (quantity >= 20) {
            discount = 0.2; // 20% de descuento para 20 o más unidades
        } else if (quantity >= 10) {
            discount = 0.1; // 10% de descuento para 10 o más unidades
        } else {
            discount = 0.0; // Sin descuento para menos de 10 unidades
        }

        // Calcular el precio total con descuento
        double totalPrice = quantity * unitPrice;
        totalPriceWithDiscount = totalPrice * (1 - discount);

        // Mostrar el descuento aplicado y el precio total con descuento
        resultArea.setText(String.format(
            "Descuento aplicado: %.0f%%%nPrecio total con descuento: $%.2f",
            discount * 100, totalPriceWithDiscount
        ));
    }

    private void addInputFields(JPanel panel, JTextField field1, JTextField field2, ActionListener action, JTextArea resultArea) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_END;

        if (field1 != null) {
            panel.add(new JLabel("Precio unitario:"), gbc);
            gbc.gridx = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            panel.add(field1, gbc);
            gbc.gridx = 0;
            gbc.gridy++;
        }

        if (field2 != null) {
            panel.add(new JLabel("Cantidad:"), gbc);
            gbc.gridx = 1;
            panel.add(field2, gbc);
            gbc.gridx = 0;
            gbc.gridy++;
        }

        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        JButton calcularButton = new JButton("Calcular");
        calcularButton.addActionListener(action);
        panel.add(calcularButton, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        resultArea.setLineWrap(true);
        resultArea.setWrapStyleWord(true);
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        panel.add(scrollPane, gbc);
    }
}