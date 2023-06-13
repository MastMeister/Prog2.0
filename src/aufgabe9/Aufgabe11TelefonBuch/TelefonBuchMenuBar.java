// O. Bittel
// 10.03.2017

package aufgabe9.Aufgabe11TelefonBuch;

import javax.swing.*;
import java.io.*;
import java.awt.event.*;


public class TelefonBuchMenuBar
        extends JMenuBar implements ActionListener {

    private TelefonBuch telBuch;

    private JMenuItem lesen;
    private JMenuItem speichern;
    private JMenuItem beenden;

    public TelefonBuchMenuBar(TelefonBuch tb) {
        telBuch = tb;

        JMenu datei = new JMenu("Datei");

        lesen = new JMenuItem("TelefonBuch Lesen ...");
        speichern = new JMenuItem("TelefonBuch Speichern ...");
        beenden = new JMenuItem("TelefonBuch Beenden");

        datei.add(lesen);
        datei.add(speichern);
        datei.addSeparator();
        datei.add(beenden);

        this.add(datei);

        lesen.addActionListener(this);
        speichern.addActionListener(this);
        beenden.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        try {
            if (source == this.beenden) {
                int res = JOptionPane.showConfirmDialog(null, "Telefonbuch Beenden?" +
                "\nGeänderte Daten werden nicht gespeichert!", "Beenden", JOptionPane.YES_NO_OPTION);

                if (res == JOptionPane.YES_OPTION) {
                    System.exit(0);
                } else {
                    return;
                }
            } else if (source == this.lesen) {
                JFileChooser fc = new JFileChooser();
                int res = fc.showOpenDialog(null);
                if (res == JFileChooser.APPROVE_OPTION) {
                    File f = fc.getSelectedFile();
                    telBuch.read(f);
                }
            } else if (source == this.speichern) {
                JFileChooser fc = new JFileChooser();
                int res = fc.showSaveDialog(null);
                if (res == JFileChooser.APPROVE_OPTION) {
                    File f = fc.getSelectedFile();
                    telBuch.save(f);
                }
            }


        } catch (Exception ex) {
            // TODO: handle exception
        }
    }
}

