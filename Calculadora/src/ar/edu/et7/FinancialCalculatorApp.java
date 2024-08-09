package ar.edu.et7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FinancialCalculatorApp extends JFrame {
    public FinancialCalculatorApp() {
        setTitle("Financial Calculator");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTabbedPane tabbedPane = new JTabbedPane();

        // Sistema Alemán
        JPanel germanSystemPanel = new JPanel(new GridBagLayout());
        addInputFields(germanSystemPanel, "Monto:", "TNA:", "Cuotas:", e -> calcularSistemaAleman());
        tabbedPane.addTab("Sistema Alemán", germanSystemPanel);

        // Sistema Francés
        JPanel frenchSystemPanel = new JPanel(new GridBagLayout());
        addInputFields(frenchSystemPanel, "Monto:", "TNA:", "Cuotas:", e -> calcularSistemaFrances());
        tabbedPane.addTab("Sistema Francés", frenchSystemPanel);

        // TNA y TEA
        JPanel tnaTeaPanel = new JPanel(new GridBagLayout());
        addInputFields(tnaTeaPanel, "TNA:", null, "TEA:", e -> calcularTnaTea());
        tabbedPane.addTab("TNA y TEA", tnaTeaPanel);

        // CFT
        JPanel cftPanel = new JPanel(new GridBagLayout());
        addInputFields(cftPanel, "TNA:", "Gastos Asociados:", null, e -> calcularCft());
        tabbedPane.addTab("CFT", cftPanel);

        // Descuento
        JPanel discountPanel = new JPanel(new GridBagLayout());
        addInputFields(discountPanel, "Importe:", "Descuento:", null, e -> calcularDescuento());
        tabbedPane.addTab("Descuento", discountPanel);

        // Descuento por cantidad
        JPanel discountQuantityPanel = new JPanel(new GridBagLayout());
        addInputFields(discountQuantityPanel, "Precio Unitario:", "Cantidad:", null, e -> calcularDescuentoPorCantidad());
        tabbedPane.addTab("Descuento por Cantidad", discountQuantityPanel);

        // Conversión de Moneda
        JPanel currencyConversionPanel = new JPanel(new GridBagLayout());
        addInputFields(currencyConversionPanel, "ARS:", null, null, e -> conversionMoneda());
        tabbedPane.addTab("Conversión de Moneda", currencyConversionPanel);

        add(tabbedPane);
    }

    private void addInputFields(JPanel panel, String label1, String label2, String label3, ActionListener action) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_END;

        if (label1 != null) {
            panel.add(new JLabel(label1), gbc);
            gbc.gridx = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            panel.add(new JTextField(10), gbc);
            gbc.gridx = 0;
            gbc.gridy++;
        }

        if (label2 != null) {
            panel.add(new JLabel(label2), gbc);
            gbc.gridx = 1;
            panel.add(new JTextField(10), gbc);
            gbc.gridx = 0;
            gbc.gridy++;
        }

        if (label3 != null) {
            panel.add(new JLabel(label3), gbc);
            gbc.gridx = 1;
            panel.add(new JTextField(10), gbc);
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
    }

    private void calcularSistemaAleman() {
        System.out.println("Función: calcularSistemaAleman");
    }

    private void calcularSistemaFrances() {
        System.out.println("Función: calcularSistemaFrances");
    }

    private void calcularTnaTea() {
        System.out.println("Función: calcularTnaTea");
    }

    private void calcularCft() {
        System.out.println("Función: calcularCft");
    }

    private void calcularDescuento() {
        System.out.println("Función: calcularDescuento");
    }

    private void calcularDescuentoPorCantidad() {
        System.out.println("Función: calcularDescuentoPorCantidad");
    }

    private void conversionMoneda() {
        System.out.println("Función: conversionMoneda");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FinancialCalculatorApp app = new FinancialCalculatorApp();
            app.setVisible(true);
        });
    }
}
