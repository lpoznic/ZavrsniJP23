/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.jp23.controller;

import edunova.jp23.model.Artikl;
import edunova.jp23.util.EdunovaException;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Pozna
 */
public class ObradaArtikl extends Obrada<Artikl>{

    @Override
    public List<Artikl> getPodaci() {
        return session.createQuery("from Artikl").list();
    }

    @Override
    protected void kontrolaCreate() throws EdunovaException {
        kontrolaCijena();
        kontrolaNaziv();
    }

    @Override
    protected void kontrolaUpdate() throws EdunovaException {
        kontrolaCreate();
        
    }

    @Override
    protected void kontrolaDelete() throws EdunovaException {
        
    }

    private void kontrolaCijena() throws EdunovaException {
        if(entitet.getCijena()==null || entitet.getCijena().compareTo(BigDecimal.ZERO)==0){
            throw new EdunovaException("Cijena mora biti upisana");
        }
    }
    private void kontrolaNaziv() throws EdunovaException{
        if(entitet.getNaziv()==null || entitet.getNaziv().isEmpty()){
            throw new EdunovaException("Naziv ne smije ostati prazan");
        }
        if(entitet.getNaziv().length()>50){
            throw new EdunovaException("Naziv ne smije biti duži od 50");
        }
    }
    
}
