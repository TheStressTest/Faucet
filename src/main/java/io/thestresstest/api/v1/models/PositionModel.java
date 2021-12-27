package io.thestresstest.api.v1.models;

import com.google.gson.annotations.SerializedName;

public class PositionModel {

    @SerializedName("x")
    public double X;

    @SerializedName("y")
    public double Y;

    @SerializedName("z")
    public double Z;

    public PositionModel(double x, double y, double z) {
        X = x;
        Y = y;
        Z = z;
    }
}