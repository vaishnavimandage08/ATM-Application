package com.solvd.ATM.GUI;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;

public class BalanceEnquiry extends JFrame implements ActionListener {

	JTextField t1, t2;
	JButton b1, b2, b3;
	JLabel l1, l2, l3;
	String pin;

	BalanceEnquiry(String pin) {
		this.pin = pin;

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/ATM.jpg"));
		Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l3 = new JLabel(i3);
		l3.setBounds(0, 0, 960, 1080);
		add(l3);

		l1 = new JLabel();
		l1.setForeground(Color.WHITE);
		l1.setFont(new Font("System", Font.BOLD, 16));
		b1 = new JButton("BACK");

		setLayout(null);

		l1.setBounds(190, 350, 400, 35);
		l3.add(l1);

		b1.setBounds(390, 633, 150, 35);
		l3.add(b1);
		int balance = 0;
		try {
			Conn c1 = new Conn();
			ResultSet rs = c1.s.executeQuery("SELECT * FROM bank WHERE pin = '" + pin + "'");
			while (rs.next()) {
				if (rs.getString("Withdrawl").equals("Deposit")) {
					balance += Integer.parseInt(rs.getString("amount"));
				} else {
					balance -= Integer.parseInt(rs.getString("amount"));
				}
			}
			l1.setText("Your Current Account Balance is Rs " + balance);
			rs.close();
			c1.s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		l1.setText("Your Current Account Balance is Rs " + balance);

		b1.addActionListener(this);

		setSize(960, 1080);

		setLocation(500, 0);

		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {

		setVisible(false);

		new Transactions(pin).setVisible(true);
	}

	public static void main(String[] args) {

		new BalanceEnquiry("").setVisible(true);
	}
}