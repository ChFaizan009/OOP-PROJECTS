package pk.ed.uog.Product.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pk.ed.uog.Product.model.ProductCategory;
import pk.ed.uog.Product.repository.productCatergoryRepository;

@RestController
@CrossOrigin
@RequestMapping("/ProductCatergory")
public class productCatergoryController
{
	private static final Logger log = LoggerFactory.getLogger(productCatergoryController.class);

	@Autowired
	private productCatergoryRepository productCatergoryrepository;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getAll() throws JsonProcessingException
	{
		ObjectMapper mapper = new ObjectMapper();
		log.info("GET: /ProductCatergory");

		String rtn;
		
		List<ProductCategory> productCatergory= productCatergoryrepository.findActive();
		rtn=mapper.writeValueAsString(productCatergory);
		return rtn;
	}
}
