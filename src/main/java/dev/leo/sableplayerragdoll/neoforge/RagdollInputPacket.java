package dev.leo.activeragdolls.neoforge;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

public record RagdollInputPacket(boolean isPressed) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<RagdollInputPacket> TYPE = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath("activeragdolls", "input"));
    public static final StreamCodec<FriendlyByteBuf, RagdollInputPacket> STREAM_CODEC = CustomPacketPayload.codec(RagdollInputPacket::write, RagdollInputPacket::new);

    public RagdollInputPacket(FriendlyByteBuf buf) {
        this(buf.readBoolean());
    }

    public void write(FriendlyByteBuf buf) {
        buf.writeBoolean(this.isPressed);
    }

    @Override
    public CustomPacketPayload.Type<RagdollInputPacket> type() {
        return TYPE;
    }
}