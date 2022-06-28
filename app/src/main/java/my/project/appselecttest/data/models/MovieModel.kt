package my.project.appselecttest.data.models


import com.google.gson.annotations.SerializedName

data class MovieModel(
    @SerializedName("display_title")
    val displayTitle: String?,
    @SerializedName("multimedia")
    val multimedia: MultimediaModel?,
    @SerializedName("summary_short")
    val summaryShort: String?,
)