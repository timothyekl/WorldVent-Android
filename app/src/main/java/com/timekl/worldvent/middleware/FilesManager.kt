package com.timekl.worldvent.middleware

import com.timekl.worldvent.WorldVentApp
import java.io.*
import java.util.zip.ZipEntry
import java.util.zip.ZipInputStream


object FilesManager {

    fun copyAsset(name: String, destination: String) {
        val bufferSize = 1024
        val assetManager = WorldVentApp.instance.assets
        var inputStream: InputStream? = null
        var outputStream: OutputStream? = null

        try {
            inputStream = assetManager.open(name)
            outputStream = FileOutputStream(File(destination))
            inputStream.copyTo(outputStream, bufferSize)
        } catch (e: FileNotFoundException) {

        } finally {
            inputStream?.close()
            outputStream?.flush()
            outputStream?.close()
        }
    }

    private fun unpackZip(path: String, zipname: String): Boolean {
        val `is`: InputStream
        val zis: ZipInputStream
        var filename: String
        `is` = FileInputStream(path + zipname)
        zis = ZipInputStream(BufferedInputStream(`is`))
        var zipEntry: ZipEntry?
        val buffer = ByteArray(1024)
        var count: Int
        while (zis.nextEntry.also { zipEntry = it } != null) {
            val ze = zipEntry ?: continue
            filename = ze.name

            // Need to create directories if not exists, or
            // it will generate an Exception...
            if (ze.isDirectory) {
                val fmd = File(path + filename)
                fmd.mkdirs()
                continue
            }
            try {
                val fout = FileOutputStream(path + filename)
                while (zis.read(buffer).also { count = it } != -1) {
                    fout.write(buffer, 0, count)
                }
                fout.close()
                zis.closeEntry()
            } catch (e: FileNotFoundException) {

            }
        }
        zis.close()

        return true
    }
}

