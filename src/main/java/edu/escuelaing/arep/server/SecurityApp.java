package edu.escuelaing.arep.server;
import edu.escuelaing.arep.server.model.Jugador;
import edu.escuelaing.arep.server.model.Ranking;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

import static spark.Spark.*;

public class SecurityApp {

    public static void main(String[] args) {
        port(getPort());
        secure("keystores2/ecikeystore.p12", "123456",  null,null);
        get("/",(req,res) -> "Welcome to Server container");

        get("/getRanking",(req,res) -> getRankig());

    }


    private static JSONObject getRankig() throws JSONException {
        JSONObject response = new JSONObject();
        Ranking ranking = new Ranking();
        List<Jugador> players = ranking.getTeams();
        List<JSONObject> data = new LinkedList<>();
        try{
            for(Jugador i: players){
                JSONObject json = new JSONObject();
                json.put("name",i.getName());
                json.put("country",i.getCountry());
                json.put("points",i.getPoints());
                data.add(json);
            }
            response.put("response",data);
        } catch (JSONException e){
            e.printStackTrace();
            response = new JSONObject();
            response.put("response","Error al cargar los datos");
        }
        System.out.println(response);
        return response;
    }


    /**
     * Método enccargado de definir el puerto por donde corre el programa
     *
     * @return variable de tipo int
     */
    public static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}
