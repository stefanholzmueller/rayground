package rayground.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class PixelCanvas extends JPanel {

    private static final long serialVersionUID = 1L;

    private BufferedImage bufferedImage;

    public PixelCanvas(int width, int height) {
        bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        fillWithBackgroundColor();
    }

    private void fillWithBackgroundColor() {
        Graphics2D graphics = bufferedImage.createGraphics();
        graphics.setPaint(java.awt.Color.DARK_GRAY);
        graphics.fillRect(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight());
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(bufferedImage.getWidth(), bufferedImage.getHeight());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(bufferedImage, 0, 0, null);
    }

    public void setPixels(int[] pixels) {
        bufferedImage.setRGB(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight(), pixels, 0, 1);
        repaint();
    }
}
