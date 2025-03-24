import com.kitfox.svg.*;
import com.kitfox.svg.animation.AnimationElement;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.net.URI;

public class Map extends JPanel {
    SVGDiagram diagram;

    public Map(String path) {
        try {
            //open svg file
            SVGUniverse universe = new SVGUniverse();
            URI svgURI = new File("europe.svg").toURI();
            diagram = universe.getDiagram(svgURI);
        } catch (Exception e) {
        }
    

    }

    //a method to change the color of a svg region
    public void changeRegionColor(String id, Color color) {
        try {
            SVGElement element = diagram.getElement(id);
            if (element != null) {
                //format string as a series of 3 2 digit hex codes, for color
                String hex = String.format("#%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());
                //set fill color
                element.setAttribute("fill",AnimationElement.AT_CSS,hex);
                element.addAttribute("fill-opacity", AnimationElement.AT_CSS, "0.5");
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
