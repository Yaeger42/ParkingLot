import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Ticket {

    private int ticketID = 0;
    public static void main(String[] args) {
        Ticket tk = new Ticket();
    }

    public Ticket(){
        JButton ticketButton = new JButton("Get ticket");
        JTextField id = new JTextField(20);
        ticketButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento){
                ticketID ++;
                id.setText("Ticket ID: "+ticketID);
            }
        });

        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setSize(300, 200);
        frame.add(ticketButton);
        frame.add(id);
        frame.setVisible(true);
        frame.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
