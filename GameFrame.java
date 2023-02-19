import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

public class GameFrame extends JFrame{
    File dir;
    JPanel menu;

    public GameFrame(File dir, JPanel menu)
    {
        this.setLayout(null);

        this.dir = dir;
        this.menu = menu;
        this.setBounds(0, 0, 1300, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setForeground(Color.CYAN);
    }




}
