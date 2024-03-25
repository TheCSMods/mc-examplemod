package io.github.thecsdev.examplemod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleMod extends Object
{
	// ==================================================
	public static final Logger LOGGER = LoggerFactory.getLogger(getModID());
	// --------------------------------------------------
	static final String ModName = "Example Mod";
	static final String ModID = "examplemod";
	// --------------------------------------------------
	private static ExampleMod INSTANCE; //do not touch
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
		
		//init stuff
		//TODO - Initialize common stuff here (dedicated-server/internal-server)
	}
	// ==================================================
	public static ExampleMod getInstance() { return INSTANCE; }
	// --------------------------------------------------
	public static String getModName() { return ModName; }
	public static String getModID() { return ModID; }
	// --------------------------------------------------
	public static boolean isModInitialized() { return isInstanceValid(INSTANCE); }
	private static boolean isInstanceValid(ExampleMod instance) { return isServer(instance) || isClient(instance); }
	// --------------------------------------------------
	public static boolean isServer() { return isServer(INSTANCE); }
	public static boolean isClient() { return isClient(INSTANCE); }
	//
	private static boolean isServer(ExampleMod arg0) { return arg0 instanceof io.github.thecsdev.examplemod.server.ExampleModServer; }
	private static boolean isClient(ExampleMod arg0) { return arg0 instanceof io.github.thecsdev.examplemod.client.ExampleModClient; }
	// ==================================================
}