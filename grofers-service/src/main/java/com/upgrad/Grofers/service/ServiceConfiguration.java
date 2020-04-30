package com.upgrad.Grofers.service;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Enabling the component scan and entity scan of classes in the below mentioned "com.upgrad.Grofers.service" and "com.upgrad.Grofers.service.entity" packages respectively.
 */
@Configuration
@ComponentScan("com.upgrad.Grofers.service")
@EntityScan("com.upgrad.Grofers.service.entity")
public class ServiceConfiguration {
}
