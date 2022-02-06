package com.prueba.controller;

import com.prueba.model.DataModel;
import com.prueba.service.ProcesarArchivosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
public class ProcesarArchivosController {

    @Autowired
    private ProcesarArchivosService procesarArchivosService;

    @GetMapping("/get")
    public DataModel consultar(@RequestParam String id) throws Exception {
        return procesarArchivosService.leerArchivos(id);
    }

    @GetMapping("/ping")
    public String test(){
        return "OK";
    }
}
