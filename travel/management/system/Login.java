package travel.management.system;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.ResultSet;


public class Login extends JFrame implements ActionListener {
    JButton login, signup, password;
    JTextField tfusername;
    JPasswordField tfpassword; // Use JPasswordField for passwords

    Login() {
        setSize(900, 400);
        setLocation(350, 200);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        // Panel for the left side image
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(131, 193, 233));
        p1.setBounds(0, 0, 400, 400);
        p1.setLayout(null);
        add(p1);

        // Login image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(100, 120, 200, 200);
        p1.add(image);

        // Panel for the right side form
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(400, 30, 450, 300);
        add(p2);

        // Username label and text field
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(60, 20, 100, 25);
        lblusername.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
        p2.add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(60, 60, 300, 30);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfusername);

        // Password label and password field
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(60, 120, 100, 25);
        lblpassword.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
        p2.add(lblpassword);

        tfpassword = new JPasswordField(); // Use JPasswordField for added security
        tfpassword.setBounds(60, 150, 300, 30);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfpassword);

        // Login button
        login = new JButton("Login");
        login.setBounds(60, 200, 130, 30);
        login.setBackground(new Color(133, 193, 233));
        login.setForeground(Color.WHITE);
        login.setBorder(new LineBorder(new Color(133, 193, 233)));
        login.addActionListener(this);
        p2.add(login);

        // Sign up button
        signup = new JButton("Sign Up");
        signup.setBounds(230, 200, 130, 30);
        signup.setBackground(new Color(133, 193, 233));
        signup.setForeground(Color.WHITE);
        signup.setBorder(new LineBorder(new Color(133, 193, 233)));
        signup.addActionListener(this);
        p2.add(signup);

        // Forget password button
        password = new JButton("Forget Password");
        password.setBounds(130, 250, 130, 30);
        password.setBackground(new Color(133, 193, 233));
        password.setForeground(Color.WHITE);
        password.setBorder(new LineBorder(new Color(133, 193, 233)));
        password.addActionListener(this);
        p2.add(password);

        JLabel text = new JLabel("Trouble in login...");
        text.setBounds(300, 250, 150, 20);
        text.setForeground(Color.RED);
        p2.add(text);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            try {
                Conn c = new Conn();
                String sql = "SELECT * FROM account WHERE username = ? AND password = ?";
                PreparedStatement pst = c.c.prepareStatement(sql); // Use the Connection object to create a PreparedStatement
                pst.setString(1, tfusername.getText());
                pst.setString(2, new String(tfpassword.getPassword())); // Use getPassword() for JPasswordField

                // Execute the query without casting
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    this.setVisible(false);
                    new Loading(tfusername.getText()).setVisible(true); // Pass username to Loading
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Login or Password!");
                }
                // Close resources
                rs.close();
                pst.close();
                c.c.close();
            } catch (SQLException e) {
                e.printStackTrace(); // Print stack trace for SQL exceptions
                JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
            } catch (Exception e) {
                e.printStackTrace(); // Print stack trace for general exceptions
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
        } else if (ae.getSource() == signup) {
            setVisible(false);
            new Signup().setVisible(true);
        } else if (ae.getSource() == password) {
            setVisible(false);
            new ForgotPassword().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Login().setVisible(true);
    }
}
