package com.thecsdev.examplemod;

import org.jetbrains.annotations.ApiStatus.Internal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fabricmc.loader.api.FabricLoader;

//Tip: Use your IDE's refactoring tools to rename the Class
public class ExampleMod extends Object
{
	// ==================================================
	private static @Internal ExampleMod INSTANCE; // <-- Do not touch this! It auto-assigns.
	// --------------------------------------------------
	public  static final Logger LOGGER   = LoggerFactory.getLogger(getModID());
	private static final String MOD_NAME = FabricLoader.getInstance().getModContainer(getModID()).get().getMetadata().getName();
	// --------------------------------------------------
	private static final String MOD_ID = "examplemod"; //TODO - Assign mod ID here!
	// ==================================================
	public ExampleMod()
	{
		//validate instance first
		if(isModInitialized())
			throw new IllegalStateException(getModID() + " has already been initialized.");
		else if(!isInstanceValid(this))
			throw new UnsupportedOperationException("Invalid '" + getModID() + "' type: " + this.getClass().getName());
		
		//assign instance, and log the initialization
		INSTANCE = this;
		LOGGER.info("Initializing '" + getModName() + "' as '" + getClass().getSimpleName() + "'.");
		
		//initialize the mod
		onInitializeMod();
	}
	// --------------------------------------------------
	private final void onInitializeMod()
	{
		//TODO - Initialize common stuff here (client/dedicated-server/internal-server)
	}
	// ==================================================
	public static final ExampleMod getInstance() { return INSTANCE; }
	// --------------------------------------------------
	public static final String getModName() { return MOD_NAME; }
	public static final String getModID() { return MOD_ID; }
	// --------------------------------------------------
	public static final boolean isModInitialized() { return isInstanceValid(INSTANCE); }
	private static final boolean isInstanceValid(ExampleMod instance) { return isServer(instance) || isClient(instance); }
	// --------------------------------------------------
	public static final boolean isServer() { return isServer(INSTANCE); }
	public static final boolean isClient() { return isClient(INSTANCE); }
	//
	private static final boolean isServer(ExampleMod arg0) { return arg0 instanceof com.thecsdev.examplemod.server.ExampleModServer; }
	private static final boolean isClient(ExampleMod arg0) { return arg0 instanceof com.thecsdev.examplemod.client.ExampleModClient; }
	// ==================================================
}