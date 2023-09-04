package com.proyecto.yankiClient.controller;

import com.proyecto.yankiClient.domain.Client;
import com.proyecto.yankiClient.repository.ClientRepository;
import com.proyecto.yankiClient.service.ClientService;
import io.reactivex.rxjava3.core.Observable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.List;

@RestController
@RequestMapping("/v1/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public DeferredResult<ResponseEntity<List<?>>> findAll() {
        DeferredResult<ResponseEntity<List<?>>> deferredResult = new DeferredResult<>();
        clientService.findAll().toList()
                .subscribe(userView -> deferredResult.setResult(ResponseEntity.accepted().body(userView)), deferredResult::setErrorResult);
        return deferredResult;
    }

    @GetMapping("/{cellPhone}")
    public DeferredResult<ResponseEntity<List<?>>> findById(@PathVariable String cellPhone) {
        DeferredResult<ResponseEntity<List<?>>> deferredResult = new DeferredResult<>();
        clientService.findByCellPhone(cellPhone).toList()
                .subscribe(userView -> deferredResult.setResult(ResponseEntity.accepted().body(userView)), deferredResult::setErrorResult);
        return deferredResult;
    }


    @PostMapping
    public ResponseEntity<?> save(@RequestBody Client client) {
        Client savedClient = clientService.save(client);
        return ResponseEntity.ok().body(savedClient);
    }


    @PutMapping
    public ResponseEntity<?> update(@RequestBody Client client) {
        Client updatedClient  = clientService.update(client);
        return ResponseEntity.ok().body(updatedClient);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        clientService.delete(id);
        return ResponseEntity.ok().body("Deleted successfully...!");
    }
}
