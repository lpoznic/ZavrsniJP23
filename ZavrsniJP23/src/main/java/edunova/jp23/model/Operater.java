/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.jp23.model;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Pozna
 */
@Entity
public class Operater extends Osoba{
    
    @NotNull(message = "lozinka ne prazna")
    @NotEmpty(message = "lozinka ne prazna")
    private String lozinka;
    private String iban;

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }
    
    @Override
    public String toString() {
        if(getIme() == null || getIme().isEmpty()){
            return "[Ime nije definirano]";
        }
        if(getPrezime() == null || getPrezime().isEmpty()){
            return "[Prezime nije definirano]";
        }
        return getIme() + " " + getPrezime();
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }
    
    public String getImePrezime(){
        return getIme() + " " + getPrezime();
    }
    
}
