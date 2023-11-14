package io.github.thecsdev.examplemod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.DedicatedServerModInitializer;

/**
 * Fabric Mod Loader entry-points for this mod.
 */
public final class ExampleModFabric implements ClientModInitializer, DedicatedServerModInitializer
{
	// ==================================================
	public @Override void onInitializeClient() { new io.github.thecsdev.examplemod.client.ExampleModClient(); }
	public @Override void onInitializeServer() { new io.github.thecsdev.examplemod.server.ExampleModServer(); }
	// ==================================================
}