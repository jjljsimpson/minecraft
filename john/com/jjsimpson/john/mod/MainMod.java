package com.jjsimpson.john.mod;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import com.jjsimpson.john.mod.idea.ClearTest;


@Mod(modid = MainMod.MODID, version = MainMod.VERSION)
public class MainMod
{
	public static final String MODID = "johnMods";
	public static final String VERSION = "1.0";
	
	public MainMod()
	{
		
	}
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
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
		
		//PigDiamond
		//MinecraftForge.EVENT_BUS.register(new PigDiamond());
		
		//ZombieKnight
		//MinecraftForge.EVENT_BUS.register(new ZombieKnight());
		
		//My Test
		//MinecraftForge.EVENT_BUS.register(new ClearTest());
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		
	}
	
}
