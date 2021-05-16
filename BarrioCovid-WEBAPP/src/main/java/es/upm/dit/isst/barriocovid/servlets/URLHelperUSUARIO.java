package es.upm.dit.isst.barriocovid.servlets;

public class URLHelperUSUARIO {
    public static String getURL() {
            String envValue = System.getenv("USUARIOSERVICE_SRV_SERVICE_HOST");
            if(envValue == null)
                    return "http://localhost:8080/BarrioCovid-SERVICE/rest/USUARIOs";
            else
                    return envValue;
    }
}

