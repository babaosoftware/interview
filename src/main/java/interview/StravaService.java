package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Strava implementation of RouteService interface
 */
public class StravaService implements RouteService {

    private String[] routes = new String[]{"SRT", "CVT", "Perkiomen"};

    @Override
    public List<String> getRoutes() {
        return Arrays.asList(routes);
    }

    @Override
    public List<String> getUserRoutes(String userId) {
        List<String> res = new ArrayList<>();
        for (String route: routes)
            res.add(userId + route);
        return res;
    }
}
