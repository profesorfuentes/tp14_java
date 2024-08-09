package ar.edu.et7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FinancialCalculatorApp extends JFrame {

    public FinancialCalculatorApp() {
        setTitle("Financial Calculator");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTabbedPane tabbedPane = new JTabbedPane();

        // Sistema Alemán
        JPanel germanSystemPanel = new JPanel(new GridBagLayout());
        JTextArea resultGermanSystem = new JTextArea(5, 20);
        addInputFields(germanSystemPanel, "Monto:", "TNA:", "Cuotas:", e -> calcularSistemaAleman(resultGermanSystem), resultGermanSystem);
        tabbedPane.addTab("Sistema Alemán", germanSystemPanel);

        // Sistema Francés
        JPanel frenchSystemPanel = new JPanel(new GridBagLayout());
        JTextArea resultFrenchSystem = new JTextArea(5, 20);
        addInputFields(frenchSystemPanel, "Monto:", "TNA:", "Cuotas:", e -> calcularSistemaFrances(resultFrenchSystem), resultFrenchSystem);
        tabbedPane.addTab("Sistema Francés", frenchSystemPanel);

        // TNA y TEA
        JPanel tnaTeaPanel = new JPanel(new GridBagLayout());
        JTextArea resultTnaTea = new JTextArea(5, 20);
        addInputFields(tnaTeaPanel, "TNA:", null, "TEA:", e -> calcularTnaTea(resultTnaTea), resultTnaTea);
        tabbedPane.addTab("TNA y TEA", tnaTeaPanel);

        // CFT
        JPanel cftPanel = new JPanel(new GridBagLayout());
        JTextArea resultCft = new JTextArea(5, 20);
        addInputFields(cftPanel, "TNA:", "Gastos Asociados:", null, e -> calcularCft(resultCft), resultCft);
        tabbedPane.addTab("CFT", cftPanel);

        // Descuento
        JPanel discountPanel = new JPanel(new GridBagLayout());
        JTextArea resultDiscount = new JTextArea(5, 20);
        addInputFields(discountPanel, "Importe:", "Descuento:", null, e -> calcularDescuento(resultDiscount), resultDiscount);
        tabbedPane.addTab("Descuento", discountPanel);

        // Descuento por cantidad
        JPanel discountQuantityPanel = new JPanel(new GridBagLayout());
        JTextArea resultDiscountQuantity = new JTextArea(5, 20);
        addInputFields(discountQuantityPanel, "Precio Unitario:", "Cantidad:", null, e -> calcularDescuentoPorCantidad(resultDiscountQuantity), resultDiscountQuantity);
        tabbedPane.addTab("Descuento por Cantidad", discountQuantityPanel);

        // Conversión de Moneda
        JPanel currencyConversionPanel = new JPanel(new GridBagLayout());
        JTextArea resultCurrencyConversion = new JTextArea(5, 20);
        addInputFields(currencyConversionPanel, "ARS:", null, null, e -> conversionMoneda(resultCurrencyConversion), resultCurrencyConversion);
        tabbedPane.addTab("Conversión de Moneda", currencyConversionPanel);

        add(tabbedPane);
    }

    private void addInputFields(JPanel panel, String label1, String label2, String label3, ActionListener action, JTextArea resultArea) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_END;

        JTextField field1 = null, field2 = null, field3 = null;

        if (label1 != null) {
            panel.add(new JLabel(label1), gbc);
            gbc.gridx = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            field1 = new JTextField(10);
            panel.add(field1, gbc);
            gbc.gridx = 0;
            gbc.gridy++;
        }

        if (label2 != null) {
            panel.add(new JLabel(label2), gbc);
            gbc.gridx = 1;
            field2 = new JTextField(10);
            panel.add(field2, gbc);
            gbc.gridx = 0;
            gbc.gridy++;
        }

        if (label3 != null) {
            panel.add(new JLabel(label3), gbc);
            gbc.gridx = 1;
            field3 = new JTextField(10);
            panel.add(field3, gbc);
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

    private void calcularSistemaAleman(JTextArea resultArea) {
        resultArea.setText("Función: calcularSistemaAleman");
    }

    private void calcularSistemaFrances(JTextArea resultArea) {
        resultArea.setText("Función: calcularSistemaFrances");
    }

    private void calcularTnaTea(JTextArea resultArea) {
        resultArea.setText("Función: calcularTnaTea");
    }

    private void calcularCft(JTextArea resultArea) {
        resultArea.setText("Función: calcularCft");
    }

    private void calcularDescuento(JTextArea resultArea) {
        resultArea.setText("Función: calcularDescuento");
    }

    private void calcularDescuentoPorCantidad(JTextArea resultArea) {
        resultArea.setText("Función: calcularDescuentoPorCantidad");
    }

    private void conversionMoneda(JTextArea resultArea) {
        resultArea.setText("Función: conversionMoneda");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FinancialCalculatorApp app = new FinancialCalculatorApp();
            app.setVisible(true);
        });
    }
}
