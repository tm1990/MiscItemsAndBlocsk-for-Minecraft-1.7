package com.miscitems.MiscItemsAndBlocks.Block;

import com.miscitems.MiscItemsAndBlocks.Items.ModItems;
import com.miscitems.MiscItemsAndBlocks.Utils.Refrence;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

import java.util.Random;

public class ModBlockCrystalOre extends Block {

    Item Dropped;

    public ModBlockCrystalOre(Item DroppedItem) {
        super(Material.rock);
        this.setHardness(6);
        this.Dropped = DroppedItem;
    }



    public int getHarvestLevel(int metadata)
    {
        return 1;
    }


    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return Dropped;
    }


    public int quantityDroppedWithBonus(int p_149679_1_, Random p_149679_2_)
    {
        return this.quantityDropped(p_149679_2_) + p_149679_2_.nextInt(p_149679_1_ + 2);
    }

    public int quantityDropped(Random p_149745_1_)
    {
        return 2 + p_149745_1_.nextInt(5);
    }
}