package me.jdragon.atddtest.chapter01;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import me.jdragon.atddtest.domain.Customer;
import me.jdragon.atddtest.domain.CustomerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
public class CustomerRepositoryTest {

  @Autowired
  CustomerRepository customerRepository;

  @Test
  public void testCustomerRepository(){
    Customer customer = Customer.builder().name("크리스").phone("010-1224-1225").build();
    customerRepository.save(customer);

    List<Customer> customerList = customerRepository.findAll();

    Customer chris = customerList.get(0);
    assertThat(chris.getName()).isEqualTo("크리스");
    assertThat(chris.getPhone()).isEqualTo("010-1224-1225");
  }

  @AfterEach
  public void deleteAll() {
    customerRepository.deleteAll();
  }

}
