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

    RouteService stravaService;
    RouteService rwgpsService;
    RouteService komootService;
    public Routes(){
        stravaService = new StravaService();
        rwgpsService = new RWGPSService();
        komootService = new KomootService();
    }

    public List<String> getAllRoutes(){
        List<String> routes = new ArrayList<>();
        routes.addAll(stravaService.getRoutes());
        routes.addAll(rwgpsService.getRoutes());
        routes.addAll(komootService.getRoutes());
        return routes;
    }

    public List<String> getUniqueRoutes(){
        Set<String> uniqueRoutes = new HashSet<>();
        uniqueRoutes.addAll(stravaService.getRoutes());
        uniqueRoutes.addAll(rwgpsService.getRoutes());
        uniqueRoutes.addAll(komootService.getRoutes());
        List<String> routes = new ArrayList<>();
        routes.addAll(uniqueRoutes);
        return routes;
    }
    public List<String> getUserRoutes(String userId){
        List<String> routes = new ArrayList<>();
        routes.addAll(stravaService.getUserRoutes(userId));
        routes.addAll(rwgpsService.getUserRoutes(userId));
        routes.addAll(komootService.getUserRoutes(userId));
        return routes;
    }

    public List<String> getUserRoutesByService(String userId, String[] services){
        List<String> routes = new ArrayList<>();
        for (String service: services){
            switch (service){
                case "Strava": routes.addAll(stravaService.getUserRoutes(userId)); break;
                case "Komoot": routes.addAll(komootService.getUserRoutes(userId)); break;
                case "RWGPS": routes.addAll(rwgpsService.getUserRoutes(userId)); break;
                default: break;
            }
        }
        return routes;
    }

    public static void printRoutes(List<String> routes){
        System.out.print("[");
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
