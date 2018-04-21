package com.demo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.BevelBorder;

/**
 *
 * @author
 */
public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		try {
			/* Set the Nimbus look and feel */
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
		} catch (UnsupportedLookAndFeelException ex) {
			Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
		}

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MainFrame().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify
	public JButton btnMyIP;
	public JButton btnPing;
	public JButton btnSpeedTest;
	public JButton btnTracert;
	public JScrollPane jScrollPane1;
	public JPanel mainPanel;
	public JPanel panelFuncions;
	public JPanel panelSpeedometer;
	public JPanel panelSystemInfo;
	public JTextArea txtSystemInfo;

	// End of variables declaration
	/**
	 * Creates new form MainFrame
	 */
	public MainFrame() {
		initComponents();
	}

	public void initComponents() {

		mainPanel = new JPanel();
		panelFuncions = new JPanel();
		btnPing = new JButton();
		btnMyIP = new JButton();
		btnSpeedTest = new JButton();
		btnTracert = new JButton();
		panelSystemInfo = new JPanel();
		jScrollPane1 = new JScrollPane();
		txtSystemInfo = new JTextArea();
		panelSpeedometer = new JPanel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Networking Software");
		setBackground(new java.awt.Color(255, 204, 204));
		setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		setLocationByPlatform(true);
		setName("frameNetworking"); // NOI18N
		setPreferredSize(new java.awt.Dimension(750, 470));
		setSize(getPreferredSize());

		mainPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		mainPanel.setToolTipText("Main");
		mainPanel.setName("mainPanel"); // NOI18N

		panelFuncions.setToolTipText("Networking Functions");
		panelFuncions.setAutoscrolls(true);
		panelFuncions.setName("panelFunctions"); // NOI18N

		btnPing.setText("Check Network Status(Ping)");
		btnPing.setToolTipText("Ping Website or IP");
		btnPing.setName("btnPing"); // NOI18N
		btnPing.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnPingActionPerformed(evt);
			}
		});

		btnMyIP.setText("What is my IP");
		btnMyIP.setToolTipText("Shows Your IP ");
		btnMyIP.setName("btnMyIP"); // NOI18N

		btnMyIP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					btnMyIPActionPerformed(evt);
				} catch (SocketException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		btnSpeedTest.setText("Speed Test");
		btnSpeedTest.setToolTipText("Internet Speed Test");
		btnSpeedTest.setName("btnSpeedTest"); // NOI18N

		btnTracert.setText("TraceRoute(Tracert)");
		btnTracert.setToolTipText("Displays all Hops");
		btnTracert.setName("btnTracert"); // NOI18N
		btnTracert.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnTracertActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout panelFuncionsLayout = new javax.swing.GroupLayout(panelFuncions);
		panelFuncions.setLayout(panelFuncionsLayout);
		panelFuncionsLayout.setHorizontalGroup(panelFuncionsLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panelFuncionsLayout.createSequentialGroup().addContainerGap()
						.addGroup(panelFuncionsLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnPing, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
								.addComponent(btnSpeedTest, Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnTracert, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap())
				.addGroup(panelFuncionsLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(panelFuncionsLayout.createSequentialGroup().addContainerGap()
								.addComponent(btnMyIP, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
								.addContainerGap())));
		panelFuncionsLayout.setVerticalGroup(panelFuncionsLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(panelFuncionsLayout.createSequentialGroup().addGap(95, 95, 95)
						.addComponent(btnPing, javax.swing.GroupLayout.PREFERRED_SIZE, 49,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(29, 29, 29)
						.addComponent(btnTracert, javax.swing.GroupLayout.PREFERRED_SIZE, 51,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(32, 32, 32)
						.addComponent(btnSpeedTest, javax.swing.GroupLayout.PREFERRED_SIZE, 48,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(26, Short.MAX_VALUE))
				.addGroup(panelFuncionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(panelFuncionsLayout.createSequentialGroup().addGap(24, 24, 24)
								.addComponent(btnMyIP, javax.swing.GroupLayout.PREFERRED_SIZE, 44,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(262, Short.MAX_VALUE))));

		panelSystemInfo.setToolTipText("System Information");
		panelSystemInfo.setName("panelSystemInfo"); // NOI18N

		txtSystemInfo.setColumns(20);
		txtSystemInfo.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
		txtSystemInfo.setRows(5);
		txtSystemInfo.setText("System info");
		txtSystemInfo.setToolTipText("System Information");
		txtSystemInfo.setName("txtSystemInfo"); // NOI18N
		txtSystemInfo.setEditable(false);
		jScrollPane1.setViewportView(txtSystemInfo);

		javax.swing.GroupLayout panelSystemInfoLayout = new javax.swing.GroupLayout(panelSystemInfo);
		panelSystemInfo.setLayout(panelSystemInfoLayout);
		panelSystemInfoLayout.setHorizontalGroup(
				panelSystemInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						panelSystemInfoLayout.createSequentialGroup().addContainerGap()
								.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
								.addContainerGap()));
		panelSystemInfoLayout.setVerticalGroup(
				panelSystemInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						panelSystemInfoLayout.createSequentialGroup().addContainerGap()
								.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
								.addContainerGap()));

		panelSpeedometer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
		panelSpeedometer.setName("panelSpeedometer"); // NOI18N

		javax.swing.GroupLayout panelSpeedometerLayout = new javax.swing.GroupLayout(panelSpeedometer);
		panelSpeedometer.setLayout(panelSpeedometerLayout);
		panelSpeedometerLayout.setHorizontalGroup(panelSpeedometerLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 0, Short.MAX_VALUE));
		panelSpeedometerLayout.setVerticalGroup(panelSpeedometerLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 224, Short.MAX_VALUE));

		javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
		mainPanel.setLayout(mainPanelLayout);
		mainPanelLayout.setHorizontalGroup(mainPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(mainPanelLayout.createSequentialGroup().addContainerGap()
						.addComponent(panelFuncions, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, Short.MAX_VALUE)
						.addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(panelSystemInfo, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(mainPanelLayout.createSequentialGroup()
										.addComponent(panelSpeedometer, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addContainerGap()))));
		mainPanelLayout.setVerticalGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(mainPanelLayout.createSequentialGroup().addContainerGap()
						.addComponent(panelSystemInfo, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(panelSpeedometer, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						mainPanelLayout.createSequentialGroup()
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(panelFuncions, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		panelFuncions.getAccessibleContext().setAccessibleParent(this);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(mainPanel,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		pack();
		setLocationRelativeTo(null);
		txtSystemInfo.setText(new SystemInformation().getSystemInformation());

	}

	private void btnPingActionPerformed(ActionEvent evt) {
		PingIPDialog pingIPDialog = new PingIPDialog(this, rootPaneCheckingEnabled);
		pingIPDialog.setVisible(true);

	}

	private void btnTracertActionPerformed(ActionEvent evt) {
		new TraceRouteDialog(this, rootPaneCheckingEnabled).setVisible(true);

	}

	private void btnMyIPActionPerformed(ActionEvent evt) throws SocketException {

		InetAddress IP = null;
		try {
			IP = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		System.out.println("IP of my system is := " + IP.getHostAddress());

		JOptionPane.showMessageDialog(this, IP.getHostAddress(), "MY IP ADDRESS", JOptionPane.NO_OPTION);

	}

}
