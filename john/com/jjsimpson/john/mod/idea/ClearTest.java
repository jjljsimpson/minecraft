package com.jjsimpson.john.mod.idea;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import com.jjsimpson.john.mod.structures.StoneFort;

public class ClearTest
{
	@SubscribeEvent
	public void SendMessage(BreakEvent event)
	{		
		//only works if hitting a lapiz stone
		Block block = event.state.getBlock();
		if(block != Blocks.lapis_block)
		{
			return;
		}
		
		//Get the player for this event
		EntityPlayer player = event.getPlayer();
		
		//Only works if holding a wooden pick axe
		ItemStack item = player.getHeldItem();
		if(item == null || item.getItem() != Items.wooden_pickaxe)
		{
			return;
		}
		
		//Create Fort
		StoneFort fort = new StoneFort(event.world, event.pos.add(0, 0, 0), true);
		fort.build();

		//Create Chat Text
		ChatComponentText txt = new ChatComponentText(EnumChatFormatting.GOLD + "Creating Fort");
		player.addChatMessage(txt);
	}
}
