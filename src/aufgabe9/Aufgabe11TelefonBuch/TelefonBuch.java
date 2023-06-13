// O. Bittel
// 10.03.2017

package aufgabe9.Aufgabe11TelefonBuch;

import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;


public class TelefonBuch {

    private TreeMap<String,String> telBuch = new TreeMap<String,String>();

    public boolean insert(String name, String zusatz, String telNr) {

        if(telBuch.containsKey(name + zusatz)) {

            JOptionPane optionPane = new JOptionPane();
            optionPane.showMessageDialog(null, "Eintrag bereits vorhanden", "Fehler", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {        
        
        telBuch.put(name + " " + zusatz, telNr);

        return true; // damit IDE kein Systaxfehler anzeigt
        }
    }

    public boolean remove(String name, String zusatz) {
        if (telBuch.containsKey(name + " " + zusatz)) {
            telBuch.remove(name + " " + zusatz);
            return true;
        } else {
            return false;
        }
    }

    public String exactSearch(String name, String zusatz) {
        
        String s;
        if (telBuch.containsKey(name + " " + zusatz)) {
            s = telBuch.get(name + " " + zusatz);
            return s;
        } else {
            return null;
        }
    }

    public List<String> prefixSearch(String s) {
        SortedMap<String,String> subMap = telBuch.tailMap(s);
        List<String> list = new LinkedList<>();

        if (s.length() != 1 || !s.matches("[A-Z]+")) {
            JOptionPane.showMessageDialog(null, "Bitte 1 Groß-Buchstabe eingeben", "Fehler", JOptionPane.ERROR_MESSAGE);
            return list;
        }
    // '        s = s1.toUpperCase();'

        for (Entry<String, String> eintrag : subMap.entrySet()) {
            String nameZusatz = eintrag.getKey();
            if (nameZusatz.startsWith(s.toUpperCase()) || nameZusatz.startsWith(s.toLowerCase())) {
                String[] parts = nameZusatz.split(" ");
                String name = parts[0];
                String zusatz = "";
                try {
                    zusatz = parts[1];
                } catch (ArrayIndexOutOfBoundsException ex) {
                }

                list.add(name + " " + zusatz + " " +eintrag.getValue());
            } else {
                break;
            }
        }

        return list; // damit IDE kein Systaxfehler anzeigt
    }

    public void read(File f) {
        LineNumberReader in = null;
        try {
            telBuch.clear();
            in = new LineNumberReader(new FileReader(f));
            String line;
            while ((line = in.readLine()) != null) {
                String[] sf = line.split(" ");
                if (sf.length == 2) {
                    insert(sf[0], "", sf[1]); // leerer Zusatz
                } else if (sf.length == 3) {
                    insert(sf[0], sf[1], sf[2]);
                }
            }
            in.close();
        } catch (IOException ex) {
            Logger.getLogger(TelefonBuch.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void save(File f) {
        PrintWriter out = null;
        try {
            out = new PrintWriter(f);
            for (Entry<String, String> eintrag : telBuch.entrySet()) {
                String s = eintrag.getKey().replace('#', ' ') + " " + eintrag.getValue();
                out.println(s);
            }
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(TelefonBuch.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void print(List<String> strList) {
        for (String s : strList)
            System.out.println(s);
    }

    public static void main(String[] args)
            throws FileNotFoundException, IOException {
        
        TelefonBuch telBuch = new TelefonBuch();
        telBuch.read(new File("TelBuchMit420Namen.txt"));

        System.out.println(telBuch.exactSearch("Oliver",""));
        System.out.println();

        print(telBuch.prefixSearch("H"));
        System.out.println();
        
        print(telBuch.prefixSearch(""));
        System.out.println();

        telBuch.insert("Oliver","1","33245");
        telBuch.insert("Oliver","2","23423");
        telBuch.insert("Oliver","3","87655");
        telBuch.remove("Oliver","2");

        print(telBuch.prefixSearch("Ol"));
        System.out.println();
       
        telBuch.save(new File("test.txt"));
    }
}

