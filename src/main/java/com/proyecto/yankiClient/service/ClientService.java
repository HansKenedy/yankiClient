package com.proyecto.yankiClient.service;

import com.proyecto.yankiClient.domain.Client;
import io.reactivex.rxjava3.core.Observable;

import java.util.List;

public interface ClientService {
    Observable<?> findAll();
    public Observable<Client> findByCellPhone(String cellPhone);
    Client findById(String id);

    Client save(Client client);

    Client update(Client client);

    void delete(String id);
}
