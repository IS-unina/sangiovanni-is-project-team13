package Control;

import Entity.EntityVeicolo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


import static org.junit.jupiter.api.Assertions.*;

class RicercaVeicoliTest {
    final GestioneNoleggio gestioneNoleggio = GestioneNoleggio.getInstance();

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testRicercaVeicoli_1() throws Throwable{
    Date DataDiRitiro = Date.valueOf("2023-11-23");
    Date DataDiConsegna = Date.valueOf("2023-11-28");
    Date DataLocale = Date.valueOf(LocalDate.now());
    ArrayList<EntityVeicolo> Lista = new ArrayList();
    Lista = (ArrayList<EntityVeicolo>) gestioneNoleggio.RicercaVeicoli(DataDiRitiro, DataDiConsegna).clone();
    assertTrue(DataDiRitiro.before(DataDiConsegna));
    assertTrue(DataDiRitiro.after(DataLocale));
    assertTrue(DataDiRitiro.before(Date.valueOf("2030-01-01")));
    assertTrue(DataDiConsegna.after(DataDiRitiro));
    assertTrue(DataDiRitiro.after(DataLocale));
    assertTrue(DataDiRitiro.before(Date.valueOf("2030-01-01")));

    assertThat(Lista.isEmpty(), is(false));

        for (EntityVeicolo veicolo:Lista
             ) {
            assertTrue(veicolo instanceof EntityVeicolo);
        }

    }
    @Test
    void testRicercaVeicoli_2() throws Throwable{
        Date DataDiRitiro = Date.valueOf("2023-23-11");
        Date DataDiConsegna = Date.valueOf("2023-11-28");
        ArrayList<EntityVeicolo> Lista = new ArrayList(0);
        Lista = (ArrayList<EntityVeicolo>) gestioneNoleggio.RicercaVeicoli(DataDiRitiro, DataDiConsegna).clone();
        assertThat(Lista.isEmpty(), is(true));

    }
    @Test
    void testRicercaVeicoli_3() throws Throwable{
        Date DataDiRitiro = Date.valueOf("2023-11-29");
        Date DataDiConsegna = Date.valueOf("2023-11-28");
        ArrayList<EntityVeicolo> Lista = new ArrayList();
        Lista = (ArrayList<EntityVeicolo>) gestioneNoleggio.RicercaVeicoli(DataDiRitiro, DataDiConsegna).clone();
        assertThat(Lista.isEmpty(), is(true));


    }
    @Test
    void testRicercaVeicoli_4() throws Throwable{

        Date DataDiRitiro = Date.valueOf("2023-11-23");
        Date DataDiConsegna = Date.valueOf("2023-11-28");
        Date DataLocale = Date.valueOf(LocalDate.now());
        ArrayList<EntityVeicolo> Lista = new ArrayList();
        Lista = (ArrayList<EntityVeicolo>) gestioneNoleggio.RicercaVeicoli(DataDiRitiro, DataDiConsegna).clone();
        assertThat(Lista.isEmpty(), is(true));
    }
    @Test
    void testRicercaVeicoli_5() throws Throwable{
        Date DataDiRitiro = Date.valueOf("2030-01-02");
        Date DataDiConsegna = Date.valueOf("2023-11-28");
        ArrayList<EntityVeicolo> Lista = new ArrayList();
        Lista = (ArrayList<EntityVeicolo>) gestioneNoleggio.RicercaVeicoli(DataDiRitiro, DataDiConsegna).clone();
        assertThat(Lista.isEmpty(), is(true));

    }
    @Test
    void testRicercaVeicoli_6() throws Throwable{
        Date DataDiRitiro = Date.valueOf("2023-11-23");
        Date DataDiConsegna = Date.valueOf("2023-28-11");
        ArrayList<EntityVeicolo> Lista = new ArrayList();
        Lista = (ArrayList<EntityVeicolo>) gestioneNoleggio.RicercaVeicoli(DataDiRitiro, DataDiConsegna).clone();
        assertThat(Lista.isEmpty(), is(true));

    }
    @Test
    void testRicercaVeicoli_7() throws Throwable{
        Date DataDiRitiro = Date.valueOf("2023-11-29");
        Date DataDiConsegna = Date.valueOf("2023-11-28");
        ArrayList<EntityVeicolo> Lista = new ArrayList();
        Lista = (ArrayList<EntityVeicolo>) gestioneNoleggio.RicercaVeicoli(DataDiRitiro, DataDiConsegna).clone();
        assertThat(Lista.isEmpty(), is(true));
    }
    @Test
    void testRicercaVeicoli_8() throws Throwable{
        Date DataDiRitiro = Date.valueOf("2023-11-23");
        Date DataDiConsegna = Date.valueOf("2023-06-22");
        ArrayList<EntityVeicolo> Lista = new ArrayList();
        Lista = (ArrayList<EntityVeicolo>) gestioneNoleggio.RicercaVeicoli(DataDiRitiro, DataDiConsegna).clone();
        assertThat(Lista.isEmpty(), is(true));

    }
    @Test
    void testRicercaVeicoli_9() throws Throwable{
        Date DataDiRitiro = Date.valueOf("2023-11-23");
        Date DataDiConsegna = Date.valueOf("2030-01-02");
        ArrayList<EntityVeicolo> Lista = new ArrayList();
        Lista = (ArrayList<EntityVeicolo>) gestioneNoleggio.RicercaVeicoli(DataDiRitiro, DataDiConsegna).clone();
        assertThat(Lista.isEmpty(), is(true));


    }
    @Test
    void testRicercaVeicoli_10() throws Throwable{
        Date DataDiRitiro = Date.valueOf("2023-11-23");
        Date DataDiConsegna = Date.valueOf("2030-01-02");
        ArrayList<EntityVeicolo> Lista = new ArrayList();
        Lista = (ArrayList<EntityVeicolo>) gestioneNoleggio.RicercaVeicoli(DataDiRitiro, DataDiConsegna).clone();
        assertThat(Lista.isEmpty(), is(true));


    }


}