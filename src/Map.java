import com.kitfox.svg.*;
import com.kitfox.svg.animation.AnimationElement;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.net.URI;
import java.util.HashMap;

public class Map extends JPanel {
    //initialize the denominator used in determining the weight of all colors needed
    public static final double WEIGHT = 7.0;
    public static final int COLORWEIGHT = (255/7);

    SVGDiagram diagram;

    //set up a hashmap to turn country names to their codes in the svg
    public static HashMap<String, String> map;
    static {
        map = new HashMap<>();
        String[] keys = Results.countries;
        String[] values = {"DE","LT","PL","FR","UA","IT","NL"};
        //add all pairs to the hashmap
        for (int i = 0; i < keys.length; i++) {
            map.put(keys[i], values[i]);
        }
    }


    public Map(String path) {
        //set background color
        setBackground(new Color(220,220,255));
        try {
            //open svg file, and store it as a diagram in diagram
            SVGUniverse universe = new SVGUniverse();
            URI svgURI = new File(path).toURI();
            diagram = universe.getDiagram(svgURI);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //a method to turn the completed SortElement array into colors
    public void setColors(SortElement[] elements) {
        //itterate through all countries
        for (SortElement element : elements) {
            //draw each color with an opacity porportinal to the value^2
            setRegionColor(map.get(element.text), new Color(255,0,255), Math.pow(element.value/WEIGHT, 2));
        }
    }

    //a method to set the color of a svg region
    public void setRegionColor(String id, Color color, double opacity) {
        //filter input
        if (opacity > 1) {
            opacity = 1;
        }
        try {
            //get the element of the particular country
            SVGElement element = diagram.getElement(id);
            if (element != null) {
                //format string as a series of 3 2 digit hex codes, for color
                String hex = String.format("#%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());
                //set fill color
                element.addAttribute("fill",AnimationElement.AT_CSS,hex);
                //set opacity
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