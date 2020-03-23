package de.wbstraining.lotto.business.lottospieler;

import java.math.BigInteger;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import de.wbstraining.lotto.dto.GewinnDetailedDto;
import de.wbstraining.lotto.persistence.model.Lottoschein;
import de.wbstraining.lotto.persistence.model.Lottoscheinziehung;
import de.wbstraining.lotto.persistence.model.Lottoscheinziehung6aus49;

@Stateless
public class GewinnErmitteln implements GewinnErmittelnLocal {

	@PersistenceContext(unitName = "corejsfPU")
	private EntityManager em;

	@Override
	public GewinnDetailedDto gewinn(long belegNr, LocalDate ziehungsDatum) {
		
		TypedQuery<Lottoschein> query;
		Lottoschein schein;
		List<Lottoscheinziehung> lzs;
		Lottoscheinziehung lziehung;
		
		int gklSpiel77;
		long quoteSpiel77;
		int gklSuper6;
		long quoteSuper6;
		int gkl6Aus49;
		
		query = em.createNamedQuery("Lottoschein.findByBelegnummer", Lottoschein.class)
				.setParameter("belegnummer", BigInteger.valueOf(belegNr));
		schein = query.getSingleResult();
		lzs = schein.getLottoscheinziehungList();
		lziehung = lzs.stream()
				.filter(lz -> date2LocalDate(lz.getZiehungid().getZiehungsdatum()).equals(ziehungsDatum)).findAny()
				.get();
		
		gklSpiel77 = lziehung.getGewinnklasseidspiel77().getGewinnklassenr();
		quoteSpiel77 = lziehung.getGewinnspiel77().longValue();
		gklSuper6 = lziehung.getGewinnklasseidsuper6().getGewinnklassenr();
		quoteSuper6 = lziehung.getGewinnsuper6().longValue();

		GewinnDetailedDto dto = new GewinnDetailedDto();
		
		dto.setBelegNr(belegNr);
		dto.setZiehungsDatum(lziehung.getZiehungid().getZiehungsdatum());
		dto.setGklSpiel77(gklSpiel77);
		dto.setQuoteSpiel77(quoteSpiel77);
		dto.setGklSuper6(gklSuper6);
		dto.setQuoteSuper6(quoteSuper6);
		for (Lottoscheinziehung6aus49 l6Aus49 : lziehung.getLottoscheinziehung6aus49List()) {
			gkl6Aus49 = l6Aus49.getGewinnklasseid().getGewinnklassenr();
			dto.addPair6Aus49(l6Aus49.getTippnr(), gkl6Aus49, l6Aus49.getGewinn().longValue());
		}
		return dto;
	}

	private LocalDate date2LocalDate(Date datum) {
		return Instant.ofEpochMilli(datum.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
	}

}