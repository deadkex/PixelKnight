import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Game extends JPanel implements ActionListener
{
    private Timer timer;
    private final int DELAY = 15;
    private character abc;
    private List<Alien> aliens;

    public Game()
    {
        addKeyListener(new Game.TAdapter());
        setFocusable(true);
        abc = new character(0,0);
        setBackground(Color.BLACK);
        aliens = new ArrayList<>();
        aliens.add(new Alien(300,100));

        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawObjects(g);
    }

    private void drawObjects(Graphics g) {

        if (abc.isVisible()) {
            g.drawImage(abc.getImage(), abc.getX(), abc.getY(),
                    this);
        }

        for (Alien alien : aliens) {
            if (alien.isVisible()) {
                g.drawImage(alien.getImage(), alien.getX(), alien.getY(), this);
            }
        }

        g.setColor(Color.WHITE);
    }

    private void updateShip() {

        if (abc.isVisible()) {

            abc.move();
        }
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

    private void updateAliens() {
        for (int i = 0; i < aliens.size(); i++) {

            Alien a = aliens.get(i);

            if (a.isVisible()) {
                a.move();
            } else {
                aliens.remove(i);
            }
        }
    }

    private class TAdapter extends KeyAdapter
    {
        @Override
        public void keyReleased(KeyEvent e) {
            abc.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            abc.keyPressed(e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        updateShip();
        updateMissiles();
        updateAliens();

        repaint();
    }
}
