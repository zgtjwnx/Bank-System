package Server;


import java.io.*;
import java.net.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
1:administer sign up checking
2:administer sign up saving
3:administer with checking sign up saving
4:administer with saving sign up checking
5:user check balance
6:transfer from checking to saving
7:transfer from saving to checking
8:withdraw
9:deposit
10:transfer from checking to another's checking
11:transfer from checking to another's saving
12:transfer from saving to another's checking
13:transfer from saving to another's saving
*/

public class ThreadedDataObjectServer {
	public static void main(String[] args) {

		try {
			ServerSocket s = new ServerSocket(3307);

			for (;;) {
				Socket incoming = s.accept();
				new ThreadedDataObjectHandler(incoming).start();

			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

class ThreadedDataObjectHandler extends Thread {

	String admin_password = "123";

	public ThreadedDataObjectHandler(Socket i) {
		incoming = i;
	}

	public void run() {
		try {

			ObjectInputStream in = new ObjectInputStream(incoming.getInputStream());

			ObjectOutputStream out = new ObjectOutputStream(incoming.getOutputStream());

			myObject = (TransactionObject) in.readObject();
			System.out.println(myObject);
			String a = myObject.getType();

			System.out.println(a);

			if (a.equals("1")) {
				
				

				String driver = "com.mysql.jdbc.Driver";
				String url = "jdbc:mysql://localhost:3306/banksystem";
				String user = "root";
				String password = "xxx";
				System.out.println(myObject);
				try {
					Class.forName(driver);
					Connection conn = DriverManager.getConnection(url, user, password);
					if (!conn.isClosed())
						System.out.println("Succeeded connecting to the Database!");
					String sql = "INSERT INTO account VALUES (?, ?,?,0,null)";

					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, myObject.getName());
					pstmt.setString(2, myObject.getMessage());
					pstmt.setInt(3, my_id);

					System.out.println(sql);

					pstmt.executeUpdate();
					System.out.println("-----------------");

					System.out.println("-----------------");

					conn.close();
					myObject.setType("0");
					myObject.setMessage("" + my_id);
					my_id++;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			if (a.equals("2")) {

				String driver = "com.mysql.jdbc.Driver";
				String url = "jdbc:mysql://localhost:3306/banksystem";
				String user = "root";
				String password = "xxx";
				System.out.println(myObject);
				try {
					Class.forName(driver);
					Connection conn = DriverManager.getConnection(url, user, password);
					if (!conn.isClosed())
						System.out.println("Succeeded connecting to the Database!");
					String sql = "INSERT INTO account VALUES (?,?,?,null,0)";

					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, myObject.getName());
					pstmt.setString(2, myObject.getMessage());
					pstmt.setInt(3, my_id);

					System.out.println(sql);

					pstmt.executeUpdate();
					System.out.println("-----------------");

					System.out.println("-----------------");

					conn.close();
					myObject.setType("0");
					myObject.setMessage("" + my_id);
					my_id++;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			if (a.equals("14")) {

				String driver = "com.mysql.jdbc.Driver";
				String url = "jdbc:mysql://localhost:3306/banksystem";
				String user = "root";
				String password = "xxx";
				System.out.println(myObject);
				try {
					Class.forName(driver);
					Connection conn = DriverManager.getConnection(url, user, password);
					if (!conn.isClosed())
						System.out.println("Succeeded connecting to the Database!");
					String sql = "INSERT INTO account VALUES (?,?,?,0,0)";

					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, myObject.getName());
					pstmt.setString(2, myObject.getMessage());
					pstmt.setInt(3, my_id);

					System.out.println(sql);

					pstmt.executeUpdate();
					System.out.println("-----------------");

					System.out.println("-----------------");

					conn.close();
					myObject.setType("0");
					myObject.setMessage("" + my_id);
					my_id++;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			if (a.equals("3")) {

				String driver = "com.mysql.jdbc.Driver";
				String url = "jdbc:mysql://localhost:3306/banksystem";
				String user = "root";
				String password = "xxx";
				System.out.println(myObject);
				try {
					Class.forName(driver);
					Connection conn = DriverManager.getConnection(url, user, password);
					if (!conn.isClosed())
						System.out.println("Succeeded connecting to the Database!");
					Statement statement = conn.createStatement();
					String sql = "select password,id from account where name='" + myObject.getName() + "'";
					ResultSet rs = statement.executeQuery(sql);
					String tmp_password;
					String tmp_id;
					while (rs.next()) {
						tmp_password = rs.getString(1);
						tmp_id = rs.getString(2);
						if (!myObject.getMessage().equals(tmp_password)) {
							myObject.setType("1");
						} else {
							sql = "update account set checking=0 where name=?";
							PreparedStatement pst = conn.prepareStatement(sql);
							pst.setString(1, myObject.getName());
							pst.executeUpdate();
							myObject.setType("0");
							myObject.setMessage(tmp_id);
						}
					}
					rs.close();
					conn.close();

				} catch (Exception e) {
					e.printStackTrace();
				}

			}

			if (a.equals("4")) {

				String driver = "com.mysql.jdbc.Driver";
				String url = "jdbc:mysql://localhost:3306/banksystem";
				String user = "root";
				String password = "xxx";
				System.out.println(myObject);
				try {
					Class.forName(driver);
					Connection conn = DriverManager.getConnection(url, user, password);
					if (!conn.isClosed())
						System.out.println("Succeeded connecting to the Database!");
					Statement statement = conn.createStatement();
					String sql = "select password,id from account where name='" + myObject.getName() + "'";
					ResultSet rs = statement.executeQuery(sql);
					String tmp_password;
					String tmp_id;
					while (rs.next()) {
						tmp_password = rs.getString(1);
						tmp_id = rs.getString(2);
						if (!myObject.getMessage().equals(tmp_password)) {
							myObject.setType("1");
						} else {
							sql = "update account set saving=0 where name=?";
							PreparedStatement pst = conn.prepareStatement(sql);
							pst.setString(1, myObject.getName());
							pst.executeUpdate();
							myObject.setType("0");
							myObject.setMessage(tmp_id);
						}
					}
					rs.close();
					conn.close();

				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			
			
			
			if (a.equals("5")) {
				System.out.print("sdfsdfsdf1");
				String driver = "com.mysql.jdbc.Driver";
				String url = "jdbc:mysql://localhost:3306/banksystem";
				String user = "root";
				String password = "xxx";
				System.out.println(myObject);
				try {
					System.out.print("test");
					Class.forName(driver);
					Connection conn = DriverManager.getConnection(url, user, password);
					System.out.print("test123");
					if (!conn.isClosed())
						System.out.println("Succeeded connecting to the Database!");
					Statement statement = conn.createStatement();
					String sql = "select checking,saving,password,id from account where name='" + myObject.getName() + "'";
					ResultSet rs = statement.executeQuery(sql);
					String tmp_password;
					float tmp_checking;
					float tmp_saving;
					int tmp_id;
					while (rs.next()) {
						
						tmp_checking = rs.getFloat(1);
						tmp_saving=rs.getFloat(2);
						tmp_password = rs.getString(3);
						tmp_id=rs.getInt(4);
						if (!myObject.getMessage().equals(tmp_password)) {
							myObject.setType("1");
						} else {
							myObject.setType("0");
							myObject.setMessage("your checking account is :"+tmp_checking+"\n"+"your saving account is :"+tmp_saving+"\n"+"Please remember your id :"+tmp_id);
						}
					}
					rs.close();
					conn.close();

				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			
			
			if (a.equals("6")) {

				String driver = "com.mysql.jdbc.Driver";
				String url = "jdbc:mysql://localhost:3306/banksystem";
				String user = "root";
				String password = "xxx";
				System.out.println(myObject);
				try {
					Class.forName(driver);
					Connection conn = DriverManager.getConnection(url, user, password);
					if (!conn.isClosed())
						System.out.println("Succeeded connecting to the Database!");
					Statement statement = conn.createStatement();
					String sql = "select checking,saving,password,id from account where name='" + myObject.getName() + "'";
					ResultSet rs = statement.executeQuery(sql);
					String tmp_password;
					float tmp_checking;
					float tmp_saving;
					int tmp_id;
					while (rs.next()) {
						
						tmp_checking = rs.getFloat(1);
						tmp_saving=rs.getFloat(2);
						tmp_password = rs.getString(3);
						tmp_id=rs.getInt(4);
						if (!myObject.getMessage().equals(tmp_password)) {
							myObject.setType("1");
						} 
						else if(tmp_checking<myObject.getAmount()){
							myObject.setType("100");
						}
						else {
							myObject.setType("0");
							tmp_checking-=myObject.getAmount();
							tmp_saving+=myObject.getAmount();
							
							sql = "update account set checking="+tmp_checking+",saving ="+tmp_saving+" where name=?";
							PreparedStatement pst = conn.prepareStatement(sql);
							pst.setString(1, myObject.getName());
							pst.executeUpdate();
							myObject.setType("0");
							myObject.setMessage("your checking account is :"+tmp_checking+"\n"+"your saving account is :"+tmp_saving+"\n"+"Please remember your id :"+tmp_id);
						}
					}
					rs.close();
					conn.close();

				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			
			
			
			if (a.equals("7")) {

				String driver = "com.mysql.jdbc.Driver";
				String url = "jdbc:mysql://localhost:3306/banksystem";
				String user = "root";
				String password = "xxx";
				System.out.println(myObject);
				try {
					Class.forName(driver);
					Connection conn = DriverManager.getConnection(url, user, password);
					if (!conn.isClosed())
						System.out.println("Succeeded connecting to the Database!");
					Statement statement = conn.createStatement();
					String sql = "select checking,saving,password,id from account where name='" + myObject.getName() + "'";
					ResultSet rs = statement.executeQuery(sql);
					String tmp_password;
					float tmp_checking;
					float tmp_saving;
					int tmp_id;
					while (rs.next()) {
						
						tmp_checking = rs.getFloat(1);
						tmp_saving=rs.getFloat(2);
						tmp_password = rs.getString(3);
						tmp_id=rs.getInt(4);
						if (!myObject.getMessage().equals(tmp_password)) {
							myObject.setType("1");
						} 
						else if(tmp_saving<myObject.getAmount()){
							myObject.setType("100");
						}
						else {
							myObject.setType("0");
							tmp_checking+=myObject.getAmount();
							tmp_saving-=myObject.getAmount();
							
							sql = "update account set checking="+tmp_checking+",saving ="+tmp_saving+" where name=?";
							PreparedStatement pst = conn.prepareStatement(sql);
							pst.setString(1, myObject.getName());
							pst.executeUpdate();
							myObject.setType("0");
							myObject.setMessage("your checking account is :"+tmp_checking+"\n"+"your saving account is :"+tmp_saving+"\n"+"Please remember your id :"+tmp_id);
						}
					}
					rs.close();
					conn.close();

				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			
			
			
			
			if (a.equals("8")) {

				String driver = "com.mysql.jdbc.Driver";
				String url = "jdbc:mysql://localhost:3306/banksystem";
				String user = "root";
				String password = "xxx";
				System.out.println(myObject);
				try {
					Class.forName(driver);
					Connection conn = DriverManager.getConnection(url, user, password);
					if (!conn.isClosed())
						System.out.println("Succeeded connecting to the Database!");
					Statement statement = conn.createStatement();
					String sql = "select checking,saving,password,id from account where name='" + myObject.getName() + "'";
					ResultSet rs = statement.executeQuery(sql);
					String tmp_password;
					float tmp_checking;
					float tmp_saving;
					int tmp_id;
					while (rs.next()) {
						
						tmp_checking = rs.getFloat(1);
						tmp_saving=rs.getFloat(2);
						tmp_password = rs.getString(3);
						tmp_id=rs.getInt(4);
						if (!myObject.getMessage().equals(tmp_password)) {
							myObject.setType("1");
						} 
						else if(tmp_checking<myObject.getAmount()){
							myObject.setType("100");
						}
						else {
							myObject.setType("0");
							tmp_checking-=myObject.getAmount();
							
							
							sql = "update account set checking="+tmp_checking+",saving ="+tmp_saving+" where name=?";
							PreparedStatement pst = conn.prepareStatement(sql);
							pst.setString(1, myObject.getName());
							pst.executeUpdate();
							myObject.setType("0");
							myObject.setMessage("your checking account is :"+tmp_checking+"\n"+"your saving account is :"+tmp_saving+"\n"+"Please remember your id :"+tmp_id);
						}
					}
					rs.close();
					conn.close();

				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			
			
			
			
			if (a.equals("9")) {

				String driver = "com.mysql.jdbc.Driver";
				String url = "jdbc:mysql://localhost:3306/banksystem";
				String user = "root";
				String password = "xxx";
				System.out.println(myObject);
				try {
					Class.forName(driver);
					Connection conn = DriverManager.getConnection(url, user, password);
					if (!conn.isClosed())
						System.out.println("Succeeded connecting to the Database!");
					Statement statement = conn.createStatement();
					String sql = "select checking,saving,password,id from account where name='" + myObject.getName() + "'";
					ResultSet rs = statement.executeQuery(sql);
					String tmp_password;
					float tmp_checking;
					float tmp_saving;
					int tmp_id;
					while (rs.next()) {
						
						tmp_checking = rs.getFloat(1);
						tmp_saving=rs.getFloat(2);
						tmp_password = rs.getString(3);
						tmp_id=rs.getInt(4);
						if (!myObject.getMessage().equals(tmp_password)) {
							myObject.setType("1");
						}
						else {
							myObject.setType("0");
							tmp_checking+=myObject.getAmount();
							
							
							sql = "update account set checking="+tmp_checking+",saving ="+tmp_saving+" where name=?";
							PreparedStatement pst = conn.prepareStatement(sql);
							pst.setString(1, myObject.getName());
							pst.executeUpdate();
							myObject.setType("0");
							myObject.setMessage("your checking account is :"+tmp_checking+"\n"+"your saving account is :"+tmp_saving+"\n"+"Please remember your id :"+tmp_id);
						}
					}
					rs.close();
					conn.close();

				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			
			
			
			if (a.equals("10")) {

				String driver = "com.mysql.jdbc.Driver";
				String url = "jdbc:mysql://localhost:3306/banksystem";
				String user = "root";
				String password = "xxx";
				System.out.println(myObject);
				try {
					Class.forName(driver);
					Connection conn = DriverManager.getConnection(url, user, password);
					if (!conn.isClosed())
						System.out.println("Succeeded connecting to the Database!");
					Statement statement = conn.createStatement();
					String sql = "select checking,saving,password,id from account where name='" + myObject.getName() + "'";
					ResultSet rs = statement.executeQuery(sql);
					String tmp_password;
					float tmp_checking;
					float tmp_saving;
					int tmp_id;
					float tar_checking;
					while (rs.next()) {
						
						tmp_checking = rs.getFloat(1);
						tmp_saving=rs.getFloat(2);
						tmp_password = rs.getString(3);
						tmp_id=rs.getInt(4);
						if (!myObject.getMessage().equals(tmp_password)) {
							myObject.setType("1");
							break;
						}
						if(tmp_checking<myObject.getAmount()){
							myObject.setType("3");
							break;
						}
						myObject.setType("2");
						String sql1 = "select checking from account where name='" + myObject.getNum() + "'";
						ResultSet rs1 = statement.executeQuery(sql1);
						
						while (rs1.next()) {
							tar_checking=rs1.getFloat(1);
							myObject.setType("4");
							tmp_checking-=myObject.getAmount();
							tar_checking+=myObject.getAmount();
						
							sql = "update account set checking="+tmp_checking+" where name=?";
							PreparedStatement pst = conn.prepareStatement(sql);
							pst.setString(1, myObject.getName());
							pst.executeUpdate();
							
							sql = "update account set checking="+tar_checking+" where name=?";
							pst = conn.prepareStatement(sql);
							pst.setString(1, myObject.getNum());
							pst.executeUpdate();
						myObject.setType("0");
							myObject.setMessage("your checking account is :"+tmp_checking+"\n"+"your saving account is :"+tmp_saving+"\n"+"Please remember your id :"+tmp_id);
						
						}
							
							
						
					}
					rs.close();
					conn.close();

				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			

			System.out.println("Message read: " + myObject.getMessage());
			System.out.println("Message written: " + myObject);
			out.writeObject(myObject);
			in.close();
			out.close();
			incoming.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	TransactionObject myObject = null;
	private Socket incoming;
	public static int my_id = 85;

}
