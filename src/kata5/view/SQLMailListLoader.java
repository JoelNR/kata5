package kata5.view;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import kata5.model.Mail;

public class SQLMailListLoader {
    
    public static List<String> read() throws ClassNotFoundException, SQLException {
        //instalar el driver en JAVA para este programa
        Class.forName("org.sqlite.JDBC");
        List<String> list = new ArrayList<>();
        
        //Creamos la conexión con la BD y creamos un statement
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:data/base.db");
                Statement statement = connection.createStatement()) {
            
            ResultSet set = statement.executeQuery("SELECT email FROM people");
            while(set.next()) {
                Mail email = new Mail(set.getString("email"));
                if(MailParser.isMail(email.getMail())) {
                    list.add(email.getDomain());
                }
            }
        }
        return list;
    }
}
