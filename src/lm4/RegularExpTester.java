/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lm4;

/**
 *
 * @author Matt
 */
public class RegularExpTester {
    private String pattern;

    private RegularExpTester() {
    }
    
    public void setPattern(String txt){
        this.pattern = txt;
    }
    
    public static RegularExpTester getInstance(String pattern){
        RegularExpTester obj = new RegularExpTester();
        obj.setPattern(pattern);
        return obj;
    }
    
    public boolean test(String txt){
        return txt.matches(pattern);
    }
}
