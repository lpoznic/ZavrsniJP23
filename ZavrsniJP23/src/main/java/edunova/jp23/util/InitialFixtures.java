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
import java.util.ArrayList;
import java.util.List;
import com.github.javafaker.Faker;
import java.net.URL;
import java.util.Scanner;
import org.jsoup.nodes.Document;
import org.hibernate.Session;
import org.jsoup.Jsoup;
import us.codecraft.xsoup.Xsoup;

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
        Faker faker = new Faker();
        List<Kupac> kupci=new ArrayList<>();
        
        Kupac k;
        for(int i=0;i<30;i++){
            k= new Kupac();
            k.setIme(faker.name().firstName());
            k.setPrezime(faker.name().lastName());
            k.setEmail("generic@email.npc");
            k.setOib(getOIB());
            s.save(k);
            kupci.add(k);
        }
        
        
        s.getTransaction().commit();
        
        
    
    }
    
    public static String getOIB(){
        //http://oib.itcentrala.com/oib-generator/
        try {
            String html = new Scanner(
                    new URL("http://oib.itcentrala.com/oib-generator/")
                            .openStream(),"UTF-8").useDelimiter("\\A").next();
            //System.out.println(html);
            
            Document d = Jsoup.parse(html);
            //
            return Xsoup.compile("/html/body/div[1]/div[1]/text()")
                    .evaluate(d).get();
        } catch (Exception e) {
            return null;
        }
        
    }
}
