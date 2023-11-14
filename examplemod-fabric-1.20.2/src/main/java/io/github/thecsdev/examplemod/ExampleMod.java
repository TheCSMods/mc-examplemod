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
	private static ExampleMod Instance;
	// --------------------------------------------------
	//protected final ModContainer modInfo; - avoid platform-specific APIs
	// ==================================================
	public ExampleMod()
	{
		//validate instance first
		if(isModInitialized())
			throw new IllegalStateException(getModID() + " has already been initialized.");
		else if(!isInstanceValid(this))
			throw new UnsupportedOperationException("Invalid " + getModID() + " type: " + this.getClass().getName());
		
		//assign instance
		Instance = this;
		//modInfo = FabricLoader.getInstance().getModContainer(getModID()).get();
		
		//log stuff
		/*LOGGER.info("Initializing '" + getModName() + "' " + modInfo.getMetadata().getVersion() +
				" as '" + getClass().getSimpleName() + "'.");*/
		LOGGER.info("Initializing '" + getModName() + "' as '" + getClass().getSimpleName() + "'.");
		
		//init stuff
		//TODO - Initialize common stuff here (client/dedicated-server/internal-server)
	}
	// ==================================================
	public static ExampleMod getInstance() { return Instance; }
	//public ModContainer getModInfo() { return modInfo; }
	// --------------------------------------------------
	public static String getModName() { return ModName; }
	public static String getModID() { return ModID; }
	// --------------------------------------------------
	public static boolean isModInitialized() { return isInstanceValid(Instance); }
	private static boolean isInstanceValid(ExampleMod instance) { return isServer(instance) || isClient(instance); }
	// --------------------------------------------------
	public static boolean isServer() { return isServer(Instance); }
	public static boolean isClient() { return isClient(Instance); }
	
	private static boolean isServer(ExampleMod arg0) { return arg0 instanceof io.github.thecsdev.examplemod.server.ExampleModServer; }
	private static boolean isClient(ExampleMod arg0) { return arg0 instanceof io.github.thecsdev.examplemod.client.ExampleModClient; }
	// ==================================================
}