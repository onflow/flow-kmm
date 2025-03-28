import com.google.common.io.BaseEncoding
import com.google.protobuf.Timestamp
import java.security.MessageDigest
import java.time.LocalDateTime
import java.time.ZoneOffset

fun ByteArray.bytesToHex(): String = BaseEncoding.base16().lowerCase().encode(this)

fun String.hexToBytes(): ByteArray = BaseEncoding.base16().lowerCase().decode(
    if (this.lowercase().startsWith("0x")) {
        this.substring(2)
    } else {
        this
    }
)