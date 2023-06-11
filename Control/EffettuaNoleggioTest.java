package Control;

import static org.junit.jupiter.api.Assertions.*;

import Entity.EntityPrenotazione;
import Entity.EntityVeicolo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import Database.PrenotazioneDAO;
class EffettuaNoleggioTest {
    final GestioneNoleggio gestioneNoleggio = GestioneNoleggio.getInstance();

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testEffettuaNoleggio_1() throws Throwable{
        Date DataDiRitiro = Date.valueOf("2023-11-23");
        Date DataDiConsegna = Date.valueOf("2023-11-28");
        Date DataLocale = Date.valueOf(LocalDate.now());
        String IdVeicolo = "AB123CD";
        String IdDipendente = "User1";
        int Prezzo;
        Prezzo =  gestioneNoleggio.EffettuaNoleggio(IdVeicolo, DataDiRitiro, DataDiConsegna, IdDipendente);
        assertTrue(DataDiRitiro.before(DataDiConsegna));
        assertTrue(DataDiRitiro.after(DataLocale));
        assertTrue(DataDiRitiro.before(Date.valueOf("2030-01-01")));
        assertTrue(DataDiConsegna.after(DataDiRitiro));
        assertTrue(DataDiRitiro.after(DataLocale));
        assertTrue(DataDiRitiro.before(Date.valueOf("2030-01-01")));
        assertNotNull(Prezzo);

    }
    @Test
    void testEffettuaNoleggio_2() throws Throwable{
        Date DataDiRitiro = Date.valueOf("2023-23-11");
        Date DataDiConsegna = Date.valueOf("2023-11-28");
        String IdVeicolo = "AB123CD";
        String IdDipendente = "User1";
        int Prezzo;
        Prezzo =  gestioneNoleggio.EffettuaNoleggio(IdVeicolo, DataDiRitiro, DataDiConsegna, IdDipendente);
        assertNull(Prezzo);

    }
    @Test
    void testEffettuaNoleggio_3() throws Throwable{
        Date DataDiRitiro = Date.valueOf("2023-11-29");
        Date DataDiConsegna = Date.valueOf("2023-11-28");
        String IdVeicolo = "AB123CD";
        String IdDipendente = "User1";
        int Prezzo;
        Prezzo =  gestioneNoleggio.EffettuaNoleggio(IdVeicolo, DataDiRitiro, DataDiConsegna, IdDipendente);
        assertNull(Prezzo);


    }
    @Test
    void testEffettuaNoleggio_4() throws Throwable{

        Date DataDiRitiro = Date.valueOf("2023-11-23");
        Date DataDiConsegna = Date.valueOf("2023-11-28");
        Date DataLocale = Date.valueOf(LocalDate.now());
        String IdVeicolo = "AB123CD";
        String IdDipendente = "User1";
        int Prezzo;
        Prezzo =  gestioneNoleggio.EffettuaNoleggio(IdVeicolo, DataDiRitiro, DataDiConsegna, IdDipendente);
        assertNull(Prezzo);
    }
    @Test
    void testEffettuaNoleggio_5() throws Throwable{
        Date DataDiRitiro = Date.valueOf("2030-01-02");
        Date DataDiConsegna = Date.valueOf("2023-11-28");
        String IdVeicolo = "AB123CD";
        String IdDipendente = "User1";
        int Prezzo;
        Prezzo =  gestioneNoleggio.EffettuaNoleggio(IdVeicolo, DataDiRitiro, DataDiConsegna, IdDipendente);
        assertNull(Prezzo);

    }
    @Test
    void testEffettuaNoleggio_6() throws Throwable{
        Date DataDiRitiro = Date.valueOf("2023-11-23");
        Date DataDiConsegna = Date.valueOf("2023-28-11");
        String IdVeicolo = "AB123CD";
        String IdDipendente = "User1";
        int Prezzo;
        Prezzo =  gestioneNoleggio.EffettuaNoleggio(IdVeicolo, DataDiRitiro, DataDiConsegna, IdDipendente);
        assertNull(Prezzo);

    }
    @Test
    void ttestEffettuaNoleggio_7() throws Throwable{
        Date DataDiRitiro = Date.valueOf("2023-11-29");
        Date DataDiConsegna = Date.valueOf("2023-11-28");
        String IdVeicolo = "AB123CD";
        String IdDipendente = "User1";
        int Prezzo;
        Prezzo =  gestioneNoleggio.EffettuaNoleggio(IdVeicolo, DataDiRitiro, DataDiConsegna, IdDipendente);
        assertNull(Prezzo);
    }
    @Test
    void testEffettuaNoleggio_8() throws Throwable{
        Date DataDiRitiro = Date.valueOf("2023-11-23");
        Date DataDiConsegna = Date.valueOf("2023-06-22");
        String IdVeicolo = "AB123CD";
        String IdDipendente = "User1";
        int Prezzo;
        Prezzo =  gestioneNoleggio.EffettuaNoleggio(IdVeicolo, DataDiRitiro, DataDiConsegna, IdDipendente);
        assertNull(Prezzo);

    }
    @Test
    void testEffettuaNoleggio_9() throws Throwable{
        Date DataDiRitiro = Date.valueOf("2023-11-23");
        Date DataDiConsegna = Date.valueOf("2030-01-02");
        String IdVeicolo = "AB123CD";
        String IdDipendente = "User1";
        int Prezzo;
        Prezzo =  gestioneNoleggio.EffettuaNoleggio(IdVeicolo, DataDiRitiro, DataDiConsegna, IdDipendente);
        assertNull(Prezzo);


    }
    @Test
    void testEffettuaNoleggio_10() throws Throwable {
        Date DataDiRitiro = Date.valueOf("2023-11-23");
        Date DataDiConsegna = Date.valueOf("2030-01-02");
        String IdVeicolo = null;
        String IdDipendente = "User1";
        int Prezzo;
        Prezzo =  gestioneNoleggio.EffettuaNoleggio(IdVeicolo, DataDiRitiro, DataDiConsegna, IdDipendente);
        assertNull(Prezzo);


    }
    @Test
    void testEffettuaNoleggio_11() throws Throwable {
        Date DataDiRitiro = Date.valueOf("2023-11-23");
        Date DataDiConsegna = Date.valueOf("2030-01-02");
        String IdVeicolo = "User1";
        String IdDipendente = null;
        int Prezzo;
        Prezzo =  gestioneNoleggio.EffettuaNoleggio(IdVeicolo, DataDiRitiro, DataDiConsegna, IdDipendente);
        assertNull(Prezzo);

    }
    @Test
    void testEffettuaNoleggio_12() throws Throwable {
        Date DataDiRitiro = Date.valueOf("2023-11-23");
        Date DataDiConsegna = Date.valueOf("2030-01-02");
        int numPrenotazione = 1;
        String IdVeicolo = null;
        String IdDipendente = "User1";
        int Prezzo;
        EntityPrenotazione prenotazione = PrenotazioneDAO.readPrenotazione(numPrenotazione);
        Prezzo =  gestioneNoleggio.EffettuaNoleggio(IdVeicolo, DataDiRitiro, DataDiConsegna, IdDipendente);
        assertNull(Prezzo);
        assertNull(prenotazione);

    }
}