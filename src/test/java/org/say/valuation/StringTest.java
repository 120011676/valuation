package org.say.valuation;

/**
 * Created by say on 01/12/2016.
 */
public class StringTest {
    public static void main(String[] args) {
        String a = "01" + new String(new char[]{27}) + "23456";
        int in = a.indexOf(27);
        System.out.println(a.substring(in+1));
        System.out.println(a.substring(0, in));
    }
}
