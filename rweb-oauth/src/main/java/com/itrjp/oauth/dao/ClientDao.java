package com.itrjp.oauth.dao;


import com.itrjp.oauth.bean.Client;

import java.util.List;


public interface ClientDao {

    Client createClient(Client client);

    Client updateClient(Client client);

    void deleteClient(Long clientId);

    Client findOne(Long clientId);

    List<Client> findAll();

    Client findByClientId(String clientId);

    Client findByClientSecret(String clientSecret);

}
