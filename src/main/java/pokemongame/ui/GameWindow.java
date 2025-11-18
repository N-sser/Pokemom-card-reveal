package pokemongame.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.Timer;

import pokemongame.logic.GameEngine;
import pokemongame.model.Card;

public class GameWindow {
    private JFrame root;
    private JButton playButton;
    private JPanel cardPanel;
    private List<JButton> cardButtons;
    private GameEngine engine;
    
    public GameWindow(GameEngine e) {
        this.engine = e;
        setupFrame();
        setupPlayButton();
        setupCardPanel();
    }
    
    private void setupFrame() {
        root = new JFrame("Pokemon evolution Cards Game"); 
        root.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        root.setSize(800, 600);
        root.setLayout(new BorderLayout());
        //root.setIconImage(null);
    }

    private void setupPlayButton() {
        playButton = new JButton("Play!");
        playButton.setFont(new Font("Arial", Font.BOLD, 24));
        playButton.addActionListener(e -> { startGame(); });
        root.add(playButton, BorderLayout.NORTH);
    }
    
    private void setupCardPanel() {
        cardPanel = new JPanel();
        cardPanel.setLayout(new GridLayout(2, 4, 10, 10));
        cardPanel.setBackground(Color.white);
        root.add(cardPanel, BorderLayout.CENTER);
    }
    
    private void startGame() {
        System.out.println("Game should've start now huh");
        createCardButtons();
        playButton.setEnabled(false); // Disable
    }
    
    private void createCardButtons() {
        cardPanel.removeAll();
        cardButtons = new ArrayList<>();

        for (int i = 0 ;i < engine.getCards().size(); i++) {
            JButton ButtonCard = new JButton("?");            
            ButtonCard.setFont(new Font("Arial", Font.ITALIC, 24));
            final int index = i;
            ButtonCard.addActionListener(e -> { cardClicked(index); });
            
            cardButtons.add(ButtonCard);
            cardPanel.add(ButtonCard);
        }
        cardPanel.revalidate();
        cardPanel.repaint();
    }
    
    private void cardClicked(int index) {
        Card card = engine.getCards().get(index);
        System.out.println(index + " was clicked");
        
        // Tell the engine to show the card
        engine.revealCard(index);
        
        // UPdate the UI
        cardButtons.get(index).setText(card.getPokemon().getName());
        
        // Check if we have two cards revealed
        if (engine.canCheckMatch()) {
            setButtons(false);
            
            // Check if they match
            boolean isMatch = engine.checkMatch();
            
            if (isMatch) {
                System.out.println("MATCH!");
                if (engine.isGameWon()) {
                    showWinMessage();
                }
                setButtons(true);
            } else {
                System.out.println("NO MATCH!");
                showCardFeedback();
                
                // Wait a lil bit after hiding
                Timer timer = new Timer(1500, e -> {
                    hideUnmatchedCards();
                    setButtons(true);
                });
                timer.setRepeats(false);
                timer.start();
            }
        }
    }
    
    private void setButtons(boolean b) {
        for (JButton c : cardButtons) {
            c.setEnabled(b);
        }
    }

    private void showCardFeedback() {
        List<Card> cards = engine.getCards();
        for (int i = 0; i < cards.size(); i++) {
            Card card = cards.get(i);
            if (card.IsRevealed() && !card.IsMatched()) {
                cardButtons.get(i).setBorder(BorderFactory.createLineBorder(Color.RED, 3));
            }
        }
    }

    private void hideUnmatchedCards() {
        // Hide unmatched cards in the engine
        engine.hideUnmatched();
        
        // Update UI to show "?" for hidden cards
        List<Card> cards = engine.getCards();
        for (int i = 0; i < cards.size(); i++) {
            Card card = cards.get(i);
            if (!card.IsRevealed()) {
                cardButtons.get(i).setText("?");
                cardButtons.get(i).setBorder(UIManager.getBorder("Button.border"));
                }
            }
    }

    private void showWinMessage() {
        JOptionPane.showMessageDialog(
            root,
            "You won! All Pokemon evolved! 🎉\nMatches found: " + engine.getMatchesFound(),
            "Pokemon Master!",
            JOptionPane.INFORMATION_MESSAGE
        );
        playButton.setEnabled(true); // Re-enable play button
    }

    public void show() {
        root.setVisible(true);
    }
}