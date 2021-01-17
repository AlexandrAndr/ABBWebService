package ru.meschanov.webService;

import generated.Client;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class ClientRepository {
    private static final List<Client> clients = new ArrayList<>();

    @PostConstruct
    public void initData(){

        Client ivan = new Client();
        ivan.setFirstName("Иван");
        ivan.setLastName("Иванов");
        ivan.setSecondName("Иванович");
        ivan.setIncome(25000);
        ivan.setExpenses(10000);

        Client vasia = new Client();
        vasia.setFirstName("Василий");
        vasia.setLastName("Васильев");
        vasia.setSecondName("Васильевич");
        vasia.setIncome(30000);
        vasia.setExpenses(12000);

    }

    public Client findClient(String name){
        Assert.notNull(name);

        Client result = null;

        for (Client client : clients){
            if (name.equals(client.getFirstName())){
                result = client;
            }
        }
        return result;
    }
}
