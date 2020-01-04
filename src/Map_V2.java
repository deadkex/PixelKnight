import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.*;

public class Map_V2
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
    private int[] map_yPos;
    private Map_Sprite_V3[][] map_sprites;
    private int Map_counter;
    private int Map_offset;

    private int mapNumberActive;

    public Map_V2(int floorHeight_temp, int mapNumberActive_temp)
    {
        map_xPos = new int[100];
        map_yPos = new int[30];
        map_sprites = new Map_Sprite_V3[100][350];
        Map_counter = 0;
        Map_offset = 0;

        //floorHeight = floorHeight_temp;
        floorHeight = 426;

        mapNumberActive = mapNumberActive_temp;

        initCraft();
    }

    private void initCraft()
    {
        lastDirection = 0;
        X_save = 0;
        x = 0;

        //map_sprites[7][6] = new Map_Sprite_V3(0,440,1);
        //map_sprites[4][7] = new Map_Sprite_V3(map_xPos[4],map_yPos[5],2);

        try
        {
            createMap();
        }
        catch(IOException e){ System.out.println("error filereader");}


    }

    private void createMap()throws IOException
    {
        // Load Map from file
        String fileLocation2;
        BufferedReader br;
        String line;
        String[] parts2;
        int lengthCount = 0;
        int lengthCount2 = 0;
        fileLocation2 = "res/maps/Map_" + mapNumberActive + ".txt";

        try {
            br = new BufferedReader(new FileReader(new File(fileLocation2)));

            while((line = br.readLine()) != null)
            {
                parts2 = line.split(";");

                if(parts2.length != 1)
                {
                    lengthCount = 0;
                    lengthCount2 = lengthCount + 1;
                    while(lengthCount != (parts2.length - 1))
                    {
                        createMapPuzzle(Integer.parseInt(parts2[lengthCount2]), Integer.parseInt(parts2[0]), lengthCount);
                        lengthCount++;
                        lengthCount2++;
                    }

                }

            }
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void createMapPuzzle(int puzzle, int i2, int lengthCount)throws IOException
    {
        String fileLocation = "res/maps/puzzles/Map_subground.txt";
        String[] parts;

        switch (puzzle)
        {
            case 0: fileLocation = "res/maps/puzzles/Map_subground.txt"; break;
            case 1: fileLocation = "res/maps/puzzles/Map_clouds.txt"; break;
            case 2: fileLocation = "res/maps/puzzles/Map_air.txt"; break;
            case 3: fileLocation = "res/maps/puzzles/Map_floor.txt"; break;
            case 4: fileLocation = "res/maps/puzzles/Map_floorWtree.txt"; break;
        }

        BufferedReader br = null;
        String line = null;

        try {
            int baseSize = 16;
            int i;
            int i6;

            for(int i5 = 0; i5 < 100; i5++)
            {
                if(i5 < 28) map_yPos[i5] = floorHeight - baseSize * i5;
                map_xPos[i5] = baseSize * i5;
            }

            br = new BufferedReader(new FileReader(new File(fileLocation)));

            while((line = br.readLine()) != null)
            {
                parts = line.split(";");
                i = 10 * lengthCount;
                i6=0;
                while(i < (lengthCount * 10 + 10))
                {
                    map_sprites[i][i2] = new Map_Sprite_V3(map_xPos[i],map_yPos[i2],Integer.parseInt(parts[i6]));
                    i++;
                    i6++;
                }

                i2--;

            }
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }

        br.close();
    }

    public void move()
    {
        if(X_save <= 405 && dx == 3 || x <= 405 && dx == 3) x += dx;
        else if(X_save <= 170 && dx == -3 || x >= 170 && dx == -3) x+= dx;

        X_save = X_save + dx;

        if (x < 1) {
            x = 0;
        }
        if (X_save < 1) {
            X_save = 0;
        }

        if((x == 168 && dx == -3 && X_save > 168) || (x == 408 && dx == 3))
        {
            for(int i = 0; i < map_sprites.length; i++)
            {
                for(int i2 = 0; i2 < map_sprites.length; i2++)
                {
                    if(map_sprites[i][i2] != null)
                    {
                        map_sprites[i][i2].move(-dx,floorHeight);
                        if(map_sprites[i][i2].getX() <= -100) map_sprites[i][i2].setVisible(false);
                        else map_sprites[i][i2].setVisible(true);
                    }
                }
            }
        }
    }

    public boolean isVisible(int i, int i2)
    {
        return map_sprites[i][i2].isVisible();
    }

    public Image getImage(int i, int i2) {
        if(map_sprites[i][i2] != null) return map_sprites[i][i2].getImage();
        else return null;
    }

    public int getX(int i, int i2) {
        return map_sprites[i][i2].getX();
    }

    public int getY(int i, int i2) {
        return map_sprites[i][i2].getY();
    }

    public Map_Sprite_V3[][] getMap(){return map_sprites;}

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
