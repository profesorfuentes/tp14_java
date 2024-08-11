package ar.edu.et7.tabs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class CurrencyConversionTab extends TabPanel {
    private JComboBox<String> sourceCurrency;
    private JTextField sourceAmount;
    private JComboBox<String> targetCurrency;
    private JTextField targetAmount;
    private JButton calcularButton;

    private Map<String, Float> exchangeRates;

    public CurrencyConversionTab() {
        sourceCurrency = new JComboBox<>(new String[]{"ARS", "USD", "BITCOIN"});
        sourceAmount = new JTextField(10);
        targetCurrency = new JComboBox<>(new String[]{"ARS", "USD", "BITCOIN"});
        targetAmount = new JTextField(10);
        calcularButton = new JButton("Calcular");

        // TODO Cargar las tasas de cambio
        exchangeRates = new HashMap<>();
        exchangeRates.put("ARS_TO_USD", 1.0f/900.0f);
        exchangeRates.put("USD_TO_ARS", 900.0f);
        exchangeRates.put("ARS_TO_BITCOIN", 0.00000025f);
        exchangeRates.put("BITCOIN_TO_ARS", 4000000f);
        exchangeRates.put("USD_TO_BITCOIN", 0.000025f);
        exchangeRates.put("BITCOIN_TO_USD", 40000f);
        createPanel();
    }

    @Override
    public JPanel createPanel() {
        panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(sourceCurrency, gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.NONE;
        panel.add(sourceAmount, gbc);

        gbc.gridx = 2;
        gbc.fill = GridBagConstraints.NONE;
        panel.add(new JLabel("->"), gbc);

        gbc.gridx = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(targetCurrency, gbc);

        gbc.gridx = 4;
        gbc.fill = GridBagConstraints.NONE;
        panel.add(targetAmount, gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        calcularButton.addActionListener(this::calcularConversion);
        panel.add(calcularButton, gbc);

        return panel;
    }

    private void calcularConversion(ActionEvent e) {
        try {
            float amount = Float.parseFloat(sourceAmount.getText());
            String source = sourceCurrency.getSelectedItem().toString();
            String target = targetCurrency.getSelectedItem().toString();
            float conversionRate = getConversionRate(source, target);
            float result = amount * conversionRate;
            targetAmount.setText(String.format("%.2f", result));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private float getConversionRate(String source, String target) {
        if (source.equals(target)) {
            return 1.0f;
        }
        String key = source + "_TO_" + target;
        return exchangeRates.getOrDefault(key, 1.0f);
    }
}
