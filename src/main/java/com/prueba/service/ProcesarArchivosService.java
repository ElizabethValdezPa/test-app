package com.prueba.service;

import com.prueba.model.DataModel;

public interface ProcesarArchivosService {

    DataModel leerArchivos(Long id) throws Exception;
}
