package ar.edu.et7.tabs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CftTab extends TabPanel {
    private JTextField tnaField;
    private JTextField associatedExpensesField;
    private JTextArea resultArea;
    
    public CftTab() {
     tnaField = new JTextField(10);
     associatedExpensesField = new JTextField(10);
     resultArea = new JTextArea(5, 20);
        createPanel();
    }    
    
    @Override
    public JPanel createPanel() {
        panel = new JPanel(new GridBagLayout());
        addInputFields(panel, tnaField, associatedExpensesField, this::calcular, resultArea);
        return panel;
    }
    
    private void calcular(ActionEvent e) {
        float resultado = 0;
        
        //TODO declarar una variable para cada campo
        float tna = 0;
        float gastosAsociados = 0;

        try {
            //TODO asignar el valor de cada campo a una variable
            tna = Float.parseFloat(tnaField.getText());
            gastosAsociados = Float.parseFloat(associatedExpensesField.getText());
            
        } catch (NumberFormatException ex) {
            resultArea.setText("Error en la entrada: " + ex.getMessage());
            return;
        }

        //TODO calcular el resultado
        // Supongamos que el cálculo del CFT (Costo Financiero Total) sigue la siguiente fórmula:
        // CFT = TNA + Gastos Asociados (Esto es solo un ejemplo simplificado)
        resultado = tna + gastosAsociados;
        
        resultArea.setText("Resultado: " + resultado);
    }

    private void addInputFields(JPanel panel, JTextField field1, JTextField field2, ActionListener action, JTextArea resultArea) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_END;

        if (field1 != null) {
            panel.add(new JLabel("TNA:"), gbc);
            gbc.gridx = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            panel.add(field1, gbc);
            gbc.gridx = 0;
            gbc.gridy++;
        }

        if (field2 != null) {
            panel.add(new JLabel("Gastos Asociados:"), gbc);
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

