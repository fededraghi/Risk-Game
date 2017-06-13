/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.mainGui.cards;

import controllers.CardListener;
import gui.PlayAudio;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import risiko.game.GameProxy;

/**
 *
 * @author feded
 */
public class CardPanel extends javax.swing.JPanel {

    private List<JLabel> cards;
    private List<JLabel> chosenCards;
    private GameProxy game;
    private JButton playTris;
    private final int LOW_Y = 530;
    private final int HIGH_Y = 330;
    
    public int getLOW_Y() {
        return LOW_Y;
    }

    public int getHIGH_Y() {
        return HIGH_Y;
    }
    
    public CardPanel(GameProxy game) {
        this.cards = new ArrayList<>();
        this.chosenCards = new ArrayList<>();
        this.game = game;
        initComponents();

        //playTrisButton
        playTris = new JButton();
        playTris.setText("Gioca il tris");
        playTris.setVisible(false);
        playTris.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                playTrisActionPerformed(evt);
            }
        });
        this.add(playTris);
        playTris.setBounds(1015, 100, 250, 50);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cardsPane = new javax.swing.JLayeredPane();

        cardsPane.setMaximumSize(new java.awt.Dimension(1000, 300));
        cardsPane.setMinimumSize(new java.awt.Dimension(1000, 300));

        javax.swing.GroupLayout cardsPaneLayout = new javax.swing.GroupLayout(cardsPane);
        cardsPane.setLayout(cardsPaneLayout);
        cardsPaneLayout.setHorizontalGroup(
            cardsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        cardsPaneLayout.setVerticalGroup(
            cardsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(cardsPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 312, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cardsPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    private void playTrisActionPerformed(java.awt.event.ActionEvent evt) {
        game.playTris(getTrisAsString(chosenCards));
        cardsPane.removeAll();
        chosenCards.clear();
        addCardsToPane();
        playTris.setVisible(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane cardsPane;
    // End of variables declaration//GEN-END:variables

    public void setCards(List<String> myCards) {
        
        if(!myCards.isEmpty()){
            PlayAudio.play("sounds/cardFan1.wav");
        }
        cardsPane.removeAll();
        JLabel label;
        cards.clear();
        chosenCards.clear();
        for (String card : myCards) {
            label = new JLabel();
            label.putClientProperty("name", card);
            label.putClientProperty("chosen", false);
            label.setIcon(new ImageIcon("images/" + card + ".png"));
            label.setOpaque(false);
            label.addMouseListener(new CardListener(this,game));
            label.addMouseMotionListener(new CardListener(this, game));
            cards.add(label);
        }

        addCardsToPane();
        addChosenCardsToPane();
        playTris.setVisible(false);
    }

    public void addCardsToPane() {
        int offset = 50;
        for (int i = 0; i < cards.size(); i++) {
            cardsPane.remove(cards.get(i));
            cardsPane.add(cards.get(i), new Integer(-i));
            cards.get(i).setBounds(15 + i * offset, 20, 150, 207);
        }
    }

    public void addChosenCardsToPane() {
        int offset = 50;
        for (int i = 0; i < chosenCards.size(); i++) {
            cardsPane.remove(chosenCards.get(i));
            cardsPane.add(chosenCards.get(i), new Integer(-i));
            chosenCards.get(i).setBounds(670 + i * offset, 20, 150, 207);
        }
    }

    public void switchCard(JLabel label) {
        boolean chosen = (boolean) label.getClientProperty("chosen");
        if (chosen) { // Se era nelle chosen
            chosenCards.remove(label);
            cards.add(label);
            cardsPane.setLayer(label, -(getNrCards() - 1));

        } else {

            chosenCards.add(label);
            cards.remove(label);
            cardsPane.setLayer(label, -(getNrChosenCards() - 1));
        }
        if (checkOnTris(chosenCards)) {
            int bonus = game.getBonusForTris(getTrisAsString(chosenCards));
            playTris.setText("Gioca il tris. (" + bonus + ")");
            playTris.setVisible(true);
        } else {
            playTris.setVisible(false);
        }

        label.putClientProperty("chosen", !chosen);

    }

    public JLayeredPane getCardsPane() {
        return cardsPane;
    }

    public int getNrChosenCards() {
        return chosenCards.size();
    }

    public void moveCard(int x, int y, JLabel card) {
        card.setLocation(x, y);
    }

    public int getLabelLayer(JLabel label) {
        if ((boolean) label.getClientProperty("chosen")) {
            return -chosenCards.indexOf(label);
        }
        return -cards.indexOf(label);
    }

    public int getNrCards() {
        return cards.size();
    }

    /**
     * Ritorna true se le carte selezionate sono un tris valido.
     *
     * @param chosenCards
     * @return
     */
    private boolean checkOnTris(List<JLabel> chosenCards) {
        boolean success = false;
        String[] cards = getTrisAsString(chosenCards);
        if (chosenCards.size() == 3) {
            success = game.canPlayThisTris(cards);
        }
        return success;
    }

    private String[] getTrisAsString(List<JLabel> chosenCards) {
        String[] cards = new String[3];
        for (int i = 0; i < chosenCards.size(); i++) {
            JLabel card = chosenCards.get(i);
            cards[i] = ((String) card.getClientProperty("name")).toUpperCase();
        }
        return cards;
    }

}
