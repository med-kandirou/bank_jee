package DTO;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Employe extends Personne {

    @NonNull private String matricule;
    @NonNull private String adresseemail;
    @NonNull private LocalDate daterecrutement;

    public Employe(String matricule,String firstName, String lastName, LocalDate birthday,String phone,String adresseemail,LocalDate daterecrutement){
        super(firstName,lastName,birthday,phone);
        this.matricule=matricule;
        this.adresseemail=adresseemail;
        this.daterecrutement=daterecrutement;
    }
}
