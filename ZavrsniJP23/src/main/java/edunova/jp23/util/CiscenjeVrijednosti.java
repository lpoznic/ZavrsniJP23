/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.jp23.util;

import edunova.jp23.model.Dobavljac;

/**
 *
 * @author Pozna
 */
public class CiscenjeVrijednosti {
    public void pocistiNarudzbu(javax.swing.JLabel lblDatum, javax.swing.JLabel lblTrenutniZaposlenik, javax.swing.JLabel lblVrijeme, javax.swing.JLabel lblBrojRacuna,
            javax.swing.JLabel lblUkCijena, javax.swing.JList<edunova.jp23.model.Stavka> lstTrenutneStavke) {
        lblDatum.setText("");
        lblTrenutniZaposlenik.setText("");
        lblVrijeme.setText("");
        lblUkCijena.setText("");
        lblBrojRacuna.setText("Broj računa: ");
        lstTrenutneStavke.removeAll();
    }
    
    public void pocistiDobavljaca(javax.swing.JTextField txtNazivDobavljaca, javax.swing.JTextField txtAdresaDobavljaca, javax.swing.JTextField txtImeVlasnikaDobavljaca){
        txtNazivDobavljaca.setText("");
        txtAdresaDobavljaca.setText("");
        txtImeVlasnikaDobavljaca.setText("");
    }

    public void pocistiArtikl(javax.swing.JTextField txtNazivArtikla, javax.swing.JTextField txtCijenaArtikla, javax.swing.JComboBox<Dobavljac> cmbDobavljaci){
        txtNazivArtikla.setText("");
        txtCijenaArtikla.setText("");
        cmbDobavljaci.setSelectedIndex(0);
    }
    
    public void pocistiOperatera(javax.swing.JTextField txtPrezime, javax.swing.JTextField txtIme,
            javax.swing.JTextField txtEmail, javax.swing.JTextField txtIban, javax.swing.JTextField txtOib ) {
        txtPrezime.setText("");
        txtIme.setText("");
        txtEmail.setText("");
        txtOib.setText("");
        txtIban.setText("");
    }
    
    public void pocistiKupca(javax.swing.JTextField txtPrezime, javax.swing.JTextField txtIme,
            javax.swing.JTextField txtEmail, javax.swing.JTextField txtAdresa, javax.swing.JTextField txtOib, javax.swing.JTextField txtKontakt){
        txtIme.setText("");
        txtPrezime.setText("");
        txtOib.setText("");
        txtAdresa.setText("");
        txtKontakt.setText("");
        txtEmail.setText("");
    }
}
