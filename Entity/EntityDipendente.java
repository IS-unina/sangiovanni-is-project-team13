package Entity;

import java.sql.Date;


public class EntityDipendente {
    private String NumPatente;
    private String Nome;
    private String Cognome;
    private String Email;
    private Date DataScadenza;
    private String Username;
    private String Password;
    private String IdAzienda;

    public String getIdAzienda() {
        return IdAzienda;
    }

    public void setIdAzienda(String idAzienda) {
        IdAzienda = idAzienda;
    }



    public EntityDipendente(String patente)
    {
        this.NumPatente= patente;

    }

    public EntityDipendente(String patente, String nome, String cognome, String email, Date data, String user, String pass, String IdAzienda)
    {
        this.Nome=nome;
        this.Cognome=cognome;
        this.Email=email;
        this.DataScadenza=data;
        this.Username=user;
        this.Password=pass;
        this.NumPatente= patente;
        this.IdAzienda = IdAzienda;

    }

    public String getNumPatente() {
        return NumPatente;
    }

    public void setNumPatente(String numPatente) {
        NumPatente = numPatente;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getCognome() {
        return Cognome;
    }

    public void setCognome(String cognome) {
        Cognome = cognome;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Date getDataScadenza() {
        return DataScadenza;
    }

    public void setDataScadenza(Date dataScadenza) {
        DataScadenza = dataScadenza;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
