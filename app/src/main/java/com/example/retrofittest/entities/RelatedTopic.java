
package com.example.retrofittest.entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RelatedTopic implements Parcelable {

    @SerializedName("Result")
    @Expose
    private String Result;
    @SerializedName("Icon")
    @Expose
    private Icon Icon;
    @SerializedName("FirstURL")
    @Expose
    private String FirstURL;
    @SerializedName("Text")
    @Expose
    private String Text;

    /**
     * @return The Result
     */
    public String getResult() {
        return Result;
    }

    /**
     * @param Result The Result
     */
    public void setResult(String Result) {
        this.Result = Result;
    }

    /**
     * @return The Icon
     */
    public Icon getIcon() {
        return Icon;
    }

    /**
     * @param Icon The Icon
     */
    public void setIcon(Icon Icon) {
        this.Icon = Icon;
    }

    /**
     * @return The FirstURL
     */
    public String getFirstURL() {
        return FirstURL;
    }

    /**
     * @param FirstURL The FirstURL
     */
    public void setFirstURL(String FirstURL) {
        this.FirstURL = FirstURL;
    }

    /**
     * @return The Text
     */
    public String getText() {
        return Text;
    }

    /**
     * @param Text The Text
     */
    public void setText(String Text) {
        this.Text = Text;
    }


    protected RelatedTopic(Parcel in) {
        Result = in.readString();
        Icon = (Icon) in.readValue(Icon.class.getClassLoader());
        FirstURL = in.readString();
        Text = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Result);
        dest.writeValue(Icon);
        dest.writeString(FirstURL);
        dest.writeString(Text);
    }

    @SuppressWarnings("unused")
    public static final Creator<RelatedTopic> CREATOR = new Creator<RelatedTopic>() {
        @Override
        public RelatedTopic createFromParcel(Parcel in) {
            return new RelatedTopic(in);
        }

        @Override
        public RelatedTopic[] newArray(int size) {
            return new RelatedTopic[size];
        }
    };

    @Override
    public String toString() {
        return "RelatedTopic{" +
                "Result='" + Result + '\'' +
                ", Icon=" + Icon +
                ", FirstURL='" + FirstURL + '\'' +
                ", Text='" + Text + '\'' +
                '}';
    }
}