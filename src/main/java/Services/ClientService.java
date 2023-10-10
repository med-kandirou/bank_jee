package Services;

import DAO.ImpClient;
import DTO.Client;

import java.util.ArrayList;
import java.util.Optional;

public class ClientService {
    ImpClient impClient;
    public ClientService(ImpClient impClient){
        this.impClient=impClient;
    }

    public boolean add(Client client){
        Optional<Client> optClient= impClient.add(client);
        return optClient.isPresent();
    }

    public boolean update(Client client){
        Optional<Client> optClient= impClient.update(client);
        return optClient.isPresent();
    }

    public ArrayList getAll(){
        ArrayList<Client> clients= impClient.getAll();
        return clients;
    }
}
