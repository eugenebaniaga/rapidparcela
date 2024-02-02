package com.stringnull.rapidparcela;

import com.stringnull.rapidparcela.models.Customer;
import com.stringnull.rapidparcela.models.Shipping;
import com.stringnull.rapidparcela.models.ShippingDetails;
import com.stringnull.rapidparcela.models.ShippingStatus;
import com.stringnull.rapidparcela.models.embeddables.Location;
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
import java.time.LocalDateTime;
import java.util.Date;
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

			//shipping status
			ShippingStatus shippingStatus = new ShippingStatus();
			shippingStatus.setStatus("Outbound for Deliver");
			shippingStatus.setCreatedAt(LocalDateTime.now());
			Location current = new Location();
			current.setLatitude(25.2084);
			current.setLongitude(55.2719);
			shippingStatus.setCurrent(current);
			shippingStatus.setDestination(current);

			ShippingDetails shippingDetails = new ShippingDetails();
			shippingDetails.setAmount(BigDecimal.valueOf(1500));
			shippingDetails.setItemDetails("military supply");
			shippingDetails.setQuantity(2);
			shippingDetails.setItemName("Supply");

			//add shipping...
			Shipping shipping = new Shipping();
			shipping.setAmount(BigDecimal.valueOf(1500.00));
			shipping.setReferenceNumber("11113433");
			shipping.setCustomer(savedCustomer);
			shipping.setDeliveryPersonel(null);
			shipping.setShippingDetails(shippingDetails);
			shipping.setShippingStatus(shippingStatus);
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
