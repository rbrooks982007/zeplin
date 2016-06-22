package org.zeplin.resources;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.zeplin.Application;
import org.zeplin.repository.impl.CustomerRepositoryImpl;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by rbrooks3 on 6/21/16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class, MockServletContext.class})
@WebAppConfiguration
public class CustomerResourceTest {

    private MockMvc mvc;

    @Autowired
    CustomerRepositoryImpl customerRepository;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new CustomerResource(customerRepository)).build();
    }

    @Test
    public void shouldFindAllContractForCustomer() throws Exception {
        mvc.perform(get("/customers").accept(MediaType.APPLICATION_JSON))
           .andExpect(status().isOk())
           .andExpect(jsonPath("$").isArray())
           .andExpect(jsonPath("$[0].contractId").value("#HB-134"))
           .andExpect(jsonPath("$[0].cost").value(4035.00d))
           .andExpect(jsonPath("$[0].services").isArray())
           .andExpect(jsonPath("$[0].services", hasSize(1)))
           .andExpect(jsonPath("$[0].services[0].contractId").value("#WT-239"))
           .andExpect(jsonPath("$[0].services[0].serviceAgreement.contractId").value("#SA-432"))
           .andExpect(jsonPath("$[0].services[0].serviceAgreement.maxHours").value(160))
           .andExpect(jsonPath("$[0].services[0].serviceAgreement.cost").value(125.00d));
    }

}
