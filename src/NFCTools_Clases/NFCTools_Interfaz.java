package NFCTools_Clases;


import NFCTools_Utils.TerminalUtils;
import NFCTools_Clases.KeyManagerDialog;
import NFCTools_Utils.KeysUtils;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.smartcardio.CardException;
import javax.swing.JOptionPane;
import org.nfctools.NfcAdapter;
import org.nfctools.io.NfcDevice;
import org.nfctools.scio.Terminal;
import org.nfctools.scio.TerminalMode;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author David
 */
public class NFCTools_Interfaz extends javax.swing.JFrame {

    
    private NfcDevice nfcDevice;
    private NfcAdapter nfcAdapter;
    private final HashSet<String> keys;
    /**
     * Creates new form NFCTools_Interfaz
     * @throws java.io.IOException
     */
    public NFCTools_Interfaz() throws IOException {
        initComponents();
        IniciarFrame();
        keys = new HashSet<String>();
		KeysUtils.addStandardKeys(keys);
    }
    
    public final void IniciarFrame () throws IOException
    {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);       
        //setIconImage(new ImageIcon (getClass().getResource("Licencias_Icon.png")).getImage());                                
    }
    
    private void connectReader() {
		if (nfcDevice != null) {
			Terminal terminal = (Terminal) nfcDevice;
			nfcAdapter = new NfcAdapter(terminal, TerminalMode.INITIATOR);
			//nfcAdapter.registerTagListener(nfcTagListener);
			nfcAdapter.startListening();
			Menu_Conectar.setEnabled(false);
			Menu_Desconectar.setEnabled(true);
			Text_Lector.setText(terminal.getTerminalName());
			//lblStatuslabel.setText("Place a Tag Over the Reader");
			Boton_Leer.setEnabled(true);
			Boton_Escribir.setEnabled(true);		
		}
    }
    
    private void selectDevice() {
			List<String> terminals;
			try {
				terminals = TerminalUtils.getAvailableTerminals();
				String readerSelected = (String) JOptionPane.showInputDialog(
						this, "Lectores:", "Selecciona un lector!",
						JOptionPane.QUESTION_MESSAGE, null,
						terminals.toArray(), null);
				if (readerSelected != null) {
					nfcDevice = TerminalUtils
							.getAvailableTerminal(readerSelected);
				}
			} catch (CardException e) {
				if (e.getMessage().equals("list() failed"))
					JOptionPane.showMessageDialog(this, "No se encontraron dispositivos",
							"Error", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}

		}
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Boton_Leer = new javax.swing.JButton();
        Boton_Escribir = new javax.swing.JButton();
        Boton_Llaves = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Text_Lector = new javax.swing.JLabel();
        Text_Tag = new javax.swing.JLabel();
        Text_Llaves = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Area_Resultados = new javax.swing.JTextArea();
        Boton_TomarFoto = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        Menu_Conectar = new javax.swing.JMenuItem();
        Menu_Desconectar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Boton_Leer.setText("Leer");
        Boton_Leer.setEnabled(false);
        Boton_Leer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Boton_LeerMouseClicked(evt);
            }
        });

        Boton_Escribir.setText("Escribir");
        Boton_Escribir.setEnabled(false);
        Boton_Escribir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Boton_EscribirMouseClicked(evt);
            }
        });

        Boton_Llaves.setText("Llaves");
        Boton_Llaves.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Boton_LlavesMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Informacion del lector");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Info Tag");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("No. de Llaves");

        Text_Lector.setText("N/A");

        Text_Tag.setText("N/A");

        Text_Llaves.setText("N/A");

        Area_Resultados.setColumns(20);
        Area_Resultados.setRows(5);
        jScrollPane1.setViewportView(Area_Resultados);

        Boton_TomarFoto.setText("Tomar Foto");
        Boton_TomarFoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Boton_TomarFotoMouseClicked(evt);
            }
        });

        jMenu1.setText("Archivo");

        Menu_Conectar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        Menu_Conectar.setText("Conectar");
        Menu_Conectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_ConectarActionPerformed(evt);
            }
        });
        jMenu1.add(Menu_Conectar);

        Menu_Desconectar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        Menu_Desconectar.setText("Desconectar");
        Menu_Desconectar.setEnabled(false);
        jMenu1.add(Menu_Desconectar);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(Boton_Leer)
                            .addGap(18, 18, 18)
                            .addComponent(Boton_Escribir)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Boton_TomarFoto))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(30, 30, 30)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(Text_Tag)))
                                .addComponent(Text_Lector))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Text_Llaves)
                                .addComponent(jLabel3))
                            .addGap(48, 48, 48)
                            .addComponent(Boton_Llaves)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Boton_Leer)
                    .addComponent(Boton_Escribir)
                    .addComponent(Boton_TomarFoto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Text_Tag)
                            .addComponent(Text_Lector)))
                    .addComponent(Boton_Llaves)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Text_Llaves)))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Boton_TomarFotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Boton_TomarFotoMouseClicked
        

        
    }//GEN-LAST:event_Boton_TomarFotoMouseClicked

    private void Boton_EscribirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Boton_EscribirMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Boton_EscribirMouseClicked

    private void Boton_LeerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Boton_LeerMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Boton_LeerMouseClicked

    private void Boton_LlavesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Boton_LlavesMouseClicked

        KeyManagerDialog llaves;
        try {
            new KeyManagerDialog(keys).setVisible(true);
            Text_Llaves.setText(keys.size() + "");
        } catch (IOException ex) {
            Logger.getLogger(NFCTools_Interfaz.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_Boton_LlavesMouseClicked

    private void Menu_ConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_ConectarActionPerformed
        
        //connectReader();
        selectDevice();
    }//GEN-LAST:event_Menu_ConectarActionPerformed

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
            java.util.logging.Logger.getLogger(NFCTools_Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NFCTools_Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NFCTools_Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NFCTools_Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new NFCTools_Interfaz().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(NFCTools_Interfaz.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Area_Resultados;
    private javax.swing.JButton Boton_Escribir;
    private javax.swing.JButton Boton_Leer;
    private javax.swing.JButton Boton_Llaves;
    private javax.swing.JButton Boton_TomarFoto;
    private javax.swing.JMenuItem Menu_Conectar;
    private javax.swing.JMenuItem Menu_Desconectar;
    private javax.swing.JLabel Text_Lector;
    private javax.swing.JLabel Text_Llaves;
    private javax.swing.JLabel Text_Tag;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
