package com.matheuslemes.diazero.incidentRecords.modules.utilsIncident;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.matheuslemes.diazero.incidentRecords.modules.entity.IncidentEntity;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class utilsRespMessage {
    @Autowired
    private PasswordEncoder passwordEncoder;

    public static List formatMessages(String message) {
        JSONObject resp = new JSONObject();
        if (message.contains("id not found")) {
            resp.put("respError", "It was not possible to find the requested ID in the database because it is not registered there.");
        }

        if (!message.isEmpty() && !message.contains("id not found")) {
            resp.put("respError", message.split("\\(")[0]);
        } else if (message.isEmpty()) {
            resp.put("respError", "error capturing message to be handled, verify");

        }

        JSONArray arrayResp = new JSONArray();
        arrayResp.put(resp);
        List<JSONArray> respList = new ArrayList<>();
        respList.add(arrayResp);

        return respList.get(0).toList();
    }

    public static String genToken(IncidentEntity incidentEntity, PasswordEncoder passwordEncoder, String secretKey) {

        var encpryptUser = passwordEncoder.encode(incidentEntity.getName());
        Algorithm algorithm = Algorithm.HMAC256(secretKey);

        var roles = Arrays.asList("INCIDENT");
        var expiresIn = Instant.now().plus(Duration.ofMinutes(10));
        String token = JWT.create()
                .withIssuer("IncidentRecorsJava")
                .withSubject(incidentEntity.getIdIncident().toString())
                .withClaim("roles", roles)
                .withExpiresAt(expiresIn)
                .sign(algorithm);
        incidentEntity.setName(encpryptUser);

        return token;
    }
}
