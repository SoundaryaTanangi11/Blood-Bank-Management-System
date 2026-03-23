package BloodBankManagementSystem;


import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.UIManager.*;


@SuppressWarnings("serial")
public class Home extends JFrame {

    public Home() {
        initComponents();
    }
    
   
    private void initComponents() {

        jLabel1 = new JLabel();
        jLabel4 = new JLabel();
        registerBtn = new JButton();
        jLabel2 = new JLabel();
        jLabel5 = new JLabel();
        jMenuBar1 = new JMenuBar();
        donor = new JMenu();
        addDonor = new JMenuItem();
        jSeparator1 = new JPopupMenu.Separator();
        updateDonor = new JMenuItem();
        jSeparator2 = new JPopupMenu.Separator();
        ddeatils = new JMenuItem();
        jSeparator7 = new JPopupMenu.Separator();
        regDonorsDetails = new JMenuItem();
        jMenu3 = new JMenu();
        bloodGrp = new JMenuItem();
        jSeparator3 = new JPopupMenu.Separator();
        location = new JMenuItem();
        purchase = new JMenu();
        jMenuItem6 = new JMenuItem();
        jSeparator4 = new JPopupMenu.Separator();
        bloodPacketsDetails = new JMenuItem();
        jSeparator5 = new JPopupMenu.Separator();
        patients = new JMenuItem();
        delete = new JMenu();
        deleteDonorDetails = new JMenuItem();
        jMenu5 = new JMenu();
        logoutItem = new JMenuItem();
        jSeparator6 = new JPopupMenu.Separator();
        closeAppItem = new JMenuItem();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(new Point(0, 0));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 770));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        registerBtn.setBackground(new Color(204, 255, 255));
        registerBtn.setFont(new Font("Candara", 1, 36)); 
        registerBtn.setForeground(new Color(0, 0, 102));
        registerBtn.setText("Click Here");
        registerBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                registerBtnActionPerformed(evt);
            }
        });
        getContentPane().add(registerBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(833, 63, -1, -1));

        jLabel2.setBackground(new Color(255, 0, 0));
        jLabel2.setFont(new Font("Candara", 1, 36)); 
        jLabel2.setForeground(new Color(255, 255, 255));
        jLabel2.setText("Register for upcoming Blood Donation Camp ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 67, -1, -1));

        jLabel5.setIcon(new ImageIcon(getClass().getResource("/Images/MainImage.jpg"))); 
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jMenuBar1.setBackground(new Color(255, 255, 255));

        donor.setIcon(new ImageIcon(getClass().getResource("/Images/Donor.png"))); 
        donor.setText("Donor");
        donor.setFont(new Font("Candara", 1, 18)); 
        donor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                donorActionPerformed(evt);
            }
        });

        addDonor.setFont(new Font("Candara", 0, 14)); 
        addDonor.setIcon(new ImageIcon(getClass().getResource("/Images/Add new.png"))); 
        addDonor.setText("Add New Donor");
        addDonor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addDonorActionPerformed(evt);
            }
        });
        donor.add(addDonor);
        donor.add(jSeparator1);

        updateDonor.setFont(new Font("Candara", 0, 14)); 
        updateDonor.setIcon(new ImageIcon(getClass().getResource("/Images/Update details.png"))); 
        updateDonor.setText("Update Details");
        updateDonor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                updateDonorActionPerformed(evt);
            }
        });
        donor.add(updateDonor);
        donor.add(jSeparator2);

        ddeatils.setFont(new Font("Candara", 0, 14)); 
        ddeatils.setIcon(new ImageIcon(getClass().getResource("/Images/Details.png"))); 
        ddeatils.setText("Donors Details");
        ddeatils.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ddeatilsActionPerformed(evt);
            }
        });
        donor.add(ddeatils);
        donor.add(jSeparator7);

        regDonorsDetails.setFont(new Font("Candara", 0, 14)); 
        regDonorsDetails.setIcon(new ImageIcon(getClass().getResource("/Images/save.png"))); 
        regDonorsDetails.setText("Registered Donors for Camp");
        regDonorsDetails.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                regDonorsDetailsActionPerformed(evt);
            }
        });
        donor.add(regDonorsDetails);
        
        if (Login.isAdminUser) {
        	jMenuBar1.add(donor);
		 }
       // jMenuBar1.add(donor);

        jMenu3.setIcon(new ImageIcon(getClass().getResource("/Images/search user.png"))); 
        jMenu3.setText("Search Blood Donor");
        jMenu3.setFont(new Font("Candara", 1, 18)); 

        bloodGrp.setFont(new Font("Candara", 0, 14)); 
        bloodGrp.setIcon(new ImageIcon(getClass().getResource("/Images/Blood group.png"))); 
        bloodGrp.setText("Blood Group ");
        bloodGrp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                bloodGrpActionPerformed(evt);
            }
        });
        jMenu3.add(bloodGrp);
        jMenu3.add(jSeparator3);

        location.setFont(new Font("Candara", 0, 14)); 
        location.setIcon(new ImageIcon(getClass().getResource("/Images/Location.png"))); 
        location.setText("Location");
        location.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                locationActionPerformed(evt);
            }
        });
        jMenu3.add(location);
        
		 if (Login.isAdminUser) {
			 jMenuBar1.add(jMenu3);
		 }
        //jMenuBar1.add(jMenu3);

        purchase.setIcon(new ImageIcon(getClass().getResource("/Images/stock.png"))); 
        purchase.setText("Blood Stocks");
        purchase.setFocusable(false);
        purchase.setFont(new Font("Candara", 1, 18)); 
        purchase.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                purchaseActionPerformed(evt);
            }
        });

        jMenuItem6.setFont(new Font("Candara", 0, 14)); 
        jMenuItem6.setIcon(new ImageIcon(getClass().getResource("/Images/Address.png"))); 
        jMenuItem6.setText("Purchase of Blood");
        jMenuItem6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        
        if (Login.isAdminUser) {
        	purchase.add(jMenuItem6);
    	}
        
        //purchase.add(jMenuItem6);
        purchase.add(jSeparator4);

        bloodPacketsDetails.setFont(new Font("Candara", 0, 14)); 
        bloodPacketsDetails.setIcon(new ImageIcon(getClass().getResource("/Images/save.png"))); 
        bloodPacketsDetails.setText("Stock Details");
        bloodPacketsDetails.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                bloodPacketsDetailsActionPerformed(evt);
            }
        });
        purchase.add(bloodPacketsDetails);
        purchase.add(jSeparator5);

        patients.setFont(new Font("Candara", 0, 14)); 
        patients.setIcon(new ImageIcon(getClass().getResource("/Images/Details.png"))); 
        patients.setText("Patients Details");
        patients.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                patientsActionPerformed(evt);
            }
        });
        
        if (Login.isAdminUser) {
        	purchase.add(patients);
    	}
        //purchase.add(patients);

        jMenuBar1.add(purchase);

        delete.setIcon(new ImageIcon(getClass().getResource("/Images/delete donor.png"))); 
        delete.setText("Delete Donor");
        delete.setFont(new Font("Candara", 1, 18)); 
        delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        deleteDonorDetails.setFont(new Font("Candara", 0, 14)); 
        deleteDonorDetails.setIcon(new ImageIcon(getClass().getResource("/Images/delete.png"))); 
        deleteDonorDetails.setText("Delete Donor");
        deleteDonorDetails.setToolTipText("");
        deleteDonorDetails.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                deleteDonorDetailsActionPerformed(evt);
            }
        });
        delete.add(deleteDonorDetails);
        
        if (Login.isAdminUser) {
        	jMenuBar1.add(delete);
    	}
       // jMenuBar1.add(delete);

        jMenu5.setIcon(new ImageIcon(getClass().getResource("/Images/exit.png"))); 
        jMenu5.setText("Exit");
        jMenu5.setFocusable(false);
        jMenu5.setFont(new Font("Candara", 1, 18)); 

        logoutItem.setFont(new Font("Candara", 0, 14)); 
        logoutItem.setIcon(new ImageIcon(getClass().getResource("/Images/Logout.png"))); 
        logoutItem.setText("Logout");
        logoutItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                logoutItemActionPerformed(evt);
            }
        });
        jMenu5.add(logoutItem);
        jMenu5.add(jSeparator6);

        closeAppItem.setFont(new Font("Candara", 0, 14)); 
        closeAppItem.setIcon(new ImageIcon(getClass().getResource("/Images/Exit application.png"))); 
        closeAppItem.setText("Close Application");
        closeAppItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                closeAppItemActionPerformed(evt);
            }
        });
        
        jMenu5.add(closeAppItem);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        pack();
    }

    private void updateDonorActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    	if (Login.isAdminUser=true) {
            new UpdateDonorDetails().setVisible(true);
    	 }
    }

    private void ddeatilsActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    	if (Login.isAdminUser=true) {
            new AllDonorDetails().setVisible(true);
    	 }
    }

    private void bloodGrpActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    	if (Login.isAdminUser=true) {
            new SearchDonorByBloodGrp().setVisible(true);
    	 }
    }

    private void jMenuItem6ActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    	if (Login.isAdminUser=true) {
            new SellBlood().setVisible(true);
    	 }
    }

    private void bloodPacketsDetailsActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
        new NoOfBloodPackets().setVisible(true);
    }

    private void deleteDonorDetailsActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    	if (Login.isAdminUser=true) {
            new DeleteDonor().setVisible(true);
    	 }
    }

    private void logoutItemActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
        int a = JOptionPane.showConfirmDialog(null, "Do you want to logout ? ", "Select", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            setVisible(false);
            new Login().setVisible(true);
        }
    }

    private void closeAppItemActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
        int a = JOptionPane.showConfirmDialog(null, "Do you want to close application ? ", "Select", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            System.exit(0);
        }
    }

    private void addDonorActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    	if (Login.isAdminUser=true) {
            new AddNewDonor().setVisible(true);
    	 }
    }

    private void locationActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    	if (Login.isAdminUser=true) {
            new SearchDonorByLocation().setVisible(true);
    	 }
    }

    private void deleteActionPerformed(ActionEvent evt) {

    }

    private void purchaseActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:

    }

    private void registerBtnActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    	if (Login.isAdminUser=true) {
            new RegisterDonor().setVisible(true);
    	 }
    }

    private void regDonorsDetailsActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
        new RegisteredCampDonor().setVisible(true);
    }

    private void donorActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
       
    }

    private void patientsActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    	if (Login.isAdminUser=true) {
            new PatientsDetails().setVisible(true);        
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
       
    	createLookAndFeel();
        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private JMenuItem addDonor;
    private JMenuItem bloodGrp;
    private JMenuItem bloodPacketsDetails;
    private JMenuItem closeAppItem;
    private JMenuItem ddeatils;
    private JMenu delete;
    private JMenuItem deleteDonorDetails;
    private JMenu donor;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JMenu jMenu3;
    private JMenu jMenu5;
    private JMenuBar jMenuBar1;
    private JMenuItem jMenuItem6;
    private JPopupMenu.Separator jSeparator1;
    private JPopupMenu.Separator jSeparator2;
    private JPopupMenu.Separator jSeparator3;
    private JPopupMenu.Separator jSeparator4;
    private JPopupMenu.Separator jSeparator5;
    private JPopupMenu.Separator jSeparator6;
    private JPopupMenu.Separator jSeparator7;
    private JMenuItem location;
    private JMenuItem logoutItem;
    private JMenuItem patients;
    private JMenu purchase;
    private JMenuItem regDonorsDetails;
    private JButton registerBtn;
    private JMenuItem updateDonor;
    // End of variables declaration
}
