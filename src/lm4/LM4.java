/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lm4;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Matt
 */
public class LM4 {

    /**
     * @param args the command line arguments
     */
    public static String content = "";
    public static HashMap<String, RegularExpTester> testers = new HashMap<String, RegularExpTester>();
    public static GUI gui;
    public static void main(String[] args) {
        gui = new GUI();
        gui.setVisible(true);
    }

    static void launch() {
        
        testers.put("IPv4 +  subnetmask", RegularExpTester.getInstance("((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?) ((128|192|224|240|248|252|254|255)0\\.0\\.0|255\\.(0|128|192|224|240|248|252|254|255)\\.0\\.0|255\\.255\\.(0|128|192|224|240|248|252|254|255)\\.0|255\\.255\\.255\\.(0|128|192|224|240|248|252|254|255))"));        
        testers.put("Mail", RegularExpTester.getInstance("[a-zA-Z0-9](\\w|.|-){2,}@(\\w){2,}\\.(\\w){2,26}"));
        testers.put("Int additions", RegularExpTester.getInstance("((-)?[0-9]+\\+)+(-)?[0-9]+"));
        testers.put("Complex numbers addditions", RegularExpTester.getInstance("([0-9]*(\\+|-)?[0-9]+i \\+ )+[0-9]*(\\+|-)?[0-9]+i"));
        testers.put("Formatting text", RegularExpTester.getInstance("^<span style=\"(((text-align):(center|right|justify))|((text-decoration):(overline|line-through|underline))|((text-transform))(uppercase|lowercase|capitalize))\">(.*)</span>$"));
        testers.put("Table:", RegularExpTester.getInstance("^<table>(<tr>(<th>(.*)</th>)+</tr>)?(<tr>(<td>.*</td>)</tr>)*</table>$"));

        String[] lines = content.split(System.lineSeparator());// content from file splited by newLine
        for(String testLine : lines){// for every line
            gui.addText("Test for: "+testLine); //print txt
            Set<String> keySet = testers.keySet(); 
            for(String testName : keySet){ //test..
                RegularExpTester tester = testers.get(testName); // all patterns
                boolean result = tester.test(testLine); //retrieve result
                gui.addText(testName + ": "+result); // print result
            }
            gui.addText("\n");
        }
        
        content = "";
    }
    
}
