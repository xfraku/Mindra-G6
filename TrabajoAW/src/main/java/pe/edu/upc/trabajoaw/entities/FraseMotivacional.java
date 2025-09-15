package pe.edu.upc.trabajoaw.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "FraseMotivacional")
public class FraseMotivacional {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idFraseMotivacional;

    @Column(name = "frase", length = 100, nullable = false)
    private String frase;

    public FraseMotivacional() {
    }

    public FraseMotivacional(String frase, int idFraseMotivacional) {
        this.frase = frase;
        this.idFraseMotivacional = idFraseMotivacional;
    }

    public int getIdFraseMotivacional() {
        return idFraseMotivacional;
    }

    public void setIdFraseMotivacional(int idFraseMotivacional) {
        this.idFraseMotivacional = idFraseMotivacional;
    }

    public String getFrase() {
        return frase;
    }

    public void setFrase(String frase) {
        this.frase = frase;
    }
}
