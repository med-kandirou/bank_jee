package DAO;

import DTO.Employe;
import Interfaces.IEmploye;

import java.util.Optional;

public class ImpEmploye implements IEmploye {
    @Override
    public Optional<Employe> add(Employe employe) {
        return Optional.empty();
    }
    @Override
    public int delete(String s) {
        return 0;
    }

    @Override
    public Optional<Employe> update(Employe employe) {
        return Optional.empty();
    }
}
