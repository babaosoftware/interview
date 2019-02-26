/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package interview;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {

        Routes routes = new Routes();
        Routes.printRoutes(routes.getAllRoutes());
        Routes.printRoutes(routes.getUniqueRoutes());
        Routes.printRoutes(routes.getUserRoutes("42"));
        String[] services = new String[]{"Strava", "Komoot"};
        Routes.printRoutes(routes.getUserRoutesByService("42", services ));
    }
}
