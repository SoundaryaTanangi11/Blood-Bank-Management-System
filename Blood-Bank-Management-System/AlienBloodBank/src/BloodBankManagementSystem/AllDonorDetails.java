package BloodBankManagementSystem;

import ProjBack.ConnectionProvider;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import java.sql.Connection;
import javax.swing.*;
import java.sql.ResultSet;
import java.sql.Statement;
import net.proteanit.sql.DbUtils;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ActionEvent;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

@SuppressWarnings("serial")
public class AllDonorDetails extends JFrame {

    /**
     * Creates new form AllDonorDetails
     */
    public AllDonorDetails() {
    	if (Login.isAdminUser) {
    		initComponents();
    	}
    }


    private void initComponents() {

        jLabel1 = new JLabel();
        jSeparator1 = new JSeparator();
        jScrollPane1 = new JScrollPane();
        detailsTable = new JTable();
        jSeparator2 = new JSeparator();
        printBtn = new JButton();
        closeBtn = new JButton();
        jLabel2 = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(270, 90));
        setUndecorated(true);
        addComponentListener(new ComponentAdapter() {
            public void componentShown(ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Candara", 1, 30)); 
        jLabel1.setText("All Donors Details");
        getContentPane().add(jLabel1, new AbsoluteConstraints(300, 20, -1, -1));
        getContentPane().add(jSeparator1, new AbsoluteConstraints(10, 60, 801, 10));

        detailsTable.setFont(new java.awt.Font("Candara", 0, 14)); 
        detailsTable.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "null", "null", "null", "null"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        detailsTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(detailsTable);

        getContentPane().add(jScrollPane1, new AbsoluteConstraints(10, 80, 801, 340));
        getContentPane().add(jSeparator2, new AbsoluteConstraints(10, 430, 790, 10));

        printBtn.setBackground(new java.awt.Color(0, 153, 204));
        printBtn.setFont(new java.awt.Font("Candara", 1, 18)); 
        printBtn.setForeground(new java.awt.Color(255, 255, 255));
        printBtn.setText("Print");
        printBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                printBtnActionPerformed(evt);
            }
        });
        getContentPane().add(printBtn, new AbsoluteConstraints(30, 450, 90, 40));

        closeBtn.setBackground(new java.awt.Color(255, 0, 51));
        closeBtn.setFont(new java.awt.Font("Candara", 1, 18)); 
        closeBtn.setForeground(new java.awt.Color(255, 255, 255));
        closeBtn.setText("Close");
        closeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                closeBtnActionPerformed(evt);
            }
        });
        getContentPane().add(closeBtn, new AbsoluteConstraints(690, 450, 90, 40));

        jLabel2.setIcon(new ImageIcon(getClass().getResource("/Images/allformsbg.png"))); 
        getContentPane().add(jLabel2, new AbsoluteConstraints(0, 0, 820, 500));

        pack();
    }

    private void formComponentShown(ComponentEvent evt) {
        // TODO add your handling code here:
        try {
            Connection conn = ConnectionProvider.getCon();
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery("select * from donor");
            //detailsTable.setAutoResizeMode(detailsTable.AUTO_RESIZE_OFF);
            detailsTable.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }

    private void printBtnActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
        try{
            detailsTable.print(JTable.PrintMode.NORMAL);
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
       
    	createLookAndFeel();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	if (Login.isAdminUser==true) {
                new AllDonorDetails().setVisible(true);
            	}else {
            		System.out.println("You are not an Admin User");
            	}
            }
        });
    }

    // Variables declaration - do not modify
    private JButton closeBtn;
    private JTable detailsTable;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JScrollPane jScrollPane1;
    private JSeparator jSeparator1;
    private JSeparator jSeparator2;
    private JButton printBtn;
    // End of variables declaration
}
