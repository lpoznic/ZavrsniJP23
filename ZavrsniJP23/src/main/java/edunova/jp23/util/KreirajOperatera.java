/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.jp23.util;

import edunova.jp23.controller.ObradaOperater;
import edunova.jp23.model.Operater;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Pozna
 */
public class KreirajOperatera {
    
    public static void main(String[] args) {
        
        Operater o = new Operater();
        o.setIme("Luka");
        o.setPrezime("Poznić");
        o.setEmail("lpoznic@outlook.com");
        o.setLozinka(BCrypt.hashpw("edunova", BCrypt.gensalt()));
        o.setOib("40654655739");
        
        
        ObradaOperater oo = new ObradaOperater();
        oo.setEntitet(o);
        
        try {
            oo.create();
        } catch (EdunovaException e) {
            System.out.println(e.getMessage());
        }
        
    }
    
}
