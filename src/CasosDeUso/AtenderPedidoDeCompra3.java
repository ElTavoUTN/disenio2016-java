/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CasosDeUso;

import CasosDeUso.Exepciones.AtenderPedidoDeCompraCaminoAlternativo1;
import CasosDeUso.Exepciones.AtenderPedidoDeCompraCaminoAlternativo2;
import CasosDeUso.Exepciones.ManejoExcepciones;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sistemacompraproveedores.Controladores.ControladorAtenderPedidoDeCompra;
import sistemacompraproveedores.DTO.DTOListaPedido;
import sistemacompraproveedores.DTO.DTOPedido;

/**
 *
 * @author Gustavo
 */
public class AtenderPedidoDeCompra3 extends javax.swing.JFrame {

    ControladorAtenderPedidoDeCompra cont;

    public AtenderPedidoDeCompra3() {
        initComponents();
        this.setLocationRelativeTo(null);

        jLabel5.setText("");
        jLabel5.setToolTipText("Fecha Actual");

        jLabel6.setText("");
        jLabel6.setToolTipText("Proveedor");
    }

    public AtenderPedidoDeCompra3(ControladorAtenderPedidoDeCompra c, DTOPedido dtoped) {
        initComponents();
        this.setLocationRelativeTo(null);

        cont = c;
        System.out.println(dtoped.toString());

        displayResult1(dtoped);

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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jRecepcionarBoton = new javax.swing.JButton();
        jRechazarBoton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Atender Pedido de Compra");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código Articulo", "Nombre Articulo", "Marca", "Cantidad Pedida", "Fecha Vencimiento Pedido"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("¿Desea Aceptar este Pedido?");

        jRecepcionarBoton.setText("Recepcionar");
        jRecepcionarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRecepcionarBotonActionPerformed(evt);
            }
        });

        jRechazarBoton.setText("Rechazar Pendiente de Entrega");
        jRechazarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRechazarBotonActionPerformed(evt);
            }
        });

        jLabel3.setText("Fecha:");

        jLabel4.setText("Proveedor:");

        jLabel5.setText("jLabel5");

        jLabel6.setText("jLabel6");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6)))
                        .addGap(491, 491, 491))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jRecepcionarBoton)
                                .addGap(121, 121, 121)
                                .addComponent(jRechazarBoton)
                                .addGap(93, 93, 93))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRechazarBoton)
                    .addComponent(jRecepcionarBoton))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRecepcionarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRecepcionarBotonActionPerformed
        
            try {
                int result = JOptionPane.showConfirmDialog(null, "¿Estás seguro?", "Confirmar", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    this.setVisible(false);
                    cont.recepcionarPedido();
                }
            } catch (IndexOutOfBoundsException ie) {
                this.setVisible(false);
                switch(ie.getMessage()){
                    case "Recepcionado": cont.caminoalternativo1(); break;
                    case "Finalizada" : cont.caminoalternativo2(); break;
                       
                }
           
            }
    }//GEN-LAST:event_jRecepcionarBotonActionPerformed

    private void jRechazarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRechazarBotonActionPerformed

        int result = JOptionPane.showConfirmDialog(null, "¿Estás seguro?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            this.setVisible(false);
            cont.rechazarPedido();
        }
    }//GEN-LAST:event_jRechazarBotonActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(AtenderPedidoDeCompra3.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AtenderPedidoDeCompra3.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AtenderPedidoDeCompra3.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AtenderPedidoDeCompra3.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AtenderPedidoDeCompra3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton jRecepcionarBoton;
    private javax.swing.JButton jRechazarBoton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
 public void displayResult1(DTOPedido dtoPedido) {

        Date today = new Date();
        String otra = String.valueOf(today);

        Vector<String> tableHeaders = new Vector<String>();
        Vector tableData = new Vector();

        tableHeaders.add("Código Articulo");
        tableHeaders.add("Nombre Articulo");
        tableHeaders.add("Marca");
        tableHeaders.add("Cantidad Pedida");
        tableHeaders.add("Fecha Vencimiento Pedido");

        for (DTOListaPedido dtoLista : dtoPedido.getM_DTOListaPedido()) {
            Vector<Object> oneRow = new Vector();

            oneRow.add(dtoLista.getCodigoArticulo());
            oneRow.add(dtoLista.getNombreArticulo());
            oneRow.add(dtoLista.getNombreMarca());
            oneRow.add(dtoLista.getCantidadPedido());
            oneRow.add(dtoPedido.getFechaVencimiento());

            tableData.add(oneRow);

            jLabel5.setText(otra);
            jLabel5.setToolTipText("Fecha Actual");

            jLabel6.setText(dtoPedido.getNombreProveedor());
            jLabel6.setToolTipText("Proveedor");
        }

        jTable1.setModel(new DefaultTableModel(tableData, tableHeaders));

    }
}
