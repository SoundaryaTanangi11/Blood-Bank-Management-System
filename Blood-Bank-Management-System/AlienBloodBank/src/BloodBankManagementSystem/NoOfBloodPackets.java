package BloodBankManagementSystem;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ActionEvent;
import ProjBack.ConnectionProvider;
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
public class NoOfBloodPackets extends JFrame {

    /**
     * Creates new form noOfBloodPackets
     */
    public NoOfBloodPackets() {
        initComponents();
        
    }

    private void initComponents() {

        jLabel1 = new JLabel();
        jSeparator1 = new JSeparator();
        jScrollPane1 = new JScrollPane();
        bloodPacketsTable = new JTable();
        jSeparator2 = new JSeparator();
        printBtn = new JButton();
        jLabel2 = new JLabel();
        closeBtn = new JButton();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(new Point(400, 170));
        setUndecorated(true);
        addComponentListener(new ComponentAdapter() {
            public void componentShown(ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new AbsoluteLayout());

        jLabel1.setFont(new Font("Candara", 1, 30)); 
        jLabel1.setText(" Available Blood Packets");
        getContentPane().add(jLabel1, new AbsoluteConstraints(10, 16, 319, -1));
        getContentPane().add(jSeparator1, new AbsoluteConstraints(10, 59, 319, 10));

        bloodPacketsTable.setFont(new Font("Candara", 0, 16)); 
        bloodPacketsTable.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        bloodPacketsTable.getTableHeader().setReorderingAllowed(false);
        bloodPacketsTable.addComponentListener(new ComponentAdapter() {
            public void componentShown(ComponentEvent evt) {
                bloodPacketsTableComponentShown(evt);
            }
        });
        jScrollPane1.setViewportView(bloodPacketsTable);

        getContentPane().add(jScrollPane1, new AbsoluteConstraints(46, 80, 231, 156));
        getContentPane().add(jSeparator2, new AbsoluteConstraints(10, 254, 319, 10));

        printBtn.setBackground(new Color(0, 153, 204));
        printBtn.setFont(new Font("Candara", 1, 18)); 
        printBtn.setForeground(new Color(255, 255, 255));
        printBtn.setText("Print");
        printBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                printBtnActionPerformed(evt);
            }
        });
        getContentPane().add(printBtn, new AbsoluteConstraints(69, 270, -1, -1));
        getContentPane().add(jLabel2, new AbsoluteConstraints(0, 0, -1, -1));

        closeBtn.setBackground(new Color(255, 51, 51));
        closeBtn.setFont(new Font("Candara", 1, 18)); 
        closeBtn.setForeground(new Color(255, 255, 255));
        closeBtn.setText("Close");
        closeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                closeBtnActionPerformed(evt);
            }
        });
        getContentPane().add(closeBtn, new AbsoluteConstraints(197, 270, -1, -1));
        getContentPane().add(jLabel3, new AbsoluteConstraints(0, 0, 170, 50));

        jLabel4.setIcon(new ImageIcon(getClass().getResource("/Images/allformsbg.png"))); 
        getContentPane().add(jLabel4, new AbsoluteConstraints(0, 0, 340, 320));

        pack();
    }

    private void printBtnActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
        try{
            bloodPacketsTable.print(JTable.PrintMode.NORMAL);
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }

    private void closeBtnActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
        setVisible(false);
    }

    private void bloodPacketsTableComponentShown(ComponentEvent evt) {
        // TODO add your handling code here:
    }

    private void formComponentShown(ComponentEvent evt) {
        // TODO add your handling code here:
        try {
            Connection conn = ConnectionProvider.getCon();
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery("select * from bloodquantity");
            //bloodPacketsTable.setAutoResizeMode(bloodPacketsTable.AUTO_RESIZE_OFF);
            bloodPacketsTable.setModel(DbUtils.resultSetToTableModel(rs));
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
                new NoOfBloodPackets().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private JTable bloodPacketsTable;
    private JButton closeBtn;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JScrollPane jScrollPane1;
    private JSeparator jSeparator1;
    private JSeparator jSeparator2;
    private JButton printBtn;
    // End of variables declaration
}
