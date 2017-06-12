package tienda;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Tienda extends javax.swing.JFrame implements Runnable{
    
    private boolean login;
    private boolean adminLogin;
    
    private ArchivoTarjeta tArch;
    private ArrayList<Tarjeta> tArray;
    private ControladorTarjeta tCtrl;
    
    private ArchivoAdministrador adminArch;
    private ArrayList<Administrador> adminArray;
    private ControladorAdministrador adminCtrl;
    
    private ArchivoProducto prodArch;
    private ArrayList<Producto> prodArray;
    private ControladorProductos prodCtrl;
    
    LlaveAdmin adminSystem;
    LlaveTarjeta tarjSystem;
    
    public Tienda() {
        initComponents();
        
        login = false;
        adminLogin =false;
        
        tArch = new ArchivoTarjeta("tarjetas");
        tArray = tArch.leerTodos();
        tCtrl = new ControladorTarjeta();
        
        adminArch = new ArchivoAdministrador("archamin");
        adminArray = adminArch.leerTodos();
        adminCtrl = new ControladorAdministrador();
        
        prodArch = new ArchivoProducto("productos");
        prodArray = prodArch.leerTodos();
        prodCtrl = new ControladorProductos();
        
        frmLogin.setSize(frmLogin.getPreferredSize());
        frmLogin.setResizable(false);
        
        setPantallaPrincipalVisible(false);
        
        btnAgregarProducto.setVisible(false);
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
        txtNombreNvProd = new javax.swing.JTextField();
        txtCostoNvProd = new javax.swing.JTextField();
        txtMarcaNvProd = new javax.swing.JTextField();
        btnGuardarProd = new javax.swing.JButton();
        frmNvTarjeta = new javax.swing.JFrame();
        jTextField3 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        frmLogin = new javax.swing.JFrame();
        pswContra = new javax.swing.JPasswordField();
        btnAceder = new javax.swing.JButton();
        btnAdministrador = new javax.swing.JToggleButton();
        lblPantallaLogin = new javax.swing.JLabel();
        frmPrimerUso = new javax.swing.JFrame();
        txtPrimerUsuario = new javax.swing.JTextField();
        pswPrimerContra = new javax.swing.JPasswordField();
        btnGuardarPrimero = new javax.swing.JButton();
        btnComprar = new javax.swing.JButton();
        btnDetalles = new javax.swing.JButton();
        btnAgregarProducto = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        lblPuntos = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblPantalla = new javax.swing.JLabel();
        lblPantallaInicio = new javax.swing.JLabel();

        txtNombreNvProd.setText("nombre");

        txtCostoNvProd.setText("costo");

        txtMarcaNvProd.setText("marca");

        btnGuardarProd.setText("jButton1");
        btnGuardarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarProdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout frmNvProductoLayout = new javax.swing.GroupLayout(frmNvProducto.getContentPane());
        frmNvProducto.getContentPane().setLayout(frmNvProductoLayout);
        frmNvProductoLayout.setHorizontalGroup(
            frmNvProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frmNvProductoLayout.createSequentialGroup()
                .addGap(168, 168, 168)
                .addGroup(frmNvProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnGuardarProd)
                    .addGroup(frmNvProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtNombreNvProd, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                        .addComponent(txtCostoNvProd)
                        .addComponent(txtMarcaNvProd)))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        frmNvProductoLayout.setVerticalGroup(
            frmNvProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frmNvProductoLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(txtNombreNvProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(txtMarcaNvProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(txtCostoNvProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(btnGuardarProd)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        frmNvTarjeta.setTitle("Nueva tarjeta");
        frmNvTarjeta.setMinimumSize(new java.awt.Dimension(610, 500));
        frmNvTarjeta.getContentPane().setLayout(null);

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        frmNvTarjeta.getContentPane().add(jTextField3);
        jTextField3.setBounds(220, 130, 170, 20);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tienda/Nuevatarjeta.png"))); // NOI18N
        frmNvTarjeta.getContentPane().add(jLabel1);
        jLabel1.setBounds(0, -10, 620, 510);

        frmLogin.setTitle("Iniciar Sesion");
        frmLogin.setMinimumSize(new java.awt.Dimension(313, 220));
        frmLogin.setPreferredSize(new java.awt.Dimension(313, 220));
        frmLogin.setType(java.awt.Window.Type.UTILITY);
        frmLogin.getContentPane().setLayout(null);

        pswContra.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                pswContraFocusLost(evt);
            }
        });
        pswContra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pswContraActionPerformed(evt);
            }
        });
        frmLogin.getContentPane().add(pswContra);
        pswContra.setBounds(110, 120, 147, 20);

        btnAceder.setText("Entrar");
        btnAceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcederActionPerformed(evt);
            }
        });
        frmLogin.getContentPane().add(btnAceder);
        btnAceder.setBounds(130, 160, 73, 23);

        btnAdministrador.setText("Administrador ");
        btnAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdministradorActionPerformed(evt);
            }
        });
        frmLogin.getContentPane().add(btnAdministrador);
        btnAdministrador.setBounds(178, 11, 101, 23);

        lblPantallaLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tienda/PantallaLogin.png"))); // NOI18N
        lblPantallaLogin.setText("jLabel1");
        frmLogin.getContentPane().add(lblPantallaLogin);
        lblPantallaLogin.setBounds(-10, 0, 320, 200);

        txtPrimerUsuario.setText("usuario");

        btnGuardarPrimero.setText("Guardar");
        btnGuardarPrimero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarPrimeroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout frmPrimerUsoLayout = new javax.swing.GroupLayout(frmPrimerUso.getContentPane());
        frmPrimerUso.getContentPane().setLayout(frmPrimerUsoLayout);
        frmPrimerUsoLayout.setHorizontalGroup(
            frmPrimerUsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, frmPrimerUsoLayout.createSequentialGroup()
                .addContainerGap(117, Short.MAX_VALUE)
                .addGroup(frmPrimerUsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnGuardarPrimero)
                    .addGroup(frmPrimerUsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtPrimerUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                        .addComponent(pswPrimerContra)))
                .addGap(96, 96, 96))
        );
        frmPrimerUsoLayout.setVerticalGroup(
            frmPrimerUsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frmPrimerUsoLayout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(txtPrimerUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(pswPrimerContra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnGuardarPrimero)
                .addContainerGap(99, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(670, 539));
        setResizable(false);
        getContentPane().setLayout(null);

        btnComprar.setText("Comprar");
        btnComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprarActionPerformed(evt);
            }
        });
        getContentPane().add(btnComprar);
        btnComprar.setBounds(540, 490, 73, 20);

        btnDetalles.setText("Detalles");
        getContentPane().add(btnDetalles);
        btnDetalles.setBounds(450, 490, 71, 23);

        btnAgregarProducto.setText("Agregar Producto");
        btnAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregarProducto);
        btnAgregarProducto.setBounds(303, 490, 130, 23);

        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblProductos);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(40, 130, 580, 340);

        lblPuntos.setText("Puntos:");
        getContentPane().add(lblPuntos);
        lblPuntos.setBounds(540, 110, 80, 14);

        lblNombre.setText("Nombre:");
        getContentPane().add(lblNombre);
        lblNombre.setBounds(430, 90, 210, 14);

        lblPantalla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tienda/PantallaUniversal.png"))); // NOI18N
        lblPantalla.setMaximumSize(new java.awt.Dimension(670, 540));
        lblPantalla.setMinimumSize(new java.awt.Dimension(670, 540));
        lblPantalla.setName(""); // NOI18N
        lblPantalla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPantallaMouseClicked(evt);
            }
        });
        getContentPane().add(lblPantalla);
        lblPantalla.setBounds(0, 0, 660, 540);

        lblPantallaInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tienda/ScreenSaver.png"))); // NOI18N
        lblPantallaInicio.setText("jLabel2");
        getContentPane().add(lblPantallaInicio);
        lblPantallaInicio.setBounds(0, 0, 670, 540);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnComprarActionPerformed

    private void pswContraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pswContraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pswContraActionPerformed

    private void pswContraFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pswContraFocusLost
      /*  if(pswContra.getText().length()< 8 || pswContra.getText().length() > 16) {
            JOptionPane.showMessageDialog(frmLogin, "La contraseña debe medir entre 8 y 16 caracteres", "Error", JOptionPane.ERROR_MESSAGE);
            pswContra.setText(""); 
            pswContra.requestFocus();
        }*/
    }//GEN-LAST:event_pswContraFocusLost

    private void btnAcederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcederActionPerformed
        if(! pswContra.getText().isEmpty()) {
            
            String contrasenia = "";
            String contraLlave = "";
            Tarjeta tarjeta = null;
            
            if(!adminLogin) {
                Tarjeta tarjetaLlave = tarjSystem.leerDatos();
                for(Tarjeta tar:tArray) {
                    
                    if(tar.getIdTarjeta().equals(tarjetaLlave.getIdTarjeta())) {
                        contrasenia = tar.getContrasenia();
                        contraLlave = tarjetaLlave.getContrasenia();
                        tarjeta = tar;
                        break;
                    }
                }
            }
            else {
                adminLogin = true;
                Administrador adminLlave = adminSystem.leerDatos();
                for(Administrador admin:adminArray) {
                    
                    if(admin.getUsuario().equals(adminLlave.getUsuario())) {
                        contrasenia = admin.getContrasenia();
                        contraLlave = adminLlave.getContrasenia();
                        break;
                    }
                }      
            }
            
            if(!contrasenia.isEmpty()) {
                
                if(ControladorUsuario.verificarContrasenia(contrasenia, pswContra.getText(), contraLlave)) {
                    login = true;
                    pswContra.setText("");
                    frmLogin.setVisible(false);
                    lblPantallaInicio.setVisible(true);
                    setPantallaPrincipalVisible(true);
                    if(!adminLogin) {
                        lblNombre.setText("Nombre:" + tarjeta.getNombre() + " " +
                            tarjeta.getApPaterno() + " " + tarjeta.getApMaterno());
                        lblPuntos.setText("Puntos: " + tarjeta.getPuntos());
                    }
                    else
                        btnAgregarProducto.setVisible(true);
                    
                }
                else
                    JOptionPane.showMessageDialog(frmLogin, "Contraseña incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else
                JOptionPane.showMessageDialog(frmLogin, "Usuario no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
            }
        else
            JOptionPane.showMessageDialog(frmLogin, "Debe llenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_btnAcederActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void btnGuardarPrimeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarPrimeroActionPerformed
        if(!txtPrimerUsuario.getText().isEmpty() && !pswPrimerContra.getText().isEmpty()) {
            Administrador admin = new Administrador(txtPrimerUsuario.getText(),
                    ControladorAdministrador.crearSeguridad(pswPrimerContra.getText()));
            adminCtrl.crear(admin, adminArch, adminArray);
            File[] paths = File.listRoots();
            int i = 0;
            for(File path:paths) {
                File file = new File(path.toString() + "/Program Files");
                if(!file.exists()) {
                    File folder = new File(paths[paths.length -1].toString() + "/Tarjeta");
                    folder.mkdir();
                    LlaveAdmin llave = new LlaveAdmin(folder);
                    llave.escrbirCodigoAcceso();
                    llave.escribirDatos(admin);
                    adminArch.grabarIdActual(adminArch.obtenerIdActual() + 1);
                    frmPrimerUso.setVisible(false);
                    login = false;
                    break;
                }
                i++;
            }
            if(i == paths.length) {
                JOptionPane.showMessageDialog(frmPrimerUso,"Inserte un USB");
                adminArch.eliminar();
                adminArray.clear();
            }
        }
        else {
            JOptionPane.showMessageDialog(frmPrimerUso, "Debe llenar todos los campos", "Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarPrimeroActionPerformed

    private void btnAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdministradorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdministradorActionPerformed

    private void btnAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoActionPerformed
        txtNombreNvProd.setText("");
        txtCostoNvProd.setText("");
        txtMarcaNvProd.setText("");
        frmNvProducto.setVisible(true);
    }//GEN-LAST:event_btnAgregarProductoActionPerformed

    private void btnGuardarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarProdActionPerformed
        if(!txtNombreNvProd.getText().isEmpty() &&
                !txtMarcaNvProd.getText().isEmpty() &&
                !txtCostoNvProd.getText().isEmpty()) {
            if(isDataValid()) {
                Producto producto = new Producto(txtNombreNvProd.getText(),
                        txtMarcaNvProd.getText(), Float.valueOf(txtCostoNvProd.getText()));
                prodCtrl.crear(producto, prodArch, prodArray);
                DefaultTableModel tabla = (DefaultTableModel) tblProductos.getModel();
                addToTable(producto, tabla);
                frmNvProducto.setVisible(false);
            }
        }
        else
            JOptionPane.showMessageDialog(frmNvProducto, "Debe llenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_btnGuardarProdActionPerformed

    private void lblPantallaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPantallaMouseClicked
         if(!frmLogin.isVisible() || !frmLogin.isActive())
            frmLogin.setVisible(true);
    }//GEN-LAST:event_lblPantallaMouseClicked
    
    private void setPantallaPrincipalVisible(boolean visible) {
        jScrollPane1.setVisible(visible);
        btnComprar.setVisible(visible);
        btnDetalles.setVisible(visible);
        tblProductos.setVisible(visible);
        lblPantalla.setVisible(visible);
        lblNombre.setVisible(visible);
        lblPuntos.setVisible(visible);
    }
    
    private boolean isDataValid() {
        if(frmNvProducto.isVisible()) {
            try
            {
                float f = Float.valueOf(txtCostoNvProd.getText());
                return true;
            }
            catch(NumberFormatException e) {
                JOptionPane.showMessageDialog(frmNvProducto, "El costo debe ser un número", "Error", JOptionPane.ERROR_MESSAGE);
                txtCostoNvProd.setText("");
            }
        }
        return false;
    }
    
    private void addToTable(Producto prod, DefaultTableModel model)
    {
        String[] nuevoProducto = {prod.getCodigo(), prod.getNombre(),
            prod.getMarca(), Float.toString(prod.getCosto())};
        model.addRow(nuevoProducto);
    }
    
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        Tienda tienda = new Tienda();
        tienda.setSize(tienda.getPreferredSize());
        tienda.setVisible(true);
        tienda.run();
    }
    
    @Override
    public void run() {
        try
        {
            System.out.println("Main thread");
            
            if(adminArch.numeroDeRegistros() == 0) {
                String usuario = adminArch.obtenerIdActual() + "";
                while(usuario.length() < 8)
                    usuario = "0" + usuario;
                txtPrimerUsuario.setText(usuario);
                txtPrimerUsuario.setEditable(false);
                frmPrimerUso.setVisible(true);
                login = true;
            }

            boolean fileFound = false;
            while(fileFound == false){

                Thread.sleep(2000);

                File[] paths = File.listRoots();

                for(File path:paths) {
                    File llave = new File(path.toString() + "/Tarjeta","batman.dmc");
                    File usuario = new File(path.toString() + "/Tarjeta","robin.dmc");

                    if(llave.exists() && usuario.exists()) {
                        //System.out.println("Tajeta Encontrada");
                        File carpeta = new File(path.toString() + "/Tarjeta");
                        
                        LlaveAdmin admin = new LlaveAdmin(carpeta);
                        LlaveTarjeta tarj = new LlaveTarjeta(carpeta);
                        
                        if("Administrador".equals(admin.leerCodigo())) {
                            Administrador administrador = admin.leerDatos();
                            for(Administrador a:adminArray) {
                                if(a.getUsuario().equals(administrador.getUsuario()) &&
                                        a.getContrasenia().equals(administrador.getContrasenia()) &&
                                        a.getNumDeRegistro() == administrador.getNumDeRegistro()) {
                                    fileFound = true;
                                    adminLogin = true;
                                    adminSystem = new LlaveAdmin(carpeta);
                                    break;
                                }
                            }
                        }
                        else if("Tarjeta de Lealtad".equals(tarj.leerDatos())) {
                            Tarjeta tarjeta = tarj.leerDatos();
                            for(Tarjeta t:tArray) {
                                if(t.getApMaterno().equals(tarjeta.getApMaterno()) &&
                                        t.getApPaterno().equals(tarjeta.getApPaterno()) &&
                                        t.getNombre().equals(tarjeta.getNombre()) &&
                                        t.getContrasenia().equals(tarjeta.getContrasenia()) &&
                                        t.getNumeroDeRegistro() == tarjeta.getNumeroDeRegistro() &&
                                        t.getIdTarjeta().equals(tarjeta.getIdTarjeta())) {
                                    fileFound = true;
                                    tarjSystem = new LlaveTarjeta(carpeta);
                                    break;
                                } 
                            }
                        }
                        //    System.out.println("Tarjeta Valida");
                      //  else
                         //  System.out.println("Tarjeta No Valida");
                    }
                   // else {
                      //  System.out.println("Tarjeta No Encontrada");
                  //  }
                }
            }

        } catch (InterruptedException ex) {
            Logger.getLogger(Tienda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceder;
    private javax.swing.JToggleButton btnAdministrador;
    private javax.swing.JButton btnAgregarProducto;
    private javax.swing.JButton btnComprar;
    private javax.swing.JButton btnDetalles;
    private javax.swing.JButton btnGuardarPrimero;
    private javax.swing.JButton btnGuardarProd;
    private javax.swing.JFrame frmLogin;
    private javax.swing.JFrame frmNvProducto;
    private javax.swing.JFrame frmNvTarjeta;
    private javax.swing.JFrame frmPrimerUso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPantalla;
    private javax.swing.JLabel lblPantallaInicio;
    private javax.swing.JLabel lblPantallaLogin;
    private javax.swing.JLabel lblPuntos;
    private javax.swing.JPasswordField pswContra;
    private javax.swing.JPasswordField pswPrimerContra;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTextField txtCostoNvProd;
    private javax.swing.JTextField txtMarcaNvProd;
    private javax.swing.JTextField txtNombreNvProd;
    private javax.swing.JTextField txtPrimerUsuario;
    // End of variables declaration//GEN-END:variables

/*    private static void pruebaTarjetaAgregarSinGUI() {
               
       
        ArchivoTarjeta arch_tarjetas = new ArchivoTarjeta("tarjetas");
        ArrayList<Tarjeta> tarjetas_array = arch_tarjetas.leerTodos();
        ControladorTarjeta ctrl_tarjetas = new ControladorTarjeta();
        
        String contra = ControladorTarjeta.crearContrasenia("mari100317");
                
        Tarjeta t = new Tarjeta("Michel", "Garcia", "Maricruz", contra);
        ctrl_tarjetas.crear(t, arch_tarjetas,tarjetas_array);

        Tarjeta t2 = arch_tarjetas.leerRegistro(t.getNumeroDeRegistro());
        System.out.println(t2.getApPaterno());
        System.out.println(t2.getApMaterno());
        System.out.println(t2.getNombre());
        System.out.println(t2.getIdTarjeta());
        System.out.println(t2.getPuntos());
        System.out.println(t2.getNumeroDeRegistro());
        System.out.println(t2.getContrasenia());
        
        if(ControladorTarjeta.verificarContrasenia(t2.getContrasenia(), "mari100417"))
            System.out.println("Son iguales");
        else
            System.out.println("Son diferentes");
                

        Tarjeta t3 = tarjetas_array.get(t.getNumeroDeRegistro());
        System.out.println(t3.getApPaterno());
        System.out.println(t3.getApMaterno());
        System.out.println(t3.getNombre());
        System.out.println(t3.getIdTarjeta());
        System.out.println(t3.getPuntos());
        System.out.println(t3.getNumeroDeRegistro());
        System.out.println(t3.getContrasenia());
        if(ctrl_tarjetas.verificarContrasenia(t3.getContrasenia(), "mari100317"))
            System.out.println("Son iguales");
        
        ctrl_tarjetas.eliminar(tarjetas_array.get(5), arch_tarjetas, tarjetas_array);
        
        for(Tarjeta t5:tarjetas_array) {
            System.out.println(t5.getIdTarjeta());
            System.out.println(t5.getNumeroDeRegistro());
        }
        
        ArrayList<Tarjeta> array = arch_tarjetas.leerTodos();
        for(Tarjeta t6:array) {
            System.out.println(t6.getIdTarjeta());
            System.out.println(t6.getNumeroDeRegistro());
        }
    }
    
    private static void defaultAdmin() {
        ArchivoAdministrador aa = new ArchivoAdministrador("archamin");
        ArrayList<Administrador> array = new ArrayList<>();
        ControladorAdministrador ca = new ControladorAdministrador();
                
        String contra = ControladorAdministrador.crearContrasenia("1234");
        Administrador ad = new Administrador("0", contra);
        
        ca.crear(ad, aa, array);
        
        
    }
*/
}
