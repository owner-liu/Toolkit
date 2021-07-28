package com.lyw.file

import android.content.Context
import android.content.res.AssetFileDescriptor
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException

/**
 * Created on  2021/7/28
 * Created by  lyw
 * Created for assets helper~
 */
object AssetsHelper {

    /**
     * copy asset resource to target file path~
     */
    @Throws(IOException::class)
    fun copyAssets(context: Context, assetsName: String, path: String) {
        val assetFileDescriptor: AssetFileDescriptor = context.assets.openFd(assetsName)
        val from = FileInputStream(assetFileDescriptor.fileDescriptor).channel
        val to = FileOutputStream(path).channel
        from.transferTo(assetFileDescriptor.startOffset, assetFileDescriptor.length, to)
    }
}