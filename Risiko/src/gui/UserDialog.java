/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Base64;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.scene.paint.Color.rgb;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

/**
 *
 * @author Elisa
 */
public class UserDialog extends javax.swing.JDialog {

    private StartGameGUI gui;
    private int index;
    private List<String> players;

    /**
     * Creates new form RegistrationDialog
     *
     * @param gui
     */
    public UserDialog(StartGameGUI gui) {
        this.gui = gui;
        initComponents();
        commentsText.setEditable(false);
        commentsText.setBackground(new Color(240, 240, 240));
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowClosed(WindowEvent e) {
                gui.setVisible(true);
            }

            @Override
            public void windowOpened(WindowEvent e) {
            }

            @Override
            public void windowClosing(WindowEvent e) {
            }

            @Override
            public void windowIconified(WindowEvent e) {
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
            }

            @Override
            public void windowActivated(WindowEvent e) {
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
            }

        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        usernameText = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        password2Label = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        saveUserButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        commentsText = new javax.swing.JTextArea();
        loginButton = new javax.swing.JButton();
        passwordText = new javax.swing.JPasswordField();
        password2Text = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Username");

        jLabel2.setText("Password");

        password2Label.setText("Ripeti la password");

        titleLabel.setText("Registrazione utente");

        saveUserButton.setText("Registra");
        saveUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveUserButtonActionPerformed(evt);
            }
        });

        commentsText.setColumns(20);
        commentsText.setRows(5);
        jScrollPane1.setViewportView(commentsText);

        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
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
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(password2Label)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(usernameText, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                            .addComponent(password2Text)
                            .addComponent(passwordText))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(saveUserButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)
                            .addComponent(loginButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 28, Short.MAX_VALUE))
                    .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(usernameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(passwordText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(loginButton)
                        .addGap(9, 9, 9)
                        .addComponent(saveUserButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(password2Label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(password2Text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Bottone per salvare il nuovo utente
     * @param evt 
     */
    private void saveUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveUserButtonActionPerformed
        if (usernameText.getText().length() == 0 || passwordText.getText().length() == 0 || password2Text.getText().length() == 0) {
            commentsText.setText("Per registrare il giocatore è necessario\ncompilare tutti i campi");
            return;
        } 
        if (!passwordText.getText().equals(password2Text.getText())) {
            commentsText.setText("Le password inserite non coincidono");
            return;
        } 
        
        if (checkUsernameInFile(usernameText.getText())) {
            try {
                registerUser(usernameText.getText(), passwordText.getText());
            } catch (IOException ex) {
                Logger.getLogger(UserDialog.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                JOptionPane.showMessageDialog(null, "Utente " + usernameText.getText() + " inserito correttamente");
                this.setVisible(false);
                gui.setVisible(true);
            }
        } else {
            commentsText.setText("Username già utilizzato");
        }

    }//GEN-LAST:event_saveUserButtonActionPerformed

    /**
     * Bottone per fare la login
     * @param evt 
     */
    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        String url = "files/players.txt";
        String username = usernameText.getText();
        String password = passwordText.getText();
        if (checkUsername(username)) {
            try (BufferedReader br = new BufferedReader(new FileReader(url))) {
                String line;

                while ((line = br.readLine()) != null) {
                    String[] tmp = line.split(";");
                    byte[] encryptedBytes = tmp[1].getBytes();
                    byte[] decryptedBytes = Base64.getDecoder().decode(encryptedBytes);
                    String decryptedString = new String(decryptedBytes, "UTF-8");
                    if (tmp[0].equals(username) && decryptedString.equals(password)) {
                        this.setVisible(false);
                        gui.setPlayerName(username, getIndex());
                        gui.setVisible(true);
                        return;
                    }

                }

            } catch (FileNotFoundException ex) {
                System.out.println("File not found");
            } catch (IOException ex) {
                Logger.getLogger(UserDialog.class.getName()).log(Level.SEVERE, null, ex);
            }

            commentsText.setText("Nome giocatore o password errati");
        } else {
            commentsText.setText("Giocatore già presente nel gioco");
        }

    }//GEN-LAST:event_loginButtonActionPerformed

    /**
     * Salva nel file players.txt lo username e la password criptata 
     * @param username
     * @param password
     * @throws IOException 
     */
    private void registerUser(String username, String password) throws IOException {
        Base64.Encoder encoder = Base64.getEncoder();
        byte[] encryptedBytes = encoder.encode(password.getBytes());
        String encryptedString = new String(encryptedBytes, "UTF-8");        
        try (PrintWriter out = new PrintWriter(new FileOutputStream("files/players.txt", true))) {
            out.println(username + ";"+encryptedString);
            
        }

    }

    /**
     * Imposta il JDialog in modo che si vedano le informazioni relative alla 
     * registrazione o alla login
     * @param isRegistration 
     */
    public void setRegistrationMode(boolean isRegistration) {
        if (isRegistration) {
            password2Text.setVisible(true);
            loginButton.setVisible(false);
            password2Label.setVisible(true);
            saveUserButton.setVisible(true);
            titleLabel.setText("Registrazione");
        } else {
            password2Text.setVisible(false);
            password2Label.setVisible(false);
            saveUserButton.setVisible(false);
            loginButton.setVisible(true);
            titleLabel.setText("Login");
        }
        commentsText.setText("");
        passwordText.setText("");
        password2Text.setText("");
        usernameText.setText("");
    }

    /**
     * Setta l'indice del player da cui è stata richiesta la login
     * @param index 
     */
    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * Ritorna l'indice del player che ha richiesto la login
     * @return 
     */
    private int getIndex() {
        return index;
    }

    /**
     * Setta la lista dei players già loggati nel gioco
     * @param list 
     */
    public void setPlayers(List<String> list) {
        this.players = list;
    }

    /**
     * Controlla se lo username inserito è già presente tra quelli degli utenti
     * loggati; se si ritorna false
     * @param username
     * @return 
     */
    private boolean checkUsername(String username) {
        for (String s : players) {
            if (s.equals(username)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Controlla se lo username scelto per registrarsi è già stato inserito
     * nel file dei players
     * @param username
     * @return 
     */
    private boolean checkUsernameInFile(String username) {
        String url = "files/players.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(url))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] tmp = line.split(";");
                if (tmp[0].equals(username)) {
                    return false;
                }

            }

        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            Logger.getLogger(UserDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea commentsText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel password2Label;
    private javax.swing.JPasswordField password2Text;
    private javax.swing.JPasswordField passwordText;
    private javax.swing.JButton saveUserButton;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JTextField usernameText;
    // End of variables declaration//GEN-END:variables

}
