package org.drools.examples.test;

import org.kie.api.KieServices;
import org.kie.api.definition.type.FactType;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.builder.DecisionTableConfiguration;
import org.kie.internal.builder.DecisionTableInputType;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.io.ResourceFactory;

public class ExcelDecisionTableExample {

    public static void main(String[] args) {
        // Create a KieServices instance
        KieServices kieServices = KieServices.Factory.get();

        // Create a KieContainer from the classpath (assuming rules are in the resources folder)
        KieContainer kieContainer = kieServices.getKieClasspathContainer();

        // Create a KieSession
        KieSession kieSession = kieContainer.newKieSession();

        // Load decision table from Excel file
        loadDecisionTable(kieServices, kieContainer, "discount_rules.xlsx");

        // Insert facts or objects into the session
        Customer customer = new Customer();
        customer.setAge(18);
        kieSession.insert(customer);

        // Fire the rules
        kieSession.fireAllRules();

        // Print the result
        System.out.println("Discount for the customer: " + customer.getDiscount() + "%");

        // Dispose the session
        kieSession.dispose();
    }

    private static void loadDecisionTable(KieServices kieServices, KieContainer kieContainer, String fileName) {
        // Configure Decision Table
        DecisionTableConfiguration dtConf = KnowledgeBuilderFactory.newDecisionTableConfiguration();
        dtConf.setInputType(DecisionTableInputType.XLS);

        // Create a KnowledgeBuilder
        KnowledgeBuilder knowledgeBuilder = kieServices.newKnowledgeBuilder();

        // Add the decision table resource to the KnowledgeBuilder
        knowledgeBuilder.add(ResourceFactory.newClassPathResource(fileName, ExcelDecisionTableExample.class), ResourceType.DTABLE, dtConf);

        // Check for errors during rule loading
        if (knowledgeBuilder.hasErrors()) {
            System.err.println("Error loading decision table: " + knowledgeBuilder.getErrors());
        }

        // Update the KieContainer to reflect changes
        kieContainer.updateToVersion(kieContainer.getReleaseId());
    }
}
