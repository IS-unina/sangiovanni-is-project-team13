package Database;

import Entity.EntityPrenotazione;
import Entity.EntityVeicolo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Exception.*;

public class VeicoloDAO {
    public VeicoloDAO() {};

    public static void createVeicolo(EntityVeicolo veicolo) throws DAOException, DatabaseConnectionException {
        try {
            Connection conn = DBManager.getConnection();
            String query = "INSERT INTO VEICOLO VALUES (?,?,?,?,?,?);";

            try {
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setString(1, veicolo.getTarga());
                stmt.setString(2, veicolo.getModello());
                stmt.setInt(3, veicolo.getNumPasseggeri());
                stmt.setInt(4, veicolo.getTariffa());
                stmt.setString(5, veicolo.getAlimentazione());
                stmt.setString(6, veicolo.getStatoVeicolo());
                stmt.executeUpdate();
            } catch (SQLException var8) {
                throw new DAOException("Errore inserimento veicolo");
            } finally {
                DBManager.closeConnection();
            }

        } catch (SQLException | DAOException var10) {
            throw new DatabaseConnectionException("Errore connessione database");
        }
    }

    public static EntityVeicolo readVeicolo(String targa) throws DAOException, DatabaseConnectionException {
        EntityVeicolo eV= null;

        try {
            Connection conn = DBManager.getConnection();
            String query = "SELECT * FROM VEICOLO WHERE TARGA=?;";

            try {
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setString(1, targa);
                ResultSet result = stmt.executeQuery();
                if (result.next()) {
                    eV = new EntityVeicolo(targa, result.getString(2), result.getInt(3), result.getInt(4), result.getString(5), result.getString(6));
                }
            } catch (SQLException var10) {
                throw new DAOException("Errore lettura Veicolo");
            } finally {
                DBManager.closeConnection();
            }

            return eV;
        } catch (SQLException var12) {
            throw new DatabaseConnectionException("Errore connessione database");
        }
    }
    public static ArrayList<EntityVeicolo> readVeicoliDisponibili (ArrayList<String> stringhe) throws DAOException, DatabaseConnectionException, OperationException {
        EntityVeicolo eV = null;
        ArrayList<EntityVeicolo> lista = new ArrayList<>();
        ArrayList<String> targhe = new ArrayList<>();
        boolean control = true;
        boolean inizio = true;


        try {
            Connection conn = DBManager.getConnection();
            String query = "SELECT * FROM VEICOLO WHERE STATOVEICOLO='In Servizio';";


            try {
                PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet result = stmt.executeQuery();
                while (result.next())
                {
                    targhe.add(result.getString(1));
                }
                result.close();
                stmt.close();

                for (String targa:targhe
                     ) {
                    if(!stringhe.contains(targa))
                    {
                        eV = readVeicolo(targa);
                        lista.add(eV);

                    }

                }
            }catch (SQLException ex)
            {
                throw new DAOException("Errore lettura veicoli");
            }

            finally
             {
                DBManager.closeConnection();
            }
            return lista;
        }catch (SQLException ex)
        {
            throw new DatabaseConnectionException("Errore connessione al database");
        }

    }
    public static void modifyVeicolo (EntityVeicolo veicolo, String stato) throws DAOException, DatabaseConnectionException {
        try {
            Connection conn = DBManager.getConnection();
            String query = "UPDATE VEICOLO SET STATOVEICOLO=? WHERE TARGA=?;";

            try {
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setString(1, stato);
                stmt.setString(2, veicolo.getTarga());
                stmt.executeUpdate();
            } catch (SQLException var10) {
                throw new DAOException("Errore lettura Veicolo");
            } finally {
                DBManager.closeConnection();
            }
        } catch (SQLException var12) {
            throw new DatabaseConnectionException("Errore connessione database");
        }
    }
}
