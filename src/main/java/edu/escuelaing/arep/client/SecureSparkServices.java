package edu.escuelaing.arep.client;


import edu.escuelaing.arep.server.model.Jugador;
import edu.escuelaing.arep.server.model.Ranking;
import org.apache.commons.codec.digest.DigestUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

import static spark.Spark.*;

/**
 * Hello world!
 *
 */

public class SecureSparkServices
{
    private static final String username = "cvillamil@hotmail.com";
    private static final String password = "7110eda4d09e062aa5e4a390b0a572ac0d2c0220";

    public static void main( String[] args )
    {
        staticFileLocation("/static");
        port(getPort());
        //API: secure(keystoreFilePath, keystorePassword, truststoreFilePath,truststorePassword);
        secure("keystores2/ecikeystore.p12", "123456", null, null);
        get("/hello", (req, res) -> "Hello web Services");

        get("/", (req,res) -> {
            res.redirect("index.html");
            return null;
        });

        get("/getData",(req,res) -> getResponse());
        post("/login",(req, res) -> verificarData(new JSONObject(req.body())));
    }
    private static Object getResponse() throws JSONException {
        String res = "";
        JSONObject data = null;
        try{
            res += HttpServer.readURL("https://ec2-3-87-197-196.compute-1.amazonaws.com:4567/getRanking");
            data = new JSONObject(res);
        }catch (Exception e){
            data = new JSONObject("Error en la conexión con el Servidor");
        }

        return data;
    }
    private static JSONObject verificarData(JSONObject data) throws JSONException {
        JSONObject response = new JSONObject();
        try {
            String user = data.get("user").toString();
            String pass = data.get("pass").toString();

            String hashPass = DigestUtils.sha1Hex(pass);
            System.out.println(hashPass);
            if(user.equals(username) && hashPass.equals(password)){
                response.put("response","Datos correctos");
            }
            else
                response.put("response","Datos incorrectos");

        } catch (JSONException e) {
            e.printStackTrace();
            response.put("response","Error en la verificación");
        }
        System.out.println(response);
        return response;
    }
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5002;
    }

}
