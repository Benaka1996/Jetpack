package com.benaka.jetpack.data.manager

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.benaka.jetpack.domain.manager.LocalUserManager
import com.benaka.jetpack.utils.Constant
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocalUserManagerImpl(private val context: Context) : LocalUserManager {
    override suspend fun saveAppEntry() {
        context.datastore.edit { preferences ->
            preferences[PreferenceKey.applicationEntry] = true
        }
    }

    override fun readAppEntry(): Flow<Boolean> {
        return context.datastore.data.map { preferences ->
            preferences[PreferenceKey.applicationEntry] ?: false
        }
    }
}

private val Context.datastore by preferencesDataStore(name = Constant.USER_SETTING)

private object PreferenceKey {
    val applicationEntry = booleanPreferencesKey(name = Constant.APP_ENTRY)
}

