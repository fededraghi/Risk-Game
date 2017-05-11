package gui;

import exceptions.PendingOperationsException;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import risiko.Country;
import risiko.Phase;
import risiko.Game;
import risiko.Player;

/**
 * @author andrea
 */
public class GUI extends JFrame implements GameObserver {

    private Game game;
    private final Map<Color, String> colorCountryNameMap;
    private AttackDialog inputArmies;

    public GUI(Map<String, Boolean> players) throws Exception {
        initComponents();
        game = new Game(players, this);
        colorCountryNameMap = readColorTextMap("src/gui/ColorCountry.txt");
        LabelMapListener labelMapListener = new LabelMapListener(convertToBufferedImage(labelMap), colorCountryNameMap, game);
        labelMap.addMouseListener(labelMapListener);
        labelMap.addMouseMotionListener(labelMapListener);
        inputArmies = new AttackDialog(game);
        labelAdvice.setText("Clicca su un tuo territorio per rinforzarlo con 1 armata");
        //initLabels("files/provaLabels.txt");
        //this.setComponentZOrder(labelMap, getComponentCount() - 1);
    }

    /*private void initLabels(String src) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(src))) {
            System.out.println(getComponentCount());
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

    private void createLabel(String countryName, int x, int y) {
        int xOffset = 10;
        int yOffset = 75;
        JLabel label = new JLabel(countryName);
        label.setBounds(x + xOffset, y + yOffset, 100, 10);
        getContentPane().add(label);
        setComponentZOrder(label, 1);
    }*/
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelMap = new javax.swing.JLabel();
        labelPlayerPhase = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaInfo = new javax.swing.JTextArea();
        buttonAttack = new javax.swing.JButton();
        buttonNextPhase = new javax.swing.JButton();
        buttonMoreInfo = new javax.swing.JButton();
        labelAdvice = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelMap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/mapparisiko.png"))); // NOI18N

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelPlayerPhase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelMap)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(buttonAttack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonNextPhase, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                            .addComponent(buttonMoreInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(labelAdvice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelPlayerPhase, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelAdvice, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelMap)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonMoreInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonNextPhase, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonAttack, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonMoreInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMoreInfoActionPerformed
        String format = "%-30s %-15s %s";
        String info = String.format(format, "territorio", "proprietario", "numero armate") + "\n";
        for (Map.Entry<Country, Player> e : game.getCountryPlayer().entrySet()) {
            info += String.format(format, e.getKey().getName(), e.getValue().getName(), e.getKey().getArmies()) + "\n";
        }
        JOptionPane.showMessageDialog(null, info);
    }//GEN-LAST:event_buttonMoreInfoActionPerformed

    private void buttonNextPhaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNextPhaseActionPerformed
        try {
            game.nextPhase();
        } catch (PendingOperationsException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_buttonNextPhaseActionPerformed

    private void buttonAttackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAttackActionPerformed
        if (game.getPhase().equals(Phase.FIGHT)) {
            if (game.getAttackerCountryName() != null && game.getDefenderCountryName() != null) {
                inputArmies.setVisible(true);
            }
            game.resetFightingCountries();
        }
    }//GEN-LAST:event_buttonAttackActionPerformed

    /**
     * Procedurone per la creazione di una map<Color,String> a partire da un
     * file di testo contenente un numero a piacere di linee, dove ogni linea
     * contiene un [token] avente la forma: [token] -> [Country] = [RGB]
     * [Country] -> qualsiasi sequenza di caratteri ASCII diversi dal carattere
     * = e interruzioni di linea [RGB] -> [R],[G],[B] [R] -> un numerCountryo
     * intero da 0 a 255 [G] -> un numero intero da 0 a 255 [B] -> un numero
     * intero da 0 a 255.
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
     * Metodo necessario per convertire la labelMap in una bufferedMap a causa
     * della GUI che è stata creata con DESIGN
     *
     * @param labelMap
     * @return
     */
    private static BufferedImage convertToBufferedImage(JLabel labelMap) {
        ImageIcon imgIcon = ((ImageIcon) labelMap.getIcon());
        Image image = imgIcon.getImage();
        BufferedImage newImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = newImage.createGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();
        return newImage;
    }

    @Override
    public void updateOnReinforce(String countryName, int bonusArmies) {

        String s;
        s = "Hai rinforzato " + countryName + ".\n ";
        if (bonusArmies == 0) {
            s += "Fase di rinforzo conlusa.\n";
            String s1 = "Clicca nextPhase per continuare il tuo turno";
            this.labelAdvice.setText(s1);
        } else {
            s += "Ti rimangono " + bonusArmies + " armate.\n";
        }
        this.textAreaInfo.setText(s);
    }

    @Override
    public void updateOnPhaseChange(String player, String phase) {
        this.labelPlayerPhase.setText(player + " " + phase);
        this.textAreaInfo.setText("");
        switch (phase) {
            case "REINFORCE":
                labelAdvice.setText("Clicca su un tuo territorio per rinforzarlo con 1 armata");
                break;
            case "FIGHT":
                labelAdvice.setText("Clicca su un tuo territorio per sceglierlo come attaccante");
                break;
        }
    }

    @Override
    public void updateOnSetAttacker(String countryName) {

        if (countryName != null) {
            this.textAreaInfo.setText("Attaccante : " + countryName);
            labelAdvice.setText("Clicca su un territorio confinante per sceglierlo come difensore");
        } else {
            this.textAreaInfo.setText("");
        }
    }

    @Override
    public void updateOnSetDefender(String countryAttackerName, String countryDefenderName, String defenderPlayer, int maxArmiesAttacker, int maxArmiesDefender) {

        if (countryDefenderName != null) {
            String s = "Attaccante : " + countryAttackerName + "\n";
            s += "Difensore : " + countryDefenderName + " ( " + defenderPlayer + " ).\n";
            this.textAreaInfo.setText(s);
            labelAdvice.setText("Clicca su attack per iniziare l'attacco(oppure clicca un territorio confinate per cambiare il territorio in difesa)");
        } else {
            this.textAreaInfo.setText("");
            labelAdvice.setText("Clicca su un tuo territorio per sceglierlo come attaccante");
        }
        this.inputArmies.setMaxArmies(maxArmiesAttacker, maxArmiesDefender);
    }

    @Override
    public void updateOnAttackResult(String attackResultInfo, boolean isConquered, boolean canAttackFromCountry, int maxArmiesAttacker, int maxArmiesDefender) {
        textAreaInfo.setText(attackResultInfo);
        this.inputArmies.setMaxArmiesAttacker(maxArmiesAttacker);
        this.inputArmies.setMaxArmiesDefender(maxArmiesDefender);
        this.inputArmies.setIsConquered(isConquered);
        this.inputArmies.setCanAttackFromCountry(canAttackFromCountry);
        if (isConquered) {
            (new JOptionPane()).showMessageDialog(null, "Complimenti, hai conquistato " + game.getDefenderCountryName());
        }
        labelAdvice.setText("Clicca su un tuo territorio per sceglierlo come attaccante"); 
    }

    @Override
    public void updateOnVictory(String winner) {
        JOptionPane.showMessageDialog(null, "Complimenti " + winner + " hai vinto!");
        //this.dispose();
        // etc
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAttack;
    private javax.swing.JButton buttonMoreInfo;
    private javax.swing.JButton buttonNextPhase;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelAdvice;
    private javax.swing.JLabel labelMap;
    private javax.swing.JLabel labelPlayerPhase;
    private javax.swing.JTextArea textAreaInfo;
    // End of variables declaration//GEN-END:variables

}
