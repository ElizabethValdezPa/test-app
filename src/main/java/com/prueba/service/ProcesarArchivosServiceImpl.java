package com.prueba.service;

import ch.qos.logback.classic.Logger;
import com.prueba.model.AdditionalData;
import com.prueba.model.Channel;
import com.prueba.model.DataModel;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.util.List;

@Service
public class ProcesarArchivosServiceImpl implements ProcesarArchivosService {

    @Override
    public DataModel leerArchivos(Long id) throws Exception {
        JSONObject ss = (JSONObject) readJsonObject();

        JSONArray jsonArray = (JSONArray) ss.get("data");
        DataModel dataModel = new DataModel();

        for (int i = 0; i <jsonArray.size(); i++) {
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            System.out.println("*****");
            System.out.println(jsonObject.get("id").getClass().getName());
            System.out.println(id);
            if(jsonObject.get("id") == id) {
                dataModel.setId((Long) jsonObject.get("id"));
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
            }
        }
        return dataModel;

    }


    private static Object readJsonObject() throws Exception {
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("data11.json");
        File bathFile = File.createTempFile("filename", "file format");
        FileUtils.copyInputStreamToFile(inputStream, bathFile);
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(bathFile);
        return jsonParser.parse(reader);
    }



}
