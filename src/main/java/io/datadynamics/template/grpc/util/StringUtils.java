package io.datadynamics.template.grpc.util;

import io.grpc.netty.shaded.io.netty.buffer.ByteBuf;
import io.grpc.netty.shaded.io.netty.buffer.ByteBufUtil;
import io.grpc.netty.shaded.io.netty.buffer.Unpooled;

public class StringUtils {

    public static String toHex(String message) {
        return toHex(message.getBytes());
    }

    public static String toHex(byte[] bytes) {
        ByteBuf buf = Unpooled.wrappedBuffer(bytes);
        return ByteBufUtil.prettyHexDump(buf);
    }

}
