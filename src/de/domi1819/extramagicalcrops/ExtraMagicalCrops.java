package de.domi1819.extramagicalcrops;

import java.io.File;

import powercrystals.minefactoryreloaded.api.FactoryRegistry;
import powercrystals.minefactoryreloaded.api.IFactoryHarvestable;
import powercrystals.minefactoryreloaded.api.IFactoryPlantable;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;

@Mod(modid = "emc", name = "Extra Magical Crops", version = "0.69")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class ExtraMagicalCrops
{
    public static CreativeTabs tab;
    
    public static int seedsID, essencesID, miscID;
    public static int[] cropsID = new int[10];
    
    public static int secondSeedDropChance;
    
    public static String[] ident = new String[] { "AdvAlloy", "Alumentum", "Amber", "ArcanePlants", "Blizz", "BlueTopaz", "Chimerite", "Chrome", "Cinnabar", "ConductiveIron", "Creosote", "DarkIron", "ElectricalSteel", "Enderium", "EnergeticAlloy", "Ethanol", "Iridium", "LiquidEssence", "Manganese", "MoonStone", "NetherStar", "Nitor", "Osmium", "Plutonium", "Quicksilver", "Rubber", "Saltpeter", "Scrap", "Silicon", "StainlessSteel", "Steel", "Sulfur", "SunStone", "Thaumium", "Titanium", "Tungsten", "TungstenSteel", "VibrantAlloy", "Vinteum", "Zinc" };
    public static String[] names = new String[] { "Advanced Alloy", "Alumentum", "Amber", "Arcane Plants", "Blizz", "Blue Topaz", "Chimerite", "Chrome", "Cinnabar", "Conductive Iron", "Creosote Oil", "Dark Iron", "Electrical Steel", "Enderium", "Energetic Alloy", "Ethanol", "Iridium", "Liquid Essence", "Manganese", "Moonstone", "Nether Star", "Nitor", "Osmium", "Plutonium", "Quicksilver", "Rubber", "Saltpeter", "Scrap", "Silicon", "Stainless Steel", "Steel", "Sulfur", "Sunstone", "Thaumium", "Titanium", "Tungsten", "Tungsten Steel", "Vibrant Alloy", "Vinteum", "Zinc" };

    public static Item itemSeeds, itemEssences, itemMisc;
    public static Block[] crops = new Block[10];
    
    @EventHandler
    public void preLoad(FMLPreInitializationEvent event)
    {
        Configuration config = new Configuration(event.getSuggestedConfigurationFile());
        
        config.load();
        
        seedsID = config.get("Item IDs -  shifted!", "itemSeedsID", 24300).getInt(24300);
        essencesID = config.get("Item IDs -  shifted!", "itemEssecesID", 24301).getInt(24301);
        miscID = config.get("Item IDs -  shifted!", "itemMiscID", 24302).getInt(24302);
        
        for (int i = 0; i < 10; i++)
            cropsID[i] = config.get("Block IDs", "blockCrops" + i + "ID", 2430 + i).getInt(2430 + i);
                
        config.save();
        
        Configuration configMC = new Configuration(new File(event.getModConfigurationDirectory(), "magicalcrops.cfg"));
        
        config.load();
        
        secondSeedDropChance = configMC.get("general", "Change number between 1-100 for chance of getting second seed drop, 10 = 10%, 20 = 20%(default) and so on.", 20).getInt(20);
        
        config.save();
    }
    
    @EventHandler
    public void load(FMLInitializationEvent event)
    {
        tab = new CreativeTabs("tabEMC");
        
        itemSeeds = new ItemCollection(seedsID - 256, "seed");
        itemEssences = new ItemCollection(essencesID - 256, "essence");
        itemMisc = new ItemCollection(miscID - 256, "misc");

        FactoryRegistry.registerPlantable((IFactoryPlantable) itemSeeds);
        
        for (int i = 0; i < 10; i++)
        {
            crops[i] = new BlockCrops(cropsID[i], i);
            GameRegistry.registerBlock(crops[i], ItemBlockCrops.class, "crop" + i);
            FactoryRegistry.registerHarvestable((IFactoryHarvestable) crops[i]);
        }
        
        if (FMLCommonHandler.instance().getSide() == Side.CLIENT)
        {
            LanguageRegistry.instance().loadLocalization("assets/emc/lang/en_US.lang", "en_US", false);
            LanguageRegistry.instance().addStringLocalization("tile.blockMagicCrops.0.name", "Magic Crop Block");
            LanguageRegistry.instance().addStringLocalization("itemGroup.tabEMC", "Extra Magical Crops");
        }
    }
    
    @EventHandler
    public void modsLoaded(FMLPostInitializationEvent event)
    {
        ModItems.fetchItems();
        Recipes.registerRecipes();
    }
}
