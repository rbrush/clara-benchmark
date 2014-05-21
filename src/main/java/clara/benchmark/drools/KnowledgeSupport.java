package clara.benchmark.drools;

import org.kie.api.KieBase;
import org.kie.api.io.ResourceType;
import org.kie.internal.KnowledgeBase;
import org.kie.internal.KnowledgeBaseFactory;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderError;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.definition.KnowledgePackage;
import org.kie.internal.io.ResourceFactory;

import java.util.Collection;

@SuppressWarnings("deprecation")
public class KnowledgeSupport {

    @SuppressWarnings("deprecation")
    static KieBase load(String resource) {

        // Use of deprecated classes is pulled from example code at
        // https://github.com/droolsjbpm/drools/blob/master/drools-examples/src/main/java/org/drools/tutorials/banking/RuleRunner.java
        // Should replace once documentation or an update example exists showing the correct pattern.
        KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();


        kbuilder.add(ResourceFactory.newClassPathResource(resource, KnowledgeSupport.class),
                ResourceType.DRL);

        if (kbuilder.hasErrors()) {

            for (KnowledgeBuilderError error: kbuilder.getErrors()) {
                System.out.print(error.getMessage());
            }

            throw new IllegalStateException("Knowledge base " + resource + " had errors.");
        }


        Collection<KnowledgePackage> pkgs = kbuilder.getKnowledgePackages();
        kbase.addKnowledgePackages( pkgs );

        return kbase;
    }

}
