package ch.keepcalm.web.controller;


import ch.keepcalm.web.model.Address;
import ch.keepcalm.web.model.Customer;
import ch.keepcalm.web.service.CustomerService;
import org.codehaus.jackson.map.ObjectMapper;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.hateoas.MediaTypes;
import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.halLinks;
import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.linkWithRel;
import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.links;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessRequest;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
@AutoConfigureRestDocs("target/generated-snippets")
public class CustomerControllerDocumentation {


    @Autowired
    private MockMvc mvc;

    @MockBean
    private CustomerService service;

    private ObjectMapper objectMapper;

    private RestDocumentationResultHandler document;

    @Before
    public void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    public void postCustomer() throws Exception {
       /* Application applicationRequest = new Application();
        applicationRequest.setType(Type.COMPANY_WITH_EMPLOYEES);

        Application applicationResponse = new Application();
        applicationResponse.setStatus(Status.NEW);
        applicationResponse.setType(Type.COMPANY_WITH_EMPLOYEES);
        applicationResponse.setSessionId(SESSION_ID);

        ApplicationResource applicationResourceRequest = new ApplicationResource();
        applicationResourceRequest.setType(Type.COMPANY_WITH_EMPLOYEES);

        given(this.service.createApplication(applicationRequest)).willReturn(applicationResponse);
        String applicationJson = objectMapper.writeValueAsString(applicationResourceRequest);
        mvc.perform(post("/api/application").contentType(MediaTypes.HAL_JSON).content(applicationJson))
                .andExpect(status().isCreated()).andDo(document("{method-name}", links(
                linkWithRel("self").description(ApplicationController.DESCRIPTION),
                linkWithRel("api").description(ApiController.DESCRIPTION))));*/

        Address address = Address.newAddress()
                .locality("Gockhausen")
                .municipality("Dübendorf")
                .municipalityNr("191")
                .postalCode("8044")
                .postalCodeAddition("00")
                .build();

        Customer customer = Customer.newBuilder()
                .id(1)
                .gender("m")
                .dateOfBirth(new DateTime(1975, 9, 27, 0, 0, 0, 0).toDateTime().toDate())
                .address(address)
                .build();

        given(this.service.createCustomer(customer)).willReturn(customer);


        // documentation call
        this.mvc.perform(
                post("/api/customers")
                        .contentType(MediaTypes.HAL_JSON)
                        .content(this.objectMapper.writeValueAsString(customer))
        ).andExpect(status().isCreated())
                .andDo(document("post-customer",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                        links(halLinks(),
                                linkWithRel("self").description("Link to the customer resource"),
                                linkWithRel("list_products").description("Link to the list the product from the customer resource"),
                                linkWithRel("create_product").description("Link to the create a product for the customer resource"),
                                linkWithRel("create_deeplink").description("Link to the create a deeplink for the customer resource")
                        )
                ));
    }


}