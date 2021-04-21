/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.jp23.controller;

import edunova.jp23.model.Kupac;
import edunova.jp23.util.EdunovaException;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Pozna
 */
public class ObradaKupac extends Obrada<Kupac>{

    
    
    public ObradaKupac(){
        super();
    }
    
    public ObradaKupac(Kupac k){
        super(k);
    }

    @Override
    public List<Kupac> getPodaci() {
       return session.createQuery("from Kupac k"
               + " order by k.prezime, k.ime").list();
    }
    
    public List<Kupac> getPodaci(String uvjet) {
        return session.createQuery("from Kupac k "
                + " where concat(k.prezime) "
                + " like :uvjet order by k.prezime, k.ime")
                .setParameter("uvjet", "%" + uvjet + "%")
                
                .setMaxResults(20)
                .list();
    }
    @Override
    protected void kontrolaCreate() throws EdunovaException {
        
    }

    @Override
    protected void kontrolaUpdate() throws EdunovaException {
        
    }

    @Override
    protected void kontrolaDelete() throws EdunovaException {
        
    }
    
    
    
    
    
}
