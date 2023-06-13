// O. Bittel
// 10.03.2017

package aufgabe9.Aufgabe11TelefonBuch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;

public class TelefonBuchSuchenLoeschenPanel
        extends JPanel implements ActionListener {

    private TelefonBuch telBuch;
    private JTextField tfSucheName;
    private JTextField tfSucheZusatz;
    private JComboBox<String> suchOptionenBox;
    private JButton buttonSuche;
    public JTextArea ausgabeText;

    public TelefonBuchSuchenLoeschenPanel(TelefonBuch tb) {
        telBuch = tb;

        JPanel info = new JPanel();
        info.setLayout(new GridLayout(2, 1));
        Border border = BorderFactory.createEmptyBorder(5,5,5,5);
        info.setBorder(border);
        info.add(new JLabel("Name"));
        info.add(new JLabel("Zusatz"));

        JPanel text = new JPanel();
        text.setLayout(new GridLayout(2, 1));
        text.setBorder(border);
        text.add(tfSucheName = new JTextField("", 20));
        text.add(tfSucheZusatz = new JTextField("", 20));
        

        JPanel suchen = new JPanel();
        // suchen.setLayout(new BoxLayout(suchen, BoxLayout.X_AXIS));
        Border borderSuchen = BorderFactory.createTitledBorder("Suchen/Löschen");
        suchen.setBorder(borderSuchen);
        suchen.add(info);
        suchen.add(text);

        String[] suchOptionen = {"Exakte Suche", "Präfix-Suche", "Löschen"};
        suchOptionenBox = new JComboBox<String>(suchOptionen);
        suchOptionenBox.setSelectedIndex(1);
        suchOptionenBox.addActionListener(this);
        suchen.add(suchOptionenBox);

        buttonSuche = new JButton("Anwenden");
        buttonSuche.addActionListener(this);
        suchen.add(buttonSuche);

        JPanel ausgabe = new JPanel();
        Border borderAusgabe = BorderFactory.createTitledBorder("Ausgabe");
        ausgabe.setBorder(borderAusgabe);
        ausgabe.setLayout(new GridLayout(1, 1));
        
        ausgabeText = new JTextArea(10, 30);
        ausgabeText.setEditable(false);
        ausgabe.add(new JScrollPane(this.ausgabeText));

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.add(suchen);
        this.add(ausgabe);

    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == buttonSuche) {

            String name = tfSucheName.getText();
            String zusatz = tfSucheZusatz.getText();

            if (name.length() > 0) {

                if (suchOptionenBox.getSelectedIndex() == 0) {
                    String s = telBuch.exactSearch(name, zusatz);
                    if (s != null) {
                        ausgabeText.setText(s);
                    } else {
                        JOptionPane.showMessageDialog(null, "Kein Eintrag gefunden");
                    }
                } 

                if (suchOptionenBox.getSelectedIndex() == 1) {
                List<String> list = telBuch.prefixSearch(name);
                if (list != null) {
                    ausgabeText.setText("");
                    for (String s : list) {
                        ausgabeText.append(s + "\n");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Kein Eintrag gefunden");
                }
                }
                
                if (suchOptionenBox.getSelectedIndex() == 2) {
                    boolean remove = telBuch.remove(name, zusatz);
                    if (remove) {
                        JOptionPane.showMessageDialog(null, "Eintrag gelöscht");
                    } else {
                        JOptionPane.showMessageDialog(null, "Kein Eintrag gefunden");
                    }
                }
            }
        }
    }
}
