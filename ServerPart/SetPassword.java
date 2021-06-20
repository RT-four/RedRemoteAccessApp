package com.rtfour.RemoteRed;

import javax.swing.*;

import java.awt.event.*;
import java.awt.*;

public class SetPassword extends JFrame{
	static String port="8181";
	JButton SUBMIT;
	JPanel panel;
	JLabel label1,label2;
	JTextField text1,text2;
	String value1;
	String value2;
	JLabel label;
	
   SetPassword(String password){
	   value1= password;
	   dispose();
	   new InitConnection(Integer.parseInt(port),value1);
	}
	
	public void actionPerformed(ActionEvent ae){

	}
	
	public String getValue1(){

		return value1;
	}


}
