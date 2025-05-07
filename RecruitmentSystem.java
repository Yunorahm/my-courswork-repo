import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class RecruitmentSystem extends JFrame {
    private JTextField txtVacancyNumber, txtStaffName;
    private JButton btnAddFullTime, btnDisplayAll;
    private ArrayList<StaffHire> staffList;

    public RecruitmentSystem() {
        super("Recruitment System");
        setLayout(new FlowLayout());

        System.out.println("WELCOME... Phillip's Recruitment System GUI Commencing...Powering Up...DONE.");

        // Initialize ArrayList
        staffList = new ArrayList<StaffHire>();

        // Label + TextField for Vacancy Number
        add(new JLabel("Vacancy Number:"));
        txtVacancyNumber = new JTextField(10);
        add(txtVacancyNumber);

        // Label + TextField for Staff Name
        add(new JLabel("Staff Name:"));
        txtStaffName = new JTextField(10);
        add(txtStaffName);

        // Button to Add Full Time Staff
        btnAddFullTime = new JButton("Add Full-Time Staff");
        add(btnAddFullTime);

        btnAddFullTime.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int vacancy = Integer.parseInt(txtVacancyNumber.getText());
                    String name = txtStaffName.getText();

                    FullTimeStaffHire staff = new FullTimeStaffHire(vacancy, "Developer", "Full-Time",
                            name, "2024-05-01", "Degree", "Manager", true, 30000.0, 40);

                    staffList.add(staff);
                    JOptionPane.showMessageDialog(null, "Full-Time Staff added!");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid Vacancy Number.");
                }
            }
        });

        // Button to Display All Staff
        btnDisplayAll = new JButton("Display All Staff");
        add(btnDisplayAll);

        btnDisplayAll.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (staffList.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No staff added yet.");
                } else {
                    for (StaffHire staff : staffList) {
                        staff.display();
                        System.out.println("---------------");
                    }
                }
            }
        });

        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new RecruitmentSystem();
    }
}
