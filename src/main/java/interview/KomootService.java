package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Komoot implementation of RouteService interface
 */
public class KomootService implements RouteService {
    private String[] routes = new String[]{"SRT", "Welsh Mountain", "Oaks to Philly"};

    @Override
    public List<String> getRoutes() {
        return Arrays.asList(routes);
    }

    @Override
    public List<String> getUserRoutes(String userId) {
        List<String> res = new ArrayList<>();
        for (String route: routes)
            res.add(userId + route + userId);
        return res;
    }
}
