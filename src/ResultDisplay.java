import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ResultDisplay extends JFrame {
    static final String SVG_PATH = "resources/europe.svg";

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
