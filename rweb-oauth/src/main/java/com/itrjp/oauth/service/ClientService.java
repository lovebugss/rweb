package com.itrjp.oauth.service;

import com.itrjp.oauth.bean.Client;

import java.util.List;


/*
 * 
 * @Author renjp
 * @Date 2018/11/15 14:42
 * @Version 1.0
 **/
public interface ClientService {

    public Client createClient(Client client);
    public Client updateClient(Client client);
    public void deleteClient(Long clientId);

    Client findOne(Long clientId);

    List<Client> findAll();

    Client findByClientId(String clientId);
    Client findByClientSecret(String clientSecret);

}
