package DTO;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
public class Client extends Personne{
    @NonNull private String code;
    @NonNull private String adresse;

    public Client(String code,String firstName, String lastName, LocalDate birthday,String phone,String adresse){
        super(firstName,lastName,birthday,phone);
        this.code=code;
        this.adresse=adresse;
    }
}
