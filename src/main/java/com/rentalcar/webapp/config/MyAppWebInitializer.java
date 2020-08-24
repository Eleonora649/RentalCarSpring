package com.rentalcar.webapp.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyAppWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { WebApplicationContextConfig.class }; //specifica la classe di configurazione
	}

	@Override
	protected Class<?>[] getServletConfigClasses() 
	{ 
		return null;
	}

	@Override
	protected String[] getServletMappings() 
	{
		return new String[] {"/"}; //qualsiasi chiamata verr� eseguita al nostro webServer verr� gestita dal dispatcher servlet
	}

}
