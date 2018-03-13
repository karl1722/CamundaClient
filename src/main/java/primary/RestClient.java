package primary;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.commons.codec.binary.Base64;

import javax.json.Json;
import javax.json.JsonObject;

public class RestClient {

    public final  String username = "demo";
    public final String password = "demo";
    public  String camundaUrl ;

    private HttpURLConnection connect(String parameters) throws  IOException{

        URL url = new URL(camundaUrl + "/" + parameters);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        String userpass = username + ":" + password;
        String basicAuth = "Basic " + new String(new Base64().encode(userpass.getBytes()));
        connection.setRequestProperty ("Authorization", basicAuth);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);
        connection.setDoInput(true);
        return connection;
    }

    private HttpURLConnection connect() throws IOException {

        return connect("");
    }

    public RestClient(String url) throws IOException{
        camundaUrl = url;
       // connect();
    }

        public void jiraTicketTransition(String issueType, String issueKey, String newStatus) throws IOException {
        HttpURLConnection connection = connect("process-definition/ProcessMessage/start");
        connection.setRequestMethod("POST");

        JsonObject jsonBody = Json.createObjectBuilder()
                .add("variables",
                        Json.createObjectBuilder().add("issueKey",issueKey)
                                .add("newStatus", newStatus)
                                .add("issueType", issueType)
                ).build();

        String encodedData = jsonBody.toString();
        connection.getOutputStream().write(encodedData.getBytes());

        try {
            InputStream inputStream = connection.getInputStream();
            System.out.println(inputStream);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public RestClient(URL url)  throws IOException {
        //do nothing
    }
}
