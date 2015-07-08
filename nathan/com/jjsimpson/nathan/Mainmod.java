package com.jjsimpson.nathan;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import com.jjsimpson.nathan.example3.BiggerTnT;


@Mod(modid=Mainmod.MODID, version=Mainmod.VERSION)
public class Mainmod {
	public static final String MODID = "THE NATHANATER";
	public static final String VERSION = "1.0";
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		//MinecraftForge.EVENT_BUS.register(new BlockBreakMessage());
		//MinecraftForge.EVENT_BUS.register(new MinecartExplosion());
		MinecraftForge.EVENT_BUS.register(new BiggerTnT());
	}	
	
	
}
