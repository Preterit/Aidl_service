package com.xiangxue.aidl_service;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Date:2019-10-21
 * author:lwb
 * Desc:
 */
public class Person implements Parcelable {

    private String name;
    private int grade;

    public Person(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }


    protected Person(Parcel in) {
        name = in.readString();
        grade = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(grade);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };
}
