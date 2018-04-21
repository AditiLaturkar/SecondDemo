package com.demo;

import java.awt.Frame;
import java.net.UnknownHostException;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class TraceRouteDialog extends JDialog {

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
	 * Creates new form TraceRouteDialog
	 */
	public TraceRouteDialog(Frame parent, boolean modal) {
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
		setName("TraceRouteIPDialog"); // NOI18N
		setResizable(false);
		setSize(getPreferredSize());
		setType(java.awt.Window.Type.POPUP);

		txtPingIP.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
		txtPingIP.setToolTipText("Enter Website OR IP Address");
		txtPingIP.setName("txtPingIP"); // NOI18N

		jLabel1.setFont(new java.awt.Font("Microsoft YaHei", 1, 14)); // NOI18N
		jLabel1.setText("Enter IP Address Or Website:");

		jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jButton1.setText("TraceRoute");
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
			String traceRoute;
			try {
				traceRoute = Implementation.traceRoute(pingIP);

				if (!traceRoute.equals(null) || !traceRoute.isEmpty()) {

					JOptionPane.showMessageDialog(this, traceRoute, "Route to Website Traced", JOptionPane.NO_OPTION);

				} else {
					JOptionPane.showMessageDialog(this, "Tracing Failed", "Failure", JOptionPane.ERROR_MESSAGE);
				}
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
			txtPingIP.setText("");
		}
	}
}
