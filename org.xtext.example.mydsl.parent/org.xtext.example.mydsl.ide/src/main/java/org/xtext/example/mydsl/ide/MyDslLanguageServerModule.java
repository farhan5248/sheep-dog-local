package org.xtext.example.mydsl.ide;

import org.eclipse.xtext.ide.server.ServerModule;

/**
 * Custom Language Server Module for MyDsl.
 * This module extends Xtext's ServerModule to provide MyDsl-specific
 * language server configuration and services.
 */
public class MyDslLanguageServerModule extends ServerModule {
	
	/**
	 * This module inherits the default Xtext language server configuration.
	 * Override methods here to customize language server behavior:
	 * 
	 * - bindILanguageServerAccess() for custom language server access
	 * - bindIResourceServiceProvider() for custom resource services
	 * - bindIWorkspaceConfigFactory() for workspace configuration
	 * - etc.
	 */
	
	// Example of customization (commented out as we're using defaults for now):
	
	/*
	@Override
	public Class<? extends ILanguageServerAccess> bindILanguageServerAccess() {
		return MyDslLanguageServerAccess.class;
	}
	
	@Override
	public Class<? extends IWorkspaceConfigFactory> bindIWorkspaceConfigFactory() {
		return MyDslWorkspaceConfigFactory.class;
	}
	*/
}