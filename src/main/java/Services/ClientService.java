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

    public Optional<Client> getClientbyId(String code){
        Optional<Client> client= impClient.getClientbyId(code);
        return client;
    }

    public ArrayList search(String param){
        ArrayList<Client> clients= impClient.search(param);
        return clients;
    }
}
