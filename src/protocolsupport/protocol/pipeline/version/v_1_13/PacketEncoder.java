package protocolsupport.protocol.pipeline.version.v_1_13;

import protocolsupport.api.Connection;
import protocolsupport.api.utils.NetworkState;
import protocolsupport.protocol.packet.ClientBoundPacket;
import protocolsupport.protocol.packet.middleimpl.clientbound.login.v_13.LoginCustomPayload;
import protocolsupport.protocol.packet.middleimpl.clientbound.login.v_4_5_6_7_8_9r1_9r2_10_11_12r1_12r2_13.EncryptionRequest;
import protocolsupport.protocol.packet.middleimpl.clientbound.login.v_7_8_9r1_9r2_10_11_12r1_12r2_13.LoginDisconnect;
import protocolsupport.protocol.packet.middleimpl.clientbound.login.v_7_8_9r1_9r2_10_11_12r1_12r2_13.LoginSuccess;
import protocolsupport.protocol.packet.middleimpl.clientbound.login.v_8_9r1_9r2_10_11_12r1_12r2_13.SetCompression;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_10_11_12r1_12r2_13.WorldCustomSound;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_10_11_12r1_12r2_13.WorldSound;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_11_12r1_12r2_13.CollectEffect;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_11_12r1_12r2_13.Title;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_12r1_12r2_13.Advancements;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_12r1_12r2_13.AdvancementsTab;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_13.BlockChangeMulti;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_13.BlockChangeSingle;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_13.Chunk;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_13.CraftRecipeConfirm;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_13.CustomPayload;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_13.DeclareCommands;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_13.DeclareRecipes;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_13.DeclareTags;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_13.LookAt;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_13.Map;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_13.QueryNBTResponse;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_13.ScoreboardObjective;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_13.ScoreboardTeam;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_13.SpawnLiving;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_13.SpawnPainting;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_13.Statistics;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_13.StopSound;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_13.TabComplete;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_13.UnlockRecipes;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_4_5_6_7_8_9r1_9r2_10_11_12r1_12r2_13.EntityStatus;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_4_5_6_7_8_9r1_9r2_10_11_12r1_12r2_13.InventoryClose;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_4_5_6_7_8_9r1_9r2_10_11_12r1_12r2_13.InventoryConfirmTransaction;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_4_5_6_7_8_9r1_9r2_10_11_12r1_12r2_13.InventoryData;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_4_5_6_7_8_9r1_9r2_10_11_12r1_12r2_13.InventorySetItems;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_4_5_6_7_8_9r1_9r2_10_11_12r1_12r2_13.InventorySetSlot;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_4_5_6_7_8_9r1_9r2_10_11_12r1_12r2_13.ScoreboardDisplay;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_4_5_6_7_8_9r1_9r2_10_11_12r1_12r2_13.TimeUpdate;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_6_7_8_9r1_9r2_10_11_12r1_12r2_13.PlayerAbilities;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_7_8_9r1_9r2_10_11_12r1_12r2_13.Animation;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_7_8_9r1_9r2_10_11_12r1_12r2_13.ChangeDimension;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_7_8_9r1_9r2_10_11_12r1_12r2_13.Explosion;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_7_8_9r1_9r2_10_11_12r1_12r2_13.GameStateChange;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_7_8_9r1_9r2_10_11_12r1_12r2_13.HeldSlot;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_7_8_9r1_9r2_10_11_12r1_12r2_13.KickDisconnect;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_8_9r1_9r2_10_11_12r1_12r2_13.BlockAction;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_8_9r1_9r2_10_11_12r1_12r2_13.BlockBreakAnimation;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_8_9r1_9r2_10_11_12r1_12r2_13.BlockOpenSignEditor;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_8_9r1_9r2_10_11_12r1_12r2_13.BlockTileUpdate;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_8_9r1_9r2_10_11_12r1_12r2_13.Camera;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_8_9r1_9r2_10_11_12r1_12r2_13.Chat;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_8_9r1_9r2_10_11_12r1_12r2_13.CombatEvent;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_8_9r1_9r2_10_11_12r1_12r2_13.Entity;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_8_9r1_9r2_10_11_12r1_12r2_13.EntityDestroy;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_8_9r1_9r2_10_11_12r1_12r2_13.EntityEffectAdd;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_8_9r1_9r2_10_11_12r1_12r2_13.EntityEffectRemove;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_8_9r1_9r2_10_11_12r1_12r2_13.EntityHeadRotation;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_8_9r1_9r2_10_11_12r1_12r2_13.EntityLook;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_8_9r1_9r2_10_11_12r1_12r2_13.EntitySetAttributes;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_8_9r1_9r2_10_11_12r1_12r2_13.EntityVelocity;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_8_9r1_9r2_10_11_12r1_12r2_13.InventoryOpen;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_8_9r1_9r2_10_11_12r1_12r2_13.KeepAlive;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_8_9r1_9r2_10_11_12r1_12r2_13.PlayerListHeaderFooter;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_8_9r1_9r2_10_11_12r1_12r2_13.PlayerListSetEntry;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_8_9r1_9r2_10_11_12r1_12r2_13.ResourcePack;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_8_9r1_9r2_10_11_12r1_12r2_13.ScoreboardScore;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_8_9r1_9r2_10_11_12r1_12r2_13.ServerDifficulty;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_8_9r1_9r2_10_11_12r1_12r2_13.SetExperience;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_8_9r1_9r2_10_11_12r1_12r2_13.SetHealth;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_8_9r1_9r2_10_11_12r1_12r2_13.SpawnPosition;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_8_9r1_9r2_10_11_12r1_12r2_13.StartGame;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_8_9r1_9r2_10_11_12r1_12r2_13.UseBed;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_8_9r1_9r2_10_11_12r1_12r2_13.WorldBorder;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_8_9r1_9r2_10_11_12r1_12r2_13.WorldEvent;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_8_9r1_9r2_10_11_12r1_12r2_13.WorldParticle;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_9r1_9r2_10_11_12r1_12r2_13.BossBar;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_9r1_9r2_10_11_12r1_12r2_13.EntityEquipment;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_9r1_9r2_10_11_12r1_12r2_13.EntityLeash;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_9r1_9r2_10_11_12r1_12r2_13.EntityMetadata;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_9r1_9r2_10_11_12r1_12r2_13.EntityRelMove;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_9r1_9r2_10_11_12r1_12r2_13.EntityRelMoveLook;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_9r1_9r2_10_11_12r1_12r2_13.EntityTeleport;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_9r1_9r2_10_11_12r1_12r2_13.SetCooldown;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_9r1_9r2_10_11_12r1_12r2_13.SetPosition;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_9r1_9r2_10_11_12r1_12r2_13.SpawnExpOrb;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_9r1_9r2_10_11_12r1_12r2_13.SpawnGlobal;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_9r1_9r2_10_11_12r1_12r2_13.SpawnNamed;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_9r1_9r2_10_11_12r1_12r2_13.SpawnObject;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_9r1_9r2_10_11_12r1_12r2_13.UnloadChunk;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_9r1_9r2_10_11_12r1_12r2_13.VehicleMove;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_9r1_9r2_10_11_12r1_12r2_13.VehiclePassengers;
import protocolsupport.protocol.packet.middleimpl.clientbound.status.v_7_8_9r1_9r2_10_11_12r1_12r2_13.Pong;
import protocolsupport.protocol.packet.middleimpl.clientbound.status.v_7_8_9r1_9r2_10_11_12r1_12r2_13.ServerInfo;
import protocolsupport.protocol.pipeline.version.util.encoder.AbstractModernPacketEncoder;
import protocolsupport.protocol.storage.netcache.NetworkDataCache;
import protocolsupport.protocol.utils.registry.PacketIdTransformerRegistry;

public class PacketEncoder extends AbstractModernPacketEncoder {

	protected static final PacketIdTransformerRegistry packetIdRegistry = new PacketIdTransformerRegistry();
	static {
		packetIdRegistry.register(NetworkState.LOGIN, ClientBoundPacket.LOGIN_DISCONNECT_ID, 0x00);
		packetIdRegistry.register(NetworkState.LOGIN, ClientBoundPacket.LOGIN_ENCRYPTION_BEGIN_ID, 0x01);
		packetIdRegistry.register(NetworkState.LOGIN, ClientBoundPacket.LOGIN_SUCCESS_ID, 0x02);
		packetIdRegistry.register(NetworkState.LOGIN, ClientBoundPacket.LOGIN_SET_COMPRESSION_ID, 0x03);
		packetIdRegistry.register(NetworkState.LOGIN, ClientBoundPacket.LOGIN_CUSTOM_PAYLOAD, 0x04);
		packetIdRegistry.register(NetworkState.STATUS, ClientBoundPacket.STATUS_SERVER_INFO_ID, 0x00);
		packetIdRegistry.register(NetworkState.STATUS, ClientBoundPacket.STATUS_PONG_ID, 0x01);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_KEEP_ALIVE_ID, 0x21);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_LOGIN_ID, 0x25);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_CHAT_ID, 0x0E);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_UPDATE_TIME_ID, 0x4A);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_ENTITY_EQUIPMENT_ID, 0x42);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_SPAWN_POSITION_ID, 0x49);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_UPDATE_HEALTH_ID, 0x44);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_RESPAWN_ID, 0x38);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_POSITION_ID, 0x32);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_HELD_SLOT_ID, 0x3D);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_BED_ID, 0x33);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_ANIMATION_ID, 0x06);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_SPAWN_NAMED_ID, 0x05);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_COLLECT_EFFECT_ID, 0x4F);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_SPAWN_OBJECT_ID, 0x00);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_SPAWN_LIVING_ID, 0x3);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_SPAWN_PAINTING_ID, 0x04);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_SPAWN_EXP_ORB_ID, 0x01);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_ENTITY_VELOCITY_ID, 0x41);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_ENTITY_DESTROY_ID, 0x35);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_ENTITY_ID, 0x27);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_ENTITY_REL_MOVE_ID, 0x28);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_ENTITY_LOOK_ID, 0x2A);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_ENTITY_REL_MOVE_LOOK_ID, 0x29);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_ENTITY_TELEPORT_ID, 0x50);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_ENTITY_HEAD_ROTATION_ID, 0x39);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_ENTITY_STATUS_ID, 0x1C);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_ENTITY_LEASH_ID, 0x40);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_ENTITY_METADATA_ID, 0x3F);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_ENTITY_EFFECT_ADD_ID, 0x53);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_ENTITY_EFFECT_REMOVE_ID, 0x36);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_EXPERIENCE_ID, 0x43);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_ENTITY_ATTRIBUTES_ID, 0x52);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_CHUNK_SINGLE_ID, 0x22);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_BLOCK_CHANGE_MULTI_ID, 0xF);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_BLOCK_CHANGE_SINGLE_ID, 0xB);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_BLOCK_ACTION_ID, 0x0A);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_BLOCK_BREAK_ANIMATION_ID, 0x8);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_EXPLOSION_ID, 0x1E);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_WORLD_EVENT_ID, 0x23);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_WORLD_SOUND_ID, 0x4D);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_WORLD_PARTICLES_ID, 0x24);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_GAME_STATE_CHANGE_ID, 0x20);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_SPAWN_WEATHER_ID, 0x02);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_WINDOW_OPEN_ID, 0x14);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_WINDOW_CLOSE_ID, 0x13);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_WINDOW_SET_SLOT_ID, 0x17);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_WINDOW_SET_ITEMS_ID, 0x15);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_WINDOW_DATA_ID, 0x16);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_WINDOW_TRANSACTION_ID, 0x12);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_MAP_ID, 0x26);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_UPDATE_TILE_ID, 0x9);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_SIGN_EDITOR_ID, 0x2C);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_STATISTICS_ID, 0x07);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_PLAYER_INFO_ID, 0x30);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_ABILITIES_ID, 0x2E);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_TAB_COMPLETE_ID, 0x10);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_SCOREBOARD_OBJECTIVE_ID, 0x45);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_SCOREBOARD_SCORE_ID, 0x48);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_SCOREBOARD_DISPLAY_SLOT_ID, 0x3E);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_SCOREBOARD_TEAM_ID, 0x47);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_CUSTOM_PAYLOAD_ID, 0x19);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_KICK_DISCONNECT_ID, 0x1B);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_RESOURCE_PACK_ID, 0x37);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_CAMERA_ID, 0x3C);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_WORLD_BORDER_ID, 0x3B);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_TITLE_ID, 0x4B);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_PLAYER_LIST_HEADER_FOOTER_ID, 0x4E);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_SET_PASSENGERS_ID, 0x46);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_CHUNK_UNLOAD_ID, 0x1F);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_WORLD_CUSTOM_SOUND_ID, 0x1A);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_SERVER_DIFFICULTY_ID, 0x0D);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_COMBAT_EVENT_ID, 0x2F);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_BOSS_BAR_ID, 0x0C);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_SET_COOLDOWN_ID, 0x18);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_VEHICLE_MOVE_ID, 0x2B);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_UNLOCK_RECIPES, 0x34);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_ADVANCEMENTS, 0x51);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_ADVANCEMENTS_TAB, 0x3A);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_CRAFT_RECIPE_CONFIRM, 0x2D);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_DECLARE_COMMANDS, 0x11);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_DECLARE_RECIPES, 0x54);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_DECLARE_TAGS, 0x55);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_QUERY_NBT_RESPONSE, 0x1D);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_STOP_SOUND, 0x4C);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_LOOK_AT, 0x31);
	}

	@Override
	protected int getNewPacketId(NetworkState currentProtocol, int oldPacketId) {
		return packetIdRegistry.getNewPacketId(currentProtocol, oldPacketId);
	}

	{
		registry.register(NetworkState.LOGIN, ClientBoundPacket.LOGIN_SUCCESS_ID, LoginSuccess.class);
		registry.register(NetworkState.LOGIN, ClientBoundPacket.LOGIN_ENCRYPTION_BEGIN_ID, EncryptionRequest.class);
		registry.register(NetworkState.LOGIN, ClientBoundPacket.LOGIN_DISCONNECT_ID, LoginDisconnect.class);
		registry.register(NetworkState.LOGIN, ClientBoundPacket.LOGIN_SET_COMPRESSION_ID, SetCompression.class);
		registry.register(NetworkState.LOGIN, ClientBoundPacket.LOGIN_CUSTOM_PAYLOAD, LoginCustomPayload.class);
		registry.register(NetworkState.STATUS, ClientBoundPacket.STATUS_SERVER_INFO_ID, ServerInfo.class);
		registry.register(NetworkState.STATUS, ClientBoundPacket.STATUS_PONG_ID, Pong.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_KEEP_ALIVE_ID, KeepAlive.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_LOGIN_ID, StartGame.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_CHAT_ID, Chat.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_UPDATE_TIME_ID, TimeUpdate.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_ENTITY_EQUIPMENT_ID, EntityEquipment.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_SPAWN_POSITION_ID, SpawnPosition.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_UPDATE_HEALTH_ID, SetHealth.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_RESPAWN_ID, ChangeDimension.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_POSITION_ID, SetPosition.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_HELD_SLOT_ID, HeldSlot.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_BED_ID, UseBed.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_ANIMATION_ID, Animation.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_SPAWN_NAMED_ID, SpawnNamed.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_COLLECT_EFFECT_ID, CollectEffect.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_SPAWN_OBJECT_ID, SpawnObject.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_SPAWN_LIVING_ID, SpawnLiving.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_SPAWN_PAINTING_ID, SpawnPainting.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_SPAWN_EXP_ORB_ID, SpawnExpOrb.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_ENTITY_VELOCITY_ID, EntityVelocity.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_ENTITY_DESTROY_ID, EntityDestroy.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_ENTITY_ID, Entity.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_ENTITY_REL_MOVE_ID, EntityRelMove.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_ENTITY_LOOK_ID, EntityLook.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_ENTITY_REL_MOVE_LOOK_ID, EntityRelMoveLook.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_ENTITY_TELEPORT_ID, EntityTeleport.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_ENTITY_HEAD_ROTATION_ID, EntityHeadRotation.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_ENTITY_STATUS_ID, EntityStatus.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_ENTITY_LEASH_ID, EntityLeash.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_ENTITY_METADATA_ID, EntityMetadata.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_ENTITY_EFFECT_ADD_ID, EntityEffectAdd.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_ENTITY_EFFECT_REMOVE_ID, EntityEffectRemove.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_EXPERIENCE_ID, SetExperience.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_ENTITY_ATTRIBUTES_ID, EntitySetAttributes.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_CHUNK_SINGLE_ID, Chunk.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_BLOCK_CHANGE_MULTI_ID, BlockChangeMulti.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_BLOCK_CHANGE_SINGLE_ID, BlockChangeSingle.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_BLOCK_ACTION_ID, BlockAction.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_BLOCK_BREAK_ANIMATION_ID, BlockBreakAnimation.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_EXPLOSION_ID, Explosion.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_WORLD_EVENT_ID, WorldEvent.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_WORLD_SOUND_ID, WorldSound.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_WORLD_CUSTOM_SOUND_ID, WorldCustomSound.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_WORLD_PARTICLES_ID, WorldParticle.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_GAME_STATE_CHANGE_ID, GameStateChange.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_SPAWN_WEATHER_ID, SpawnGlobal.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_WINDOW_OPEN_ID, InventoryOpen.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_WINDOW_CLOSE_ID, InventoryClose.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_WINDOW_SET_SLOT_ID, InventorySetSlot.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_WINDOW_SET_ITEMS_ID, InventorySetItems.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_WINDOW_DATA_ID, InventoryData.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_WINDOW_TRANSACTION_ID, InventoryConfirmTransaction.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_MAP_ID, Map.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_UPDATE_TILE_ID, BlockTileUpdate.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_SIGN_EDITOR_ID, BlockOpenSignEditor.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_PLAYER_INFO_ID, PlayerListSetEntry.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_ABILITIES_ID, PlayerAbilities.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_TAB_COMPLETE_ID, TabComplete.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_SCOREBOARD_OBJECTIVE_ID, ScoreboardObjective.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_SCOREBOARD_SCORE_ID, ScoreboardScore.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_SCOREBOARD_DISPLAY_SLOT_ID, ScoreboardDisplay.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_SCOREBOARD_TEAM_ID, ScoreboardTeam.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_CUSTOM_PAYLOAD_ID, CustomPayload.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_RESOURCE_PACK_ID, ResourcePack.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_KICK_DISCONNECT_ID, KickDisconnect.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_CAMERA_ID, Camera.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_PLAYER_LIST_HEADER_FOOTER_ID, PlayerListHeaderFooter.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_SET_PASSENGERS_ID, VehiclePassengers.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_TITLE_ID, Title.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_WORLD_BORDER_ID, WorldBorder.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_CHUNK_UNLOAD_ID, UnloadChunk.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_SERVER_DIFFICULTY_ID, ServerDifficulty.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_COMBAT_EVENT_ID, CombatEvent.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_SET_COOLDOWN_ID, SetCooldown.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_BOSS_BAR_ID, BossBar.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_VEHICLE_MOVE_ID, VehicleMove.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_ADVANCEMENTS, Advancements.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_ADVANCEMENTS_TAB, AdvancementsTab.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_UNLOCK_RECIPES, UnlockRecipes.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_CRAFT_RECIPE_CONFIRM, CraftRecipeConfirm.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_STATISTICS_ID, Statistics.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_DECLARE_COMMANDS, DeclareCommands.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_DECLARE_RECIPES, DeclareRecipes.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_DECLARE_TAGS, DeclareTags.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_QUERY_NBT_RESPONSE, QueryNBTResponse.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_STOP_SOUND, StopSound.class);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_LOOK_AT, LookAt.class);
	}

	public PacketEncoder(Connection connection, NetworkDataCache storage) {
		super(connection, storage);
	}

}