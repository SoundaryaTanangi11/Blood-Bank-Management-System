package BloodBankManagementSystem;

import ProjBack.ConnectionProvider;
import java.awt.*;
import java.awt.event.ActionListener;
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
public class SearchDonorByLocation extends JFrame {

    /**
     * Creates new form searchDonorByLocation
     */
    public SearchDonorByLocation() {
    	if (Login.isAdminUser) {
    		initComponents();
    	}
    }

    private void initComponents() {

        jLabel1 = new JLabel();
        jSeparator1 = new JSeparator();
        jLabel2 = new JLabel();
        location = new JTextField();
        jSeparator2 = new JSeparator();
        jScrollPane1 = new JScrollPane();
        locationTable = new JTable();
        jSeparator3 = new JSeparator();
        printBtn = new JButton();
        closeBtn = new JButton();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(new Point(270, 90));
        setUndecorated(true);
        getContentPane().setLayout(new AbsoluteLayout());

        jLabel1.setFont(new Font("Candara", 1, 30)); 
        jLabel1.setText("Search Blood Donor by Location");
        getContentPane().add(jLabel1, new AbsoluteConstraints(205, 11, -1, -1));
        getContentPane().add(jSeparator1, new AbsoluteConstraints(10, 54, 801, 10));

        jLabel2.setFont(new Font("Candara", 1, 14)); 
        jLabel2.setText("Address / City");
        getContentPane().add(jLabel2, new AbsoluteConstraints(258, 77, -1, -1));

        location.setFont(new Font("Candara", 1, 14)); 
        location.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                locationKeyReleased();
            }
        });
        getContentPane().add(location, new AbsoluteConstraints(426, 75, 170, -1));
        getContentPane().add(jSeparator2, new AbsoluteConstraints(10, 112, 801, 10));

        locationTable.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null } },
				new String[] { "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8",
						"Title 9", "Title 10", "Title 11" }) {
			boolean[] canEdit = new boolean[] { false, false, false, false ,false, false, false, false ,false, false,false};

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
        
        locationTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(locationTable);

        getContentPane().add(jScrollPane1, new AbsoluteConstraints(10, 128, 801, 302));
        getContentPane().add(jSeparator3, new AbsoluteConstraints(10, 441, 801, 10));

        printBtn.setBackground(new Color(0, 153, 204));
        printBtn.setFont(new Font("Candara", 1, 18)); 
        printBtn.setForeground(new Color(255, 255, 255));
        printBtn.setText("Print");
        printBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                printBtnActionPerformed(evt);
            }
        });
        getContentPane().add(printBtn, new AbsoluteConstraints(40, 450, 90, 40));

        closeBtn.setBackground(new Color(255, 0, 51));
        closeBtn.setFont(new Font("Candara", 1, 18)); 
        closeBtn.setForeground(new Color(255, 255, 255));
        closeBtn.setText("Close");
        closeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                closeBtnActionPerformed(evt);
            }
        });
        getContentPane().add(closeBtn, new AbsoluteConstraints(680, 450, 90, 40));
        getContentPane().add(jLabel3, new AbsoluteConstraints(0, 0, -1, -1));

        jLabel4.setIcon(new ImageIcon(getClass().getResource("/Images/allformsbg.png"))); 
        getContentPane().add(jLabel4, new AbsoluteConstraints(0, 0, -1, -1));
        locationKeyReleased();
        pack();
    }

    private void printBtnActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
        try{
            locationTable.print(JTable.PrintMode.NORMAL);
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void closeBtnActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
        setVisible(false);
    }

    private void locationKeyReleased() {
        // TODO add your handling code here:
        String loc = location.getText();
        String Query;
        if (loc.isEmpty() ) {
        	Query="Select * from donor ";

        }else {
        	Query="Select * from donor where upper(city) like upper('%"+loc+"%')"
        			+ " or Upper(address) like upper('%"+loc+"%')";

        }
        
        try {
            Connection conn = ConnectionProvider.getCon();
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(Query);
//            bloodGrpTable.setAutoResizeMode(bloodGrpTable.AUTO_RESIZE_OFF);
            locationTable.setModel(DbUtils.resultSetToTableModel(rs));
            conn.close();
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
                new SearchDonorByLocation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private JButton closeBtn;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JScrollPane jScrollPane1;
    private JSeparator jSeparator1;
    private JSeparator jSeparator2;
    private JSeparator jSeparator3;
    private JTextField location;
    private JTable locationTable;
    private JButton printBtn;
    // End of variables declaration
}
