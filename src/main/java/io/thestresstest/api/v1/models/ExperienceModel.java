package io.thestresstest.api.v1.models;

import com.google.gson.annotations.SerializedName;

public class ExperienceModel {

    @SerializedName("total_experience")
    public float totalExperience;

    @SerializedName("percent_to_next_level")
    public float percentToNextLevel;

    @SerializedName("level")
    public int level;

    public ExperienceModel(float totalExp, float exp, int lvl) {
        totalExperience = totalExp;
        percentToNextLevel = exp;
        level = lvl;
    }
}
