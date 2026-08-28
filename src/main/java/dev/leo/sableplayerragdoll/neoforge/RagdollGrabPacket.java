package dev.leo.sableplayerragdoll.neoforge;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

public record RagdollGrabPacket(int targetEntityId) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<RagdollGrabPacket> TYPE = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath("sableplayerragdoll", "grab"));
    public static final StreamCodec<FriendlyByteBuf, RagdollGrabPacket> STREAM_CODEC = CustomPacketPayload.codec(RagdollGrabPacket::write, RagdollGrabPacket::new);

    public RagdollGrabPacket(FriendlyByteBuf buf) {
        this(buf.readInt());
    }

    public void write(FriendlyByteBuf buf) {
        buf.writeInt(this.targetEntityId);
    }

    @Override
    public CustomPacketPayload.Type<RagdollGrabPacket> type() {
        return TYPE;
    }
}