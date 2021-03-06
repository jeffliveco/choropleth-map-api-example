package co.jeffersonortiz.choroplethapi.business.gis;

import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.jeffersonortiz.choroplethapi.business.gis.facade.GisFacadeLocal;
import co.jeffersonortiz.choroplethapi.business.gis.facade.GisFacadeRemote;
import co.jeffersonortiz.choroplethapi.business.gis.service.GisService;
import co.jeffersonortiz.choroplethapi.business.gis.service.IGisFacade;
import co.jeffersonortiz.choroplethapi.dto.ShapeDto;

/**
 * 
 * @author <a href="mailto:me@jeffersonortiz.com">Jefferson Ortiz Quiroga</a>
 * @version 1.0
 */
@Stateless(name = "GisFacade", mappedName = "GisFacade")
@Remote(GisFacadeRemote.class)
@Local(GisFacadeLocal.class)
public class GisFacade implements GisFacadeLocal, GisFacadeRemote {

	private final static Logger logger = Logger.getLogger(GisFacade.class.getName());
	
	private IGisFacade service;
	
	@PersistenceContext(unitName="cmae-gis-persistence")
	private EntityManager em;
	
	@PostConstruct
	public void init() {
		logger.info("GisFacade->init()");
		this.service = GisService.getInstance(em);
	}
	
	@Override
	public List<ShapeDto> getAllWord() {
		return this.service.getAllWord();
	}
}
