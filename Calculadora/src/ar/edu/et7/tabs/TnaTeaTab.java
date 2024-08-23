package ar.edu.et7.tabs;

import javax.swing.*;

import ar.edu.et7.business.Calculos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TnaTeaTab extends TabPanel {
    private JTextField tnaField;
    private JTextField teaField;
    private JTextArea resultArea;
    private JPanel panel;

    public TnaTeaTab() {
        tnaField = new JTextField(10);
        teaField = new JTextField(10);
        teaField.setEditable(true); // El campo TEA debe ser solo lectura
        resultArea = new JTextArea(5, 20);
        resultArea.setEditable(false);
        createPanel();
    }

    @Override
    public JPanel createPanel() {
        panel = new JPanel(new GridBagLayout());
        addInputFields(panel, tnaField, teaField, this::calcular, resultArea);
        return panel;
    }

    public JPanel getPane() {
        return panel;
    }

    private void calcular(ActionEvent e) {
    	Calculos c;
    	c = new Calculos();
    	
        try {
            float tna = Float.parseFloat(tnaField.getText());
            int capitalizacionPorAnio = 12; // Asumiendo capitalización mensual
            float tea = c.tnaTea(tna, capitalizacionPorAnio);
            teaField.setText(String.format("%.2f%%", tea)); // Mostrar el TEA calculado en el campo correspondiente
            resultArea.setText(String.format("La Tasa Efectiva Anual (TEA) es: %.2f%%", tea));
        } catch (NumberFormatException ex) {
            resultArea.setText("Por favor, ingrese un valor numérico válido para TNA.");
        }
       
    }

    private void addInputFields(JPanel panel, JTextField tnaField, JTextField teaField, ActionListener action, JTextArea resultArea) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_END;

        // Campo para TNA
        panel.add(new JLabel("TNA (%):"), gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(tnaField, gbc);
        gbc.gridx = 0;
        gbc.gridy++;

        // Campo para TEA
        panel.add(new JLabel("TEA (%):"), gbc);
        gbc.gridx = 1;
        panel.add(teaField, gbc);
        gbc.gridx = 0;
        gbc.gridy++;

        // Botón Calcular
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        JButton calcularButton = new JButton("Calcular");
        calcularButton.addActionListener(action);
        panel.add(calcularButton, gbc);

        // Área de Resultados
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        JScrollPane scrollPane = new JScrollPane(resultArea);
        panel.add(scrollPane, gbc);
    }

}