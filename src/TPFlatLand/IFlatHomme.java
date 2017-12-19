package TPFlatLand;

import java.time.LocalDateTime;

public interface IFlatHomme extends IFlatLandien {

    public String getNom();

    public void setNom(String nom);

    public LocalDateTime getDateNaissance();

    public void setDateNaissance(LocalDateTime dateNaissance);

}
