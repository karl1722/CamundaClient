package tests;

import primary.RestClient;

import java.io.IOException;
import java.net.URL;


public class Go {

    public static void main(String args[]) throws IOException {
        String url = "http://localhost:9080/engine-rest";

    RestClient restClient = new RestClient(url);
    restClient.jiraTicketTransition("EXT-6", "New", "Asked");

    int x=1;



}

}
