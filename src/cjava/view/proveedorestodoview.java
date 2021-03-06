/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cjava.view;

import cjava.controller.ProveedorBLL;
import cjava.entity.ProveedorDTO;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Edith
 */
public class proveedorestodoview extends javax.swing.JInternalFrame {

    /**
     * Creates new form proveedorestodoview
     */
    public proveedorestodoview() {
        initComponents();
        listaProveedores();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblProveedor = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JButton();

        setTitle("LISTADO DE EMPLEADOS");

        tblProveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Apellido", "Nombre", "Email", "Usuario", "Clave"
            }
        ));
        jScrollPane1.setViewportView(tblProveedor);

        jLabel1.setText("Total  de Proveedores");

        lblTotal.setText("0");

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(96, 96, 96)
                        .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCerrar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblTotal)
                    .addComponent(btnCerrar))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
     this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnCerrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tblProveedor;
    // End of variables declaration//GEN-END:variables



 private void listaProveedores()
    {
    
        try {
            //se instancia el Objeto
            ProveedorBLL obj= new ProveedorBLL();
            
            List<ProveedorDTO> lista = obj.ProveedorListar(); //devuelve la lista de productos de la collections
            int nfilas=0;
            if (lista!=null && !lista.isEmpty()) {
                
                nfilas=lista.size();
                //se determina cuantas filas hay en la collection
                lblTotal.setText(nfilas + "");
                verProducto(lista);
                
            }
            
        } catch (Exception e) {
        }
        
    }
        public void verProducto(List<ProveedorDTO> lista)
                {
                DefaultTableModel tabla = (DefaultTableModel) tblProveedor.getModel();
                tabla.setRowCount(0);
                
               
                    for (ProveedorDTO p : lista) {
                        Object  []  datos= {p.getIdProveedor(),p.getRazonSocial(), p.getDireccion(),
                        p.getRuc(), p.getTelefono()};
                        
                        
                        tabla.addRow(datos);
                     
                    }
                      
                        
                    }
}

