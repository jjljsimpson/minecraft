package com.jjsimpson.john.mod.examples.lesson1;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BlockBreakMessage
{
	public BlockBreakMessage()
	{
		
	}
	
	@SubscribeEvent
	public void SendMessage(BreakEvent event)
	{
		//Get the player for this event
		EntityPlayer player = event.getPlayer();
		
		//Create Chat Text
		ChatComponentText txt = new ChatComponentText(EnumChatFormatting.GOLD + "You Broke A Block");
		
		//Send text to player
		player.addChatComponentMessage(txt);
	}
	
	
}
