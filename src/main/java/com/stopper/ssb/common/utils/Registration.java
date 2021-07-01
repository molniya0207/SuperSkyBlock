package com.stopper.ssb.common.utils;

import com.stopper.ssb.SuperSkyBlock;
import com.stopper.ssb.common.blocks.*;
import com.stopper.ssb.common.entities.*;
import com.stopper.ssb.common.items.*;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTier;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Registration {
    public AbstractBlock.Properties StandartBlockProperties = AbstractBlock.Properties.of(Material.METAL).harvestLevel(2).harvestTool(ToolType.PICKAXE).strength(4f).requiresCorrectToolForDrops();

    public final String MODID = "ssb";
    
    private final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public final RegistryObject<Block> DUST_GENERATOR_BLOCK = BLOCKS.register("dustgenblock", () -> new DustGenerator(StandartBlockProperties));
    public final RegistryObject<Block> CUSTOM_GENERATOR_BLOCK = BLOCKS.register("customgenblock", () -> new CustomGenerator(StandartBlockProperties));
    public final RegistryObject<Block> RAINBOW_GENERATOR_BLOCK = BLOCKS.register("rainbowgenblock", () -> new RainbowGenerator(StandartBlockProperties));
    public final RegistryObject<Block> MOLECULAR_I_BLOCK = BLOCKS.register("moleculariblock", () -> new Molecular1Block(StandartBlockProperties));
    public final RegistryObject<Block> MOLECULAR_II_BLOCK = BLOCKS.register("moleculariiblock", () -> new BaseBlock(StandartBlockProperties));
    public final RegistryObject<Block> MOLECULAR_III_BLOCK = BLOCKS.register("moleculariiiblock", () -> new BaseBlock(StandartBlockProperties));
    public final RegistryObject<Block> EXCHANGER_BLOCK = BLOCKS.register("exchangerblock", () -> new ExchangerBlock(StandartBlockProperties));
    public final RegistryObject<Block> STATIONARY_DIAMOND_ORE_GENERATOR_BLOCK = BLOCKS.register("stationarydiamondoregenerator", () -> new StationaryDiamondOreGeneratorBlock(StandartBlockProperties));
    public final RegistryObject<Block> DIAMOND_ANVIL_BLOCK = BLOCKS.register("diamondanvil", () -> new DiamondAnvilBlock(StandartBlockProperties.sound(SoundType.ANVIL)));
    public final RegistryObject<Block> CUSTOM2_GENERATOR_BLOCK = BLOCKS.register("custom2genblock", () -> new Custom2Generator(StandartBlockProperties));

    private final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, MODID);
    public final EntityType<ClownBoss> CLOWNBOSS_ENTITY_UNREG = EntityType.Builder.of(ClownBoss::new, EntityClassification.MONSTER).sized(1f, 3f).build("ssb:clownboss");
    public final EntityType<ClownTrader> CLOWNTRADER_ENTITY_UNREG = EntityType.Builder.of(ClownTrader::new, EntityClassification.CREATURE).sized(1f, 2f).build("ssb:clowntrader");
    public final EntityType<LexaLox> LEXALOX_ENTITY_UNREG = EntityType.Builder.of(LexaLox::new, EntityClassification.MONSTER).sized(1f, 0.5f).build("ssb:lexalox");
    public final EntityType<KillerHangBoss> KILLERHANG_ENTITY_UNREG = EntityType.Builder.of(KillerHangBoss::new, EntityClassification.MONSTER).sized(1f, 3f).build("ssb:killerhang");
    public final EntityType<DevilBoss> DEVILBOSS_ENTITY_UNREG = EntityType.Builder.of(DevilBoss::new, EntityClassification.MONSTER).sized(1f, 2f).build("ssb:devilboss");
    public final RegistryObject<EntityType<ClownBoss>> CLOWNBOSS_ENTITY = ENTITIES.register("clownboss", () -> CLOWNBOSS_ENTITY_UNREG);
    public final RegistryObject<EntityType<ClownTrader>> CLOWNTRADER_ENTITY = ENTITIES.register("clowntrader", () -> CLOWNTRADER_ENTITY_UNREG);
    public final RegistryObject<EntityType<LexaLox>> LEXALOX_ENTITY = ENTITIES.register("lexalox", () -> LEXALOX_ENTITY_UNREG);
    public final RegistryObject<EntityType<KillerHangBoss>> KILLERHANG_ENTITY = ENTITIES.register("killerhang", () -> KILLERHANG_ENTITY_UNREG);
    public final RegistryObject<EntityType<DevilBoss>> DEVILBOSS_ENTITY = ENTITIES.register("devilboss", () -> DEVILBOSS_ENTITY_UNREG);

    private final DeferredRegister<TileEntityType<?>> TILES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, MODID);
    public final RegistryObject<TileEntityType<DustGeneratorTile>> DUST_GENERATOR_TILE = TILES.register("dustgentile", () -> TileEntityType.Builder.of(DustGeneratorTile::new, DUST_GENERATOR_BLOCK.get()).build(null));
    public final RegistryObject<TileEntityType<CustomGeneratorTile>> CUSTOM_GENERATOR_TILE = TILES.register("customgentile", () -> TileEntityType.Builder.of(CustomGeneratorTile::new, CUSTOM_GENERATOR_BLOCK.get()).build(null));
    public final RegistryObject<TileEntityType<RainbowGeneratorTile>> RAINBOW_GENERATOR_TILE = TILES.register("rainbowgentile", () -> TileEntityType.Builder.of(RainbowGeneratorTile::new, RAINBOW_GENERATOR_BLOCK.get()).build(null));
    public final RegistryObject<TileEntityType<ExchangerBlockTile>> EXCHANGER_TILE = TILES.register("exchangertile", () -> TileEntityType.Builder.of(ExchangerBlockTile::new, EXCHANGER_BLOCK.get()).build(null));
    public final RegistryObject<TileEntityType<Molecular1Tile>> MOLECULAR_I_TILE = TILES.register("molecularitile", () -> TileEntityType.Builder.of(Molecular1Tile::new, MOLECULAR_I_BLOCK.get()).build(null));
    public final RegistryObject<TileEntityType<StationaryDiamondOreGeneratorTile>> STATIONARY_DIAMOND_ORE_GENERATOR_TILE = TILES.register("stationarydiamondoregeneratortile", () -> TileEntityType.Builder.of(StationaryDiamondOreGeneratorTile::new, STATIONARY_DIAMOND_ORE_GENERATOR_BLOCK.get()).build(null));
    public final RegistryObject<TileEntityType<DiamondAnvilTile>> DIAMOND_ANVIL_TILE = TILES.register("diamondanviltile", () -> TileEntityType.Builder.of(DiamondAnvilTile::new, DIAMOND_ANVIL_BLOCK.get()).build(null));
    public final RegistryObject<TileEntityType<Custom2GeneratorTile>> CUSTOM2_GENERATOR_TILE = TILES.register("custom2gentile", () -> TileEntityType.Builder.of(Custom2GeneratorTile::new, CUSTOM2_GENERATOR_BLOCK.get()).build(null));

    private final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public final RegistryObject<Item> INFORMATIVEEMPTY_ITEM = ITEMS.register("informativeempty", () -> new BaseItem("item.ssb.informativeempty", "message.ssb.informativeempty", new Item.Properties().tab(SuperSkyBlock.CreativeTab)));
    public final RegistryObject<Item> GREENSTONE_ITEM = ITEMS.register("greenstone", () -> new BaseItem("item.ssb.greenstone", "message.ssb.greenstone", new Item.Properties().tab(SuperSkyBlock.CreativeTab)));
    public final RegistryObject<Item> PURPLESTONE_ITEM = ITEMS.register("purplestone", () -> new BaseItem("item.ssb.purplestone", "message.ssb.purplestone", new Item.Properties().tab(SuperSkyBlock.CreativeTab)));
    public final RegistryObject<Item> FIRESTONE_ITEM = ITEMS.register("firestone", () -> new FireDust("item.ssb.firestone", "message.ssb.firestone", new Item.Properties().tab(SuperSkyBlock.CreativeTab)));
    public final RegistryObject<Item> RAINBOWSTONE_ITEM = ITEMS.register("rainbowstone", () -> new BaseItem("item.ssb.rainbowstone", "message.ssb.rainbowstone", new Item.Properties().tab(SuperSkyBlock.CreativeTab)));
    public final RegistryObject<Item> DUST_GENERATOR_ITEM = ITEMS.register("dustgenitem", () -> new BaseBlockItem("item.ssb.dustgen", "message.ssb.dustgen", DUST_GENERATOR_BLOCK.get(), new Item.Properties().tab(SuperSkyBlock.CreativeTab)));
    public final RegistryObject<Item> CUSTOM_GENERATOR_ITEM = ITEMS.register("customgenitem", () -> new BaseBlockItem("item.ssb.customgen", "message.ssb.customgen", CUSTOM_GENERATOR_BLOCK.get(), new Item.Properties().tab(SuperSkyBlock.CreativeTab)));
    public final RegistryObject<Item> RAINBOW_GENERATOR_ITEM = ITEMS.register("rainbowgenitem", () -> new BaseBlockItem("item.ssb.rainbowgen", "message.ssb.rainbowgen", RAINBOW_GENERATOR_BLOCK.get(), new Item.Properties().tab(SuperSkyBlock.CreativeTab)));
    public final RegistryObject<Item> MOLECULAR_I_ITEM = ITEMS.register("moleculariitem", () -> new BaseBlockItem("item.ssb.moleculari", "message.ssb.moleculari", MOLECULAR_I_BLOCK.get(), new Item.Properties().tab(SuperSkyBlock.CreativeTab)));
    public final RegistryObject<Item> MOLECULAR_II_ITEM = ITEMS.register("moleculariiitem", () -> new BaseBlockItem("item.ssb.molecularii", "message.ssb.molecularii", MOLECULAR_II_BLOCK.get(), new Item.Properties().tab(SuperSkyBlock.CreativeTab)));
    public final RegistryObject<Item> MOLECULAR_III_ITEM = ITEMS.register("moleculariiiitem", () -> new BaseBlockItem("item.ssb.moleculariii", "message.ssb.moleculariii", MOLECULAR_III_BLOCK.get(), new Item.Properties().tab(SuperSkyBlock.CreativeTab)));
    public final RegistryObject<Item> CLOWNMASK_ITEM = ITEMS.register("clownmask_head", () -> new ClownMask("item.ssb.clownmask", "message.ssb.clownmask", new ClownMaskArmorMaterial(), EquipmentSlotType.HEAD, new Item.Properties().tab(SuperSkyBlock.CreativeTab)));
    public final RegistryObject<Item> CLOWNSPAWN_ITEM = ITEMS.register("clownspawn", () -> new BossSummonItem("item.ssb.clownspawn", "message.ssb.clownspawn", 1, new Item.Properties().tab(SuperSkyBlock.CreativeTab)));
    public final RegistryObject<Item> BOSSESSENCE1_ITEM = ITEMS.register("bossessence1", () -> new BaseItem("item.ssb.bossessence1", "message.ssb.bossessence1", new Item.Properties().tab(SuperSkyBlock.CreativeTab)));
    public final RegistryObject<Item> BOSSESSENCE2_ITEM = ITEMS.register("bossessence2", () -> new BaseItem("item.ssb.bossessence2", "message.ssb.bossessence2", new Item.Properties().tab(SuperSkyBlock.CreativeTab)));
    public final RegistryObject<Item> BOSSESSENCE3_ITEM = ITEMS.register("bossessence3", () -> new BaseItem("item.ssb.bossessence3", "message.ssb.bossessence3", new Item.Properties().tab(SuperSkyBlock.CreativeTab)));
    public final RegistryObject<Item> GOLDENCOIN_ITEM = ITEMS.register("goldencoin", () -> new BaseItem("item.ssb.goldencoin", "message.ssb.goldencoin", new Item.Properties().tab(SuperSkyBlock.CreativeTab)));
    public final RegistryObject<Item> SILVERCOIN_ITEM = ITEMS.register("silvercoin", () -> new BaseItem("item.ssb.silvercoin", "message.ssb.silvercoin", new Item.Properties().tab(SuperSkyBlock.CreativeTab)));
    public final RegistryObject<Item> CLOWNSIGN_ITEM = ITEMS.register("clownsign", () -> new BaseTool("item.ssb.clownsign", "message.ssb.clownsign", 11f, -3f, ItemTier.DIAMOND, new Item.Properties().tab(SuperSkyBlock.CreativeTab)));
    public final RegistryObject<Item> HANGJAW_ITEM = ITEMS.register("hangjaw", () -> new BaseItem("item.ssb.hangjaw", "message.ssb.hangjaw", new Item.Properties().tab(SuperSkyBlock.CreativeTab)));
    public final RegistryObject<Item> DEATHTOTEM_ITEM = ITEMS.register("deathtotem", () -> new BossSummonItem("item.ssb.deathtotem", "message.ssb.deathtotem", 2, new Item.Properties().tab(SuperSkyBlock.CreativeTab)));
    public final RegistryObject<Item> CE_BODY_ITEM = ITEMS.register("ce_body", () -> new ClownEssenceArmor("item.ssb.ce_body", "message.ssb.ce_body", new ClownEssenceArmorMaterial(), EquipmentSlotType.CHEST, new Item.Properties().tab(SuperSkyBlock.CreativeTab)));
    public final RegistryObject<Item> CE_LEGS_ITEM = ITEMS.register("ce_legs", () -> new ClownEssenceArmor("item.ssb.ce_legs", "message.ssb.ce_legs", new ClownEssenceArmorMaterial(), EquipmentSlotType.LEGS, new Item.Properties().tab(SuperSkyBlock.CreativeTab)));
    public final RegistryObject<Item> CE_BOOTS_ITEM = ITEMS.register("ce_boots", () -> new ClownEssenceArmor("item.ssb.ce_boots", "message.ssb.ce_boots", new ClownEssenceArmorMaterial(), EquipmentSlotType.FEET, new Item.Properties().tab(SuperSkyBlock.CreativeTab)));
    public final RegistryObject<Item> HANGKATANA_ITEM = ITEMS.register("hangkatana", () -> new BaseTool("item.ssb.hangkatana", "message.ssb.hangkatana", 16f, -3f, ItemTier.NETHERITE, new Item.Properties().tab(SuperSkyBlock.CreativeTab)));
    public final RegistryObject<Item> HANGGLASSES_ITEM = ITEMS.register("hangglasses", () -> new HangGlasses("item.ssb.hangglasses", "message.ssb.hangglasses", new HangGlassesArmorMaterial(), EquipmentSlotType.HEAD, new Item.Properties().tab(SuperSkyBlock.CreativeTab)));
    public final RegistryObject<Item> CE2_BODY_ITEM = ITEMS.register("ce2_body", () -> new ClownEssenceArmor("item.ssb.ce2_body", "message.ssb.ce2_body", new HangEssenceArmorMaterial(), EquipmentSlotType.CHEST, new Item.Properties().tab(SuperSkyBlock.CreativeTab)));
    public final RegistryObject<Item> CE2_LEGS_ITEM = ITEMS.register("ce2_legs", () -> new ClownEssenceArmor("item.ssb.ce2_legs", "message.ssb.ce2_legs", new HangEssenceArmorMaterial(), EquipmentSlotType.LEGS, new Item.Properties().tab(SuperSkyBlock.CreativeTab)));
    public final RegistryObject<Item> CE2_BOOTS_ITEM = ITEMS.register("ce2_boots", () -> new ClownEssenceArmor("item.ssb.ce2_boots", "message.ssb.ce2_boots", new HangEssenceArmorMaterial(), EquipmentSlotType.FEET, new Item.Properties().tab(SuperSkyBlock.CreativeTab)));
    public final RegistryObject<Item> EXCHANGER_BLOCK_ITEM = ITEMS.register("exchangerblockitem", () -> new BaseBlockItem("item.ssb.exchangerblockitem", "message.ssb.exchangerblockitem", EXCHANGER_BLOCK.get(), new Item.Properties().tab(SuperSkyBlock.CreativeTab)));
    public final RegistryObject<Item> MASKWITHGLASSES_ITEM = ITEMS.register("mwglasses", () -> new MaskWithGlasses("item.ssb.mwglasses", "message.ssb.mwglasses", new MaskWithGlassesArmorMaterial(), EquipmentSlotType.HEAD, new Item.Properties().tab(SuperSkyBlock.CreativeTab)));
    public final RegistryObject<Item> PURPLEPOWDER_ITEM = ITEMS.register("purplepowder", () -> new BaseItem("item.ssb.purplepowder", "message.ssb.purplepowder", new Item.Properties().tab(SuperSkyBlock.CreativeTab)));
    public final RegistryObject<Item> STATIONARY_DIAMOND_ORE_GENERATOR_ITEM = ITEMS.register("stationarydiamondoregeneratoritem", () -> new BaseBlockItem("item.ssb.stationarydiamondoregeneratoritem", "message.ssb.stationarydiamondoregeneratoritem", STATIONARY_DIAMOND_ORE_GENERATOR_BLOCK.get(), new Item.Properties().tab(SuperSkyBlock.CreativeTab)));
    public final RegistryObject<Item> DIAMOND_ANVIL_ITEM = ITEMS.register("diamondanvilitem", () -> new BaseBlockItem("item.ssb.diamondanvilitem", "message.ssb.diamondanvilitem", DIAMOND_ANVIL_BLOCK.get(), new Item.Properties().tab(SuperSkyBlock.CreativeTab)));
    public final RegistryObject<Item> CUSTOM2_GENERATOR_ITEM = ITEMS.register("custom2genitem", () -> new BaseBlockItem("item.ssb.custom2gen", "message.ssb.custom2gen", CUSTOM2_GENERATOR_BLOCK.get(), new Item.Properties().tab(SuperSkyBlock.CreativeTab)));
    public final RegistryObject<Item> ULTIMATE_HANGKATANA_ITEM = ITEMS.register("ultimatehangkatana", () -> new BaseTool("item.ssb.ultimatehangkatana", "message.ssb.ultimatehangkatana", 27f, -3f, ItemTier.NETHERITE, new Item.Properties().fireResistant().tab(SuperSkyBlock.CreativeTab)));
    public final RegistryObject<Item> CLOWNTRADERSUMMON_ITEM = ITEMS.register("clowntradersummon", () -> new BossSummonItem("item.ssb.clowntradersummon", "message.ssb.clowntradersummon", 0, new Item.Properties().tab(SuperSkyBlock.CreativeTab)));
    public final RegistryObject<Item> DEVILSPAWN_ITEM = ITEMS.register("devilspawn", () -> new BossSummonItem("item.ssb.devilspawn", "message.ssb.devilspawn", 3, new Item.Properties().tab(SuperSkyBlock.CreativeTab)));
    public final RegistryObject<Item> DEVILMASK_ITEM = ITEMS.register("devilmask_head", () -> new DevilMask("item.ssb.devilmask", "message.ssb.devilmask", new DevilMaskArmorMaterial(), EquipmentSlotType.HEAD, new Item.Properties().tab(SuperSkyBlock.CreativeTab)));

    public void init() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
        TILES.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
