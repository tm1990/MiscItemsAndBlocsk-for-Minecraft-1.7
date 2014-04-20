package BookCode_mantle.client.pages;

import BookCode_mantle.client.MantleClientRegistry;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class CraftingPage extends BookPage
{
    String text;
    String size;
    ItemStack[] icons;

    int xS, yS;

    @Override
    public void readPageFromXML (Element element)
    {
        NodeList nodes = element.getElementsByTagName("text");
        if (nodes != null)
            text = nodes.item(0).getTextContent();

        nodes = element.getElementsByTagName("name");
        if (nodes != null)
            icons = MantleClientRegistry.getRecipeIcons(nodes.item(0).getTextContent());

        nodes = element.getElementsByTagName("size");
        if (nodes != null)
            size = nodes.item(0).getTextContent();
    }

    @Override
    public void renderContentLayer (int localWidth, int localHeight, boolean isTranslatable)
    {
        if (isTranslatable)
            text = StatCollector.translateToLocal(text);
        if (size.equals("two"))
            drawCraftingPage(text, icons, 2, localWidth, localHeight + 12);
        if (size.equals("three")){
            drawCraftingPage(text, icons, 3, localWidth + (side != 1 ? 6 : 0), localHeight + 12);
        }
    }

    public void drawCraftingPage (String info, ItemStack[] icons, int recipeSize, int localWidth, int localHeight)
    {
        if (info != null)
            manual.fonts.drawString("\u00a7n" + info, localWidth + 50, localHeight + 4, 0);

        GL11.glScalef(2f, 2f, 2f);
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        RenderHelper.enableGUIStandardItemLighting();
        manual.renderitem.zLevel = 100;

        xS = localWidth;
        yS = localHeight;

        if (recipeSize == 2)
        {



            if(icons != null && icons[0] != null && icons.length > 1 && icons[0].getItem() != null && icons[0].getItem() != ItemBlock.getItemFromBlock(Blocks.air)){

            manual.renderitem.renderItemAndEffectIntoGUI(manual.fonts, manual.getMC().renderEngine, icons[0], (localWidth + 126) / 2, (localHeight + 68) / 2);
            if (icons[0].stackSize > 1)
                manual.renderitem.renderItemOverlayIntoGUI(manual.fonts, manual.getMC().renderEngine, icons[0], (localWidth + 126) / 2, (localHeight + 68) / 2, String.valueOf(icons[0].stackSize));
            for (int i = 0; i < icons.length - 1; i++)
            {
                if (icons[i + 1] != null && Item.itemRegistry.containsId(Item.getIdFromItem(icons[i + 1].getItem()))&& icons[i + 1].getItem() != ItemBlock.getItemFromBlock(Blocks.air) && icons[i + 1].getItem() != null)
                    manual.renderitem.renderItemAndEffectIntoGUI(manual.fonts, manual.getMC().renderEngine, icons[i + 1], (localWidth + 14 + 36 * (i % 2)) / 2, (localHeight + 36 * (i / 2) + 52) / 2);
            }
        }
        }

        if (recipeSize == 3)
        {



            if(icons != null && icons[0] != null && Item.itemRegistry.containsId(Item.getIdFromItem(icons[0].getItem())) && icons[0].stackSize > 0){
            manual.renderitem.renderItemAndEffectIntoGUI(manual.fonts, manual.getMC().renderEngine, icons[0], (localWidth + 138) / 2, (localHeight + 70) / 2);
            if (icons[0].stackSize > 1)
                manual.renderitem.renderItemOverlayIntoGUI(manual.fonts, manual.getMC().renderEngine, icons[0], (localWidth + 134) / 2, (localHeight + 68) / 2, String.valueOf(icons[0].stackSize));
            for (int i = 0; i < icons.length - 1; i++)
            {

                if (icons[i + 1] != null && Item.itemRegistry.containsId(Item.getIdFromItem(icons[i + 1].getItem())))
                    manual.renderitem.renderItemAndEffectIntoGUI(manual.fonts, manual.getMC().renderEngine, icons[i + 1], (localWidth - 2 + 36 * (i % 3)) / 2, (localHeight + 36 * (i / 3) + 34) / 2);
            }
            }

        }

        manual.renderitem.zLevel = 0;
        GL11.glScalef(0.5F, 0.5F, 0.5F);
        RenderHelper.disableStandardItemLighting();
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
    }

    public void renderBackgroundLayer (int localwidth, int localheight)
    {
    	
        if (size.equals("two"))
            drawBackground(2, localwidth, localheight + 12);

        if (size.equals("three"))
            drawBackground(3, localwidth + (side != 1 ? 6 : 0), localheight + 12);
    }

    private static final ResourceLocation background = new ResourceLocation("miscitems", "textures/gui/bookcrafting.png");

    public void drawBackground (int size, int localWidth, int localHeight)
    {
        manual.getMC().getTextureManager().bindTexture(background);
        if (size == 2)
            manual.drawTexturedModalRect(localWidth + 8, localHeight + 46, 0, 116, 154, 78);
        if (size == 3)
            manual.drawTexturedModalRect(localWidth - 8, localHeight + 28, 0, 0, 183, 114);
    }



}