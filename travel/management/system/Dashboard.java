package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Dashboard extends JFrame implements ActionListener {
    String username;
    JButton addPersonalDetails,notepad,calculators, bookhotels,viewbookedhotel,  destinations, payments , 
viewhotels,viewpackages,bookpackages,about,deletePersonalDetails,checkpackages , viewPersonalDetails, updatePersonalDetails;

    public Dashboard(String username) {
        this.username = username;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);

        // Panel at the top
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0, 0, 102));
        p1.setBounds(0, 0, 1600, 65);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
        Image i2 = i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(5, 0, 70, 70);
        p1.add(icon);

        JLabel heading = new JLabel("Dashboard");
        heading.setBounds(80, 10, 300, 40);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        p1.add(heading);

        // Panel on the left
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0, 0, 102));
        p2.setBounds(0, 65, 300, 900);
        add(p2);

        // Buttons in the left panel
        addPersonalDetails = new JButton("Add Personal Details");
        addPersonalDetails.setBounds(0, 0, 300, 50);
        addPersonalDetails.setBackground(new Color(0, 0, 102));
        addPersonalDetails.setForeground(Color.WHITE);
        addPersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        addPersonalDetails.setMargin(new Insets(0, 0, 0, 60));
        addPersonalDetails.addActionListener(this);
        p2.add(addPersonalDetails);

        updatePersonalDetails = new JButton("Update Personal Details");
        updatePersonalDetails.setBounds(0, 50, 300, 50);
        updatePersonalDetails.setBackground(new Color(0, 0, 102));
        updatePersonalDetails.setForeground(Color.WHITE);
        updatePersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        updatePersonalDetails.setMargin(new Insets(0, 0, 0, 30));
        updatePersonalDetails.addActionListener(this);
        p2.add(updatePersonalDetails);

        viewPersonalDetails = new JButton("View Details");
        viewPersonalDetails.setBounds(0, 100, 300, 50);
        viewPersonalDetails.setBackground(new Color(0, 0, 102));
        viewPersonalDetails.setForeground(Color.WHITE);
        viewPersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewPersonalDetails.setMargin(new Insets(0, 0, 0, 130));
        viewPersonalDetails.addActionListener(this);
        p2.add(viewPersonalDetails);
        
        deletePersonalDetails =new JButton("delete  Personal Details");
        deletePersonalDetails.setBounds(0,150,300,50);
        deletePersonalDetails.setBackground(new Color(0,0,102));
        deletePersonalDetails.setForeground(Color.WHITE);
        deletePersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        deletePersonalDetails.setMargin(new Insets(0,0,0,40));
        deletePersonalDetails.addActionListener(this);
        p2.add(deletePersonalDetails);
        
       checkpackages =new JButton("check package");
        checkpackages.setBounds(0,200,300,50);
        checkpackages.setBackground(new Color(0,0,102));
        checkpackages.setForeground(Color.WHITE);
       checkpackages.setFont(new Font("Tahoma",Font.PLAIN,20));
        checkpackages.setMargin(new Insets(0,0,0,110));
        checkpackages.addActionListener(this);
        p2.add(checkpackages);
        
        bookpackages =new JButton("book package");
        bookpackages.setBounds(0,250,300,50);
        bookpackages.setBackground(new Color(0,0,102));
        bookpackages.setForeground(Color.WHITE);
       bookpackages.setFont(new Font("Tahoma",Font.PLAIN,20));
        bookpackages.setMargin(new Insets(0,0,0,120));
        bookpackages.addActionListener(this);
        p2.add(bookpackages);
        
        viewpackages =new JButton(" view package");
         viewpackages.setBounds(0,300,300,50);
         viewpackages.setBackground(new Color(0,0,102));
         viewpackages .setForeground(Color.WHITE);
        viewpackages.setFont(new Font("Tahoma",Font.PLAIN,20));
         viewpackages.setMargin(new Insets(0,0,0,120));
         viewpackages.addActionListener(this);
        p2.add( viewpackages);
        

        viewhotels =new JButton(" View Hotels");
         viewhotels.setBounds(0,350,300,50);
         viewhotels.setBackground(new Color(0,0,102));
         viewhotels .setForeground(Color.WHITE);
         viewhotels.setFont(new Font("Tahoma",Font.PLAIN,20));
         viewhotels.setMargin(new Insets(0,0,0,130));
          viewhotels.addActionListener(this);
        p2.add( viewhotels);
        
        bookhotels =new JButton(" Book Hotels");
         bookhotels.setBounds(0,400,300,50);
         bookhotels.setBackground(new Color(0,0,102));
         bookhotels .setForeground(Color.WHITE);
         bookhotels.setFont(new Font("Tahoma",Font.PLAIN,20));
         bookhotels.setMargin(new Insets(0,0,0,140));
         bookhotels.addActionListener(this);
        p2.add( bookhotels);
        
        viewbookedhotel =new JButton("view Booked Hotel");
          viewbookedhotel.setBounds(0,450,300,50);
          viewbookedhotel.setBackground(new Color(0,0,102));
          viewbookedhotel .setForeground(Color.WHITE);
          viewbookedhotel.setFont(new Font("Tahoma",Font.PLAIN,20));
          viewbookedhotel.setMargin(new Insets(0,0,0,70));
          viewbookedhotel.addActionListener(this);
        p2.add( viewbookedhotel);
        
           destinations =new JButton(" destinations ");
         destinations .setBounds(0,500,300,50);
         destinations .setBackground(new Color(0,0,102));
         destinations  .setForeground(Color.WHITE);
        destinations .setFont(new Font("Tahoma",Font.PLAIN,20));
         destinations .setMargin(new Insets(0,0,0,125));
          destinations.addActionListener(this);
        p2.add( destinations );
         
        payments  =new JButton(" Payments");
         payments.setBounds(0,550,300,50);
         payments.setBackground(new Color(0,0,102));
         payments.setForeground(Color.WHITE);
        payments.setFont(new Font("Tahoma",Font.PLAIN,20));
        payments.setMargin(new Insets(0,0,0,155));
       payments.addActionListener(this);
        p2.add( payments);
        
        calculators =new JButton(" calculators");
         calculators.setBounds(0,600,300,50);
         calculators.setBackground(new Color(0,0,102));
         calculators.setForeground(Color.WHITE);
        calculators.setFont(new Font("Tahoma",Font.PLAIN,20));
        calculators.setMargin(new Insets(0,0,0,145));
        calculators.addActionListener(this);
        p2.add( calculators);
        
        
        notepad =new JButton("  Notepad ");
        notepad .setBounds(0,650,300,50);
        notepad .setBackground(new Color(0,0,102));
        notepad .setForeground(Color.WHITE);
        notepad .setFont(new Font("Tahoma",Font.PLAIN,20));
        notepad .setMargin(new Insets(0,0,0,155));
         notepad.addActionListener(this);
        p2.add(notepad );

         
        about =new JButton("About ");
        about .setBounds(0,700,300,50);
        about .setBackground(new Color(0,0,102));
        about .setForeground(Color.WHITE);
        about.setFont(new Font("Tahoma",Font.PLAIN,20));
        about.setMargin(new Insets(0,0,0,175));
        about.addActionListener(this);
        p2.add( about );



        // Background image
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i5 = i4.getImage().getScaledInstance(1650, 1000, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(0, 0, 1650, 1000);
        add(image);

        JLabel text = new JLabel("Travel and Tourism Management System");
        text.setBounds(400, 70, 1000, 70);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway", Font.PLAIN, 55));
        image.add(text);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == addPersonalDetails) {
            try {
                new AddCustomer(username).setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (ae.getSource() == viewPersonalDetails) {
            new ViewCustomer(username).setVisible(true);
        }
        else if (ae.getSource() == updatePersonalDetails){
            try {
                new UpdateCustomer(username).setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if (ae.getSource() == checkpackages) {
            new CheckPackage().setVisible(true);
        }
        else if (ae.getSource() == bookpackages) {
            new BookPackage(username).setVisible(true);
        }
        else if (ae.getSource() ==  viewpackages) {
            new ViewPackage(username).setVisible(true);
        }
          else if (ae.getSource() == viewhotels ) {
            new CheckHotels().setVisible(true);
        }
         else if (ae.getSource() == destinations ) {
            new Destinations().setVisible(true);
        }
        else if (ae.getSource() == bookhotels ) {
            new BookHotel(username).setVisible(true);
        }
        else if (ae.getSource() == viewbookedhotel ) {
            new ViewBookedHotel(username).setVisible(true);
        }
        else if (ae.getSource() ==  payments ) {
            new Payment().setVisible(true);
        }
        else if (ae.getSource() ==  calculators ) {
            try{
                Runtime.getRuntime().exec("calc.exe");
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        else if (ae.getSource() == about ) {
            new About().setVisible(true);
        }
        
        else if (ae.getSource() ==  notepad ) {
            try{
                Runtime.getRuntime().exec("notepad.exe");
            }catch(IOException e){
                e.printStackTrace();
            }
        }
         else if (ae.getSource() == deletePersonalDetails ) {
            try {
                new DeleteDetails(username).setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       
    }

    public static void main(String[] args) {
        new Dashboard("").setVisible(true);
    }
}
