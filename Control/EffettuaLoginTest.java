package Control;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import Database.DipendenteDAO;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
class EffettuaLoginTest {

    final GestioneNoleggio gestioneNoleggio = GestioneNoleggio.getInstance();

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testEffettuaLogin_1() throws Throwable {
        String username = "User4";
        String password = "AB12C34";
        gestioneNoleggio.EffettuaLogin(username, password);
        assertNotNull(username);
        assertNotNull(password);
        assertThat(username.contains("User"), is(false));
        assertNotNull(DipendenteDAO.readDipendente(username));
        assertEquals(password.length(), 7);
    }
    @Test
    void testEffettuaLogin_2() throws Throwable {
        String username = "";
        String password = "AB12C34";
        gestioneNoleggio.EffettuaLogin(username, password);

        assertNull(DipendenteDAO.readDipendente(username));
    }
    @Test
    void testEffettuaLogin_3() throws Throwable {
        String username = "U4";
        String password = "AB12C34";
        gestioneNoleggio.EffettuaLogin(username, password);
        assertNull(DipendenteDAO.readDipendente(username));
    }
    @Test
    void testEffettuaLogin_4() throws Throwable {
        String username = "User50";
        String password = "AB12C34";
        gestioneNoleggio.EffettuaLogin(username, password);
        assertNull(DipendenteDAO.readDipendente(username));
    }
    @Test
    void testEffettuaLogin_5() throws Throwable {
        String username = "User4";
        String password = "";
        gestioneNoleggio.EffettuaLogin(username, password);
        assertNull(DipendenteDAO.readDipendente(username));
    }
    @Test
    void testEffettuaLogin_6() throws Throwable {
        String username = "User4";
        String password = "AB12C34DE";
        gestioneNoleggio.EffettuaLogin(username, password);
        assertNull(DipendenteDAO.readDipendente(username));
    }

}