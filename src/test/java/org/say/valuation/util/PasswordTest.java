package org.say.valuation.util;

import org.apache.shiro.authc.credential.DefaultPasswordService;
import org.apache.shiro.authc.credential.PasswordService;
import org.apache.shiro.crypto.hash.Sha256Hash;

/**
 * Created by say on 9/4/16.
 */
public class PasswordTest {

    public static void main(String[] args) {
        String password = "admin";
        String m = new Sha256Hash(password).toString();
        System.out.println(m);


        PasswordService svc = new DefaultPasswordService();
        String encrypted = svc.encryptPassword(password);
        System.out.println(encrypted);
    }
}
