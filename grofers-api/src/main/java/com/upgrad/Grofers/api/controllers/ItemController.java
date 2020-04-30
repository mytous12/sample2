package com.upgrad.Grofers.api.controllers;


import com.upgrad.Grofers.service.business.ItemService;
import com.upgrad.Grofers.service.business.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//RestController annotation specifies that this class represents a REST API(equivalent of @Controller + @ResponseBody)
@RestController
//"@CrossOrigin” annotation enables cross-origin requests for all methods in that specific controller class.
@CrossOrigin
@RequestMapping("/")
public class ItemController {

    //Required services are autowired to enable access to methods defined in respective Business services
    @Autowired
    private ItemService itemService;

    //Required services are autowired to enable access to methods defined in respective Business services
    @Autowired
    private StoreService storeService;


    }


