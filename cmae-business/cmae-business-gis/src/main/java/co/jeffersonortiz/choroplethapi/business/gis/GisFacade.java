package co.jeffersonortiz.choroplethapi.business.gis;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.jeffersonortiz.choroplethapi.business.gis.facade.GisFacadeLocal;
import co.jeffersonortiz.choroplethapi.business.gis.facade.GisFacadeRemote;
import co.jeffersonortiz.choroplethapi.business.gis.service.GisService;
import co.jeffersonortiz.choroplethapi.business.gis.service.IGisService;
import co.jeffersonortiz.choroplethapi.entity.Shape;
import co.jeffersonortiz.choroplethapi.exception.business.BusinessException;

/**
 * 
 * @author <a href="mailto:me@jeffersonortiz.com">Jefferson Ortiz Quiroga</a>
 * @version 1.0
 */
@Stateless(name = "GisFacade", mappedName = "GisFacade")
@Remote(GisFacadeRemote.class)
@Local(GisFacadeLocal.class)
public class GisFacade implements GisFacadeLocal, GisFacadeRemote {

	private IGisService service;
	
	@PersistenceContext(unitName="cmae-gis-persistence")
	private EntityManager em;
	
	public GisFacade() {
		this.service = GisService.getInstance(em);
	}
	
	@Override
	public List<Shape> getAllWord() throws BusinessException {
		return this.service.getAllWord();
	}
}
