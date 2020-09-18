package org.killer.springdroolsdemo;

import lombok.extern.slf4j.Slf4j;
import org.drools.core.impl.InternalKnowledgeBase;
import org.drools.core.impl.KnowledgeBaseFactory;
import org.drools.core.io.impl.ClassPathResource;
import org.kie.api.KieServices;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.killer.springdroolsdemo.modules.test.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
//@SpringBootApplication
public class SpringDroolsDemoApplication {

//	public static void main(String[] args) {
//		SpringApplication.run(SpringDroolsDemoApplication.class, args);
//	}

	public static void main(String[] args) {
		manualConfig();

		xmlConfig();
	}

	/**相当于提供的javaapi 用来构造配置， 但同时应该也是提供了读取资源配置的功能*/
	public static void manualConfig() {
		KnowledgeBuilder knowledgeBuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
		knowledgeBuilder.add(new ClassPathResource("META-INF/drools.rules/test.drl"), ResourceType.DRL);

		if(knowledgeBuilder.hasErrors()) {
			log.error("error message: {}", "配置文件错误");
			return;
		}

		// 这是一个好的变量过长的命名方式
		InternalKnowledgeBase kBase = KnowledgeBaseFactory.newKnowledgeBase();
		kBase.addPackages(knowledgeBuilder.getKnowledgePackages());

		StatelessKieSession kSession = kBase.newStatelessKieSession();
		User user = new User().setAge(25).setSalary(8000f);
		kSession.execute(user);

		System.out.println(user);
	}

	public static void xmlConfig() {
		KieServices kieServices = KieServices.get();
		KieContainer kieContainer = kieServices.getKieClasspathContainer();

		StatelessKieSession statelessKieSession = kieContainer.newStatelessKieSession();
		User user = new User().setAge(25).setSalary(8000f);
		statelessKieSession.execute(user);
	}

}
