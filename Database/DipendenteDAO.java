package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Entity.EntityDipendente;
import Exception.*;
import java.lang.String;
import java.security.SecureRandom;
import java.util.ArrayList;

public class DipendenteDAO {
    public DipendenteDAO() {
    }

    ;

    public static EntityDipendente readDipendente(String username) throws DAOException, DatabaseConnectionException {
        EntityDipendente eD = null;

        try {
            Connection conn = DBManager.getConnection();
            String query = "SELECT * FROM DIPENDENTE WHERE USERNAME=?;";

            try {
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setString(1, username);
                ResultSet result = stmt.executeQuery();
                if (result.next()) {
                    eD = new EntityDipendente(result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getDate(5), username, result.getString(7), result.getString(8));
                }
            } catch (SQLException var10) {
                throw new DAOException("Errore lettura Dipendente");
            } finally {
                DBManager.closeConnection();
            }

            return eD;
        } catch (SQLException var12) {
            throw new DatabaseConnectionException("Errore connessione database");
        }
    }

    public static String createDipendente(EntityDipendente dipendente) throws DAOException, DatabaseConnectionException {
        try {
            Connection conn = DBManager.getConnection();
            String query = "INSERT INTO DIPENDENTE VALUES (?,?,?,?,?,?,?,?);";
            String query2 = "SELECT COUNT (*) FROM DIPENDENTE;";
            int numDipendenti = 0;
            String username = "";
            final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
            SecureRandom random = new SecureRandom();
            StringBuilder password = new StringBuilder();
            try {
                PreparedStatement stmt = conn.prepareStatement(query2);
                ResultSet result = stmt.executeQuery();
                if (result.next()) {
                    numDipendenti = result.getInt(1);
                }
                result.close();
                stmt.close();
                username = "User" + String.valueOf(numDipendenti+1);
                for (int i = 0; i < 7; i++) {
                    int randomIndex = random.nextInt(chars.length());
                    password.append(chars.charAt(randomIndex));
                }
                stmt = conn.prepareStatement(query);
                stmt.setString(1, dipendente.getNumPatente());
                stmt.setString(2, dipendente.getNome());
                stmt.setString(3, dipendente.getCognome());
                stmt.setString(4, dipendente.getEmail());
                stmt.setDate(5, dipendente.getDataScadenza());
                stmt.setString(6, username);
                stmt.setString(7, password.toString());
                stmt.setString(8, dipendente.getIdAzienda());
                stmt.executeUpdate();
            } catch (SQLException var8) {
                throw new DAOException("Errore inserimento dipendente");
            } finally {
                DBManager.closeConnection();
            }

            return username;

        } catch (SQLException | DAOException var10) {
            throw new DatabaseConnectionException("Errore connessione database");
        }
    }

    public static boolean verifyDipendente (String user, String pass) throws DAOException, DatabaseConnectionException
    {
        try {
            Connection conn = DBManager.getConnection();
            String query = "SELECT * FROM DIPENDENTE WHERE (USERNAME=? AND PASSWORD=?);";

            try {
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setString(1, user);
                stmt.setString(2, pass);
                ResultSet result = stmt.executeQuery();
                if (result.next())
                    return true;
            } catch (SQLException var10) {
                throw new DAOException("Errore lettura Dipendente");
            } finally {
                DBManager.closeConnection();
            }
            return false;
        } catch (SQLException var12) {
            throw new DatabaseConnectionException("Errore connessione database");
        }
    }
}
