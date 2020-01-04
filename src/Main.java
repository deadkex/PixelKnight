import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class Main
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(() -> {
            JFrame ex = new Game_window();
            ex.setVisible(true);
            ex.setSize(640,480);
        });
    }
}