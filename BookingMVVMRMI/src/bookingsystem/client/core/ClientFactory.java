package bookingsystem.client.core;

import bookingsystem.client.network.Client;
import bookingsystem.client.network.RMIClient;

public class ClientFactory {

    private Client client;

    public Client getClient() {
        if(client == null) {
            client = new RMIClient();
        }
        return client;
    }
}
