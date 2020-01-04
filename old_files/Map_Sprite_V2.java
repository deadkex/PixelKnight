import java.awt.event.KeyEvent;

public class Map_Sprite_V2 extends Sprite
{
    private int spriteSelect;
    private int dx; //Speed
    private int dy;
    private int X_save;
    protected int floorHeight;
    private int lastDirection;

    public Map_Sprite_V2(int x, int y, int spriteSelect_temp)
    {
        super(x,y);
        this.spriteSelect = spriteSelect_temp;

        initCraft();
    }

    private void initCraft()
    {
        switch(spriteSelect)
        {
            case 0: loadImage("res/Map/ground/ground-00.png");
            case 1: loadImage("res/Map/ground/ground-01.png");
        }
        getImageDimensions();

        floorHeight = 293;
        lastDirection = 0;
        X_save = 1;
    }

    public void move()
    {
        X_save = X_save += dx;
        if(X_save <= 300) x += dx;

        if (x < 1) {
            x = 1;
        }
        if (X_save < 1) {
            X_save = 1;
        }
    }

    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_UP) {
        }

        if (key == KeyEvent.VK_LEFT) {
            dx = -3;
            lastDirection = 1;
        }

        if (key == KeyEvent.VK_RIGHT)
        {
            dx = 3;
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
            if(dx == -3)
            {
                dx = 0;
            }
        }

        if (key == KeyEvent.VK_RIGHT) {
            if(dx == 3)
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
