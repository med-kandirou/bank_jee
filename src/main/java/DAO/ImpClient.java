package DAO;

import DTO.Client;
import Interfaces.IClient;

import java.util.Optional;

public class ImpClient implements IClient {
    @Override
    public Optional<Client> add(Client client) {
        return Optional.empty();
    }

    @Override
    public int delete(String s) {
        return 0;
    }
}
