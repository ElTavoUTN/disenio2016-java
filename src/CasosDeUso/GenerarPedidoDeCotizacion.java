package CasosDeUso;

import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sistemacompraproveedores.Controladores.ControladorGenerarPedidoCotizacion;
import sistemacompraproveedores.DTO.DTOReposicion;
import sistemacompraproveedores.DTO.DTOReposicionDetalle;

public class GenerarPedidoDeCotizacion extends javax.swing.JFrame {

    ControladorGenerarPedidoCotizacion cont;

    List<DTOReposicion> lr;
    
    int combo;

    public GenerarPedidoDeCotizacion() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Generar Pedido de Cotización");

        cont = new ControladorGenerarPedidoCotizacion();
        lr = cont.buscarReposicion();

        for (DTOReposicionDetalle lint : lr.get(0).getDtoRepodetalle()) {
            System.out.println("p" + lint.getNombreArticulo());

        }
        jTable1.getColumnModel().getColumn(0).setMaxWidth(0);                       // Ocultar NumeroReposicion
        jTable1.getColumnModel().getColumn(0).setMinWidth(0);
        jTable1.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        jTable1.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);

        jTable1.getColumnModel().getColumn(5).setMaxWidth(0);                       // Ocultar CodigoArticulo
        jTable1.getColumnModel().getColumn(5).setMinWidth(0);
        jTable1.getTableHeader().getColumnModel().getColumn(5).setMaxWidth(0);
        jTable1.getTableHeader().getColumnModel().getColumn(5).setMinWidth(0);

        displayResult(lr);

        displayResult2(lr);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnCancel = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
        cbRepo = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Generar Pedido de Cotización");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Número Reposición", "Nombre Artículo", "Cantidad", "Marca", "Tipo de Producto", "Código Artículo"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btnCancel.setText("Cancelar");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnSiguiente.setText("Siguiente");
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        cbRepo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbRepoMouseClicked(evt);
            }
        });
        cbRepo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbRepoActionPerformed(evt);
            }
        });

        jLabel2.setText("Reposición:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCancel)
                        .addGap(18, 18, 18)
                        .addComponent(btnSiguiente))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 753, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 753, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbRepo, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbRepo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                        .addGap(83, 83, 83))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSiguiente)
                            .addComponent(btnCancel))
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.setVisible(false);
        cont.volver();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void cbRepoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbRepoMouseClicked


    }//GEN-LAST:event_cbRepoMouseClicked

    private void cbRepoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbRepoActionPerformed

        try {

            displayResult2(lr);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }//GEN-LAST:event_cbRepoActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        
        this.setVisible(false);
        cont.seleccionarReposicion(combo);
        

    }//GEN-LAST:event_btnSiguienteActionPerformed

    public static void main(String args[]) {

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
            java.util.logging.Logger.getLogger(GenerarPedidoDeCotizacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GenerarPedidoDeCotizacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GenerarPedidoDeCotizacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GenerarPedidoDeCotizacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GenerarPedidoDeCotizacion().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JComboBox cbRepo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    public void displayResult(List<DTOReposicion> repo) {

        cbRepo.removeAllItems();

        for (DTOReposicion dto : repo) {

            cbRepo.addItem(dto.getNumeroReposicion());

        }
        jTable1.getColumnModel().getColumn(0).setMaxWidth(0);                       // Ocultar NumeroReposicion
        jTable1.getColumnModel().getColumn(0).setMinWidth(0);
        jTable1.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        jTable1.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);

        jTable1.getColumnModel().getColumn(5).setMaxWidth(0);                       // Ocultar CodigoArticulo
        jTable1.getColumnModel().getColumn(5).setMinWidth(0);
        jTable1.getTableHeader().getColumnModel().getColumn(5).setMaxWidth(0);
        jTable1.getTableHeader().getColumnModel().getColumn(5).setMinWidth(0);
    }

    public void displayResult2(List<DTOReposicion> repo) {

        Vector<String> tableHeaders = new Vector<String>();

        Vector tableData = new Vector();

        tableHeaders.add("Número Reposición");
        tableHeaders.add("Nombre Artículo");
        tableHeaders.add("Cantidad");
        tableHeaders.add("Marca");
        tableHeaders.add("Tipo de Producto");
        tableHeaders.add("Código Artículo");

       combo = (int) cbRepo.getSelectedItem();

        for (DTOReposicion list : repo) {
            if (list.getNumeroReposicion() == combo) {

                for (DTOReposicionDetalle detalle : list.getDtoRepodetalle()) {

                    Vector<Object> twoRow = new Vector<Object>();
                    
                    twoRow.addElement(list.getNumeroReposicion());
                    //System.out.println(list.getNumeroReposicion());
                    twoRow.addElement(detalle.getNombreArticulo());
                    //System.out.println(detalle.getNombreArticulo());

                    twoRow.addElement(detalle.getCantidadAReponerArticulo());
                    //System.out.println(detalle.getCantidadAReponerArticulo());
                    twoRow.addElement(detalle.getNombreMarca());
                    //System.out.println(detalle.getNombreMarca());
                    twoRow.addElement(detalle.getNombreTipoProducto());
                    //System.out.println(detalle.getNombreTipoProducto());
                    twoRow.addElement(detalle.getCodigoArticulo());
                    //System.out.println(detalle.getCodigoArticulo());

                    tableData.addElement(twoRow);

                }
            }

            jTable1.setModel(new DefaultTableModel(tableData, tableHeaders));

            jTable1.getColumnModel().getColumn(0).setMaxWidth(0);                       // Ocultar NumeroReposicion
            jTable1.getColumnModel().getColumn(0).setMinWidth(0);
            jTable1.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
            jTable1.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);

            jTable1.getColumnModel().getColumn(5).setMaxWidth(0);                       // Ocultar CodigoArticulo
            jTable1.getColumnModel().getColumn(5).setMinWidth(0);
            jTable1.getTableHeader().getColumnModel().getColumn(5).setMaxWidth(0);
            jTable1.getTableHeader().getColumnModel().getColumn(5).setMinWidth(0);
        }
    }

}
