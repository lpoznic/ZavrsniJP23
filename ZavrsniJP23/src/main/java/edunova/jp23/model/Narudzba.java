/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.jp23.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Pozna
 */
@Entity
public class Narudzba extends Entitet{
    
    private Date datum;
    @OneToOne
    private Zaposlenik zaposlenik;
    @OneToOne
    private Kupac kupac;
    private int brojRacuna;
    @ManyToMany
    private List<Artikl> artikli;

    public List<Artikl> getArtikli() {
        return artikli;
    }

    public void setArtikli(List<Artikl> artikli) {
        this.artikli = artikli;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Zaposlenik getZaposlenik() {
        return zaposlenik;
    }

    public void setZaposlenik(Zaposlenik zaposlenik) {
        this.zaposlenik = zaposlenik;
    }

    public Kupac getKupac() {
        return kupac;
    }

    public void setKupac(Kupac kupac) {
        this.kupac = kupac;
    }

    public int getBrojRacuna() {
        return brojRacuna;
    }

    public void setBrojRacuna(int brojRacuna) {
        this.brojRacuna = brojRacuna;
    }

    public BigDecimal getUkupnaCijena() {
        return ukupnaCijena;
    }

    public void setUkupnaCijena(BigDecimal ukupnaCijena) {
        this.ukupnaCijena = ukupnaCijena;
    }
    private BigDecimal ukupnaCijena;
    
}