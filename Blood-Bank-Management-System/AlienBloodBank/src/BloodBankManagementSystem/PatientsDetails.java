package BloodBankManagementSystem;

import ProjBack.ConnectionProvider;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ActionEvent;
import net.proteanit.sql.DbUtils;
import javax.swing.*;
import javax.swing.UIManager.*;
import javax.swing.table.DefaultTableModel;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@SuppressWarnings("serial")
public class PatientsDetails extends JFrame {

    /**
     * Creates new form PatientsDetails
     */
    public PatientsDetails() {
    	if (Login.isAdminUser) {
    		initComponents();
    	}
    }


    private void initComponents() {

        jLabel1 = new JLabel();
        jSeparator1 = new JSeparator();
        jScrollPane1 = new JScrollPane();
        patientDetailsTable = new JTable();
        jSeparator2 = new JSeparator();
        printBtn = new JButton();
        closeBtn = new JButton();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(new Point(250, 90));
        setUndecorated(true);
        addComponentListener(new ComponentAdapter() {
            public void componentShown(ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new AbsoluteLayout());

        jLabel1.setFont(new Font("Candara", 1, 30)); 
        jLabel1.setText("Patient Details");
        getContentPane().add(jLabel1, new AbsoluteConstraints(337, 19, -1, -1));
        getContentPane().add(jSeparator1, new AbsoluteConstraints(10, 62, 801, 10));

        patientDetailsTable.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        patientDetailsTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(patientDetailsTable);

        getContentPane().add(jScrollPane1, new AbsoluteConstraints(10, 70, 801, 340));
        getContentPane().add(jSeparator2, new AbsoluteConstraints(10, 420, 801, 10));

        printBtn.setBackground(new Color(0, 153, 204));
        printBtn.setFont(new Font("Candara", 1, 18)); 
        printBtn.setForeground(new Color(255, 255, 255));
        printBtn.setText("Print");
        printBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                printBtnActionPerformed(evt);
            }
        });
        getContentPane().add(printBtn, new AbsoluteConstraints(60, 440, 90, 40));

        closeBtn.setBackground(new Color(255, 0, 51));
        closeBtn.setFont(new Font("Candara", 1, 18)); 
        closeBtn.setForeground(new Color(255, 255, 255));
        closeBtn.setText("Close");
        closeBtn.setToolTipText("");
        closeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                closeBtnActionPerformed(evt);
            }
        });
        getContentPane().add(closeBtn, new AbsoluteConstraints(690, 440, 90, 40));
        getContentPane().add(jLabel2, new AbsoluteConstraints(0, 0, -1, -1));

        jLabel3.setIcon(new ImageIcon(getClass().getResource("/Images/allformsbg.png"))); 
        getContentPane().add(jLabel3, new AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }

    private void formComponentShown(ComponentEvent evt) {
        // TODO add your handling code here:
        try {
            Connection conn = ConnectionProvider.getCon();
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery("select * from patientdetails");
            //patientDetailsTable.setAutoResizeMode(patientDetailsTable.AUTO_RESIZE_OFF);
            patientDetailsTable.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void printBtnActionPerformed(ActionEvent evt) { 
        // TODO add your handling code here:
        try{
            patientDetailsTable.print(JTable.PrintMode.NORMAL);
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void closeBtnActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
        setVisible(false);
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
                    new PatientsDetails().setVisible(true);
                }
            });
		} else {
			System.out.println("You are not an Admin User");
		}

    }

    // Variables declaration - do not modify
    private JButton closeBtn;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JScrollPane jScrollPane1;
    private JSeparator jSeparator1;
    private JSeparator jSeparator2;
    private JTable patientDetailsTable;
    private JButton printBtn;
    // End of variables declaration
}
