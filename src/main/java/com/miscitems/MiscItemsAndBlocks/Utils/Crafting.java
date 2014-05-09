package com.miscitems.MiscItemsAndBlocks.Utils;

import com.miscitems.MiscItemsAndBlocks.Block.ModBlocks;
import com.miscitems.MiscItemsAndBlocks.Items.ModItems;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.oredict.ShapedOreRecipe;

import java.util.ArrayList;
import java.util.HashMap;

public class Crafting {



    public static ArrayList<String> Recipes = new ArrayList<String>();
	
	public static void RegisterRecipes(){




        MiscItemsApi.Recipes.SqueezerRecipes.instance().AddRecipe(new ItemStack(Items.glass_bottle), new ItemStack(Items.apple), new ItemStack(ModItems.Liquid, 1, 0));
        MiscItemsApi.Recipes.SqueezerRecipes.instance().AddRecipe(new ItemStack(Items.bucket), new ItemStack(ModItems.Tomato), new ItemStack(ModItems.Liquid, 1, 1));
        MiscItemsApi.Recipes.SqueezerRecipes.instance().AddRecipe(new ItemStack(Items.glass_bottle), new ItemStack(ModItems.Orange), new ItemStack(ModItems.Liquid, 1, 2));
        MiscItemsApi.Recipes.SqueezerRecipes.instance().AddRecipe(new ItemStack(Items.glass_bottle), new ItemStack(Items.carrot), new ItemStack(ModItems.Liquid, 1, 3));

        MiscItemsApi.Recipes.MillRecipes.instance().AddRecipe(new ItemStack(Items.wheat), new ItemStack(ModItems.Flour));
        MiscItemsApi.Recipes.MillRecipes.instance().AddRecipe(new ItemStack(Items.rotten_flesh), new ItemStack(Items.leather));

        MiscItemsApi.Recipes.MetalPressRecipes.instance().AddRecipeMode_1(new ItemStack(Items.iron_ingot), new ItemStack(ModItems.IronPlate, 1, 0));

        MiscItemsApi.Recipes.MetalPressRecipes.instance().AddRecipeMode_4(new ItemStack(Items.iron_ingot),new ItemStack(Items.iron_ingot),new ItemStack(Items.iron_ingot),new ItemStack(Items.iron_ingot), new ItemStack(ModItems.IronPlate, 1, 2));
		
		    AddShapelessRecipe(new ItemStack(ModItems.PaintBrush, 1, 1), new Object[]{new ItemStack(ModItems.PaintBrush, 1, 0), new ItemStack(Items.dye, 1, 1)});
		    AddShapelessRecipe(new ItemStack(ModItems.PaintBrush, 1, 2), new Object[]{new ItemStack(ModItems.PaintBrush, 1, 0), new ItemStack(Items.dye, 1, 2)});
		    AddShapelessRecipe(new ItemStack(ModItems.PaintBrush, 1, 3), new Object[]{new ItemStack(ModItems.PaintBrush, 1, 0), new ItemStack(Items.dye, 1, 4)});
		    AddShapelessRecipe(new ItemStack(ModItems.Cheese), Items.milk_bucket);
		    AddShapelessRecipe(new ItemStack(ModItems.TomatoSeeds, 4), ModItems.Tomato);
		    AddShapelessRecipe(new ItemStack(ModBlocks.DiceHolder, 1, 0), new Object[]{ModBlocks.ItemPedestal, ModBlocks.Dice});
		    AddShapelessRecipe(new ItemStack(ModItems.SilverNugget, 9), ModItems.SilverIngot);
            AddShapelessRecipe(new ItemStack(ModBlocks.OrangePlanks, 4), ModBlocks.OrangeLog);
            AddShapelessRecipe(new ItemStack(ModItems.Cardboard, 2), new Object[]{Items.paper, Items.paper, Items.paper});
		    AddShapelessRecipe(new ItemStack(ModItems.SilverIngot, 9), new Object[]{ModBlocks.SilverBlock});
            AddShapelessRecipe(new ItemStack(ModBlocks.GamePart, 1, 1), new Object[]{new ItemStack(Items.dye, 1, 1), ModBlocks.GamePart});
            AddShapelessRecipe(new ItemStack(ModBlocks.GamePart, 1, 2), new Object[]{new ItemStack(Items.dye, 1, 4), ModBlocks.GamePart});
            AddShapelessRecipe(new ItemStack(ModBlocks.GamePart, 1, 3), new Object[]{new ItemStack(Items.dye, 1, 2), ModBlocks.GamePart});
            AddShapelessRecipe(new ItemStack(ModBlocks.GamePart, 1, 4), new Object[]{new ItemStack(Items.dye, 1, 11), ModBlocks.GamePart});
            AddShapelessRecipe(new ItemStack(ModItems.PizzaRaw), ModItems.Cheese, ModItems.PizzaBottom, new ItemStack(ModItems.Liquid, 1, 1), Items.cooked_fished);
            AddShapelessRecipe(new ItemStack(ModItems.PizzaRaw, 1, 1), ModItems.Cheese, ModItems.PizzaBottom, new ItemStack(ModItems.Liquid, 1, 1), Items.cooked_porkchop);
            AddShapelessRecipe(new ItemStack(ModItems.PizzaRaw, 1, 2), ModItems.Cheese, ModItems.PizzaBottom, new ItemStack(ModItems.Liquid, 1, 1), Items.cooked_beef);
            AddShapelessRecipe(new ItemStack(ModItems.PizzaRaw, 1, 3), ModItems.Cheese, ModItems.PizzaBottom, new ItemStack(ModItems.Liquid, 1, 1), Items.cooked_chicken);
            AddShapelessRecipe(new ItemStack(ModBlocks.LensBench), ModItems.Lens, ModBlocks.CraftingInv);
            AddShapelessRecipe(new ItemStack(ModItems.BigBattery, 1, 32), new Object[]{new ItemStack(ModItems.Battery, 1, 16), new ItemStack(ModItems.Circuit, 1, 1), new ItemStack(ModItems.Battery, 1, 16),});
            AddShapelessRecipe(new ItemStack(ModItems.BigBattery, 1, 0), new Object[]{new ItemStack(ModItems.Battery, 1, 0), new ItemStack(ModItems.Circuit, 1, 1), new ItemStack(ModItems.Battery, 1, 0)});
            AddShapelessRecipe(new ItemStack(ModItems.AdvancedBattery, 1, 64), new Object[]{new ItemStack(ModItems.BigBattery, 1, 32), new ItemStack(ModItems.Circuit, 1, 1), new ItemStack(ModItems.BigBattery, 1, 32)});
            AddShapelessRecipe(new ItemStack(ModItems.AdvancedBattery, 1, 0), new Object[]{new ItemStack(ModItems.BigBattery, 1, 0), new ItemStack(ModItems.Circuit, 1, 1), new ItemStack(ModItems.BigBattery, 1, 0)});

            GameRegistry.addRecipe(new ShapedOreRecipe(ModBlocks.CraftingInv, new Object[] {"WWW", "PIP", "PCP", 'W', Blocks.wool, Character.valueOf('P'), "plankWood", 'C', Blocks.chest, 'I', Blocks.crafting_table}));
		    GameRegistry.addRecipe(new ShapedOreRecipe(ModBlocks.Dice, new Object[]{"PPP", "PDP", "PPP", Character.valueOf('P'), "plankWood", 'D', Items.dye}));
		    GameRegistry.addRecipe(new ShapedOreRecipe(ModBlocks.Table, new Object[]{"CCC", "HHH", "P P", 'C', new ItemStack(Blocks.carpet, 1, 14), Character.valueOf('P'), "plankWood", Character.valueOf('H'), "slabWood"}));	
		    GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.Turbine, new Object[]{"S S", " P ", "S S", 'S', Items.stick, Character.valueOf('P'), "plankWood"}));
		    
            AddRecipe(new ItemStack(ModItems.GuideBook), true, new Object[]{"BP", "SP", 'B', Items.book, 'P', Items.paper, 'S', Items.string});
		    AddRecipe(new ItemStack(ModItems.DataChip, 2),  true,new Object[]{"CCC", "CGC", "III", 'C', ModItems.Cardboard, 'G', new ItemStack(ModItems.Circuit, 1, 0), 'I', Items.iron_ingot});
	     	AddRecipe(new ItemStack(ModBlocks.Teleporter), true, new Object[]{"HCH", "BEB", "HCH", 'H', new ItemStack(ModItems.IronPlate, 1, 2), 'C', new ItemStack(ModItems.Circuit, 1, 1), 'B', new ItemStack(ModItems.AdvancedBattery, 1, 0), 'E', Items.ender_pearl});
		    AddRecipe(new ItemStack(ModBlocks.WireLessRedstone, 2), true, new Object[]{"IEI", "ERE", "ICI", 'I', new ItemStack(ModItems.IronPlate, 1, 0), 'E', Items.ender_pearl, 'R', Blocks.redstone_block, 'C', new ItemStack(ModItems.Circuit, 1, 1)});
		    AddRecipe(new ItemStack(ModBlocks.WirelessItemTrans, 2),  true,new Object[]{"POP", "CEC", "POP", 'P', new ItemStack(ModItems.IronPlate, 1, 2), 'O', Blocks.obsidian, 'C', new ItemStack(ModItems.Circuit, 1, 1), 'E', Items.ender_pearl});
		    AddRecipe(new ItemStack(ModBlocks.MetalPress), true, new Object[]{"IPI", "CBC", "IAI", 'I', new ItemStack(ModItems.IronPlate, 1,0), 'P', Blocks.piston, 'C', new ItemStack(ModItems.Circuit), 'B', Blocks.iron_block, 'A', Blocks.anvil});
		    AddRecipe(new ItemStack(ModBlocks.SilverBlock), true, new Object[]{"SSS", "SSS", "SSS", 'S', ModItems.SilverIngot});
		    AddRecipe(new ItemStack(ModBlocks.Computer),  true,new Object[]{"IBI", "PCB", "IBT", 'I', Items.iron_ingot, 'B', Blocks.iron_block, 'P', Blocks.glass_pane, 'C', new ItemStack(ModItems.Circuit, 1, 1), 'R', Items.redstone, 'T', Blocks.redstone_block});
		    AddRecipe(new ItemStack(ModBlocks.StorageBlock), true, new Object[]{"ICI", "CBC", "ICI", 'I', Blocks.iron_block, 'C', Blocks.chest, 'B', ModBlocks.Box});
		    AddRecipe(new ItemStack(ModBlocks.OneWayGlass, 8), true, new Object[]{"SSS", "GES", "SSS", 'S', Blocks.stone, 'G', Blocks.glass, 'E', Items.ender_pearl});
		    AddRecipe(new ItemStack(ModItems.XpExtractor), true, new Object[] {" D ", "IGI", "IGI", 'I', Items.iron_ingot, 'G', Blocks.glass, 'D', Items.diamond});
			AddRecipe(new ItemStack(ModBlocks.XpStorage), true, new Object[] {"BIB", "IEI", "BIB", 'I', Blocks.obsidian, 'B', Blocks.iron_block, 'E', ModItems.XpExtractor});
	        AddRecipe(new ItemStack(ModItems.SilverIngot), true, new Object[] {"NNN", "NNN", "NNN", 'N', ModItems.SilverNugget});
			AddRecipe(new ItemStack(ModItems.SilverSword), true, new Object[] {" I ", " I ", " S ", 'I', ModItems.SilverIngot, 'S', Items.stick});
			AddRecipe(new ItemStack(ModItems.SilverBow), true, new Object[] {" IS", "I S", " IS", 'I', ModItems.SilverIngot, 'S', Items.string});
	        AddRecipe(new ItemStack(ModItems.SilverBow), true, new Object[] {"SI ", "S I", "SI ", 'I', ModItems.SilverIngot, 'S', Items.string});
	        AddRecipe(new ItemStack(ModItems.SilverArrow, 8), true, new Object[] {" N ", " S ", " F ", 'N', ModItems.SilverNugget, 'S', Items.stick, 'F', Items.feather});
			AddRecipe(new ItemStack(ModBlocks.StoneStair, 4), true, new Object[]{"S  ", "SS ", "SSS", 'S', Blocks.stone});
			AddRecipe(new ItemStack(ModBlocks.StoneStair, 4), true, new Object[]{"  S", " SS", "SSS", 'S', Blocks.stone});
	        AddRecipe(new ItemStack(ModBlocks.DisarmTrap),  true,new Object[] {"IHI", "HPH", "IDI", 'I', Items.iron_ingot, 'H', Blocks.hopper, 'P', Blocks.heavy_weighted_pressure_plate, 'D', Blocks.dispenser});
	        AddRecipe(new ItemStack(ModBlocks.Bin), true, new Object[] {"I I", "IBI", " I ", 'I', Items.iron_ingot, 'B', Items.bucket});
			AddRecipe(new ItemStack(ModBlocks.Box), true, new Object[]{"CCC", "C C", "CCC", 'C', ModItems.Cardboard});
			AddRecipe(new ItemStack(ModItems.DivingHelmet), true, new Object[] {"SNS", "SGS", "   ", 'S', ModItems.SilverIngot, 'N', Items.nether_star, 'G', Blocks.glass});
			AddRecipe(new ItemStack(ModItems.RunningLeggings), true, new Object[]{"SNS", "S S", "S S", 'S', ModItems.SilverIngot, 'N', Items.nether_star});
			AddRecipe(new ItemStack(ModItems.JumpingBoots), true, new Object[] {"   ", "S S", "D D", 'D', Items.diamond, 'S', ModItems.SilverIngot});
			AddRecipe(new ItemStack(ModBlocks.PaintBlock, 8),  true,new Object[]{"CCC", "CSC", "CCC", 'C', Blocks.wool, 'S', Items.stick});
			AddRecipe(new ItemStack(ModBlocks.SpeedBlock, 8), true, new Object[]{"III", "BDB", "BBB", 'I', Blocks.ice, 'B', Blocks.iron_block, 'D', Items.diamond});
			AddRecipe(new ItemStack(ModBlocks.Mill), true,new Object[]{"CSC", "SPS", "CCC", 'C', Blocks.cobblestone, 'S', Blocks.stone, 'P', Blocks.piston});
			AddRecipe(new ItemStack(ModItems.PizzaBottom), true, new Object[]{"FFF", 'F', ModItems.Flour});
			AddRecipe(new ItemStack(ModBlocks.Squezer), true, new Object[]{"CIC", "IPI", "CCC", 'C', Blocks.cobblestone, 'I', Items.iron_ingot, 'P', Blocks.piston});
			AddRecipe(new ItemStack(ModBlocks.PizzaOven), true, new Object[] {"SSS", "SFS", "SSS", 'S', Blocks.stone, 'F', Blocks.furnace});
			AddRecipe(new ItemStack(ModItems.PaintBrush), true, new Object[]{"  C", " S ", "S  ", 'C', Blocks.wool, 'S', Items.stick});
			AddRecipe(new ItemStack(ModItems.PaintBrush, 1, 4), true, new Object[]{" R ", "GPB", " F ", 'R', new ItemStack(ModItems.PaintBrush, 1, 1 ), 'G', new ItemStack(ModItems.PaintBrush, 1, 2 ), 'B', new ItemStack(ModItems.PaintBrush, 1, 3 ), 'P', Items.paper, 'F', new ItemStack(ModItems.PaintBrush, 1, 0)});
			AddRecipe(new ItemStack(ModItems.PaintBrush, 1, 5), true, new Object[]{" R ", "GPB", " F ", 'R', new ItemStack(ModItems.PaintBrush, 1, 1 ), 'G', new ItemStack(ModItems.PaintBrush, 1, 2 ), 'B', new ItemStack(ModItems.PaintBrush, 1, 3 ), 'P', Items.paper, 'F', new ItemStack(ModItems.PaintBrush, 1, 4)});
			AddRecipe(new ItemStack(ModBlocks.MachinePart), true, new Object[]{"PPP", "P P", "PPP", 'P', new ItemStack(ModItems.IronPlate, 1, 0)});
			AddRecipe(new ItemStack(ModItems.IronPlate, 2, 0), false, new Object[]{"II", "II", 'I', Items.iron_ingot});
			AddRecipe(new ItemStack(ModItems.IronPlate, 1, 2), false, new Object[]{"II", "II", 'I', new ItemStack(ModItems.IronPlate, 1, 1)});
			AddRecipe(new ItemStack(ModItems.Wrench), true, new Object[]{"P P", " P ", " P ", 'P', new ItemStack(ModItems.IronPlate, 1, 0)});
			AddRecipe(new ItemStack(ModItems.Upgrades, 3, 0), true, new Object[]{"PPP", "BBB", "PPP", 'P', new ItemStack(ModItems.IronPlate, 1, 2), 'B', ModItems.Battery});
            AddRecipe(new ItemStack(ModBlocks.ItemPedestal, 2), true, new Object[]{"I I", " S ", "SSS", 'I', Items.iron_ingot, 'S', Blocks.stone});
			AddRecipe(new ItemStack(ModBlocks.MiningChamber), true, new Object[]{"ICI", "IMI", " P ", 'I', new ItemStack(ModItems.IronPlate, 1, 2), 'P', Items.diamond_pickaxe, 'C', new ItemStack(ModItems.Circuit, 1, 1), 'M', ModBlocks.MachinePart});
			AddRecipe(new ItemStack(ModItems.Drill), true, new Object[]{"DD ", "DSI", " IP", 'D', Items.diamond, 'P', ModItems.Battery, 'I', new ItemStack(ModItems.IronPlate, 1, 0), 'S', new ItemStack(ModItems.Circuit, 1, 0)});
			AddRecipe(new ItemStack(ModItems.HeatDrill), true, new Object[]{"CFP", "FDF", "PFK", 'C', new ItemStack(ModItems.Circuit, 1, 1), 'F', Items.fire_charge, 'D', ModItems.Drill, 'K', Blocks.furnace, 'P', new ItemStack(ModItems.IronPlate, 1, 2)});
			AddRecipe(new ItemStack(ModItems.Battery, 1, 16), true, new Object[]{" C ", "IRI", "IRI", 'C', new ItemStack(ModItems.Circuit, 1, 0), 'I', new ItemStack(ModItems.IronPlate, 1, 0), 'R', Items.redstone});
            AddRecipe(new ItemStack(ModItems.ElectricShears), true, new Object[]{"ISI", "IBI", "ICI", 'I', new ItemStack(ModItems.IronPlate, 1, 0), 'S', Items.shears, 'B', ModItems.Battery, 'C', new ItemStack(ModItems.Circuit, 1, 0)});
			AddRecipe(new ItemStack(ModItems.ElectricBow), true, new Object[]{" IS", "ICB", " IS", 'I', new ItemStack(ModItems.IronPlate, 1, 0), 'S', Items.string, 'C', new ItemStack(ModItems.Circuit), 'B', ModItems.Battery});
			AddRecipe(new ItemStack(ModItems.Circuit, 1, 1), true, new Object[]{"IGI", "RCR", "IGI", 'I', new ItemStack(Items.dye, 1, 4), 'C', new ItemStack(ModItems.Circuit, 1, 0), 'R', Items.redstone, 'G', Items.glowstone_dust});
			AddRecipe(new ItemStack(ModItems.Circuit, 1, 0), true, new Object[]{"WIW", "IRI", "WIW", 'W', ModItems.Cardboard, 'I', new ItemStack(ModItems.IronPlate, 1, 0), 'R', Items.redstone});
			AddRecipe(new ItemStack(ModItems.CableItem, 16), true, new Object[]{"CSC", "PRP", "CSC", 'C', new ItemStack(Blocks.carpet), 'S', new ItemStack(Items.string), 'P', new ItemStack(ModItems.IronPlate, 1, 0), 'R', new ItemStack(Items.redstone)});
			AddRecipe(new ItemStack(ModItems.SolarCells), true, new Object[]{"IGI", "GCG", "IGI", 'I', new ItemStack(ModItems.IronPlate, 1, 0), 'G', Blocks.glass, 'C', new ItemStack(ModItems.Circuit, 1, 0)});
			AddRecipe(new ItemStack(ModBlocks.Charger), true, new Object[]{"ICI", "RMR", "IRI", 'I', new ItemStack(ModItems.IronPlate, 1, 2), 'R', new ItemStack(ModItems.Battery, 1, 16), 'C', new ItemStack(ModItems.Circuit, 1, 0), 'M', ModBlocks.MachinePart});
			AddRecipe(new ItemStack(ModBlocks.SolarPanel), true, new Object[]{"IGI", "GMG", "ICI", 'I', new ItemStack(ModItems.IronPlate, 1, 2), 'G', ModItems.SolarCells, 'C', new ItemStack(ModItems.Circuit, 1, 1), 'M', ModBlocks.MachinePart});
			AddRecipe(new ItemStack(ModBlocks.WindMill), true, new Object[]{"III", "SMS", "ICI", 'I', new ItemStack(ModItems.IronPlate, 1, 2), 'S', ModItems.Turbine, 'C', new ItemStack(ModItems.Circuit, 1, 0), 'M', ModBlocks.MachinePart});
			AddRecipe(new ItemStack(ModBlocks.Generator), true, new Object[]{"III", "FMF", "ICI", 'I', new ItemStack(ModItems.IronPlate, 1, 2), 'C', new ItemStack(ModItems.Circuit, 1, 0), 'M', ModBlocks.MachinePart, 'F', Blocks.furnace});
			AddRecipe(new ItemStack(ModBlocks.PowerCable, 32), true, new Object[]{"CCC", "IRI", "CCC", 'I', new ItemStack(ModItems.IronPlate, 1, 0), 'C', new ItemStack(ModItems.CableItem), 'R', new ItemStack(Blocks.redstone_block)});
			AddRecipe(new ItemStack(ModItems.FloatBlockPlacer), true, new Object[]{"GDP", "DRC", "PCB", 'G', Blocks.glass, 'D', Items.diamond, 'P', new ItemStack(ModItems.IronPlate, 1, 2), 'R', Blocks.redstone_block, 'C', new ItemStack(ModItems.Circuit, 1, 1), 'B', new ItemStack(ModItems.AdvancedBattery, 1, 0)});
			AddRecipe(new ItemStack(ModItems.AntiFallChestPlate), true, new Object[]{"PUP", "FCF", "PBP", 'P', new ItemStack(ModItems.IronPlate, 1, 2), 'U', new ItemStack(ModItems.Upgrades, 1, 0), 'F', ModItems.FloatBlockPlacer, 'C', Items.iron_chestplate, 'B', new ItemStack(ModItems.AdvancedBattery, 1, 0)});
			AddRecipe(new ItemStack(ModItems.InfoScreenHelmet), true, new Object[]{"IIP", "GCB", "IIP", 'I', new ItemStack(ModItems.IronPlate, 1 ,0), 'P', new ItemStack(ModItems.IronPlate, 1, 2), 'G', Blocks.glass_pane, 'C', new ItemStack(ModItems.Circuit, 1, 1), 'B', new ItemStack(ModItems.Battery, 1, 0)});
			AddRecipe(new ItemStack(Items.saddle), true, new Object[]{"LLL", "LSL", " I ", 'L', Items.leather, 'S', Items.string, 'I', Items.iron_ingot});
	        AddRecipe(new ItemStack(ModBlocks.Pillar, 4),  true, new Object[]{"QQQ", " Q ", "QQQ", 'Q', Blocks.quartz_block});
	        AddRecipe(new ItemStack(ModBlocks.ElectricFurnace), true, new Object[]{"PMP", "PFP", "PCP", 'P', new ItemStack(ModItems.IronPlate, 1, 2), 'M', ModBlocks.MachinePart, 'F', Blocks.furnace, 'C', new ItemStack(ModItems.Circuit, 1, 1)});
	        AddRecipe(new ItemStack(ModBlocks.GamePart, 4), true, new Object[]{"III", " I ", "III", 'I', Items.iron_ingot});
            AddRecipe(new ItemStack(ModItems.FlightChestPlate), true, new Object[] {"IFI", "ISI", "III", 'I', ModItems.SilverIngot, 'S', Items.nether_star, 'F', Items.feather});
            AddRecipe(new ItemStack(ModItems.Lens), true, new Object[]{"ISI", "SGS", "ISI", 'I', Items.iron_ingot, 'S', ModItems.SilverNugget, 'G', Blocks.glass_pane});
            AddRecipe(new ItemStack(ModBlocks.Laser), true, new Object[]{"HCH", "BML", "HCH", 'H', new ItemStack(ModItems.IronPlate, 1, 2), 'C', ModBlocks.PowerCable, 'B', new ItemStack(ModItems.Battery, 1, 0), 'M', ModBlocks.MachinePart, 'L', ModItems.Lens});
            AddRecipe(new ItemStack(ModBlocks.LaserReciver), true, new Object[]{"HBH", "CLC", "HRH", 'H', new ItemStack(ModItems.IronPlate, 1, 2), 'B', new ItemStack(ModItems.Battery, 1, 0), 'C', ModBlocks.PowerCable, 'L', ModItems.Lens, 'R', Blocks.redstone_block});
            AddRecipe(new ItemStack(ModBlocks.GhostBlock, 16), true, new Object[]{"GPG", "GSG", "GDG", 'G', Blocks.glass, 'P', Items.paper, 'D', Items.diamond, 'S', ModItems.SilverIngot});


            RegisterSmelting(ModBlocks.SilverOre, new ItemStack(ModItems.SilverIngot), 2.0F);
            RegisterSmelting(ModBlocks.OrangeLog, new ItemStack(Items.coal, 1, 1), 1.2F);
            RegisterSmelting(ModItems.Flour, new ItemStack(Items.bread), 1F);

            RegisterSmelting(new ItemStack(ModItems.PizzaRaw, 1, 0), new ItemStack(ModItems.Pizza, 1, 0), 20F);
            RegisterSmelting(new ItemStack(ModItems.PizzaRaw, 1, 1), new ItemStack(ModItems.Pizza, 1, 1), 20F);
            RegisterSmelting(new ItemStack(ModItems.PizzaRaw, 1, 2), new ItemStack(ModItems.Pizza, 1, 2), 20F);
            RegisterSmelting(new ItemStack(ModItems.PizzaRaw, 1, 3), new ItemStack(ModItems.Pizza, 1, 3), 20F);

            RegisterSmelting(new ItemStack(ModItems.IronPlate, 1, 0), new ItemStack(ModItems.IronPlate, 1, 1), 20F);




    }

    public static boolean RegisterRes(String name){


        if(!Recipes.contains(name)){
            Recipes.add(name);
            return true;
        }

        return false;
    }


    public static void RegisterSmelting(ItemStack Input, ItemStack Output, float Xp){
        if(!Item.itemRegistry.containsId(Item.getIdFromItem(Input.getItem())) || !Item.itemRegistry.containsId(Item.getIdFromItem(Output.getItem())))
            return;
        FurnaceRecipes.smelting().func_151394_a(Input, Output, Xp);
    }

    public static void RegisterSmelting(Item Input, ItemStack Output, float Xp){
        if(!Item.itemRegistry.containsId(Item.getIdFromItem(Input)) || !Item.itemRegistry.containsId(Item.getIdFromItem(Output.getItem())))
            return;
        GameRegistry.addSmelting(Input, Output, Xp);
    }

    public static void RegisterSmelting(Block Input, ItemStack Output, float Xp){
        if(!Block.blockRegistry.containsId(Block.getIdFromBlock(Input)) || !Item.itemRegistry.containsId(Item.getIdFromItem(Output.getItem())))
            return;
        GameRegistry.addSmelting(Input, Output, Xp);
    }

    
    public static void AddRecipe(ItemStack output, boolean RegisterGuide,  Object... Array){

        String name = output.getUnlocalizedName().replace("tile.", "").replace(".name", "").replace(" ", "_").replace("item.", "");




        if(RegisterRes(name)){
            if(CheckBigRecipe(output, Array)){
                GameRegistry.addShapedRecipe(output, Array);
            }

        }else{
            if(!RegisterRes(name)){
                for(int i = 0; i < 20; i++){

                    if(RegisterRes(name + "_" + i)){

                        name = output.getUnlocalizedName().replace("tile.", "").replace(".name", "").replace(" ", "_").replace("item.", "") + "_" + i;


                        if(CheckBigRecipe(output, Array)){
                            GameRegistry.addShapedRecipe(output, Array);
                            break;
                        }
                    }

                }
            }


        }


    }
    
    public static void AddShapelessRecipe(ItemStack output, Object... Array){

        String name = output.getUnlocalizedName().replace("tile.", "").replace(".name", "").replace(" ", "_").replace("item.", "");



        if(RegisterRes(name)){
            if(CheckSmallRecipe(output, Array)){
                GameRegistry.addShapelessRecipe(output, Array);
            }

        }else{
            if(!RegisterRes(name)){
                for(int i = 0; i < 20; i++){

                    if(RegisterRes(name + "_" + i)){

                        name = output.getUnlocalizedName().replace("tile.", "").replace(".name", "").replace(" ", "_").replace("item.", "") + "_" + i;


                        if(CheckSmallRecipe(output, Array)){
                            GameRegistry.addShapelessRecipe(output, Array);
                            break;
                        }
                    }

                }
            }


        }

    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static boolean CheckBigRecipe(ItemStack stack, Object ... par2ArrayOfObj)
    {



        String s = "";
        int i = 0;
        int j = 0;
        int k = 0;

        if (par2ArrayOfObj[i] instanceof String[])
        {
            String[] astring = (String[])((String[])par2ArrayOfObj[i++]);

            for (int l = 0; l < astring.length; ++l)
            {
                String s1 = astring[l];
                ++k;
                j = s1.length();
                s = s + s1;
            }
        }
        else
        {
            while (par2ArrayOfObj[i] instanceof String)
            {
                String s2 = (String)par2ArrayOfObj[i++];
                ++k;
                j = s2.length();
                s = s + s2;
            }
        }

        HashMap hashmap;

        for (hashmap = new HashMap(); i < par2ArrayOfObj.length; i += 2)
        {
            Character character = (Character)par2ArrayOfObj[i];
            ItemStack itemstack1 = null;

            if (par2ArrayOfObj[i + 1] instanceof Item)
            {
                itemstack1 = new ItemStack((Item)par2ArrayOfObj[i + 1]);
            }
            else if (par2ArrayOfObj[i + 1] instanceof Block)
            {
                itemstack1 = new ItemStack((Block)par2ArrayOfObj[i + 1], 1, 32767);
            }
            else if (par2ArrayOfObj[i + 1] instanceof ItemStack)
            {
                itemstack1 = (ItemStack)par2ArrayOfObj[i + 1];
            }

            hashmap.put(character, itemstack1);
        }

        ItemStack[] aitemstack = new ItemStack[j * k];

        for (int i1 = 0; i1 < j * k; ++i1)
        {
            char c0 = s.charAt(i1);

            if (hashmap.containsKey(Character.valueOf(c0)))
            {
                aitemstack[i1] = ((ItemStack)hashmap.get(Character.valueOf(c0))).copy();
            }
            else
            {
                aitemstack[i1] = null;
            }
        }

        if(Item.itemRegistry.containsId(Item.getIdFromItem(stack.getItem()))){
        for(int z = 0; z  < aitemstack.length; z++){
            if(aitemstack[z] != null){
                if(Item.itemRegistry.containsId(Item.getIdFromItem(aitemstack[z].getItem())) == false){
                    return false;
                }

            }
        }

    }else{
            return false;
        }

        return true;
    }


    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static boolean CheckSmallRecipe(ItemStack par1ItemStack, Object ... par2ArrayOfObj)
    {
        ArrayList arraylist = new ArrayList();
        Object[] aobject = par2ArrayOfObj;
        int i = par2ArrayOfObj.length;

        for (int j = 0; j < i; ++j)
        {
            Object object1 = aobject[j];

            if (object1 instanceof ItemStack)
            {
                arraylist.add(((ItemStack)object1).copy());
            }
            else if (object1 instanceof Item)
            {
                arraylist.add(new ItemStack((Item)object1));
            }
            else
            {
                if (!(object1 instanceof Block))
                {
                    throw new RuntimeException("Invalid shapeless recipy!");
                }

                arraylist.add(new ItemStack((Block)object1));
            }

        }

        if(Item.itemRegistry.containsId(Item.getIdFromItem(par1ItemStack.getItem()))){
            for(int z = 0; z  < arraylist.size(); z++){
                if((ItemStack)arraylist.get(z) != null){
                if(Item.itemRegistry.containsId(Item.getIdFromItem(((ItemStack)arraylist.get(z)).getItem())) == false){
                    return false;
                }

            }
            }

        }else
            return false;


      return true;
    }





    public static ItemStack GetItemStack(ArrayList array, int i){

        if(array.get(i) instanceof Block){
            return new ItemStack((Block)array.get(i));
        }

        if(array.get(i) instanceof Item){
            return new ItemStack((Item)array.get(i));
        }

        if(array.get(i) instanceof ItemStack){
            return (ItemStack)array.get(i);
        }


        return new ItemStack(Blocks.air);
    }
    
}