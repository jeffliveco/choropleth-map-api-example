package co.jeffersonortiz.choroplethapi.services.gis;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import co.jeffersonortiz.choroplethapi.services.gis.routes.CountryRoute;
import co.jeffersonortiz.choroplethapi.services.gis.routes.MainRoute;

@ApplicationPath("/v1/")
public class GisServiceRestApplication extends Application {
	 public Set<Class<?>> getClasses() {
		 Set<Class<?>> classes = new HashSet<>();
		 classes.add(MainRoute.class);
		 classes.add(CountryRoute.class);
		 return classes;
	 }
}
