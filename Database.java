import java.sql.*;

public class Database {
    private static Database instance = new Database(); //Singleton Pattern
    private String server_ip; // 서버 주소
    private String db_name; //데이터베이스 이름
    private String user_id; //  접속자 id
    private String passwd; // 접속자 pw
    private Connection con;

    private Database() {
        server_ip = "localhost";
        db_name = "contacts";
        user_id = "root";
        passwd = "1234";
        con = connectDB(server_ip, db_name, user_id, passwd);
    }

    public static Database getInstance() {
        return instance;
    }

    private static Connection connectDB(String ip, String db, String id, String pswd) {
        Connection con = null;
        String url = "jdbc:mysql://" + ip + "/" + db + "?characterEncoding=UTF-8&serverTimezone=UTC";

        // JDBC 드라이버 로드
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Load JDBC Driver Failed: " + e.getMessage());
            e.printStackTrace();
        }

        // 드라이버 접속
        try {
            con = DriverManager.getConnection(url, id, pswd);
            System.out.println("Database Connection Executed: ");
            System.out.println("\tserver_ip = " + ip + "\n\tdb_name = " + db);
        } catch(SQLException e) {
            System.err.println("Database Connection Failed: " + e.getMessage());
            e.printStackTrace();
        }

        return con;
    }

    public ResultSet executeSql(String sql) throws SQLException {
        PreparedStatement pstmt = con.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

//        //Example Code
//        while(rs.next()) {
//            System.out.print("name: " + rs.getString("contry") + "\t");
//            System.out.print("code: " + rs.getString("contry_code") + "\n");
//        }
//        rs.first();

        return rs;
    }
}
