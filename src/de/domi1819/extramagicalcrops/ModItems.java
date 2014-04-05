package de.domi1819.extramagicalcrops;

import java.util.ArrayList;

import cpw.mods.fml.common.event.FMLInterModComms.IMCEvent;
import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class ModItems
{
    public static ItemStack[] items = new ItemStack[40];
    public static ItemStack[] essences = new ItemStack[6];
    public static ItemStack infusionStoneMaster;
   
    public static void fetchItems()
    {
        items[0] = fetchStack("IC2", "itemPartAlloy");
        items[1] = fetchStack("Thaumcraft", "ItemResource");
        items[2] = fetchStack("Thaumcraft", "ItemResource", 6);
        items[3] = null; //arcane plants
        items[4] = pullStack("thermalexpansion.item.TEItems", "rodBlizz");
        items[5] = fetchStack("arsmagica2", "itemOre", 5);
        items[6] = fetchStack("arsmagica2", "itemOre", 4);
        items[7] = fetchOreDict("ingotChrome");
        items[8] = pullStack("thermalexpansion.item.TEItems", "crystalCinnabar");
        items[9] = fetchOreDict("ingotConductiveIron");
        items[10] = fetchStack("Railcraft", "railcraft.fluid.creosote.bucket");
        items[11] = fetchStack("factorization", "item.factorization:dark_iron_ingot");
        items[12] = fetchOreDict("ingotElectricalSteel");
        items[13] = pullStack("thermalexpansion.item.TEItems", "ingotEnderium");
        items[14] = fetchOreDict("ingotEnergeticAlloy");
        items[15] = fetchStack("Forestry", "bucketBiofuel");
        items[16] = fetchStack("IC2", "itemOreIridium");
        items[17] = fetchStack("arsmagica2", "liquidEssenceBucket");
        items[18] = fetchOreDict("ingotManganese");
        items[19] = fetchStack("arsmagica2", "itemOre", 7);
        items[20] = new ItemStack(Item.netherStar, 1, 0);
        items[21] = fetchStack("Thaumcraft", "ItemResource", 1);
        items[22] = fetchStack("Mekanism", "Ingot", 1);
        items[23] = fetchOreDict("ingotPlutonium");
        items[24] = fetchStack("Thaumcraft", "ItemResource", 3);
        items[25] = fetchStack("IC2", "itemRubber");
        items[26] = pullStack("thermalexpansion.item.TEItems", "dustNiter");
        items[27] = fetchStack("IC2", "itemScrap");
        items[28] = fetchStack("AppliedEnergistics", "AppEngMaterials", 13);
        items[29] = fetchOreDict("ingotStainlessSteel");
        items[30] = fetchStack("Railcraft", "railcraft.ingot");
        items[31] = pullStack("thermalexpansion.item.TEItems", "dustSulfur");
        items[32] = fetchStack("arsmagica2", "itemOre", 6);
        items[33] = fetchStack("Thaumcraft", "ItemResource", 2);
        items[34] = fetchOreDict("ingotTitanium");
        items[35] = fetchOreDict("ingotTungsten");
        items[36] = fetchOreDict("ingotTungstenSteel");
        items[37] = fetchOreDict("ingotVibrantAlloy");
        items[38] = fetchStack("arsmagica2", "itemOre", 4);
        items[39] = fetchOreDict("ingotZinc");

        essences[0] = pullStack("magicalcrops.mod_mCrops", "MagicEssence");
        essences[1] = new ItemStack(essences[0].itemID, 1, 1);
        essences[2] = new ItemStack(essences[0].itemID, 1, 2);
        essences[3] = new ItemStack(essences[0].itemID, 1, 3);
        essences[4] = new ItemStack(essences[0].itemID, 1, 4);
        essences[5] = new ItemStack(ExtraMagicalCrops.itemMisc.itemID, 1, 0);
        
        infusionStoneMaster = new ItemStack(pullStack("magicalcrops.mod_mCrops", "magicInfusionStone").itemID, 1, 4);
    }
    
    public static ItemStack fetchStack(String modID, String name)
    {
        return GameRegistry.findItemStack(modID, name, 1);
    }
    
    public static ItemStack fetchStack(String modID, String name, int dmg)
    {
        ItemStack stack = GameRegistry.findItemStack(modID, name, 1);
        if (stack != null) stack.setItemDamage(dmg);
        return stack;
    }
    
    public static ItemStack fetchOreDict(String tag)
    {
        ArrayList<ItemStack> stacks = OreDictionary.getOres(tag);
        if (stacks.size() > 1)
        {
            return stacks.get(0);
        }
        
        return null;
    }
    
    public static ItemStack pullStack(String className, String field)
    {
        try
        {
            Class c = Class.forName(className);
            Object f = c.getField(field).get(null);
            
            if (f instanceof ItemStack)
                return (ItemStack) f;
            if (f instanceof Item)
                return new ItemStack(((Item)f).itemID, 1, 0);
            return null;
        }
        catch (Exception e)
        {
            return null;
        }
    }
}
