package com.prueba.service;

import com.prueba.model.AdditionalData;
import com.prueba.model.Channel;
import com.prueba.model.DataModel;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.util.List;

@Service
public class ProcesarArchivosServiceImpl implements ProcesarArchivosService {

    @Override
    public DataModel leerArchivos(String id) throws Exception {
        JSONObject jsonObject = (JSONObject) readJsonObject();
        DataModel dataModel = new DataModel();
        dataModel.setId((String) jsonObject.get("id"));
        dataModel.setHref((String) jsonObject.get("href"));
        dataModel.setCorrelationId((String) jsonObject.get("correlationId"));
        dataModel.setDescription((String) jsonObject.get("description"));
        dataModel.setCreationDate((String) jsonObject.get("creationDate"));
        dataModel.setCategory((String) jsonObject.get("category"));
        dataModel.setSource((String) jsonObject.get("source"));
        dataModel.setStatus((String) jsonObject.get("status"));
        dataModel.setStatusChangeDate((String) jsonObject.get("statusChangeDate"));
        dataModel.setRelatedParty((String) jsonObject.get("relatedParty"));
        dataModel.setRelatedObject((String) jsonObject.get("relatedObject"));
        dataModel.setNote((String) jsonObject.get("note"));
        dataModel.setChannel((List<Channel>) jsonObject.get("channel"));
        dataModel.setAdditionalData((List<AdditionalData>) jsonObject.get("additionalData"));

        if(id.equals(dataModel.getId()) || id.isEmpty()){
            return dataModel;
        }
        return null;

    }

    private static Object readJsonObject() throws Exception {
        FileReader reader = new FileReader("src/main/resources/data/data11.json");
        JSONParser jsonParser = new JSONParser();
        return jsonParser.parse(reader);
    }
}
