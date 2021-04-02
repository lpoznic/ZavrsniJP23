/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.jp23.model;

import edunova.jp23.view.Aplikacija;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.swing.JOptionPane;

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
    private long brojRacuna = getId();

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

    public long getBrojRacuna() {
        return brojRacuna;
    }

    public void setBrojRacuna(long brojRacuna) {
        this.brojRacuna = brojRacuna;
    }

    public BigDecimal getUkupnaCijena() {
        return ukupnaCijena;
    }

    public void setUkupnaCijena(BigDecimal ukupnaCijena) {
        this.ukupnaCijena = ukupnaCijena;
    }
    private BigDecimal ukupnaCijena;
    
    
    @OneToMany(mappedBy = "Artikli")
    private List<Clan> artikli = new ArrayList<>();

    public List<Clan> getArtikli() {
        return artikli;
    }

    public void setPolaznici(List<Clan> artikli) {
        this.artikli = artikli;
    }
    
    @Override
    public String toString() {
        
        Date d = new Date();
        SimpleDateFormat df = new SimpleDateFormat("dd. MMMM YYYY. HH:mm:ss");
        if(d == null || d.toString().isEmpty()){
            return "[Datum nije definiran]";
        }
        return df.format(d) + " " + getId();
    }
    
}
