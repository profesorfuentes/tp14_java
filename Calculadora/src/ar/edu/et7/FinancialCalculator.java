package ar.edu.et7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FinancialCalculator extends JFrame {
    public FinancialCalculator() {
        setTitle("Financial Calculator");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTabbedPane tabbedPane = new JTabbedPane();

        // Sistema Alemán
        JPanel germanSystemPanel = new JPanel();
        germanSystemPanel.setLayout(new GridLayout(4, 2));
        JTextField montoGerman = new JTextField();
        JTextField tnaGerman = new JTextField();
        JTextField cuotasGerman = new JTextField();
        JButton calcularGerman = new JButton("Calcular");
        calcularGerman.addActionListener(e -> calcularSistemaAleman());
        germanSystemPanel.add(new JLabel("Monto:"));
        germanSystemPanel.add(montoGerman);
        germanSystemPanel.add(new JLabel("TNA:"));
        germanSystemPanel.add(tnaGerman);
        germanSystemPanel.add(new JLabel("Cuotas:"));
        germanSystemPanel.add(cuotasGerman);
        germanSystemPanel.add(calcularGerman);
        tabbedPane.addTab("Sistema Alemán", germanSystemPanel);

        // Sistema Francés
        JPanel frenchSystemPanel = new JPanel();
        frenchSystemPanel.setLayout(new GridLayout(4, 2));
        JTextField montoFrench = new JTextField();
        JTextField tnaFrench = new JTextField();
        JTextField cuotasFrench = new JTextField();
        JButton calcularFrench = new JButton("Calcular");
        calcularFrench.addActionListener(e -> calcularSistemaFrances());
        frenchSystemPanel.add(new JLabel("Monto:"));
        frenchSystemPanel.add(montoFrench);
        frenchSystemPanel.add(new JLabel("TNA:"));
        frenchSystemPanel.add(tnaFrench);
        frenchSystemPanel.add(new JLabel("Cuotas:"));
        frenchSystemPanel.add(cuotasFrench);
        frenchSystemPanel.add(calcularFrench);
        tabbedPane.addTab("Sistema Francés", frenchSystemPanel);

        // TNA y TEA
        JPanel tnaTeaPanel = new JPanel();
        tnaTeaPanel.setLayout(new GridLayout(3, 2));
        JTextField tnaField = new JTextField();
        JButton calcularTnaTea = new JButton("Calcular");
        JTextField teaField = new JTextField();
        calcularTnaTea.addActionListener(e -> calcularTnaTea());
        tnaTeaPanel.add(new JLabel("TNA:"));
        tnaTeaPanel.add(tnaField);
        tnaTeaPanel.add(calcularTnaTea);
        tnaTeaPanel.add(new JLabel("TEA:"));
        tnaTeaPanel.add(teaField);
        tabbedPane.addTab("TNA y TEA", tnaTeaPanel);

        // CFT
        JPanel cftPanel = new JPanel();
        cftPanel.setLayout(new GridLayout(3, 2));
        JTextField tnaCftField = new JTextField();
        JTextField gastosAsociadosField = new JTextField();
        JButton calcularCft = new JButton("Calcular");
        calcularCft.addActionListener(e -> calcularCft());
        cftPanel.add(new JLabel("TNA:"));
        cftPanel.add(tnaCftField);
        cftPanel.add(new JLabel("Gastos Asociados:"));
        cftPanel.add(gastosAsociadosField);
        cftPanel.add(calcularCft);
        tabbedPane.addTab("CFT", cftPanel);

        // Descuento
        JPanel discountPanel = new JPanel();
        discountPanel.setLayout(new GridLayout(3, 2));
        JTextField importeField = new JTextField();
        JTextField descuentoField = new JTextField();
        JButton calcularDescuento = new JButton("Calcular");
        calcularDescuento.addActionListener(e -> calcularDescuento());
        discountPanel.add(new JLabel("Importe:"));
        discountPanel.add(importeField);
        discountPanel.add(new JLabel("Descuento:"));
        discountPanel.add(descuentoField);
        discountPanel.add(calcularDescuento);
        tabbedPane.addTab("Descuento", discountPanel);

        // Descuento por cantidad
        JPanel discountQuantityPanel = new JPanel();
        discountQuantityPanel.setLayout(new GridLayout(3, 2));
        JTextField precioUnitarioField = new JTextField();
        JTextField cantidadField = new JTextField();
        JButton calcularDescuentoCantidad = new JButton("Calcular");
        calcularDescuentoCantidad.addActionListener(e -> calcularDescuentoPorCantidad());
        discountQuantityPanel.add(new JLabel("Precio Unitario:"));
        discountQuantityPanel.add(precioUnitarioField);
        discountQuantityPanel.add(new JLabel("Cantidad:"));
        discountQuantityPanel.add(cantidadField);
        discountQuantityPanel.add(calcularDescuentoCantidad);
        tabbedPane.addTab("Descuento por Cantidad", discountQuantityPanel);

        // Conversión de Moneda
        JPanel currencyConversionPanel = new JPanel();
        currencyConversionPanel.setLayout(new GridLayout(2, 2));
        JTextField arsField = new JTextField();
        JButton calcularConversion = new JButton("Calcular");
        calcularConversion.addActionListener(e -> conversionMoneda());
        currencyConversionPanel.add(new JLabel("ARS:"));
        currencyConversionPanel.add(arsField);
        currencyConversionPanel.add(calcularConversion);
        tabbedPane.addTab("Conversión de Moneda", currencyConversionPanel);

        add(tabbedPane);
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
            FinancialCalculator app = new FinancialCalculator();
            app.setVisible(true);
        });
    }
}
