package TPFlatLandAbstract.TPFlatLand;

import java.time.LocalDateTime;

public interface IFlatLandien {

    public String getNom();

    public void setNom(String nom);

    public LocalDateTime getDateNaissance();

    public void setDateNaissance(LocalDateTime dateNaissance);

    public void sePresenter();
    public String toString();


    public void setFlatLandien(String nom, LocalDateTime dateNaissance);

}
