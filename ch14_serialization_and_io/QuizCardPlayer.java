import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class QuizCardPlayer {
    private JTextArea display;
    private JTextArea answer;
    private ArrayList<QuizCard> cardList;
    private QuizCard currentCard;
    private int currentCardIndex;
    private JFrame frame;
    private JButton nextButton;
    private boolean isShowAnswer;


    public static void main(String[] args) {
        QuizCardPlayer player = new QuizCardPlayer();
        player.go();
    }

    public void go() {
        // build gui
        frame = new JFrame("Quiz Card Player");
        Font bigFont = new Font("sanserif", Font.BOLD, 24);

        display = new JTextArea(10, 20);
        display.setFont(bigFont);

        display.setLineWrap(true);
        display.setLineWrap(false);

        JScrollPane qScroller = new JScrollPane(display);
        qScroller.setVerticalScrollBarPolicy(ScrollBarConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qScroller.setHorizontalScrollBarPolicy(ScrollBarConstants.HORIZONTAL_SCROLLBAR_NEVER);
        nextButton = new JButton("Show Question");
        mainPanel.add(qScroller);
        mainPanel.add(nextButton);
        nextButton.addActionListener(new NextCardListener());

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem loadMenuItem = new JMenuItem("Load card set");
        loadMenuItem.addActionListener(new OpenMenuListener());
        fileMenu.add(loadMenuItem);
        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(640, 500);
        frame.setVisible(true);
    }

    public class NextCardListener implements ActionListener {
        public void actionPerformed(ActionEvent ev);
        if (isShowAnswer) {
            // show the answer because they've already seen the question
            display.setText(currentCard.getAnswer());
            nextButton.setText("Next Card");
            isShowAnswer = false;
        } else {
            // show the next question.
            if (currentCardIndex < cardList.size()) {
                showNextCard();
            } else {
                // there are no more cards to show.
                display.setText("That was the last card.");
                nextButton.setEnabled(false);
            }
        }
    }

    public class OpenMenuListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            JFileChooser fileOpen = new JFileChooser();
            fileOpen.showOpenDialog(frame);
            loadFile(fileOpen.getSelectedFile());
        }
    }

    public void loadFile(File file) {

        cardList = new ArrayList<QuizCard>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = reader.readLine()) != null) {
                makeCard(line);
            }
            reader.close();
        } catch (Exception ex) {
            System.out.println("Couldn't read the card file!");
            ex.printStackTrace();
        }

        // Now it is time ot start by showing the first card.
        showNextCard();
    }

    private void makeCard(String lineToParse) {
        String[] result = lineToParse.split("/");
        // must parse card to show pieces.
        QuizCard card = new QuizCard(result[0], result[1]);
        cardList.add(card);
        System.out.println("Made a card!");
    }

    private void showNextCard() {
        currentCard = cardList.get(currentCardIndex);
        currentCardIndex++;
        display.setText(currentCard.getQuestion());
        nextButton.setText("Show Answer");
        isShowAnswer = true;
    }
}
