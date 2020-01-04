import java.awt.*;

public class Map_all
{
    private int[] map;
    private Map_Sprite[] map_sprites;
    private static int baseSize;
    private int height;
    private int width;
    private int floorHeight;

    public Map_all(int height_temp, int width_temp)
    {
        this.height = height_temp;
        this.width = width_temp;

        floorHeight = 480 - height - 150;

        map_sprites = new Map_Sprite[1000];
        map = new int[1000];

        initCraft();
    }

    private void initCraft()
    {
        baseSize = 16;
        int i = 0;
        do
        {
            map[i] = baseSize * i;
            map_sprites[i] = new Map_Sprite(map[i],floorHeight,1);
            i++;
            System.out.print("error");
        }
        while(i <= width*2);
    }

    public Image getImage(int i)
    {
        Image image_temp = null;
        if(map_sprites[i] != null)
        {
            if(map_sprites[i].isVisible())
            {
                image_temp = map_sprites[i].getImage();
            }
        }
        return image_temp;
    }

    public int getX(int i)
    {
        return map[i];
    }
    public int getY(int i)
    {
        return floorHeight;
    }
}
