/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Dimension;
import controllers.ColorBoxListener;
import controllers.ChangeTypeListener;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author Elisa
 */
public class StartGameGUI extends JFrame {

    private int nPlayers;
    private JTextField[] playerTexts;
    private JComboBox[] colorBoxes;
    private JLabel[] playerTypes;
    private JButton[] changeTypes;
    private ColorBoxListener cbListener;
    private UserDialog regDialog;
    private JButton[] logins;

    /**
     * Creates new form startGame
     */
    public StartGameGUI() {
        initBackground();
        initComponents();
        initColorBoxes();
        init();
    }

    /**
     * Inizializzazione
     */
    private void init() {

        nPlayers = 2;
        regDialog = new UserDialog(this);
        regDialog.setVisible(false);
        Dimension dim = getToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getWidth() / 2, dim.height / 2 - this.getHeight() / 2);

        playerTexts = new JTextField[]{this.playerText1, this.playerText2, this.playerText3, this.playerText4, this.playerText5, this.playerText6};
        logins = new JButton[]{login1, login2, login3, login4, login5, login6};
        playerTypes = new JLabel[]{playerType1, playerType2, playerType3, playerType4, playerType5, playerType6};
        changeTypes = new JButton[]{changeType1, changeType2, changeType3, changeType4, changeType5, changeType6};

        ChangeTypeListener ctListener = new ChangeTypeListener(playerTexts, logins, changeTypes, playerTypes);
        LoginListener loginListener = new LoginListener(logins, regDialog, this, playerTexts);
        for (int i = 0; i < playerTexts.length; i++) {
            logins[i].setVisible(false);
            changeTypes[i].addActionListener(ctListener);
            logins[i].addActionListener(loginListener);
            if (i > 1) {
                colorBoxes[i].setVisible(false);
                playerTexts[i].setVisible(false);
                changeTypes[i].setVisible(false);
                playerTypes[i].setVisible(false);
            }
        }

        // Setto trasparenti i campi di input di testo (scherzavo)
        Color transparentWhite = new Color(255, 255, 255, 100);
        for (JTextField text : playerTexts) {
            text.setOpaque(false);
            text.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0, 150)));
            /*text.setBackground(transparentWhite);
            text.setCaretColor(transparentWhite);
            text.setDisabledTextColor(transparentWhite);*/
        }

        // Setto le immagini ai bottoni di login
        ImageIcon icon = new ImageIcon("images/loginButton.png");
        for (JButton login : logins) {
            login.setText("");
            login.setSize(icon.getIconWidth(), icon.getIconHeight());
            login.putClientProperty("value", "login");
            login.setBorder(null);
            login.setIcon(icon);
        }

        // Setto le immagini ai bottoni per cambiare tipo di giocatore
        icon = new ImageIcon("images/forwardButton.png");
        for (JButton forward : changeTypes) {
            forward.setText("");
            forward.setSize(icon.getIconWidth(), icon.getIconHeight());
            forward.setBorder(null);
            forward.setIcon(icon);
        }

        // Setto le immagini sugli altri bottoni
        addButton.setIcon(new ImageIcon("images/addButton.png"));
        removeButton.setIcon(new ImageIcon("images/removeButton.png"));
        registrationButton.setIcon(new ImageIcon("images/registrationButton.png"));
        startButton.setIcon(new ImageIcon("images/playButton.png"));

    }

    private void initBackground() {
        BufferedImage backgroundImage;
        try {
            backgroundImage = ImageIO.read(new File("images/loginBackground.png"));
            this.setContentPane(new BackgroundPane(backgroundImage));
        } catch (IOException ex) {
            System.err.println("loginBackground.png not found");
        }
    }

    /**
     * Inizializza i colorBoxes. Setta come modello un array coni nomi dei
     * colori, setta come renderer una JLabel che ha come Icon un rettangolo del
     * colore corrispondente ...
     */
    private void initColorBoxes() {

        colorBoxes = new JComboBox[]{colorBox1, colorBox2, colorBox3, colorBox4, colorBox5, colorBox6};
        DefaultColor[] colors = DefaultColor.values();
        ImageIcon[] icons = new ImageIcon[colors.length];
        String[] names = new String[colors.length];

        // Creo un array di icons (una per colore)
        for (int i = 0; i < icons.length; i++) {
            names[i] = colors[i].toStringLC();
            icons[i] = new ImageIcon("images/" + colors[i].toStringLC() + ".png");
        }

        cbListener = new ColorBoxListener(colorBoxes, names.clone());

        // Setto i colorBoxes
        for (int i = 0; i < colorBoxes.length; i++) {
            JComboBox colorBox = colorBoxes[i];
            colorBox.setModel(new DefaultComboBoxModel(names));
            colorBox.setSelectedItem(names[i]);
            ComboBoxRenderer renderer = new ComboBoxRenderer(icons, names);
            renderer.setPreferredSize(new Dimension(icons[0].getIconWidth(), icons[0].getIconHeight()));
            colorBox.setRenderer(renderer);
            colorBoxes[i].addActionListener(cbListener);
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

        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jToggleButton1 = new javax.swing.JToggleButton();
        playerText1 = new javax.swing.JTextField();
        playerText2 = new javax.swing.JTextField();
        playerText3 = new javax.swing.JTextField();
        playerText4 = new javax.swing.JTextField();
        playerText5 = new javax.swing.JTextField();
        playerText6 = new javax.swing.JTextField();
        startButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        colorBox1 = new javax.swing.JComboBox<>();
        colorBox2 = new javax.swing.JComboBox<>();
        colorBox3 = new javax.swing.JComboBox<>();
        colorBox4 = new javax.swing.JComboBox<>();
        colorBox5 = new javax.swing.JComboBox<>();
        colorBox6 = new javax.swing.JComboBox<>();
        registrationButton = new javax.swing.JButton();
        login1 = new javax.swing.JButton();
        login2 = new javax.swing.JButton();
        login3 = new javax.swing.JButton();
        login4 = new javax.swing.JButton();
        login5 = new javax.swing.JButton();
        login6 = new javax.swing.JButton();
        commentsLabel = new javax.swing.JLabel();
        playerType1 = new javax.swing.JLabel();
        changeType1 = new javax.swing.JButton();
        playerType2 = new javax.swing.JLabel();
        playerType3 = new javax.swing.JLabel();
        playerType4 = new javax.swing.JLabel();
        playerType5 = new javax.swing.JLabel();
        playerType6 = new javax.swing.JLabel();
        changeType2 = new javax.swing.JButton();
        changeType3 = new javax.swing.JButton();
        changeType4 = new javax.swing.JButton();
        changeType5 = new javax.swing.JButton();
        changeType6 = new javax.swing.JButton();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        registrationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrationButtonActionPerformed(evt);
            }
        });

        login2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login2ActionPerformed(evt);
            }
        });

        playerType1.setText("Normale");

        changeType1.setText(">>");

        playerType2.setText("Normale");

        playerType3.setText("Normale");

        playerType4.setText("Normale");

        playerType5.setText("Normale");

        playerType6.setText("Normale");

        changeType2.setText(">>");

        changeType3.setText(">>");

        changeType4.setText(">>");

        changeType5.setText(">>");

        changeType6.setText(">>");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addComponent(registrationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(177, 177, 177))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(commentsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(playerText2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(playerText3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(playerText4, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(playerText5, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(playerText6, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(playerText1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(playerType1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(playerType2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(playerType3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(playerType4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(playerType5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(playerType6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(changeType6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(colorBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(login5, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(changeType2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(colorBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(login2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(changeType3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(colorBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(login3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(changeType4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(colorBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(login4, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(changeType5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(colorBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(login6, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(changeType1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(colorBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(login1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(253, 264, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(178, 178, 178))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(playerText1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(playerText2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(playerType2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(changeType2)
                                .addComponent(colorBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(login2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(playerText3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(playerType3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(changeType3)
                            .addComponent(colorBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(login3))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(playerText4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(playerType4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(changeType4)
                            .addComponent(colorBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(login4))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(playerText5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(playerType5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(changeType5)
                            .addComponent(colorBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(login6))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(playerText6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(playerType6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(changeType6)
                                    .addComponent(colorBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(login5)))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(playerType1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(changeType1)
                        .addComponent(colorBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(login1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(commentsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(registrationButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(80, 80, 80))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Rimuove un giocatore se ci sono più di due giocatori
     *
     * @param evt
     */
    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        if (nPlayers > 2) {
            playerTexts[nPlayers - 1].setVisible(false);
            colorBoxes[nPlayers - 1].setVisible(false);
            logins[nPlayers - 1].setVisible(false);
            changeTypes[nPlayers - 1].setVisible(false);
            playerTypes[nPlayers - 1].setVisible(false);
            nPlayers--;
        }
    }//GEN-LAST:event_removeButtonActionPerformed

    /**
     * Aggiunge un giocatore se non è stato raggiunto il numero massimo di
     * giocatori
     *
     * @param evt
     */
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        if (nPlayers < 6) {
            playerTexts[nPlayers].setVisible(true);
            colorBoxes[nPlayers].setVisible(true);
            changeTypes[nPlayers].setVisible(true);
            playerTypes[nPlayers].setVisible(true);
            nPlayers++;
        }
    }//GEN-LAST:event_addButtonActionPerformed

    /**
     * Inizia la partita se tutti i nomi dei giocatori sono stati inseriti e non
     * si ripetono
     *
     * @param evt
     */
    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        List<String> list = new ArrayList<>();
        for (JTextField playerText : playerTexts) {
            if (playerText.isVisible()) {
                list.add(playerText.getText());
            }
        }

        for (String text : list) {
            if (text.length() == 0) {
                commentsLabel.setText("Inserisci i nomi di tutti i giocatori per iniziare la partita");
                return;
            }
        }

        if (!checkUsername(list)) {
            commentsLabel.setText("I nomi dei giocatori devono essere diversi tra loro");
            return;
        }

        GUI gui;
        Map<String, String> players = new HashMap<>();
        Map<String, String> playersColor = new HashMap<>();
        String[] colors = cbListener.getUpdateColors(list.size());

        for (int i = 0; i < list.size(); i++) {
            players.put(list.get(i), getFormattedName(playerTypes[i].getText().toLowerCase()));
            playersColor.put(list.get(i), colors[i]);
        }
        try {
            gui = new GUI(players, playersColor);
            gui.setVisible(true);
            this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(StartGameGUI.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_startButtonActionPerformed

    /**
     * Permette di registrare un nuovo utente
     *
     * @param evt
     */
    private void registrationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrationButtonActionPerformed
        regDialog.setPlayers(new ArrayList<>());
        regDialog.setRegistrationMode(true);
        regDialog.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_registrationButtonActionPerformed

    private void login2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_login2ActionPerformed

    /**
     * Setta il nome del player nel input e lo rende non editabile; cambia il
     * bottone di login a logout
     *
     * @param username
     * @param index
     */
    public void setPlayerName(String username, int index) {
        playerTexts[index].setText(username);
        playerTexts[index].setEditable(false);
        logins[index].putClientProperty("value", "logout");
        logins[index].setIcon(new ImageIcon("images/logoutButton.png"));
    }

    /**
     * Controlla se non sono stati inseriti username uguali
     *
     * @param players
     * @return
     */
    private boolean checkUsername(List<String> players) {
        Object[] players1 = players.toArray();
        Object[] players2 = players1.clone();
        for (int i = 0; i < players1.length; i++) {
            for (int j = 0; j < players2.length; j++) {
                if (i != j && players1[i].equals(players2[j])) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Formatta la tipologia di giocatore
     *
     * @param type
     * @return
     */
    private String getFormattedName(String type) {
        switch (type) {
            case "loggato":
                return "LOGGED";
            case "normale":
                return "NORMAL";
            case "artificiale":
                return "ARTIFICIAL";
            default:
                return null;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton changeType1;
    private javax.swing.JButton changeType2;
    private javax.swing.JButton changeType3;
    private javax.swing.JButton changeType4;
    private javax.swing.JButton changeType5;
    private javax.swing.JButton changeType6;
    private javax.swing.JComboBox<String> colorBox1;
    private javax.swing.JComboBox<String> colorBox2;
    private javax.swing.JComboBox<String> colorBox3;
    private javax.swing.JComboBox<String> colorBox4;
    private javax.swing.JComboBox<String> colorBox5;
    private javax.swing.JComboBox<String> colorBox6;
    private javax.swing.JLabel commentsLabel;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JButton login1;
    private javax.swing.JButton login2;
    private javax.swing.JButton login3;
    private javax.swing.JButton login4;
    private javax.swing.JButton login5;
    private javax.swing.JButton login6;
    private javax.swing.JTextField playerText1;
    private javax.swing.JTextField playerText2;
    private javax.swing.JTextField playerText3;
    private javax.swing.JTextField playerText4;
    private javax.swing.JTextField playerText5;
    private javax.swing.JTextField playerText6;
    private javax.swing.JLabel playerType1;
    private javax.swing.JLabel playerType2;
    private javax.swing.JLabel playerType3;
    private javax.swing.JLabel playerType4;
    private javax.swing.JLabel playerType5;
    private javax.swing.JLabel playerType6;
    private javax.swing.JButton registrationButton;
    private javax.swing.JButton removeButton;
    private javax.swing.JButton startButton;
    // End of variables declaration//GEN-END:variables

}