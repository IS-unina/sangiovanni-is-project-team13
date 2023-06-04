package Database;

import Entity.EntityAzienda;
import Entity.EntityDipendente;

import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Exception.*;

public class AziendaDAO {
    public AziendaDAO() {
    }

    ;

    public static EntityAzienda readAzienda(String nome) throws DAOException, DatabaseConnectionException {
        EntityAzienda eA = null;

        try {
            Connection conn = DBManager.getConnection();
            String query = "SELECT * FROM AZIENDA WHERE NOME=?;";

            try {
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setString(1, nome);
                ResultSet result = stmt.executeQuery();
                if (result.next()) {
                    eA = new EntityAzienda(nome, result.getString(2), result.getString(3), result.getString(4), result.getString(5));
                }
            } catch (SQLException var10) {
                throw new DAOException("Errore lettura Azienda");
            } finally {
                DBManager.closeConnection();
            }

            return eA;
        } catch (SQLException var12) {
            throw new DatabaseConnectionException("Errore connessione database");
        }
    }

    public static void createAzienda(EntityAzienda azienda) throws DAOException, DatabaseConnectionException {
        try {
            Connection conn = DBManager.getConnection();
            String query = "INSERT INTO AZIENDA VALUES (?,?,?,?,?);";
            try {
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setString(1, azienda.getNome());
                stmt.setString(2, azienda.getIndirizzo());
                stmt.setString(3, azienda.getResponsabile());
                stmt.setString(4, azienda.getNumTelefono());
                stmt.setString(5, azienda.getEmail());
                stmt.executeUpdate();
            } catch (SQLException var8) {
                throw new DAOException("Errore inserimento azienda");
            } finally {
                DBManager.closeConnection();
            }

        } catch (SQLException | DAOException var10) {
            throw new DatabaseConnectionException("Errore connessione database");
        }
    }
}
