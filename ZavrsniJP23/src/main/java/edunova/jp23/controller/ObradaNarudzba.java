/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.jp23.controller;

import edunova.jp23.model.Artikl;
import edunova.jp23.model.Stavka;
import edunova.jp23.model.Narudzba;
import edunova.jp23.util.EdunovaException;
import edunova.jp23.view.Aplikacija;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.hibernate.CacheMode;

/**
 *
 * @author Pozna
 */
public class ObradaNarudzba extends Obrada<Narudzba>{

    @Override
    public List<Narudzba> getPodaci() {
        List<Narudzba> lista =session.createQuery("from Narudzba n"
                + " order by n.id").list();
        session.setCacheMode(CacheMode.IGNORE);
        return lista;
    }
    //public List<Artikl> getArtikli(){
      //  return session.createQuery("from Narudzba.Artikl").list();
    //}
    
    
    @Override
    public Narudzba create() throws EdunovaException {
        
        session.beginTransaction();
        for (Stavka c : entitet.getArtikli()) {
            session.save(c);
        }
        kontrolaCreate();
        super.kontrola();
        session.save(entitet);
        session.getTransaction().commit();
        return entitet;
    }
    
    
    
    @Override
    protected void kontrolaCreate() throws EdunovaException {
        
    }

    @Override
    protected void kontrolaUpdate() throws EdunovaException {
        kontrolaCreate();
    }

    @Override
    protected void kontrolaDelete() throws EdunovaException {
        
    }
    
    private void kontrolaCijena() throws EdunovaException{
        System.out.println(entitet.getUkupnaCijena());
        if(entitet.getUkupnaCijena().compareTo(BigDecimal.ZERO)==0 || entitet.getUkupnaCijena()==null){
            throw new EdunovaException("Cijena ne smije biti nula");
        }
        if (entitet.getUkupnaCijena().compareTo(BigDecimal.ZERO) < 0){
            throw new EdunovaException("Cijena mora biti veća od nule");
        }
        
    }
    
    
}
