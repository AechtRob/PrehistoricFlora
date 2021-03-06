package net.lepidodendron;

import net.lepidodendron.entity.*;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityRegistries {

    private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range, int color1, int color2) {
        EntityRegistry.registerModEntity(new ResourceLocation(LepidodendronMod.MODID + ":" + name), entity, name, id, LepidodendronMod.instance, range, 1, true, color1, color2);
    }

    public static void registerEntities() {
        registerEntity("prehistoric_flora_walliserops", EntityPrehistoricFloraWalliserops.class, LepidodendronMod.ENTITY_WALLISEROPS, 32,-8896764,-10867366);
        registerEntity("prehistoric_flora_pneumodesmus", EntityPrehistoricFloraPneumodesmus.class, LepidodendronMod.ENTITY_PNEUMODESMUS, 32,-3497691,-10867366);
        registerEntity("prehistoric_flora_cheirurus", EntityPrehistoricFloraCheirurus.class, LepidodendronMod.ENTITY_CHEIRURUS, 32,-11715316,-11583424);
        registerEntity("prehistoric_flora_isotelus", EntityPrehistoricFloraIsotelus.class, LepidodendronMod.ENTITY_ISOTELUS, 32,-11715316,-4682937);
        registerEntity("prehistoric_flora_asaphus", EntityPrehistoricFloraAsaphus.class, LepidodendronMod.ENTITY_ASAPHUS, 32,-3689350,-11583424);
        registerEntity("prehistoric_flora_promissum", EntityPrehistoricFloraPromissum.class, LepidodendronMod.ENTITY_PROMISSUM, 32,-12301749,-1);
        registerEntity("prehistoric_flora_acanthodes", EntityPrehistoricFloraAcanthodes.class, LepidodendronMod.ENTITY_ACANTHODES, 32,-6569759,-1);
        registerEntity("prehistoric_flora_jellyfish1", EntityPrehistoricFloraJellyfish1.class, LepidodendronMod.ENTITY_JELLYFISH1, 32,-16724737,-1);
        registerEntity("prehistoric_flora_jellyfish2", EntityPrehistoricFloraJellyfish2.class, LepidodendronMod.ENTITY_JELLYFISH2, 32,-1586000,-1);
        registerEntity("prehistoric_flora_jellyfish3", EntityPrehistoricFloraJellyfish3.class, LepidodendronMod.ENTITY_JELLYFISH3, 32,-3571402,-1);
        registerEntity("prehistoric_flora_jellyfish4", EntityPrehistoricFloraJellyfish4.class, LepidodendronMod.ENTITY_JELLYFISH4, 32,-6452876,-1);
        registerEntity("prehistoric_flora_jellyfish5", EntityPrehistoricFloraJellyfish5.class, LepidodendronMod.ENTITY_JELLYFISH5, 32,-6785123,-1);
        registerEntity("prehistoric_flora_jellyfish6", EntityPrehistoricFloraJellyfish6.class, LepidodendronMod.ENTITY_JELLYFISH6, 32,-6210212,-1);
        registerEntity("prehistoric_flora_jellyfish7", EntityPrehistoricFloraJellyfish7.class, LepidodendronMod.ENTITY_JELLYFISH7, 32,-1731924,-1);
        registerEntity("prehistoric_flora_bothriolepis", EntityPrehistoricFloraBothriolepis.class, LepidodendronMod.ENTITY_BOTHRIOLEPIS, 32,-3373540,-1);
        registerEntity("prehistoric_flora_eurypterus", EntityPrehistoricFloraEurypterus.class, LepidodendronMod.ENTITY_EURYPTERUS, 32,-11451354,-1);
        registerEntity("prehistoric_flora_pteraspis", EntityPrehistoricFloraPteraspis.class, LepidodendronMod.ENTITY_PTERASPIS, 32,-4266538,-855410);
        registerEntity("prehistoric_flora_cyrtoceras", EntityPrehistoricFloraCyrtoceras.class, LepidodendronMod.ENTITY_CYRTOCERAS, 32,-1,-3698552);
        registerEntity("prehistoric_flora_arandaspis", EntityPrehistoricFloraArandaspis.class, LepidodendronMod.ENTITY_ARANDASPIS, 32,-3134187,-14763792);
        registerEntity("prehistoric_flora_anthracomedusa", EntityPrehistoricFloraAnthracomedusa.class, LepidodendronMod.ENTITY_ANTHRACOMEDUSA, 32,-16724737,-1);
        registerEntity("prehistoric_flora_limnoscelis", EntityPrehistoricFloraLimnoscelis.class, LepidodendronMod.ENTITY_LIMNOSCELIS, 32,-6306328,-1572272);
        registerEntity("prehistoric_flora_sacabambaspis", EntityPrehistoricFloraSacabambaspis.class, LepidodendronMod.ENTITY_SACABAMBASPIS, 32,-9168057,-13694436);
        registerEntity("prehistoric_flora_hibernaspis", EntityPrehistoricFloraHibernaspis.class, LepidodendronMod.ENTITY_HIBERNASPIS, 32,-5200768,-11384532);
        registerEntity("prehistoric_flora_eoarthropleura", EntityPrehistoricFloraEoarthropleura.class, LepidodendronMod.ENTITY_EOARTHROPLEURA, 32,-4122343,-10867366);
        registerEntity("prehistoric_flora_ammonite_manticoceras", EntityPrehistoricFloraAmmonite_Manticoceras.class, LepidodendronMod.ENTITY_AMMONITE_MANTICOCERAS, 32,-5308448,-6199863);
        registerEntity("prehistoric_flora_ammonite_goniatites", EntityPrehistoricFloraAmmonite_Goniatites.class, LepidodendronMod.ENTITY_AMMONITE_GONIATITES, 32,-4084109,-2070938);
        registerEntity("prehistoric_flora_ammonite_cylolobus", EntityPrehistoricFloraAmmonite_Cylolobus.class, LepidodendronMod.ENTITY_AMMONITE_CYLOLOBUS, 32,-9137749,-2775363);
        registerEntity("prehistoric_flora_ammonite_parapuzosia", EntityPrehistoricFloraAmmonite_Parapuzosia.class, LepidodendronMod.ENTITY_AMMONITE_PARAPUZOSIA, 32,-6323152,-4222976);
        registerEntity("prehistoric_flora_ammonite_dactylioceras", EntityPrehistoricFloraAmmonite_Dactylioceras.class, LepidodendronMod.ENTITY_AMMONITE_DACTYLIOCERAS, 32,-9162414,0);
        registerEntity("prehistoric_flora_ammonite_titanites", EntityPrehistoricFloraAmmonite_Titanites.class, LepidodendronMod.ENTITY_AMMONITE_TITANITES, 32,-13661992,0);
        registerEntity("prehistoric_flora_ammonite_asteroceras", EntityPrehistoricFloraAmmonite_Asteroceras.class, LepidodendronMod.ENTITY_AMMONITE_ASTEROCERAS, 32,-5947328,-10092544);
        registerEntity("prehistoric_flora_ammonite_pachydesmoceras", EntityPrehistoricFloraAmmonite_Pachydesmoceras .class, LepidodendronMod.ENTITY_AMMONITE_PACHYDESMOCERAS, 32,-14846373,-5947328);
        registerEntity("prehistoric_flora_ammonite_pachydiscus", EntityPrehistoricFloraAmmonite_Pachydiscus .class, LepidodendronMod.ENTITY_AMMONITE_PACHYDISCUS, 32,-10092544,-1);
        registerEntity("prehistoric_flora_ammonite_coroniceras", EntityPrehistoricFloraAmmonite_Coroniceras.class, LepidodendronMod.ENTITY_AMMONITE_CORONICERAS, 32,-9137749,0);
        registerEntity("prehistoric_flora_ammonite_ceratites", EntityPrehistoricFloraAmmonite_Ceratites.class, LepidodendronMod.ENTITY_AMMONITE_CERATITES, 32,-7186664,-5947328);
        registerEntity("prehistoric_flora_hibbertopterus", EntityPrehistoricFloraHibbertopterus.class, LepidodendronMod.ENTITY_HIBBERTOPTERUS, 32,-2524036,-8171236);
        registerEntity("prehistoric_flora_terataspis", EntityPrehistoricFloraTerataspis.class, LepidodendronMod.ENTITY_TERATASPIS, 32,-1000314,-4546685);
        registerEntity("prehistoric_flora_furcacauda", EntityPrehistoricFloraFurcacauda.class, LepidodendronMod.ENTITY_FURCACAUDA, 32,-855513,-14342909);
        registerEntity("prehistoric_flora_squatinactis", EntityPrehistoricFloraSquatinactis.class, LepidodendronMod.ENTITY_SQUATINACTIS, 32,-4547201,-3700922);
        registerEntity("prehistoric_flora_palaeodictyoptera_nymph", EntityPrehistoricFloraPalaeodictyopteraNymph.class, LepidodendronMod.ENTITY_PALAEODICTYOPTERA_NYMPH, 32,-11850451,0);
        registerEntity("prehistoric_flora_qilinyu", EntityPrehistoricFloraQilinyu.class, LepidodendronMod.ENTITY_QILINYU, 32,-1000937,-871049);
        registerEntity("prehistoric_flora_poraspis", EntityPrehistoricFloraPoraspis.class, LepidodendronMod.ENTITY_PORASPIS, 32,-11216556,-1666760);
        registerEntity("prehistoric_flora_aphetoceras", EntityPrehistoricFloraAphetoceras.class, LepidodendronMod.ENTITY_APHETOCERAS , 32,-1666760,-10405102);
        registerEntity("prehistoric_flora_endoceras", EntityPrehistoricFloraEndoceras.class, LepidodendronMod.ENTITY_ENDOCERAS, 32,-13474928,-7555363);
        registerEntity("prehistoric_flora_cameroceras", EntityPrehistoricFloraCameroceras.class, LepidodendronMod.ENTITY_CAMEROCERAS, 32,-270141,-1277682);
        registerEntity("prehistoric_flora_orthoceras", EntityPrehistoricFloraOrthoceras.class, LepidodendronMod.ENTITY_ORTHOCERAS, 32,-1518882,-11257313);
        registerEntity("prehistoric_flora_palaeodictyoptera_delitzschala", EntityPrehistoricFloraPalaeodictyoptera_Delitzschala.class, LepidodendronMod.ENTITY_PALAEODICTYOPTERA_DELITZSCHALA, 32,-10702793,-10583218);
        registerEntity("prehistoric_flora_palaeodictyoptera_dunbaria", EntityPrehistoricFloraPalaeodictyoptera_Dunbaria.class, LepidodendronMod.ENTITY_PALAEODICTYOPTERA_DUNBARIA, 32,-5717544,-10583218);
        registerEntity("prehistoric_flora_palaeodictyoptera_homaloneura", EntityPrehistoricFloraPalaeodictyoptera_Homaloneura.class, LepidodendronMod.ENTITY_PALAEODICTYOPTERA_HOMALONEURA, 32,-5468103,-10583218);
        registerEntity("prehistoric_flora_palaeodictyoptera_homoioptera", EntityPrehistoricFloraPalaeodictyoptera_Homoioptera.class, LepidodendronMod.ENTITY_PALAEODICTYOPTERA_HOMOIOPTERA, 32,-9475752,-10583218);
        registerEntity("prehistoric_flora_palaeodictyoptera_lithomantis", EntityPrehistoricFloraPalaeodictyoptera_Lithomantis.class, LepidodendronMod.ENTITY_PALAEODICTYOPTERA_LITHOMANTIS, 32,-4544654,-10583218);
        registerEntity("prehistoric_flora_palaeodictyoptera_lycocercus", EntityPrehistoricFloraPalaeodictyoptera_Lycocercus.class, LepidodendronMod.ENTITY_PALAEODICTYOPTERA_LYCOCERCUS, 32,-6646910,-10583218);
        registerEntity("prehistoric_flora_palaeodictyoptera_sinodunbaria", EntityPrehistoricFloraPalaeodictyoptera_Sinodunbaria.class, LepidodendronMod.ENTITY_PALAEODICTYOPTERA_SINODUNBARIA, 32,-4544654,-6509419);
        registerEntity("prehistoric_flora_palaeodictyoptera_stenodictya", EntityPrehistoricFloraPalaeodictyoptera_Stenodictya.class, LepidodendronMod.ENTITY_PALAEODICTYOPTERA_STENODICTYA, 32,-6646910,-6509419);
        registerEntity("prehistoric_flora_jellyfish_precambrian", EntityPrehistoricFloraJellyfish_Precambrian.class, LepidodendronMod.ENTITY_JELLYFISH_PRECAMBRIAN, 32,-1,-4274237);
        registerEntity("prehistoric_flora_schinderhannes", EntityPrehistoricFloraSchinderhannes.class, LepidodendronMod.ENTITY_SCHINDERHANNES, 32,-16711936,-12464471);
        registerEntity("prehistoric_flora_titanichthys", EntityPrehistoricFloraTitanichthys.class, LepidodendronMod.ENTITY_TITANICTHYS, 32,-3355444,-4274237);
        registerEntity("prehistoric_flora_ichthyostega", EntityPrehistoricFloraIchthyostega.class, LepidodendronMod.ENTITY_ICHTHYOSTEGA, 32,-9792893,-13417924);
        registerEntity("prehistoric_flora_amphibamus", EntityPrehistoricFloraAmphibamus.class, LepidodendronMod.ENTITY_AMPHIBAMUS, 32,-13933805,-8321273);
        registerEntity("prehistoric_flora_mixopterus", EntityPrehistoricFloraMixopterus.class, LepidodendronMod.ENTITY_MIXOPTERUS, 32,-2070938,-7444633);
        registerEntity("prehistoric_flora_jaekelopterus", EntityPrehistoricFloraJaekelopterus.class, LepidodendronMod.ENTITY_JAEKELOPTERUS, 32,-12111601,-12568274);
        registerEntity("prehistoric_flora_pterygotus", EntityPrehistoricFloraPterygotus.class, LepidodendronMod.ENTITY_PTERYGOTUS, 32,-11833200,-14723193);
        registerEntity("prehistoric_flora_megarachne", EntityPrehistoricFloraMegarachne.class, LepidodendronMod.ENTITY_MEGARACHNE, 32,-12568274,-1);
        registerEntity("prehistoric_flora_lunataspis", EntityPrehistoricFloraLunataspis.class, LepidodendronMod.ENTITY_LUNATASPIS, 32,-9414593,-5924984);
        registerEntity("prehistoric_flora_selenopeltis", EntityPrehistoricFloraSelenopeltis.class, LepidodendronMod.ENTITY_SELENOPELTIS, 32,-256,-9276729);
        registerEntity("prehistoric_flora_hemicyclaspis", EntityPrehistoricFloraHemicyclaspis.class, LepidodendronMod.ENTITY_HEMICYCLASPIS, 32,-2377907,-9197352);
        registerEntity("prehistoric_flora_ateleaspis", EntityPrehistoricFloraAteleaspis.class, LepidodendronMod.ENTITY_ATELEASPIS, 32,-532324,-5308448);
        registerEntity("prehistoric_flora_cephalaspis", EntityPrehistoricFloraCephalaspis.class, LepidodendronMod.ENTITY_CEPHALASPIS, 32,-5463147,-10004416);
        registerEntity("prehistoric_flora_psarolepis", EntityPrehistoricFloraPsarolepis.class, LepidodendronMod.ENTITY_PSAROLEPIS, 32,-1,-6569759);
        registerEntity("prehistoric_flora_aegirocassis", EntityPrehistoricFloraAegirocassis.class, LepidodendronMod.ENTITY_AEGIROCASSIS, 32,-8287866,-14078677);
        registerEntity("prehistoric_flora_thelodus", EntityPrehistoricFloraThelodus.class, LepidodendronMod.ENTITY_THELODUS, 32,-3499933,0);
        registerEntity("prehistoric_flora_tullimonstrum", EntityPrehistoricFloraTullimonstrum.class, LepidodendronMod.ENTITY_TULLIMONSTRUM, 32,-1263331,-4225719);
        registerEntity("prehistoric_flora_attercopus", EntityPrehistoricFloraAttercopus.class, LepidodendronMod.ENTITY_ATTERCOPUS, 32,-9160648,-4687495);
        registerEntity("prehistoric_flora_trigonotarbid_palaeotarbus", EntityPrehistoricFloraTrigonotarbid_Palaeotarbus.class, LepidodendronMod.ENTITY_TRIGONOTARBID_PALAEOTARBUS, 32,-13095635,-993835);
        registerEntity("prehistoric_flora_trigonotarbid_palaeocharinus", EntityPrehistoricFloraTrigonotarbid_Palaeocharinus.class, LepidodendronMod.ENTITY_TRIGONOTARBID_PALAEOCHARINUS, 32,-13095635,-10990002);
        registerEntity("prehistoric_flora_trigonotarbid_eophrynus", EntityPrehistoricFloraTrigonotarbid_Eophrynus.class, LepidodendronMod.ENTITY_TRIGONOTARBID_EOPHRYNUS, 32,-13095635,-5478810);
        registerEntity("prehistoric_flora_trigonotarbid_kreischeria", EntityPrehistoricFloraTrigonotarbid_Kreischeria.class, LepidodendronMod.ENTITY_TRIGONOTARBID_KREISCHERIA, 32,-13095635,-7906000);
        registerEntity("prehistoric_flora_trigonotarbid_cryptomartus", EntityPrehistoricFloraTrigonotarbid_Cryptomartus.class, LepidodendronMod.ENTITY_TRIGONOTARBID_CRYPTOMARTUS, 32,-13095635,-8313306);
        registerEntity("prehistoric_flora_trigonotarbid_permotarbus", EntityPrehistoricFloraTrigonotarbid_Permotarbus.class, LepidodendronMod.ENTITY_TRIGONOTARBID_PERMOTARBUS, 32,-13095635,-5813221);
        registerEntity("prehistoric_flora_dickinsonia", EntityPrehistoricFloraDickinsonia.class, LepidodendronMod.ENTITY_DICKINSONIA, 32,-12961130,-10789906);
        registerEntity("prehistoric_flora_kimberella", EntityPrehistoricFloraKimberella.class, LepidodendronMod.ENTITY_KIMBERELLA, 32,-1987926,-1666760);
        registerEntity("prehistoric_flora_eoandromeda", EntityPrehistoricFloraEoandromeda.class, LepidodendronMod.ENTITY_EOANDROMEDA, 32,-5193816,-7282843);
        registerEntity("prehistoric_flora_parvancorina", EntityPrehistoricFloraParvancorina.class, LepidodendronMod.ENTITY_PARVANCORINA, 32,-5802170,-2718414);
        registerEntity("prehistoric_flora_spriggina", EntityPrehistoricFloraSpriggina.class, LepidodendronMod.ENTITY_SPRIGGINA, 32,-10268272,-11004328);
        registerEntity("prehistoric_flora_yilingia", EntityPrehistoricFloraYilingia.class, LepidodendronMod.ENTITY_YILINGIA, 32,-1598051,-2970709);
        registerEntity("prehistoric_flora_yorgia", EntityPrehistoricFloraYorgia.class, LepidodendronMod.ENTITY_YORGIA, 32,-1046520,-892061);
        registerEntity("prehistoric_flora_monograptus", EntityPrehistoricFloraMonograptus.class, LepidodendronMod.ENTITY_MONOGRAPTUS, 32,-10005478,-5467843);
        registerEntity("prehistoric_flora_didymograptus", EntityPrehistoricFloraDidymograptus.class, LepidodendronMod.ENTITY_DIDYMOGRAPTUS, 32,-10005478,-10397897);
        registerEntity("prehistoric_flora_tetragraptus", EntityPrehistoricFloraTetragraptus.class, LepidodendronMod.ENTITY_TETRAGRAPTUS, 32,-10994614,-10267092);
        registerEntity("prehistoric_flora_poleumita", EntityPrehistoricFloraPoleumita.class, LepidodendronMod.ENTITY_POLEUMITA, 32,-296583,-12112364);
        registerEntity("prehistoric_flora_maclurina", EntityPrehistoricFloraMaclurina.class, LepidodendronMod.ENTITY_MACLURINA, 32,-296583,-892061);
        registerEntity("prehistoric_flora_cyclonema", EntityPrehistoricFloraCyclonema.class, LepidodendronMod.ENTITY_CYCLONEMA, 32,-296583,0);
        registerEntity("prehistoric_flora_xenacanthus", EntityPrehistoricFloraXenacanthus.class, LepidodendronMod.ENTITY_XENACANTHUS, 32,-6917556,-12890317);
        registerEntity("prehistoric_flora_belantsea", EntityPrehistoricFloraBelantsea.class, LepidodendronMod.ENTITY_BELANTSEA, 32,-10984609,-11981765);
        registerEntity("prehistoric_flora_campbellodus", EntityPrehistoricFloraCampbellodus.class, LepidodendronMod.ENTITY_CAMPBELLODUS, 32,-13008795,-2855123);
        registerEntity("prehistoric_flora_platysomus", EntityPrehistoricFloraPlatysomus.class, LepidodendronMod.ENTITY_PLATYSOMUS, 32,-8922972,-2015682);
        registerEntity("prehistoric_flora_coccosteus", EntityPrehistoricFloraCoccosteus.class, LepidodendronMod.ENTITY_COCCOSTEUS, 32,-5811404,-12819670);
        registerEntity("prehistoric_flora_akmonistion", EntityPrehistoricFloraAkmonistion.class, LepidodendronMod.ENTITY_AKMONISTION, 32,-5460307,-7095380);
        registerEntity("prehistoric_flora_dracopristis", EntityPrehistoricFloraDracopristis.class, LepidodendronMod.ENTITY_DRACOPRISTIS, 32,-7902386,-2575990);
        registerEntity("prehistoric_flora_cladoselache", EntityPrehistoricFloraCladoselache.class, LepidodendronMod.ENTITY_CLADOSELACHE, 32,-5654073,-6841956);
        registerEntity("prehistoric_flora_gemuendina", EntityPrehistoricFloraGemuendina.class, LepidodendronMod.ENTITY_GEMUENDINA, 32,-6449279,-2702206);
        registerEntity("prehistoric_flora_hyneria", EntityPrehistoricFloraHyneria.class, LepidodendronMod.ENTITY_HYNERIA, 32,-10271709,-5662845);
        registerEntity("prehistoric_flora_onychodus", EntityPrehistoricFloraOnychodus.class, LepidodendronMod.ENTITY_ONYCHODUS, 32,-10850444,-4598051);
        registerEntity("prehistoric_flora_rhizodus", EntityPrehistoricFloraRhizodus.class, LepidodendronMod.ENTITY_RHIZODUS, 32,-8896764,-5668777);
        registerEntity("prehistoric_flora_furcaster", EntityPrehistoricFloraFurcaster.class, LepidodendronMod.ENTITY_FURCASTER, 32,-3690910,-3963291);
        registerEntity("prehistoric_flora_kalbarria", EntityPrehistoricFloraKalbarria.class, LepidodendronMod.ENTITY_KALBARRIA, 32,-9416157,-8490157);
        registerEntity("prehistoric_flora_palaeoisopus", EntityPrehistoricFloraPalaeoisopus.class, LepidodendronMod.ENTITY_PALAEOISOPUS, 32,-12885629,-3021578);
        registerEntity("prehistoric_flora_ainiktozoon", EntityPrehistoricFloraAiniktozoon.class, LepidodendronMod.ENTITY_AINIKTOZOON, 32,-3865757,-12368905);
        registerEntity("prehistoric_flora_acutiramus", EntityPrehistoricFloraAcutiramus.class, LepidodendronMod.ENTITY_ACUTIRAMUS, 32,-12958912,-14214116);


    }

}
