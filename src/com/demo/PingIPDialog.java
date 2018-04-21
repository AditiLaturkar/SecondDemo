package com.demo;

import java.awt.Frame;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author
 */
public class PingIPDialog extends JDialog {

	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JTextField txtPingIP;
	// End of variables declaration

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Creates new form pingIPDialog
	 */
	public PingIPDialog(Frame parent, boolean modal) {
		super(parent, modal);
		initComponents();
	}

	private void initComponents() {

		txtPingIP = new javax.swing.JTextField();
		jLabel1 = new javax.swing.JLabel();
		jButton1 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("IP ADDRESS");
		setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		setName("IPDialog"); // NOI18N
		setResizable(false);
		setSize(getPreferredSize());
		setType(java.awt.Window.Type.POPUP);

		txtPingIP.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
		txtPingIP.setToolTipText("Enter Website OR IP Address");
		txtPingIP.setName("txtPingIP"); // NOI18N

		jLabel1.setFont(new java.awt.Font("Microsoft YaHei", 1, 14)); // NOI18N
		jLabel1.setText("Enter IP Address Or Website:");

		jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jButton1.setText("Ping");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addGap(47, 47, 47)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 256,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(txtPingIP, javax.swing.GroupLayout.PREFERRED_SIZE, 303,
														javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addGroup(layout.createSequentialGroup().addGap(106, 106, 106).addComponent(jButton1,
										javax.swing.GroupLayout.PREFERRED_SIZE, 149,
										javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(33, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(txtPingIP, javax.swing.GroupLayout.PREFERRED_SIZE, 36,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18).addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(31, Short.MAX_VALUE)));

		txtPingIP.getAccessibleContext().setAccessibleName("");

		pack();
		setLocationRelativeTo(null);
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		String pingIP = txtPingIP.getText();
		if (pingIP.equals(null) || pingIP.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Please Enter Valid IP Address or Website Name", "Error",
					JOptionPane.ERROR_MESSAGE);
		} else {
			new Implementation();
			if (Implementation.pingWebsite(pingIP)) {
				JOptionPane.showMessageDialog(this, "Ping Success", "Success", JOptionPane.INFORMATION_MESSAGE);
				InetAddress[] allByName;
				try {
					allByName = InetAddress.getAllByName(pingIP);
					StringBuilder sb = new StringBuilder();
					for (int i = 0; i < allByName.length; i++) {
						String hostName = allByName[i].getHostName();
						sb.append("Host Name " + (i + 1) + ": " + hostName);
						String hostAddress = allByName[i].getHostAddress();
						sb.append("\nHost Address " + (i + 1) + ": " + hostAddress);
						System.out.println(hostName);
						System.out.println(hostAddress);
					}
					JOptionPane.showMessageDialog(this, sb, "PINGED ADDRESSES", JOptionPane.NO_OPTION);
				} catch (UnknownHostException e) {
					System.out.println("Unknown Host " + e.getMessage());
				}

			} else {
				JOptionPane.showMessageDialog(this, "Ping Failed", "Failure", JOptionPane.WARNING_MESSAGE);
			}
			txtPingIP.setText("");
		}
	}
}
