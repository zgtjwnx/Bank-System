package Client;

import java.io.*;
import java.net.*;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.UIManager;



public class Client {
	public static void main(String[] arg) {
		try {

			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (Throwable e) {
				e.printStackTrace();
			}
			Niles cl = new Niles();
			cl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			cl.setVisible(true);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
