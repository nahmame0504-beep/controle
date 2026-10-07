package ma.projet.beans;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "contrats")
public class Contrat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Temporal(TemporalType.DATE)
    private Date datedebut;
    
    @Temporal(TemporalType.DATE)
    private Date datefin;
    
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    
    @ManyToOne
    @JoinColumn(name = "assurance_id")
    private Assurance assurance;

    @Enumerated(EnumType.STRING)
    @Column(name = "statut", nullable = false, length = 20)
    private StatutContrat statut;

    public Contrat() {
    }

    public Contrat(Date datedebut, Date datefin, Client client, Assurance assurance) {
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.client = client;
        this.assurance = assurance;
        this.statut = StatutContrat.ACTIF; // Valeur par défaut
    }

    public Contrat(Date datedebut, Date datefin, Client client, Assurance assurance, StatutContrat statut) {
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.client = client;
        this.assurance = assurance;
        this.statut = statut;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public Date getDatedebut() { return datedebut; }
    public void setDatedebut(Date datedebut) { this.datedebut = datedebut; }

    public Date getDatefin() { return datefin; }
    public void setDatefin(Date datefin) { this.datefin = datefin; }
    
    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }

    public Assurance getAssurance() { return assurance; }
    public void setAssurance(Assurance assurance) { this.assurance = assurance; }

    public StatutContrat getStatut() { return statut; }
    public void setStatut(StatutContrat statut) { this.statut = statut; }
}
