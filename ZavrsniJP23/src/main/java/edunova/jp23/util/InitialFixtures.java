/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.jp23.util;

import edunova.jp23.model.Artikl;
import edunova.jp23.model.Dobavljac;
import edunova.jp23.model.Kupac;
import java.math.BigDecimal;
import org.hibernate.Session;

/**
 *
 * @author Pozna
 */
public class InitialFixtures {
    
    public static void main(String[] args) {
        Start();
    }
    public static void Start(){
        
        Session s = HibernateUtil.getSession();
        s.beginTransaction();
        
        Kupac kupac = new Kupac();
        kupac.setIme("Zoran");
        kupac.setPrezime("Maričić");
        kupac.setEmail("zmaricic@gmail.com");
        kupac.setAdresa("Strossmayerova 26");
        kupac.setKontakt("0957822635");
        kupac.setOib("72366372948");
        s.save(kupac);
        
        Dobavljac dobavljac = new Dobavljac();
        dobavljac.setAdresa("Strossmayerova 24");
        dobavljac.setImeVlasnika("Kota");
        dobavljac.setNaziv("Mro Bobento");
        s.save(dobavljac);
        
        Artikl artikl = new Artikl();
        artikl.setCijena(BigDecimal.TEN);
        artikl.setDobavljac(dobavljac);
        artikl.setNaziv("Cigla");
        artikl.setOpis("Cigla");
        s.save(artikl);
        
        
        
        s.getTransaction().commit();
        
        
    
    }
}
