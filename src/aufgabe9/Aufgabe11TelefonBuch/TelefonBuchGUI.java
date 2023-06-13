// O. Bittel
// 10.03.2017

package aufgabe9.Aufgabe11TelefonBuch;

import java.awt.Color;
import java.util.concurrent.Flow;

import javax.swing.*;
import javax.swing.border.Border;

public class TelefonBuchGUI extends JFrame {

    private TelefonBuch telBuch;

    public TelefonBuchGUI() {
        // TelefonBuch anlegen:
        telBuch = new TelefonBuch();

        TelefonBuchMenuBar menuBar = new TelefonBuchMenuBar(telBuch);
        this.setJMenuBar(menuBar);


        // mainPanel mit Umrandung versehen und das
        // Einfuegen- und  SuchenLoeschenPanel einbauen:
        JPanel mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        
        TelefonBuchEinfuegenPanel einfuegenPanel = new TelefonBuchEinfuegenPanel(telBuch);
        TelefonBuchSuchenLoeschenPanel suchenLoeschenPanel = new TelefonBuchSuchenLoeschenPanel(telBuch);

        mainPanel.add(einfuegenPanel);
        mainPanel.add(suchenLoeschenPanel);

        this.setContentPane(mainPanel);

        // Sonstige Eigenschaften des Hauptfenster setzen:
        this.setTitle("Telefonbuch");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new TelefonBuchGUI();
    }
}
