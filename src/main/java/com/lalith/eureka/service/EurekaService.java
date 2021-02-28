package com.lalith.eureka.service;

import java.util.List;

import org.springframework.cloud.client.ServiceInstance;

public interface EurekaService
{
    Boolean checkIfServiceExists(String serviceId);

    List<ServiceInstance> getServiceInstances(String applicationName);

    List<String> getAllServices();
}
