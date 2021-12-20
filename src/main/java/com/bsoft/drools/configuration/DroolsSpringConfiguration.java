package com.bsoft.drools.configuration;

import org.kie.api.KieServices;
import org.kie.api.io.Resource;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.runtime.KieContainer;
import org.kie.internal.io.ResourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DroolsSpringConfiguration {

	private static final String RULES_ORDER_DISCOUNT_XLS = "rules/discount.xls";
    private final KieServices kieServices = KieServices.Factory.get();


    @Bean
    public KieContainer getKieContainer() {
        /*
        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
        kieFileSystem.write(ResourceFactory.newClassPathResource("rules/discount.xls"));
        */

        Resource dt = ResourceFactory.newClassPathResource(RULES_ORDER_DISCOUNT_XLS, getClass());
		KieFileSystem kieFileSystem = kieServices.newKieFileSystem().write(dt);
        KieBuilder kb = kieServices.newKieBuilder(kieFileSystem);
        kb.buildAll();
        KieModule kieModule = kb.getKieModule();
        return kieServices.newKieContainer(kieModule.getReleaseId());

    }

}
