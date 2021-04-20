/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.jp23.model;

import javax.persistence.Entity;

/**
 *
 * @author Pozna
 */
@Entity
public class Kupac extends Osoba{
    
    private String kontakt;
    private String adresa;

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getKontakt() {
        return kontakt;
    }

    public void setKontakt(String kontakt) {
        this.kontakt = kontakt;
    }

    @Override
    public String toString() {
        if(getIme() == null || getIme().isEmpty()){
            return "[Ime nije definirano]";
        }
        if(getPrezime() == null || getPrezime().isEmpty()){
            return "[Prezime nije definirano]";
        }
        if(getPrezime() == null && getIme().isEmpty()){
            return null;
        }
        return getIme() + " " + getPrezime();
    }
    
    
    
    
}
