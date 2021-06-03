package com.stopper.ssb;

import com.stopper.ssb.client.entity.renderer.ClownBossRenderer;
import com.stopper.ssb.client.entity.renderer.ClownTraderRenderer;
import com.stopper.ssb.client.entity.renderer.KillerHangRenderer;
import com.stopper.ssb.client.entity.renderer.LexaLoxRenderer;
import com.stopper.ssb.common.blocks.*;
import com.stopper.ssb.common.entities.ClownBoss;
import com.stopper.ssb.common.entities.ClownTrader;
import com.stopper.ssb.common.entities.KillerHangBoss;
import com.stopper.ssb.common.entities.LexaLox;
import com.stopper.ssb.common.items.*;
import com.stopper.ssb.common.utils.*;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nullable;

@Mod("ssb")
public class SuperSkyBlock
{
    private static final Logger LOGGER = LogManager.getLogger();

    public static final SSBTab CreativeTab = new SSBTab("superskyblock");

    public static AbstractBlock.Properties StandartBlockProperties = AbstractBlock.Properties.of(Material.METAL).harvestLevel(2).harvestTool(ToolType.PICKAXE).strength(4f);

    public static final String MODID = "ssb";
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    //public static final RegistryObject<Block> BASE_GENERATOR_BLOCK = BLOCKS.register("basegenblock", () -> new BaseGenerator());
    public static final RegistryObject<Block> DUST_GENERATOR_BLOCK = BLOCKS.register("dustgenblock", () -> new DustGenerator(StandartBlockProperties));
    public static final RegistryObject<Block> CUSTOM_GENERATOR_BLOCK = BLOCKS.register("customgenblock", () -> new CustomGenerator(StandartBlockProperties));
    public static final RegistryObject<Block> MOLECULAR_I_BLOCK = BLOCKS.register("moleculariblock", () -> new Molecular1Block(StandartBlockProperties));
    public static final RegistryObject<Block> MOLECULAR_II_BLOCK = BLOCKS.register("moleculariiblock", () -> new BaseBlock(StandartBlockProperties));
    public static final RegistryObject<Block> MOLECULAR_III_BLOCK = BLOCKS.register("moleculariiiblock", () -> new BaseBlock(StandartBlockProperties));
    public static final RegistryObject<Block> EXCHANGER_BLOCK = BLOCKS.register("exchangerblock", () -> new ExchangerBlock(StandartBlockProperties));
    public static final RegistryObject<Block> STATIONARY_DIAMOND_ORE_GENERATOR_BLOCK = BLOCKS.register("stationarydiamondoregenerator", () -> new StationaryDiamondOreGeneratorBlock(StandartBlockProperties));

    private static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, MODID);
    public static final RegistryObject<EntityType<ClownBoss>> CLOWNBOSS_ENTITY = ENTITIES.register("clownboss", () -> EntityType.Builder.of(ClownBoss::new, EntityClassification.MONSTER).sized(1f, 3f).build("ssb:clownboss"));
    public static final RegistryObject<EntityType<ClownTrader>> CLOWNTRADER_ENTITY = ENTITIES.register("clowntrader", () -> EntityType.Builder.of(ClownTrader::new, EntityClassification.CREATURE).sized(1f, 2f).build("ssb:clowntrader"));
    public static final RegistryObject<EntityType<LexaLox>> LEXALOX_ENTITY = ENTITIES.register("lexalox", () -> EntityType.Builder.of(LexaLox::new, EntityClassification.MONSTER).sized(1f, 0.5f).build("ssb:lexalox"));
    public static final RegistryObject<EntityType<KillerHangBoss>> KILLERHANG_ENTITY = ENTITIES.register("killerhang", () -> EntityType.Builder.of(KillerHangBoss::new, EntityClassification.MONSTER).sized(1f, 3f).build("ssb:killerhang"));

    private static final DeferredRegister<TileEntityType<?>> TILES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, MODID);
    public static final RegistryObject<TileEntityType<DustGeneratorTile>> DUST_GENERATOR_TILE = TILES.register("dustgentile", () -> TileEntityType.Builder.of(DustGeneratorTile::new, DUST_GENERATOR_BLOCK.get()).build(null));
    public static final RegistryObject<TileEntityType<CustomGeneratorTile>> CUSTOM_GENERATOR_TILE = TILES.register("customgentile", () -> TileEntityType.Builder.of(CustomGeneratorTile::new, CUSTOM_GENERATOR_BLOCK.get()).build(null));
    public static final RegistryObject<TileEntityType<ExchangerBlockTile>> EXCHANGER_TILE = TILES.register("exchangertile", () -> TileEntityType.Builder.of(ExchangerBlockTile::new, EXCHANGER_BLOCK.get()).build(null));
    public static final RegistryObject<TileEntityType<Molecular1Tile>> MOLECULAR_I_TILE = TILES.register("molecularitile", () -> TileEntityType.Builder.of(Molecular1Tile::new, MOLECULAR_I_BLOCK.get()).build(null));
    public static final RegistryObject<TileEntityType<StationaryDiamondOreGeneratorTile>> STATIONARY_DIAMOND_ORE_GENERATOR_TILE = TILES.register("stationarydiamondoregeneratortile", () -> TileEntityType.Builder.of(StationaryDiamondOreGeneratorTile::new, STATIONARY_DIAMOND_ORE_GENERATOR_BLOCK.get()).build(null));

    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static final RegistryObject<Item> INFORMATIVEEMPTY_ITEM = ITEMS.register("informativeempty", () -> new BaseItem("item.ssb.informativeempty", "message.ssb.informativeempty", new Item.Properties().tab(CreativeTab)));
    public static final RegistryObject<Item> GREENSTONE_ITEM = ITEMS.register("greenstone", () -> new BaseItem("item.ssb.greenstone", "message.ssb.greenstone", new Item.Properties().tab(CreativeTab)));
    public static final RegistryObject<Item> PURPLESTONE_ITEM = ITEMS.register("purplestone", () -> new BaseItem("item.ssb.purplestone", "message.ssb.purplestone", new Item.Properties().tab(CreativeTab)));
    public static final RegistryObject<Item> FIRESTONE_ITEM = ITEMS.register("firestone", () -> new FireDust("item.ssb.firestone", "message.ssb.firestone", new Item.Properties().tab(CreativeTab)));
    public static final RegistryObject<Item> RAINBOWSTONE_ITEM = ITEMS.register("rainbowstone", () -> new BaseItem("item.ssb.rainbowstone", "message.ssb.rainbowstone", new Item.Properties().tab(CreativeTab)));
    public static final RegistryObject<Item> DUST_GENERATOR_ITEM = ITEMS.register("dustgenitem", () -> new BaseBlockItem("item.ssb.dustgen", "message.ssb.dustgen", DUST_GENERATOR_BLOCK.get(), new Item.Properties().tab(CreativeTab)));
    public static final RegistryObject<Item> CUSTOM_GENERATOR_ITEM = ITEMS.register("customgenitem", () -> new BaseBlockItem("item.ssb.customgen", "message.ssb.customgen", CUSTOM_GENERATOR_BLOCK.get(), new Item.Properties().tab(CreativeTab)));
    public static final RegistryObject<Item> MOLECULAR_I_ITEM = ITEMS.register("moleculariitem", () -> new BaseBlockItem("item.ssb.moleculari", "message.ssb.moleculari", MOLECULAR_I_BLOCK.get(), new Item.Properties().tab(CreativeTab)));
    public static final RegistryObject<Item> MOLECULAR_II_ITEM = ITEMS.register("moleculariiitem", () -> new BaseBlockItem("item.ssb.molecularii", "message.ssb.molecularii", MOLECULAR_II_BLOCK.get(), new Item.Properties().tab(CreativeTab)));
    public static final RegistryObject<Item> MOLECULAR_III_ITEM = ITEMS.register("moleculariiiitem", () -> new BaseBlockItem("item.ssb.moleculariii", "message.ssb.moleculariii", MOLECULAR_III_BLOCK.get(), new Item.Properties().tab(CreativeTab)));
    public static final RegistryObject<Item> CLOWNMASK_ITEM = ITEMS.register("clownmask_head", () -> new ClownMask("item.ssb.clownmask", "message.ssb.clownmask", new ClownMaskArmorMaterial(), EquipmentSlotType.HEAD, new Item.Properties().tab(CreativeTab)));
    //public static final RegistryObject<Item> CLOWNSPAWN_ITEM = ITEMS.register("clownspawn", () -> new BossSummonItem("item.ssb.clownspawn", "message.ssb.clownspawn", CLOWNBOSS_ENTITY.get(), new Item.Properties().tab(CreativeTab)));
    public static final RegistryObject<Item> CLOWNSPAWN_ITEM = ITEMS.register("clownspawn", () -> new BaseItem("item.ssb.clownspawn", "message.ssb.clownspawn", new Item.Properties().tab(CreativeTab)));
    public static final RegistryObject<Item> BOSSESSENCE1_ITEM = ITEMS.register("bossessence1", () -> new BaseItem("item.ssb.bossessence1", "message.ssb.bossessence1", new Item.Properties().tab(CreativeTab)));
    public static final RegistryObject<Item> BOSSESSENCE2_ITEM = ITEMS.register("bossessence2", () -> new BaseItem("item.ssb.bossessence2", "message.ssb.bossessence2", new Item.Properties().tab(CreativeTab)));
    public static final RegistryObject<Item> BOSSESSENCE3_ITEM = ITEMS.register("bossessence3", () -> new BaseItem("item.ssb.bossessence3", "message.ssb.bossessence3", new Item.Properties().tab(CreativeTab)));
    public static final RegistryObject<Item> GOLDENCOIN_ITEM = ITEMS.register("goldencoin", () -> new BaseItem("item.ssb.goldencoin", "message.ssb.goldencoin", new Item.Properties().tab(CreativeTab)));
    public static final RegistryObject<Item> SILVERCOIN_ITEM = ITEMS.register("silvercoin", () -> new BaseItem("item.ssb.silvercoin", "message.ssb.silvercoin", new Item.Properties().tab(CreativeTab)));
    public static final RegistryObject<Item> CLOWNSIGN_ITEM = ITEMS.register("clownsign", () -> new BaseTool("item.ssb.clownsign", "message.ssb.clownsign", 11f, -3f, ItemTier.DIAMOND, new Item.Properties().tab(CreativeTab)));
    public static final RegistryObject<Item> HANGJAW_ITEM = ITEMS.register("hangjaw", () -> new BaseItem("item.ssb.hangjaw", "message.ssb.hangjaw", new Item.Properties().tab(CreativeTab)));
    //public static final RegistryObject<Item> DEATHTOTEM_ITEM = ITEMS.register("deathtotem", () -> new BossSummonItem("item.ssb.deathtotem", "message.ssb.deathtotem", KILLERHANG_ENTITY.get(), new Item.Properties().tab(CreativeTab)));
    public static final RegistryObject<Item> DEATHTOTEM_ITEM = ITEMS.register("deathtotem", () -> new BaseItem("item.ssb.deathtotem", "message.ssb.deathtotem", new Item.Properties().tab(CreativeTab)));
    public static final RegistryObject<Item> CE_BODY_ITEM = ITEMS.register("ce_body", () -> new ClownEssenceArmor("item.ssb.ce_body", "message.ssb.ce_body", new ClownEssenceArmorMaterial(), EquipmentSlotType.CHEST, new Item.Properties().tab(CreativeTab)));
    public static final RegistryObject<Item> CE_LEGS_ITEM = ITEMS.register("ce_legs", () -> new ClownEssenceArmor("item.ssb.ce_legs", "message.ssb.ce_legs", new ClownEssenceArmorMaterial(), EquipmentSlotType.LEGS, new Item.Properties().tab(CreativeTab)));
    public static final RegistryObject<Item> CE_BOOTS_ITEM = ITEMS.register("ce_boots", () -> new ClownEssenceArmor("item.ssb.ce_boots", "message.ssb.ce_boots", new ClownEssenceArmorMaterial(), EquipmentSlotType.FEET, new Item.Properties().tab(CreativeTab)));
    public static final RegistryObject<Item> HANGKATANA_ITEM = ITEMS.register("hangkatana", () -> new BaseTool("item.ssb.hangkatana", "message.ssb.hangkatana", 16f, -3f, ItemTier.NETHERITE, new Item.Properties().tab(CreativeTab)));
    public static final RegistryObject<Item> HANGGLASSES_ITEM = ITEMS.register("hangglasses", () -> new HangGlasses("item.ssb.hangglasses", "message.ssb.hangglasses", new HangGlassesArmorMaterial(), EquipmentSlotType.HEAD, new Item.Properties().tab(CreativeTab)));
    public static final RegistryObject<Item> CE2_BODY_ITEM = ITEMS.register("ce2_body", () -> new ClownEssenceArmor("item.ssb.ce2_body", "message.ssb.ce2_body", new HangEssenceArmorMaterial(), EquipmentSlotType.CHEST, new Item.Properties().tab(CreativeTab)));
    public static final RegistryObject<Item> CE2_LEGS_ITEM = ITEMS.register("ce2_legs", () -> new ClownEssenceArmor("item.ssb.ce2_legs", "message.ssb.ce2_legs", new HangEssenceArmorMaterial(), EquipmentSlotType.LEGS, new Item.Properties().tab(CreativeTab)));
    public static final RegistryObject<Item> CE2_BOOTS_ITEM = ITEMS.register("ce2_boots", () -> new ClownEssenceArmor("item.ssb.ce2_boots", "message.ssb.ce2_boots", new HangEssenceArmorMaterial(), EquipmentSlotType.FEET, new Item.Properties().tab(CreativeTab)));
    public static final RegistryObject<Item> EXCHANGER_BLOCK_ITEM = ITEMS.register("exchangerblockitem", () -> new BaseBlockItem("item.ssb.exchangerblockitem", "message.ssb.exchangerblockitem", EXCHANGER_BLOCK.get(), new Item.Properties().tab(CreativeTab)));
    public static final RegistryObject<Item> MASKWITHGLASSES_ITEM = ITEMS.register("mwglasses", () -> new MaskWithGlasses("item.ssb.mwglasses", "message.ssb.mwglasses", new MaskWithGlassesArmorMaterial(), EquipmentSlotType.HEAD, new Item.Properties().tab(CreativeTab)));
    public static final RegistryObject<Item> PURPLEPOWDER_ITEM = ITEMS.register("purplepowder", () -> new BaseItem("item.ssb.purplepowder", "message.ssb.purplepowder", new Item.Properties().tab(CreativeTab)));
    public static final RegistryObject<Item> STATIONARY_DIAMOND_ORE_GENERATOR_ITEM = ITEMS.register("stationarydiamondoregeneratoritem", () -> new BaseBlockItem("item.ssb.stationarydiamondoregeneratoritem", "message.ssb.stationarydiamondoregeneratoritem", STATIONARY_DIAMOND_ORE_GENERATOR_BLOCK.get(), new Item.Properties().tab(CreativeTab)));
    //public static final RegistryObject<Item> BOSSPAWNEGG_ITEM = ITEMS.register("bossspawnegg", () -> new SpawnEggItem(TEST_ENTITY.get(), 0xeb4034, 0x34e2eb, new Item.Properties().tab(CreativeTab)));

    public SuperSkyBlock() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        MinecraftForge.EVENT_BUS.register(this);

        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
        TILES.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    private void setup(final FMLCommonSetupEvent event)
    {
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        ItemModelsProperties.register(RAINBOWSTONE_ITEM.get(), new ResourceLocation("time"), new IItemPropertyGetter() {
            float retVal = 1.0f;
            @Override
            public float call(ItemStack stackIn, @Nullable ClientWorld worldIn, @Nullable LivingEntity entityIn) {
                if (retVal != 4.0f) retVal += 0.1f; else retVal = 1.0f;
                return retVal;
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(CLOWNBOSS_ENTITY.get(), ClownBossRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(LEXALOX_ENTITY.get(), LexaLoxRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(KILLERHANG_ENTITY.get(), KillerHangRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(CLOWNTRADER_ENTITY.get(), ClownTraderRenderer::new);
        //RenderTypeLookup.setRenderLayer(AUTO_INSCRBR_BLOCK.get(), RenderType.cutoutMipped());
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        //InterModComms.sendTo("examplemod", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
        /*LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.getMessageSupplier().get()).
                collect(Collectors.toList()));*/
    }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
    }

    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class Events {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
        }

        @SubscribeEvent
        public static void onEntityAttrCreateEvent(EntityAttributeCreationEvent event) {
            //AttributeModifierMap.MutableAttribute amm = AttributeModifierMap.builder().add(Attributes.MAX_HEALTH).add(Attributes.KNOCKBACK_RESISTANCE).add(Attributes.MOVEMENT_SPEED).add(Attributes.ARMOR).add(Attributes.ARMOR_TOUGHNESS).add(ForgeMod.SWIM_SPEED.get()).add(ForgeMod.NAMETAG_DISTANCE.get()).add(ForgeMod.ENTITY_GRAVITY.get()).add(Attributes.ATTACK_DAMAGE).add(Attributes.FOLLOW_RANGE).add(Attributes.ATTACK_KNOCKBACK);
            event.put(CLOWNBOSS_ENTITY.get(), ClownBoss.createAttributes().build());
            event.put(LEXALOX_ENTITY.get(), LexaLox.createAttributes().build());
            event.put(KILLERHANG_ENTITY.get(), KillerHangBoss.createAttributes().build());
            event.put(CLOWNTRADER_ENTITY.get(), ClownTrader.createAttributes().build());
        }
    }

    public static class SSBTab extends ItemGroup {
        public SSBTab(String label) {
            super(label);
        }

        @Override
        public ItemStack makeIcon() {
            return FIRESTONE_ITEM.get().getDefaultInstance();
            //return null;
        }

        @Override
        public ITextComponent getDisplayName() {
            return new TranslationTextComponent("message.ssb.tab");
        }
    }
}
