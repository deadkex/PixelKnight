import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Game_Jump_V2 extends JPanel implements ActionListener
{
    private Timer timer;
    private final int DELAY = 15;
    private character_jump abc;

    private int[] map_xPos;
    private Map_Sprite_V2[] map_sprites;
    private int floorHeight;
    private int Map_counter;
    private int Map_offset;

    public Game_Jump_V2()
    {
        this.addKeyListener(new Game_Jump_V2.TAdapter());
        this.setFocusable(true);
        this.setBackground(Color.BLACK);

        this.abc = new character_jump(this.getHeight());

        map_xPos = new int[100];
        map_sprites = new Map_Sprite_V2[100];
        Map_counter = 0;
        Map_offset = 0;

        floorHeight = 480 - this.getHeight() - 150;

        initStuff();

        this.timer = new Timer(DELAY, this);
        this.timer.start();
    }

    private void initStuff()
    {
        int baseSize = 16;
        int i = 0;
        do
        {
            map_xPos[i] = baseSize * i;
            map_sprites[i] = new Map_Sprite_V2(map_xPos[i],floorHeight,1);
            i++;
        }
        while(i <= 99);
        map_sprites[5] = new Map_Sprite_V2(0,floorHeight,0);
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        drawObjects(g);
    }

    private void drawObjects(Graphics g)
    {
        g.drawImage(map_sprites[0].getImage(), map_sprites[0].getX(), map_sprites[0].getY(), this);

        if (abc.isVisible())
        {
            g.drawImage(abc.getImage(), abc.getX(), abc.getY(),this);
        }

        g.setColor(Color.WHITE);
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
        map_sprites[0].move();
        System.out.print(" "+map_sprites[0].getX());
    }









    /*

            if(abc.getX() <= this.getWidth()/2) Map_offset = 0;
        else if(abc.getX() >= 300) Map_offset = 1;
        if(Map_offset == 0)
    {
        Map_counter = 0;
        do
        {
            if(map_sprites[Map_counter].getImage() != null) g.drawImage(map_sprites[Map_counter].getImage(), map_sprites[Map_counter].getX(), map_sprites[Map_counter].getY(),this);
            Map_counter++;
        }
        while(Map_counter <= this.getWidth()/16);
    }
        else if(Map_counter > 0)
    {
        Map_offset++;
        Map_counter = Map_offset;
        do
        {
            if(map_sprites[Map_counter].getImage() != null) g.drawImage(map_sprites[Map_counter].getImage(), map_sprites[Map_counter].getX(), map_sprites[Map_counter].getY(),this);
            Map_counter++;
        }
        while(Map_counter <= this.getWidth()/16);
    }



    private void updateMissiles() {

        List<Missile> ms = abc.getMissiles();

        for (int i = 0; i < ms.size(); i++) {

            Missile m = ms.get(i);

            if (m.isVisible()) {
                m.move();
            } else {
                ms.remove(i);
            }
        }
    }

            for (Alien alien : aliens) {
    if (alien.isVisible()) {
        g.drawImage(alien.getImage(), alien.getX(), alien.getY(), this);
    }
}


    aliens = new ArrayList<>();
        aliens.add(new Alien(300,100));





*/













    private class TAdapter extends KeyAdapter
    {
        @Override
        public void keyReleased(KeyEvent e) {
            abc.keyReleased(e);
            map_sprites[0].keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            abc.keyPressed(e);
            map_sprites[0].keyPressed(e);
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