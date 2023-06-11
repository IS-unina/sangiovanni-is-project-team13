package Boundary;

import Boundary.UI.Azienda.Azienda;
import Boundary.UI.Cliente.Cliente_Login;
import Boundary.UI.Cliente.Cliente_Ricerca;
import Boundary.UI.Direttore.Direttore_scelta;
import Boundary.UI.Responsabile.Responsabile_ModificaVeicolo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MainTest extends JFrame{
    static public JFrame frame;
    private JButton Direttore;
    private JButton Azienda;
    private JButton Dipendente;
    private JButton Responsabile_Officina;
    private JPanel panel1;
    private JLabel Titolo;
    private JLabel Picture;

    public MainTest(){
        setContentPane(panel1);
        setTitle("ADD CAR RENTAL");
        setSize(1000, 550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        Direttore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Direttore_scelta direttore = new Direttore_scelta();
                MainTest.frame.setVisible(false);
                direttore.frame.setVisible(true);

            }
        });
        Responsabile_Officina.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Responsabile_ModificaVeicolo responsabile = new Responsabile_ModificaVeicolo();
                MainTest.frame.setVisible(false);
                responsabile.frame.setVisible(true);

            }
        });
        Azienda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Azienda azienda = new Azienda();
                MainTest.frame.setVisible(false);
                azienda.frame.setVisible(true);

            }
        });
        Dipendente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cliente_Login cliente = new Cliente_Login();
                MainTest.frame.setVisible(false);
                cliente.frame.setVisible(true);
            }
        });
    };
    public static void main(String args[])
    {
        try{
            new MainTest();
        } catch (Exception var12)
        {
            var12.printStackTrace();
        }


    }

}
