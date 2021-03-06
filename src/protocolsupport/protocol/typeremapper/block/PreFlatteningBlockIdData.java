package protocolsupport.protocol.typeremapper.block;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import protocolsupport.protocol.utils.MappingsData;
import protocolsupport.protocol.utils.minecraftdata.MinecraftData;
import protocolsupport.utils.JsonUtils;
import protocolsupport.utils.Utils;
import protocolsupport.zplatform.ServerPlatform;

@SuppressWarnings("deprecation")
public class PreFlatteningBlockIdData {

	protected static final int[] toLegacyId = new int[MinecraftData.BLOCKDATA_COUNT];

	protected static int formLegacyCombinedId(int id, int data) {
		return (id << 4) | data;
	}

	protected static void register(String modernBlockState, int legacyId, int legacyData) {
		toLegacyId[ServerPlatform.get().getMiscUtils().getBlockDataNetworkId(Bukkit.createBlockData(modernBlockState))] = formLegacyCombinedId(legacyId, legacyData);
	}

	static {
		Arrays.fill(toLegacyId, formLegacyCombinedId(1, 0));
		//air
		toLegacyId[0] = 0;
		//load list of autogenerated block mappings
		for (JsonElement element : Utils.iterateJsonArrayResource(MappingsData.getResourcePath("preflatteningblockiddata.json"))) {
			JsonObject object = element.getAsJsonObject();
			register(JsonUtils.getString(object, "blockdata"), JsonUtils.getInt(object, "legacyid"), JsonUtils.getInt(object, "legacydata"));
		}
		//manual mappings for some blocks
		for (Material material : Arrays.asList(
			Material.CREEPER_HEAD, Material.CREEPER_WALL_HEAD,
			Material.ZOMBIE_HEAD, Material.ZOMBIE_WALL_HEAD,
			Material.SKELETON_SKULL, Material.SKELETON_WALL_SKULL,
			Material.WITHER_SKELETON_SKULL, Material.WITHER_SKELETON_WALL_SKULL,
			Material.PLAYER_HEAD, Material.PLAYER_WALL_HEAD
		)) {
			register(material.createBlockData().getAsString(), Material.LEGACY_SKULL.getId(), 0);
		}
	}

	public static int getCombinedId(int modernId) {
		return toLegacyId[modernId];
	}

	public static int getIdFromCombinedId(int legacyId) {
		return legacyId >> 4;
	}

	public static int getDataFromCombinedId(int oldId) {
		return oldId & 0xF;
	}

	public static int convertCombinedIdToM12(int blockstate) {
		return (getIdFromCombinedId(blockstate)) | (getDataFromCombinedId(blockstate) << 12);
	}

	public static int convertCombinedIdToM16(int blockstate) {
		return (getIdFromCombinedId(blockstate)) | (getDataFromCombinedId(blockstate) << 16);
	}

}
