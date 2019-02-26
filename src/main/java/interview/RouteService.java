package interview;

import java.util.List;

/**
 * Interface implemented by services to return routes.
 */
public interface RouteService {
    /**
     * Return all available routes
     *
     * @return list of all routes
     */
    List<String> getRoutes();
    /**
     * Return all available routes for a user
     *
     * @param userId id of the use
     * @return list of all routes for the use
     */
    List<String> getUserRoutes(String userId);
}
