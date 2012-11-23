package rayground.swing;


import javax.swing.*;

public class Swing {

    private static final int WIDTH = 1600;
    private static final int HEIGHT = 900;

    public static void main(String[] args) {
        PixelCanvas pixelCanvas = new PixelCanvas(WIDTH, HEIGHT);

        JFrame frame = new JFrame("Raytracer Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(pixelCanvas);
        frame.pack();
        frame.setVisible(true);

    }
}
