public class Map_Sprite extends Sprite
{
    private int spriteSelect;

    public Map_Sprite(int x, int y, int spriteSelect_temp)
    {
        super(x,y);
        this.spriteSelect = spriteSelect_temp;

        initCraft();
    }

    private void initCraft()
    {
        switch(spriteSelect)
        {
            case 0: loadImage("res/Map/subground/subground-00.png");
            case 1: loadImage("res/Map/ground/ground-01.png");
        }

        getImageDimensions();
    }
}
