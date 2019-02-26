package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * RWGPS implementation of RouteService interface
 */
public class RWGPSService implements RouteService {
    private String[] routes = new String[]{"CVT", "Perkiomen", "Welsh Mountain"};
    private String id;

    public RWGPSService(String id){
        this.id = id;
    }

    @Override
    public String getId(){ return id;}


    @Override
    public List<String> getRoutes() {
        return Arrays.asList(routes);
    }

    @Override
    public List<String> getUserRoutes(String userId) {
        List<String> res = new ArrayList<>();
        for (String route: routes)
            res.add(route + userId);
        return res;
    }
}
