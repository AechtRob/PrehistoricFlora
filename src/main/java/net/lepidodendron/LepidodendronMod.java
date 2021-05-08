/*
 *    MCreator note:
 *
 *    If you lock base mod element files, you can edit this file and the proxy files
 *    and they won't get overwritten. If you change your mod package or modid, you
 *    need to apply these changes to this file MANUALLY.
 *
 *    Settings in @Mod annotation WON'T be changed in case of the base mod element
 *    files lock too, so you need to set them manually here in such case.
 *
 *    Keep the ElementsLepidodendronMod object in this class and all calls to this object
 *    INTACT in order to preserve functionality of mod elements generated by MCreator.
 *
 *    If you do not lock base mod element files in Workspace settings, this file
 *    will be REGENERATED on each build.
 *
 */
package net.lepidodendron;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.biome.Biome;
import net.minecraft.potion.Potion;
import net.minecraft.item.Item;
import net.minecraft.block.Block;

import java.util.function.Supplier;

@Mod(modid = LepidodendronMod.MODID, name = LepidodendronMod.NAME, version = LepidodendronMod.VERSION, dependencies = "required-after:llibrary@[1.7.17,)")
public class LepidodendronMod {
	public static final String MODID = "lepidodendron";
	public static final String NAME = "Prehistoric Flora";
	public static final String VERSION = "47.0";
	public static final SimpleNetworkWrapper PACKET_HANDLER = NetworkRegistry.INSTANCE.newSimpleChannel("lepidodendron:a");
	@SidedProxy(clientSide = "net.lepidodendron.ClientProxyLepidodendronMod", serverSide = "net.lepidodendron.ServerProxyLepidodendronMod")
	public static IProxyLepidodendronMod proxy;
	@Mod.Instance(MODID)
	public static LepidodendronMod instance;
	public ElementsLepidodendronMod elements = new ElementsLepidodendronMod();

	public static final int ENTITY_WALLISEROPS = 1;
	public static final ResourceLocation WALLISEROPS_LOOT = LootTableList.register(new ResourceLocation(LepidodendronMod.MODID, "entity/walliserops"));
	public static final int ENTITY_PNEUMODESMUS = 2;
	public static final int ENTITY_CHEIRURUS = 3;
	public static final ResourceLocation CHEIRURUS_LOOT = LootTableList.register(new ResourceLocation(LepidodendronMod.MODID, "entity/cheirurus"));
	public static final int ENTITY_ISOTELUS = 4;
	public static final ResourceLocation ISOTELUS_LOOT = LootTableList.register(new ResourceLocation(LepidodendronMod.MODID, "entity/isotelus"));
	public static final int ENTITY_ASAPHUS = 5;
	public static final ResourceLocation ASAPHUS_LOOT = LootTableList.register(new ResourceLocation(LepidodendronMod.MODID, "entity/asaphus"));
	public static final int ENTITY_PROMISSUM = 6;
	public static final ResourceLocation PROMISSUM_LOOT = LootTableList.register(new ResourceLocation(LepidodendronMod.MODID, "entity/promissum"));
	public static final int ENTITY_ACANTHODES = 7;
	public static final ResourceLocation ACANTHODES_LOOT = LootTableList.register(new ResourceLocation(LepidodendronMod.MODID, "entity/acanthodes"));
	public static final int ENTITY_JELLYFISH1 = 8;
	public static final int ENTITY_JELLYFISH2 = 9;
	public static final int ENTITY_JELLYFISH3 = 10;
	public static final int ENTITY_JELLYFISH4 = 11;
	public static final int ENTITY_JELLYFISH5 = 12;
	public static final int ENTITY_JELLYFISH6 = 13;
	public static final int ENTITY_JELLYFISH7 = 14;
	public static final int ENTITY_BOTHRIOLEPIS = 15;
	public static final ResourceLocation BOTHRIOLEPIS_LOOT = LootTableList.register(new ResourceLocation(LepidodendronMod.MODID, "entity/bothriolepis"));
	public static final int ENTITY_EURYPTERUS = 16;
	public static final ResourceLocation EURYPTERUS_LOOT = LootTableList.register(new ResourceLocation(LepidodendronMod.MODID, "entity/eurypterus"));
	public static final int ENTITY_PTERASPIS = 17;
	public static final ResourceLocation PTERASPIS_LOOT = LootTableList.register(new ResourceLocation(LepidodendronMod.MODID, "entity/pteraspis"));
	public static final int ENTITY_CYRTOCERAS = 18;
	public static final ResourceLocation CYRTOCERAS_LOOT = LootTableList.register(new ResourceLocation(LepidodendronMod.MODID, "entity/cyrtoceras"));
	public static final int ENTITY_ARANDASPIS = 19;
	public static final ResourceLocation ARANDASPIS_LOOT = LootTableList.register(new ResourceLocation(LepidodendronMod.MODID, "entity/arandaspis"));
	public static final int ENTITY_ANTHRACOMEDUSA = 20;
	public static final int ENTITY_LIMNOSCELIS = 21;
	public static final int ENTITY_SACABAMBASPIS = 22;
	public static final ResourceLocation SACABAMBASPIS_LOOT = LootTableList.register(new ResourceLocation(LepidodendronMod.MODID, "entity/sacabambaspis"));
	public static final int ENTITY_HIBERNASPIS = 23;
	public static final ResourceLocation HIBERNASPIS_LOOT = LootTableList.register(new ResourceLocation(LepidodendronMod.MODID, "entity/hibernaspis"));
	public static final int ENTITY_EOARTHROPLEURA = 24;
	public static final int ENTITY_AMMONITE_MANTICOCERAS = 25;
	public static final int ENTITY_AMMONITE_GONIATITES = 26;
	public static final int ENTITY_AMMONITE_CYLOLOBUS = 27;
	public static final int ENTITY_AMMONITE_PARAPUZOSIA = 28;
	public static final int ENTITY_AMMONITE_DACTYLIOCERAS = 29;
	public static final int ENTITY_AMMONITE_TITANITES = 30;
	public static final int ENTITY_AMMONITE_ASTEROCERAS  = 31;
	public static final int ENTITY_AMMONITE_PACHYDESMOCERAS  = 32;
	public static final int ENTITY_AMMONITE_PACHYDISCUS  = 33;
	public static final int ENTITY_AMMONITE_CORONICERAS = 34;
	public static final int ENTITY_AMMONITE_CERATITES = 35;
	public static final ResourceLocation AMMONITE_LOOT = LootTableList.register(new ResourceLocation(LepidodendronMod.MODID, "entity/ammonite"));
	public static final int ENTITY_HIBBERTOPTERUS = 36;
	public static final ResourceLocation HIBBERTOPTERUS_LOOT = LootTableList.register(new ResourceLocation(LepidodendronMod.MODID, "entity/hibbertopterus"));
	public static final int ENTITY_TERATASPIS = 37;
	public static final ResourceLocation TERATASPIS_LOOT = LootTableList.register(new ResourceLocation(LepidodendronMod.MODID, "entity/terataspis"));
	public static final int ENTITY_FURCACAUDA = 38;
	public static final ResourceLocation FURCACAUDA_LOOT = LootTableList.register(new ResourceLocation(LepidodendronMod.MODID, "entity/furcacauda"));
	public static final int ENTITY_SQUATINACTIS = 39;
	public static final ResourceLocation SQUATINACTIS_LOOT = LootTableList.register(new ResourceLocation(LepidodendronMod.MODID, "entity/squatinactis"));
	public static final int ENTITY_PALAEODICTYOPTERA_NYMPH = 40;
	public static final int ENTITY_QILINYU = 41;
	public static final ResourceLocation QILINYU_LOOT = LootTableList.register(new ResourceLocation(LepidodendronMod.MODID, "entity/qilinyu"));
	public static final int ENTITY_PORASPIS = 42;
	public static final ResourceLocation PORASPIS_LOOT = LootTableList.register(new ResourceLocation(LepidodendronMod.MODID, "entity/poraspis"));
	public static final int ENTITY_APHETOCERAS  = 43;
	public static final ResourceLocation APHETOCERAS_LOOT = LootTableList.register(new ResourceLocation(LepidodendronMod.MODID, "entity/aphetoceras"));
	public static final int ENTITY_ENDOCERAS = 44;
	public static final ResourceLocation ENDOCERAS_LOOT = LootTableList.register(new ResourceLocation(LepidodendronMod.MODID, "entity/endoceras"));
	public static final int ENTITY_CAMEROCERAS = 45;
	public static final ResourceLocation CAMEROCERAS_LOOT = LootTableList.register(new ResourceLocation(LepidodendronMod.MODID, "entity/cameroceras"));
	public static final int ENTITY_ORTHOCERAS = 46;
	public static final ResourceLocation ORTHOCERAS_LOOT = LootTableList.register(new ResourceLocation(LepidodendronMod.MODID, "entity/orthoceras"));
	public static final int ENTITY_PALAEODICTYOPTERA_DELITZSCHALA = 47;
	public static final int ENTITY_PALAEODICTYOPTERA_DUNBARIA = 48;
	public static final int ENTITY_PALAEODICTYOPTERA_HOMALONEURA = 49;
	public static final int ENTITY_PALAEODICTYOPTERA_HOMOIOPTERA = 50;
	public static final int ENTITY_PALAEODICTYOPTERA_LITHOMANTIS = 51;
	public static final int ENTITY_PALAEODICTYOPTERA_LYCOCERCUS = 52;
	public static final int ENTITY_PALAEODICTYOPTERA_SINODUNBARIA = 53;
	public static final int ENTITY_PALAEODICTYOPTERA_STENODICTYA = 54;
	public static final ResourceLocation PALAEODICTYOPTERA_LOOT = LootTableList.register(new ResourceLocation(LepidodendronMod.MODID, "entity/palaeodictyoptera"));
	public static final int ENTITY_JELLYFISH_PRECAMBRIAN = 55;
	public static final int ENTITY_SCHINDERHANNES = 56;
	public static final ResourceLocation SCHINDERHANNES_LOOT = LootTableList.register(new ResourceLocation(LepidodendronMod.MODID, "entity/schinderhannes"));
	public static final int ENTITY_TITANICTHYS = 57;


	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		LepidodendronConfig.load(event);
		MinecraftForge.EVENT_BUS.register(this);
		GameRegistry.registerWorldGenerator(elements, 5);
		GameRegistry.registerFuelHandler(elements);
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new ElementsLepidodendronMod.GuiHandler());
		elements.preInit(event);
		MinecraftForge.EVENT_BUS.register(elements);
		elements.getElements().forEach(element -> element.preInit(event));
		EntityRegistries.registerEntities();
		proxy.preInit(event);
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		elements.getElements().forEach(element -> element.init(event));
		proxy.init(event);
		MinecraftForge.TERRAIN_GEN_BUS.register(new LepidodendronDecorationHandler());
		//MinecraftForge.EVENT_BUS.register(new LepidodendronDecorationHandler());
		MinecraftForge.ORE_GEN_BUS.register(new LepidodendronOreHandler());
		MinecraftForge.EVENT_BUS.register(new LepidodendronDimensionHandler());
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit(event);
	}

	@Mod.EventHandler
	public void serverLoad(FMLServerStartingEvent event) {
		elements.getElements().forEach(element -> element.serverLoad(event));
		proxy.serverLoad(event);
	}

	@SubscribeEvent
	public void registerBlocks(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(elements.getBlocks().stream().map(Supplier::get).toArray(Block[]::new));
	}

	@SubscribeEvent
	public void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(elements.getItems().stream().map(Supplier::get).toArray(Item[]::new));
	}

	@SubscribeEvent
	public void registerBiomes(RegistryEvent.Register<Biome> event) {
		event.getRegistry().registerAll(elements.getBiomes().stream().map(Supplier::get).toArray(Biome[]::new));
	}

	@SubscribeEvent
	public void registerEntities(RegistryEvent.Register<EntityEntry> event) {
		event.getRegistry().registerAll(elements.getEntities().stream().map(Supplier::get).toArray(EntityEntry[]::new));
	}

	@SubscribeEvent
	public void registerPotions(RegistryEvent.Register<Potion> event) {
		event.getRegistry().registerAll(elements.getPotions().stream().map(Supplier::get).toArray(Potion[]::new));
	}

	@SubscribeEvent
	public void registerSounds(RegistryEvent.Register<net.minecraft.util.SoundEvent> event) {
		elements.registerSounds(event);
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		elements.getElements().forEach(element -> element.registerModels(event));
	}
	static {
		FluidRegistry.enableUniversalBucket();
	}
}
