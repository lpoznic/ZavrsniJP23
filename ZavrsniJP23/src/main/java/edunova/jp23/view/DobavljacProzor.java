/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.jp23.view;

import edunova.jp23.controller.ObradaDobavljac;
import edunova.jp23.model.Dobavljac;
import edunova.jp23.util.EdunovaException;
import java.math.BigDecimal;
import java.time.ZoneId;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Pozna
 */
public class DobavljacProzor extends javax.swing.JFrame {

    /**
     * Creates new form DobavljacProzor
     */
    
    private ObradaDobavljac obrada;
    public DobavljacProzor() {
        initComponents();
        obrada = new ObradaDobavljac();
        setTitle(Aplikacija.NASLOV_APP + " Dobavljaci");
        ucitaj();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnDodaj = new javax.swing.JButton();
        btnUredi = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNazivDobavljaca = new javax.swing.JTextField();
        txtImeVlasnika = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtAdresaDobavljaca = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstDobavljaci = new javax.swing.JList<>();
        btnUkloni = new javax.swing.JButton();
        btnOdaberiDobavljaca = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnDodaj.setText("Dodaj");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        btnUredi.setText("Uredi");
        btnUredi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUrediActionPerformed(evt);
            }
        });

        jLabel1.setText("Svi dobavljači");

        jLabel2.setText("Naziv dobavljača");

        txtNazivDobavljaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNazivDobavljacaActionPerformed(evt);
            }
        });

        jLabel3.setText("Ime vlasnika");

        jLabel4.setText("Adresa");

        lstDobavljaci.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstDobavljaciValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstDobavljaci);

        btnUkloni.setText("Ukloni");

        btnOdaberiDobavljaca.setText("Odaberi");
        btnOdaberiDobavljaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOdaberiDobavljacaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnOdaberiDobavljaca, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnUredi, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addComponent(btnUkloni, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(154, 154, 154))
                            .addComponent(txtImeVlasnika, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtAdresaDobavljaca)
                            .addComponent(txtNazivDobavljaca, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNazivDobavljaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtImeVlasnika, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAdresaDobavljaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOdaberiDobavljaca)
                    .addComponent(btnUkloni)
                    .addComponent(btnUredi)
                    .addComponent(btnDodaj))
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNazivDobavljacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNazivDobavljacaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNazivDobavljacaActionPerformed

    private void lstDobavljaciValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstDobavljaciValueChanged
         if (evt.getValueIsAdjusting()) {
            return;
        }
       
        if (lstDobavljaci.getSelectedValue() == null) {
            return;
        }
        
         obrada.setEntitet(lstDobavljaci.getSelectedValue());


        // ovo se može zamijeniti tkz. Binding
        txtNazivDobavljaca.setText(obrada.getEntitet().getNaziv());
        try {
            txtImeVlasnika.setText(obrada.getEntitet().getImeVlasnika());
        } catch(Exception e) {
            txtImeVlasnika.setText("");
        }
        try {
            txtAdresaDobavljaca.setText(obrada.getEntitet().getAdresa());
        } catch (Exception e) {
            txtAdresaDobavljaca.setText("");
        }

        
    }//GEN-LAST:event_lstDobavljaciValueChanged

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
        obrada.setEntitet(new Dobavljac());
        postaviVrijednostiNaEntitet();

        try {
            obrada.create();
            pocisti();
            ucitaj(); 
        } catch (EdunovaException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getPoruka());
        }
    }//GEN-LAST:event_btnDodajActionPerformed

    private void btnUrediActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUrediActionPerformed
        if (obrada.getEntitet()==null || 
                obrada.getEntitet().getId() == null) {
            JOptionPane.showMessageDialog(rootPane, "Prvo odaberite stavku");
            return;
        }
        postaviVrijednostiNaEntitet();

        try {
            obrada.update();
            pocisti();
            ucitaj();
        } catch (EdunovaException e) {
            JOptionPane.showMessageDialog(rootPane, e.getPoruka());
        }
    }//GEN-LAST:event_btnUrediActionPerformed

    private void btnOdaberiDobavljacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOdaberiDobavljacaActionPerformed
        if (obrada.getEntitet()==null || 
                obrada.getEntitet().getId() == null) {
            JOptionPane.showMessageDialog(rootPane, "Prvo odaberite stavku");   
        }
        getDobavljac();
    }//GEN-LAST:event_btnOdaberiDobavljacaActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnOdaberiDobavljaca;
    private javax.swing.JButton btnUkloni;
    private javax.swing.JButton btnUredi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<Dobavljac> lstDobavljaci;
    private javax.swing.JTextField txtAdresaDobavljaca;
    private javax.swing.JTextField txtImeVlasnika;
    private javax.swing.JTextField txtNazivDobavljaca;
    // End of variables declaration//GEN-END:variables

public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DobavljacProzor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DobavljacProzor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DobavljacProzor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DobavljacProzor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DobavljacProzor().setVisible(true);
            }
        });
    }
    
    
      private void ucitaj() {

        DefaultListModel<Dobavljac> m = new DefaultListModel<>();

        m.addAll(obrada.getPodaci());

        lstDobavljaci.setModel(m);

    }

    private void postaviVrijednostiNaEntitet() {
        var entitet=obrada.getEntitet();
        
        entitet.setNaziv(txtNazivDobavljaca.getText());

        try {
            entitet.setImeVlasnika(txtImeVlasnika.getText());
        } catch (Exception e) {
            entitet.setImeVlasnika(null);
        }

        try {
            entitet.setAdresa(txtAdresaDobavljaca.getText());
        } catch (Exception e) {
            entitet.setAdresa(null);
        }

    }

    private void pocisti() {
        txtNazivDobavljaca.setText("");
        txtImeVlasnika.setText("");
        txtAdresaDobavljaca.setText("");

    }

    public Dobavljac getDobavljac(){
        return obrada.getEntitet();
    }



}
