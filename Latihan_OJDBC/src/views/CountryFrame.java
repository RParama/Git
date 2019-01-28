/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.CountriesController;
import javax.swing.table.DefaultTableModel;
import models.Countries;
import tools.Connections;

/**
 *
 * @author vivian
 */
public class CountryFrame extends javax.swing.JInternalFrame {
    
    private DefaultTableModel model;
    Connections connections = new Connections();
    CountriesController jcon = new CountriesController(connections.getConnection());

    /**
     * Creates new form CountryFrame
     */
    public CountryFrame() {
        initComponents();
        loadData();
    }
    
    public void loadData() {
        model = new DefaultTableModel();
        Tbl_Countries.setModel(model);
        model.addColumn("COUNTRY ID");
        model.addColumn("COUNTRY NAME");
        model.addColumn("REGIONS ID");

        Object[] dat = new Object[3];

        for (Countries c : jcon.getData()) {
            dat[0] = c.getCountryId();
            dat[1] = c.getCountryName();
            dat[2] = c.getRegionId();
            model.addRow(dat);
        }
        TF_CountryId.enable();
    }
    
    public void select() {
        int i = Tbl_Countries.getSelectedRow();
        System.out.println("" + i);
        if (i == -1) {
            return;
        }
        String ids = (String) model.getValueAt(i, 0);
        String names = (String) model.getValueAt(i, 1);
        int idis = (int) model.getValueAt(i, 2);

        TF_CountryId.setText(String.valueOf(ids));
        TF_CountryName.setText(String.valueOf(names));
        TF_RegionId.setText(Integer.toString(idis));
        Btn_Edit.setText("Edit");
        TF_CountryId.disable();

    }
    
    public void reset() {
        TF_CountryId.setText("");
        TF_CountryName.setText("");
        TF_RegionId.setText("");
        TF_Search.setText("");
        TF_CountryId.enable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        TF_CountryId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        TF_CountryName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        TF_RegionId = new javax.swing.JTextField();
        TF_Search = new javax.swing.JTextField();
        Btn_Search = new javax.swing.JButton();
        Btn_Delete = new javax.swing.JButton();
        Btn_Edit = new javax.swing.JButton();
        Btn_Insert = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tbl_Countries = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setText("Country Id");

        jLabel2.setText("Country Name");

        jLabel3.setText("Region Id");

        TF_RegionId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_RegionIdActionPerformed(evt);
            }
        });

        Btn_Search.setText("Search");
        Btn_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_SearchActionPerformed(evt);
            }
        });

        Btn_Delete.setText("Delete");
        Btn_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_DeleteActionPerformed(evt);
            }
        });

        Btn_Edit.setText("Update");
        Btn_Edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_EditActionPerformed(evt);
            }
        });

        Btn_Insert.setText("Insert");
        Btn_Insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_InsertActionPerformed(evt);
            }
        });

        reset.setText("Reset");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        Tbl_Countries.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        Tbl_Countries.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tbl_CountriesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tbl_Countries);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(reset)
                                .addGap(18, 18, 18)
                                .addComponent(Btn_Insert)
                                .addGap(18, 18, 18)
                                .addComponent(Btn_Edit)
                                .addGap(12, 12, 12)
                                .addComponent(Btn_Delete))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(TF_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Btn_Search))
                                    .addComponent(TF_RegionId, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TF_CountryName, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TF_CountryId, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 35, Short.MAX_VALUE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TF_CountryId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(TF_CountryName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TF_RegionId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TF_Search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_Search))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btn_Delete)
                    .addComponent(Btn_Edit)
                    .addComponent(Btn_Insert)
                    .addComponent(reset))
                .addGap(48, 48, 48)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Tbl_CountriesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tbl_CountriesMouseClicked
        // TODO add your handling code here:
        select();
    }//GEN-LAST:event_Tbl_CountriesMouseClicked

    private void TF_RegionIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_RegionIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_RegionIdActionPerformed

    private void Btn_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_SearchActionPerformed
        // TODO add your handling code here:
        model = new DefaultTableModel();
        Tbl_Countries.setModel(model);
        model.addColumn("COUNTRY ID");
        model.addColumn("COUNTRY NAME");
        model.addColumn("REGIONS ID");

        Object[] dat = new Object[3];

        for (Countries c : jcon.getDataSearch(TF_Search.getText())) {
            dat[0] = c.getCountryId();
            dat[1] = c.getCountryName();
            dat[2] = c.getRegionId();
            model.addRow(dat);
        }
    }//GEN-LAST:event_Btn_SearchActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        // TODO add your handling code here:
        reset();
        loadData();
    }//GEN-LAST:event_resetActionPerformed

    private void Btn_InsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_InsertActionPerformed
        // TODO add your handling code here:
        jcon.insert(TF_CountryId.getText(), TF_CountryName.getText(), TF_RegionId.getText());
        loadData();
    }//GEN-LAST:event_Btn_InsertActionPerformed

    private void Btn_EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_EditActionPerformed
        // TODO add your handling code here:
        if (Btn_Edit.getText() == "Edit") {
            jcon.update(TF_CountryId.getText(), TF_CountryName.getText(), TF_RegionId.getText());
            loadData();
        }        
    }//GEN-LAST:event_Btn_EditActionPerformed

    private void Btn_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_DeleteActionPerformed
        // TODO add your handling code here:
        jcon.delete(TF_CountryId.getText());
        loadData();
    }//GEN-LAST:event_Btn_DeleteActionPerformed
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Delete;
    private javax.swing.JButton Btn_Edit;
    private javax.swing.JButton Btn_Insert;
    private javax.swing.JButton Btn_Search;
    private javax.swing.JTextField TF_CountryId;
    private javax.swing.JTextField TF_CountryName;
    private javax.swing.JTextField TF_RegionId;
    private javax.swing.JTextField TF_Search;
    private javax.swing.JTable Tbl_Countries;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton reset;
    // End of variables declaration//GEN-END:variables
}
