package com.jjsimpson.john.mod.examples;

import java.util.Random;

import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ZombieKnight
{
	protected static final int WEAPON = 0;
	protected static final int CHESTPLATE = 1;
	protected static final int LEGGINGS = 2;
	protected static final int BOOTS = 3;
	protected static final int HELMENT = 4;
	

	@SubscribeEvent
	protected void giveArmor(EntityJoinWorldEvent event)
	{
		//only for Zombie
		if( !(event.entity instanceof EntityZombie) ) {
			return;
		}
		
		EntityZombie zombie = (EntityZombie)event.entity;
		Random random = new Random();
		int perc = random.nextInt(100);
		
		//40% regular
		if(perc < 40)
		{
			return;
		}
		else if(perc < 60)
		{
			//20% grunt
			promoteGrunt(zombie);
		}
		else if(perc < 72)
		{
			//12% scout
			promoteScout(zombie);
		}
		else if(perc < 84)
		{
			//12% archer
			promoteArcherer(zombie);
		}
		else if(perc < 94)
		{
			//10% knight
			promoteKnight(zombie);
		}
		else
		{
			//6% general
			promoteGeneral(zombie);
		}
	}
	
	
	protected void promoteGeneral(EntityZombie zombie)
	{
		zombie.setCurrentItemOrArmor(WEAPON, new ItemStack(Items.diamond_axe));
		zombie.setCurrentItemOrArmor(CHESTPLATE, new ItemStack(Items.diamond_chestplate));
		zombie.setCurrentItemOrArmor(LEGGINGS, new ItemStack(Items.diamond_leggings));
		zombie.setCurrentItemOrArmor(BOOTS, new ItemStack(Items.diamond_boots));
		zombie.setCurrentItemOrArmor(HELMENT, new ItemStack(Items.diamond_helmet));		
	}
	
	
	protected void promoteKnight(EntityZombie zombie)
	{
		zombie.setCurrentItemOrArmor(WEAPON, new ItemStack(Items.iron_axe));
		zombie.setCurrentItemOrArmor(CHESTPLATE, new ItemStack(Items.iron_chestplate));
		zombie.setCurrentItemOrArmor(LEGGINGS, new ItemStack(Items.iron_leggings));
		zombie.setCurrentItemOrArmor(BOOTS, new ItemStack(Items.iron_boots));
		zombie.setCurrentItemOrArmor(HELMENT, new ItemStack(Items.iron_helmet));				
	}
	
	
	protected void promoteArcherer(EntityZombie zombie)
	{
		zombie.setCurrentItemOrArmor(WEAPON, new ItemStack(Items.bow));
		zombie.setCurrentItemOrArmor(CHESTPLATE, new ItemStack(Items.chainmail_chestplate));
		zombie.setCurrentItemOrArmor(LEGGINGS, new ItemStack(Items.chainmail_leggings));
		zombie.setCurrentItemOrArmor(BOOTS, new ItemStack(Items.chainmail_boots));
		zombie.setCurrentItemOrArmor(HELMENT, new ItemStack(Items.chainmail_helmet));				
	}
	
	
	protected void promoteScout(EntityZombie zombie)
	{
		zombie.setCurrentItemOrArmor(WEAPON, new ItemStack(Items.wooden_sword));
		zombie.setCurrentItemOrArmor(LEGGINGS, new ItemStack(Items.leather_leggings));
		zombie.setCurrentItemOrArmor(BOOTS, new ItemStack(Items.leather_boots));
		zombie.setCurrentItemOrArmor(HELMENT, new ItemStack(Items.leather_helmet));				
	}
	
	protected void promoteGrunt(EntityZombie zombie)
	{
		zombie.setCurrentItemOrArmor(WEAPON, new ItemStack(Items.wooden_axe));
		zombie.setCurrentItemOrArmor(HELMENT, new ItemStack(Items.leather_helmet));				
	}
	
}
