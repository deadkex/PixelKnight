import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class backpack_window extends JPanel
{
    private backpack pack_win;
    private int countItems = 0;
    //private int equipped_index = 0;
    private item equipped_item_obj;
    private int gold = 0;

    private JMenuBar menuBar1;
    private JMenuBar menuBar2;
    private JMenuBar menuBar3;

    private JComboBox comboBox1;
    private JComboBox comboBox2;

    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;

    private JLabel label1;
    private JLabel label2;

    public backpack_window()
    {
        pack_win = new backpack(5);

        this.setLayout(new BorderLayout());

        initComponents();
        initComponentFunctions();

        menuBar1.add(label1);
        menuBar1.add(label2);

        menuBar2.add(comboBox1);
        menuBar2.add(comboBox2);

        menuBar3.add(button1);
        menuBar3.add(button2);
        menuBar3.add(button3);
        menuBar3.add(button4);

        add(menuBar1, BorderLayout.NORTH);
        add(menuBar2, BorderLayout.CENTER);
        add(menuBar3, BorderLayout.SOUTH);
    }

    private void initComponents()
    {
        menuBar1 = new JMenuBar();
        menuBar2 = new JMenuBar();
        menuBar3 = new JMenuBar();

        comboBox1 = new JComboBox();
        comboBox2 = new JComboBox();
        comboBox1.setPrototypeDisplayValue("XXXXXXXXXXXXXXX");
        comboBox2.setPrototypeDisplayValue("XXXXXXXXXXXXXXX");

        button1 = new JButton("newSword");
        button2 = new JButton("newShield");
        button3 = new JButton("Sell Item");
        button4 = new JButton("CheckInv");

        label1 = new JLabel();
        label2 = new JLabel();

        label1.setText("Backpack        ");
        label2.setText("Gold: " + gold);
    }

    private void initComponentFunctions() {
        //Nicht implementiert
        ActionListener listener1 = new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("Noch nicht implementiert!");
            }
        };

        //Sword add
        ActionListener listener2 = new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                if(countItems < pack_win.getPack().length)
                {
                    int new_obj_pos = pack_win.newItem("sword",true);
                    comboBox1.addItem(pack_win.getPack()[new_obj_pos]);
                    comboBox1.repaint();
                    countItems = countItems + 1;
                }
            }
        };

        //Shield add
        ActionListener listener3 = new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                if(countItems < pack_win.getPack().length)
                {
                    int new_obj_pos = pack_win.newItem("shield",true);
                    comboBox2.addItem(pack_win.getPack()[new_obj_pos]);
                    comboBox2.repaint();
                    countItems = countItems + 1;
                }
            }
        };

        //Remove
        ActionListener listener4 = new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                if(equipped_item_obj != null)
                {
                    pack_win.delItem("sword", equipped_item_obj.getitemID());
                    comboBox2.removeItem(equipped_item_obj);
                    comboBox1.removeItem(equipped_item_obj);

                    countItems = countItems - 1;
                }
            }
        };

        //CheckInv
        ActionListener listener5 = new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                pack_win.checkInv();
            }
        };

        button1.addActionListener(listener2);
        button2.addActionListener(listener3);
        button3.addActionListener(listener4);
        button4.addActionListener(listener5);

        comboBox1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                //equipped_index = comboBox1.getSelectedIndex();
                equipped_item_obj = (item)comboBox1.getSelectedItem();
            }
        });

        comboBox2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                //equipped_index = comboBox2.getSelectedIndex();
                equipped_item_obj = (item)comboBox2.getSelectedItem();
            }
        });

        KeyListener keyListener1 = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_N)
                {
                    closewindow();
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {

            }
        };

        this.addKeyListener(keyListener1);
        comboBox1.addKeyListener(keyListener1);
        comboBox2.addKeyListener(keyListener1);
        button1.addKeyListener(keyListener1);
        button2.addKeyListener(keyListener1);
        button3.addKeyListener(keyListener1);
        button4.addKeyListener(keyListener1);
    }
    public void closewindow()
    {
        this.setVisible(false);
    };

}