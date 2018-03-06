import primary.RestClient;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;


public class Go {

    public static void main(String args[]) throws IOException {
        URL url = new URL("http://localhost:9080/rest/engine");

    RestClient restClient = new RestClient(url);

    int x=1;



}

}
