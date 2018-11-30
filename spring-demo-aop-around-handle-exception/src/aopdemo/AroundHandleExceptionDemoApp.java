package aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import aopdemo.service.TrafficFortuneService;

public class AroundHandleExceptionDemoApp {

	// Why you should write ClassName.class.getName() and declare as static variable?
	// ANS: getClass().getName() would not work since the main method it static 
	// because static variable don't belong to any class
	private static Logger myLogger = Logger.getLogger(AroundHandleExceptionDemoApp.class.getName()); 
	
	public static void main(String[] args) {
	
		// read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		myLogger.info("Main Program: AroundDemoApp");	
		
		myLogger.info("Calling getFortune");
		
		String data = theFortuneService.getFortune();
		
		myLogger.info("\nMy fortune is: " + data);
		
		myLogger.info("Finished");
		
		// close the context
		context.close();
		
	}

}
