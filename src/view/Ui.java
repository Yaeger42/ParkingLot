package view;

import Model.Ticket;
import manager.Greedy;
import manager.ParkingManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Ui implements ManagerListener {
    JTable ticketsTable;
    Greedy greedy;
    ParkingManager parkingManager = new ParkingManager(this);
    int money = 0;
    DefaultTableModel model = new DefaultTableModel();

    public Ui() {
        String[][] data = {
                {"0", "1", "1"},
                {"1", "1", "3"}
        };
        String[] columnNames = {"Hours", "Minutes", "Price"};
        // ------------- end of table data

        String[][] dataTicketList = {

        };

        String[] columnNamesTicket = {"Id", "Entrance time", "Exit time", "Ammount payed"};
        JButton ticketButton = new JButton("Get ticket");
        //Falta pagar aqui :'v
        JButton payButton = new JButton("Pay: ");
        JButton pay1 = new JButton("1");
        JButton pay2 = new JButton("2");
        JButton pay5 = new JButton("5");
        JButton pay10 = new JButton("10");
        JTextField moneyEntered = new JTextField("Money: " + money);
        JTextField idEnter = new JTextField(); //How do I get the data from this?
        JTextField id = new JTextField(30);
        JTextField change = new JTextField(30);
        JTextField exitTime = new JTextField(20);

        pay1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                money +=1;
                moneyEntered.setText("Money: " + money);
            }
        });

        pay2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                money +=2;
                moneyEntered.setText("Money: " + money);
            }
        });

        pay5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                money += 5;
                moneyEntered.setText("Money: " + money);
            }
        });

        pay10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                money += 10;
                moneyEntered.setText("Money: " + money);
            }
        });

        ticketButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                parkingManager.createTicket();
                try {
                    ticketButton.setEnabled(false);
                    Thread.sleep(2000);
                    ticketButton.setEnabled(true);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        payButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                int id = Integer.parseInt(idEnter.getText());
                parkingManager.payTicket(money, id);
                change.setText("Change: " + greedy.findMin(money).toString());
                money = 0;
                moneyEntered.setText("Money: " + money);
            }
        });

        ticketsTable = new JTable(model);
        ticketsTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        JTable priceTable = new JTable(data, columnNames);
        JFrame frame = new JFrame();
        JScrollPane scroll = new JScrollPane(priceTable);

        JPanel panel = new JPanel();
        panel.setSize(20, 20);
        frame.add(ticketsTable);
        frame.add(new JLabel("Enter the id: "));
        frame.add(idEnter);
        frame.add(change);
        frame.add(pay1);
        frame.add(pay2);
        frame.add(pay5);
        frame.add(pay10);
        frame.add(moneyEntered);
        frame.add(payButton);
        //panel.setLayout(new GridLayout());
        frame.setLayout(new FlowLayout());
        frame.setSize(1300, 400);
        //panel.setSize(400, 350);
        panel.add(scroll);
        frame.add(priceTable);
        frame.add(ticketButton);
        frame.add(id);
        exitTime.setText("Exit time: ");
        //frame.add(entTime);
        //panel.add(exitTime);
        frame.setVisible(true);
        panel.setVisible(true);
        frame.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Ui UI = new Ui();
    }

    @Override
    public void updateTicketList(List<Ticket> ticketList) {
        //This updates the table
        //Attributes from ticket object -- traverse list with a for each, insert an element in the table by element.
        //Id, entrance time, exit time (if not available, show empty) show the price payed
        model.addColumn("ID");
        model.addColumn("Entrance time");
        model.addColumn("Exit time");
        model.addColumn("Ammount payed");
        for (Ticket ticket : ticketList) {
            String[] strArray = {Integer.toString(ticket.getTicketID()), ticket.getEntranceHrs() + ":" + ticket.getEntranceMnts(), ticket.getExitHrs() + ":" + ticket.getEntranceMnts(), Integer.toString(ticket.getPrice())};
            if (ticket.getExitHrs() == 0) {

                strArray[3] = "";
                strArray[2] = "";
            }

            System.out.println("ticket.toString() = " + ticket.toString());
            model.addRow(strArray);
            ticketsTable = new JTable(model);
        }
    }
}
