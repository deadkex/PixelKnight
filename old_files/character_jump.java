import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class character_jump extends Sprite
{
    private int dx; //Speed
    private int dy;
    private int X_save;
    private int Y_save;

    private float jumpStrength;
    private static int jumpStrength_reset = 14;
    private float weight;
    protected int floorHeight;
    private int switchVar;
    private int switchVarJump;
    private int lastDirection;

    private int jump_delay;

    public character_jump(int height) {
        super(0,(480 - height - 150));

        initCraft();
    }

    private void initCraft()
    {
        loadImage("res/idle/right/adventurer-idle-00.png");
        getImageDimensions();
        floorHeight = 293;
        weight = 1;
        switchVar = 0;
        switchVarJump = 5;
        jump_delay = 20;
        lastDirection = 0; // 0 = right // 1 = left
        X_save = x;
        Y_save = y;
        //System.out.println(floorHeight + " " + height);
    }

    public void move()
    {
        X_save = X_save + dx;
        if(X_save <= 300) x += dx;

        if (x < 1) {
            x = 1;
        }
        if (X_save < 1) {
            X_save = 1;
        }

        if(dx == 3)
        {
            switch(switchVar)
            {
                case 0: loadImage("res/run/right/adventurer-run-00.png"); break;
                case 7: loadImage("res/run/right/adventurer-run-01.png"); break;
                case 14: loadImage("res/run/right/adventurer-run-02.png"); break;
                case 21: loadImage("res/run/right/adventurer-run-03.png"); break;
                case 28: loadImage("res/run/right/adventurer-run-04.png"); break;
                case 35: loadImage("res/run/right/adventurer-run-05.png"); switchVar = 0; break;
            }
            switchVar += 1;
        }
        else if(dx == -3)
        {
            switch(switchVar)
            {
                case 0: loadImage("res/run/left/adventurer-run-06.png"); break;
                case 7: loadImage("res/run/left/adventurer-run-07.png"); break;
                case 14: loadImage("res/run/left/adventurer-run-08.png"); break;
                case 21: loadImage("res/run/left/adventurer-run-09.png"); break;
                case 28: loadImage("res/run/left/adventurer-run-10.png"); break;
                case 35: loadImage("res/run/left/adventurer-run-11.png"); switchVar = 0; break;
            }
            switchVar += 1;
        }
        else if(dx == 0 && y == floorHeight)
        {
            if(lastDirection == 0) loadImage("res/idle/right/adventurer-idle-00.png");
            else if(lastDirection == 1) loadImage("res/idle/left/adventurer-idle-00.png");
        }
    }

    public void jump()
    {

        y -= jumpStrength; // Move the player on the y-axis based on the strength of the jump.
        jumpStrength -= weight; // Gradually decrease the strength of the jump by the player's weight.
        if (y >= floorHeight) y = floorHeight; // Ensure the player does not fall through the floor.


        if(y < floorHeight)
        {
            if (jumpStrength >= 0.9 * jumpStrength_reset) switchVarJump = 0;
            if (jumpStrength >= 0.7 * jumpStrength_reset && jumpStrength < 0.9 * jumpStrength_reset) switchVarJump = 1;
            if (jumpStrength > -0.3 * jumpStrength_reset && jumpStrength < 0.7 * jumpStrength_reset) switchVarJump = 2;
            if (jumpStrength <= -0.3 * jumpStrength_reset) switchVarJump = 3;
        }
        if(lastDirection == 0)
        {
            switch(switchVarJump)
            {
                case 0: loadImage("res/jump/right/adventurer-jump-00.png"); switchVarJump = 4; break;
                case 1: loadImage("res/jump/right/adventurer-jump-01.png"); switchVarJump = 4; break;
                case 2: loadImage("res/jump/right/adventurer-jump-02.png"); switchVarJump = 4; break;
                case 3: loadImage("res/jump/right/adventurer-jump-03.png"); switchVarJump = 4; break;
                case 4: loadImage("res/idle/right/adventurer-idle-00.png"); switchVarJump++; break;
                case 5: break;
            }
        }
        else if(lastDirection == 1)
        {
            switch(switchVarJump)
            {
                case 0: loadImage("res/jump/left/adventurer-jump-00.png"); switchVarJump = 4; break;
                case 1: loadImage("res/jump/left/adventurer-jump-01.png"); switchVarJump = 4; break;
                case 2: loadImage("res/jump/left/adventurer-jump-02.png"); switchVarJump = 4; break;
                case 3: loadImage("res/jump/left/adventurer-jump-03.png"); switchVarJump = 4; break;
                case 4: loadImage("res/idle/left/adventurer-idle-00.png"); switchVarJump++; break;
                case 5: break;
            }
        }
    }

    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_UP) {
            if (y >= floorHeight) jumpStrength = jumpStrength_reset; // Will result in the player moving upwards.
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
                switchVar = 0;
                loadImage("res/idle/left/adventurer-idle-00.png");
            }
        }

        if (key == KeyEvent.VK_RIGHT) {
            if(dx == 3)
            {
                dx = 0;
                switchVar = 0;
                loadImage("res/idle/right/adventurer-idle-00.png");
            }
        }

        if (key == KeyEvent.VK_UP) {
        }

        if (key == KeyEvent.VK_DOWN) {
        }
    }
}