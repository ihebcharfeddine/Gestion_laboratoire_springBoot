package com.example.projet.proxy;

import com.example.projet.beans.OutilBean;
import com.example.projet.beans.PublicationBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "OUTIL-SERVICE")

public interface OutilServiceProxy {
    @GetMapping("/outil/{id}")
    public OutilBean findOutilById(@PathVariable(name = "id") Long id);
}
