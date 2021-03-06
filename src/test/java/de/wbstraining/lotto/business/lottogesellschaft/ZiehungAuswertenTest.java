package de.wbstraining.lotto.business.lottogesellschaft;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import de.wbstraining.lotto.persistence.dao.LottoscheinziehungFacadeLocal;
import de.wbstraining.lotto.persistence.dao.SpielFacadeLocal;
import de.wbstraining.lotto.persistence.dao.ZiehungFacadeLocal;
import de.wbstraining.lotto.persistence.model.Lottoscheinziehung;
import de.wbstraining.lotto.persistence.model.Spiel;
import de.wbstraining.lotto.persistence.model.Ziehung;
import de.wbstraining.lotto.populatedb.CleanDatabaseLocal;
import de.wbstraining.lotto.populatedb.PopulateDatabaseLocal;
import de.wbstraining.lotto.testdatengenerierung.CZiehungTestdatenGeneratorLocal;
import de.wbstraining.lotto.testdatengenerierung.Testdatengenerator;

@RunWith(Arquillian.class)
public class ZiehungAuswertenTest {

	private static String schemaPath = "testdatengenerator.xsd";
//	private static String xmlPath = "testdatengenerator.xml";
//	private static String xmlPath = "testdatengenerator_2o2m2o2m.xml";
	private static String xmlPath = "testdatengenerator_15zieOhneGkl1.xml";

	@Deployment
	public static Archive<?> createTestArchive() {
		WebArchive archive = ShrinkWrap.create(WebArchive.class, "test.war")
				.addPackages(true, "de.wbstraining.lotto.persistence",
						"de.wbstraining.lotto.populatedb", "de.wbstraining.lotto.util",
						"de.wbstraining.lotto.business.lottospieler",
						"de.wbstraining.lotto.cache", "de.wbstraining.lotto.mail",
						"de.wbstraining.lotto.dto",
						"de.wbstraining.lotto.business.lottogesellschaft",
						"de.wbstraining.lotto.web.lottospieler.controller",
						"org.primefaces.event", "de.wbstraining.lotto.testdatengenerierung")
				.addAsResource(
						new File("src/test/resources/testdatengenerator/" + xmlPath))
				.addAsResource(
						new File("src/test/resources/testdatengenerator/" + schemaPath))
				.addAsResource("META-INF/persistence.xml")
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
		return archive;
	}

	@EJB
	private ZiehungAuswertenLocal ziehungAuswerten;

	@EJB
	private ZiehungFacadeLocal ziehungFacade;

	@EJB
	private SpielFacadeLocal spielFacade;

	@EJB
	private LottoscheinziehungFacadeLocal lottoscheinZiehungFacade;

	@EJB
	CleanDatabaseLocal cleanDatabase;

	@EJB
	PopulateDatabaseLocal populateDatabase;

	@EJB
	CZiehungTestdatenGeneratorLocal cZiehungTestdatenGenerator;

	@PersistenceContext(unitName = "corejsfPU")
	private EntityManager em;

	@Test
	public void ziehungAuswerten() throws Exception {

		StreamSource schemaSource = new StreamSource(getClass().getClassLoader()
				.getResourceAsStream(schemaPath));
		SchemaFactory schemaFactory = SchemaFactory
				.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = schemaFactory.newSchema(schemaSource);

		JAXBContext context = JAXBContext.newInstance(Testdatengenerator.class);

		Unmarshaller um = context.createUnmarshaller();
		um.setSchema(schema);
		JAXBElement<Testdatengenerator> nodeElement = um
				.unmarshal(new StreamSource(getClass().getClassLoader()
						.getResourceAsStream(xmlPath)), Testdatengenerator.class);
		Testdatengenerator generator = nodeElement.getValue();
		System.out.println(generator.getBelegnummernStart());

		cleanDatabase.cleanDatabase("mydbtest");

		populateDatabase.populateDatabase();
		cZiehungTestdatenGenerator
				.generiereTestDatenFuerMehrereZiehungen(generator);

//		Alle Ziehungen auswerten
		List<Ziehung> ziehungen = ziehungFacade.findAll();
		ziehungen.forEach(ziehungAuswerten::ziehungAuswerten);

		List<Spiel> spiele = spielFacade.findAll();
		Map<String, Spiel> spielMap = new HashMap<>();
		long anzahlSuper6TotalActual;
		long anzahlSpiel77TotalActual;
		long anzahlSuper6TotalExpected = 21;
		long anzahlSpiel77TotalExpected = 28;
		spiele.stream()
				.forEach(s -> spielMap.put(s.getName(), s));

		TypedQuery<Lottoscheinziehung> query = em.createQuery(
				"SELECT lz FROM Lottoscheinziehung lz where lz.ziehung.ziehungid = 1L",
				Lottoscheinziehung.class);

		List<Lottoscheinziehung> lzList = query.getResultList();
		anzahlSpiel77TotalActual = lzList.stream()

				.filter(lz -> lz.getGewinnklassespiel77() != null
						&& lz.getGewinnklassespiel77()
								.getSpiel()
								.getName()
								.equals("Spiel 77"))
				.count();
		System.out.println("aF");
		anzahlSuper6TotalActual = lzList.stream()
				.filter(lz -> lz.getGewinnklassesuper6() != null
						&& lz.getGewinnklassesuper6()
								.getSpiel()
								.getName()
								.equals("Super 6"))
				.count();
		assertEquals(anzahlSuper6TotalExpected, anzahlSuper6TotalActual);
		assertEquals(anzahlSpiel77TotalExpected, anzahlSpiel77TotalActual);

	}
}
