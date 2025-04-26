package com.matheuslemes.diazero.incidentRecords.modules.utilsIncident;

import org.json.JSONObject;

public class utilsRespMessage {

    public static String formatMessages(String message) {
        JSONObject resp = new JSONObject();

        if (message.contains("id not found")) {
            resp.put("respError", "It was not possible to find the requested ID in the database because it is not registered there.");
        }

        if (!message.isEmpty() && !message.contains("id not found")) {
            resp.put("respError", message.split("\\(")[0]);
        } else if (message.isEmpty()) {
            resp.put("respError", "error capturing message to be handled, verify");

        }
        return resp.toString();
    }
}
