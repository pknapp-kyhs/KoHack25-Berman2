import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ResultDisplay extends JFrame {
    static final String SVG_PATH = "resources/europe.svg";

    JPanel mainPanel;
    //the constructor of the result window
    public ResultDisplay(Quiz quiz) {
        super("results");
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        Map map = new Map(SVG_PATH);
        SortElement[] results = Results.getSortedResults(quiz);
        map.setColors(results);
        mainPanel.add(map);

        JPanel leaderBoard = new JPanel();
        leaderBoard.setLayout(new BoxLayout(leaderBoard, BoxLayout.X_AXIS));

        for (int i = 0; i < 3; i++) {
            leaderBoard.add(sortElementToPanel(results[i]));
        }
        mainPanel.add(leaderBoard);

        add(mainPanel);
        setSize(600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public JPanel sortElementToPanel(SortElement element) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        JLabel country = new JLabel(element.text + ":");
        country.setFont(new Font("Arial",Font.BOLD,16));
        if (element.value/Map.WEIGHT > 1.0) {
            element.value = (int) Map.WEIGHT;
        }
        JLabel value = new JLabel(Integer.toString((int) ((element.value/Map.WEIGHT) * 100)) + "%");
        value.setFont(new Font("Arial",Font.PLAIN,12));

        panel.add(country);
        panel.add(value);
        return panel;
    }
}
