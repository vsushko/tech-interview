package miscellaneous;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/**
 * Determine the host byte order (endianness).
 * <p>
 * Runtime Complexity: Constant, O(1).
 * Memory Complexity: Constant, O(1).
 */
public class HostEndianness {

    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(20);
        int capacity = byteBuffer.capacity(); // 10
        System.out.println(capacity);

        byteBuffer.order(hostByteOrder());

        byteBuffer.put("vsushko.github.com".getBytes());

        System.out.println(Arrays.toString(byteBuffer.array()));
    }

    public static ByteOrder hostByteOrder() {
        return ByteOrder.nativeOrder();
    }
}
