package breon.telematics.loneworkersafetyapp.android.data

import android.util.Log
import java.io.ByteArrayOutputStream
import java.net.HttpURLConnection
import java.net.URL

object GetUserTemplates {

    fun getJSONString(url: String?, base64: String): String? {
        var jsonString: String? = null
        var con: HttpURLConnection? = null
        try {
            val obj = URL(url)
            con = obj.openConnection() as HttpURLConnection
            con.requestMethod = "GET"
            val responseCode = con.responseCode
            if (responseCode == HttpURLConnection.HTTP_OK) {
                val linkinStream = con.inputStream
                val baos = ByteArrayOutputStream()
                var j = 0
                while (linkinStream.read().also { j = it } != -1) {
                    baos.write(j)
                }
                val data = baos.toByteArray()
                jsonString = String(data)
            }

            Log.i("SplashResponse", "getJSONString: " + jsonString)
        } catch (e: Exception) {
            e.printStackTrace()
            Log.i("SplashResponse", "errorString: " + e.message)
        } finally {
            con?.disconnect()
        }
        return jsonString
    }

   suspend fun getJSONString(url: String?): String? {
        var jsonString: String? = null
        var linkConnection: HttpURLConnection? = null
        try {
            val linkurl = URL(url)
            linkConnection = linkurl.openConnection() as HttpURLConnection
            val responseCode = linkConnection.responseCode
            if (responseCode == HttpURLConnection.HTTP_OK) {
                val linkinStream = linkConnection!!.inputStream
                val baos = ByteArrayOutputStream()
                var j = 0
                while (linkinStream.read().also { j = it } != -1) {
                    baos.write(j)
                }
                val data = baos.toByteArray()
                jsonString = String(data)
            }
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        } finally {
            linkConnection?.disconnect()
        }
        return jsonString
    }
}