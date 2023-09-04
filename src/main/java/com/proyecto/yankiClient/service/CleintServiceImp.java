package com.proyecto.yankiClient.service;

import com.proyecto.yankiClient.domain.Client;
import com.proyecto.yankiClient.repository.ClientRepository;
import io.reactivex.rxjava3.core.Observable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CleintServiceImp implements ClientService{

    @Autowired
    private ClientRepository clientRepository;
    @Override
    public Observable<Client> findAll() {
        return Observable.fromIterable(clientRepository.findAll()) ;
    }

    @Override
    public Observable<Client> findByCellPhone(String cellPhone) {
        return Observable.fromIterable(clientRepository.findAll()).filter(client -> client.getCellPhone().equals(cellPhone));
    }

    @Override
    public Client findById(String id) {
        return clientRepository.findById(id).orElse(new Client());
    }

    @Override
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client update(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public void delete(String id) {
        clientRepository.findById(id).ifPresent(client -> clientRepository.delete(client));
    }
}
