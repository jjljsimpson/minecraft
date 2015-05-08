package com.jjsimpson.john.mod;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import com.jjsimpson.john.mod.examples.BlockBreakMessage;


@Mod(modid = MainMod.MODID, version = MainMod.VERSION)
public class MainMod
{
	public static final String MODID = "johnMods";
	public static final String VERSION = "1.0";
	
	public MainMod()
	{
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		//Block Break Example 1
		//MinecraftForge.EVENT_BUS.register(new BlockBreakMessage());
		
		//Exploding Minecart Example 2
		//MinecraftForge.EVENT_BUS.register(new MinecartExplosion());
		
		//Bigger Explosion Example 3
		//MinecraftForge.EVENT_BUS.register(new BiggerTntNoFuse());
	}
}
