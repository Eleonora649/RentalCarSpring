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
	{ //specifica la classe pi� importante della nostra applicazione che � la classe di configurazione
		return new Class[] 
		{
			WebApplicationContextConfig.class
		};
	}

	@Override
	protected String[] getServletMappings() 
	{
		return new String[] {"/"}; //qualsiasi chiamata verr� eseguita al nostro webServer verr� gestita dal dispatcher servlet
	}

}
