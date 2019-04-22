import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Map extends JPanel {
    private BufferedImage grass;
    private BufferedImage highway;

    public BufferedImage getGrass() {
        return grass;
    }

    public BufferedImage getHighway() {
        return highway;
    }


    public void drawApp() {
        try {
            grass = ImageIO.read(new File("C:\\Users\\Vasiliq\\Desktop\\NewProject\\RaceCar\\src\\SourcePictures\\grass-texture.jpg"));
            highway = ImageIO.read(new File("C:\\Users\\Vasiliq\\Desktop\\NewProject\\RaceCar\\src\\SourcePictures\\highway.png"));
        } catch (IOException ex) {
            System.out.println("Image not found");
        }
    }

    public void paintComponent(Graphics g) {
        drawApp();
        g.drawImage(getHighway(), 730, 0, null);
        g.drawImage(getGrass(), 580, 0, null);
        g.drawImage(getGrass(), 1200, 0, null);
    }
}
