package rayground.client;


import rayground.Engine;

import javax.swing.*;
import java.awt.*;
import java.awt.image.RenderedImage;

public class SwingClient {

    private static final int WIDTH = 1600;
    private static final int HEIGHT = 900;

    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeAndWait(new Runnable() {
            @Override
            public void run() {
                Image image = (Image) Engine.renderSync();

                JFrame frame = new JFrame("Raytracer Demo");
                frame.add(new JLabel(new ImageIcon(image)));
                frame.pack();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}
