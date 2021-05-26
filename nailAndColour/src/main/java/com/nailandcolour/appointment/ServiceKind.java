package com.nailandcolour.appointment;

import com.nailandcolour.exceptions.UnrecognizableServiceException;
import com.nailandcolour.service.Manicure;
import com.nailandcolour.service.Pedicure;
import com.nailandcolour.service.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum ServiceKind {
    M (new Manicure()),
    P (new Pedicure());

    private Service service;

    ServiceKind(Service service) {
        this.service = service;
    }

    public static Service from (String name) {
        List<ServiceKind> services = Arrays.asList(values());
        for(int i = 0; i < services.size(); i++){
            if(name.trim().equalsIgnoreCase(services.get(i).toString())){
                return services.get(i).service;
            }
        }
        throw new UnrecognizableServiceException("Can't recognize " + name);


    }
}

