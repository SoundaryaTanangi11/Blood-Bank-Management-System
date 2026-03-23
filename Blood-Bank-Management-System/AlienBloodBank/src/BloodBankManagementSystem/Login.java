package BloodBankManagementSystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.prefs.Preferences;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;
import javax.swing.*;
import javax.swing.UIManager.*;

@SuppressWarnings("serial")
public class Login extends JFrame {

	/**
	 * Creates new form Login
	 */
	public Preferences pref = Preferences.userRoot().node("Remember");

	public Login() {
		initComponents();

		String usr = null;
		usr = pref.get("Username", usr);
		username.setText(usr);

		String pss = null;
		pss = pref.get("Password", pss);
		password.setText(pss);
	}

	private void initComponents() {

		user = new JLabel();
		username = new JTextField();
		pass = new JLabel();
		password = new JPasswordField();
		heading = new JLabel();
		loginBtn = new JButton();
		closeBtn = new JButton();
		jLabel3 = new JLabel();
		jLabel1 = new JLabel();
		check = new JCheckBox();
		jLabel2 = new JLabel();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setUndecorated(true);
		getContentPane().setLayout(new AbsoluteLayout());

		user.setFont(new java.awt.Font("Candara", 1, 18));
		user.setText("Username");
		getContentPane().add(user, new AbsoluteConstraints(769, 314, -1, 30));

		username.setFont(new java.awt.Font("Candara", 1, 18));
		username.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				usernameActionPerformed(evt);
			}
		});
		getContentPane().add(username, new AbsoluteConstraints(909, 314, 250, -1));

		pass.setFont(new java.awt.Font("Candara", 1, 18));
		pass.setText("Password");
		getContentPane().add(pass, new AbsoluteConstraints(769, 384, -1, 30));

		password.setFont(new java.awt.Font("Candara", 1, 18));
		password.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				passwordActionPerformed(evt);
			}
		});
		getContentPane().add(password, new AbsoluteConstraints(909, 384, 250, -1));

		heading.setFont(new java.awt.Font("Candara", 1, 30));
		heading.setText("Login to Continue...");
		getContentPane().add(heading, new AbsoluteConstraints(849, 224, -1, -1));

		loginBtn.setBackground(new java.awt.Color(51, 153, 0));
		loginBtn.setFont(new java.awt.Font("Candara", 1, 18));
		loginBtn.setForeground(new java.awt.Color(255, 255, 255));
		loginBtn.setText("Login");
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				loginBtnActionPerformed(evt);
			}
		});
		getContentPane().add(loginBtn, new AbsoluteConstraints(809, 511, 110, 50));

		closeBtn.setBackground(new java.awt.Color(255, 51, 51));
		closeBtn.setFont(new java.awt.Font("Candara", 1, 18));
		closeBtn.setForeground(new java.awt.Color(255, 255, 255));
		closeBtn.setText("Close");
		closeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				closeBtnActionPerformed(evt);
			}
		});
		getContentPane().add(closeBtn, new AbsoluteConstraints(1019, 511, 110, 50));

		jLabel3.setFont(new java.awt.Font("Candara", 1, 50));
		jLabel3.setForeground(new java.awt.Color(255, 0, 0));
		jLabel3.setText("BLOOD BANK");
		getContentPane().add(jLabel3, new AbsoluteConstraints(785, 70, -1, -1));

		jLabel1.setFont(new java.awt.Font("Candara", 1, 50));
		jLabel1.setForeground(new java.awt.Color(255, 0, 0));
		jLabel1.setText("MANAGEMENT SYSTEM");
		getContentPane().add(jLabel1, new AbsoluteConstraints(670, 120, -1, -1));

		check.setFont(new java.awt.Font("Candara", 1, 14));
		check.setText("Remember me");
		getContentPane().add(check, new AbsoluteConstraints(770, 440, -1, -1));

		jLabel2.setIcon(new ImageIcon(getClass().getResource("/Images/login1.png")));
		jLabel2.setText("jLabel2");
		getContentPane().add(jLabel2, new AbsoluteConstraints(0, 0, -1, -1));

		pack();
	}

	private void usernameActionPerformed(ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void passwordActionPerformed(ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void closeBtnActionPerformed(ActionEvent evt) {
		// TODO add your handling code here:
		int a = JOptionPane.showConfirmDialog(null, "Do you want to close application ? ", "Select",
				JOptionPane.YES_NO_OPTION);
		if (a == 0) {
			System.exit(0);
		}
	}

	@SuppressWarnings("deprecation")
	private void loginBtnActionPerformed(ActionEvent evt) {
		// TODO add your handling code here:
		if (username.getText().equals("Soundarya") && password.getText().equals("Alien")) {
			isAdminUser =true;
			setVisible(false);
			new Home().setVisible(true);
		}else if(username.getText().equals("Aachal") && password.getText().equals("Aachal")) {
			isAdminUser =false;
			setVisible(false);
			new Home().setVisible(true);
		}else {
			JOptionPane.showMessageDialog(null, "Incorrect Username or Password");
			new Login().setVisible(true);
		}

		if (check.isSelected()) {
			checked(true);
		} else {
			checked(false);
		}

		this.dispose();

	}

	@SuppressWarnings("unused")
	public void saveuser(String Username, String Password) {
		if (Username == null || Password == null) {
			JOptionPane.showMessageDialog(null, "Please enter Username or Password");
		} else {
			String user = Username;
			pref.put("Username", Username);
			String pass = Password;
			pref.put("Password", pass);

		}
	}

	@SuppressWarnings("deprecation")
	public final void checked(boolean remember) {
		if (remember == true) {
			saveuser(username.getText(), password.getText());
		} else {
			System.out.println("null ");
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

		System.out.println("App is running");
		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Login().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify
	private JCheckBox check;
	private JButton closeBtn;
	private JLabel heading;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JButton loginBtn;
	private JLabel pass;
	private JPasswordField password;
	private JLabel user;
	private JTextField username;
	public static boolean isAdminUser= false;
	// End of variables declaration
}
