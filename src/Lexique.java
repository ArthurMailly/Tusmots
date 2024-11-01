
import java.sql.*;

public class Lexique {
    private static Lexique instance = new Lexique();
    
    private Connection conn;
    private PreparedStatement psMotAleatoire;
    private PreparedStatement psMotExiste;
    private String url ="jdbc:sqlite:rsrc/lexique.db"; // chemin de la base de données, faudra peut être adapter selon ce que vous avez

    private Lexique() {
        try {
            conn = DriverManager.getConnection(url);
            psMotAleatoire = conn.prepareStatement("select * from Lexique order by random() limit 1");
            psMotExiste = conn.prepareStatement("select * from Lexique where mot = ?");
        } catch (SQLException e) {
            System.err.println("Erreur de connexion à la base de données");
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
    // Singleton DP pour s'assurer que on a qu'une seule instance de Lexique, que l'on va retourner dans la classe Partie pour vérifier si le mot existe - Fares les Grosses Fesses
    public static Lexique getInstance(){
        if (instance == null){
            instance = new Lexique();
        }
        return instance;
    }

}

