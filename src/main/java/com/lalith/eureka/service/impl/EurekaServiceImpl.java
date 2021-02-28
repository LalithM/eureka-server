package com.lalith.eureka.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

import com.lalith.eureka.service.EurekaService;

@Component
public class EurekaServiceImpl implements EurekaService
{

    @Autowired
    DiscoveryClient discoveryClient;

    @Override
    public Boolean checkIfServiceExists(String serviceId)
    {
        return discoveryClient.getServices().indexOf(serviceId) > 0 ? true : false;
    }

    @Override
    public List<ServiceInstance> getServiceInstances(String applicationName)
    {
        return discoveryClient.getInstances(applicationName);
    }

    @Override
    public List<String> getAllServices()
    {
        return discoveryClient.getServices();
    }
}
