package breon.telematics.loneworkersafetyapp.android.utils

import android.content.Context

class PrefManager(context: Context) {
    private val pref = context.getSharedPreferences("breon_app_pref", Context.MODE_PRIVATE)
    private val editor = pref.edit()

    fun putBoolean(key: String, value: Boolean) {
        editor.putBoolean(key, value).commit()
    }

    fun getBoolean(key: String): Boolean {
        return pref.getBoolean(key, false)
    }

    fun putString(key: String, value: String) {
        editor.putString(key, value).commit()
    }

    fun getString(key: String): String {
        return pref.getString(key, "") ?: ""
    }

    fun putInt(key: String, value: Int) {
        editor.putInt(key, value).commit()
    }

    fun getInt(key: String): Int {
        return pref.getInt(key, 0)
    }

    fun putLong(key: String, value: Long) {
        editor.putLong(key, value).commit()
    }

    fun getLong(key: String): Long {
        return pref.getLong(key, 0)
    }

    fun clearPreference() {
        editor.clear().commit()
    }
}