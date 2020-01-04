import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main_menu_V1 extends JPanel
{
    private int Mm_select;

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

    public Main_menu_V1()
    {
        this.setLayout(new BorderLayout());

        initComponents();
        initComponentFunctions();

        menuBar1.add(comboBox1);
        menuBar1.add(button1);

        menuBar2.add(comboBox2);
        menuBar2.add(button2);

        menuBar3.add(button3);
        menuBar3.add(button4);

        add(menuBar1, BorderLayout.NORTH);
        add(menuBar2, BorderLayout.NORTH);
        add(menuBar3, BorderLayout.CENTER);
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

        label1.setText("MAIN MENU");
        label2.setText("label");
    }

    private void initComponentFunctions() {
        //Nicht implementiert
        ActionListener listener1 = new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("Noch nicht implementiert!");
            }
        };

        ActionListener listener2 = new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {

            }
        };

        ActionListener listener3 = new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {

            }
        };

        ActionListener listener4 = new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {

            }
        };

        ActionListener listener5 = new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {

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
                //equipped_item_obj = (item)comboBox1.getSelectedItem();
            }
        });

        comboBox2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                //equipped_index = comboBox2.getSelectedIndex();
                //equipped_item_obj = (item)comboBox2.getSelectedItem();
            }
        });
    }
    public void closewindow()
    {
        this.setVisible(false);
    };

}
