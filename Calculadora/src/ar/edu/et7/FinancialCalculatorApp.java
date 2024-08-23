package ar.edu.et7;

import javax.swing.*;

import ar.edu.et7.tabs.CftTab;
import ar.edu.et7.tabs.CurrencyConversionTab;
import ar.edu.et7.tabs.DiscountQuantityTab;
import ar.edu.et7.tabs.DiscountTab;
import ar.edu.et7.tabs.FrenchSystemTab;
import ar.edu.et7.tabs.GermanSystemTab;
import ar.edu.et7.tabs.TnaTeaTab;

public class FinancialCalculatorApp extends JFrame {

	GermanSystemTab germanSystemTab;
	FrenchSystemTab frenchSystemTab;
	TnaTeaTab tnaTeaTab;
	CftTab cftTab;

	CurrencyConversionTab currencyConversionTab;
	DiscountQuantityTab discountQuantityTab;
	DiscountTab discountTab;

	public FinancialCalculatorApp() {
        setTitle("Financial Calculator");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTabbedPane tabbedPane = new JTabbedPane();

        // Sistema Alemán
        germanSystemTab = new GermanSystemTab();
        tabbedPane.addTab("Sistema Alemán", germanSystemTab.getPane());

        // Sistema Francés
        frenchSystemTab = new FrenchSystemTab();
        tabbedPane.addTab("Sistema Francés", frenchSystemTab.getPane());

        // TNA y TEA
        tnaTeaTab = new TnaTeaTab();
        tabbedPane.addTab("TNA TEA", tnaTeaTab.getPane()); 

        // CFT
        cftTab = new CftTab();
        tabbedPane.addTab("CFT", cftTab.getPane());

        // Descuento
        discountTab = new DiscountTab();
        tabbedPane.addTab("Descuento", discountTab.getPane());

        // Descuento por cantidad
        discountQuantityTab = new DiscountQuantityTab();
        tabbedPane.addTab("Descuento por cantidad", discountQuantityTab.getPane());

        // Conversión de Moneda
        currencyConversionTab = new CurrencyConversionTab();
        tabbedPane.addTab("Conversion de Monedas", currencyConversionTab.getPane());

        add(tabbedPane);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FinancialCalculatorApp app = new FinancialCalculatorApp();
            app.setVisible(true);
        });
    }
}
