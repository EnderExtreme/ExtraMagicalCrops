package de.domi1819.extramagicalcrops;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes
{
    public static String[] ident = new String[] { "AdvAlloy", "Alumentum", "Amber", "ArcanePlants", "Blizz", "BlueTopaz", "Chimerite", "Chrome", "Cinnabar", "ConductiveIron", "Creosote", "DarkIron", "ElectricalSteel", "Enderium", "EnergeticAlloy", "Ethanol", "Iridium", "LiquidEssence", "Manganese", "MoonStone", "NetherStar", "Nitor", "Osmium", "Plutonium", "Quicksilver", "Rubber", "Saltpeter", "Scrap", "Silicon", "StainlessSteel", "Steel", "Sulfur", "SunStone", "Thaumium", "Titanium", "Tungsten", "TungstenSteel", "VibrantAlloy", "Vinteum", "Zinc" };
    public static String[] oreDict = new String[] { null, null, null, null, null, null, null, "ingotChrome", "crystalCinnabar", "ingotConductiveIron", null, "ingotFzDarkIron", "ingotElectricalSteel", "ingotEnderium", "ingotEnergeticAlloy", null, null, null, "ingotManganese", null, null, null, "ingotOsmium", "ingotPlutonium", null, "itemRubber", "dustSaltpeter", null, "itemSilicon", "ingotStainlessSteel", "ingotSteel", "dustSulfur", null, "ingotThaumium", "ingotTitanium", "ingotTungsten", "ingotTungstenSteel", "ingotVibrantAlloy", null, "ingotZinc" };
    public static int[] tiers = new int[] { 3, 4, 2, 3, 4, 2, 2, 5, 4, 3, 3, 4, 3, 5, 4, 4, 5, 4, 2, 3, 5, 3, 3, 4, 3, 3, 3, 2, 3, 5, 5, 3, 4, 3, 5, 5, 5, 4, 3, 3 };
    
    public static void registerRecipes()
    {
        if (ModItems.items[0] != null) GameRegistry.addRecipe(ModItems.items[0], "XXX", "   ", "XXX", 'X', new ItemStack(ExtraMagicalCrops.itemEssences, 1, 0));
        if (ModItems.items[1] != null) GameRegistry.addRecipe(ModItems.items[1], " X ", "XXX", " X ", 'X', new ItemStack(ExtraMagicalCrops.itemEssences, 1, 1));
        if (ModItems.items[2] != null) GameRegistry.addRecipe(ModItems.items[2], " X ", "X X", " X ", 'X', new ItemStack(ExtraMagicalCrops.itemEssences, 1, 2));
        if (ModItems.items[4] != null) GameRegistry.addRecipe(ModItems.items[4], " XX", "XXX", "XX ", 'X', new ItemStack(ExtraMagicalCrops.itemEssences, 1, 4));
        if (ModItems.items[5] != null) GameRegistry.addRecipe(ModItems.items[5], "X X", " X ", "X X", 'X', new ItemStack(ExtraMagicalCrops.itemEssences, 1, 5));
        if (ModItems.items[6] != null) GameRegistry.addRecipe(ModItems.items[6], "XX", 'X', new ItemStack(ExtraMagicalCrops.itemEssences, 1, 6));
        if (ModItems.items[7] != null) GameRegistry.addRecipe(ModItems.items[7], "XXX", "X X", "XXX", 'X', new ItemStack(ExtraMagicalCrops.itemEssences, 1, 7));
        if (ModItems.items[8] != null) GameRegistry.addRecipe(ModItems.items[8], " XX", "XXX", " X ", 'X', new ItemStack(ExtraMagicalCrops.itemEssences, 1, 8));
        if (ModItems.items[9] != null) GameRegistry.addRecipe(ModItems.items[9], "XXX", "X X", "XXX", 'X', new ItemStack(ExtraMagicalCrops.itemEssences, 1, 9));
        if (ModItems.items[10] != null) GameRegistry.addRecipe(ModItems.items[10], " X ", "XBX", " X ", 'X', new ItemStack(ExtraMagicalCrops.itemEssences, 1, 10), 'B', Item.bucketEmpty);
        if (ModItems.items[11] != null) GameRegistry.addRecipe(ModItems.items[11], "XXX", "X X", "XXX", 'X', new ItemStack(ExtraMagicalCrops.itemEssences, 1, 11));
        if (ModItems.items[12] != null) GameRegistry.addRecipe(ModItems.items[12], "XXX", "X X", "XXX", 'X', new ItemStack(ExtraMagicalCrops.itemEssences, 1, 12));
        if (ModItems.items[13] != null) GameRegistry.addRecipe(ModItems.items[13], "XXX", "X X", "XXX", 'X', new ItemStack(ExtraMagicalCrops.itemEssences, 1, 13));
        if (ModItems.items[14] != null) GameRegistry.addRecipe(ModItems.items[14], "XXX", "X X", "XXX", 'X', new ItemStack(ExtraMagicalCrops.itemEssences, 1, 14));
        if (ModItems.items[15] != null) GameRegistry.addRecipe(ModItems.items[15], " X ", "XBX", " X ", 'X', new ItemStack(ExtraMagicalCrops.itemEssences, 1, 15), 'B', Item.bucketEmpty);
        if (ModItems.items[16] != null) GameRegistry.addRecipe(ModItems.items[16], "XXX", "XXX", "XXX", 'X', new ItemStack(ExtraMagicalCrops.itemEssences, 1, 16));
        if (ModItems.items[17] != null) GameRegistry.addRecipe(ModItems.items[17], " X ", "XBX", " X ", 'X', new ItemStack(ExtraMagicalCrops.itemEssences, 1, 17), 'B', Item.bucketEmpty);
        if (ModItems.items[18] != null) GameRegistry.addRecipe(ModItems.items[18], "XXX", "X X", "XXX", 'X', new ItemStack(ExtraMagicalCrops.itemEssences, 1, 18));
        if (ModItems.items[19] != null) GameRegistry.addRecipe(ModItems.items[19], " X ", "XXX", " X ", 'X', new ItemStack(ExtraMagicalCrops.itemEssences, 1, 19));
        if (ModItems.items[20] != null) GameRegistry.addRecipe(ModItems.items[20], "XXX", "XXX", "XXX", 'X', new ItemStack(ExtraMagicalCrops.itemEssences, 1, 20));
        if (ModItems.items[21] != null) GameRegistry.addRecipe(ModItems.items[21], " X ", "XXX", " X ", 'X', new ItemStack(ExtraMagicalCrops.itemEssences, 1, 21));
        if (ModItems.items[22] != null) GameRegistry.addRecipe(ModItems.items[22], "XXX", "X X", "XXX", 'X', new ItemStack(ExtraMagicalCrops.itemEssences, 1, 22));
        if (ModItems.items[23] != null) GameRegistry.addRecipe(ModItems.items[23], "XXX", "X X", "XXX", 'X', new ItemStack(ExtraMagicalCrops.itemEssences, 1, 23));
        if (ModItems.items[24] != null) GameRegistry.addRecipe(ModItems.items[24], " X ", "XXX", " X ", 'X', new ItemStack(ExtraMagicalCrops.itemEssences, 1, 24));
        if (ModItems.items[25] != null) GameRegistry.addRecipe(ModItems.items[25], "X", 'X', new ItemStack(ExtraMagicalCrops.itemEssences, 1, 25));
        if (ModItems.items[26] != null) GameRegistry.addRecipe(ModItems.items[26], "X X", "   ", "X X", 'X', new ItemStack(ExtraMagicalCrops.itemEssences, 1, 26));
        if (ModItems.items[27] != null) GameRegistry.addRecipe(ModItems.items[27], "X", 'X', new ItemStack(ExtraMagicalCrops.itemEssences, 1, 27));
        if (ModItems.items[28] != null) GameRegistry.addRecipe(ModItems.items[28], "X", "X", 'X', new ItemStack(ExtraMagicalCrops.itemEssences, 1, 28));
        if (ModItems.items[29] != null) GameRegistry.addRecipe(ModItems.items[29], "XXX", "X X", "XXX", 'X', new ItemStack(ExtraMagicalCrops.itemEssences, 1, 29));
        if (ModItems.items[30] != null) GameRegistry.addRecipe(ModItems.items[30], "XXX", "X X", "XXX", 'X', new ItemStack(ExtraMagicalCrops.itemEssences, 1, 30));
        if (ModItems.items[31] != null) GameRegistry.addRecipe(ModItems.items[31], "X X", "   ", "X X", 'X', new ItemStack(ExtraMagicalCrops.itemEssences, 1, 31));
        if (ModItems.items[32] != null) GameRegistry.addRecipe(ModItems.items[32], " X ", "XXX", " X ", 'X', new ItemStack(ExtraMagicalCrops.itemEssences, 1, 32));
        if (ModItems.items[33] != null) GameRegistry.addRecipe(ModItems.items[33], "XXX", "X X", "XXX", 'X', new ItemStack(ExtraMagicalCrops.itemEssences, 1, 33));
        if (ModItems.items[34] != null) GameRegistry.addRecipe(ModItems.items[34], "XXX", "X X", "XXX", 'X', new ItemStack(ExtraMagicalCrops.itemEssences, 1, 34));
        if (ModItems.items[35] != null) GameRegistry.addRecipe(ModItems.items[35], "XXX", "X X", "XXX", 'X', new ItemStack(ExtraMagicalCrops.itemEssences, 1, 35));
        if (ModItems.items[36] != null) GameRegistry.addRecipe(ModItems.items[36], "XXX", "X X", "XXX", 'X', new ItemStack(ExtraMagicalCrops.itemEssences, 1, 36));
        if (ModItems.items[37] != null) GameRegistry.addRecipe(ModItems.items[37], "XXX", "X X", "XXX", 'X', new ItemStack(ExtraMagicalCrops.itemEssences, 1, 37));
        if (ModItems.items[38] != null) GameRegistry.addRecipe(ModItems.items[38], "X X", "   ", "X X", 'X', new ItemStack(ExtraMagicalCrops.itemEssences, 1, 38));
        if (ModItems.items[39] != null) GameRegistry.addRecipe(ModItems.items[39], "XXX", "X X", "XXX", 'X', new ItemStack(ExtraMagicalCrops.itemEssences, 1, 39));
        
        GameRegistry.addRecipe(new ItemStack(ExtraMagicalCrops.itemMisc.itemID, 4, 0), "EEE", "EIE", "EEE", 'E', ModItems.essences[4], 'I', ModItems.infusionStoneMaster);
        
        for (int i = 0; i < 40; i++)
        {
            if (oreDict[i] == null)
            {
                if (ModItems.items[i] != null) GameRegistry.addRecipe(new ItemStack(ExtraMagicalCrops.itemSeeds.itemID, (tiers[i] > 3 ? 1 : 2), i), "IEI", "ESE", "IEI", 'I', ModItems.items[i], 'E', ModItems.essences[tiers[i]], 'S', Item.seeds);
            }
            else
            {
                GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ExtraMagicalCrops.itemSeeds.itemID, (tiers[i] > 3 ? 1 : 2), i), "IEI", "ESE", "IEI", 'I', oreDict[i], 'E', ModItems.essences[tiers[i]], 'S', Item.seeds));
            }
        }
    }
}
