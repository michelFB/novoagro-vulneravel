package projeto;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conex�oBancoDados {
	private Connection con = null;
	private String hostName = null;
	private String userName = null;
	private String password = null;
	private String url = null;
	private String jdbcDriver = null;
	private String dataBaseName = null;
	private String dataBasePrefix = null;

	public Conex�oBancoDados() {
		jdbcDriver = "org.firebirdsql.jdbc.FBDriver";
		dataBasePrefix = "jdbc:firebirdsql";
		dataBaseName = "login-vulneravel";
		userName = "SYSDBA";
		hostName = "localhost";
		password = "masterkey";
		url = dataBasePrefix + ":" + hostName + ":" + dataBaseName;
	}
	
	public Connection getConnection() {
		Runtime.getRuntime().gc();
		try {
			if (con == null) {
				Class.forName(jdbcDriver);
				con = DriverManager.getConnection(url, userName, password);
			} else if (con.isClosed()) {
				con = null;
				return getConnection();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public void closeConnection() {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}

/*






public static void main(String[] args) throws SQLException, ClassNotFoundException {
Class.forName("org.firebirdsql.jdbc.FBDriver");  
String url = "jdbc:firebirdsql:localhost:login1";  
Connection conexao  = DriverManager.getConnection(url,"SYSDBA","masterkey"); 
System.out.println("Conectado!");
conexao.close();
		}
}

	*/
