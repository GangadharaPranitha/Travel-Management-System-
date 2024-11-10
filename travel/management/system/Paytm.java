package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Paytm extends JFrame {
    
    Paytm() {
        // Create a JButton to load the webpage
        JButton loadPageButton = new JButton("Open Paytm Website");
        
        loadPageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openWebPage("https://paytm.com/electricity-bill-payment");
            }
        });
        
        // Set up the layout for the JFrame
        setLayout(new FlowLayout());
        add(loadPageButton);  // Add the button to the JFrame
        
        // Create the Back button to close the window
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);  // Close the window
            }
        });
        add(backButton);  // Add the Back button to the JFrame
        
        // JFrame properties
        setSize(800, 600);
        setLocation(600, 220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // Method to open the webpage in the default web browser
    private void openWebPage(String url) {
        try {
            // Check if Desktop is supported and can open the URL
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                URI uri = new URI(url);
                desktop.browse(uri);  // Opens the default web browser
            } else {
                JOptionPane.showMessageDialog(this, "Desktop is not supported on your platform.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error opening web page: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Launch the application
        new Paytm();
    }
}
