package tienda;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tienda extends javax.swing.JFrame implements Runnable{
    
    public Tienda() {
        initComponents();
        
        frmLogin.setSize(frmLogin.getPreferredSize());
        frmLogin.setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        frmNvProducto = new javax.swing.JFrame();
        frmNvTarjeta = new javax.swing.JFrame();
        frmLogin = new javax.swing.JFrame();
        txtUsuario = new javax.swing.JTextField();
        pswContra = new javax.swing.JPasswordField();
        btnAceder = new javax.swing.JButton();
        bntAdministrador = new javax.swing.JToggleButton();
        lblPantallaLogin = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblPantallaInicio = new javax.swing.JLabel();
        bntComprar = new javax.swing.JButton();
        bntDetalles = new javax.swing.JButton();
        lblPuntos = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblPantalla = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        javax.swing.GroupLayout frmNvProductoLayout = new javax.swing.GroupLayout(frmNvProducto.getContentPane());
        frmNvProducto.getContentPane().setLayout(frmNvProductoLayout);
        frmNvProductoLayout.setHorizontalGroup(
            frmNvProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        frmNvProductoLayout.setVerticalGroup(
            frmNvProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout frmNvTarjetaLayout = new javax.swing.GroupLayout(frmNvTarjeta.getContentPane());
        frmNvTarjeta.getContentPane().setLayout(frmNvTarjetaLayout);
        frmNvTarjetaLayout.setHorizontalGroup(
            frmNvTarjetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        frmNvTarjetaLayout.setVerticalGroup(
            frmNvTarjetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        frmLogin.setTitle("Iniciar Sesion");
        frmLogin.setMinimumSize(new java.awt.Dimension(300, 200));
        frmLogin.setType(java.awt.Window.Type.UTILITY);
        frmLogin.getContentPane().setLayout(null);

        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        frmLogin.getContentPane().add(txtUsuario);
        txtUsuario.setBounds(110, 80, 147, 20);
        frmLogin.getContentPane().add(pswContra);
        pswContra.setBounds(110, 120, 147, 20);

        btnAceder.setText("Entrar");
        frmLogin.getContentPane().add(btnAceder);
        btnAceder.setBounds(130, 160, 73, 23);

        bntAdministrador.setText("Administrador ");
        bntAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntAdministradorActionPerformed(evt);
            }
        });
        frmLogin.getContentPane().add(bntAdministrador);
        bntAdministrador.setBounds(178, 11, 101, 23);

        lblPantallaLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tienda/PantallaLogin.png"))); // NOI18N
        lblPantallaLogin.setText("jLabel1");
        frmLogin.getContentPane().add(lblPantallaLogin);
        lblPantallaLogin.setBounds(-10, 0, 320, 200);

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(660, 540));
        setPreferredSize(new java.awt.Dimension(660, 540));
        setResizable(false);
        setSize(new java.awt.Dimension(570, 376));
        getContentPane().setLayout(null);

        lblPantallaInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tienda/ScreenSaver.png"))); // NOI18N
        lblPantallaInicio.setText("jLabel2");
        getContentPane().add(lblPantallaInicio);
        lblPantallaInicio.setBounds(0, 10, 660, 530);

        bntComprar.setText("Comprar");
        bntComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntComprarActionPerformed(evt);
            }
        });
        getContentPane().add(bntComprar);
        bntComprar.setBounds(540, 490, 73, 20);

        bntDetalles.setText("Detalles");
        getContentPane().add(bntDetalles);
        bntDetalles.setBounds(450, 490, 71, 23);

        lblPuntos.setText("Puntos:");
        getContentPane().add(lblPuntos);
        lblPuntos.setBounds(540, 110, 80, 14);

        lblNombre.setText("Nombre:");
        getContentPane().add(lblNombre);
        lblNombre.setBounds(430, 90, 50, 14);

        lblPantalla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tienda/PantallaUniversal.png"))); // NOI18N
        lblPantalla.setName(""); // NOI18N
        getContentPane().add(lblPantalla);
        lblPantalla.setBounds(0, 0, 660, 520);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Id", "Nombre", "Marca", "Costo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(40, 130, 580, 340);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bntAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntAdministradorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bntAdministradorActionPerformed

    private void bntComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntComprarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bntComprarActionPerformed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

       Tienda tienda = new Tienda();
       tienda.setSize(tienda.getPreferredSize());
       tienda.setVisible(true);
       tienda.run();
    }
    
    public void run() {
        try
        {
            System.out.println("Main thread");
            boolean fileFound = false;
            while(fileFound == false){
                
                Thread.sleep(2000);

                File[] paths = File.listRoots();

                for(File path:paths) {
                    File tarjeta = new File(path.toString() + "/Tarjeta","Tarjeta.dmc");

                    if(tarjeta.exists()) {
                        System.out.println("Tajeta Encontrada");
                        
                        if(Controlador1.tarjetaValida(tarjeta)) {
                            fileFound = true;
                            System.out.println("Tarjeta Valida");
                            break;
                        }
                        else
                            System.out.println("Tarjeta No Valida");
                    }
                    else {
                        System.out.println("Tarjeta No Encontrada");
                    }
                }
            }
            
            frmLogin.setVisible(true);
            

        } catch (InterruptedException ex) {
            Logger.getLogger(Tienda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton bntAdministrador;
    private javax.swing.JButton bntComprar;
    private javax.swing.JButton bntDetalles;
    private javax.swing.JButton btnAceder;
    private javax.swing.JFrame frmLogin;
    private javax.swing.JFrame frmNvProducto;
    private javax.swing.JFrame frmNvTarjeta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPantalla;
    private javax.swing.JLabel lblPantallaInicio;
    private javax.swing.JLabel lblPantallaLogin;
    private javax.swing.JLabel lblPuntos;
    private javax.swing.JPasswordField pswContra;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
