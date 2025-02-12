package com.example.projet.proxy;

import com.example.projet.beans.EvenementBean;
import com.example.projet.beans.PublicationBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "EVENEMENT-SERVICE")

public interface EvenementServiceProxy {
    @GetMapping("/evenement/{id}")
    public EvenementBean findEvenementById(@PathVariable(name = "id") Long id);
}
