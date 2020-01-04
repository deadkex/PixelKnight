import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BackNotes
{
        public BackNotes()
        {

            //330 normal höhe
            //426 boden





            /*
            KeyListener keyListener1 = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                closewindow();
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
            };
            comboBox1.addKeyListener(keyListener1);
            comboBox2.addKeyListener(keyListener1);
             */








            //Von Konsole einlesen
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            System.out.print("Gib was ein: ");
            String eingabe = null;
            try {
                eingabe = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Du hast " + eingabe + " eingegeben.");

            //If Abfrage
            System.out.print("Wie alt bist du: ");
            try {
                eingabe = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            int alter = Integer.parseInt(eingabe);
        }
}