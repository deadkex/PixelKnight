import java.awt.event.KeyEvent;

public class Map_Sprite_V3 extends Sprite_V1
{
    private int spriteSelect;

    public Map_Sprite_V3(int x, int y, int spriteSelect_temp)
    {
        super(x,y);
        this.spriteSelect = spriteSelect_temp;

        initCraft();
    }

    private void initCraft()
    {
        switch(spriteSelect)
        {
            case 0: loadImage("res/MapSprites/subground/subground-00.png"); break;
            case 1: loadImage("res/MapSprites/ground/ground-01.png"); break;
            case 2: loadImage("res/MapSprites/tree-00.png"); break;
            case 3: break;
        }
        getImageDimensions();
    }

    public void move(int x_temp, int y_temp)
    {
        this.x = this.x + x_temp;
    }
}
