package com.rentalcar.webapp.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() 
	{ //specifica la classe più importante della nostra applicazione che è la classe di configurazione
		return new Class[] 
		{
			WebApplicationContextConfig.class
		};
	}

	@Override
	protected String[] getServletMappings() 
	{
		return new String[] {"/"}; //qualsiasi chiamata verrà eseguita al nostro webServer verrà gestita dal dispatcher servlet
	}

}
