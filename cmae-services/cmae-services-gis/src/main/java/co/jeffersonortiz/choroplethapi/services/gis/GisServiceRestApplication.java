package co.jeffersonortiz.choroplethapi.services.gis;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import co.jeffersonortiz.choroplethapi.services.gis.routes.CountryRoute;
import co.jeffersonortiz.choroplethapi.services.gis.routes.MainRoute;
import co.jeffersonortiz.choroplethapi.util.rest.helper.ExceptionHelper;

@ApplicationPath("/v1/")
public class GisServiceRestApplication extends Application {
	 public Set<Class<?>> getClasses() {
		 Set<Class<?>> classes = new HashSet<>();
		 classes.add(MainRoute.class);
		 classes.add(CountryRoute.class);
		 classes.add(ExceptionHelper.class);
		 return classes;
	 }
}
