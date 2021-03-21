/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.jp23.controller;

import edunova.jp23.model.Zaposlenik;
import edunova.jp23.util.EdunovaException;
import java.util.List;

/**
 *
 * @author Pozna
 */
public class ObradaZaposlenik extends ObradaOsoba<Zaposlenik>{

    @Override
    public List<Zaposlenik> getPodaci() {
        return session.createQuery("from Zaposlenik").list();
    }
    
     @Override
    protected void kontrolaCreate() throws EdunovaException {
       super.kontrolaCreate();
       ibanKontrola();
       //onda moje kontrole
    }

    @Override
    protected void kontrolaUpdate() throws EdunovaException {
        super.kontrolaUpdate();
        kontrolaCreate();
        //onda moje kontrole
    }
    @Override
    protected void kontrolaDelete() throws EdunovaException {
        
    }
    
    
    private void ibanKontrola() throws EdunovaException {
        if(isIbanValid(entitet.getIban()) == false){
            throw new EdunovaException("Netočan IBAN");
        }
    }
    
    private boolean isIbanValid(String iban) {

    int IBAN_MIN_SIZE = 15;
    int IBAN_MAX_SIZE = 34;
    long IBAN_MAX = 999999999;
    long IBAN_MODULUS = 97;

    String trimmed = iban.trim();

    if (trimmed.length() < IBAN_MIN_SIZE || trimmed.length() > IBAN_MAX_SIZE) {
        return false;
    }

    String reformat = trimmed.substring(4) + trimmed.substring(0, 4);
    long total = 0;

    for (int i = 0; i < reformat.length(); i++) {

        int charValue = Character.getNumericValue(reformat.charAt(i));

        if (charValue < 0 || charValue > 35) {
            return false;
        }

        total = (charValue > 9 ? total * 100 : total * 10) + charValue;

        if (total > IBAN_MAX) {
            total = (total % IBAN_MODULUS);
        }
    }

    return (total % IBAN_MODULUS) == 1;
}
    
}
