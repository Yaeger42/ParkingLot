import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;
import java.util.jar.JarEntry;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Ticket {

    public int ticketID = 0;
    public static void main(String[] args) {
        Ticket tk = new Ticket();
    }

    public Ticket(){
        JButton ticketButton = new JButton("Get ticket");
        JButton payButton = new JButton("Pay: ");
        JTextField idEnter = new JTextField("Enter the id: "); //How do I get the data from this?
        JTextField id = new JTextField(20);
        JTextField entTime = new JTextField(20);
        JTextField exitTime = new JTextField(20);

        ticketButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento){
                ChargeMoney ch = new ChargeMoney();
                ticketID ++;
                id.setText("Ticket ID: "+ticketID);
                entTime.setText("Time of entry: " + ch.setHoursTime() +":"+  ch.setMinutesTime());
            }
        });

        payButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento){

            }
        });


        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout());
        frame.setLayout(new FlowLayout());
        frame.setSize(300, 200);
        panel.setSize(100, 300);
        frame.add(panel);
        frame.add(ticketButton);
        frame.add(id);
        exitTime.setText("Exit time: ");
        frame.add(entTime);
        panel.add(exitTime);
        frame.setVisible(true);
        panel.setVisible(true);
        frame.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
