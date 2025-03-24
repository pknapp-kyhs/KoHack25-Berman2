import java.awt.Font;
import java.awt.event.*;

import javax.swing.*;

public class ResultDisplay extends JFrame {
    static final String SVG_PATH = "resources/europe.svg";
    static final String INFO_STRING = "Additional Minahgim \n\n\ndata coming soon";

    //the constructor of the result window
    public ResultDisplay(Quiz quiz) {
        super("Your Quiz Results");

        //sort the quiz results
        SortElement[] results = Results.getSortedResults(quiz);
        //set up the main panel of the frame
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        //set up the map
        Map map = new Map(SVG_PATH);
        map.setColors(results);
        mainPanel.add(map);

        //set up the panel of top 3 matches
        JPanel leaderBoard = new JPanel();
        leaderBoard.setLayout(new BoxLayout(leaderBoard, BoxLayout.X_AXIS));
        //get top 3, and add them
        for (int i = 0; i < 3; i++) {
            leaderBoard.add(sortElementToPanel(results[i]));
        }
        //makes a button to go to a page where you can learn more
        JButton button = new JButton("Learn More");
        //listner for press
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //removes previous stuff
                remove(mainPanel);
                //add text
                JTextArea text = new JTextArea(INFO_STRING);
                add(text);
                //for some reason this works and repaint() doesn't, without it the text is off screen
                setSize(599,399);
                setSize(600,400);
            }
        });
        leaderBoard.add(button);
        mainPanel.add(leaderBoard);
        add(mainPanel);
    }

    //starts up and displays the result window
    public void start() {
        setSize(600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    //turns a sortElement into a Jpanel that shows the percentage match of that location
    public JPanel sortElementToPanel(SortElement element) {
        //makes panel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        
        //makes a bold label for the country name
        JLabel country = new JLabel(element.text + ":");
        country.setFont(new Font("Arial",Font.BOLD,16));
        //limits match percentage to 100%
        if (element.value/Map.WEIGHT > 1.0) {
            element.value = (int) Map.WEIGHT;
        }
        //makes a label for the percentage
        JLabel value = new JLabel(Integer.toString((int) ((element.value/Map.WEIGHT) * 100)) + "%");
        value.setFont(new Font("Arial",Font.PLAIN,12));
        //finish output panel
        panel.add(country);
        panel.add(value);
        return panel;
    }
}