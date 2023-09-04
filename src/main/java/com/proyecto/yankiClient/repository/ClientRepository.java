package com.proyecto.yankiClient.repository;

import com.proyecto.yankiClient.domain.Client;
import io.reactivex.rxjava3.core.Observable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClientRepository extends MongoRepository<Client,String> {

}
