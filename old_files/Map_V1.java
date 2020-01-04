import java.awt.*;
import java.awt.event.KeyEvent;

public class Map_V1
{
    private int spriteSelect;
    private int dx; //Speed
    private int dy;
    private int x;
    private int y;
    private int x_playerpos;
    private int y_playerpos;
    private int X_save;
    protected int floorHeight;
    private int lastDirection;

    private int testint = 5;

    private int[] map_xPos;
    private Map_Sprite_V3[] map_sprites;
    private int Map_counter;
    private int Map_offset;

    public Map_V1(int floorHeight_temp)
    {
        map_xPos = new int[100];
        map_sprites = new Map_Sprite_V3[100];
        Map_counter = 0;
        Map_offset = 0;

        floorHeight = floorHeight_temp;

        initCraft();
    }

    private void initCraft()
    {
        lastDirection = 0;
        X_save = 1;

        int baseSize = 16;
        int i = 0;
        do
        {
            map_xPos[i] = baseSize * i;
            map_sprites[i] = new Map_Sprite_V3(map_xPos[i],floorHeight,1);
            i++;
        }
        while(i <= 99);
    }

    public void move()
    {
        X_save = X_save += -dx;
        if(X_save <= 300) x_playerpos += -dx;

        if (x_playerpos < 1) {
            x_playerpos = 1;
        }
        if (X_save < 1) {
            X_save = 1;
        }

        if(X_save >= 300)
        {
            for(int i = 0; i < map_sprites.length; i++)
            {
                map_sprites[i].move(dx,floorHeight);
                if(map_sprites[i].getX() <= -15) map_sprites[i].setVisible(false);
                else map_sprites[i].setVisible(true);
            }
        }



    }

    public boolean isVisible(int i)
    {
        return map_sprites[i].isVisible();
    }

    public Image getImage(int i) {
        return map_sprites[i].getImage();
    }

    public int getX(int i) {
        return map_sprites[i].getX();
    }

    public int getY(int i) {
        return map_sprites[i].getY();
    }

    public Map_Sprite_V3[] getMap(){return map_sprites;}

    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_UP) {
        }

        if (key == KeyEvent.VK_LEFT) {
            dx = 3;
            lastDirection = 1;
        }

        if (key == KeyEvent.VK_RIGHT)
        {
            dx = -3;
            lastDirection = 0;
        }

        if (key == KeyEvent.VK_SPACE) {
        }

        if (key == KeyEvent.VK_DOWN) {
        }
    }

    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            if(dx == 3)
            {
                dx = 0;
            }
        }

        if (key == KeyEvent.VK_RIGHT) {
            if(dx == -3)
            {
                dx = 0;
            }
        }

        if (key == KeyEvent.VK_UP) {
        }

        if (key == KeyEvent.VK_DOWN) {
        }
    }
}
