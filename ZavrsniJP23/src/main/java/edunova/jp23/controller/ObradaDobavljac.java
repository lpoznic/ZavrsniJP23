/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.jp23.controller;

import edunova.jp23.model.Dobavljac;
import edunova.jp23.util.EdunovaException;
import java.util.List;
import javax.persistence.Entity;

/**
 *
 * @author Pozna
 */
public class ObradaDobavljac extends Obrada<Dobavljac>{

    public ObradaDobavljac(){
        super();
    }
    
    public ObradaDobavljac(Dobavljac d){
        super(d);
    }
    
    @Override
    public List<Dobavljac> getPodaci() {
        return session.createQuery("from Dobavljac d"
                + " order by d.naziv").list();
    }
    
     public List<Dobavljac> getPodaci(String uvjet) {
        return session.createQuery("from Dobavljac d "
                + " where concat(d.naziv) "
                + " like :uvjet order by d.naziv")
                .setParameter("uvjet", "%" + uvjet + "%")
                
                .setMaxResults(20)
                .list();
    }

    @Override
    protected void kontrolaCreate() throws EdunovaException {
        kontrolaNaziv();
    }

    @Override
    protected void kontrolaUpdate() throws EdunovaException {
        kontrolaCreate();
    }

    @Override
    protected void kontrolaDelete() throws EdunovaException {
        
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
