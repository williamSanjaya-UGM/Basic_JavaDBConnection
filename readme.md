SerializationTest, consist of serialize and deserialize POJO and write it into file; Vice versa, by using Serializable marker interface.
WriteFilebuffer method inside SerializationTest, used for writing POJO into a file by using buffer.

Tips: String.valueOf() can be used to turn ASCII into integer value, ex: change SOH into 1, or STX into 2

FileOutputStream and ObjectOutputStream will write file in stream mode, the written file will be in binary format

FileWriter and BufferedWriter will write file in byte text format
