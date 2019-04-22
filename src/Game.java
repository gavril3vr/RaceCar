import javax.swing.*;

public class Game extends JFrame {

    public Game() {
        super.setTitle("Car Race");
        super.setBounds(0, 0, 1950, 1035);
        super.add(new Car());
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setVisible(true);
    }
}
