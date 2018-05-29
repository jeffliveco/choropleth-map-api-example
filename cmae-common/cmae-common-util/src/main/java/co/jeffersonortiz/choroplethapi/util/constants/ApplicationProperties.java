package co.jeffersonortiz.choroplethapi.util.constants;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

import co.jeffersonortiz.choroplethapi.exception.constants.NoFilePropertiesException;

/**
 * 
 * @author <a href="mailto:me@jeffersonortiz.com">Jefferson Ortiz Quiroga</a>
 * @version 1.0
 */
public abstract class ApplicationProperties<K> {

	private Logger logger = Logger.getLogger(ApplicationProperties.class.getName());
	
	private Properties moduleAttributes;
	
	public ApplicationProperties(String nameFile) {
		try {
			InputStream propertiesStream = null;
			this.moduleAttributes = new Properties();
			propertiesStream = getClass().getClassLoader().getResourceAsStream(nameFile);
			if (propertiesStream != null) {
				this.moduleAttributes.load(propertiesStream);
				propertiesStream.close();
			} else {
				logger.info("ErrorLoad('" + nameFile + "')");
				throw new NoFilePropertiesException("FILE/PROPERTIES_LOAD_ERROR");
			}
			logger.info("LoadFile('" + nameFile + "')");
		} catch (IOException e) {
			logger.info("Error('" + e.getMessage() + "')");
			throw new NoFilePropertiesException("FILE/PROPERTIES_LOAD_ERROR", e);
		}
	}
	
	protected Properties getModuleAttributes() {
		return this.moduleAttributes;
	}
	
	public abstract String getValue(K attribute);
}
