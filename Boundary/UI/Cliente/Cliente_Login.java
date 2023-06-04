package Boundary.UI.Cliente;

import Boundary.BoundaryCliente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Boundary.MainTest;
import Exception.OperationException;

public class Cliente_Login extends JFrame{
    public JFrame frame;
    private JLabel Titolo;
    private JTextField username;
    private JTextField password;
    private JPanel LoginPanel;
    private JLabel labelUser;
    private JLabel labelPass;
    private JTextPane Messaggio;
    private JButton Conferma;
    private JButton Indietro;


public Cliente_Login() {
    BoundaryCliente boundaryCliente = new BoundaryCliente();
    setContentPane(LoginPanel);
    setTitle("Schermata Login");
    setSize(1000, 450);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setVisible(true);
    Conferma.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            boolean control = false;
            try {
                control = boundaryCliente.VerificaDipendente(username.getText(), password.getText());
                if(control == true)
                {
                    Cliente_Ricerca ricerca = new Cliente_Ricerca(username.getText());
                    dispose();
                    ricerca.frame.setVisible(true);

                }
                else
                    Messaggio.setText("Il dipendente non esiste, ritenta!");
            } catch (OperationException ex) {
                throw new RuntimeException(ex);
            }


        }
    });
    Indietro.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            MainTest.frame.setVisible(true);
        }
    });
}
}
