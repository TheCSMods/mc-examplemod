package com.thecsdev.examplemod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.DedicatedServerModInitializer;

/**
 * Fabric Mod Loader entry-points for this mod.
 * @apiNote Do not change anything in here. Leave it as-is.
 * @apiNote Do not under any circumstances put static initializers or variables in here!
 */
public final class ExampleModFabric implements ClientModInitializer, DedicatedServerModInitializer
{
	// ==================================================
	public @Override void onInitializeClient() { new com.thecsdev.examplemod.client.ExampleModClient(); }
	public @Override void onInitializeServer() { new com.thecsdev.examplemod.server.ExampleModServer(); }
	// ==================================================
}