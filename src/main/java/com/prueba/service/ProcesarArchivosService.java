package com.prueba.service;

import com.prueba.model.DataModel;

public interface ProcesarArchivosService {

    DataModel leerArchivos(String id) throws Exception;
}
