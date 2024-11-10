package travel.management.system;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.Vector;
import java.sql.ResultSet;
import java.awt.event.*;

public class ViewCustomer extends JFrame implements ActionListener{
    private JPanel contentPane;
    private JTable table;
    private JLabel lblAvailability;
    private JLabel lblCleanStatus;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;
    private JLabel lblId;
    private String username;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                ViewCustomer frame = new ViewCustomer("pranitha"); // Provide a sample username for testing
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public ViewCustomer(String username) {
        this.username = username; // Properly set the username
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(580, 220, 900, 680);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Adding images to the frame
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i3 = i1.getImage().getScaledInstance(626, 201, Image.SCALE_DEFAULT);
        JLabel l1 = new JLabel(new ImageIcon(i3));
        l1.setBounds(0, 450, 626, 201);
        contentPane.add(l1);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i5 = i4.getImage().getScaledInstance(626, 201, Image.SCALE_DEFAULT);
        JLabel l2 = new JLabel(new ImageIcon(i5));
        l2.setBounds(615, 450, 626, 201);
        contentPane.add(l2);

        // Setting up the table
        table = new JTable();
        table.setBounds(0, 40, 900, 350);
        contentPane.add(table);

        // Load data from the database
        loadCustomerData();

        // Back button
        JButton btnNewButton = new JButton("Back");
        btnNewButton.addActionListener(e -> setVisible(false));
        btnNewButton.setBounds(390, 400, 120, 30);
        btnNewButton.setBackground(Color.BLACK);
        btnNewButton.setForeground(Color.WHITE);
        btnNewButton.addActionListener(this);
        contentPane.add(btnNewButton);

        // Adding labels to the frame
        lblAvailability = new JLabel("Username");
        lblAvailability.setBounds(10, 15, 69, 14);
        contentPane.add(lblAvailability);

        lblCleanStatus = new JLabel("Id Type");
        lblCleanStatus.setBounds(110, 15, 76, 14);
        contentPane.add(lblCleanStatus);

        lblNewLabel = new JLabel("Number");
        lblNewLabel.setBounds(220, 15, 46, 14);
        contentPane.add(lblNewLabel);

        lblNewLabel_1 = new JLabel("Name");
        lblNewLabel_1.setBounds(320, 15, 76, 14);
        contentPane.add(lblNewLabel_1);

        lblId = new JLabel("Gender");
        lblId.setBounds(420, 15, 90, 14);
        contentPane.add(lblId);

        JLabel l3 = new JLabel("Country");
        l3.setBounds(520, 15, 90, 14);
        contentPane.add(l3);

        JLabel l4 = new JLabel("Address");
        l4.setBounds(620, 15, 90, 14);
        contentPane.add(l4);

        JLabel l5 = new JLabel("Phone");
        l5.setBounds(720, 15, 90, 14);
        contentPane.add(l5);

        JLabel l6 = new JLabel("Email");
        l6.setBounds(820, 15, 90, 14);
        contentPane.add(l6);

        getContentPane().setBackground(Color.WHITE);
    }

    private void loadCustomerData() {
        try {
            Conn c = new Conn();
            String query = "SELECT * FROM customer WHERE username = '" + username + "'";
            ResultSet rs = c.s.executeQuery(query);

            // Use custom method to set table model
            table.setModel(buildTableModel(rs));

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading customer data: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Custom method to convert ResultSet to TableModel
    public static DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();

        // Column names
        Vector<String> columnNames = new Vector<>();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }

        // Data rows
        Vector<Vector<Object>> data = new Vector<>();
        while (rs.next()) {
            Vector<Object> row = new Vector<>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                row.add(rs.getObject(columnIndex));
            }
            data.add(row);
        }

        return new DefaultTableModel(data, columnNames);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       setVisible(false);
    }
}
