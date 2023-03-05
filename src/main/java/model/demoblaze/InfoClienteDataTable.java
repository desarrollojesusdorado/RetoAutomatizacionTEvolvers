package model.demoblaze;

import io.cucumber.java.DataTableType;

import java.util.Map;

public class InfoClienteDataTable {

    @DataTableType
    public DataInfoClient infoClient(Map<String, String> data){
        return new DataInfoClient(
        data.get("name"),
        data.get("country"),
        data.get("city"),
        data.get("creditCard"),
        data.get("month"),
        data.get("year"));
    }
}
