
import java.sql.*;

public class Lexique {
    private static Lexique instance = new Lexique();
    private Connection conn;
    private PreparedStatement psMotAleatoire;
    private PreparedStatement psMotExiste;

    private Lexique() {
        try {
            conn = DriverManager.getConnection("jdbc:sqlite::resource:lexique.db");
            psMotAleatoire = conn.prepareStatement("select * from Lexique order by random() limit 1");
            psMotExiste = conn.prepareStatement("select * from Lexique where mot = ?");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Mot motAleatoire() {
        try {
            ResultSet rs = instance.psMotAleatoire.executeQuery();
            rs.next();
            return new Mot(rs.getString("mot"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Boolean motExiste(Mot mot) {
        try {
            instance.psMotExiste.setString(1, mot.getMot());
            return instance.psMotExiste.executeQuery().next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

