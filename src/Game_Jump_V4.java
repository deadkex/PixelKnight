import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Game_Jump_V4 extends JPanel implements ActionListener
{
    private Timer timer;
    private final int DELAY = 15;
    private character_jump_V1 abc;
    private Map_V2 map;
    private int floorHeight;
    private int mapNumberActive;

    private backpack_window window1;

    public Game_Jump_V4()
    {
        this.addKeyListener(new Game_Jump_V4.TAdapter());
        this.setFocusable(true);
        this.setBackground(Color.BLACK);

        window1 = new backpack_window();
        this.add(this.window1);
        window1.setVisible(false);

        initStuff();

        this.timer = new Timer(DELAY, this);
        this.timer.start();
    }

    private void initStuff()
    {
        floorHeight = 480 - this.getHeight() - 150;
        mapNumberActive = 0;

        this.abc = new character_jump_V1(this.getHeight());
        this.map = new Map_V2(floorHeight, mapNumberActive);
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        drawObjects(g);
    }

    private void drawObjects(Graphics g)
    {
        for(int i = 0; i < map.getMap().length; i++)
        {
            for(int i2 = 0; i2 < map.getMap().length; i2++)
            {
                if(map.getImage(i, i2) != null)
                {
                    if(map.isVisible(i, i2))
                    {
                        g.drawImage(map.getImage(i, i2), map.getX(i, i2), map.getY(i, i2), this);
                    }
                }
            }


        }

        if (abc.isVisible())
        {
            g.drawImage(abc.getImage(), abc.getX(), abc.getY(),this);
        }
        g.setColor(Color.WHITE);
        //g.drawString("AdventureTime!", 5, 15);

    }

    private void updateCharacter()
    {
        if (abc.isVisible())
        {
            abc.move();
            abc.jump();
        }
    }

    private void updateMap()
    {
        map.move();
    }

    private class TAdapter extends KeyAdapter
    {
        @Override
        public void keyReleased(KeyEvent e) {
            abc.keyReleased(e);
            map.keyReleased(e);

            int key = e.getKeyCode();
            if (key == KeyEvent.VK_N && timer.isRunning() == false)
            {
                window1.setVisible(false);
                timer.start();
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {
            abc.keyPressed(e);
            map.keyPressed(e);

            int key = e.getKeyCode();
            if (key == KeyEvent.VK_B)
            {
                timer.stop();
                window1.setVisible(true);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        updateCharacter();
        updateMap();

        repaint();
    }
}