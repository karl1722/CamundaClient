package primary;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

public class RestClient {

    public final  String username = "admin";
    public final String password = "admin";

    private HttpURLConnection connect(URL url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
       // connection.setRequestMethod("GET");

    return connection;
    }



    public RestClient(URL url)  throws IOException {
        HttpURLConnection connection = connect(url);
    }
}
