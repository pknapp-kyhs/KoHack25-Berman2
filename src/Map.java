import com.kitfox.svg.*;
import com.kitfox.svg.animation.AnimationElement;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.net.URI;
import java.util.HashMap;

public class Map extends JPanel {
    //initialize the denominator used in determining the weight of all colors needed
    public static final double weight = 3.0;

    SVGDiagram diagram;

    //set up a hashmap to turn country names to their codes in the svg
    public static HashMap<String, String> map;
    static {
        map = new HashMap<>();
        String[] keys = Results.countries;
        String[] values = {"DE","LT","PL","FR","UA","IT","NL"};
        for (int i = 0; i < keys.length; i++) {
            map.put(keys[i], values[i]);
        }

    }

    public Map(String path) {
        try {
            //open svg file
            SVGUniverse universe = new SVGUniverse();
            URI svgURI = new File(path).toURI();
            diagram = universe.getDiagram(svgURI);
        } catch (Exception e) {
        }
    }

    //a method to turn the completed SortElement array into colors
    public void setColors(SortElement[] elements) {
        for (SortElement element : elements) {
            changeRegionColor(map.get(element.text), Color.RED, element.value/weight);
        }
    }

    //a method to change the color of a svg region
    public void changeRegionColor(String id, Color color, double opacity) {
        if (opacity > 1) {
            opacity = 1;
        }
        try {
            SVGElement element = diagram.getElement(id);
            if (element != null) {
                //format string as a series of 3 2 digit hex codes, for color
                String hex = String.format("#%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());
                //set fill color
                element.addAttribute("fill",AnimationElement.AT_CSS,hex);
                element.addAttribute("fill-opacity", AnimationElement.AT_CSS, Double.toString(opacity));
                //update svg to apply change
                diagram.updateTime(0);
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //overides the default rendering method to show map
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graph = (Graphics2D) g;
        try {
            diagram.render(graph);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
