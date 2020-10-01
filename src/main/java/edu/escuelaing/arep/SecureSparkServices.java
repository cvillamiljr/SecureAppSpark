package edu.escuelaing.arep;

import static spark.Spark.*;

/**
 * Hello world!
 *
 */

public class SecureSparkServices
{
    public static void main( String[] args )
    {
        staticFileLocation("/static");
        port(getPort());
        //API: secure(keystoreFilePath, keystorePassword, truststoreFilePath,truststorePassword);
        secure("keystore/ecikeystore.p12", "123456", null, null);
        get("/hello", (req, res) -> "Hello web Services");

        get("/",(req,res) ->{
            res.redirect("index.html");
            return null;
        });
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5000;
    }

}
