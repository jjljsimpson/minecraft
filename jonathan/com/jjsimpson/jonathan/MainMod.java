package com.jjsimpson.jonathan;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import com.jjsimpson.jonathan.example3.BiggerTnT;


@Mod(modid=MainMod.MODID, version=MainMod.VERSION)
public class MainMod {
	public static final String MODID = "90856";
	public static final String VERSION = "1.0";
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		//MinecraftForge.EVENT_BUS.register(new BlockBreakMessage());
		//MinecraftForge.EVENT_BUS.register(new MinecartExplosion());
		MinecraftForge.EVENT_BUS.register(new BiggerTnT());
		
	}
	
	
}
