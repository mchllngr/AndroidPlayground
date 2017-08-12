package de.mchllngr.androidplayground.module.savingData.data;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.HashMap;
import java.util.Map;

public class SavedInFragment implements Parcelable {

    public String savedInFragmentString = "default";

    public HashMap<String, String> savedInFragmentHashMap = new HashMap<>();

    public SavedInFragment() {
    }

    protected SavedInFragment(Parcel in) {
        savedInFragmentString = in.readString();

        int size = in.readInt();
        for (int i = 0; i < size; i++) {
            String key = in.readString();
            String value = in.readString();
            savedInFragmentHashMap.put(key, value);
        }
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(savedInFragmentString);

        dest.writeInt(savedInFragmentHashMap.size());
        for (Map.Entry<String, String> entry : savedInFragmentHashMap.entrySet()) {
            dest.writeString(entry.getKey());
            dest.writeString(entry.getValue());
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<SavedInFragment> CREATOR = new Creator<SavedInFragment>() {
        @Override
        public SavedInFragment createFromParcel(Parcel in) {
            return new SavedInFragment(in);
        }

        @Override
        public SavedInFragment[] newArray(int size) {
            return new SavedInFragment[size];
        }
    };
}
