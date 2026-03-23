package BloodBankManagementSystem;

import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.sql.*;
import ProjBack.ConnectionProvider;
import java.text.SimpleDateFormat;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager.*;
import javax.swing.UnsupportedLookAndFeelException;

import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


@SuppressWarnings("serial")
public class AddNewDonor extends JFrame {
    public static String bg;
    /**
     * Creates new form addNewDonor
     */
    public AddNewDonor() {
    	if (Login.isAdminUser) {
    		initComponents();
    	}
    }

    
    private void initComponents() {

        jLabel1 = new JLabel();
        jSeparator1 = new JSeparator();
        jLabel2 = new JLabel();
        donorId = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();
        jLabel9 = new JLabel();
        dName = new JTextField();
        dFname = new JTextField();
        dMname = new JTextField();
        dMobile = new JTextField();
        dGender = new JComboBox<>();
        jLabel10 = new JLabel();
        jLabel11 = new JLabel();
        jLabel12 = new JLabel();
        jLabel13 = new JLabel();
        dEmail = new JTextField();
        dBloodGrp = new JComboBox<>();
        jScrollPane1 = new JScrollPane();
        dAddress = new JTextArea();
        dCity = new JTextField();
        jSeparator2 = new JSeparator();
        saveBtn = new JButton();
        resetBtn = new JButton();
        closebtn = new JButton();
        dDob = new com.toedter.calendar.JDateChooser();
        jLabel3 = new JLabel();
        jLabel15 = new JLabel();
        jLabel14 = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(250, 90));
        setUndecorated(true);
        addComponentListener(new ComponentAdapter() {
            public void componentShown(ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Candara", 1, 30));
        jLabel1.setText("Add New Donor");
        getContentPane().add(jLabel1, new AbsoluteConstraints(333, 11, -1, -1));
        getContentPane().add(jSeparator1, new AbsoluteConstraints(10, 59, 801, 10));

        jLabel2.setFont(new java.awt.Font("Candara", 1, 14)); 
        jLabel2.setText("New Donor Id");
        getContentPane().add(jLabel2, new AbsoluteConstraints(54, 89, -1, -1));

        donorId.setFont(new java.awt.Font("Candara", 1, 18)); 
        donorId.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(donorId, new AbsoluteConstraints(183, 87, 170, -1));

        jLabel4.setFont(new java.awt.Font("Candara", 1, 14)); 
        jLabel4.setText("Full Name");
        getContentPane().add(jLabel4, new AbsoluteConstraints(54, 128, -1, -1));

        jLabel5.setFont(new java.awt.Font("Candara", 1, 14)); 
        jLabel5.setText("Father's Name");
        getContentPane().add(jLabel5, new AbsoluteConstraints(54, 170, -1, -1));

        jLabel6.setFont(new java.awt.Font("Candara", 1, 14)); 
        jLabel6.setText("Mother's Name");
        getContentPane().add(jLabel6, new AbsoluteConstraints(54, 212, -1, -1));

        jLabel7.setFont(new java.awt.Font("Candara", 1, 14)); 
        jLabel7.setText("Date of Birth");
        getContentPane().add(jLabel7, new AbsoluteConstraints(54, 253, -1, -1));

        jLabel8.setFont(new java.awt.Font("Candara", 1, 14)); 
        jLabel8.setText("Mobile No.");
        getContentPane().add(jLabel8, new AbsoluteConstraints(54, 292, -1, -1));

        jLabel9.setFont(new java.awt.Font("Candara", 1, 14)); 
        jLabel9.setText("Gender");
        getContentPane().add(jLabel9, new AbsoluteConstraints(54, 335, -1, -1));

        dName.setFont(new java.awt.Font("Candara", 0, 14)); 
        dName.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dNameActionPerformed(evt);
            }
        });
        getContentPane().add(dName, new AbsoluteConstraints(183, 125, 170, -1));

        dFname.setFont(new java.awt.Font("Candara", 0, 14)); 
        getContentPane().add(dFname, new AbsoluteConstraints(183, 167, 170, -1));

        dMname.setFont(new java.awt.Font("Candara", 0, 14)); 
        getContentPane().add(dMname, new AbsoluteConstraints(183, 209, 170, -1));

        dMobile.setFont(new java.awt.Font("Candara", 0, 14)); 
        getContentPane().add(dMobile, new AbsoluteConstraints(183, 289, 160, -1));

        dGender.setFont(new java.awt.Font("Candara", 0, 14)); 
        dGender.setModel(new DefaultComboBoxModel<>(new String[] { "Male", "Female", "Others" }));
        dGender.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dGenderActionPerformed(evt);
            }
        });
        getContentPane().add(dGender, new AbsoluteConstraints(183, 332, 170, -1));

        jLabel10.setFont(new java.awt.Font("Candara", 1, 14)); 
        jLabel10.setText("Email ");
        getContentPane().add(jLabel10, new AbsoluteConstraints(450, 128, 50, -1));

        jLabel11.setFont(new java.awt.Font("Candara", 1, 14)); 
        jLabel11.setText("Blood Group");
        getContentPane().add(jLabel11, new AbsoluteConstraints(450, 170, -1, -1));

        jLabel12.setFont(new java.awt.Font("Candara", 1, 14)); 
        jLabel12.setText("Address");
        getContentPane().add(jLabel12, new AbsoluteConstraints(450, 212, -1, -1));

        jLabel13.setFont(new java.awt.Font("Candara", 1, 14)); 
        jLabel13.setText("City");
        getContentPane().add(jLabel13, new AbsoluteConstraints(450, 335, 40, -1));

        dEmail.setFont(new java.awt.Font("Candara", 0, 14)); 
        dEmail.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dEmailActionPerformed(evt);
            }
        });
        getContentPane().add(dEmail, new AbsoluteConstraints(585, 125, 170, -1));

        dBloodGrp.setFont(new java.awt.Font("Candara", 0, 14)); 
        dBloodGrp.setModel(new DefaultComboBoxModel<>(new String[] { "A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-" }));
        getContentPane().add(dBloodGrp, new AbsoluteConstraints(585, 167, 170, -1));

        dAddress.setColumns(20);
        dAddress.setFont(new java.awt.Font("Candara", 0, 14)); 
        dAddress.setRows(5);
        jScrollPane1.setViewportView(dAddress);

        getContentPane().add(jScrollPane1, new AbsoluteConstraints(585, 209, 170, -1));

        dCity.setFont(new java.awt.Font("Candara", 0, 14)); 
        getContentPane().add(dCity, new AbsoluteConstraints(585, 332, 170, -1));
        getContentPane().add(jSeparator2, new AbsoluteConstraints(10, 392, 801, 10));

        saveBtn.setBackground(new java.awt.Color(0, 153, 0));
        saveBtn.setFont(new java.awt.Font("Candara", 1, 18)); 
        saveBtn.setForeground(new java.awt.Color(255, 255, 255));
        saveBtn.setText("Save");
        saveBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });
        getContentPane().add(saveBtn, new AbsoluteConstraints(162, 420, 90, 40));

        resetBtn.setBackground(new java.awt.Color(0, 153, 255));
        resetBtn.setFont(new java.awt.Font("Candara", 1, 18)); 
        resetBtn.setForeground(new java.awt.Color(255, 255, 255));
        resetBtn.setText("Reset");
        resetBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                resetBtnActionPerformed(evt);
            }
        });
        getContentPane().add(resetBtn, new AbsoluteConstraints(368, 420, 90, 40));

        closebtn.setBackground(new java.awt.Color(255, 0, 51));
        closebtn.setFont(new java.awt.Font("Candara", 1, 18)); 
        closebtn.setForeground(new java.awt.Color(255, 255, 255));
        closebtn.setText("Close");
        closebtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                closebtnActionPerformed(evt);
            }
        });
        getContentPane().add(closebtn, new AbsoluteConstraints(586, 420, 90, 40));

        dDob.setFont(new java.awt.Font("Candara", 0, 14)); 
        getContentPane().add(dDob, new AbsoluteConstraints(183, 251, 170, -1));
        getContentPane().add(jLabel3, new AbsoluteConstraints(0, 0, 820, -1));
        getContentPane().add(jLabel15, new AbsoluteConstraints(120, 30, -1, -1));

        jLabel14.setIcon(new ImageIcon(getClass().getResource("/Images/allformsbg.png"))); 
        getContentPane().add(jLabel14, new AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }

    private void formComponentShown(ComponentEvent evt) {
        // TODO add your handling code here:
        try{
        	
            Connection conn = ConnectionProvider.getCon();
            Statement stat = conn.createStatement(
            		ResultSet.TYPE_SCROLL_INSENSITIVE,
        		    ResultSet.CONCUR_READ_ONLY);
            
            ResultSet rs = stat.executeQuery("select max(donorId) donorId from Donor");
            
       /*     ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) System.out.print(",  ");
                    String columnValue = rs.getString(i);
                    System.out.print(columnValue + " " + rsmd.getColumnName(i));
                }
                System.out.println("");
            }
            System.out.println(rs);
            */
            if (rs.first()) {
                int id = rs.getInt(1);
                id = id + 1;
                String str = String.valueOf(id);
                donorId.setText(str);
                
            }
            else {
                donorId.setText("1");
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void dNameActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void dGenderActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void dEmailActionPerformed(ActionEvent evt) {

        // TODO add your handling code here:
    }

    private void saveBtnActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
        long dId = Long.parseLong(donorId.getText());
        String name = dName.getText();
        String fatherName = dFname.getText();
        String motherName = dMname.getText();
        SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
        String dob = dFormat.format(dDob.getDate());
        long mobileNo = Long.parseLong(dMobile.getText());
        String gender = (String)dGender.getSelectedItem();
        String email = dEmail.getText();
        String bloodGrp = (String)dBloodGrp.getSelectedItem();
        String address = dAddress.getText();
        String city = dCity.getText();
        
        
        
        try{
            Connection conn = ConnectionProvider.getCon();
//            stat.executeUpdate("insert into donatedblood(name, dateOfPurchase, 
 //           mobileNo, gender, email, bloodGrp, address, city ) 
//values ('" +name+ "', '" +dob+ "', '" +mobileNo+ "', '" +gender+ "', 
//		'" +email+ "', '" +bloodGrp+ "', '" +address+ "', '" +city+ "')");
            
            PreparedStatement stat = conn.prepareStatement("insert into donor values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            stat.setLong(1, dId);
            stat.setString(2, name);
            stat.setString(3, fatherName);
            stat.setString(4, motherName);
            stat.setString(5, dob);
            stat.setLong(6, mobileNo);
            stat.setString(7, gender);
            stat.setString(8, email);
            stat.setString(9, bloodGrp);
            stat.setString(10, address);
            stat.setString(11, city);
            
            stat.executeUpdate();
            
            bg = dBloodGrp.getSelectedItem().toString();
            if (bg.equals("A+")) {
                stat = conn.prepareStatement("select packetsofBlood from bloodquantity where bloodGrp='"+bg+"'");
            }
            if (bg.equals("A-")) {
                stat = conn.prepareStatement("select packetsofBlood from bloodquantity where bloodGrp='"+bg+"'");
            }
            if (bg.equals("B+")) {
                stat = conn.prepareStatement("select packetsofBlood from bloodquantity where bloodGrp='"+bg+"'");
            }
            if (bg.equals("B-")) {
                stat = conn.prepareStatement("select packetsofBlood from bloodquantity where bloodGrp='"+bg+"'");
            }
            if (bg.equals("O+")) {
                stat = conn.prepareStatement("select packetsofBlood from bloodquantity where bloodGrp='"+bg+"'");
            }
            if (bg.equals("O-")) {
                stat = conn.prepareStatement("select packetsofBlood from bloodquantity where bloodGrp='"+bg+"'");
            }
            if (bg.equals("AB+")) {
                stat = conn.prepareStatement("select packetsofBlood from bloodquantity where bloodGrp='"+bg+"'");
            }
            if (bg.equals("AB-")) {
                stat = conn.prepareStatement("select packetsofBlood from bloodquantity where bloodGrp='"+bg+"'");
            }

            ResultSet rs = stat.executeQuery();
            rs.next();
            int pkno = rs.getInt(1);
//            if (pkno == 0) {
//                JOptionPane.showMessageDialog(this, "First Donor of this Blood Group", "Note", JOptionPane.PLAIN_MESSAGE);
//            }
//            
                pkno += 1;
                stat = conn.prepareStatement("update bloodquantity set packetsofBlood=? where bloodGrp=?");
                stat.setInt(1, pkno);
                stat.setString(2, bg);
                this.dispose();
                stat.executeUpdate();
           
            JOptionPane.showMessageDialog(null, "Donor Details Added Successfully");
            setVisible(false);
            new AddNewDonor().setVisible(true);
        }
            
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void closebtnActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
        setVisible(false);
    }

    private void resetBtnActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
        setVisible(false);
        new AddNewDonor().setVisible(true);
    }

    public static void createLookAndFeel() {
    	try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			System.out.println(ex);
		} catch (InstantiationException ex) {
			System.err.println(ex);
		} catch (IllegalAccessException ex) {
			System.err.println(ex);
		} catch (UnsupportedLookAndFeelException ex) {
			System.err.println(ex);
		}
	}

    public static void main(String args[]) {
        /* Create and display the form */
    	
    	if (Login.isAdminUser == true) {
        	createLookAndFeel();
    		EventQueue.invokeLater(new Runnable() {
                public void run() {
            		new AddNewDonor().setVisible(true);
                }
            });
		} else {
			System.out.println("You are not an Admin User");
		}
    	
    }

    // Variables declaration - do not modify
    private JButton closebtn;
    private JTextArea dAddress;
    private JComboBox<String> dBloodGrp;
    private JTextField dCity;
    private com.toedter.calendar.JDateChooser dDob;
    private JTextField dEmail;
    private JTextField dFname;
    private JComboBox<String> dGender;
    private JTextField dMname;
    private JTextField dMobile;
    private JTextField dName;
    private JLabel donorId;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel14;
    private JLabel jLabel15;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JScrollPane jScrollPane1;
    private JSeparator jSeparator1;
    private JSeparator jSeparator2;
    private JButton resetBtn;
    private JButton saveBtn;
    // End of variables declaration
}
