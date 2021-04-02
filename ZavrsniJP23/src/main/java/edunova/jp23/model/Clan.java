/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.jp23.model;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Pozna
 */
public class Clan extends Entitet{
    
    @ManyToOne
    private Artikl artikl;
    @ManyToOne
    private Narudzba narudzba;

    public Artikl getArtikl() {
        return artikl;
    }

    public void setArtikl(Artikl artikl) {
        this.artikl = artikl;
    }

    public Narudzba getNarudzba() {
        return narudzba;
    }

    public void setNarudzba(Narudzba narudzba) {
        this.narudzba = narudzba;
    }
    
}
