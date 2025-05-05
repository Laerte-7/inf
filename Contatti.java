import java.io.Serializable;

public class Contatti implements Serializable{
    String nome;  
    String numTel;
    String email;


    public Contatti(String nome, String numTel, String email) {
        this.nome = nome;
        this.numTel = numTel;
        this.email = email;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getNumTel() {
        return numTel;
    }


    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    
    public String toString() {
        
        return nome+" - "+numTel+"/"+email;
    }
    
}
