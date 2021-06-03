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
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
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

    public static final String MODID = "ssb";

    public SuperSkyBlock() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        MinecraftForge.EVENT_BUS.register(this);

        Registration.init();
    }

    private void setup(final FMLCommonSetupEvent event)
    {
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        ItemModelsProperties.register(Registration.RAINBOWSTONE_ITEM.get(), new ResourceLocation("time"), new IItemPropertyGetter() {
            float retVal = 1.0f;
            @Override
            public float call(ItemStack stackIn, @Nullable ClientWorld worldIn, @Nullable LivingEntity entityIn) {
                if (retVal != 4.0f) retVal += 0.1f; else retVal = 1.0f;
                return retVal;
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(Registration.CLOWNBOSS_ENTITY.get(), ClownBossRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(Registration.LEXALOX_ENTITY.get(), LexaLoxRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(Registration.KILLERHANG_ENTITY.get(), KillerHangRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(Registration.CLOWNTRADER_ENTITY.get(), ClownTraderRenderer::new);

        RenderTypeLookup.setRenderLayer(Registration.DIAMOND_ANVIL_BLOCK.get(), RenderType.translucent());
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
            event.put(Registration.CLOWNBOSS_ENTITY.get(), ClownBoss.createAttributes().build());
            event.put(Registration.LEXALOX_ENTITY.get(), LexaLox.createAttributes().build());
            event.put(Registration.KILLERHANG_ENTITY.get(), KillerHangBoss.createAttributes().build());
            event.put(Registration.CLOWNTRADER_ENTITY.get(), ClownTrader.createAttributes().build());
        }
    }

    public static class SSBTab extends ItemGroup {
        public SSBTab(String label) {
            super(label);
        }

        @Override
        public ItemStack makeIcon() {
            return Registration.FIRESTONE_ITEM.get().getDefaultInstance();
        }

        @Override
        public ITextComponent getDisplayName() {
            return new TranslationTextComponent("message.ssb.tab");
        }
    }
}
