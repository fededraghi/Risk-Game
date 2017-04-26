/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package risiko;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author alessandro
 */
public class Gui extends JFrame {

    Game game;

    //sono da inserire i vari elementi grafici, gli eventi che richiamano game, l'aggiornamento dello stato del gioco
    //gli elementi che potrebbero servire sono :
    //2 combobox per selezionare attacco e difesa, 
    //1 bottone per attaccare, 
    //un textfield o combobox per il numero di armate,
    //un bottone per passare il turno,
    //un label per il giocatore 
    //una textarea per le informazioni
    //Per aggiungere le armate bonus, clicchi su attacckerList finchè armateBonus del giocatore non arriva a zero.
    /**
     * Creates new form Gui
     *
     * @param game istanza del gioco
     */
    public Gui(Game game) {
        initComponents();
        this.game = game;
        init();

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
        playerPhase = new javax.swing.JLabel();
        nextPhaseButton = new javax.swing.JButton();
        attackerList = new javax.swing.JComboBox<>();
        defenderList = new javax.swing.JComboBox<>();
        attackButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        gameStatus = new javax.swing.JTextArea();
        infoCombAtt = new javax.swing.JLabel();
        infoCombDef = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        attackResult = new javax.swing.JTextArea();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setPreferredSize(new java.awt.Dimension(1250, 725));

        playerPhase.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        playerPhase.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        nextPhaseButton.setText("nextPhase");
        nextPhaseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextPhaseButtonActionPerformed(evt);
            }
        });

        attackerList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attackerListActionPerformed(evt);
            }
        });

        defenderList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                defenderListActionPerformed(evt);
            }
        });

        attackButton.setText("attack");
        attackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attackButtonActionPerformed(evt);
            }
        });

        gameStatus.setColumns(20);
        gameStatus.setFont(new java.awt.Font("Monospaced", 0, 16)); // NOI18N
        gameStatus.setRows(5);
        jScrollPane1.setViewportView(gameStatus);

        infoCombAtt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        infoCombAtt.setText("seleziona un tuo territorio");

        infoCombDef.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        infoCombDef.setText("seleziona territorio avversario");

        attackResult.setColumns(20);
        attackResult.setRows(5);
        jScrollPane2.setViewportView(attackResult);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(playerPhase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(infoCombAtt, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(infoCombDef, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(defenderList, 0, 141, Short.MAX_VALUE)
                                    .addComponent(attackerList, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                                .addComponent(attackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nextPhaseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(playerPhase, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(infoCombAtt)
                    .addComponent(attackerList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(defenderList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(infoCombDef)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(attackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nextPhaseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(52, 52, 52))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * é abilitato solo se giocatore non artificiale e se è nella fase attacco e
     * ha finito quella di rinforzo
     *
     * @param evt
     * @author Alessandro
     */
    private void nextPhaseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextPhaseButtonActionPerformed
        game.nextPhase();
        update();
    }//GEN-LAST:event_nextPhaseButtonActionPerformed

    /**
     * Controlla la fase: -rinforzo: Chiama game.controlPlayer e se ok Chiama
     * game.reinforce(country,1) dove country è scelto dalla lista, il controllo
     * è fatto da reinforce -attacco: Chiama controlAttacker e deseleziona il
     * country fa uscire un pop up di avvertimento
     *
     * @author Alessandro
     */
    private void attackerListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attackerListActionPerformed
        if (this.attackerList.getSelectedIndex() > -1) {
            if (game.getPhase().equals(Phase.REINFORCE)) {
                if (!game.controlAttacker((String) this.attackerList.getSelectedItem())) {
                    this.attackerList.setSelectedIndex(-1);
                } else if (!game.reinforce((String) this.attackerList.getSelectedItem(), 1)) {
                    this.attackResult.setText("non ci sono più armate disponibili da assegnare");
                    this.attackerList.setSelectedIndex(-1);
                }
            } else if (game.getPhase().equals(Phase.FIGHT)) {
                if (!game.controlAttacker((String) this.attackerList.getSelectedItem())) {
                    this.attackerList.setSelectedIndex(-1);
                }
            }
        }
        update();;
    }//GEN-LAST:event_attackerListActionPerformed

    /**
     * Controlla che ci siano i territori selezionati, lancia il dialog per
     * prendere i numeri delle armate che saranno Jspinner controllati che ti
     * fanno metter al massimo il numero dio armate ch epuoi mettere, prende i
     * due territori, i numeri e chiama il metodo attack di game
     *
     * @param evt
     * @author Alessandro
     */
    private void attackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attackButtonActionPerformed
        if (game.getPhase().equals(Phase.FIGHT)) {
            if (this.attackerList.getSelectedIndex() > -1 && this.defenderList.getSelectedIndex() > -1) {
                JDialog inputArmies = new JDialog();
                JPanel dialogPanel = new JPanel(new GridLayout(0, 2));
                JLabel attackText = new JLabel("n armate attaccco");
                JLabel defenseText = new JLabel("n armate difesa");
                SpinnerNumberModel attackModel = new SpinnerNumberModel(1, 1, game.getMaxArmies((String) attackerList.getSelectedItem(), true), 1);
                SpinnerNumberModel defenseModel = new SpinnerNumberModel(1, 1, game.getMaxArmies((String) defenderList.getSelectedItem(), false), 1);
                JSpinner attackArmies = new JSpinner(attackModel);
                JSpinner defenseArmies = new JSpinner(defenseModel);
                JButton execute = new JButton("Esegui");
                execute.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        game.attack((String) attackerList.getSelectedItem(), (String) defenderList.getSelectedItem(), (int) attackArmies.getValue(), (int) defenseArmies.getValue());
                        attackResult.setText(game.getAttackResult().toString());
                        update();
                        String attackerCountry = (String) attackerList.getSelectedItem();
                        if (game.getAttackResult().isIsConquered()) {
                            JOptionPane.showMessageDialog(null, "Complimenti, il terriotorio in difesa è stato conquistato.");
                            inputArmies.dispose();
                            return;
                        }
                        if (!game.canAttackFromCountry(attackerCountry)) {
                            JOptionPane.showMessageDialog(null, "Non è più possibile effettuare attacchi da questo territorio.");
                            inputArmies.dispose();
                            return;
                        }
                        attackArmies.setModel(new SpinnerNumberModel(1, 1, game.getMaxArmies((String) attackerList.getSelectedItem(), true), 1));
                        defenseArmies.setModel(new SpinnerNumberModel(1, 1, game.getMaxArmies((String) defenderList.getSelectedItem(), false), 1));
                    }
                });
                dialogPanel.add(attackText);
                dialogPanel.add(defenseText);
                dialogPanel.add(attackArmies);
                dialogPanel.add(defenseArmies);
                dialogPanel.add(execute);
                inputArmies.add(dialogPanel);
                inputArmies.setModal(true);
                inputArmies.setSize(600, 300);
                inputArmies.setVisible(true);
            }
            this.attackerList.setSelectedIndex(-1);
            this.defenderList.setSelectedIndex(-1);
        }
    }//GEN-LAST:event_attackButtonActionPerformed

    /**
     *
     * dopo aver controllato che il territorio non sia dell'activeplayer, sia
     * confinate con l'attacker(se non lo è deselziono l'elemento selezionato e
     * selziono quello vuoto di default)
     *
     * @author Alessandro
     */
    private void defenderListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_defenderListActionPerformed
        if (game.getPhase().equals(Phase.FIGHT)) {
            if (this.attackerList.getSelectedIndex() > -1) {
                if (!game.controlDefender((String) this.attackerList.getSelectedItem(), (String) this.defenderList.getSelectedItem())) {
                    this.defenderList.setSelectedIndex(-1);
                }
            }
        } else {
            this.defenderList.setSelectedIndex(-1);
        }
        //update();
    }//GEN-LAST:event_defenderListActionPerformed

    /**
     * Riempie la textarea e il label del giocatore in cui ci sono nome
     * giocatore, fase gioco, risultato ultima azione riempie l'altro label con
     * attackresult
     *
     * @author Alessandro
     *
     */
    private void update() {
        String format;
        format = "%1$-30s %2$-15s %3$s";
        this.gameStatus.setText(String.format(format, "territorio", "proprietario", "numero armate") + "\n");//"territorio\t\tproprietario\t\tnumero armate\n");
        //format=""
        for (Entry<Country, Player> e : game.getCountryPlayer().entrySet()) {
            this.gameStatus.append(String.format(format, e.getKey().getName(), e.getValue().getName(), e.getKey().getArmies()) + "\n");
            //this.gameStatus.append(e.getKey().getName() + "\t\t" + e.getValue().getName() + "\t\t" + e.getKey().getArmies() + "\n");
        }
        this.gameStatus.setCaretPosition(0);
        this.playerPhase.setText(game.getInfo());
        if (game.getAttackResult() != null) {
            this.attackResult.setText(game.getAttackResult().toString());
        }
    }

    /**
     * Riempie le combo box
     *
     * @author Alessandro
     */
    private void init() {
        //crea il modello con la lista dei territori
        DefaultComboBoxModel cma = new DefaultComboBoxModel(game.getCountryNameList());
        DefaultComboBoxModel cmd = new DefaultComboBoxModel(game.getCountryNameList());
        this.attackerList.setModel(cma);
        this.defenderList.setModel(cmd);
        update();
        this.attackerList.setSelectedIndex(-1);
        this.defenderList.setSelectedIndex(-1);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton attackButton;
    private javax.swing.JTextArea attackResult;
    private javax.swing.JComboBox<String> attackerList;
    private javax.swing.JComboBox<String> defenderList;
    private javax.swing.JTextArea gameStatus;
    private javax.swing.JLabel infoCombAtt;
    private javax.swing.JLabel infoCombDef;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton nextPhaseButton;
    private javax.swing.JLabel playerPhase;
    // End of variables declaration//GEN-END:variables
}
