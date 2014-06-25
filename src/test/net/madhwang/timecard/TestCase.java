package net.madhwang.timecard;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.madhwang.timecard.model.TimeStats;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/test-root-context.xml" })
public class TestCase {

	@Test
	public void testJson() throws JsonGenerationException, JsonMappingException, IOException {

		List<TimeStats> stat = new ArrayList<TimeStats>();

		TimeStats t1 = new TimeStats();
		t1.setMemberNo("1");

		TimeStats t2 = new TimeStats();
		t2.setMemberNo("2");

		stat.add(t1);
		stat.add(t2);

		ObjectMapper mapper = new ObjectMapper();
		String jsonMonthlyRecords = mapper.writeValueAsString(stat);
		System.out.println("====" + jsonMonthlyRecords + "====");

		/** ***** **/
		// Product p = new Product();
		// p.setName("FooBar Cookies");
		// p.setProductType("Food");
		// c.setBoughtProduct(p);
		//
		// XStream xstream = new XStream(new JettisonMappedXmlDriver());
		// xstream.setMode(XStream.NO_REFERENCES);
		// xstream.alias("p", Product.class);
		// String jSONMsg=xstream.toXML(product);
		// System.out.println(xstream.toXML(product));
	}

}
