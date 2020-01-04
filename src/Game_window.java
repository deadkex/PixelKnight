import javax.swing.*;
import java.awt.*;

public class Game_window extends JFrame
{
    private Game_Jump_V4 window2;
    private Main_menu_gui_V1 window3;

    public Game_window()
    {
        this.setTitle("Game");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setResizable(false);

        window2 = new Game_Jump_V4();
        this.add(this.window2, BorderLayout.CENTER);
        window2.setVisible(true);

        /*
        window3 = new Main_menu_gui_V1();
        this.setContentPane(window3.panel1);
        this.pack();
        window3.setVisible(true);
        */

        //window3 = new Main_menu_gui_V1();
        //this.add(this.window3, BorderLayout.CENTER);
        //window3.setVisible(true);

        //if(window3.isVisible() == false)
        //{
        //    window2.setVisible(true);
        //}
    }
}
