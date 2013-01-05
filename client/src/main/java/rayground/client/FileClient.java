package rayground.client;

import rayground.Engine;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.*;
import java.io.File;

public class FileClient {
    public static void main(String[] args) throws Exception {
        RenderedImage image = Engine.renderSync();

        File outputfile = new File("saved.png");
        ImageIO.write(image, "png", outputfile);
    }
}
