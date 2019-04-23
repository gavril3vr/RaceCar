import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Car extends Map implements ActionListener, KeyListener {

    private Timer t;

    private BufferedImage firstCar;
    private BufferedImage secondCar;
    private BufferedImage thirdCar;
    private int myCarX = 980;
    private int myCarY = 730;
    private int secondCarX = 730;
    private int secondCarY = 400;
    private int thirdCarX = 980;
    private int thirdCarY = 0;


    private int speed = 2;

    private int velocityX = 0;
    private int velocityY = 0;

    public Car() {
        super.setDoubleBuffered(true);
        t = new javax.swing.Timer(0, this);
        t.start();
        this.addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    public Timer getT() {
        return t;
    }

    public int getMyCarX() {
        return myCarX;
    }

    public int getMyCarY() {
        return myCarY;
    }

    public int getSecondCarX() {
        return secondCarX;
    }

    public int getSecondCarY() {
        return secondCarY;
    }

    public int getThirdCarX() {
        return thirdCarX;
    }

    public int getThirdCarY() {
        return thirdCarY;
    }


    public BufferedImage getFirstCar() {
        return firstCar;
    }


    public BufferedImage getSecondCar() {
        return secondCar;
    }


    public BufferedImage getThirdCar() {
        return thirdCar;
    }


    public void OtherCars() {
        try {
            firstCar = ImageIO.read(new File("C:\\Users\\Vasiliq\\Desktop\\Photo_For_CarProject\\11.png"));
            secondCar = ImageIO.read(new File("C:\\Users\\Vasiliq\\Desktop\\Photo_For_CarProject\\22.png"));
            thirdCar = ImageIO.read(new File("C:\\Users\\Vasiliq\\Desktop\\Photo_For_CarProject\\44.png"));
        } catch (IOException ex) {
            System.out.println("Image not found");
        }

    }

    public void paintComponent(Graphics g) {
        OtherCars();
        super.paintComponent(g);
        g.drawImage(getFirstCar(), getMyCarX(), getMyCarY(), null);
        g.drawImage(getSecondCar(), getSecondCarX(), getSecondCarY(), null);
        g.drawImage(getThirdCar(), getThirdCarX(), getThirdCarY(), null);
    }


    public void move() {
        secondCarY = secondCarY + speed;
        thirdCarY = thirdCarY + speed;
        if (secondCarY == 920) {
            secondCarY = -250;
        }
        if (thirdCarY == 920) {
            thirdCarY = -250;
        }
        repaint();


    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        int c = e.getKeyCode();
        if (c == KeyEvent.VK_LEFT) {
            velocityX = -35;
            velocityY = 0;
        }
        if (c == KeyEvent.VK_UP) {
            velocityX = 0;
            velocityY = -35;
        }
        if (c == KeyEvent.VK_RIGHT) {
            velocityX = 35;
            velocityY = 0;
        }
        if (c == KeyEvent.VK_DOWN) {
            velocityX = 0;
            velocityY = 35;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    public void limit() {
        if (myCarX < 700) {
            velocityX = 0;
            myCarX = 700;
        }
        if (myCarX > 1020) {
            velocityX = 0;
            myCarX = 1020;
        }
        if (myCarY < 0) {
            velocityY = 0;
            myCarY = 0;
        }
        if (myCarY > 780) {
            velocityY = 0;
            myCarY = 780;
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        limit();
        this.addKeyListener(this);
        myCarX = myCarX + velocityX;
        velocityX = 0;
        myCarY = myCarY + velocityY;
        velocityY = 0;
        repaint();
    }
}