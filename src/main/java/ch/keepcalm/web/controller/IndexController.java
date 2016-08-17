package ch.keepcalm.web.controller;


import org.springframework.hateoas.ResourceSupport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * Created by marcelwidmer on 20/03/16.
 */
@RestController
@RequestMapping(value = "/api", produces = "application/hal+json")
public class IndexController {

    @RequestMapping(method= RequestMethod.GET)
    public ResourceSupport index() throws Exception {
        ResourceSupport index = new ResourceSupport();
        index.add(linkTo(CustomerController.class).withRel("createCustomers"));
        index.add(linkTo(IndexController.class).withSelfRel());
        return index;
    }
}
