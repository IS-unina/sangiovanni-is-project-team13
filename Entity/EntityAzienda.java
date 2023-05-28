package Entity;

public class EntityAzienda {

    private String Nome;
    private String Indirizzo;
    private String Responsabile;
    private String NumTelefono;
    private String Email;

    public EntityAzienda(String nome, String indirizzo, String responsabile, String numTelefono, String email) {
        Nome = nome;
        Indirizzo = indirizzo;
        Responsabile = responsabile;
        NumTelefono = numTelefono;
        Email = email;

    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getIndirizzo() {
        return Indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        Indirizzo = indirizzo;
    }

    public String getResponsabile() {
        return Responsabile;
    }

    public void setResponsabile(String responsabile) {
        Responsabile = responsabile;
    }

    public String getNumTelefono() {
        return NumTelefono;
    }

    public void setNumTelefono(String numTelefono) {
        NumTelefono = numTelefono;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
