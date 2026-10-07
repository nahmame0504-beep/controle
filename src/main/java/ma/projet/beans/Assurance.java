package ma.projet.beans;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "assurances")
public class Assurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String type;
    private double montant; 
    private String couverture;
    
    @OneToMany(mappedBy = "assurance", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Contrat> contrats;

    public Assurance() {
    }

    public Assurance(String type, double montant, String couverture) {
        this.type = type;
        this.montant = montant;
        this.couverture = couverture;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public double getMontant() { return montant; }
    public void setMontant(double montant) { this.montant = montant; }

    public String getCouverture() { return couverture; }
    public void setCouverture(String couverture) { this.couverture = couverture; }
    
    public List<Contrat> getContrats() { return contrats; }
    public void setContrats(List<Contrat> contrats) { this.contrats = contrats; }
}
