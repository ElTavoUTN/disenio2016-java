package CasosDeUso;


import CasosDeUso.Exepciones.ManejoExcepciones;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sistemacompraproveedores.Controladores.ControladorRecepcionarCotizacion;
import sistemacompraproveedores.DTO.DTOCompletarCotizacion;
import sistemacompraproveedores.DTO.DTODetalleCotizacion;
import sistemacompraproveedores.DTO.DTOListaCotizacion;

public class RecepcionarCotizacion3 extends javax.swing.JFrame {

    ControladorRecepcionarCotizacion cont;

    public RecepcionarCotizacion3() {
        initComponents();

//        cont = new ControladorRecepcionarCotizacion();
//         List<DTODetalleCotizacion> alc;
//             
//        alc = cont.seleccionarCotizacion(2);
//        System.out.println(alc);
//        displayResult3(alc);
//        
//        List<DTOCompletarCotizacion> po;
//        po = cont.completarCotizacionDetalle();
    }

    public RecepcionarCotizacion3(ControladorRecepcionarCotizacion c, List<DTODetalleCotizacion> alc) {
        initComponents();

        this.setLocationRelativeTo(null);
        cont = c;
        System.out.println(alc.toString());
        displayResult3(alc);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnSiguiente = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();
        jLProveedor = new javax.swing.JLabel();
        jLReposicion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Recepcionar Cotización");

        jLabel2.setText("Proveedor: ");

        jLabel3.setText("Reposición: ");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Renglon", "Nombre Artículo", "Marca", "Tipo", "Cantidad Pedida", "Cantidad Cotizada", "Precio Lista", "Precio Cotizado", "Código Artículo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        btnSiguiente.setText("Siguiente");
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        btnAtras.setText("Atrás");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        jLProveedor.setText("jLabel4");

        jLReposicion.setText("jLabel5");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 880, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLReposicion)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAtras)
                        .addGap(18, 18, 18)
                        .addComponent(btnSiguiente)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLProveedor)
                    .addComponent(jLReposicion))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSiguiente)
                    .addComponent(btnAtras))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        try {

            DTOCompletarCotizacion e = new DTOCompletarCotizacion();

            List<DTOCompletarCotizacion> algo2 = new ArrayList<>();

            for (int i = 0; i < jTable1.getRowCount(); i++){

                System.out.println(jTable1.getValueAt(i, 4) + " "); //Cantidad
                System.out.print(jTable1.getValueAt(i, 6) + " "); //Precio
                System.out.print(jTable1.getValueAt(i, 7) + " "); // Renglon
                System.out.print(jTable1.getValueAt(i, 8) + " "); // CodigoArticulo

                String dtoCant = this.jTable1.getValueAt(i, 4).toString();
                String dtoPrecio = this.jTable1.getValueAt(i, 6).toString();
                String dtoRen = this.jTable1.getValueAt(i, 7).toString();

                int dtocan = Integer.parseInt(dtoCant);
                double dtopre = Double.parseDouble(dtoPrecio);
                int dtoren = Integer.parseInt(dtoRen);
                System.out.println(dtocan + "hh" + dtoPrecio + "hh " + dtoren);
                e = new DTOCompletarCotizacion();
                e.setCantidad(dtocan);
                e.setPrecio(dtopre);
                e.setRenglon(dtoren);

                algo2.add(e);

            }
            System.out.println();

            cont.completarCotizacionDetalle(algo2);
            this.setVisible(false);
        } catch (ManejoExcepciones e) {
            this.setVisible(false);
            cont.terminarTransaccion(false);
            switch(e.getParametro()){
                case"Atendida" : cont.caminoAlternativo1(); break;
                case"Cargada" : cont.caminoAlternativo2(); break;
                case"Descartada" : cont.caminoAlternativo3(); break;
                
            }
        }

    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed

        this.setVisible(false);
        try {
            cont.volver2();
        } catch (ManejoExcepciones ex) {
            Logger.getLogger(RecepcionarCotizacion3.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnAtrasActionPerformed

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
            java.util.logging.Logger.getLogger(RecepcionarCotizacion3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RecepcionarCotizacion3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RecepcionarCotizacion3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RecepcionarCotizacion3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new RecepcionarCotizacion3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JLabel jLProveedor;
    private javax.swing.JLabel jLReposicion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    public void displayResult3(List<DTODetalleCotizacion> detcoti) {

        Vector<String> tableHeaders = new Vector<String>();

        Vector tableData = new Vector();

        tableHeaders.add("Nombre Artículo");
        tableHeaders.add("Marca");
        tableHeaders.add("Tipo");
        tableHeaders.add("Cantidad Pedida");
        tableHeaders.add("Cantidad Cotizada");
        tableHeaders.add("Precio Lista");
        tableHeaders.add("Precio Cotizado");
        tableHeaders.add("Renglon");
        tableHeaders.add("Código Artículo");

        for (DTODetalleCotizacion dosdto : detcoti) {

            Vector<Object> oneRow = new Vector<Object>();

            oneRow.add(dosdto.getNombreArticulo());
            oneRow.add(dosdto.getNombreMarca());
            oneRow.add(dosdto.getNombreTipo());
            oneRow.add(dosdto.getCantidadAPedirCotizacion());
            oneRow.add(dosdto.getCantidadCotizada());
            oneRow.add(dosdto.getPrecioArticuloLista());
            oneRow.add(dosdto.getPrecioCotizacion());
            oneRow.add(dosdto.getRenglonCotizacion());
            oneRow.add(dosdto.getCodigoArticulo());

            int repo = dosdto.getReposicion();
            String srepo = String.valueOf(repo);

            tableData.add(oneRow);

            jLReposicion.setText(srepo);
            jLReposicion.setToolTipText("Reposicion");
            jLProveedor.setText(dosdto.getProveedor());
            jLProveedor.setToolTipText("Proveedor");

        }

        jTable1.setModel(new DefaultTableModel(tableData, tableHeaders));

        jTable1.getColumnModel().getColumn(7).setMaxWidth(0);                       // Ocultar Renglon
        jTable1.getColumnModel().getColumn(7).setMinWidth(0);
        jTable1.getTableHeader().getColumnModel().getColumn(7).setMaxWidth(0);
        jTable1.getTableHeader().getColumnModel().getColumn(7).setMinWidth(0);

        jTable1.getColumnModel().getColumn(8).setMaxWidth(0);                       // Ocultar CodigoArticulo
        jTable1.getColumnModel().getColumn(8).setMinWidth(0);
        jTable1.getTableHeader().getColumnModel().getColumn(8).setMaxWidth(0);
        jTable1.getTableHeader().getColumnModel().getColumn(8).setMinWidth(0);

        for (int i = 0; i < jTable1.getRowCount(); i++) {

            jTable1.isCellEditable(i, 4);
            jTable1.isCellEditable(i, 6);
        }

        DefaultTableModel modelo = new DefaultTableModel() {

            public boolean isCellEditable(int fila, int columna) {
                if (columna == 0 && columna == 1 && columna == 2 && columna == 3 && columna == 5) //Con esto se pueden editar todas las celdas menos la de la columna 0
                {
                    return false;
                } else {
                    return true;
                }
            }
        };

    }
}
