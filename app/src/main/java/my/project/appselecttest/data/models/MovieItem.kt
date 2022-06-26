package my.project.appselecttest.data.models


import com.google.gson.annotations.SerializedName

data class MovieItem(
    @SerializedName("display_title")
    val displayTitle: String?,
    @SerializedName("multimedia")
    val multimedia: Multimedia?,
    @SerializedName("summary_short")
    val summaryShort: String?
)