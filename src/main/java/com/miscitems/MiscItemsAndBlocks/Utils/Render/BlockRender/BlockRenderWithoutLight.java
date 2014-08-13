package com.miscitems.MiscItemsAndBlocks.Utils.Render.BlockRender;

import com.miscitems.MiscItemsAndBlocks.Main.Main;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Decorative.TileEntityColorBlock;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.ChunkCache;
import net.minecraft.world.IBlockAccess;
import org.lwjgl.opengl.GL11;

public class BlockRenderWithoutLight  implements ISimpleBlockRenderingHandler
    {


    public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer)
    {

        Tessellator var4 = Tessellator.instance;
        block.setBlockBoundsForItemRender();
        renderer.setRenderBoundsFromBlock(block);
        GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
        GL11.glTranslatef(-0.5F, -0.0F, -0.5F);

        int l = block.getRenderColor(metadata);
        float r = (l >> 16 & 0xFF) / 255.0F;
        float g = (l >> 8 & 0xFF) / 255.0F;
        float b = (l & 0xFF) / 255.0F;
        GL11.glColor4f(r, g, b, 1.0F);
        GL11.glDisable(2896);
        renderer.enableAO = false;
        var4.startDrawingQuads();
        var4.setNormal(0.0F, 1.0F, 0.0F);

        renderer.renderFaceYNeg(block, 0.0D, -0.5D, 0.0D, block.getIcon(0, metadata));



        renderer.renderFaceYPos(block, 0.0D, -0.5D, 0.0D, block.getIcon(1, metadata));



        renderer.renderFaceZNeg(block, 0.0D, -0.5D, 0.0D, block.getIcon(2, metadata));



        renderer.renderFaceZPos(block, 0.0D, -0.5D, 0.0D, block.getIcon(3, metadata));



        renderer.renderFaceXNeg(block, 0.0D, -0.5D, 0.0D, block.getIcon(4, metadata));



        renderer.renderFaceXPos(block, 0.0D, -0.5D, 0.0D, block.getIcon(5, metadata));

        var4.draw();
        GL11.glTranslatef(0.5F, 0.0F, 0.5F);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glEnable(2896);
    }

    public boolean renderWorldBlock(IBlockAccess world, int par2, int par3, int par4, Block par1Block, int modelId, RenderBlocks renderer)
    {
        TileEntityColorBlock tile = null;

        if(world instanceof ChunkCache)
            if(((ChunkCache)world).getTileEntity(par2, par3, par4) instanceof TileEntityColorBlock)
                tile = (TileEntityColorBlock)((ChunkCache)world).getTileEntity(par2, par3, par4);

        renderer.enableAO = false;
        Tessellator tessellator = Tessellator.instance;
        boolean flag = false;
        tessellator.setColorOpaque_F(1.0F, 1.0F, 1.0F);
        tessellator.setBrightness(240);

        int meta = world.getBlockMetadata(par2, par3, par4);
        int l = 0;

        if(tile != null)
        l = par1Block.getRenderColor(tile.Color);

        else
            l = par1Block.getRenderColor(meta);



        float r = (l >> 16 & 0xFF) / 255.0F;
        float g = (l >> 8 & 0xFF) / 255.0F;
        float b = (l & 0xFF) / 255.0F;
        tessellator.setColorOpaque_F(r, g, b);
        if ((renderer.renderAllFaces) || (par1Block.shouldSideBeRendered(renderer.blockAccess, par2, par3 - 1, par4, 0)))
        {
            renderer.renderFaceYNeg(par1Block, par2, par3, par4, renderer.getBlockIcon(par1Block, renderer.blockAccess, par2, par3, par4, 0));
            flag = true;
        }
        if ((renderer.renderAllFaces) || (par1Block.shouldSideBeRendered(renderer.blockAccess, par2, par3 + 1, par4, 1)))
        {
            renderer.renderFaceYPos(par1Block, par2, par3, par4, renderer.getBlockIcon(par1Block, renderer.blockAccess, par2, par3, par4, 1));
            flag = true;
        }
        if ((renderer.renderAllFaces) || (par1Block.shouldSideBeRendered(renderer.blockAccess, par2, par3, par4 - 1, 2)))
        {
            renderer.renderFaceZNeg(par1Block, par2, par3, par4, renderer.getBlockIcon(par1Block, renderer.blockAccess, par2, par3, par4, 2));
            flag = true;
        }
        if ((renderer.renderAllFaces) || (par1Block.shouldSideBeRendered(renderer.blockAccess, par2, par3, par4 + 1, 3)))
        {
            renderer.renderFaceZPos(par1Block, par2, par3, par4, renderer.getBlockIcon(par1Block, renderer.blockAccess, par2, par3, par4, 3));
            flag = true;
        }
        if ((renderer.renderAllFaces) || (par1Block.shouldSideBeRendered(renderer.blockAccess, par2 - 1, par3, par4, 4)))
        {
            renderer.renderFaceXNeg(par1Block, par2, par3, par4, renderer.getBlockIcon(par1Block, renderer.blockAccess, par2, par3, par4, 4));
            flag = true;
        }
        if ((renderer.renderAllFaces) || (par1Block.shouldSideBeRendered(renderer.blockAccess, par2 + 1, par3, par4, 5)))
        {
            renderer.renderFaceXPos(par1Block, par2, par3, par4, renderer.getBlockIcon(par1Block, renderer.blockAccess, par2, par3, par4, 5));
            flag = true;
        }
        return flag;
    }

    public boolean shouldRender3DInInventory(int modelId)
    {
        return true;
    }

    public int getRenderId()
    {
        return Main.proxy.RenderColorBlock;
    }
}
