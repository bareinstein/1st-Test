package p1;
import java.sql.*;

public class DB {

	public String _user;
	public String _password;
	public String _dbURL;
	public Connection _con;
	public Statement _statement;
	public ResultSet _rs;

public DB() {
	_user="root";
	_password= "1234";
	_dbURL= "jdbc:mysql://localhost:3306/betmagen_magen_bets";
	try {
		Class.forName("com.mysql.jdbc.Driver");//test
		_con = DriverManager.getConnection(_dbURL, _user, _password);//test
		_statement=_con.createStatement();
	} catch (Exception ex) {//test
		System.out.println(ex.getMessage());//test
	}
	_rs = null;
}

/*public static Statement getStatement() {
	DB connectionOne = new DB();
	try {
		Class.forName("com.mysql.jdbc.Driver");
		connectionOne._con = DriverManager.getConnection(connectionOne._dbURL, connectionOne._user, connectionOne._password);
		connectionOne._statement=connectionOne._con.createStatement();
		
	} catch (Exception ex) {
		System.out.println("error in connecting");
	}
	return connectionOne._statement;   
}*/

public void  executeQuery( String sql) {
	try {
	this._rs= this._statement.executeQuery(sql);
	} catch (Exception ex) {
		System.out.println(ex.getMessage());
		
	}

}

public void initializeConnection() {
	try {
		Class.forName("com.mysql.jdbc.Driver");
		this._con = DriverManager.getConnection(this._dbURL, this._user, this._password);
		this._statement=this._con.createStatement();
	} catch (Exception ex) {
		System.out.println(ex.getMessage());
	}
	
}

public void closeConnection() {
		try {
			this._rs.close();
			this._statement.close();
			this._con.close();
		} catch (Exception ex) {
			System.out.println("error in connecting");
		}
}

	public static void executeUpdate(String sql) {
		DB connectionOne = new DB();
		//connectionOne._statement = getStatement();
		try {
			connectionOne._statement.executeUpdate(sql);
			connectionOne._statement.close();
			connectionOne._con.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
