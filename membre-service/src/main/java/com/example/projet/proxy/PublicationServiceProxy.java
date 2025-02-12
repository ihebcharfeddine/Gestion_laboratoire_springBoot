package com.example.projet.proxy;

import com.example.projet.beans.PublicationBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "PUBLICATION-SERVICE")

public interface PublicationServiceProxy {
    @GetMapping("/publication/{id}")
    public PublicationBean findPublicationById(@PathVariable(name = "id") Long id);
}
