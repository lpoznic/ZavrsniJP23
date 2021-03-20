/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.jp23.start;

import edunova.jp23.model.Kupac;
import edunova.jp23.util.HibernateUtil;
import java.math.BigDecimal;
import java.util.Date;
import org.hibernate.Session;

/**
 *
 * @author Pozna
 */
public class Start {
    
    public static void main(String[] args) {
        
       Session s = HibernateUtil.getSession();
        s.beginTransaction();
        
        Kupac kupac = new Kupac();
        kupac.setAdresa("JJ Strossmayera 149");
        kupac.setEmail("lpoznic@outlook.com");
        kupac.setIme("Luka");
        kupac.setPrezime("Pzn");
        kupac.setKontakt("91743681");
        
        
        s.save(kupac);

        s.getTransaction().commit();
        
    }
    
}
