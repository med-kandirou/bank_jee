package DAO;

import Config.Database;
import DTO.Client;
import Interfaces.IClient;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ImpClient implements IClient {

    Connection cnx= Database.getconn();
    @Override
    public Optional<Client> add(Client client) {
        try {
            String insertSql = "insert into client (code, nom, prenom, datenaissance, telephone, adresse) values (?,?,?,?,?,?)";
            PreparedStatement preparedStatement = cnx.prepareStatement(insertSql);
            preparedStatement.setString(1, client.getCode());
            preparedStatement.setString(2, client.getFirstName());
            preparedStatement.setString(3,client.getLastName());
            preparedStatement.setDate(4, Date.valueOf(client.getBirthday()));
            preparedStatement.setString(5,client.getPhone());
            preparedStatement.setString(6,client.getAdresse());
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                return Optional.ofNullable(client);
            }
            preparedStatement.close();
        }
        catch (Exception e){
            System.out.print(e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public int delete(String s) {
        return 0;
    }

    @Override
    public Optional<Client> update(Client client) {
        try {
            String updateSql = "update client set nom=? , prenom=? , datenaissance=?, telephone=? ,adresse=? where code like ?";
            PreparedStatement preparedStatement = cnx.prepareStatement(updateSql);
            preparedStatement.setString(1, client.getFirstName());
            preparedStatement.setString(2,client.getLastName());
            preparedStatement.setDate(3, Date.valueOf(client.getBirthday()));
            preparedStatement.setString(4,client.getPhone());
            preparedStatement.setString(5,client.getAdresse());
            preparedStatement.setString(6,client.getCode());
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                preparedStatement.close();
                return Optional.ofNullable(client);
            }
        }
        catch (Exception e){
            System.out.print(e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public ArrayList<Client> getAll() {
        ArrayList<Client> Clients= new ArrayList<>();
        try {
            String selectSql = "SELECT * FROM client";
            PreparedStatement preparedStatement = cnx.prepareStatement(selectSql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String code=resultSet.getString("code");
                String fname=resultSet.getString("nom");
                String lname=resultSet.getString("prenom");
                String phone=resultSet.getString("telephone");
                LocalDate date=resultSet.getDate("datenaissance").toLocalDate();
                String adresse=resultSet.getString("adresse");
                Client client=new Client(code,fname,lname,date,phone,adresse);
                Clients.add(client);
            }
            resultSet.close();
            preparedStatement.close();
        }
        catch (SQLException e){
            System.out.print(e.getMessage());
        }
        return Clients;
    }

    @Override
    public Optional<Client> getClientbyId(String code) {
        Client client = null;
        try {
            String selectSql = "SELECT * FROM client WHERE code like '"+code+"'";
            PreparedStatement preparedStatement = cnx.prepareStatement(selectSql);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                String codec=resultSet.getString("code");
                String fname=resultSet.getString("nom");
                String lname=resultSet.getString("prenom");
                String phone=resultSet.getString("telephone");
                LocalDate date=resultSet.getDate("datenaissance").toLocalDate();
                String adresse=resultSet.getString("adresse");
                client=new Client(codec,fname,lname,date,phone,adresse);
            }
            resultSet.close();
            preparedStatement.close();
            return Optional.ofNullable(client);
        }
        catch (SQLException e){
            System.out.print(e.getMessage());
        }
        return Optional.empty();
    }


    public ArrayList<Client> search(String param) {
        ArrayList<Client> Clients= new ArrayList<>();
        try {
            String selectSql = "SELECT * FROM client where code like ? or nom like ? or prenom like ? or telephone like ? or adresse like ?";
            PreparedStatement preparedStatement = cnx.prepareStatement(selectSql);
            preparedStatement.setString(1, param);
            preparedStatement.setString(2,param);
            preparedStatement.setString(3,param);
            preparedStatement.setString(4,param);
            preparedStatement.setString(5,param);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String code=resultSet.getString("code");
                String fname=resultSet.getString("nom");
                String lname=resultSet.getString("prenom");
                String phone=resultSet.getString("telephone");
                LocalDate date=resultSet.getDate("datenaissance").toLocalDate();
                String adresse=resultSet.getString("adresse");
                Client client=new Client(code,fname,lname,date,phone,adresse);
                Clients.add(client);
            }
            resultSet.close();
            preparedStatement.close();
        }
        catch (SQLException e){
            System.out.print(e.getMessage());
        }
        return Clients;
    }
}
