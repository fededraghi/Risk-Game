package gui;

import controllers.LabelMapListener;
import utils.GameObserver;
import exceptions.PendingOperationsException;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import risiko.Country;
import risiko.Phase;
import risiko.Game;
import risiko.GameInvocationHandler;
import risiko.GameProxy;
import risiko.players.Player;
import utils.BasicGameObserver;

/**
 * @author andrea
 */
public class GUI extends JFrame implements GameObserver {

    //private Game game;
    private GameProxy game;
    private final Map<Color, String> colorCountryNameMap;
    private final Map<String, JLabel> countryLabelMap;
    private DefenseDialog defenseArmies;
    private CardBonusDialog cardBonusDialog;
    private AttackerDialog attackerDialog;
    private DiceDialog diceDialog;

    public GUI(Map<String, String> players, Map<String, String> playersColor) throws Exception {
        initBackground();
        initComponents();
        labelMap.setIcon(new javax.swing.ImageIcon(ImageIO.read(new File("images/risiko.png"))));
        countryLabelMap = new HashMap<>();
        colorCountryNameMap = readColorTextMap("files/ColorCountry.txt");
        init(players, playersColor);
    }

    private void initBackground() {
        BufferedImage backgroundImage;
        try {
            backgroundImage = ImageIO.read(new File("images/background.jpg"));
            this.setContentPane(new BackgroundPane(backgroundImage));
        } catch (IOException ex) {
            System.out.println("loginBackground.png not found");
        }
    }

    /**
     * Inizializza la gui e il game.
     *
     * @throws IOException
     * @throws Exception
     */
    private void init(Map<String, String> players, Map<String, String> playersColor) throws IOException, Exception {
        // Labels
        initLabels("files/labelsTerritori.txt");
        mapLayeredPane.setComponentZOrder(labelMap, mapLayeredPane.getComponentCount() - 1);
        labelAdvice.setText("Clicca su un tuo territorio per rinforzarlo con 1 armata");
        labelAdvice.setFont(new Font("Serif", Font.PLAIN, 13));

        // Game
        game = (GameProxy) Proxy.newProxyInstance(GameProxy.class.getClassLoader(),
                new Class<?>[]{GameProxy.class},
                new GameInvocationHandler(new Game(players, playersColor, this)));

        // Mouse Listeners
        LabelMapListener labelMapListener = new LabelMapListener(labelMap, colorCountryNameMap, game, this);
        labelMap.addMouseListener(labelMapListener);
        labelMap.addMouseMotionListener(labelMapListener);

        // Dialogs
        defenseArmies = new DefenseDialog(game, this, true);
        attackerDialog = new AttackerDialog(game, this, true);
        diceDialog = new DiceDialog(game, this, true);
        cardBonusDialog = new CardBonusDialog(game);

        // Setting
        Dimension dim = getToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getWidth() / 2, dim.height / 2 - this.getHeight() / 2);
    }

    /**
     * Inizializza i labels
     *
     * @param src
     * @throws IOException
     */
    private void initLabels(String src) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(src))) {
            String line;
            String[] tokens;
            int x, y;
            while ((line = br.readLine()) != null) {
                tokens = line.split("\t");
                x = Integer.parseInt(tokens[0].split(",")[0]);
                y = Integer.parseInt(tokens[0].split(",")[1]);
                createLabel(tokens[1], x, y);
            }

        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }
    }

    /**
     * Crea un label e lo aggiunge a <code>countryLabelMap</code>.
     *
     * @param countryName
     * @param x
     * @param y
     */
    private void createLabel(String countryName, int x, int y) {

        JLabel label = new JLabel();
        label.setFont(new Font("Serif", Font.BOLD, 16));
        label.setBounds(x, y, 30, 30);
        //label.setOpaque(true);
        //label.setBackground(new Color(255, 255, 255, 100));
        mapLayeredPane.add(label);
        mapLayeredPane.setComponentZOrder(label, 1);
        countryLabelMap.put(countryName, label);
    }

    /**
     * Ritorna la jlabel corrispondente al territorio di nome
     * <code>country</code>.
     *
     * @param country
     * @return
     */
    public JLabel getLabelByCountry(String country) {
        return countryLabelMap.get(country);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelPlayerPhase = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaInfo = new javax.swing.JTextArea();
        buttonAttack = new javax.swing.JButton();
        buttonNextPhase = new javax.swing.JButton();
        buttonMoreInfo = new javax.swing.JButton();
        mapLayeredPane = new javax.swing.JLayeredPane();
        labelMap = new GraphicsJLabel();
        labelAdvice = new javax.swing.JLabel();
        buttonShowMission = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        settingsItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1400, 650));
        setPreferredSize(new java.awt.Dimension(1400, 650));

        labelPlayerPhase.setBackground(new java.awt.Color(225, 207, 218));
        labelPlayerPhase.setForeground(new java.awt.Color(1, 1, 1));

        textAreaInfo.setColumns(20);
        textAreaInfo.setRows(5);
        jScrollPane1.setViewportView(textAreaInfo);

        buttonAttack.setText("attack");
        buttonAttack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAttackActionPerformed(evt);
            }
        });

        buttonNextPhase.setText("nextPhase");
        buttonNextPhase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNextPhaseActionPerformed(evt);
            }
        });

        buttonMoreInfo.setText("MoreInfo");
        buttonMoreInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMoreInfoActionPerformed(evt);
            }
        });

        mapLayeredPane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        mapLayeredPane.setLayer(labelMap, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout mapLayeredPaneLayout = new javax.swing.GroupLayout(mapLayeredPane);
        mapLayeredPane.setLayout(mapLayeredPaneLayout);
        mapLayeredPaneLayout.setHorizontalGroup(
            mapLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelMap)
        );
        mapLayeredPaneLayout.setVerticalGroup(
            mapLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelMap)
        );

        buttonShowMission.setText("ShowMission");
        buttonShowMission.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonShowMissionActionPerformed(evt);
            }
        });

        jMenu1.setText("Settings");

        settingsItem.setText("AISettings");
        settingsItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingsItemActionPerformed(evt);
            }
        });
        jMenu1.add(settingsItem);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelPlayerPhase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelAdvice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(mapLayeredPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonShowMission, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonMoreInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonNextPhase, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonAttack, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 1251, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelPlayerPhase, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelAdvice, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonShowMission, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonMoreInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonNextPhase, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(buttonAttack, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(mapLayeredPane))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Mostra un JOptioPane con tutte le informazioni sul gioco
     *
     * @param evt
     */
    private void buttonMoreInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMoreInfoActionPerformed

    }//GEN-LAST:event_buttonMoreInfoActionPerformed

    /**
     * Passa alla fase successiva del gioco
     *
     * @param evt
     */
    private void buttonNextPhaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNextPhaseActionPerformed
        //System.out.println(javax.swing.SwingUtilities.isEventDispatchThread());
        //((GraphicsJLabel) labelMap).resetCone();

        try {
            game.nextPhase();
        } catch (PendingOperationsException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        //repaint();
    }//GEN-LAST:event_buttonNextPhaseActionPerformed

    /**
     * Inizia un attacco se sono già stati selezionati attaccante e difensore
     *
     * @param evt
     */
    private void buttonAttackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAttackActionPerformed
        // controllo in game per il giocatore artificiale??
        if (game.getPhase().equals(Phase.FIGHT)) {
            if (game.getAttackerCountryName() != null && game.getDefenderCountryName() != null) {
                attackerDialog.setVisible(true);
                //diceDialog.setVisible(false);
            }
        }
    }//GEN-LAST:event_buttonAttackActionPerformed

    /**
     * Mostra la missione del giocatore di turno
     *
     * @param evt
     */
    private void buttonShowMissionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonShowMissionActionPerformed
        JOptionPane.showMessageDialog(null, game.getActivePlayerMission());
    }//GEN-LAST:event_buttonShowMissionActionPerformed

    /**
     * Mostra la Dialog per la gestione dei settings del player artificiale
     */
    private void settingsItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingsItemActionPerformed
        SettingsDialog settings = new SettingsDialog(this, true, game);
        settings.setVisible(true);
    }//GEN-LAST:event_settingsItemActionPerformed

    /**
     * Creazione di una map<Color,String> a partire da un file di testo
     * contenente un numero a piacere di linee, dove ogni linea contiene un
     * [token] avente la forma: [token] -> [Country] = [RGB] [Country] ->
     * qualsiasi sequenza di caratteri ASCII diversi dal carattere = e
     * interruzioni di linea [RGB] -> [R],[G],[B] [R] -> un numerCountryo intero
     * da 0 a 255 [G] -> un numero intero da 0 a 255 [B] -> un numero intero da
     * 0 a 255.
     */
    private static Map<Color, String> readColorTextMap(String relativeURL) throws FileNotFoundException {
        Map<Color, String> map = new HashMap<>();
        try (Scanner scanner = new Scanner(new FileReader(relativeURL))) {
            while (scanner.hasNextLine()) {
                String[] tokens = scanner.nextLine().split("=");
                String[] RGB = tokens[1].split(",");
                String country = tokens[0];
                int R = Integer.parseInt(RGB[0].trim());
                int G = Integer.parseInt(RGB[1].trim());
                int B = Integer.parseInt(RGB[2].trim());
                Color color = new Color(R, G, B);
                map.put(color, country);
            }
        }
        return map;
    }

    /**
     * Aggiorna <code> textAreaInfo</code> e <code>labelAdvice</code> dopo che
     * la country <code>countryName</code> è stata rinforzata.
     *
     * @param countryName
     * @param bonusArmies
     */
    @Override
    public void updateOnReinforce(String countryName, int bonusArmies) {

        String s;
        s = "Hai rinforzato " + countryName + ".\n ";
        if (bonusArmies == 0) {
            s += "Fase di rinforzo conlusa.\n";
        } else {
            s += "Ti rimangono " + bonusArmies + " armate.\n";
        }
        this.textAreaInfo.setText(s);
    }

    /**
     * Aggiorna <code>textAreaInfo</code> e <code>labelAdvice</code> quando
     * cambia la fase del gioco.
     *
     * @param player
     * @param phase
     */
    @Override
    public void updateOnPhaseChange(String player, String phase, String color) {
        ((GraphicsJLabel) labelMap).resetCone();
        this.labelPlayerPhase.setText(player + " " + phase);
        this.labelPlayerPhase.setForeground(DefaultColor.valueOf(color.toUpperCase()).getColor());
        this.textAreaInfo.setText("");
        switch (phase) {
            case "REINFORCE":
                labelAdvice.setText("Clicca su un tuo territorio per rinforzarlo con 1 armata");
                break;
            case "FIGHT":
                labelAdvice.setText("Clicca su un tuo territorio per sceglierlo come attaccante");
                break;
            case "MOVE":
                labelAdvice.setText("Scegli un tuo territorio da cui spostare una o più armate");
                break;
        }
    }

    /**
     * Aggiorna <code>textAreaInfo</code> e <code>labelAdvice</code> quando è
     * stato scelto il territorio da cui attaccare.
     *
     * @param countryName
     */
    @Override
    public void updateOnSetAttacker(String countryName, int maxArmiesAttacker) {
        ((GraphicsJLabel) labelMap).resetCone();
        if (countryName != null) {
            this.textAreaInfo.setText("Attaccante : " + countryName);
            labelAdvice.setText("Clicca su un territorio confinante per sceglierlo come difensore");
            attackerDialog.setMaxArmies(maxArmiesAttacker);
        } else {
            this.textAreaInfo.setText("");
            labelAdvice.setText("Clicca su un tuo territorio per sceglierlo come attaccante");
        }
    }

    /**
     * Aggiorna  <code>textAreaInfo</code> e <code>labelAdvice</code> quando è
     * stato scelto il territorio da attaccare. Aggiorna anche i valori di
     * massimo numero di armate dell'attaccante/difensore per preparare il
     * jspinner dell'AttackDialog.
     *
     * @param countryAttackerName
     * @param countryDefenderName
     * @param defenderPlayer
     * @param maxArmiesAttacker
     * @param maxArmiesDefender
     */
    @Override
    public void updateOnSetDefender(String countryAttackerName, String countryDefenderName, String defenderPlayer, int maxArmiesAttacker, int maxArmiesDefender, boolean reattack) {
        ((GraphicsJLabel) labelMap).drawCone(countryLabelMap.get(countryAttackerName).getBounds(), countryLabelMap.get(countryDefenderName).getBounds());

        if (countryDefenderName != null) {
            String s = "Attaccante : " + countryAttackerName + "\n";
            s += "Difensore : " + countryDefenderName + " ( " + defenderPlayer + " ).\n";
            this.textAreaInfo.setText(s);
            labelAdvice.setText("Clicca su attack per iniziare l'attacco(oppure clicca un territorio confinate per cambiare il territorio in difesa)");
        } else { //non viene chiamata da resetFightingCountries, non gli passiamo mai null
            this.textAreaInfo.setText("");
            labelAdvice.setText("Clicca su un tuo territorio per sceglierlo come attaccante");
        }
        //this.inputArmies.setMaxArmies(maxArmiesAttacker, maxArmiesDefender);
        this.defenseArmies.setMaxArmies(maxArmiesDefender);
        if (reattack) {
            this.attackerDialog.setVisible(true);
        }
        //repaint();
        repaint(textAreaInfo, labelAdvice);
    }

    /**
     * Aggiorna <code>textAreaInfo</code> e <code>labelAdvice</code> quando è
     * stato scelto il territorio da cui attaccare.
     *
     * @param countryName
     */
    @Override
    public void updateOnSetFromCountry(String countryName) {
        //((GraphicsJLabel) labelMap).Cone();
        if (countryName != null) {
            this.textAreaInfo.setText("Territorio di partenza : " + countryName);
            labelAdvice.setText("Clicca su un territorio confinante per sceglierlo come destinazione");
        } else {
            this.textAreaInfo.setText("");
            labelAdvice.setText("Scegli un tuo territorio da cui spostare una o più armate");
        }
    }

    /**
     * Aggiorna  <code>textAreaInfo</code> e <code>labelAdvice</code> una volta
     * concluso l'attacco e mostra la <code>diceDialog</code>
     *
     * @param attackResultInfo
     * @param isConquered
     * @param canAttackFromCountry
     * @param maxArmiesAttacker
     * @param maxArmiesDefender
     * @param attackerDice
     * @param defenderDice
     */
    @Override
    public void updateOnAttackResult(String attackResultInfo, boolean isConquered, boolean canAttackFromCountry, int maxArmiesAttacker, int maxArmiesDefender, int[] attackerDice, int[] defenderDice, boolean[] artificialAttack, boolean hasAlreadyDrawnCard) {
        if (!artificialAttack[0]) {
            diceDialog.setHasAlreadyDrawnCard(hasAlreadyDrawnCard);
            diceDialog.setArtificialAttacker(artificialAttack[1]);
            diceDialog.setIsConquered(isConquered);
            diceDialog.setCanAttackFromCountry(canAttackFromCountry);
            diceDialog.setDefenderCountryName(game.getDefenderCountryName());
            diceDialog.updateDice(attackerDice, defenderDice);
            diceDialog.setAttackerCountryName(game.getAttackerCountryName());
            diceDialog.showDice();
            diceDialog.setVisible(true);
        }
        // resetFightingCountruiesd se artificial attack

        textAreaInfo.setText(attackResultInfo);
        defenseArmies.setMaxArmies(maxArmiesDefender);
        labelAdvice.setText("Clicca su un tuo territorio per sceglierlo come attaccante");

    }

    /**
     * Cancella i coni e resetta le stringhe visualizzate
     */
    public void resetAfterAttack() {
        repaint(textAreaInfo, labelAdvice);
        ((GraphicsJLabel) labelMap).resetCone();
    }

    /**
     * Mostra un messaggio di vittoria e chiude il gioco
     *
     * @param winner
     */
    @Override
    public void updateOnVictory(String winner) {
        JOptionPane.showMessageDialog(null, "Complimenti " + winner + " hai vinto!");
        this.dispose();
        System.exit(0);
        // etc
        // bisogna bloccare i run dei giocatori artificiali
    }

    /**
     * Aggiorna le etichette dei dopo l'assegnazione iniziale delle armate.
     *
     * @param countries
     * @param armies
     * @param colors
     */
    @Override
    public void updateOnCountryAssignment(String[] countries, int[] armies, String[] colors) {
        int i = 0;
        for (String country : countries) {
            updateOnArmiesChange(country, armies[i], colors[i]);
            i++;
        }
    }

    /**
     * Aggiorna l'etichetta del territorio <code>country</code> quando cambia il
     * numero di armate.
     *
     * @param country
     * @param armies
     * @param color
     */
    @Override
    public void updateOnArmiesChange(String country, int armies, String color) {
        String colorToString = color;
        JLabel label = countryLabelMap.get(country);
        label.setForeground(Color.WHITE);
        label.setText(Integer.toString(armies));
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setIcon(new ImageIcon("files/images/labelCountry/" + colorToString + "label1.png"));

        repaint(label);
    }

    /**
     * Mostra la finestra di gestione delle carte
     */
    @Override
    public void updateOnNextTurn() {
        cardBonusDialog.initImagesPanel();
        cardBonusDialog.initButtonPanel();
        cardBonusDialog.setVisible(true);
    }

    /**
     * Setta la carta vinta in <code>diceDialog</code>
     *
     * @param cardName
     */
    @Override
    public void updateOnDrawnCard(String cardName) {
        diceDialog.setDrawnCard(cardName);
    }

    /**
     * Chiama Component.repaint() sui components passati come parametro del
     * metodo.
     *
     * @param components
     */
    private void repaint(Component... components) {
        for (Component c : components) {
            c.repaint();
        }
    }

    /**
     * Se il giocatore è reale viene richiamata una dialog che chiede al
     * difensore con quante armate difendersi per completare l'attacco
     *
     * @param defender
     * @param countryDefender
     * @param attacker
     * @param countryAttacker
     * @param nrA
     * @param isArtificialPlayer
     */
    @Override
    public void updateOnDefend(String defender, String countryDefender, String attacker, String countryAttacker, int nrA, boolean isArtificialPlayer) {
        if (!isArtificialPlayer) {
            this.defenseArmies.setVisible(true);
        }
    }

    @Override
    public void updateOnElimination(String defenderName, boolean artificialAttack) {
        if (!artificialAttack) {
            JOptionPane.showMessageDialog(null, defenderName + " sei stato eliminato dal gioco");
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAttack;
    private javax.swing.JButton buttonMoreInfo;
    private javax.swing.JButton buttonNextPhase;
    private javax.swing.JButton buttonShowMission;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelAdvice;
    private javax.swing.JLabel labelMap;
    private javax.swing.JLabel labelPlayerPhase;
    private javax.swing.JLayeredPane mapLayeredPane;
    private javax.swing.JMenuItem settingsItem;
    private javax.swing.JTextArea textAreaInfo;
    // End of variables declaration//GEN-END:variables

}