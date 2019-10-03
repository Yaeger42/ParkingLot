import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.Vector;

public class DisplayImage {

    public static final int IMG1 = 0;
    public static final int IMG2 = 1;
    public static final int IMG3 = 2;
    public static final int IMG4 = 3;
    int credits = 0;

    public static void main(String avg[]) throws IOException {
        DisplayImage abc = new DisplayImage();
    }

    public DisplayImage() throws IOException {
        JButton jButton = new JButton("10");
        JButton jButton2 = new JButton("5");
        JButton jButton3 = new JButton("2");
        JButton jButton4 = new JButton("1");
        JButton jButton5 = new JButton("Play");
        JButton jButton6 = new JButton("Retrieve");
        JTextField text = new JTextField(20);
        JTextField text2 = new JTextField(60);
        JLabel label1 = new JLabel();
        JLabel label2 = new JLabel();
        JLabel label3 = new JLabel();
        JLabel label4 = new JLabel();
        JLabel genLabel = new JLabel();
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                credits += 10;
                text.setText("Credits: " + credits);
            }
        });
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                credits += 5;
                text.setText("Credits: " + credits);

            }
        });

        jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                credits += 2;
                text.setText("Credits: " + credits);

            }
        });

        jButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                credits += 1;
                text.setText("Credits: " + credits);

            }
        });


        jButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (credits >= 7) {
                    credits -= 7;
                    text.setText("Credits: " + credits);
                    Image imgg;
                    ImageIcon icon = null;
                    int contImg1 = 0;
                    int contImg2 = 0;
                    int contImg3 = 0;
                    for (int i = 0; i < 3; i++) {
                        try {
                            int randomNumber = genRandomImage();

                            switch (randomNumber) {

                                case IMG1:
                                    imgg = ImageIO.read(new File("img1.png"));
                                    icon = new ImageIcon(imgg);
                                    contImg1++;

                                    break;

                                case IMG2:
                                    imgg = ImageIO.read(new File("img2.png"));
                                    icon = new ImageIcon(imgg);
                                    contImg2++;

                                    break;

                                case IMG3:
                                    imgg = ImageIO.read(new File("img3.png"));
                                    icon = new ImageIcon(imgg);
                                    contImg3++;
                                    break;

                                case IMG4:
                                    imgg = ImageIO.read(new File("img4.png"));
                                    icon = new ImageIcon(imgg);

                                    break;

                            }
                            if(i == 0){
                                label1.setIcon(icon);

                            }
                            if( i == 1){
                                label2.setIcon(icon);
                            }
                            if(i == 2){
                                label3.setIcon(icon);
                            }




                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }

                    }
                    System.out.println(credits);

                    if(contImg1 == 2){
                        credits+= 97;
                    }
                    if(contImg1 == 3){
                        credits += 163;
                    }
                    if(contImg2 == 2){
                        credits +=97;
                    }
                    if(contImg2 == 3){
                        credits +=163;
                    }
                    if(contImg3 == 2){
                        credits+=97;
                    }
                    if(contImg3 == 3){
                        credits += 163;
                    }
                    text.setText("Credits: "+credits);

                }
            }
        });

        jButton6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text2.setText("Change " + Greedy.findMin(credits).toString());
                credits = 0;
                text.setText("Credits: "+credits);

            }
        });



        GridLayout exp = new GridLayout(2,4);
        JFrame frame = new JFrame();
        frame.setLayout(exp);
        frame.setSize(600, 600);


        frame.add(label1);
        frame.add(label2);
        frame.add(label3);
        frame.add(label4);
        frame.add(genLabel);
        frame.add(text2);
        frame.add(text);
        text.setText("Credits: " + credits);
        frame.add(jButton);
        frame.add(jButton2);
        frame.add(jButton3);
        frame.add(jButton4);
        frame.add(jButton5);
        frame.add(jButton6);


        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    public int genRandomImage() {
        //Este método te va a devolver un número de 0 a 3
        //Cada uno representa cada una de tus imágenes
        int randomImage = ThreadLocalRandom.current().nextInt(0, 3 );
        int image = 0;
        if (randomImage == IMG1) {
            image = IMG1;
        } else if (randomImage == IMG2) {
            image = IMG2;
        } else if (randomImage == IMG3) {
            image = IMG3;
        } else if (randomImage == IMG4) {
            image = IMG4;
        }
        //Una vez que haya comparado tu número aleatorio te va a devolver el valor que tenga image
        return image;
    }

}