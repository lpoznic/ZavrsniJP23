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
import edunova.jp23.model.Artikl;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
    private Operater operater;
    
    @ManyToOne
    private Kupac kupac;
    private long brojRacuna;
    private BigDecimal ukupnaCijena;

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Operater getOperater() {
        return operater;
    }

    public void setOperater(Operater operater) {
        this.operater = operater;
    }

    public Kupac getKupac() {
        return kupac;
    }

    public void setKupac(Kupac kupac) {
        this.kupac = kupac;
    }

    public long getBrojRacuna() {
        return getId();
    }

    public BigDecimal getUkupnaCijena() {
        return ukupnaCijena;
    }

    public void setBrojRacuna(long brojRacuna) {
        this.brojRacuna = brojRacuna;
    }

    public void setUkupnaCijena(BigDecimal ukupnaCijena) {
       this.ukupnaCijena=ukupnaCijena;
    }
    
    
    @OneToMany(mappedBy = "narudzba")
    private List<Stavka> artikli = new ArrayList<>();

    public List<Stavka> getArtikli() {
        return artikli;
    }

    public void setArtikli(List<Stavka> artikli) {
        this.artikli = artikli;
    }
    
    @Override
    public String toString() {
        
        Date d = new Date();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        if(d == null || d.toString().isEmpty()){
            return "[Datum nije definiran]";
        }
        return "["+getId()+"], " +df.format(d)+ ", "+ getOperater().getImePrezime();
    }
    
    
   
    
    public String ukupnaCijenaToString(){
        
        if(getUkupnaCijena()!=null){
            return getUkupnaCijena().toString();
        }
        return "0";
        
    }
    
    
    
}
