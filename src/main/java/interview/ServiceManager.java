package interview;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServiceManager {

    private List<RouteService> services = new ArrayList<>();

    public static class Builder{
        private Map<String, String> services = new HashMap<>();

        public ServiceManager build(){
            ServiceManager serviceManager = new ServiceManager();
            for (Map.Entry<String, String> entry: services.entrySet())
                serviceManager.addService(entry.getKey(), entry.getValue());
            return serviceManager;
        }

        public Builder withService(String serviceId, String serviceClass){
            services.put(serviceId, serviceClass);
            return this;
        }
    }

    public RouteService addService(String serviceId, String serviceClass){
        try{
            Class<?> c = Class.forName(serviceClass);
            Constructor<?> ctor = c.getConstructor(String.class);
            RouteService service = (RouteService)ctor.newInstance(serviceId);
            services.add(service);
            return service;
        }
        catch (Exception e){
            return null;
        }
    }

    public List<RouteService> getServices(){
        return services;
    }

    public RouteService getService(String id){
        for (RouteService service: services){
            if (service.getId().compareToIgnoreCase(id) == 0)
                return service;
        }
        return null;
    }

    private ServiceManager(){

    }
}
