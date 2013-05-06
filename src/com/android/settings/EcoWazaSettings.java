package com.android.settings;

import android.os.Bundle;
import android.os.SystemProperties;
import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceScreen;

public class EcoWazaSettings extends PreferenceFragment {

    private static final String ECO_ENABLE_PROPERTY = "persist.sys.eco.enable";
    private static final String ECO_SELECT = "eco_select";
    private CheckBoxPreference mEcoEnable;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        addPreferencesFromResource(R.xml.eco_settings);
        mEcoEnable = (CheckBoxPreference)findPreference(ECO_SELECT);
    }

    private void writeEcoEnableOptions() {
        SystemProperties.set(ECO_ENABLE_PROPERTY, mEcoEnable.isChecked() ? "true" : "false");
    }

    @Override
    public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
        if (preference == mEcoEnable) {
            writeEcoEnableOptions();
        }
        return true;
    }   
}

