import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Cursor;
import java.awt.Component;

public class gpacseswings{
    private JFrame frame;
    private JComboBox<String> semesterComboBox;
    private JButton showButton;
    private JTable subjectTable;
    private DefaultTableModel tableModel;
    private JButton calculateGPAButton;
    private String selectedSemester;

    public gpacseswings() {
        frame = new JFrame("GPA");
        frame.getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(new Color(84, 120, 197));

        semesterComboBox = new JComboBox<>(new String[]{"Semester 1", "Semester 2", "Semester 3", "Semester 4", "Semester 5", "Semester 6", "Semester 7", "Semester 8"});
        semesterComboBox.setForeground(new Color(255, 255, 255));
        semesterComboBox.setBorder(null);
        semesterComboBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        semesterComboBox.setBounds(360, 126, 234, 40);
        semesterComboBox.setBackground(new Color(67, 102, 150));
        frame.getContentPane().add(semesterComboBox);

        showButton = new JButton("Semester Details");
        showButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        showButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        showButton.setBorder(null);
        showButton.setBounds(360, 192, 234, 40);
        showButton.setBackground(new Color(23, 35, 51));
        showButton.setForeground(Color.WHITE);
        frame.getContentPane().add(showButton);

        tableModel = new DefaultTableModel(new String[]{"Subject Code", "Subject", "Grade"}, 0);
        subjectTable = new JTable(tableModel);
        subjectTable.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(createGradeComboBox()));
        JScrollPane tableScrollPane = new JScrollPane(subjectTable);
        tableScrollPane.setBounds(133, 271, 756, 269);
        tableScrollPane.setVisible(false); // Initially set the table to be invisible
        frame.getContentPane().add(tableScrollPane);

        calculateGPAButton = new JButton("Calculate GPA");
        calculateGPAButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        calculateGPAButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        calculateGPAButton.setBorder(null);
        calculateGPAButton.setBounds(391, 585, 203, 54);
        calculateGPAButton.setBackground(new Color(23, 35, 51));
        calculateGPAButton.setForeground(Color.WHITE);
        frame.getContentPane().add(calculateGPAButton);
        
        JLabel lblNewLabel = new JLabel("GPA CALCULATOR");
        lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 30));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(322, 42, 322, 30);
        frame.getContentPane().add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("-Designed for students of Computer Science & Engineering");
        lblNewLabel_1.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setFont(new Font("Calisto MT", Font.ITALIC, 18));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(288, 71, 431, 30);
        frame.getContentPane().add(lblNewLabel_1);

        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedSemester = (String) semesterComboBox.getSelectedItem();
                if ("Semester 1".equals(selectedSemester) ||
                    "Semester 2".equals(selectedSemester) ||
                    "Semester 3".equals(selectedSemester) ||
                    "Semester 4".equals(selectedSemester) ||
                    "Semester 5".equals(selectedSemester) ||
                    "Semester 6".equals(selectedSemester) ||
                    "Semester 7".equals(selectedSemester) ||
                    "Semester 8".equals(selectedSemester)) {
                    populateSubjectTable(selectedSemester);
                    tableScrollPane.setVisible(true); // Make the table visible
                } else {
                    tableModel.setRowCount(0); // Clear the table
                    tableScrollPane.setVisible(false); // Make the table invisible
                    JOptionPane.showMessageDialog(frame, "ENTER VALID SEMESTER", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        calculateGPAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double totalGradePoints = 0.0;
                int totalCredits = 0;

                for (int row = 0; row < tableModel.getRowCount(); row++) {
                    String selectedGrade = (String) tableModel.getValueAt(row, 2); // Get the selected grade
                    String subject = (String) tableModel.getValueAt(row, 1);
                    int credits = getSubjectCredits(selectedSemester, subject); // Get credits for the subject
                    double gradePoints = getGradePoints(selectedGrade); // Get the grade points for the selected grade

                    totalGradePoints += gradePoints * credits;
                    totalCredits += credits;
                }

                if (totalCredits > 0) {
                    double gpa = totalGradePoints / totalCredits;
                    String formattedGPA = String.format("%.2f", gpa); // Format GPA to two decimal places
                    JOptionPane.showMessageDialog(frame, "Your GPA is: " + formattedGPA, "GPA Calculation", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(frame, "No credits available for GPA calculation.", "GPA Calculation", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frame.setSize(1061, 762);
        frame.setVisible(true);
    }

    public void populateSubjectTable(String semester) {
        tableModel.setRowCount(0); // Clear the table

        String url = "jdbc:mysql://localhost:3306/gpa";
        String user = "root"; // Replace with your database username
        String password = ""; // Replace with your database password;
        String semesterWithoutSpaces = semester.replace(" ", "");

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT id, name FROM " + semesterWithoutSpaces;
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String subjectCode = resultSet.getString("id");
                String subjectName = resultSet.getString("name");
                tableModel.addRow(new Object[]{subjectCode, subjectName, "O"}); // Add a row with subject code, subject name, and grade
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Error: Unable to retrieve data", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private JComboBox<String> createGradeComboBox() {
        return new JComboBox<>(new String[]{"O", "A+", "A", "B+", "B", "C", "U"});
    }

    private int getSubjectCredits(String semester, String subject) {
        // Retrieve credits for the subject from the database
        // Replace with your database query to fetch credits for the subject
        String url = "jdbc:mysql://localhost:3306/gpa";
        String user = "root"; // Replace with your database username
        String password = ""; // Replace with your database password

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String semesterWithoutSpaces = semester.replace(" ", "");
            String sql = "SELECT credits FROM " + semesterWithoutSpaces + " WHERE name = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, subject);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt("credits");
            } else {
                return 0; // Return 0 credits if subject not found
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0; // Return 0 credits in case of an error
        }
    }

    private double getGradePoints(String grade) {
        switch (grade) {
            case "O":
                return 10.0;
            case "A+":
                return 9.0;
            case "A":
                return 8.0;
            case "B+":
                return 7.0;
            case "B":
                return 6.0;
            case "C":
                return 5.0;
            case "U":
                return 0.0;
            default:
                return 0.0; // Handle other cases as needed
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new gpacseswings();
            }
        });
    }
}
