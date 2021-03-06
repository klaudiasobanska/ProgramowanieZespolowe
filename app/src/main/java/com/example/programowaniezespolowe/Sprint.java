package com.example.programowaniezespolowe;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.*;

public class Sprint implements Parcelable {

    private GregorianCalendar mStartDate;
    private GregorianCalendar mEndDate;
    public ArrayList<Task> mTasksList;

    Sprint(){
        this.mStartDate= new GregorianCalendar();
        this.mEndDate = new GregorianCalendar();
        this.mTasksList = new ArrayList<Task>();
    }

    Sprint(GregorianCalendar startDate, GregorianCalendar endDate)
    {
        this.mStartDate = startDate;
        this.mEndDate = endDate;
        this.mTasksList = new ArrayList<Task>();
    }


    public GregorianCalendar getStartDate() {
        return mStartDate;
    }

    public void setStartDate(GregorianCalendar startDate) {
        mStartDate = startDate;
    }

    public GregorianCalendar getEndDate() {
        return mEndDate;
    }

    public void setEndDate(GregorianCalendar endDate) {
        mEndDate = endDate;
    }

    public ArrayList<Task> getTasksList() {return mTasksList;}

    public void setTasksList(ArrayList<Task> tasksList) {mTasksList = tasksList;}


    protected Sprint(Parcel in) {
        mStartDate = (GregorianCalendar) in.readValue(GregorianCalendar.class.getClassLoader());
        mEndDate = (GregorianCalendar) in.readValue(GregorianCalendar.class.getClassLoader());
        if (in.readByte() == 0x01) {
            mTasksList = new ArrayList<Task>();
            in.readList(mTasksList, Task.class.getClassLoader());
        } else {
            mTasksList = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(mStartDate);
        dest.writeValue(mEndDate);
        if (mTasksList == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(mTasksList);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Sprint> CREATOR = new Parcelable.Creator<Sprint>() {
        @Override
        public Sprint createFromParcel(Parcel in) {
            return new Sprint(in);
        }

        @Override
        public Sprint[] newArray(int size) {
            return new Sprint[size];
        }
    };


}

