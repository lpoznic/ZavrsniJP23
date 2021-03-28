/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.jp23.controller;

import edunova.jp23.model.Artikl;
import edunova.jp23.model.Narudzba;
import edunova.jp23.util.EdunovaException;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Pozna
 */
public class ObradaNarudzba extends Obrada<Narudzba>{

    @Override
    public List<Narudzba> getPodaci() {
        return session.createQuery("from Narudzba").list();
    }
    public List<Artikl> getArtikli(){
        return session.createQuery("from Narudzba.Artikl").list();
    }
    
    @Override
    protected void kontrolaCreate() throws EdunovaException {
        kontrolaCijena();
    }

    @Override
    protected void kontrolaUpdate() throws EdunovaException {
        kontrolaCreate();
    }

    @Override
    protected void kontrolaDelete() throws EdunovaException {
        
    }
    
    private void kontrolaCijena() throws EdunovaException{
        if(entitet.getUkupnaCijena().compareTo(BigDecimal.ZERO)==0 || entitet.getUkupnaCijena()==null){
            throw new EdunovaException("Cijena ne smije biti nula");
        }
        if (entitet.getUkupnaCijena().compareTo(BigDecimal.ZERO) < 0){
            throw new EdunovaException("Cijena mora biti veća od nule");
        }
    }
    
    
}
