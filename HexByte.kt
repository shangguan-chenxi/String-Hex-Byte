import java.lang.Byte


    /**
      String? 转 ByteArray：
      data?.toByteArray(charset("utf-8")) // data为String?类型
    
      ByteArray 转 String
      String(data, charset("UTF-8")) // data为ByteArray类型
    */
    
    /**
     * byte数组转hex
     * @param bytes
     * @return
     */
    private val hexArray = "0123456789ABCDEF".toCharArray()
    /*
    private fun byteToHex(bytes: ByteArray): String {
        val hexChars = CharArray(bytes.size * 2)
        for (j in bytes.indices) {
            val v = bytes[j].toInt() and 0xFF
            hexChars[j * 2] = hexArray[v ushr 4]
            hexChars[j * 2 + 1] = hexArray[v and 0x0F]
        }
        return String(hexChars)
    }
     */
    private fun byteToHex(bytes: ByteArray?): String? {
        val hexChars = CharArray(bytes!!.size * 2)
        for (j in bytes.indices) {
            val v = bytes[j].toInt() and 0xFF
            hexChars[j * 2] = hexArray[v ushr 4]
            hexChars[j * 2 + 1] = hexArray[v and 0x0F]
        }
        return String(hexChars)
    }

    /**
     * hex转byte数组
     * @param hex
     * @return
     */
    private fun hexToByte(hex: String?): ByteArray? {
        var m = 0
        var n = 0
        val byteLen = hex!!.length / 2 // 每两个字符描述一个字节
        val ret = ByteArray(byteLen)
        for (i in 0 until byteLen) {
            m = i * 2 + 1
            n = m + 1
            val intVal = Integer.decode("0x" + hex.substring(i * 2, m) + hex.substring(m, n))
            ret[i] = Byte.valueOf(intVal.toByte())
        }
        return ret
    }
