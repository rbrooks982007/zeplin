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
import org.zeplin.repository.impl.InvoiceRepositoryImpl;

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
public class InvoiceResourceTest {

    private MockMvc mvc;

    @Autowired
    InvoiceRepositoryImpl invoiceRepository;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new InvoiceResource(invoiceRepository)).build();
    }

    @Test
    public void shouldFindAllInvoices() throws Exception {
        mvc.perform(get("/invoices").accept(MediaType.APPLICATION_JSON))
           .andExpect(status().isOk())
           .andExpect(jsonPath("$").isArray())
           .andExpect(jsonPath("$", hasSize(4)))
           .andExpect(jsonPath("$[3].customerId").value("Geico-WXCD"));
    }

    @Test
    public void shouldSearchForInvoicesByCustomer() throws Exception {
        mvc.perform(get("/invoices/search?customerId=Geico-WXCD").accept(MediaType.APPLICATION_JSON))
           .andExpect(status().isOk())
           .andExpect(jsonPath("$").isArray())
           .andExpect(jsonPath("$", hasSize(4)))
           .andExpect(jsonPath("$[0].customerId").value("Geico-WXCD"));
    }

    @Test
    public void shouldSearchForInvoicesByCustomerAndContract() throws Exception {
        mvc.perform(get("/invoices/search?customerId=Geico-WXCD&contractId=%23HB-134")
                            .accept(MediaType.APPLICATION_JSON))
           .andExpect(status().isOk())
           .andExpect(jsonPath("$").isArray())
           .andExpect(jsonPath("$", hasSize(2)))
           .andExpect(jsonPath("$[0].customerId").value("Geico-WXCD"))
           .andExpect(jsonPath("$[0].contractId").value("#HB-134"))
           .andExpect(jsonPath("$[1].customerId").value("Geico-WXCD"))
           .andExpect(jsonPath("$[1].contractId").value("#HB-134"));
    }
}
