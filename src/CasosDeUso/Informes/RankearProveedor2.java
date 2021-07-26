package CasosDeUso.Informes;

import CasosDeUso.Exepciones.ManejoExcepciones;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import sistemacompraproveedores.Controladores.ControladorRankearProveedor;
import sistemacompraproveedores.DTO.DTOCabeceraRanking;
import sistemacompraproveedores.DTO.DTORankingProveedor;

public class RankearProveedor2 extends javax.swing.JFrame{
ControladorRankearProveedor cont;
Date desdefecha;
Date hastafecha;
DTOCabeceraRanking dto;
private boolean bandera = true;
    public RankearProveedor2() {initComponents();}
    
    public RankearProveedor2(Date fechadesde, Date fechahasta){
        initComponents();
        this.setTitle("Rankear Proveedor");
        this.setLocationRelativeTo(null);
        desdefecha = fechadesde; hastafecha = fechahasta;
        cont = new ControladorRankearProveedor();
        try{
        DTOCabeceraRanking dtocabecera;
        dtocabecera = cont.realizarRanking(fechadesde, fechahasta);
        this.setVisible(true);
        dto = dtocabecera;
        displayResults(dtocabecera);
        }catch(ManejoExcepciones me){
                bandera = false;
                this.setVisible(false);
                cont.terminartransacccion(false);
                switch(me.getParametro()){
                case"Rankear.nohayproveedoreshabilitados":
                    cont.rankearcaminoalternativo1(); break;
                case"Rankear.nohaycotparafechasingresadas":
                    cont.rankearcaminoalternativo2(); break;
                case"Rankear.nohaycotdisponiblesparalasfechasingresadas":
                    cont.rankearcaminoalternativo3(); break;
                                
                }
                
                
                
            }
        if(bandera) this.setVisible(true);
        
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButtonFinalizar = new javax.swing.JButton();
        jButtonAtras = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton3GuardarPDF = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Rankear Proveedor");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Puesto", "Proveedor", "Código Proveedor", "Descuento Total%"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel3.setText("Fecha de Consulta:");

        jLabel4.setText("Hora de Consulta:");

        jButtonFinalizar.setText("Finalizar");
        jButtonFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFinalizarActionPerformed(evt);
            }
        });

        jButtonAtras.setText("Atrás");
        jButtonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtrasActionPerformed(evt);
            }
        });

        jLabel5.setText("jLabel5");

        jLabel6.setText("jLabel6");

        jLabel7.setText("Ranking desde:");

        jLabel8.setText("jLabel8");

        jLabel9.setText("hasta: ");

        jLabel10.setText("jLabel10");

        jButton3GuardarPDF.setText("Guardar en PDF");
        jButton3GuardarPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3GuardarPDFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButtonAtras)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3GuardarPDF)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonFinalizar)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addGap(93, 93, 93)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonFinalizar)
                    .addComponent(jButtonAtras)
                    .addComponent(jButton3GuardarPDF))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtrasActionPerformed
        // boton atras
        cont.terminartransacccion(false);
        this.setVisible(false);
        cont.rankearproveedor();
        
    }//GEN-LAST:event_jButtonAtrasActionPerformed

    private void jButtonFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFinalizarActionPerformed
        // boton finalizar
        this.setVisible(false);
        cont.terminartransacccion(true);
        cont.rankearproveedor3();
    }//GEN-LAST:event_jButtonFinalizarActionPerformed

    private void jButton3GuardarPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3GuardarPDFActionPerformed
        //boton pdf
        cont.rankearproveedor4(dto, desdefecha, hastafecha);

        
        

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3GuardarPDFActionPerformed

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
            java.util.logging.Logger.getLogger(RankearProveedor2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RankearProveedor2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RankearProveedor2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RankearProveedor2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run(){
                new RankearProveedor2();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3GuardarPDF;
    private javax.swing.JButton jButtonAtras;
    private javax.swing.JButton jButtonFinalizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

public void displayResults(DTOCabeceraRanking dtocabecera){
    Date hoy = new Date();
    Date ahora = new Date();
    DateFormat fechahoy = new SimpleDateFormat("dd/MM/yyyy");
    DateFormat hora = new SimpleDateFormat("HH:mm:ss");
    jLabel8.setText(fechahoy.format(desdefecha));
    jLabel10.setText(fechahoy.format(hastafecha));
    jLabel5.setText(fechahoy.format(hoy));
    jLabel6.setText(hora.format(ahora));
    
    Vector<String> tableHeaders = new Vector<String>();
        
        Vector tableData = new Vector();
        String descuentostring;
        tableHeaders.add("Puesto");
        tableHeaders.add("Proveedor");
        tableHeaders.add("Código Proveedor");
        tableHeaders.add("Descuento Total%");
        Integer i = 1;
        DecimalFormat decimal = new DecimalFormat("0.00");
        for(DTORankingProveedor dtolist : dtocabecera.getM_DTORankingProveedorlist()){
            descuentostring = decimal.format(dtolist.getTotalDescuento());
            Vector<Object> onerow = new Vector<Object>();
            onerow.add(i); i++;
            onerow.add(dtolist.getNombreProveedor());
            onerow.add(dtolist.getCodigoProveedor());
            onerow.add(descuentostring+"%");
            tableData.add(onerow);
           
        }
        jTable1.setModel(new DefaultTableModel(tableData, tableHeaders));


}


}
