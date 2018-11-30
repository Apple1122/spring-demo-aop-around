package aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import aopdemo.service.TrafficFortuneService;

public class AroundWithLoggerDemoApp {

	// Why you should write ClassName.class.getName() and declare as static variable?
	// ANS: getClass().getName() would not work since the main method it static 
	// because static variable don't belong to any class
	private static Logger myLogger = Logger.getLogger(AroundWithLoggerDemoApp.class.getName()); 
	
	public static void main(String[] args) {
	
		// read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		myLogger.info("Main Program: AroundDemoApp");	
		
		myLogger.info("Calling getFortune");
		
		boolean tripWire = true;
		
		String data = theFortuneService.getFortune(tripWire);
		
		myLogger.info("\nMy fortune is: " + data);
		
		myLogger.info("Finished");
		
		// close the context
		context.close();
		
	}

}
