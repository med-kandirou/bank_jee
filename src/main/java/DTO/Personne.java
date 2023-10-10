package DTO;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@RequiredArgsConstructor
public abstract class Personne {
    @NonNull protected String firstName;
    @NonNull protected String lastName;
    @NonNull protected LocalDate birthday;
    @NonNull protected String phone;

    /*protected Personne(Personne p){
        this.nom=p.getNom();
        this.prenom=p.getPrenom();
        this.dateNaissance=p.getDateNaissance();
        this.telephone=p.getTelephone();
    }*/
}
