package interview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Flow;

/**
 * Utility class to hold specific route interfaces and query functions
 */
public class Routes {

    ServiceManager serviceManager;
    public Routes(ServiceManager serviceManager){
        this.serviceManager = serviceManager;
    }

    public List<String> getAllRoutes(){
        List<String> allRoutes = new ArrayList<>();
        List<RouteService> routes = serviceManager.getServices();
        for (RouteService service: routes)
            allRoutes.addAll(service.getRoutes());
        return allRoutes;
    }

    public List<String> getUniqueRoutes(){
        Set<String> uniqueRoutes = new HashSet<>();
        List<RouteService> routes = serviceManager.getServices();
        for (RouteService service: routes)
            uniqueRoutes.addAll(service.getRoutes());
        List<String> allRoutes = new ArrayList<>();
        allRoutes.addAll(uniqueRoutes);
        return allRoutes;
    }
    public List<String> getUserRoutes(String userId){
        List<String> allRoutes = new ArrayList<>();
        List<RouteService> routes = serviceManager.getServices();
        for (RouteService service: routes)
            allRoutes.addAll(service.getUserRoutes(userId));
        return allRoutes;
    }

    public List<String> getUserRoutesByService(String userId, String[] services){
        List<String> allRoutes = new ArrayList<>();
        for (String serviceId: services){
            RouteService routeService = serviceManager.getService(serviceId);
            if (null != routeService)
                allRoutes.addAll(routeService.getUserRoutes(userId));
        }
        return allRoutes;
    }

    public static void printRoutes(String prefix, List<String> routes){
        System.out.print(prefix + ": [");
        boolean bFirst = true;
        for (String route: routes) {
            if (!bFirst)
                System.out.print(", ");
            bFirst = false;
            System.out.print("\"" + route + "\"");
        }
        System.out.println("]");
    }
}
