package components;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.mule.api.MuleEventContext;
import org.mule.api.MuleMessage;

import beans.CustomerCollectionResponse;
import beans.Response;
import models.Customer;
import models.CustomerRepository;

public class Customers extends Component {
	final static Logger logger = Logger.getLogger(Customers.class);

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		MuleMessage message = eventContext.getMessage();
		Map<String, String> params = message.getInboundProperty("http.query.params");
		String action = message.getInvocationProperty("action");
		
		try {
			switch(action) {
			case "get-all-customers":
				CustomerRepository repository = new CustomerRepository(dataSource(com.mysql.jdbc.Driver.class));
				List<Customer> customers = repository.findAll();
				
				if (customers != null && customers.size() > 0) {
					CustomerCollectionResponse response = new CustomerCollectionResponse(200, "OK", "Success");
					response.setData(customers);
					
					return response;
				} else {
					return new Response(404, "KO", "Not found");
				}
			}
			
		} catch (Exception e) {
			logger.fatal(e.getMessage());
			return new Response(500, "KO", "Internal error");
		}
		
		return new Response(400, "KO", "Invalid request");
	}

}