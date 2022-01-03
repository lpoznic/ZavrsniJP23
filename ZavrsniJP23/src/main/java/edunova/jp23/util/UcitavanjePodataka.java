/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.jp23.util;

import edunova.jp23.controller.ObradaArtikl;
import edunova.jp23.controller.ObradaDobavljac;
import edunova.jp23.controller.ObradaKupac;
import edunova.jp23.controller.ObradaNarudzba;
import edunova.jp23.controller.ObradaOperater;
import edunova.jp23.model.Artikl;
import edunova.jp23.model.Dobavljac;
import edunova.jp23.model.Kupac;
import edunova.jp23.model.Narudzba;
import edunova.jp23.model.Operater;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

/**
 *
 * @author Pozna
 */
public class UcitavanjePodataka {
    public void ucitajNarudzbe(ObradaNarudzba obradaN, javax.swing.JList<Narudzba> lstNarudzbe){
        DefaultListModel<Narudzba> m = new DefaultListModel<>();

        //m.addAll(obrada.getPodaci());
        System.out.println("Narudžbe");
        obradaN.getPodaci().forEach(xxxx -> {
            m.addElement(xxxx);
            System.out.println(
                    xxxx.getArtikli().hashCode());
        });

        lstNarudzbe.setModel(m);
    }
    
    public void ucitajKupce(javax.swing.JComboBox<Kupac> cmbKupci) {
         
        DefaultComboBoxModel<Kupac> m =
                 new DefaultComboBoxModel<>();
        Kupac k=new Kupac();
        k.setId(-1L);
        k.setIme("Odaberite kupca");
        m.addElement(k);
        System.out.println("Kupci u CMB");
        new ObradaKupac().getPodaci().forEach(sm->{
              m.addElement(sm);
              System.out.println(sm.getIme()+" "+sm.getPrezime()+ ": " + 
                      sm.hashCode());
         });

        cmbKupci.setModel(m);
        cmbKupci.setSelectedIndex(0);
        
    }
    
    public void ucitajOperatera(ObradaOperater obradaO, javax.swing.JList<Operater> lstZaposlenici) {

        DefaultListModel<Operater> m = new DefaultListModel<>();

        m.addAll(obradaO.getPodaci());

        lstZaposlenici.setModel(m);

    }
    
    public void ucitajDobavljace(ObradaDobavljac obradaD, javax.swing.JList<Dobavljac> lstDobavljaci){
        DefaultListModel<Dobavljac> m = new DefaultListModel<>();

        m.addAll(obradaD.getPodaci());

        lstDobavljaci.setModel(m);
    }
    
    public void ucitajKupce(ObradaKupac obradaK, javax.swing.JList<Kupac> lstKupci){
        DefaultListModel<Kupac> m = new DefaultListModel<>();

        m.addAll(obradaK.getPodaci());

        lstKupci.setModel(m);
    }
    
    public void ucitajArtikle(ObradaArtikl obradaA, javax.swing.JList<Artikl> lstArtikli, javax.swing.JComboBox<Dobavljac> cmbDobavljaci){
        DefaultListModel<Artikl> m = new DefaultListModel<>();

        m.addAll(obradaA.getPodaci());
        ucitajDobavljaceCMB(cmbDobavljaci);
        lstArtikli.setModel(m);
    }
    
    private void ucitajDobavljaceCMB(javax.swing.JComboBox<Dobavljac> cmbDobavljaci){
        DefaultComboBoxModel<Dobavljac> m =
                 new DefaultComboBoxModel<>();
        Dobavljac d=new Dobavljac();
        d.setId(-1L);
        d.setNaziv("Odaberite dobavljača");
        m.addElement(d);
        System.out.println("Dobavljači u CMB");
        new ObradaDobavljac().getPodaci().forEach(sm->{
              m.addElement(sm);
              System.out.println(sm.getNaziv()+" "+ 
                      sm.hashCode());
         });

        cmbDobavljaci.setModel(m);
        cmbDobavljaci.setSelectedIndex(0);
    }
}
