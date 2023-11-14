package org.drools.examples.test;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class DroolsExample {

    public static void main(String[] args) {
        // Create a KieServices instance
        KieServices kieServices = KieServices.Factory.get();

        if (kieServices == null) {
            System.err.println("KieServices is null. Check your Drools setup.");
            return;
        }

        // Get the KieContainer based on the kmodule.xml configuration
        KieContainer kieContainer = kieServices.getKieClasspathContainer();

        // Create a KieSession from the "myKieSession" defined in kmodule.xml
        KieSession kieSession = kieContainer.newKieSession("myKieSession");

        System.out.println("KieSession status: " + (kieSession != null ? "Created" : "Null"));


        // Insert facts or objects into the session (for this example, assume a Customer class with age)
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
}
