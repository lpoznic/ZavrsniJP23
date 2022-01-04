/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.jp23.util;

import edunova.jp23.controller.ObradaArtikl;
import edunova.jp23.controller.ObradaDobavljac;
import edunova.jp23.controller.ObradaNarudzba;
import edunova.jp23.controller.ObradaOperater;
import edunova.jp23.model.Dobavljac;
import edunova.jp23.model.Kupac;
import edunova.jp23.model.Narudzba;
import edunova.jp23.model.Stavka;
import edunova.jp23.view.Aplikacija;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Pozna
 */
public class PostavljanjeVrijednosti {
    
    public void postaviVrijednostiNaNarudzbu(ObradaNarudzba obrada, JComboBox<Kupac> cmbKupci,
            javax.swing.JList<Stavka> lstTrenutneStavke, javax.swing.JList<Narudzba> lstNarudzbe) {
       var g = obrada.getEntitet();
       g.setKupac((Kupac)cmbKupci.getSelectedItem());
       g.setDatum(new Date());
       g.setOperater(Aplikacija.operater);
       
       
       DefaultListModel<Stavka> m;
        try {
            m=(DefaultListModel<Stavka>) lstTrenutneStavke.getModel();
            g.setArtikli(new ArrayList<>());
            for(int i=0;i<m.getSize();i++){
                g.getArtikli().add(m.get(i));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        updateUkupnaCijena(lstNarudzbe);
       
       
       lstTrenutneStavke.repaint();
       
    }
    
    public void postaviVrijednostiNaOperatora(ObradaOperater obradaO, javax.swing.JTextField txtIme,
            javax.swing.JTextField txtPrezime, javax.swing.JTextField txtEmail, javax.swing.JTextField txtIban,
            javax.swing.JTextField txtOib, javax.swing.JPasswordField pwdZaporka) {
        var entitet=obradaO.getEntitet();
        
        entitet.setIme(txtIme.getText());

        try {
            entitet.setPrezime(txtPrezime.getText());
        } catch (Exception e) {
            entitet.setPrezime("");
        }

        try {
            entitet.setEmail(txtEmail.getText());
        } catch (Exception e) {
            entitet.setEmail("");
        }
        
        try {
            entitet.setIban(txtIban.getText());
        } catch (Exception e) {
            entitet.setIban("");
        }

        try {
            entitet.setOib(txtOib.getText());
        } catch (Exception e) {
            entitet.setOib("");
        }
        String lozinka = new String(pwdZaporka.getPassword());
        try{
            entitet.setLozinka(BCrypt.hashpw(lozinka, BCrypt.gensalt()));
        }catch(Exception e){
            entitet.setLozinka("");
        }
    }
    
    public void postaviVrijednostiNaArtikl(ObradaArtikl obradaA, javax.swing.JTextField txtNaziv,
            javax.swing.JTextField txtCijena, javax.swing.JComboBox cmbDobavljaci) {
        var entitet=obradaA.getEntitet();
        
        entitet.setNaziv(txtNaziv.getText());
        entitet.setCijena(new BigDecimal(txtCijena.getText()));
        entitet.setDobavljac((Dobavljac)cmbDobavljaci.getSelectedItem());
    }
    
    public void postaviVrijednostiNaDobavljaca(ObradaDobavljac obradaD, javax.swing.JTextField txtNaziv,
            javax.swing.JTextField txtAdresa, javax.swing.JTextField txtImeVlasnika) {
        var entitet=obradaD.getEntitet();
        
        entitet.setNaziv(txtNaziv.getText());
        entitet.setAdresa(txtAdresa.getText());
        entitet.setImeVlasnika(txtImeVlasnika.getText());
    }
    
    public BigDecimal updateUkupnaCijena(javax.swing.JList<Narudzba> lstNarudzbe){
        BigDecimal ukupnaCijena = BigDecimal.ZERO;
        if(lstNarudzbe.getSelectedValue()==null){
            return BigDecimal.ZERO;
        }
        for(Stavka s : lstNarudzbe.getSelectedValue().getArtikli()){
            ukupnaCijena=ukupnaCijena.add(s.getArtikl().getCijena());
        }
        return ukupnaCijena;
    }
}
