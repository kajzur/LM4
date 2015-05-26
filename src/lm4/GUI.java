/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lm4;

import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

/**
 *
 * @author Matt
 */
public class GUI extends JFrame{

    private JTextArea jta = new JTextArea();
    JMenuBar menuBar;
    JMenuItem menuItem;
    JMenu menu, submenu;
    public GUI() throws HeadlessException {
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        GridLayout gb = new GridLayout(1, 1);
        JPanel main = new JPanel(gb);
        menuBar = new JMenuBar();
        menu = new JMenu("Plik");
        menu.setMnemonic(KeyEvent.VK_A);
        menuBar.add(menu);
        menuItem = new JMenuItem("Otwórz",
                         KeyEvent.VK_T);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_O, ActionEvent.ALT_MASK));
        menuItem.addActionListener(new OpenFileListener(this));
        menu.add(menuItem);
        this.setJMenuBar(menuBar);
        jta.setEditable(false);
        JScrollPane sp = new JScrollPane(jta);
        main.add(sp);
        this.add(main);
    }
    
    public void addText(String txt){
        jta.setText(jta.getText()+txt+"\n");
    }
    
}

