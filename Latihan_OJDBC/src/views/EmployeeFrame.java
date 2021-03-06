/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.DepartmentController;
import controllers.EmployeeController;
import controllers.JobController;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Department;
import models.Employee;
import models.Job;
import tools.Connections;

/**
 *
 * @author kresna92
 */
public class EmployeeFrame extends javax.swing.JInternalFrame {

    private DefaultTableModel model;
    Connections connections = new Connections();
    EmployeeController econ = new EmployeeController(connections.getConnection());
    JobController jcon = new JobController(connections.getConnection());
    DepartmentController dcon = new DepartmentController(connections.getConnection());

    /**
     * Creates new form EmployeeFrame
     */
    public EmployeeFrame() {

        initComponents();
        loadData();
        loadCombo();

    }

    public void loadData() {
        String header[] = {"Nomor", "Employee ID", "First Name",
            "Last Name", "Email", "Phone Number", "Hire Date", "Job", "Salary",
            "Commission", "Manager", "Department"};
        List<Employee> employees = econ.getDataAll();
        int g = 1;
        Object[][] datas = new Object[employees.size()][header.length];
        for (int i = 0; i < employees.size(); i++) {
            Job job = jcon.getById(employees.get(i).getJob());
            Employee manager = econ.getById(Integer.toString(employees.get(i).getId()));
            datas[i][0] = g++;
            datas[i][1] = employees.get(i).getId();
            datas[i][2] = employees.get(i).getFirst_name();
            datas[i][3] = employees.get(i).getLast_name();
            datas[i][4] = employees.get(i).getEmail();
            datas[i][5] = employees.get(i).getPhone();
            datas[i][6] = employees.get(i).getHire();
            datas[i][7] = job.getJobTitle();
            datas[i][8] = employees.get(i).getSalary();
            datas[i][9] = employees.get(i).getCommission();
            datas[i][10] = manager.getFirst_name() + " " + manager.getLast_name();
            if (employees.get(i).getDepartment() == 0) {
            } else {
                Department department = dcon.getById(Integer.toString(employees.get(i).getDepartment()));
                datas[i][11] = department.getDepartmentName();
            }

        }
        model = new DefaultTableModel(datas, header);
        empTable.setModel(model);

    }

    public void select() {
        int i = empTable.getSelectedRow();
        if (i == -1) {
            return;
        }
        List<Job> job = jcon.getData();
        List<Employee> mgr = econ.getDataAll();
        List<Department> dpt = dcon.getDepartmentList();
        Date d = (Date) model.getValueAt(i, 6);

        idField.setText(Integer.toString((int) model.getValueAt(i, 1)));
        firstnameField.setText(String.valueOf(model.getValueAt(i, 2)));
        lastnameField.setText(String.valueOf(model.getValueAt(i, 3)));
        emailField.setText(String.valueOf(model.getValueAt(i, 4)));
        phonenumberField.setText(String.valueOf(model.getValueAt(i, 5)));
        hiredateChooser.setDate(d);
        salaryField.setText(String.valueOf(model.getValueAt(i, 8)));
        commissionField.setText(String.valueOf(model.getValueAt(i, 9)));
        for (int j = 0; j < mgr.size(); j++) {
            String a = mgr.get(j).getFirst_name() + " " + mgr.get(j).getLast_name();
            if (j < job.size()) {
                if (job.get(j).getJobTitle().equals(model.getValueAt(i, 7))) {
                    jobList.setSelectedIndex(j);
                }
            }
            if (j < dpt.size()) {
                if (dpt.get(j).getDepartmentName().equals(model.getValueAt(i, 11))) {
                    departmentField.setSelectedIndex(j);
                }
            }
            if (j < mgr.size()) {
                if (a.equals(model.getValueAt(i, 10))) {
                    managerField.setSelectedIndex(j);
                }

                insertupdateButton.setText("UPDATE");

            }
        }
    }

    public void resetData() {
        idField.setText(econ.getMaxEmpId() + "");
        firstnameField.setText("");
        lastnameField.setText("");
        emailField.setText("");
        phonenumberField.setText("");
        jobList.setSelectedIndex(0);
        salaryField.setText("");
        commissionField.setText("");
        managerField.setSelectedIndex(0);
        departmentField.setSelectedIndex(0);
        searchField.setText("");
        jobList.setSelectedIndex(1);
        hiredateChooser.setDate(new Date());
        insertupdateButton.setText("INSERT");
    }

    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeFrame().setVisible(true);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        searchButton = new javax.swing.JButton();
        searchField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        empTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        idField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        firstnameField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lastnameField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        phonenumberField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        hiredateChooser = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        salaryField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        commissionField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        insertupdateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        jobList = new javax.swing.JComboBox<>();
        managerField = new javax.swing.JComboBox<>();
        departmentField = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("EMPLOYEE");
        setMinimumSize(new java.awt.Dimension(583, 1011));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(583, 1011));
        setVisible(true);

        searchButton.setText("CARI");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        empTable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        empTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10", "Title 11"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        empTable.setMinimumSize(new java.awt.Dimension(800, 64));
        empTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                empTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(empTable);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Employee Data"));

        idField.setEditable(false);
        int i = econ.getMaxEmpId()+1;
        idField.setText(Integer.toString(i));

        jLabel1.setText("ID");

        jLabel2.setText("First Name");

        jLabel3.setText("Last Name");

        jLabel4.setText("Email");

        jLabel5.setText("Phone");

        jLabel6.setText("Hire Date");

        jLabel7.setText("Job");

        jLabel8.setText("Salary");

        jLabel9.setText("Commission");

        jLabel10.setText("Manager");

        jLabel11.setText("Department");

        insertupdateButton.setText("INSERT");
        insertupdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertupdateButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("DELETE");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel1))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(insertupdateButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deleteButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(commissionField, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(salaryField, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phonenumberField)
                            .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lastnameField, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(firstnameField, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(managerField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(departmentField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hiredateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jobList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {commissionField, emailField, firstnameField, idField, lastnameField, phonenumberField, salaryField});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(firstnameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastnameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(phonenumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(hiredateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jobList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(salaryField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(commissionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(managerField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(departmentField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(insertupdateButton)
                    .addComponent(deleteButton)))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {commissionField, emailField, firstnameField, idField, lastnameField, phonenumberField, salaryField});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(searchButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchButton)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        String header[] = {"Employee ID", "First Name",
            "Last Name", "Email", "Phone Number", "Hire Date", "Job", "Salary",
            "Commission", "Manager", "Department"};
        List<Employee> employees = econ.search(searchField.getText());
        Object[][] datas = new Object[employees.size()][header.length];
        for (int i = 0; i < employees.size(); i++) {
            datas[i][0] = employees.get(i).getId();
            datas[i][1] = employees.get(i).getFirst_name();
            datas[i][2] = employees.get(i).getLast_name();
            datas[i][3] = employees.get(i).getEmail();
            datas[i][4] = employees.get(i).getPhone();
            datas[i][5] = employees.get(i).getHire();
            datas[i][6] = employees.get(i).getJob();
            datas[i][7] = employees.get(i).getSalary();
            datas[i][8] = employees.get(i).getCommission();
            datas[i][9] = employees.get(i).getManager();
            datas[i][10] = employees.get(i).getDepartment();
        }
        model = new DefaultTableModel(datas, header);
        empTable.setModel(model);
    }//GEN-LAST:event_searchButtonActionPerformed


    private void empTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_empTableMouseClicked
        select();
    }//GEN-LAST:event_empTableMouseClicked

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int selectedOption = JOptionPane.showConfirmDialog(null, "Apakah Ingin Dihapus?");
        if (selectedOption == JOptionPane.YES_OPTION) {
            econ.delete(idField.getText());
        }
        loadData();
        resetData();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void insertupdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertupdateButtonActionPerformed
        if (insertupdateButton.getText() == "INSERT") {
            econ.insert(idField.getText(), firstnameField.getText(),
                lastnameField.getText(), emailField.getText(), phonenumberField.getText(),
                hiredateChooser.getDate(),
                new String(jobList.getItemAt(jobList.getSelectedIndex()).
                    substring(0, jobList.getItemAt(jobList.getSelectedIndex()).indexOf("-"))),
                salaryField.getText(),
                commissionField.getText(),
                new String(managerField.getItemAt(managerField.getSelectedIndex()).
                    substring(0, managerField.getItemAt(managerField.getSelectedIndex()).indexOf("-"))),
                new String(departmentField.getItemAt(departmentField.getSelectedIndex()).
                    substring(0, departmentField.getItemAt(departmentField.getSelectedIndex()).indexOf("-"))));
            JOptionPane.showMessageDialog(null, "Insert Berhasil!");

        } else {
            econ.update(idField.getText(), firstnameField.getText(),
                lastnameField.getText(), emailField.getText(), phonenumberField.getText(),
                hiredateChooser.getDate(),
                new String(jobList.getItemAt(jobList.getSelectedIndex()).
                    substring(0, jobList.getItemAt(jobList.getSelectedIndex()).indexOf("-"))),
                salaryField.getText(),
                commissionField.getText(),
                new String(managerField.getItemAt(managerField.getSelectedIndex()).
                    substring(0, managerField.getItemAt(managerField.getSelectedIndex()).indexOf("-"))),
                new String(departmentField.getItemAt(departmentField.getSelectedIndex()).
                    substring(0, departmentField.getItemAt(departmentField.getSelectedIndex()).indexOf("-"))));
            JOptionPane.showMessageDialog(null, "Update Berhasil!");
        }

        loadData();
        resetData();
    }//GEN-LAST:event_insertupdateButtonActionPerformed

    private void loadCombo() {
        for (Job job : new JobController(connections.getConnection()).getData()) {
            jobList.addItem(job.getJobId() + "-" + job.getJobTitle());
        }
        for (Employee emp : new EmployeeController(connections.getConnection()).getDataAll()) {
            managerField.addItem(emp.getId() + "-" + emp.getFirst_name() + " " + emp.getLast_name());
        }
        for (Department dpt : new DepartmentController(connections.getConnection()).getDepartmentList()) {
            departmentField.addItem(dpt.getDepartmentId() + "-" + dpt.getDepartmentName());
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField commissionField;
    private javax.swing.JButton deleteButton;
    private javax.swing.JComboBox<String> departmentField;
    private javax.swing.JTextField emailField;
    private javax.swing.JTable empTable;
    private javax.swing.JTextField firstnameField;
    private com.toedter.calendar.JDateChooser hiredateChooser;
    private javax.swing.JTextField idField;
    private javax.swing.JButton insertupdateButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> jobList;
    private javax.swing.JTextField lastnameField;
    private javax.swing.JComboBox<String> managerField;
    private javax.swing.JTextField phonenumberField;
    private javax.swing.JTextField salaryField;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchField;
    // End of variables declaration//GEN-END:variables
}
