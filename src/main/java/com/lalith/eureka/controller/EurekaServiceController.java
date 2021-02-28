package com.lalith.eureka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lalith.eureka.service.EurekaService;

@RestController
@RequestMapping("/api/eurekaService")
public class EurekaServiceController
{
    @Autowired
    EurekaService eurekaService;

    @GetMapping("/serviceInstances/{applicationName}")
    public List<ServiceInstance> serviceInstancesByApplicationName(
            @PathVariable("applicationName") String applicationName)
    {
        return eurekaService.getServiceInstances(applicationName);
    }

    @GetMapping("/services")
    public List<String> getServices()
    {
        return eurekaService.getAllServices();
    }

    @GetMapping("/serviceInstances/{serviceId}")
    public Boolean checkIfServiceExists(@PathVariable("serviceId") String serviceId)
    {
        return eurekaService.checkIfServiceExists(serviceId);
    }
}
