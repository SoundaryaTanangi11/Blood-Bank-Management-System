package BloodBankManagementSystem;

import ProjBack.ConnectionProvider;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.UIManager.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.sql.ResultSet;

import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import net.proteanit.sql.DbUtils;

@SuppressWarnings("serial")
public class RegisteredCampDonor extends JFrame {

    /**
     * Creates new form RegisteredCampDonor
     */
    public RegisteredCampDonor() {
        initComponents();
    }

    private void initComponents() {

        jLabel1 = new JLabel();
        jSeparator1 = new JSeparator();
        jScrollPane1 = new JScrollPane();
        regDonorTable = new JTable();
        jSeparator2 = new JSeparator();
        printBtn = new JButton();
        closeBtn = new JButton();
        jLabel2 = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(new Point(250, 80));
        setUndecorated(true);
        addComponentListener(new ComponentAdapter() {
            public void componentShown(ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new AbsoluteLayout());

        jLabel1.setFont(new Font("Candara", 1, 30)); 
        jLabel1.setText("Donors Registered for Camp");
        getContentPane().add(jLabel1, new AbsoluteConstraints(180, 20, -1, -1));
        getContentPane().add(jSeparator1, new AbsoluteConstraints(10, 59, 700, 10));

        regDonorTable.setFont(new Font("Candara", 0, 14)); 
        regDonorTable.setModel(new DefaultTableModel(
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
        jScrollPane1.setViewportView(regDonorTable);

        getContentPane().add(jScrollPane1, new AbsoluteConstraints(10, 75, 700, 347));
        getContentPane().add(jSeparator2, new AbsoluteConstraints(10, 433, 700, 10));

        printBtn.setBackground(new Color(0, 153, 204));
        printBtn.setFont(new Font("Candara", 1, 18)); 
        printBtn.setForeground(new Color(255, 255, 255));
        printBtn.setText("Print");
        printBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                printBtnActionPerformed(evt);
            }
        });
        getContentPane().add(printBtn, new AbsoluteConstraints(40, 450, 80, 40));

        closeBtn.setBackground(new Color(255, 0, 51));
        closeBtn.setFont(new Font("Candara", 1, 18)); 
        closeBtn.setForeground(new Color(255, 255, 255));
        closeBtn.setText("Close");
        closeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                closeBtnActionPerformed(evt);
            }
        });
        getContentPane().add(closeBtn, new AbsoluteConstraints(590, 450, 80, 40));

        jLabel2.setIcon(new ImageIcon(getClass().getResource("/Images/allformsbg.png"))); 
        getContentPane().add(jLabel2, new AbsoluteConstraints(0, 0, 720, -1));

        pack();
    }

    private void closeBtnActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
        setVisible(false);
    }

    private void printBtnActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
        try{
            regDonorTable.print(JTable.PrintMode.NORMAL);
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void formComponentShown(ComponentEvent evt) {
        // TODO add your handling code here:
    	try {
            Connection conn = ConnectionProvider.getCon();
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery("select * from donationCampDonors");
            //regDonorTable.setAutoResizeMode(regDonorTable.AUTO_RESIZE_OFF);
            regDonorTable.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
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
    	createLookAndFeel() ;
        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisteredCampDonor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private JButton closeBtn;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JScrollPane jScrollPane1;
    private JSeparator jSeparator1;
    private JSeparator jSeparator2;
    private JButton printBtn;
    private JTable regDonorTable;
}
