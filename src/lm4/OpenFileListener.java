/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lm4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

/**
 *
 * @author Matt
 */
public class OpenFileListener implements ActionListener {

    JFrame jframe;

    public OpenFileListener(JFrame jframe) {
        this.jframe = jframe;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser openfile = new JFileChooser();
        if (openfile.showOpenDialog(jframe) == JFileChooser.APPROVE_OPTION) {
            File file = openfile.getSelectedFile();
            try {
                FileReader fr = new FileReader(file);
                BufferedReader bfr = new BufferedReader(fr);
                int letter = 0;
                String linia;
                try {
                    while ((linia = bfr.readLine()) != null) {
                        LM4.content +=linia+System.lineSeparator();
                    }
                } catch (IOException ee) {
                    System.out.println("BŁĄD ODCZYTU Z PLIKU!");
                    System.exit(2);
                }
                
                LM4.launch();
            } catch (IOException ex) {
                Logger.getLogger(OpenFileListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
