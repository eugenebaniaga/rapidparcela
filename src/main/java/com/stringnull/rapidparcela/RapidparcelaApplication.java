package com.stringnull.rapidparcela;

import com.stringnull.rapidparcela.models.Customer;
import com.stringnull.rapidparcela.models.Shipping;
import com.stringnull.rapidparcela.repositories.CustomerRepository;
import com.stringnull.rapidparcela.repositories.ShippingRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.math.BigDecimal;
import java.util.Optional;

@SpringBootApplication
public class RapidparcelaApplication {

	public static void main(String[] args) {
		SpringApplication.run(RapidparcelaApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner (CustomerRepository customerRepository, ShippingRepository shippingRepository){
		return args -> {
			Customer customer = new Customer();
			customer.setFirstname("Eugene");
			customer.setLastname("Baniaga");
			customer.setContact("0928182828");
			customer.setUsername("eugene");
			customer.setPassword("abc");
			customer.setEmail("baniaga.eugene@gmail.com");
			customer.setAddress("Address test");
			customer.setShippings(null);
			Customer savedCustomer  = customerRepository.save(customer);


			//add shipping...
			Shipping shipping = new Shipping();
			shipping.setAmount(BigDecimal.valueOf(1500.00));
			shipping.setReferenceNumber("11113433");
			shipping.setCustomer(savedCustomer);
			shipping.setDeliveryPersonel(null);
			shipping.setShippingDetails(null);
			shipping.setShippingStatus(null);
			shippingRepository.save(shipping);

			//Optional<Customer> findCust = customerRepository.findById(Long.valueOf(1));
			//System.out.println("Customer id:1 " + findCust.toString());
		};

	}

	@Bean
	public ModelMapper getModelMapper() {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setPreferNestedProperties(true);
		return new ModelMapper();
	}

}
